package model;

public class Movie implements IMovie {

	private String name, author;
	private int duration, id;
	private static int nextId = 0;

	public Movie(String name, String author, int duration) {
		id = nextId++;
		this.name = name;
		this.author = author;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", author=" + author + ", duration=" + duration + ", id=" + id + "]";
	}

}
