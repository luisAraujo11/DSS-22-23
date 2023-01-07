package RacingManager.business.Carros;

import java.util.Objects;

public class Pneu{

	public static enum TipoPneu {
		SOFT,
		MEDIUM,
		HARD,
		INTERMEDIATE,
		WET
	}
	private TipoPneu type;

	public TipoPneu getTipo() {return type;}


	@Override
	public Pneu clone() {
		return new Pneu(this.getTipo());
	}

	public void setTipo(TipoPneu type) {this.type = type;}

	public Pneu (TipoPneu t){
		type=t;
	}

	public double getTipoPneu() {
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


	public boolean isWet() {
		return type == TipoPneu.WET || type == TipoPneu.INTERMEDIATE;
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
