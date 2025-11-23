// Archivo: ConsultaDeAPI.java
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDeAPI {
    private static final String API_KEY = "2f5ed877006fd51fb369433b";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public JsonObject obtenerTasasDeCambio(String codigoMonedaBase) {
        String url = BASE_URL + API_KEY + "/latest/" + codigoMonedaBase;

        // Creando cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();

        // Creando la solicitud
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Enviando solicitud y recibiendo respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() == 200) {
                // Parseando el JSON con Gson
                JsonObject jsonRespuesta = JsonParser.parseString(respuesta.body()).getAsJsonObject();

                // Verificando que la respuesta sea exitosa
                if (jsonRespuesta.get("result").getAsString().equals("success")) {
                    return jsonRespuesta;
                } else {
                    System.out.println("Error en la respuesta de la API");
                    return null;
                }
            } else {
                System.out.println("Error al realizar la solicitud. Código: " + respuesta.statusCode());
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }

    public double obtenerTasaEspecifica(String monedaOrigen, String monedaDestino) {
        JsonObject respuesta = obtenerTasasDeCambio(monedaOrigen);

        if (respuesta != null) {
            JsonObject tasasConversion = respuesta.getAsJsonObject("conversion_rates");

            if (tasasConversion.has(monedaDestino)) {
                return tasasConversion.get(monedaDestino).getAsDouble();
            } else {
                System.out.println("Moneda destino no encontrada");
                return 0;
            }
        }

        return 0;
    }
}