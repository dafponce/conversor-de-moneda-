
import java.util.HashMap;
import java.util.Map;

public class ConversorDeMoneda {
    private ConsultaDeAPI consultaAPI;
    private Map<String, String> monedasDisponibles;

    public ConversorDeMoneda() {
        this.consultaAPI = new ConsultaDeAPI();
        this.monedasDisponibles = new HashMap<>();
        inicializarMonedas();
    }

    private void inicializarMonedas() {
        monedasDisponibles.put("ARS", "Peso argentino");
        monedasDisponibles.put("BOB", "Boliviano boliviano");
        monedasDisponibles.put("BRL", "Real brasileño");
        monedasDisponibles.put("CLP", "Peso chileno");
        monedasDisponibles.put("COP", "Peso colombiano");
        monedasDisponibles.put("USD", "Dólar estadounidense");
    }

    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        if (!validarMoneda(monedaOrigen) || !validarMoneda(monedaDestino)) {
            System.out.println("Código de moneda inválido");
            return 0;
        }

        double tasa = consultaAPI.obtenerTasaEspecifica(monedaOrigen, monedaDestino);

        if (tasa > 0) {
            return cantidad * tasa;
        } else {
            System.out.println("No se pudo obtener la tasa de cambio");
            return 0;
        }
    }

    private boolean validarMoneda(String codigo) {
        return monedasDisponibles.containsKey(codigo.toUpperCase());
    }

    public void mostrarResultadoConversion(String monedaOrigen, String monedaDestino,
                                           double cantidadOrigen, double cantidadDestino) {
        System.out.println("\n========================================");
        System.out.println("RESULTADO DE LA CONVERSIÓN");
        System.out.println("========================================");
        System.out.printf("%.2f %s equivale a %.2f %s%n",
                cantidadOrigen, monedaOrigen, cantidadDestino, monedaDestino);
        System.out.println("========================================\n");
    }
}