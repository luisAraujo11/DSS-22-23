package business.Corrida;

import java.util.Random;
public class Segmento {
    private static final int CURVA = 0;
    private static final int RETA = 1;
    private static final int SHICANE = 2;

    private static final int IMPOSSIVEL = 3;
    private static final int POSSIVEL = 4;
    private static final int DIFICIL = 5;

    private int type;
    private int gdu;

    public int getGDU() {
        return this.gdu;
    }

    public void setGDU(int gdu) {
        this.gdu = gdu;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Segmento(int type) {
        this.type = type;
        this.gdu = new Random().nextInt(3);
    }
    public Segmento(int tipo, int gdu) {
        this.type = tipo;
        this.gdu = gdu;
    }
    public Segmento(Segmento segmento) {
        this.type = segmento.getType();
        this.gdu = segmento.getGDU();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: ");
        switch (this.type) {
            case 0:
                sb.append("Curva");
                break;
            case 1:
                sb.append("Reta");
                break;
            case 2:
                sb.append("Shicane");
                break;
        }
        sb.append(" GDU: ");
        sb.append(this.gdu);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Segmento s = (Segmento) o;
        return s.getType() == this.type && s.getGDU() == this.gdu;
    }

    public Segmento clone()
    {
        return new Segmento(this);
    }

}
