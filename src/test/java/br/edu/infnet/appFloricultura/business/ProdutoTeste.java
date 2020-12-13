package br.edu.infnet.appFloricultura.business;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTeste {
    
    @Test
    void testandoPlanta() {
        Planta planta = null;
        planta = new Planta("Rosa", 20, Boolean.FALSE);
        
        assertNotNull(planta);
    }
    
    @Test
    void testandoAdubo() {
        Adubo adubo = null;
        adubo = new Adubo("Esterco", 15, Boolean.TRUE);
        
        assertNotNull(adubo);
    }
    
    @Test
    void testandoSemente() {
        Semente semente = null;
        semente = new Semente("Tomate", 20, Boolean.FALSE);
        
        assertNotNull(semente);
    }
    
}
