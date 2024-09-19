import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar clientes
        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627", new Date(), "111.111.111-11", 36, 'm');
        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000", new Date(), "000.00000.0000/0001", 25, "Comércio");
        
        // Criar contas
        Conta conta1 = new ContaPoupanca(1234, joao, 100, 800);

        // Testes de depósito
        System.out.println("Testando depósito:");
        try {
            conta1.depositar(10);
            System.out.println("Depósito realizado com sucesso.");
        } catch (ValorNegativoException e) {
            System.out.println(e.getMessage());
        }
        
        // Testes de saque
        System.out.println("\nTestando saque:");
        try {
            conta1.sacar(4000);
        } catch (SemLimiteException | ValorNegativoException e) {
            System.out.println(e.getMessage());
        }

        // Impressão de extrato e informações
        System.out.println("\nImprimindo extrato e informações:");
        System.out.println(conta1);
        conta1.impressao_extratosMAIN();
        
        // Informações dos clientes
        System.out.println("\nInformações dos clientes:");
        System.out.println(lojinha);
        System.out.println(joao);

        // Cálculo da média de operações
        int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
        System.out.println("Média de operações por conta aberta: " + media);

        // Verificação do tipo de cliente
        System.out.println("\nVerificação do tipo de cliente:");
        System.out.println("O dono da conta é uma Pessoa Jurídica? " + (conta1.getDono() instanceof PessoaJuridica));

        //Serializacao e desserializacao da conta
        System.out.println("========================");
        try{
        conta1.serializa_classe();
        }catch(IOException e)
        {
            System.out.println("Erro na serializacao desta conta");
        }

        try
        {   
            conta1.desserializa_classe();

        }catch(IOException | ClassNotFoundException e)
        {

        }
    }
}
