package log;

import java.util.ArrayList;
import java.util.List;

public class LogErros {
    
    public static void main(String[] args) {
        
        List<String> maquinas = new ArrayList<>();
        Boolean deuErro = false;
        
        maquinas.add("Maquina1");
        maquinas.add("Maquina2");
        
        if(!deuErro) {
            deuErro = true;
            System.out.println(String.format("%s-data-LOG.txt", maquinas.get(0)));
        }
    }
    
}
