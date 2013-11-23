/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareestatistico.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
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
    
    private Stage stage=new Stage();
    private File file;
    
    @FXML
    private void handleAbrirExcelAction(ActionEvent event) {
        FileChooser filechoose=new FileChooser();
        filechoose.setTitle("Abrir Amostra excel");
        this.file=filechoose.showOpenDialog(this.stage);
        textExcel.setText(this.file.getName());
        Calculo c=new CalculoImpl();
        //ler arquivo excel e transformar em lista
        //passar a lista para o calculo
    }
    //abrir excel
    public void lerXsl(File file){
        try {
            Workbook workbook=Workbook.getWorkbook(file);
            Sheet sheet=workbook.getSheet(0);
            int linhas=sheet.getRows();
            int colunas=sheet.getColumns();
            for(int j=0;j<colunas;j++){
                for(int i=0;i<linhas;i++){
                    Cell cell=sheet.getCell(j,i);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // DOMConfigurator.configure("./src/indexcontroller.xml");
//        slf4j.info("Initializing IndexController");
    }    

//    public void setStageAndSetupListeners(Stage stage) {
//        this.stage=stage;
//    }
}
