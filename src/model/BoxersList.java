package model;

public class BoxersList<T> {
	
	@SuppressWarnings({ })
	private BoxerNode<T> first;
	
	private int count;

	public BoxersList() {
		count = 1;
	}
	
	public void add(T value) {
		if(first == null) {
			first = new BoxerNode<T>(value);
		}
		else {
			first.addNext(value);
		}
	}
	
	public boolean toLookForAnElementAndModify(T value, T newItem) {
		if(first == null) {
			return false;
		}
		else {
			return first.searchANodeAndModify(value,newItem);
		}
	}
	
	
	public BoxerNode<T> getFirst() {
		return first;
	}

	public void setFirst(BoxerNode<T> first) {
		this.first = first;
	}
	

	public void setCount(int count) {
		this.count = count;
	}

	public String toShowList(int numColumns) {
		if(first == null) {
			return "[]";
		}
		else {
			return "["+first.toString(numColumns,1)+"]";
		}
		
	}
}
