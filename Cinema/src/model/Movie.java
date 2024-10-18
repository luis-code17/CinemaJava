package model;

/**
 * Representa una pel·lícula amb la seva informació com el nom, autor i duració.
 * 
 * @author luis
 * @version 1.0
 * @since 2024-04-10
 */
public class Movie implements IMovie {
	private int id;
	private static int nextid;
	private String name;
	private String author;
	private int duration;

	/**
	 * Constructor que inicialitza una nova pel·lícula amb el nom, autor i duració
	 * donats.
	 * 
	 * @param name     El nom de la pel·lícula.
	 * @param author   L'autor de la pel·lícula.
	 * @param duration La duració de la pel·lícula en minuts.
	 */
	public Movie(String name, String author, int duration) {
		this.name = name;
		this.author = author;
		this.duration = duration;
		nextid++;
		id = nextid;
	}

	/**
	 * Obté l'identificador de la pel·lícula.
	 * 
	 * @return L'identificador de la pel·lícula.
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Estableix l'identificador de la pel·lícula.
	 * 
	 * @param id L'identificador de la pel·lícula.
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obté el nom de la pel·lícula.
	 * 
	 * @return El nom de la pel·lícula.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Estableix el nom de la pel·lícula.
	 * 
	 * @param name El nom de la pel·lícula.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obté l'autor de la pel·lícula.
	 * 
	 * @return L'autor de la pel·lícula.
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * Estableix l'autor de la pel·lícula.
	 * 
	 * @param author L'autor de la pel·lícula.
	 */
	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Obté la duració de la pel·lícula en minuts.
	 * 
	 * @return La duració de la pel·lícula.
	 */
	@Override
	public int getDuration() {
		return duration;
	}

	/**
	 * Estableix la duració de la pel·lícula en minuts.
	 * 
	 * @param duration La duració de la pel·lícula en minuts.
	 */
	@Override
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Retorna una representació en cadena de la pel·lícula.
	 * 
	 * @return Una cadena que representa la pel·lícula.
	 */
	@Override
	public String toString() {
		return "Movie(" + id + ") " + name + " and duration " + duration + "min with author " + author;
	}

}
