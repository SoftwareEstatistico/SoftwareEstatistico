/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shellcli;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import cli.CommandLineParameters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Amostra;
import model.ValorAmostra;
import util.ChartGenerate;

/**
 *
 * @author Ana
 */
public class ClieShellParser {
    private Amostra amostra;
    private List<Double> vlrs;
    private CommandLineParameters clp=new CommandLineParameters();
    
    @Command
    public String nova(){
        vlrs=new ArrayList<>();
        amostra=new Amostra();
        return clp.getOptions().getOption("nova").getDescription();
    } 
    
    @Command
    public String add(double v){
       vlrs.add(v);
       return clp.getOptions().getOption("add").getDescription();
    }

    private void gerarString(){
        ChartGenerate.getInstance().stringstatica(amostra);
        ChartGenerate.getInstance().stringsdesviopadrao(true);
        ChartGenerate.getInstance().stringscurtose(true);
        ChartGenerate.getInstance().stringsmax(true);
        ChartGenerate.getInstance().stringsmin(true);
        ChartGenerate.getInstance().stringsmedia(true);
        ChartGenerate.getInstance().stringsmediana(true);
        ChartGenerate.getInstance().stringsmoda(true);
        ChartGenerate.getInstance().stringsobliquidade(true);
        ChartGenerate.getInstance().stringsvariancia(true);
    }
    @Command
    public String calculo(){
        try{
            
            for(Double d:vlrs){
                ValorAmostra v=new ValorAmostra();
                v.setValor(d);
                amostra.setDados(v);
            }
            gerarString();
            return ChartGenerate.getInstance().getstrings();
        }catch(Exception e){
            return e.toString();
        }
    } 
    @Command
    public String help(){
        StringBuilder sb=new StringBuilder();
        sb.append("Help: \n");
        sb.append(clp.getOptions().getOption("help").getOpt()+":");
        sb.append(clp.getOptions().getOption("help").getDescription());
        sb.append("\n");
        sb.append(clp.getOptions().getOption("add").getOpt()+":");
        sb.append(clp.getOptions().getOption("add").getDescription());
        sb.append("\n");
        sb.append(clp.getOptions().getOption("calculo").getOpt()+":");
        sb.append(clp.getOptions().getOption("calculo").getDescription());
        sb.append("\n");
        sb.append(clp.getOptions().getOption("nova").getOpt()+":");
        sb.append(clp.getOptions().getOption("nova").getDescription());
        sb.append("\n");
        sb.append(clp.getOptions().getOption("sair").getOpt()+":");
        sb.append(clp.getOptions().getOption("sair").getDescription());
        sb.append("\n");
        return sb.toString();
    }
    @Command
    public void sair(){
        System.exit(0);
    }
    public static void exec() throws IOException {
             ShellFactory.createConsoleShell("clieShell", "ClieShellParser", new ClieShellParser())
            .commandLoop(); // and three.
    }
    
}
