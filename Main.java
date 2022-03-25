import javax.swing.JFrame;

import view.BaseballGamePanel;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(400, 30);
		var baseball = new BaseballGamePanel(window);
		baseball.init();
		window.pack();
		window.setVisible(true);
	}
}