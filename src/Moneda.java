
public class Moneda {
    private String codigoBase;
    private String codigoDestino;
    private double tasaConversion;

    public Moneda(String codigoBase, String codigoDestino, double tasaConversion) {
        this.codigoBase = codigoBase;
        this.codigoDestino = codigoDestino;
        this.tasaConversion = tasaConversion;
    }

    public String getCodigoBase() {
        return codigoBase;
    }

    public void setCodigoBase(String codigoBase) {
        this.codigoBase = codigoBase;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public void setCodigoDestino(String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "codigoBase='" + codigoBase + '\'' +
                ", codigoDestino='" + codigoDestino + '\'' +
                ", tasaConversion=" + tasaConversion +
                '}';
    }
}
