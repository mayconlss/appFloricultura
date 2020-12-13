package br.edu.infnet.appFloricultura.business;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTeste {
    
    @Test
    void testandoInstancia(){
        Cliente c = new Cliente ("ProfessorGirafales", "12345678901", "fales@gira.com");
        
        assertNotNull(c);
    }
     
    @Test
    void testandoToString(){
        Cliente c = new Cliente ("ProfessorGirafales", "12345678901", "fales@gira.com");
        
        assertTrue("ProfessorGirafales;12345678901;fales@gira.com".equals(c.toString()));   
    }     
}
