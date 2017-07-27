package LinkedLists;

public class Element<T> {
		private T data;
		private Element<T> next;
		
		public Element() {
			next = null;
		}
		
		public Element(T data) {
			this.data = data;
			this.next = null;
		}
		
		public Element(T data, Element<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return data;
		}
		
		public Element<T> getNext() {
			return next;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public void setNext(Element<T> next) {
			this.next = next;
		}
		
		public boolean hasNext() {
			return next!=null;
		}

		
	}