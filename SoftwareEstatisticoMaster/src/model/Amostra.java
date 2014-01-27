/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ana
 */
public class Amostra {
    private String nome;
//    private List<Dado_Amostra> dados=new ArrayList<>();
    private List<ValorAmostra> dados=new ArrayList<>();
    private List<FrequenciaAbsoluta1> fa=new ArrayList<>();
    private List<FrequenciaRelativa1> fr=new ArrayList<>();
    private double moda;
    private double mediana;
    private double media;
    private double curtose;
    private double obliquidade;
    private double variancia;
    private double desvio_padrao;
    private double amplitude;
    private double max;
    private double min;

    public Amostra() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<FrequenciaAbsoluta1> getFa() {
        return fa;
    }

    public void setFa(FrequenciaAbsoluta1 fa) {
        this.fa.add(fa); 
    }

    public List<FrequenciaRelativa1> getFr() {
        return fr;
    }

    public void setFr(FrequenciaRelativa1 fr) {
        this.fr.add(fr);
    }


    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getCurtose() {
        return curtose;
    }

    public void setCurtose(double curtose) {
        this.curtose = curtose;
    }

    public double getObliquidade() {
        return obliquidade;
    }

    public void setObliquidade(double obliquidade) {
        this.obliquidade = obliquidade;
    }

    public double getVariancia() {
        return variancia;
    }

    public void setVariancia(double variancia) {
        this.variancia = variancia;
    }

    public double getDesvio_padrao() {
        return desvio_padrao;
    }

    public void setDesvio_padrao(double desvio_padrao) {
        this.desvio_padrao = desvio_padrao;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setDados(ValorAmostra dados) {
        this.dados.add(dados);
    }

    public List<ValorAmostra> getDados() {
        return dados;
    }
    public List<Double> valores_ordenados_amostra(){
        List<Double> l=new ArrayList<>();
        for(int i=0;i<dados.size();i++){
            l.add(dados.get(i).getValor());
        }
        Collections.sort(l);
        return l;
    }
    @Override
    public String toString() {
        return "Amostra{" + "nome=" + nome + ", dados=" + dados + ", f_absoluta=" + fa+ ", f_relativa=" + fr + ", moda=" + moda + ", mediana=" + mediana + ", media=" + media + ", curtose=" + curtose + ", obliquidade=" + obliquidade + ", variancia=" + variancia + ", desvio_padrao=" + desvio_padrao + ", amplitude=" + amplitude + ", max=" + max + ", min=" + min + '}';
    }
    
}
