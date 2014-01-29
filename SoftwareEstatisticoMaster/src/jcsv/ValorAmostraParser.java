/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsv;

import com.googlecode.jcsv.reader.CSVEntryParser;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ValorAmostra;

/**
 *
 * @author Ana
 */
public class ValorAmostraParser implements CSVEntryParser<ValorAmostra>{

    @Override
    public ValorAmostra parseEntry(String... strings) {
        try {
            if (strings.length != 2) {
                throw new IllegalArgumentException("data is not a valid person record");
              }

              DateFormat formatter = new SimpleDateFormat("yyyy-m-d hh:mm:ss");  
              Date date = (Date)formatter.parse(strings[0]);  
              Double valor =Double.parseDouble(strings[1]);

              return new ValorAmostra(valor,date);
        } catch (ParseException ex) {
            Logger.getLogger(ValorAmostraParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
