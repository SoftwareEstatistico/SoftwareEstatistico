/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    
    public void save() throws IOException{
        stage=new Stage();
        filechoose=new FileChooser();
        filechoose.setTitle("Salvar Arquivo");
        filechoose.setInitialFileName("amostra.xml");
        List<String> list=new ArrayList<>();
        list.add(".xml");
        list.add(".csv");
        FileChooser.ExtensionFilter ext=new FileChooser.ExtensionFilter("extensoes", list);
        filechoose.getExtensionFilters().add(ext);
        try{
            filechoose.showSaveDialog(stage).createNewFile();
        }catch(Exception e){
        }
    }
}
