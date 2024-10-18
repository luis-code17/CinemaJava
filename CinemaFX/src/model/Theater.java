package model;

public class Theater implements ITheater {

	private static int next_id = 0;
	private int id;
	private int capacity;
	
	public Theater(int capacity) {
		id = next_id++;
		this.capacity = capacity;
	}
	
	public Theater(int id, int capacity){
		this.capacity = capacity;
		this.id = id;

	}

	@Override
	public String toString() {
		return "Theater [id=" + id + ", capacity=" + capacity + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}	

}
