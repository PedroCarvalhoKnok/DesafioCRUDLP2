package Estoqueroupas.roupasConsole.util.Enums;

public enum EnumroupasConsoleTamanho {
    PP(1),
    P(2),
    M(3),
    G(4),
    GG(5);

    EnumroupasConsoleTamanho(int codigo){
        this.codigo = codigo;

    }
    public int getCodigo(){

        return this.codigo;
    }
    private int codigo;
}
