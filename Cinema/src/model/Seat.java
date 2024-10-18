package model;

/**
 * Representa un seient en una sala de cinema.
 * 
 * @author luis
 * @version 1.0
 * @since 2024-04-10
 */
public class Seat implements ISeat {
	private boolean booked = false;
	private int id;

	/**
	 * Constructor que inicialitza un seient amb un identificador donat.
	 * 
	 * @param id L'identificador del seient.
	 */
	public Seat(int id) {
		this.id = id;
	}

	/**
	 * Reserva el seient.
	 * 
	 * @throws SeatAlreadyBookedException Si el seient ja està reservat.
	 */
	@Override
	public void book() throws SeatAlreadyBookedException {
		if (booked) {
			throw new SeatAlreadyBookedException("Seat is already booked");
		}
		booked = true;

	}

	/**
	 * Retorna una representació en cadena del seient.
	 * 
	 * @return Una cadena que representa el seient.
	 */
	@Override
	public String toString() {
		if (booked) {
			return "x" + id + "";
		}
		return "\uD83D\uDCBA" + id + "";

	}

}
