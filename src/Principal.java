import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        LlamadaApi llamada = new LlamadaApi();
        int opcionElegida = 1;
        Historial historial = new Historial();
        Scanner sc = new Scanner(System.in);
        Conversor conversor = new Conversor();
        List<Moneda> monedas = new ArrayList<>();
        monedas = llamada.obtenerMonedas("ARS", "CLP", "COP");


        String mensajePrincipal = """
                *********************************************
                Le damos la bienvenida al conversor de monedas
                Elija los pares de monedas que desea convertir:
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Peso chileno
                4) Peso chileno => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Ver historial de conversiones
                8) Salir
                
                Elija una opción válida
                *********************************************""";

        while(true){
            System.out.println(mensajePrincipal);
            opcionElegida = sc.nextInt();


            if(opcionElegida == 7){

                if(historial.getHistorial().isEmpty()) {
                    System.out.println("Aún no ha realizado ninguna conversión.");
                } else {
                    System.out.println("""
                            **********************************************
                            Historial""");

                    for (String elemento : historial.getHistorial()) {
                        System.out.println(elemento);
                    }
                }

            } else if (opcionElegida <= 0) {
                break;
            } else if (opcionElegida == 8){
                break;
            } else if(opcionElegida % 2 == 0) {
            int index = (opcionElegida / 2) + 1;
            Moneda moneda = monedas.get(opcionElegida - index);
            System.out.println("Indique la cantidad de " + moneda.getCodigo() + " que desea convertir a USD");
            double cantidad = sc.nextDouble();
            conversor.convertirMoneda(moneda, "a USD", cantidad, historial);
        } else {
            Moneda moneda = monedas.get(opcionElegida/2);
            System.out.println("Indique la cantidad de USD que desea convertir a " + moneda.getCodigo());
            double cantidad = sc.nextDouble();
            conversor.convertirMoneda(moneda, "de USD", cantidad, historial);
        }



        }






    }

}
