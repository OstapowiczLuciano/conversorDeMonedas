import excepciones.Excepcion;

public class Conversor {


    public void convertirMoneda(Moneda moneda, String tipoOperacion, double cantidad, Historial historial) {

        double monto;

        if(tipoOperacion.equals("a USD")){

          monto =  cantidad / moneda.getValorConversion();
          String mensaje = cantidad + " " +moneda.getCodigo() + " equivalen a " + "%.2f" + " USD";
            System.out.println(String.format(mensaje, monto));

        } else if(tipoOperacion.equals("de USD")){
            monto =  cantidad * moneda.getValorConversion();
            String mensaje = cantidad + " USD "+"equivalen a "+ "%.2f"+ " " + moneda.getCodigo();
            System.out.println(String.format(mensaje, monto));
        } else {
            throw new Excepcion("Operación invalida");
        }

        historial.agregarAHistorial(cantidad, tipoOperacion, moneda.getCodigo(), monto);

    }




}
