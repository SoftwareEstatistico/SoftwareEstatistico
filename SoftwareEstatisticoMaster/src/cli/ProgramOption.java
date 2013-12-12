/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import amostra.Amostra;
import amostra.Dado_Amostra;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import softwareestatistico.model.Calculo;


/**
 *
 * @author Ana
 */
public class ProgramOption {
    private Options options;
    private Calculo calculo;
    private Amostra amostra;
    private List<Double> lista_vrl_amostra=new ArrayList();
    private List<Dado_Amostra> lista_dados=new ArrayList();
    public ProgramOption() {
        try {
            options = new Options();
//            calculo = new CalculoImpl();
//            File f=new File("C:\\Users\\Ana\\Documents\\NetBeansProjects\\SoftwareEstatisticoDigester\\SoftwareEstatisticoMaster\\xml\\amostra.xml");
//            amostra=Read.leitura(f);
//            System.out.println("teste"+amostra.toString());
//            lista_dados.addAll(amostra.getAmostra());
//            for(int i=0;i<lista_dados.size();i++){
//                lista_vrl_amostra.add(lista_dados.get(i).getValor());
//            }
//            calculo.setAmostra(lista_vrl_amostra);
            default_options();
        } catch (Exception ex) {
            Logger.getLogger(ProgramOption.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void default_options(){
//  Option logfile   = OptionBuilder.withArgName( "file" )
//                                .hasArg()
//                                .withDescription(  "use given file for log" )
//                                .create( "logfile" );

        options.addOption("moda",false,"");
        options.addOption("mediana",false,"");
        options.addOption("media",false,"");
        
//        ...
    }
    public void create_option(String nome,boolean hasarg,String descricao){
//        options.addOption(nome,hasarg, descricao);
    }
    public void cmd_behavior(String args[],String option){
        try {
            CommandLineParser parser=new BasicParser();
            CommandLine cmd=parser.parse(options, args);
            if(cmd.hasOption(option)){
                switch(option){
                    case "moda":
                        System.out.println(calculo.moda());
                        break;
                    case "mediana":
                        System.out.println(calculo.mediana());
                        break;
                    case "media":
                        System.out.println(calculo.media());
                        break;
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(ProgramOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
