package br.edu.infnet.appFloricultura.business;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private LocalDateTime data;
    private boolean site;
    private Cliente cliente;
    
    public Venda(){
        this.data = LocalDateTime.now();
        this.site = Boolean.TRUE;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        return String.format("%s, %s, %s",
                this.getData().format(formato),
                this.site,
                this.cliente.toString());                
    }
    
    public LocalDateTime getData() {
        return data;
    }
    
    public boolean isSite() {
        return site;
    }
    
    public void setSite(boolean site){
        this.site = site;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    } 
      
}
