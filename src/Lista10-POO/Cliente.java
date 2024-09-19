import java.util.Date;
import java.io.*;

abstract class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;
    private String tipo;
    private String nome;
    private String endereco;
    private Date data;

    public Cliente(String nome, String endereco, Date data) {
        this.nome = nome;
        this.endereco = endereco;
        this.data = data;
    }

    @Override
    public String toString() {    
        return "Nome : " + this.nome + "\n" + "Endereco : " + this.endereco + "\n" + "Data : " + this.data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return nome.equals(cliente.nome) && endereco.equals(cliente.endereco) && data.equals(cliente.data);
    }

    public boolean autenticacao(String parametro) {
        return false; // Implementar autenticação baseada em tipo de cliente
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }
}
