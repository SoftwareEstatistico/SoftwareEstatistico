/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellcli;

import calculo.Calculo;
import calculo.CalculoImpl;
import cli.CommandLineParameters;
import java.io.PrintStream;
import java.util.StringTokenizer;
import model.Amostra;
import model.ValorAmostra;
import org.apache.commons.cli.Option;

/**
 *
 * @author Ana
 */
public class SoftEstShell implements Runnable{
    private String args[]=null;
    private CommandLineParameters clp;
    private StringBuilder sb=new StringBuilder();
    private Amostra amostra;
    Calculo calculo;
    
    public SoftEstShell() {
        clp=new CommandLineParameters();
    }
    
    public String[] execute(String line) {
        StringTokenizer st = new StringTokenizer(line, " ");
        // Ignore the command name.
        st.nextToken();

        // There should be at least one bundle id.
        if (st.countTokens() >= 1)
        {
            while (st.hasMoreTokens())
            {
                int i=0;
                String id = st.nextToken().trim();
                args[i]=id;
                if(args[0].equals("-c")||args[0].equals("-calculo")){
                    double aux=Double.parseDouble(args[i]);
                    if(aux!=Double.NaN){
                        amostra=new Amostra();
                        ValorAmostra v=new ValorAmostra();
                        v.setValor(aux);
                        amostra.setDados(v);
                    }
                }
                i++;        
            }
        }
        else
        {
            System.out.println("Incorrect number of arguments");
        }
        return args;
    }

    public StringBuilder getSb() {
        return sb;
    }
    
    @Override
    public void run() {
        boolean continua=true;
        Option option;
        while(continua){
            sb.append("softEst>");
            if(clp.getOptions().hasOption(args[0])){
               option=clp.getOptions().getOption(args[0]);
               if(option.hasArgs()&&option.getOpt().equals("s")){
                   sb.append("tchau");
                   continua=false;
               }
               if(option.hasArgs()&&option.getOpt().equals("a")){
                   sb.append("amostra");
                   sb.append(amostra.getDados());
               }
               if(option.hasArgs()&&option.getOpt().equals("h")){
                   sb.append("help");
                   sb.append(option.getDescription());
               }
               if(option.hasArgs()&&option.getOpt().equals("c")){
                    sb.append("calculo");
                    sb.append("Resultado:");
                    sb.append("Max:"+amostra.getMax());
                    sb.append("Min:"+amostra.getMin());
                    sb.append("Media:"+amostra.getMedia());
                    sb.append("Mediana:"+amostra.getMediana());
                    sb.append("Moda:"+amostra.getModa());
                    sb.append("Desvio Padrao:"+amostra.getDesvio_padrao());
                    sb.append("Variancia:"+amostra.getVariancia());
               }
            }
        }
    }
    public void calcular(){
             calculo=new CalculoImpl();
             calculo.amplitude(amostra);
             calculo.desviopadrao(amostra);
             calculo.max(amostra);
             calculo.min(amostra);
             calculo.media(amostra);
             calculo.mediana(amostra);
             calculo.variancia(amostra);
             calculo.moda(amostra);
    }
    
}
