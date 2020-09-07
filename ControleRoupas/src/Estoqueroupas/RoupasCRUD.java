package Estoqueroupas;

import Estoqueroupas.roupasConsole.Controller.RoupaController;
import Estoqueroupas.roupasConsole.Models.Roupa;
import Estoqueroupas.roupasConsole.util.Enums.EnumroupasConsoleCorPeca;
import Estoqueroupas.roupasConsole.util.Enums.EnumroupasConsoleTamanho;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RoupasCRUD {

    private static void MontaMenu (Roupa r) {

        try {

            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdt = new SimpleDateFormat("DD/MM/YYYY");

            System.out.println("Digite o código do item(inteiro)");
            int codigoItem = sc.nextInt();
            r.setCodigoItem(codigoItem);
            System.out.println("Digite a data da entrega do item");
            String dataEntrega = sc.next();
            Date dataEntregar = sdt.parse(dataEntrega);
            r.setDataEntrega(dataEntregar);
            System.out.println("Digite o local da compra do item");
            String localCompra = sc.next();
            r.setLocalCompra(localCompra);
            System.out.println("Digite o tipo do item");
            String tipo = sc.next();
            r.setTipo(tipo);
            System.out.println("Digite a marca do item");
            String marca = sc.next();
            r.setMarca(marca);
            System.out.println("Digite a descrição do item");
            String caracteristicas = sc.next();
            r.setCaracteristicas(caracteristicas);
            System.out.println("Digite a cor do item(inteiro)");
            for (EnumroupasConsoleCorPeca cor : EnumroupasConsoleCorPeca.values()) {
                System.out.printf(cor.toString(), cor.getCodigo());

            }
            int cor = sc.nextInt();
            r.setCor(cor);
            System.out.println("Digite o tamanho do item(inteiro)");
            for (EnumroupasConsoleTamanho tamanho : EnumroupasConsoleTamanho.values()) {
                System.out.printf(tamanho.toString(), tamanho.getCodigo());

            }
            int tamanho = sc.nextInt();
            r.setTamanho(tamanho);
            System.out.println("Digite o valor da etiqueta do item");
            System.out.printf("R$ "); double valorEtiqueta = Double.parseDouble(sc.next());
            r.setValorEtiqueta(valorEtiqueta);
            System.out.println("Digite o valor de compra do item");
            System.out.printf("R$ "); double valorCompra = Double.parseDouble(sc.next());
            r.setValorCompra(valorCompra);
            r.setValorMargem();
            System.out.println("Digite o valor sugerido do item");
            System.out.printf("R$ "); double valorSugerido = Double.parseDouble(sc.next());
            r.setPrecoSugerido(valorSugerido);
        }
        catch (ParseException err){
            System.out.println(err.getMessage());
        }


    }


    public static void main(String[] args) throws ParseException, IOException {


        Scanner sc = new Scanner(System.in);
        RoupaController rc = new RoupaController();
        Roupa roupa = new Roupa();
        int codigo = 0;
        int codigoItem = 0;

        while (codigo != 4) {

            System.out.println("Bem vindo ao sistema de Cadastro de roupas!");
            System.out.println("Digite o que deseja fazer");
            System.out.println("1 - Cadastrar Roupa");
            System.out.println("2 - Editar Roupa");
            System.out.println("3 - Excluir Roupa");
            System.out.println("4 - Sair");

            codigo = sc.nextInt();


            switch (codigo) {
                case 1:
                    MontaMenu(roupa);
                    rc.InsereDados(roupa, roupa.getCodigoItem());

                    System.out.println("Roupa cadastrada com sucesso!");
                    codigo = 0;
                    break;

                case 2:
                    Roupa r = new Roupa();
                    System.out.println("Digite o código do item que quer editar");
                    codigoItem = sc.nextInt();
                    rc.EditaDados(codigoItem);
                    MontaMenu(r);
                    rc.InsereDados(r, r.getCodigoItem());


                    System.out.println("Roupa editada com sucesso!");
                    codigo = 0;
                    codigoItem = 0;
                    break;

                case 3:
                    System.out.println("Digite o código do item que quer deletar");
                    codigoItem = sc.nextInt();
                    rc.ExcluiDados(codigoItem);

                    System.out.println("Roupa deletada com sucesso!");
                    codigo = 0;
                    codigoItem = 0;
                    break;

            }
        }


    }

}
