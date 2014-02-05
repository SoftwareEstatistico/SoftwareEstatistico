/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellcli;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Ana
 */
public class ShellController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextArea shell;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SoftEstShell ses=new SoftEstShell();
        ses.execute(shell.getText());
    }    
}
