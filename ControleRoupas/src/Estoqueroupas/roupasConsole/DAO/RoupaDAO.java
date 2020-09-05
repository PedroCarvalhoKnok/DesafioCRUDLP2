package Estoqueroupas.roupasConsole.DAO;


import Estoqueroupas.roupasConsole.Models.Roupa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoupaDAO  {

    File arquivo = new File("CRUDRoupas.txt");
    List<Roupa> objetos;

   public void ValidaDadosInseridos(int codigo) throws IOException{

       try {

           /* Roupa roupa = (Roupa) is.readObject();*/

          /* List<Integer> listaCodigos = new ArrayList<Integer>();*/
           objetos = LerObjetosDoArquivo(arquivo);

           for (Roupa obj: objetos) {
               if(obj.getCodigoItem() == codigo)
               {
                   System.out.println("Código do item já existe!");
                   return;
               }

           }

          /*
           listaCodigos.add(roupa.getCodigoItem());

           for (int codigo: listaCodigos) {
               if(r.getCodigoItem() == codigo){
                   System.out.println("Código do item já existe!");
                   is.close();
               }

           }*/
       }
       catch (ClassNotFoundException err){
           System.out.printf("Erro: %s", err.getMessage());
       }
   }
   private void ValidaArquivo(){
       if(!arquivo.exists()){
           System.out.println("Nenhuma roupa cadastrada!");
           return;
       }
   }
    private static List<Roupa> LerObjetosDoArquivo(File arquivo) throws IOException, ClassNotFoundException {
        List<Roupa> objetos = new ArrayList();
        InputStream is = null;
        try {
            is = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(is);
            while (true) {
                try {
                    Roupa roupa = (Roupa) ois.readObject();
                    objetos.add(roupa);

                } catch (EOFException ex) {
                    break;
                }
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return objetos;
    }



    public void InsereDados(Roupa roupa,int codigo) throws IOException {

        try {

            /* FileWriter fw = new FileWriter(arquivo,true);*/
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arquivo, true));


            if (!arquivo.exists())
                arquivo.createNewFile();

            ValidaDadosInseridos(codigo);

            os.flush();
            os.writeObject(roupa);
            os.close();
        }
        catch (IOException erro){
            System.out.printf("Erro: %s", erro.getMessage());
        }



    }

    public Roupa EditaDados(int codigo) throws IOException {

       try {
           try {

               ValidaArquivo();

              /* FileInputStream fs = new FileInputStream(arquivo);*/
              /* ObjectInputStream is = new ObjectInputStream(fs);*/
               ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arquivo));


                objetos = LerObjetosDoArquivo(arquivo);
              /* Roupa roupa = (Roupa) is.readObject();
               List<Integer> listaCodigos = new ArrayList<Integer>();*/
               for (Roupa obj: objetos) {
                   if(codigo == obj.getCodigoItem())
                   {
                      objetos.remove(obj);
                      return obj;

                   }
                   else {
                       System.out.println("Item não encontrado no estoque!");

                   }

               }
               objetos = LerObjetosDoArquivo(arquivo);
               /*listaCodigos.add(roupa.getCodigoItem());
               for(int cod: listaCodigos){
                   if(codigo == cod){


                   }
               }*/
           }
           catch (ClassNotFoundException err){
               System.out.printf("Erro: %s", err.getMessage());
           }
       }
       catch (IOException erro){
           System.out.printf("Erro: %s", erro.getMessage());
       }

       return new Roupa();


    }

    public void ExcluiDados(int codigo) {

        try {

            ValidaArquivo();
            objetos = LerObjetosDoArquivo(arquivo);
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arquivo));
            for (Roupa obj: objetos) {
                if(codigo == obj.getCodigoItem())
                {

                    objetos.remove(obj);

                }
                else {
                    System.out.println("Item não encontrado no estoque!");

                }

            }
            objetos = LerObjetosDoArquivo(arquivo);

        } catch (IOException e) {
            System.out.printf("Erro: %s", e.getMessage());
        } catch (ClassNotFoundException err) {
            System.out.printf("Erro: %s", err.getMessage());
        }


    }
    
}
