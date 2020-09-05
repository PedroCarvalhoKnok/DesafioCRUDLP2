package Estoqueroupas.roupasConsole.Controller;

import Estoqueroupas.roupasConsole.DAO.RoupaDAO;
import Estoqueroupas.roupasConsole.Models.Roupa;

import java.io.IOException;

public class RoupaController extends Roupa {

   public void InsereDados(Roupa roupa,int codigo) throws IOException {
      RoupaDAO DAO = new RoupaDAO();
      DAO.InsereDados(roupa,codigo);

   }

   public Roupa EditaDados(int codigo) throws IOException{
      RoupaDAO DAO = new RoupaDAO();
          return DAO.EditaDados(codigo);


   }

   public void ExcluiDados(int codigo) throws IOException{
      RoupaDAO DAO = new RoupaDAO();
         DAO.ExcluiDados(codigo);


   }



}
