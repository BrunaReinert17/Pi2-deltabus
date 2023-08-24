package utilidades;

import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Shape;



public class RoundButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Shape shape;

	public RoundButton(String label) {
		super(label);
		setOpaque(false);
	}

	public RoundButton(int i) {
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		}
		return shape.contains(x, y);
	}

}
