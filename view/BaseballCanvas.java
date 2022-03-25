package view;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class BaseballCanvas extends JPanel {
	public static int  WIDTH = 500;
	public static int  HEIGHT = 500;
	private int balls = 0;
	private int strikes = 0;
	
	private BaseballGamePanel panel;

	public BaseballCanvas(BaseballGamePanel panel) {
		this.panel = panel;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics g2 = (Graphics2D) g;

		BaseballGamePanel.GameState state = panel.getGameState();
		if(state == BaseballGamePanel.GameState.READY) {
			g2.setColor(Color.yellow);
			g2.setFont(new Font("Courier New", Font.BOLD, 30));
			g2.drawString("Click <Play> to start", 70, 150);
		} else {
			if(state == BaseballGamePanel.GameState.GAMEOVER) {
				g2.setColor(Color.red);
				g2.setFont(new Font("Courier New", Font.BOLD, 30));
				g2.drawString("Game Over", 150, 160);
			}
			g2.setColor(Color.yellow);
			g2.setFont(new Font("Courier New", Font.BOLD, 14));
			g2.drawString("Balls: " + balls, 20, 100);
			for(int i = 0; i < 3; i++) {
				if(i < balls) {
					g2.fillOval(i * 140 + 120, 80, 50, 50);
				} else {
					g2.drawOval(i * 140 + 120, 80, 50, 50);
				}
			}

			g2.drawString("Strikes: " + strikes, 20, 200);
			for(int i = 0; i < 3; i++) {
				if(i < strikes) {
					g2.fillOval(i * 140 + 120, 180, 50, 50);
				}
				else {
					g2.drawOval(i * 140 + 120, 180, 50, 50);
				}
			}
		}
	}

	public void setBallStrikeCount(int balls, int strikes) {
		this.balls = balls;
		this.strikes = strikes;
	}
}
