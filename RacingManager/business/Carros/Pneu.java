package org.example.business.cars;


import java.util.Objects;

public class Pneu{

	public static enum TyreType {
		SOFT,
		MEDIUM,
		HARD,
		INTERMEDIATE,
		WET
	}
	private TyreType type;

	public TyreType getTipo() {return type;}

	private boolean isPunctured;

	@Override
	public Pneu clone() {
		return new Pneu(this.getTipo());
	}

	public void setTipo(TyreType type) {this.type = type;}

	public Pneu (TyreType t){
		type=t;
	}

	public double getTyreWearStep() {
		switch(this.type) {
			case SOFT:
				return 1.0;
			case MEDIUM:
				return 0.5;
			case HARD:
				return 0.25;
			case INTERMEDIATE:
				return 1.3;
			case WET:
				return 1.5;
			default:
				return 0.0;
		}
	}

	public boolean isPunctured() {
		return this.isPunctured;
	}

	public void setPuncture(boolean puncture) {
		this.isPunctured = puncture;
	}
	public boolean isWet() {
		return type == TyreType.WET || type == TyreType.INTERMEDIATE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pneu tyre = (Pneu) o;
		return this.getTipo() == tyre.getTipo();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTipo());
	}

	@Override
	public String toString() {
		return "Pneu{" +
				"type=" + type +
				'}';
	}
}
