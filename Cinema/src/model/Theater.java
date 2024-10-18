package model;

/**
 * Representa una sala de cine amb la seva capacitat.
 * 
 * @author luis
 * @version 1.0
 * @since 2024-04-10
 */
public class Theater implements ITheater {
	private int id;
	private static int nextid;
	private int capacity;

	/**
	 * Constructor que inicialitza una nova sala de cinema amb la capacitat donada.
	 * 
	 * @param capacity La capacitat de la sala de cinema.
	 */
	public Theater(int capacity) {
		this.capacity = capacity;
		nextid++;
		id = nextid;
	}

	/**
	 * Estableix l'identificador de la sala de cinema.
	 * 
	 * @param id L'identificador de la sala de cinema.
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obté l'identificador de la sala de cinema.
	 * 
	 * @return L'identificador de la sala de cinema.
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Estableix la capacitat de la sala de cinema.
	 * 
	 * @param capacity La capacitat de la sala de cinema.
	 */
	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Obté la capacitat de la sala de cinema.
	 * 
	 * @return La capacitat de la sala de cinema.
	 */
	@Override
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Retorna una representació en cadena de la sala de cinema.
	 * 
	 * @return Una cadena que representa la sala de cinema.
	 */
	@Override
	public String toString() {
		return "Theater " + id + " with capacity of " + capacity + ".";

	}

}
