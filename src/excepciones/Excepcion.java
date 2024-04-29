package excepciones;

public class Excepcion extends RuntimeException {

    private String mensaje;

    public Excepcion(String mensaje) {

        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
}
