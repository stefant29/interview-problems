package diningPhilosophers;

public class Main {

	public static void main(String[] args) {
		/* create a table for 5 philosophers */
		TableForPhilosophers d = new TableForPhilosophers(5);
		/* start eating */
		d.startEating();
	}

}
