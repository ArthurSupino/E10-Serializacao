public class OperacaoSaque extends Operacao {

    public OperacaoSaque(double valor) {
        super('s', valor);
    }

    @Override
    public double calculataxas() {
        return 0.05; // Implementar taxa específica se necessário
    }
}
