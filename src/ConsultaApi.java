import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private static final String API_KEY = "2f5ed877006fd51fb369433b";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Moneda obtenerMoneda(String codigoBase, String codigoDestino) {
        try {
            //  Crear HttpClient
            HttpClient cliente = HttpClient.newHttpClient();

            //  Crear HttpRequest
            String url = BASE_URL + API_KEY + "/latest/" + codigoBase;
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            //  Obtener HttpResponse
            HttpResponse<String> respuesta = cliente.send(solicitud,
                    HttpResponse.BodyHandlers.ofString());

            // Analizar JSON con Gson
            JsonObject jsonObject = JsonParser.parseString(respuesta.body())
                    .getAsJsonObject();

            // Verificar si la respuesta fue exitosa
            String resultado = jsonObject.get("result").getAsString();
            if (!resultado.equals("success")) {
                System.out.println("Error: La API no retornó una respuesta exitosa.");
                return null;
            }

            // Obtener las tasas de conversión
            JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");

            if (tasasConversion.has(codigoDestino)) {
                double tasa = tasasConversion.get(codigoDestino).getAsDouble();
                return new Moneda(codigoBase, codigoDestino, tasa);
            } else {
                System.out.println("Error: No se encontró la tasa para " + codigoDestino);
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}