package model;


public class Seat implements ISeat {

	private boolean isBooked;
	
	public Seat() {
		this.isBooked = false;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		if (isBooked) {
			return "X";
		} else {
			return "O";
		}
	}

	@Override
	public void book() throws SeatAlreadyBookedException {
		if (this.isBooked) {
			throw new SeatAlreadyBookedException("Seat is already booked.");
		} else {
			this.setBooked(true);
		}
	}
	
	
}
