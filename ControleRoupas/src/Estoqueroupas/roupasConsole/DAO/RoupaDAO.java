package Estoqueroupas.roupasConsole.DAO;


import Estoqueroupas.roupasConsole.Models.Roupa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RoupaDAO {



    String caminho = "CRUDRoupas.txt";

    File arquivo;

    List<String> roupas = new ArrayList<String>();

   public void ValidaDadosInseridos(int codigo) throws IOException{

       try {

           roupas = LerRoupasDoArquivo(arquivo);
           String  codItem = "";

           for (String r: roupas) {
               String [] leitor = r.split(":");
               codItem = leitor[1];
               if(String.valueOf(codigo) == codItem.trim()){
                   System.out.println("Código do item já existe!");
               }

           }

       }
       catch (ClassNotFoundException err){
           System.out.printf("Erro: %s", err.getMessage());
       }
   }
   private void ValidaArquivo() throws FileNotFoundException {
       if(arquivo == null){
           System.out.println("Nenhuma roupa cadastrada!");
           return;
       }
   }
    private static List<String> LerRoupasDoArquivo(File arquivo) throws IOException, ClassNotFoundException {
       /* ArrayList<String> linhas =  new ArrayList<String>() ;*/
        List<String> roupas = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        String linhas = "";
        while( (linha = br.readLine()) != null){

            linhas = String.join(linha);

        }
        String [] roupa = linhas.split("_") ;

        for(String r : roupa){
            roupas.add(r);
        }

        br.close();
        return roupas;
    }

    private static void DeletarRoupaDoArquivo(File arquivo,String r) throws IOException {
        List<String> salvar = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha = br.readLine();
        String linhas = "";
        while( (linha != null)){

           linhas = String.join(linha);

        }
        String[] arq = linhas.split("_");
        for(String a : arq){
            if(a.trim().equals(r.trim()) == false){
                salvar.add(a);
            }

        }
        br.close();
        FileWriter fw = new FileWriter(arquivo);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0 ; i < salvar.size();i++){
            bw.write(salvar.get(i));
            bw.newLine();
        }
        bw.close();
        fw.close();



    }

    public void InsereDados(Roupa roupa,int codigo) throws IOException, FileNotFoundException {

        try {


            arquivo = new File(caminho);
            FileWriter fw = new FileWriter(arquivo.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);

            ValidaDadosInseridos(codigo);

            bw.write("Código do item:" + String.valueOf(roupa.getCodigoItem()) + "\n");
            bw.write(":Data da entrega do item:" + String.valueOf(roupa.getDataEntrega()) + "\n");
            bw.write(":Local da compra do item:" + roupa.getLocalCompra() + "\n");
            bw.write(":Tipo do item:" + roupa.getTipo() + "\n");
            bw.write(":Marca do item:" + roupa.getMarca() + "\n");
            bw.write(":Características do item:" + roupa.getCaracteristicas() + "\n");
            bw.write(":Cor do item:" + String.valueOf(roupa.getCor()) + "\n");
            bw.write(":Tamanho do item:" + String.valueOf(roupa.getTamanho()) + "\n");
            bw.write(":Valor da etiqueta do item:" + String.valueOf(roupa.getValorEtiqueta()) +"\n");
            bw.write(":Valor de compra do item:" + String.valueOf(roupa.getValorCompra()) + "\n");
            bw.write(":Valor margem do item:" + String.valueOf(roupa.getValorMargem()) + "\n");
            bw.write(":Preço sugerido do item:" + String.valueOf(roupa.getPrecoSugerido()) + "\n");
            bw.write("_");
            bw.close();


        }
        catch (IOException erro){
            System.out.printf("Erro: %s", erro.getMessage());
        }



    }

    public void EditaDados(int codigo) throws IOException {

       try {
           try {

               ValidaArquivo();

                roupas = LerRoupasDoArquivo(arquivo);
                String  codItem = "";

               for (String r: roupas) {

                       String [] leitor = r.split(":");
                       codItem = leitor[1];
                       if(String.valueOf(codigo) == codItem.trim()){
                           DeletarRoupaDoArquivo(arquivo,r);

                       }
                       else {
                       System.out.println("Item não encontrado no estoque!");

                       }

               }

           }
           catch (ClassNotFoundException err){
               System.out.printf("Erro: %s", err.getMessage());
           }
       }
       catch (IOException erro){
           System.out.printf("Erro: %s", erro.getMessage());
       }



    }

    public void ExcluiDados(int codigo) {

        try {

            ValidaArquivo();
            roupas = LerRoupasDoArquivo(arquivo);
            String codItem = "";
            for (String r: roupas) {
                String [] leitor = r.split(":");
                codItem = leitor[1];
                if(String.valueOf(codigo) == codItem.trim()){
                    DeletarRoupaDoArquivo(arquivo,r);

                }
                else {
                    System.out.println("Item não encontrado no estoque!");
                }

            }

        } catch (IOException e) {
            System.out.printf("Erro: %s", e.getMessage());
        } catch (ClassNotFoundException err) {
            System.out.printf("Erro: %s", err.getMessage());
        }


    }
    
}
