package diningPhilosophers;

public class Philosopher extends Thread{
	int id;
	Object fork1, fork2;
	
	/* constructor */
	public Philosopher(int id, Object fork1, Object fork2) {
		this.id = id;
		this.fork1 = fork1;
		this.fork2 = fork2;
	}
	
	/* eat */
	public void run() {
		System.out.println("philosopher " + id + " wants to eat with forks " + fork1 + ", " + fork2);
		while (true) {
			/* try acquiring the left fork */
			System.out.println(id + " picking up fork " + fork1);
			synchronized(fork1) {
				/* try acquiring the right fork */
				System.out.println(id + " picking up fork " + fork2);
				synchronized(fork2) {
					/* eat with both forks */
					System.out.println("Philosopher " + id + " eats.");
				}
			}
		}
	}
}
