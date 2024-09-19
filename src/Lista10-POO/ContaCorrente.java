public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Cliente dono, double saldo, double limite , String agencia) {
        super(numero, dono, saldo,agencia);
        setLimite(limite);  
    }

    @Override
    public void setLimite(double limite) throws IllegalArgumentException {
        if (limite > -100) {
            this.limite = limite;
        } else {
            throw new IllegalArgumentException("Limite deve ser maior que -100");
        }
    }

    @Override
    public double calculataxas() {
        if (this.dono instanceof PessoaJuridica) {
            return 20;
        } else {
            return 10;
        }
    }
}
