package Estoqueroupas.roupasConsole.Models;


import java.io.Serializable;
import java.util.Date;

public class Roupa {

    private int codigoItem;
    private Date dataEntrega;
    private String localCompra;
    private String tipo;
    private String marca;
    private String caracteristicas;
    private int cor;
    private int tamanho;
    private double valorEtiqueta;
    private double valorCompra;
    private double valorMargem;
    private double precoSugerido;


    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setValorEtiqueta(double valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setValorMargem() {
        valorMargem = valorCompra * 2;
        this.valorMargem = valorMargem;
    }

    public void setPrecoSugerido(double precoSugerido) {
        this.precoSugerido = precoSugerido;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public double getValorEtiqueta() {
        return valorEtiqueta;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public double getValorMargem() {
        return valorMargem;
    }

    public double getPrecoSugerido() {
        return precoSugerido;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getCor() {
        return cor;
    }

    public int getTamanho() {
        return tamanho;
    }




}
