/*
 * frameworks a serem utilizados: collections, slf4j; junit, easymock, cli, digester+betwixt, javafx, multi-thread para os cálculos
implementar app com gui JavaFX2 e shell cli
carregar o conjunto de dados a partir de um arquivo csv e xml
calcular estatísticas básicas para cada atributo
apresentar: histograma, média, mediana, desvio padrão, variância, moda, frequência absoluta e relativa, max, min, curtorse e obliquidade
gravar resultados em um arquivo xml
gerar/exportar gráficos com javafx
* 
* fazer shell 
* easymock
* 
* salvar xml somente quando gerar resultados
* pegar resultados quando abrir arquivo
* formatar saidas
 */
package softwareestatistico.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Amostra;
import model.FrequenciaAbsoluta1;
import model.FrequenciaRelativa1;
import model.ValorAmostra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import util.ChartGenerate;
import util.Open;
import util.OpenFile;
import util.SaveFile;

/**
 *
 * @author Ana
 */
public class IndexController implements Initializable {
    
    @FXML
    private Button abrir;
    @FXML
    private Button salvar;
    @FXML
    private Button delete;
    @FXML
    private Button add;
    
    @FXML
    private Button gerar;
    
    @FXML
    private TextField textFile;
    @FXML
    private TextField textValor;
    
    @FXML
    private TextArea resultText;
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private ListView lista_amostra;
    
    @FXML
    private CheckBox max;
    @FXML
    private CheckBox min;
    @FXML
    private CheckBox moda;
    @FXML
    private CheckBox media;
    @FXML
    private CheckBox mediana;
    @FXML
    private CheckBox curtose;
    @FXML
    private CheckBox obliquidade;
    @FXML
    private CheckBox dp;
    @FXML
    private CheckBox variancia;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    
    private ObservableList charty=FXCollections.observableArrayList();
    private ObservableList chartx=FXCollections.observableArrayList();
    private ObservableList dados;
    private List<ValorAmostra> vlrs;
    private List<FrequenciaRelativa1> frs;
    //slf4j
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    //Falta salvar o xml 
    public XYChart.Series<String,Double> createSeries(List<FrequenciaRelativa1> lfr){
        logger.info("createSeries");
        XYChart.Series<String,Double> series=new XYChart.Series<String,Double>();
        for (int i = 0; i < lfr.size(); i++) {
            XYChart.Data<String,Double> hdata=new XYChart.Data<String, Double>(String.valueOf(lfr.get(i).getKey()),lfr.get(i).getValue());
            series.getData().add(hdata);
        }
        return series;
    }
    public XYChart.Series<String,Integer> createSeries2(List<FrequenciaAbsoluta1> lfa){
        logger.info("createSeries2");
        XYChart.Series<String,Integer> series=new XYChart.Series<String,Integer>();
        for (int i = 0; i < lfa.size(); i++) {
            XYChart.Data<String,Integer> hdata=new XYChart.Data<String, Integer>(String.valueOf(lfa.get(i).getKey()),lfa.get(i).getValue());
            series.getData().add(hdata);
        }
        return series;
    }
    
    @FXML//arrumar
    private void handleAbrirAction(ActionEvent event) throws IOException, SAXException {
        logger.info("handleAbrirAction");
        try{
        Open open=new Open(OpenFile.getInstance().open(),dados);
        open.run();
        }catch(Exception e){
            logger.error(e.getMessage());
        }
//        dados.addAll();
        
    }
    
    @FXML
    private void handleAddAction(ActionEvent event) throws IOException, SAXException {
       logger.info("handleAddAction");  
       try{ 
           String aux=makedouble(textValor.getText());
           if(!aux.equals("")){
            ValorAmostra vlr=new ValorAmostra();
            
            vlr.setValor(Double.parseDouble(aux));
     //       vlrs.add(vlr);
            dados.add(vlr);
           }else{
                logger.error("NaN digitado em TextValue");
                Dialogs.showErrorDialog(new Stage(), "Permitido apenas números");
           }
       }catch(Exception e){
           logger.error(e.getMessage());
       }
    }
    @FXML
    private void handleDelAction(ActionEvent event) throws IOException, SAXException {
       logger.info("handleDelAction"); 
       try{
       ValorAmostra vlr;
       vlr=(ValorAmostra) lista_amostra.getSelectionModel().getSelectedItem();
//       vlrs.add(vlr);
       dados.remove(vlr);
       }catch(Exception e){
           logger.error(e.getMessage());
       }
    }
    @FXML
    private void handleSalvarAction(ActionEvent event) throws IOException, SAXException {
        logger.info("handleSalvarAction");
        try{
        Amostra amostra=new Amostra();
        for (ValorAmostra valorAmostra: vlrs) {
            amostra.setDados(valorAmostra);
        }
        SaveFile.getInstance().save(amostra);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }
    @FXML
    private void handleChartAction(ActionEvent event) throws IOException, SAXException {
        logger.info("handleChartAction");
        try{
        Amostra amostra=new Amostra();
        for (ValorAmostra valorAmostra: vlrs) {
            amostra.setDados(valorAmostra);
        }
        //curtose e moda estao dando erro
        //para gerar gráfico
        ChartGenerate.getInstance().stringstatica(amostra);
        ChartGenerate.getInstance().stringscurtose(curtose.isSelected());
        ChartGenerate.getInstance().stringsdesviopadrao(dp.isSelected());
        ChartGenerate.getInstance().stringsmax(max.isSelected());
        ChartGenerate.getInstance().stringsmedia(media.isSelected());
        ChartGenerate.getInstance().stringsmediana(mediana.isSelected());
        ChartGenerate.getInstance().stringsmin(min.isSelected());
        ChartGenerate.getInstance().stringsmoda(moda.isSelected());
        ChartGenerate.getInstance().stringsobliquidade(obliquidade.isSelected());
        resultText.setText(ChartGenerate.getInstance().getstrings());
      
        x.setLabel("Valor");
        y.setLabel("Frequência");
        barChart.setTitle("Histograma");
        XYChart.Series<String,Double> series=createSeries(amostra.getFr());
        XYChart.Series<String,Integer> series2=createSeries2(amostra.getFa());
        barChart.getData().add(series2);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }
    public String makedouble(String verify){
        String aux=verify;
        if(verify.contains(",")){
            aux=verify.replace(",", ".");
        }
        else if(Double.isNaN(Double.parseDouble(verify))){
            textValor.clear();
            aux="";
        }
        return aux;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vlrs=new ArrayList<>();
        dados= FXCollections.observableList(vlrs);
        lista_amostra.setItems(dados);
       
        logger.info("initialize");
    }    

}
