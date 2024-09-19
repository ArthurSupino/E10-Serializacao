public class ContaUniversitaria extends Conta {

    public ContaUniversitaria(int numero, Cliente dono, double saldo, double limite , String agencia) {
        super(numero, dono, saldo, agencia);
        setLimite(limite);
    }

    @Override
    public void setLimite(double limite) throws IllegalArgumentException {
        if (limite <= 500 && limite >= 0) {
            this.limite = limite;
        } else {
            throw new IllegalArgumentException("Limite deve estar entre 0 e 500");
        }
    }

    @Override
    public double calculataxas() {
        return 0; // Implementar taxa específica se necessário
    }
}
