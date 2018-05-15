package producerConsumer;

public class Consumer extends Thread {
	IntBuffer buffer;
	
	/* constructor: assign the shared buffer */
	public Consumer(IntBuffer buf) {
		this.buffer = buf;
	}
	
	@Override
	public void run() {
		while(true) {
			/* consume an element from the buffer */
			System.out.println("consumer took: " + buffer.consume());
		}
	}
}
