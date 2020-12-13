package br.edu.infnet.appFloricultura.business;
import br.edu.infnet.appFloricultura.exception.SacoInvalidoException;

public class Adubo extends Produto {
    
    private int saco;
    private boolean compacto;
    
    public Adubo(String info, float preco, boolean producaoOrganica){
        super (info, preco, producaoOrganica);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.getSaco());
        sb.append(";");
        sb.append(this.isCompacto());
        
        return sb.toString();
    }
    
    @Override
    public float calcularVenda() {
        return this.getPreco() + (this.isProducaoOrganica() ? 4 : 0) + (this.getPreco() * this.getSaco()) + (this.isCompacto() ? 8 : 0);
    }
    
    public int getSaco() {
        return saco;
    }
    
    public void setSaco(int saco) throws SacoInvalidoException {
        if(saco <= 0) {
            throw new SacoInvalidoException("Quantidade de sacos inválida.");
        }
        
        this.saco = saco;
    }
    
    public boolean isCompacto() {
        return compacto;
    }  
    
    public void setCompacto(boolean compacto) {
        this.compacto = compacto;
    }
    
}
