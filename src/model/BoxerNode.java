package model;

public class BoxerNode<T>{
	
	private T date;
	
	private BoxerNode<T> next;
	
	public BoxerNode(T date) {
		this.date = date;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}
	

	public BoxerNode<T> getNext() {
		return next;
	}
	
	public boolean searchANodeAndModify(T item, T newItem) {
		
		if(date.equals(item)) {
			setDate(newItem);
			return true;
		}
		
		else if(next == null) {
			return false;
		}
		else {
			return next.searchANodeAndModify(item,newItem);
		}
	}
	
	public void addNext(T value) {
		if(next == null) {
			BoxerNode<T> aux = new BoxerNode<T>(value);
			next = aux;
		}
		else {
			next.addNext(value);
		}
	}
	
	public String toString(int numColumns,int i) {
		String out = date+"";
		
		if(next != null) {
			if(i == numColumns) {
				out += "]";
				out += "\n";
				out += "["+next.toString(numColumns,1);
			}
			else {
				out += "]"+"["+next.toString(numColumns,i+1);
			}
			
		}
		
		return out;
	}

	public void setNext(BoxerNode<T> next) {
		this.next = next;
	}
	
}
