import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class LlamadaApi {

    Gson gson = new GsonBuilder().create();





//    private String apiKey = "80af06bcb8558b5db15bc398";


    public List<Moneda> obtenerMonedas (String moneda1, String moneda2, String moneda3){
        List<Moneda> tasasDeConversion = new ArrayList<>();
        String direccion = "https://v6.exchangerate-api.com/v6/63ee934c679876fea7348bdf/latest/USD";

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            System.out.println(response.body());

            JsonReader lectura = new JsonReader(new InputStreamReader(response.body(), "UTF-8"));


            lectura.beginObject();
            while(lectura.hasNext()){
                String name = lectura.nextName();
                if(name.equals("conversion_rates")){
                    lectura.beginObject();
                    while(lectura.hasNext()){
                        String valor = lectura.nextName();
                        if(valor.equals(moneda1)){
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);

                        } else if(valor.equals(moneda2)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);

                        } else if(valor.equals(moneda3)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);
                        } else {
                            lectura.skipValue();
                        }
                    }
                    lectura.endObject();

                    break;
                } else {
                    lectura.skipValue();
                }
            }

            lectura.endObject();


            return tasasDeConversion;

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return tasasDeConversion;
    }
}
