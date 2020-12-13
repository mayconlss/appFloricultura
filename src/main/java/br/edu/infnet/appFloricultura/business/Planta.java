package br.edu.infnet.appFloricultura.business;
import br.edu.infnet.appFloricultura.exception.CorInvalidaException;

public class Planta extends Produto {
    
    private boolean rara;
    private String cor;
    
    public Planta(String info, float preco, boolean producaoOrganica){
        super (info, preco, producaoOrganica);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.isRara());
        sb.append(";");
        sb.append(this.getCor());
        
        return sb.toString();
    }
    
    @Override
    public float calcularVenda() {
        return this.getPreco() + (this.isProducaoOrganica() ? 4 : 0) + (this.isRara() ? 8 : 0);
    }
    
    public boolean isRara(){
        return rara;
    }
    
    public void setRara(boolean rara){
        this.rara = rara;
    }
    
    public String getCor(){
        return cor;
    }
    
    public void setCor(String cor) throws CorInvalidaException {
        if (cor == null) {
            throw new CorInvalidaException("Cor inválida.");
        }
        
        this.cor = cor;
    }
    
}
