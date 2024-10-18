package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class Cinema implements ICinema {
	private List<IMovie> movies;
	private List<ISession> sessions;
	private List<ITheater> theaters;

	public static int idNextTheater = 0;

	public Cinema() {
		this.movies = new ArrayList<IMovie>();
		this.sessions = new ArrayList<ISession>();
		this.theaters = new ArrayList<ITheater>();
	}

	@Override
	public List<ITheater> getTheaters() {
		return theaters;
	}

	@Override
	public List<IMovie> getMovies() {
		return movies;
	}

	@Override
	public List<ISession> getSessions() {
		return sessions;
	}

	@Override
	public void addTheater(int capacity) {
		ITheater theater = new Theater(capacity);
		theaters.add(theater);

	}

	@Override
	public void addMovie(String name, String author, int duration) {
		IMovie movie = new Movie(name, author, duration);
		movies.add(movie);
	}

	@Override
	public void addSession(int idTheater, int idMovie, Date date) throws NoSuchElementException {
		ITheater theater = getTheater(idTheater);
		IMovie movie = getMovie(idMovie);
		ISession session = new Session(theater, movie, date);
		sessions.add(session);
	}

	@Override
	public void deleteTheater(int id) throws NoSuchElementException {
		int before = theaters.size();
		theaters.removeIf(theater -> theater.getId() == id);
		if (before == theaters.size()) {
			throw new NoSuchElementException("Theater not found.");
		}

	}
	@Override
	public void deleteMovie(int id) throws NoSuchElementException {
		int before = movies.size();
		movies.removeIf(movie -> movie.getId() == id);
		if (before == movies.size()) {
			throw new NoSuchElementException("Movie not found.");
		}
	}
	@Override
	public void deleteSession(int id) throws NoSuchElementException {
		int before = sessions.size();
		sessions.removeIf(session-> session.getId() == id);
		if (before == sessions.size()) {
			throw new NoSuchElementException("Session not found.");
		}
	}

	@Override
	public void updateTheater(int id, int newCapacity) throws NoSuchElementException {
		ITheater theater = getTheater(id);
		theater.setCapacity(newCapacity);
	}

	@Override
	public void updateMovie(int id, String newName, String newAuthor, int newDuration) throws NoSuchElementException {
		IMovie movie = getMovie(id);
		movie.setName(newName);
		movie.setAuthor(newAuthor);
		movie.setDuration(newDuration);
	}
	@Override
	public void updateSession(int id, Date newDate) throws NoSuchElementException {
		ISession session = getSession(id);
		session.setDate(newDate);
	}

	private ITheater getTheater(int id) throws NoSuchElementException { 
		boolean found = false;
		ITheater foundTheater = null;
		for (ITheater theater : theaters) {
			if (theater.getId() == id) {
				found = true;
				foundTheater = theater;
				break;
			}
		}
		if (!found) {
			throw new NoSuchElementException("Theater not found.");
		}
		return foundTheater;
	}

	private IMovie getMovie(int id) throws NoSuchElementException {
		boolean found = false;
		IMovie foundMovie = null;
		for (IMovie movie: movies) {
			if (movie.getId() == id) {
				found = true;
				foundMovie = movie;
				break;
			}
		}
		if (!found) {
			throw new NoSuchElementException("Theater not found.");
		}
		return foundMovie;
	}

	private ISession getSession(int id) throws NoSuchElementException {
		boolean found = false;
		ISession foundSession = null;
		for (ISession session: sessions) {
			if (session.getId() == id) {
				found = true;
				foundSession = session;
				break;
			}
		}
		if (!found) {
			throw new NoSuchElementException("Theater not found.");
		}
		return foundSession;
	}

	@Override
	public void bookSeat(int idSession, int seatNumber) throws SeatAlreadyBookedException {
		ISession session = getSession(idSession);
		session.book(seatNumber);
	}

}
