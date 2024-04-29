import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<String> historial = new ArrayList<>();


    public void agregarAHistorial (double cantidad, String tipoOperacion, String codigo, double monto ) {

        if(tipoOperacion.equals("a USD")){
            historial.add("Convirtió "+cantidad+" "+codigo+" "+tipoOperacion+" ("+monto+" USD)");
        } else {
            historial.add("Convirtio "+cantidad+ " USD"+" a "+codigo+" ("+monto+" "+codigo+")");
        }

    }

    public List<String> getHistorial() {
        return historial;
    }
}
