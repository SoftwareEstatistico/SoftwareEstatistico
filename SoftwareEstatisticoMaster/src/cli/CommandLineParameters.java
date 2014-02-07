/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import calculo.Calculo;
import calculo.CalculoImpl;
import model.Amostra;
import model.ValorAmostra;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author Ana
 */
public class CommandLineParameters {
    public Options getOptions(){
         Options options=new Options();
         options.addOption("calculo",false,"resultados de media, mediana, maximo, minimo, moda, desvio_padrao,variancia,curtose, frequências, variâncias e obliquidade.");
         options.addOption("help",false,"instruções para uso de comandos");
         options.addOption("nova",true,"criar uma nova amostra");
         options.addOption("add",true,"adicionar á amostra");
         options.addOption("sair",true,"finalizar o programa");
         return options;
    }
    public static void main(String[] args) throws ParseException {
         CommandLineParser parser=new BasicParser();
         Options options=new Options();

         options.addOption("c", "calculo",true,"resultados de media, mediana, maximo, minimo, moda, desvio_padrao,variancia,curtose e obliquidade.");
         CommandLine cl;
         cl=parser.parse(options, args);
         if(options.hasOption("-c")){
             Amostra amostra=new Amostra();
             for(int i=0;i<args.length-1;i++){
                ValorAmostra v1=new ValorAmostra();
                v1.setValor(Double.parseDouble(args[i]));
                amostra.setDados(v1);
             }
             Calculo calculo=new CalculoImpl();
             calculo.amplitude(amostra);
             calculo.desviopadrao(amostra);
             calculo.max(amostra);
             calculo.min(amostra);
             calculo.media(amostra);
             calculo.mediana(amostra);
             calculo.variancia(amostra);
             calculo.moda(amostra);
             System.out.println("Resultado:");
             System.out.println("Max:"+amostra.getMax());
             System.out.println("Min:"+amostra.getMin());
             System.out.println("Media:"+amostra.getMedia());
             System.out.println("Mediana:"+amostra.getMediana());
             System.out.println("Moda:"+amostra.getModa());
             System.out.println("Desvio Padrao:"+amostra.getDesvio_padrao());
             System.out.println("Variancia:"+amostra.getVariancia());
         }
//         options.addOption("-me", "media");
//         options.addOption("-md", "mediana");
//         options.addOption("-max", "maximo");
//         options.addOption("-min", "minimo");
//         options.addOption("-moda", "moda");
//         options.addOption("-dp", "desvio_padrao");
//         options.addOption("-v", "variancia");
//         options.addOption("-c", "curtose");
//         options.addOption("-o", "obliquidade");
         
    }
}
