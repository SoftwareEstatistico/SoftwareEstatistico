/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import model.ValorAmostra;

/**
 *
 * @author Ana
 */
public class CsvController {
    
    private ValorAmostra valorAmostra;
  
    public  List<ValorAmostra> read(File file) throws FileNotFoundException, IOException{
        Reader in=new FileReader(file);
        
        CSVReader<ValorAmostra> valorReader = new CSVReaderBuilder<ValorAmostra>(in).entryParser(new ValorAmostraParser()).build();
        List<ValorAmostra> valores = valorReader.readAll();
        return valores;
    }

    public ValorAmostra getValorAmostra() {
        return valorAmostra;
    }
    public void write(String arqnome, List<ValorAmostra> vlrs) throws IOException{
        Writer out = new FileWriter(arqnome);

        CSVWriter<ValorAmostra> csvWriter = new CSVWriterBuilder<ValorAmostra>(out).entryConverter(new ValorAmostraConverter()).build();
        csvWriter.writeAll(vlrs);
        csvWriter.flush();
        csvWriter.close();
    }
//    public void add(String arqnome, ValorAmostra vlr) throws IOException{
//        List<ValorAmostra> vlrs=new ArrayList<>();
//        vlrs.addAll(read(arqnome));
//        vlrs.add(vlr);
//        Writer out = new FileWriter(arqnome);
//
//        CSVWriter<ValorAmostra> csvWriter = new CSVWriterBuilder<ValorAmostra>(out).entryConverter(new ValorAmostraConverter()).build();
//        csvWriter.writeAll(vlrs);
//        csvWriter.flush();
//        csvWriter.close();
//    }
    
}
