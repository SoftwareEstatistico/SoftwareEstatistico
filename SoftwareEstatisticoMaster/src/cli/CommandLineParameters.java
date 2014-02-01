/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

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
    public static void main(String[] args) throws ParseException {
         CommandLineParser parser=new BasicParser();
         Options options=new Options();

         options.addOption("-c", "calculo",true,"resultados de media, mediana, maximo, minimo, moda, desvio_padrao,variancia,curtose e obliquidade.");
         CommandLine cl;
         cl=parser.parse(options, args);
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
