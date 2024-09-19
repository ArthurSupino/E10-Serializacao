import java.util.ArrayList;
import java.io.*;

abstract class Conta implements ITaxas, Serializable {

    private static final long serialVersionUID = 1L;
    private int numero;
    protected Cliente dono;
    private double saldo;
    protected double limite;
    private ArrayList<Operacao> operacoes = new ArrayList<>();
    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        Conta.totalContas++;
    }

    public void imprimirExtratoTaxas() {
        double soma = 0;
        System.out.println("Extrato Taxas : ");
        System.out.println("=======================");
        System.out.println("Taxa de manutençao : " + this.calculataxas());
        System.out.println("Operacoes: ");
        
        int i = 1;
        for (Operacao atual : operacoes) {
            if (atual != null && atual.getTipo() == 's') {
                System.out.println("Saque " + i + ": " + atual.calculataxas());
                soma += atual.calculataxas(); 
                i++;
            }
        }
        soma += this.calculataxas();
        System.out.println("Gasto total : " + soma);
        System.out.println("=-----------------------------------=");
    }

    public void impressao_extratosMAIN() {
        imprimirExtrato(this.numero);
    }

    public boolean sacar(double valor) throws ValorNegativoException, SemLimiteException {
        if (valor < 0) {
            throw new ValorNegativoException();
        }
        if (valor > this.saldo + this.limite) {
            throw new SemLimiteException("Valor de saque muito alto ...");
        }
        this.saldo -= valor;
        setOperacoes(new OperacaoSaque(valor));
        return true;
    }

    public void depositar(double valor) throws ValorNegativoException {
        if (valor < 0) {
            throw new ValorNegativoException();
        }
        this.saldo += valor;
        setOperacoes(new OperacaoDeposito(valor));
    }

    public boolean transferir(Conta destino, double valor) {
        try {
            boolean valorSacado = this.sacar(valor);
            if (valorSacado) {
                destino.depositar(valor);
                return true;
            }
        } catch (ValorNegativoException | SemLimiteException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conta conta = (Conta) obj;
        return numero == conta.numero;
    }

    @Override
    public String toString() {
        return "Conta : " + this.numero + "\n" + "Saldo : " + this.saldo + "\n" + "Limite : " + this.limite;
    }

    public void imprimirExtrato(int num) {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for (Operacao atual : this.operacoes) {
            if (atual != null) {
                System.out.println(atual.toString());
            }
        }
        System.out.println("====================");
        System.out.println("Extrato ordenado: ");
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setOperacoes(Operacao operacao) {
        this.operacoes.add(operacao);
    }

    
    public void serializa_classe() throws IOException {
        String arquivo_da_conta = "Agencia_Do_Sups-" + this.numero + ".ser";

        try (FileOutputStream saida_de_dados = new FileOutputStream(arquivo_da_conta);
             ObjectOutputStream saida = new ObjectOutputStream(saida_de_dados)) {
            saida.writeObject(this);  
            System.out.println("Serializado: " + this);
        } catch (IOException e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
            throw e;
        }
    }

   
    public Conta desserializa_classe() throws IOException, ClassNotFoundException {
        String arquivo_da_conta = "Agencia_Do_Sups-" + this.numero + ".ser";
        Conta conta;

        try (FileInputStream entrada_de_dados = new FileInputStream(arquivo_da_conta);
             ObjectInputStream entrada = new ObjectInputStream(entrada_de_dados)) {
            conta = (Conta) entrada.readObject();
            System.out.println("Desserializado: " + conta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar: " + e.getMessage());
            throw e; 
        }

        return conta;
    }
}
