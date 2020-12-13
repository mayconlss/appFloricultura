package br.edu.infnet.appFloricultura.business;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.infnet.appFloricultura.exception.CorInvalidaException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class PlantaTeste {
    
    @Test
    void testandoInstanciaToString() throws CorInvalidaException {
        Planta planta = new Planta("Flor Cadáver", 10, Boolean.FALSE);
        planta.setRara(Boolean.TRUE);
        planta.setCor("Roxa");
        
        assertTrue("Flor Cadáver;10.0;false;true;Roxa".equals(planta.toString()));
    }
    
    @Test
    void testandoCalcularVenda() throws CorInvalidaException {
        Planta planta = new Planta("Flor Cadáver", 10, Boolean.FALSE);
        planta.setRara(Boolean.TRUE);
        planta.setCor("Roxa");
        
        assertEquals(planta.calcularVenda(), 18);
    }
    
    @Test
    void testandoCorInvalida() {
        try {
        Planta planta = new Planta("Flor Cadáver", 10, Boolean.FALSE);
        planta.setRara(Boolean.TRUE);
        planta.setCor(null);
        } catch(CorInvalidaException e) {
            assertEquals("Cor inválida.", e.getMessage());            
        }
    }
    
    @Test
    void testandoObterPrecoUnidade() throws CorInvalidaException {
        Planta planta = new Planta("Flor Cadáver", 10, Boolean.FALSE);
        planta.setRara(Boolean.TRUE);
        planta.setCor("Roxa");
        
        String result = "Flor Cadáver;18.0\r";
        
        assertEquals(planta.obterPrecoUnidade(), result);
    }
    
}
