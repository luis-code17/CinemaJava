package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa una sessió d'un cinema que inclou informació sobre la pel·lícula,
 * la sala i les seves seients.
 * 
 * @author luis
 * @version 1.0
 * @since 2024-04-10
 */
public class Session implements ISession {

	private int id;
	private static int nextid;
	private Date newDate;
	private IMovie movie;
	private ITheater theater;
	private List<ISeat> seats;

	/**
	 * Constructor que inicialitza una nova sessió amb la pel·lícula, la sala i la
	 * data donades.
	 * 
	 * @param movie   La pel·lícula de la sessió.
	 * @param theater La sala de la sessió.
	 * @param newDate La data de la sessió.
	 */
	public Session(IMovie movie, ITheater theater, Date newDate) {
		this.movie = movie;
		this.theater = theater;
		this.newDate = newDate;
		this.seats = new ArrayList<ISeat>();
		for (int i = 0; i < theater.getCapacity(); i++) {
			seats.add(new Seat(i));
		}
		nextid++;
		id = nextid;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Date getDate() {
		return newDate;
	}

	@Override
	public void setDate(Date newDate) {
		this.newDate = newDate;
	}

	@Override
	public void book(int seatNumber) throws SeatAlreadyBookedException {
		if (seatNumber < 1 || seatNumber > seats.size()) {
			throw new SeatAlreadyBookedException("Seat number is invalid");
		}
		ISeat seat = seats.get(seatNumber);
		seat.book();
	}

	@Override
	public String toString() {
		return "Session " + id + " on theater " + theater.getId() + " with movie(" + movie.getId() + ") "
				+ movie.getName() + ", " + newDate + ". Seats: " + seats;
	}

}
