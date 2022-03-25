package designpattern;

public interface Subject {
	
	void attachActionListener(Observer o);
	void detachActionListener(Observer o);
	void notifyActionListener(int g1, int g2, int g3);

}
