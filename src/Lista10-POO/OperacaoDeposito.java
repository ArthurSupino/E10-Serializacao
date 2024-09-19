public class OperacaoDeposito extends Operacao {

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    @Override
    public double calculataxas() {
        return 0; // Implementar taxa específica se necessário
    }
}
