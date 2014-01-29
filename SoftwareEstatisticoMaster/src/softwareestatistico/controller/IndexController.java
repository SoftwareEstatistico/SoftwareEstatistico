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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import model.Amostra;
import model.FrequenciaAbsoluta1;
import model.FrequenciaRelativa1;
import model.ValorAmostra;
import org.xml.sax.SAXException;
import threads.Curtose;
import threads.DesvioPadrao;
import threads.FrequenciaAbsoluta;
import threads.FrequenciaRelativa;
import threads.Max;
import threads.Media;
import threads.Mediana;
import threads.Min;
import threads.Moda;
import threads.Obliquidade;
import threads.Variancia;
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
   
    
    private ObservableList dados;
    private List<ValorAmostra> vlrs;
    private List<FrequenciaRelativa1> frs;
    @FXML//arrumar
    private void handleAbrirAction(ActionEvent event) throws IOException, SAXException {
        dados.addAll(OpenFile.getInstance().open());
    }
    
    @FXML
    private void handleAddAction(ActionEvent event) throws IOException, SAXException {
       ValorAmostra vlr=new ValorAmostra();
       vlr.setValor(Double.parseDouble(textValor.getText()));
//       vlrs.add(vlr);
       dados.add(vlr);
    }
    @FXML
    private void handleDelAction(ActionEvent event) throws IOException, SAXException {
       System.out.println("entra");
       ValorAmostra vlr;
       vlr=(ValorAmostra) lista_amostra.getSelectionModel().getSelectedItem();
//       vlrs.add(vlr);
       dados.remove(vlr);
    }
    @FXML
    private void handleSalvarAction(ActionEvent event) throws IOException, SAXException {
        Amostra amostra=new Amostra();
        for (ValorAmostra valorAmostra: vlrs) {
            amostra.setDados(valorAmostra);
        }
        SaveFile.getInstance().save(amostra);
    }
    @FXML
    private void handleChartAction(ActionEvent event) throws IOException, SAXException {
        Amostra amostra=new Amostra();
        for (ValorAmostra valorAmostra: vlrs) {
            amostra.setDados(valorAmostra);
        }
        //para gerar gráfico
        FrequenciaAbsoluta fa=new FrequenciaAbsoluta(amostra);
        fa.run();
        FrequenciaRelativa fr=new FrequenciaRelativa(amostra);
        fr.run();
        if(moda.isSelected()){
            Moda mo=new Moda(amostra);
            mo.run();
            System.out.println(amostra.getModa());
        }
        if(media.isSelected()){
            Media me=new Media(amostra);
            me.run();
            System.out.println(amostra.getMedia());
        }
        if(mediana.isSelected()){
           Mediana md=new Mediana(amostra);
           md.run();
           System.out.println(amostra.getMediana());
        }
        if(max.isSelected()){
            Max ma=new Max(amostra);
            ma.run();
            System.out.println(amostra.getMax());
        }
        if(min.isSelected()){
            Min mi=new Min(amostra);
            mi.run();
            System.out.println(amostra.getMin());
        }
        //curtose erro de execução para dados impar
        if(curtose.isSelected()){
            Curtose cu=new Curtose(amostra);
            cu.run();
            System.out.println(amostra.getCurtose());
        }
        if(obliquidade.isSelected()){
            Obliquidade ob=new Obliquidade(amostra);
            ob.run();
            System.out.println(amostra.getObliquidade());
        } 
        if(variancia.isSelected()){
            Variancia va=new Variancia(amostra);
            va.run();
            System.out.println(amostra.getVariancia());
        }
        if(dp.isSelected()){
            DesvioPadrao desvioPadrao=new DesvioPadrao(amostra);
            desvioPadrao.run();
            System.out.println(amostra.getDesvio_padrao());
        }
        resultText.setText(amostra.getFa().toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vlrs=new ArrayList<>();
        dados= FXCollections.observableList(vlrs);
        lista_amostra.setItems(dados);
    }    

}
