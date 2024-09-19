public class ValorNegativoException extends Exception {
    public ValorNegativoException() {
        super("Valor negativo não é permitido");
    }
    public ValorNegativoException(String message) {
        super(message);
    }
}
