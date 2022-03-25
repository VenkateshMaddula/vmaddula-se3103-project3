package designpattern;

import java.util.ArrayList;

public class ConcreteSubject implements Subject{
	
	private ArrayList<Observer> observers;
	
	public ConcreteSubject() {
		observers = new ArrayList<>();
	}

	@Override
	public void attachActionListener(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void detachActionListener(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyActionListener(int g1, int g2, int g3) {
		for(var ob: observers) {
			ob.actionPerformed(g1, g2, g3);
		}
		
	}

}
