/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *Não uso mais
 * @author Ana
 */
public class Dado_Amostra {
    private String descricao;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Dado_Amostra{" + "descricao=" + descricao + ", valor=" + valor + '}';
    }

   
}
