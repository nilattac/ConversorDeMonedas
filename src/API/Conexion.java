package API;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {

    private String monedaInicial;
    private String monedaFinal;
    private String monto;

    public Conexion(String monedaInicial, String monedaFinal, String monto) {
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;
        this.monto = monto;
    }

    public double convertir (){
        Gson gson = new GsonBuilder().create();

        String direccion = "https://v6.exchangerate-api.com/v6/00c2504999b107270637f939" + "/pair/"+monedaInicial+"/"+monedaFinal+"/"+monto;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Resultado resultado =
                    gson.fromJson(response.body(), Resultado.class);

            return resultado.conversion_result;

        } catch (Exception e) {
            throw new RuntimeException("Error en la conversión");
        }
    }
}