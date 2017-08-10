package producerConsumer;

public class Main {
	public static void main(String[] args) {
		/* create a buffer with maximum 8 elements */
		IntBuffer buf = new IntBuffer(8);
		/* create  consumer and producer and assign the buffer to both */
		Consumer c = new Consumer(buf);
		Producer p = new Producer(buf);

		/* start work for both producer and consumer */
		p.start();
		c.start();
	}
}
