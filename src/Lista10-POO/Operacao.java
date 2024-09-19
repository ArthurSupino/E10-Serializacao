import java.util.Date;
import java.io.Serializable;
abstract class Operacao implements ITaxas , Serializable{

    private Date data;
    private char tipo;
    private double valor;
    private static int totalOperacoes = 0;

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = new Date();
        Operacao.totalOperacoes++;
    }

    @Override
    public String toString() {
        return this.data + " " + this.tipo + " " + this.valor;
    }

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public static int getTotalOperacoes() {
        return Operacao.totalOperacoes;
    }

    public void setTipo(char tipo) {
        if (tipo == 'd' || tipo == 's') {
            this.tipo = tipo;
        }
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
