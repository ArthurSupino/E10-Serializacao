import java.util.Date;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private int numFuncionarios;
    private String setor;

    public PessoaJuridica(String nome, String endereco, Date data, String cnpj, int numFuncionarios, String setor) {
        super(nome, endereco, data);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PessoaJuridica that = (PessoaJuridica) obj;
        return cnpj.equals(that.cnpj);
    }

    @Override
    public String toString() {    
        return super.toString() + "\nCnpj: " + this.cnpj + "\nNumero de Funcionarios: " + this.numFuncionarios + "\nSetor: " + this.setor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public boolean autenticacao(String autentificador) {   
        return this.cnpj.equals(autentificador);
    }
}
