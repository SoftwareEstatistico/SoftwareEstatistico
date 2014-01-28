/*
 * frameworks a serem utilizados: collections, slf4j; junit, easymock, cli, digester+betwixt, javafx, multi-thread para os cálculos
implementar app com gui JavaFX2 e shell cli
carregar o conjunto de dados a partir de um arquivo csv e xml
calcular estatísticas básicas para cada atributo
apresentar: histograma, média, mediana, desvio padrão, variância, moda, frequência absoluta e relativa, max, min, curtorse e obliquidade
gravar resultados em um arquivo xml
gerar/exportar gráficos com javafx
 */
package softwareestatistico.controller;

import calculo.Calculo;
import calculo.CalculoImpl;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import util.OpenFile;

/**
 *
 * @author Ana
 */
public class IndexController implements Initializable {
    
    @FXML
    private Button abrir;
    
    @FXML
    private TextField textFile;
    
    @FXML
    private TextArea textFileContent;
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private TextArea resultText;
    
    @FXML
    private ListView lista_amostra;
    
    private Stage stage=new Stage();
    private File file;
    private ObservableList amostras;
    @FXML
    private void handleAbrirExcelAction(ActionEvent event) throws IOException, SAXException {
        textFileContent.setText(OpenFile.getInstance().open());
        //ler arquivo excel e transformar em lista
        //passar a lista para o calculo
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // DOMConfigurator.configure("./src/indexcontroller.xml");
//        slf4j.info("Initializing IndexController");
        lista_amostra=new ListView(amostras);
    }    

//    public void setStageAndSetupListeners(Stage stage) {
//        this.stage=stage;
//    }
}
