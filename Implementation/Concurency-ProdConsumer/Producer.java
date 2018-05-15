package producerConsumer;

import java.util.Random;

public class Producer extends Thread {
	IntBuffer buffer;
	
	/* constructor: assign the shared buffer */
	public Producer(IntBuffer buf) {
		this.buffer = buf;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while(true) {
			/* produce a random number */
			int num = r.nextInt();
			/* put it in the buffer */
			buffer.produce(num);
			System.out.println("producer produced: " + num);
		}
	}
}

