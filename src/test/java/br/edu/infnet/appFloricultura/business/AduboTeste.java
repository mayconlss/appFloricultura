package br.edu.infnet.appFloricultura.business;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.infnet.appFloricultura.exception.SacoInvalidoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class AduboTeste {
    
    @Test
    void testandoInstanciaToString() throws SacoInvalidoException {
        Adubo adubo = new Adubo("Esterco", 30, Boolean.TRUE);
        adubo.setSaco(3);
        adubo.setCompacto(Boolean.FALSE);
        
        assertTrue("Esterco; 30.0;true;3;false".equals(adubo.toString()));
    }
    
    @Test
    void testandoCalcularVenda() throws SacoInvalidoException {
        Adubo adubo = new Adubo("Esterco", 30, Boolean.TRUE);
        adubo.setSaco(3);
        adubo.setCompacto(Boolean.FALSE);
        
        assertEquals(adubo.calcularVenda(), 124);
    }
    
    @Test
    void testandoSacoInvalido() {
        try {
            Adubo adubo = new Adubo("Esterco", 30, Boolean.TRUE);
            adubo.setSaco(0);
            adubo.setCompacto(Boolean.FALSE);
        } catch (SacoInvalidoException e) {
            assertEquals(e.getMessage(), "Quantidade de sacos inválida.");
        } 
    }
    
    @Test
    void testandoObterPrecoUnidade() throws SacoInvalidoException {
        Adubo adubo = new Adubo("Esterco", 30, Boolean.TRUE);
        adubo.setSaco(3);
        adubo.setCompacto(Boolean.FALSE);
        
        String result = "Esterco; 124.0\r";
        
        assertEquals(adubo.obterPrecoUnidade(), result);
    }
    
}
