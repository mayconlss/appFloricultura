package br.edu.infnet.appFloricultura.business;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.infnet.appFloricultura.exception.PesoInvalidoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class SementeTeste {
    
    @Test
    void testandoInstanciaToString() throws PesoInvalidoException{
        Semente semente = new Semente("Tomate", 15, Boolean.TRUE);
        semente.setEmbalagem("Granel");
        semente.setPeso(50);
        
        assertTrue("Tomate;15.0;true;50.0; Granel".equals(semente.toString()));
    }
    
    @Test
    void testandoCalcularVenda() throws PesoInvalidoException{
        Semente semente = new Semente("Tomate", 15, Boolean.TRUE);
        semente.setEmbalagem("Granel");
        semente.setPeso(50);
        
        assertEquals(semente.calcularVenda(), 21.5);
    }
    
    @Test
    void testandoPesoInvalido(){
        try{
        Semente semente = new Semente("Tomate", 15, Boolean.TRUE);
        semente.setEmbalagem("Granel");
        semente.setPeso(-25);
        } catch (PesoInvalidoException e) {
            assertEquals("Peso inválido.", e.getMessage());
        }
    }
    
    @Test
    void testandoObterPrecoUnidade () throws PesoInvalidoException{
        Semente semente = new Semente("Tomate", 15, Boolean.TRUE);
        semente.setEmbalagem("Granel");
        semente.setPeso(50);
        
        String result = "Tomate;21.5\r";
        
        assertEquals(semente.obterPrecoUnidade(), result);
    }
    
}
