package br.edu.infnet.appFloricultura.business;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VendaTeste {
    
    @Test
    void testandoAssociacao(){
        Cliente cliente = new Cliente("ProfessorGirafales", "12345678901", "fales@gira.com");
        
        Venda venda = new Venda();
        venda.setCliente(cliente);
        
        assertTrue(cliente.equals(venda.getCliente()));
    }
    
    @Test
    void testandoSite(){
        Cliente cliente = new Cliente("ProfessorGirafales", "12345678901", "fales@gira.com");
        
        Venda venda = new Venda();
        venda.setCliente(cliente);
        
        assertTrue(venda.isSite());
    }
    
    @Test
    void testandoMobile(){
        Cliente cliente = new Cliente("ProfessorGirafales", "12345678901", "fales@gira.com");
        
        Venda venda = new Venda();
        venda.setSite(Boolean.FALSE);
        venda.setCliente(cliente);
        
        assertFalse(venda.isSite());
    }
    
    @Test
    void testandoToString(){
        Cliente cliente = new Cliente("ProfessorGirafales", "12345678901", "fales@gira.com");
        
        Venda venda = new Venda();
        venda.setSite(Boolean.FALSE);
        venda.setCliente(cliente);
        
        DateTimeFormatter formatoHoje = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime hoje = LocalDateTime.now();
        
        String descricaoVenda = hoje.format(formatoHoje)+";false;ProfessorGirafales;12345678901;fales@gira.com";
        
        assertTrue(descricaoVenda.equals(venda.toString()));        
    }
    
}
