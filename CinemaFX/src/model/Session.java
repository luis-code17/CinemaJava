package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Session implements ISession {

	private static int nextId = 0;
	private int id;
	private ITheater theater;
	private IMovie movie;
	private Date date;
	private List<ISeat> seats;

	public Session(ITheater theater, IMovie movie, Date date) {
		id = nextId++;
		this.theater = theater;
		this.movie = movie;
		this.date = date;
		this.seats = new ArrayList<ISeat>();
		 for (int i = 1; i <= theater.getCapacity(); i++) {
	            seats.add(new Seat());
	        }
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id=id;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", theater=" + theater + ", movie=" + movie + ", date=" + date + ", seats=" + seats
				+ "]";
	}
	

	

	@Override
	public void book(int seatNumber) throws SeatAlreadyBookedException {
		seats.get(seatNumber).book();
	}	

}
