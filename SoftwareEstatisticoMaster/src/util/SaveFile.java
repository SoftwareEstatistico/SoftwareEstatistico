/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
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
        filechoose.showSaveDialog(stage).createNewFile();
    }
}
