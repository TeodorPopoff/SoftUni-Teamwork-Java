package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Player extends JPanel {
	private Image image = Toolkit.getDefaultToolkit().createImage("res/penguin.png");
	int x = 0;
	int y = 0;
	int width = 50;
	int height = 50;
	boolean collision = false;

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, width, height, null);
	}

	public boolean detectCollision(Enemy enemy) {
		for (int enemyY = 0; enemyY <= enemy.getRandHeight(); enemyY++) {
			for (int enemyX = 0; enemyX <= enemy.getRandWidth(); enemyX++) {
				if (((enemy.getX() + enemyX) - (x + width / 2))
						* ((enemy.getX() + enemyX) - (x + width / 2))
						+ ((enemy.getY() + enemyY) - (y + height / 2))
						* ((enemy.getY() + enemyY) - (y + height / 2)) <= (width
						/ 2 * width / 2)) {
					collision = true;
				}
			}
		}
		return collision;
	}
}
