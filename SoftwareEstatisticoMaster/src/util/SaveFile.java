/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import betwixt.Create;
import calculo.Calculo;
import calculo.CalculoImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jcsv.CsvController;
import model.Amostra;
import threads.FrequenciaAbsoluta;
import threads.FrequenciaRelativa;

/**
 *
 * @author Ana
 */
public class SaveFile {
    private static SaveFile instance;
    private File file;
    private Stage stage;
    private FileChooser filechoose;

    private SaveFile() {
    }

    public static SaveFile getInstance() {
        if(instance==null)
            if(instance==null)
                instance=new SaveFile();
        return instance;
    }
    
    public void save(Amostra amostra) throws IOException{
        stage=new Stage();
        filechoose=new FileChooser();
        filechoose.setTitle("Salvar Arquivo");
        filechoose.setInitialFileName("amostra.xml");
        List<String> list=new ArrayList<>();
        list.add(".xml");
        list.add(".csv");
        FileChooser.ExtensionFilter ext=new FileChooser.ExtensionFilter("extensoes", list);
        filechoose.getExtensionFilters().add(ext);
        File f;
        try{
//            filechoose.showSaveDialog(stage).createNewFile();
            f=filechoose.showSaveDialog(stage);
            //se arquivo não existir
            if(!f.exists()){
                //save csv dados
                CsvController csv=new CsvController();
                String change=f.getName();
                if(change.endsWith(".xml"))
                    change=change.replace(".xml", ".csv");
                csv.write(change, amostra.getDados());
                resultados(amostra);
                //save xml
                if(change.endsWith(".csv"))
                    change=change.replace(".csv", ".xml");
                Create.createxml(change, amostra);
            }
        }catch(Exception e){
        }
    }
    public void resultados(Amostra amostra){
         //save xml dados + amostra resultados
                Calculo calculo=new CalculoImpl();
                calculo.amplitude(amostra);
                calculo.desviopadrao(amostra);
                calculo.max(amostra);
                calculo.media(amostra);
                calculo.mediana(amostra);
                calculo.min(amostra);
                calculo.variancia(amostra);
                calculo.obliquidade(amostra);
                calculo.curtose(amostra);
                calculo.moda(amostra);
                FrequenciaAbsoluta fa=new FrequenciaAbsoluta(amostra);
                fa.run();
                FrequenciaRelativa fr=new FrequenciaRelativa(amostra);
                fr.run();
    }
}
