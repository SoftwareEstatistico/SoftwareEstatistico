/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsv;

import com.googlecode.jcsv.writer.CSVEntryConverter;
import model.ValorAmostra;

/**
 *
 * @author Ana
 */
public class ValorAmostraConverter implements CSVEntryConverter<ValorAmostra>{

    @Override
    public String[] convertEntry(ValorAmostra e) {
        String[] columns = new String[2];

        columns[0] = String.valueOf(e.getDate());
        columns[1] = String.valueOf(e.getValor());

        return columns;
    }
    
}
