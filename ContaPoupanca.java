public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo);
        setLimite(limite);
    }

    @Override
    public void setLimite(double limite) throws IllegalArgumentException {
        if (limite <= 1000 && limite >= 100) {
            this.limite = limite;
        } else {
            throw new IllegalArgumentException("Limite deve estar entre 100 e 1000");
        }
    }

    @Override
    public double calculataxas() {
        return 0; // Implementar taxa específica se necessário
    }
}
