import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Veiculo {

    private String nome;
    private String tipo;
    private int qtdRodas;
    private Date anoFabricacao;
    private double velocidadeMax;

    public Veiculo(String _nome,String _tipo, int _qtdRodas, Date _anoFabricacao,double _velocidadeMax)
    {
        this.nome = _nome;
        this.tipo = _tipo;;
        this.qtdRodas = _qtdRodas;
        this.anoFabricacao = _anoFabricacao;
        this.velocidadeMax = _velocidadeMax;

    }
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public  int getQtdRodas(){
        return  qtdRodas;
    }
    public Date getAno(){
        return  anoFabricacao;
    }
    public Double getVelocidade(){
        return  velocidadeMax;
    }

    public void ComparaVelocidade(Veiculo v){

        if(this.velocidadeMax > v.velocidadeMax){
            System.out.println("O(A)"+ this.nome + " é mais rápido que o(a) " + v.nome);
        }
        else {
            System.out.println("O(A)"+this.nome + " é menos rápido que o(a) " + v.nome);
        }
    }
    public void ComparaAno(Veiculo v){

        if(this.anoFabricacao.compareTo(v.anoFabricacao) > 0){

            System.out.println("O(A)"+ this.nome + " é mais novo que o(a) " + v.nome);
        }
        else if(this.anoFabricacao.compareTo(v.anoFabricacao) == 0){
            System.out.println("O(A)"+ this.nome + " é do mesmo ano que o(a) " + v.nome);
        }
        else {
            System.out.println("O(A)"+ this.nome + " é mais antigo que o(a) " + v.nome);
        }



    }



}
