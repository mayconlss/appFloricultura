package br.edu.infnet.appFloricultura.business;

public abstract class Produto {
    private String info;
    private float preco;
    private boolean producaoOrganica;
    
    public Produto(String descricao, float preco, boolean producaoOrganica){
        this.info = info;
        this.preco = preco;
        this.producaoOrganica = producaoOrganica;
    }
    
    public abstract float calcularVenda();
    
    public String obterPrecoUnidade() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getInfo());
        sb.append(";");
        sb.append(this.calcularVenda());
        sb.append("\r");
        
        return sb.toString();        
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getInfo());
        sb.append(";");
        sb.append(this.getPreco());
        sb.append(";");
        sb.append(this.isProducaoOrganica());
        
        return sb.toString();
    }
    
    public String getInfo(){
        return info;
    }
    
    public float getPreco() {
        return preco;
    }
    
    public boolean isProducaoOrganica(){
        return producaoOrganica;
    } 
    
}
