import java.text.SimpleDateFormat;
import java.util.Date;

public class ExemploHeranca {

        public static void main(String[] args) throws Exception
        {
            SimpleDateFormat data1 = new SimpleDateFormat("dd-MM-yyyy");
            Date datac = data1.parse("20-04-2010");
            Date datam = data1.parse("04-06-2016");
            Date datan = data1.parse("19-07-1947");
            Date dataa = data1.parse("22-11-2007");

            Carro carro = new Carro("Carro","terrestre",4,datac,120.76);

            Motocicleta moto = new Motocicleta("Moto","terrestre",2,datam,200.64);

            Navio navio = new Navio("Navio","aquático",0,datan,50.01);

            Aviao aviao = new Aviao("Avião","aéreo",3,dataa,500.5);


           System.out.println(carro.getNome());
            System.out.println(aviao.getNome());
            carro.ComparaVelocidade(moto);
            carro.ComparaAno(moto);






        }
    }

