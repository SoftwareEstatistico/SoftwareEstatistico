/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra;

import java.util.List;

/**
 *
 * @author Ana
 */
public class Amostra {
    private String nome;
    private List<Dado_Amostra> amostra;
    private double f_absoluta;
    private double f_relativa;
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

    public Amostra(String nome, List<Dado_Amostra> amostra, double f_absoluta, double f_relativa, double moda, double mediana, double media, double curtose, double obliquidade, double variancia, double desvio_padrao, double amplitude, double max, double min) {
        this.nome = nome;
        this.amostra = amostra;
        this.f_absoluta = f_absoluta;
        this.f_relativa = f_relativa;
        this.moda = moda;
        this.mediana = mediana;
        this.media = media;
        this.curtose = curtose;
        this.obliquidade = obliquidade;
        this.variancia = variancia;
        this.desvio_padrao = desvio_padrao;
        this.amplitude = amplitude;
        this.max = max;
        this.min = min;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getF_absoluta() {
        return f_absoluta;
    }

    public void setF_absoluta(double f_absoluta) {
        this.f_absoluta = f_absoluta;
    }

    public double getF_relativa() {
        return f_relativa;
    }

    public void setF_relativa(double f_relativa) {
        this.f_relativa = f_relativa;
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

    public List<Dado_Amostra> getAmostra() {
        return amostra;
    }

    public void setAmostra(List<Dado_Amostra> amostra) {
        this.amostra = amostra;
    }
    
}
