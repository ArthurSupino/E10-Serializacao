import java.util.Date;

public class PessoaFisica extends Cliente {

    private String cpf;
    private int idade;
    private char genero;

    public PessoaFisica(String nome, String endereco, Date data, String cpf, int idade, char genero) {
        super(nome, endereco, data);
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PessoaFisica that = (PessoaFisica) obj;
        return cpf.equals(that.cpf);
    }

    @Override
    public String toString() {    
        return super.toString() + "\nCpf: " + this.cpf + "\nIdade: " + this.idade + "\nGenero: " + this.genero;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean autenticacao(String autentificador) {   
        return this.cpf.equals(autentificador);
    }
}
