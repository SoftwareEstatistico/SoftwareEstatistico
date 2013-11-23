/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import softwareestatistico.model.Calculo;
import softwareestatistico.model.CalculoImpl;

/**
 *
 * @author Ana
 */
public class IndexController implements Initializable {
    
    @FXML
    private Button abrirExcel;
    
    @FXML
    private TextField textExcel;
    
    @FXML
    private PieChart pieChart;
    
    @FXML
    private BubbleChart bubleChart;
    
    @FXML
    private LineChart lineChart;
    
    @FXML
    private ScatterChart scatterChart;
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private TableView tableExcel;
    
    @FXML
    private Text resultText;
    
    
    @FXML
    private void handleAbrirExcelAction(ActionEvent event) {
        FileChooser filechoose=new FileChooser();
        filechoose.setTitle("Abrir Amostra excel");
        Stage stage=(Stage) event.getSource();
        filechoose.showOpenDialog(stage);
        Calculo c=new CalculoImpl();
        //ler arquivo excel e transformar em lista
        //passar a lista para o calculo
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // DOMConfigurator.configure("./src/indexcontroller.xml");
//        slf4j.info("Initializing IndexController");
    }    
}
