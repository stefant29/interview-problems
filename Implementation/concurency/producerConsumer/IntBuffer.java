package producerConsumer;

public class IntBuffer {
	int index = 0;
	int[] buffer;
	
	/* initialize the buffer with a given size */
	public IntBuffer (int size) {
		buffer = new int[size];
	}
	
	/* produce into buffer: get a value and add it to the buffer */
	public synchronized void produce(int value) {
		/* while the buffer is full, wait */ 
		while (index == buffer.length-1) {
			try {
				wait();
			} catch (Exception e) {
				System.err.println("exception in wait add");
			}
		}
		/* when there is space in buffer, put the value in the buffer */
		buffer[index++] = value;
		/* then notify all other threads that were waiting for the element */
		notifyAll();
	}
	
	/* consume from buffer: remove and return the last value from the buffer */
	public synchronized int consume() {
		/* if the buffer is empty, wait */
		while (index == 0) {
			try {
				wait();
			} catch (Exception e) {
				System.err.println("exception in wait remove");
			}
		}
		/* the buffer has at least one element, remove and return the last element */
		int val = buffer[--index];
		/* notify all threads waiting */
		notifyAll();
		return val;
	}
}
