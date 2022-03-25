package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import designpattern.ConcreteObserver;
import designpattern.ConcreteSubject;
import model.BaseballGame;
import view.BaseballGamePanel;

public class BaseballKeyListener implements ActionListener{
	private BaseballGamePanel panel;
	private int clicks = 0;
	private int g1, g2, g3;
	
	//Observer pattern objects
	private ConcreteObserver observer;
	private ConcreteSubject subject;

	public BaseballKeyListener(BaseballGamePanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button == panel.getPlayButton()) {
			var baseball = new BaseballGame();
			panel.setBaseBall(baseball);
			panel.setGameState(BaseballGamePanel.GameState.PLAYING);
			int[] keys = baseball.getKey();
			String keyString = "" + keys[0] + keys[1] + keys[2];
			panel.getGameKeyField().setText(keyString);
			panel.getGuessField().setText("");
			for(var b: panel.getDigitButtons()) {
				b.setEnabled(true);
			}
			panel.getCanvas().setBallStrikeCount(0, 0);
			panel.getCanvas().repaint();
			
			//Initialize observer pattern objects
			observer = new ConcreteObserver(baseball);
			subject = new ConcreteSubject();
			
			subject.attachActionListener(observer);
			
		} else if (button == panel.getExitButton()) {
			int option =  JOptionPane.showConfirmDialog(
				    panel.getCanvas(),
				    "Are you sure you want to exit the game?",
				    "Exit game",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE);
			if(option == 0) System.exit(0);
		} else {
			button.setEnabled(false);
			JTextField guessField = panel.getGuessField();
			
			if(clicks == 0) guessField.setText("");
			BaseballGame baseball = panel.getBaseball();
			String n = button.getText();
			guessField.setText(guessField.getText() + n);
			clicks++;
			
			//Get guess values
			switch(clicks) {
			case 1:
				g1 = n.charAt(0) - '0';
				break;
			case 2:
				g2 = n.charAt(0) - '0';
				break;
			case 3:
				g3 = n.charAt(0) - '0';
				break;
			}

			if(clicks == 3) {
				//Notify concrete observer object
				subject.notifyActionListener(g1, g2, g3);
				baseball.computeBallsStrikes();
				int balls = baseball.getBallCount();
				int strikes = baseball.getStrikeCount();
				panel.getCanvas().setBallStrikeCount(balls, strikes);
				if(strikes == 3) {
					panel.setGameState(BaseballGamePanel.GameState.GAMEOVER);
					for(var b: panel.getDigitButtons()) {
						b.setEnabled(false);
					}
				} else {
					for(var b: panel.getDigitButtons()) {
						b.setEnabled(true);
					}
				}
				clicks = 0;
				panel.getCanvas().repaint();
			}
		}
	}
	
}