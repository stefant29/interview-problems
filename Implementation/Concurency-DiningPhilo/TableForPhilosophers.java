package diningPhilosophers;

public class TableForPhilosophers {
	Philosopher[] philosophers;
	Object[] forks;

	/* constructor */
	public TableForPhilosophers(int no) {
		/* allocate space for the arrays */
		philosophers = new Philosopher[no];
		forks = new Object[no];
		for (int i = 0; i < no; i++) {
			/* initialize the forks */
			forks[i] = new Object();
			/* 
			 * just for the first philosopher, switch the order of forks to avoid deadlock:
			 * first philosopher will take first the right fork (fork2), then the left one (fork1)
			 * while the rest of the philosophers take the left fork (fork1) first and then the right one (fork2) 
			 */
			if (i == 0)
				philosophers[i] = new Philosopher(i, (i+1)%no, i);
			else
				philosophers[i] = new Philosopher(i, i, (i+1)%no);
		}
	}
	
	public void startEating() {
		/* start eating */
		for (int i = 0; i < philosophers.length; i++)
			philosophers[i].start();
	}
}
