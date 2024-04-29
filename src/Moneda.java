public class Moneda {

    private String codigo;
    private Double valorConversion;

    public Moneda(String codigo, Double valorConversion) {
        this.codigo = codigo;
        this.valorConversion = valorConversion;
    }

    public String getCodigo() {
        return codigo;
    }

    public Double getValorConversion() {
        return valorConversion;
    }
}
