package Estoqueroupas.roupasConsole.util.Enums;

public enum EnumroupasConsoleCorPeca {

 Vermelho(1),
    Preto(2),
    Azul(3),
    Amarelo(4),
    Cinza(5),
    Verde(6),
    Roxo(7),
    Marrom(8);


    EnumroupasConsoleCorPeca(int codigo){
     this.codigo = codigo;

    }
    public int getCodigo(){

       return this.codigo;
   }
    private int codigo;

}
