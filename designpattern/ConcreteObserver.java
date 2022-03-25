package designpattern;

import model.BaseballGame;

public class ConcreteObserver implements Observer{
	
	private BaseballGame baseBall;
	
	public ConcreteObserver(BaseballGame baseBall) {
		this.baseBall = baseBall;
	}

	@Override
	public void actionPerformed(int g1, int g2, int g3) {
		baseBall.setGuess(0, g1);
		baseBall.setGuess(1, g2);
		baseBall.setGuess(2, g3);
		
	}

}
