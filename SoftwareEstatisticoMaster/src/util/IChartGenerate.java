/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Amostra;

/**
 *
 * @author Ana
 */
public interface IChartGenerate {
    public void stringstatica(Amostra amostra);
    public void stringsmax(boolean mostrar);
    public void stringsmin(boolean mostrar);
    public void stringsmedia(boolean mostrar);
    public void stringsmediana(boolean mostrar);
    public void stringsmoda(boolean mostrar);
    public void stringscurtose(boolean mostrar);
    public void stringsobliquidade(boolean mostrar);
    public void stringsdesviopadrao(boolean mostrar);
    public String getstrings();
}
