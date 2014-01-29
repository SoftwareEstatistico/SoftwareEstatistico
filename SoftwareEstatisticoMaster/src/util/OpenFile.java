/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import digester.Read;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jcsv.CsvController;
import model.ValorAmostra;
import org.xml.sax.SAXException;

/**
 *
 * @author Ana
 */
public class OpenFile {
    private File file;
    private Stage stage;
    private FileChooser filechoose;
    private SalvarCSV readcsv=new SalvarCSV();
    private static OpenFile instance;
    
    private OpenFile() {
    }

    public static OpenFile getInstance() {
        if(instance==null)
            if(instance==null)
                instance=new OpenFile();
        return instance;
    }
    
    
    public List<ValorAmostra> open() throws IOException, SAXException{
        stage=new Stage();
        filechoose=new FileChooser();
        filechoose.setTitle("Abrir Arquivo");
        file=filechoose.showOpenDialog(stage);
        CsvController csv=new CsvController();
        if(file.getName().endsWith(".xml")){
           return Read.leitura(file).getDados();
        }else if(file.getName().endsWith(".csv")){
           return csv.read(file.getPath());
        }
        return null;
    }
    
}
