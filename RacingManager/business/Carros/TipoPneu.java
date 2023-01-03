package RacingManager.business.Carros;

public enum TipoPneu{
MACIO,
DURO,
CHUVA,
NULL;
    public static TipoPneu fromString(String str){
	 switch (str){
		case("macio"):
			return MACIO;
		case("duro"):
			return DURO;
		case("chuva"):
			return CHUVA;
		default:
			return NULL;	
		}
    }
	public static String toStr(TipoPneu pneus)
	{
	 switch(pneus){
		case MACIO:
			return "macio";
		case DURO:
			return "duro";
		case CHUVA:
			return "chuva";
		default:
			return "sem tipo ";
		}
	}
}

