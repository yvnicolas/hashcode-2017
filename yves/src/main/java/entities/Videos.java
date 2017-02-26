package entities;

public class Videos {
	
	int size;
	int index;

	public int getSize() {
		return size;
	}
	
	

	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	public void setSize(int size) {
		this.size = size;
	}

	public Videos(int size, int index) {
		super();
		this.size = size;
		this.index = index;
	}
	

}
