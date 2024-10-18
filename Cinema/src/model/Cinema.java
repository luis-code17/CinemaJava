package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Representa un cinema que gestiona les sales, les pel·lícules i les sessions.
 * 
 * @author luis
 * @version 1.0
 * @since 2024-04-10
 */
public class Cinema implements ICinema, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private List<ITheater> listTheater;
	private List<IMovie> listMovie;
	private List<ISession> listSession;

	/**
	 * Constructor per defecte que inicialitza les llistes de sales, pel·lícules i
	 * sessions.
	 */
	public Cinema() {
		id++;
		this.listTheater = new ArrayList<ITheater>();
		this.listSession = new ArrayList<ISession>();
		this.listMovie = new ArrayList<IMovie>();
	}

	@Override
	public ITheater[] getTheaters() {
		return listTheater.toArray(new ITheater[listTheater.size()]);
	}

	@Override
	public void addTheater(int capacity) {
		Theater theater = new Theater(capacity);
		listTheater.add(theater);

	}

	@Override
	public void deleteTheater(int id) throws NoSuchElementException {
		for (ITheater theater : listTheater) {
			if (theater.getId() == id) {
				listTheater.remove(theater);
				return;
			}
		}
		throw new NoSuchElementException("Theater with id " + id + " is not found.");
	}

	@Override
	public void updateTheater(int id, int newCapacity) throws NoSuchElementException {
		for (ITheater theater : listTheater) {
			if (theater.getId() == id) {
				theater.setCapacity(newCapacity);
				return;
			}
		}
		throw new NoSuchElementException("Theater with id " + id + " is not found.");
	}

	@Override
	public IMovie[] getMovies() {
		return listMovie.toArray(new IMovie[listMovie.size()]);
	}

	@Override
	public void addMovie(String name, String author, int duration) {
		Movie movie = new Movie(name, author, duration);
		listMovie.add(movie);
	}

	@Override
	public void deleteMovie(int id) throws NoSuchElementException {
		for (IMovie movie : listMovie) {
			if (movie.getId() == id) {
				listMovie.remove(movie);
				return;
			}
		}
		throw new NoSuchElementException("Movie with id " + id + " is not found.");
	}

	@Override
	public void updateMovie(int id, String newName, String newAuthor, int newDuration) throws NoSuchElementException {
		for (IMovie movie : listMovie) {
			if (movie.getId() == id) {
				movie.setName(newName);
				movie.setAuthor(newAuthor);
				movie.setDuration(newDuration);
				return;
			}
		}
		throw new NoSuchElementException("Movie with id " + id + " is not found.");
	}

	@Override
	public ISession[] getSessions() {
		return listSession.toArray(new ISession[listSession.size()]);
	}

	@Override
	public void addSession(int idTheater, int idMovie, Date date) throws NoSuchElementException {
		IMovie movie = null;
		ITheater theater = null;
		for (ITheater t : listTheater) {
			if (t.getId() == idTheater) {
				theater = t;
			}
		}

		for (IMovie m : listMovie) {
			if (m.getId() == idMovie) {
				movie = m;
			}
		}

		if (theater == null || movie == null) {
			throw new NoSuchElementException();
		}

		Session session = new Session(movie, theater, date);
		listSession.add(session);
	}

	@Override
	public void deleteSession(int id) throws NoSuchElementException {
		for (ISession session : listSession) {
			if (session.getId() == id) {
				listSession.remove(session);
				return;
			}
		}
		throw new NoSuchElementException("Session with id " + id + " is not found.");
	}

	@Override
	public void updateSession(int id, Date newDate) throws NoSuchElementException {
		for (ISession session : listSession) {
			if (session.getId() == id) {
				session.setDate(newDate);
				return;
			}
		}
		throw new NoSuchElementException("Session with id " + id + " is not found.");
	}

	@Override
	public void bookSeat(int idSession, int seatNumber) throws SeatAlreadyBookedException {
		for (ISession session : listSession) {
			if (session.getId() == idSession) {
				session.book(seatNumber);
				return;
			}
		}
		throw new SeatAlreadyBookedException("Session with id " + id + " is not found.");
	}
}
