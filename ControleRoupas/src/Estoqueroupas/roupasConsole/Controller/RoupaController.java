package Estoqueroupas.roupasConsole.Controller;

import Estoqueroupas.roupasConsole.DAO.RoupaDAO;
import Estoqueroupas.roupasConsole.Models.Roupa;

import java.io.IOException;

public class RoupaController  {

   public void InsereDados(Roupa roupa,int codigo) throws IOException {
      try {
         RoupaDAO DAO = new RoupaDAO();
         DAO.InsereDados(roupa, codigo);
      }
      catch (Exception erro){

         System.out.printf("Ocorreu um erro %s", erro.getMessage());

      }

   }

   public void EditaDados(int codigo) throws IOException{
      try {
         RoupaDAO DAO = new RoupaDAO();
         DAO.EditaDados(codigo);
      }
      catch (Exception erro){
         System.out.printf("Ocorreu um erro %s",erro.getMessage());
      }


   }

   public void ExcluiDados(int codigo) throws IOException{
      try {
         RoupaDAO DAO = new RoupaDAO();
         DAO.ExcluiDados(codigo);
      }
      catch (Exception erro){
         System.out.printf("Ocorreu um erro %s",erro.getMessage());
      }


   }



}
