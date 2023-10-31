package utilidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RoundedPanel extends JPanel  {
	private int cornerRadius = 90; // Raio dos cantos (ajuste conforme necessário)

    public RoundedPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics2D = (Graphics2D) g.create();

        RoundRectangle2D roundRect = new RoundRectangle2D.Float(1, 1, width, height, cornerRadius, cornerRadius);

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());
        graphics2D.fill(roundRect);
        graphics2D.setColor(getForeground());
        graphics2D.draw(roundRect);

        graphics2D.dispose();
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JPanel com Cantos Arredondados");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            RoundedPanel roundedPanel = new RoundedPanel();
            roundedPanel.setBackground(Color.BLUE);
            roundedPanel.setForeground(Color.WHITE);

            JLabel label = new JLabel("Painel com Cantos Arredondados");
            roundedPanel.add(label);

            frame.add(roundedPanel);
            frame.setVisible(true);
        });
    }
}
