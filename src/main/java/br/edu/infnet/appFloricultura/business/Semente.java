package br.edu.infnet.appFloricultura.business;
import br.edu.infnet.appFloricultura.exception.PesoInvalidoException;

public class Semente extends Produto {
    
    private float peso;
    private String embalagem;
    
    public Semente(String info, float preco, boolean producaoOrganica){
        super (info, preco, producaoOrganica);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.getPeso());
        sb.append(";");
        sb.append(this.getEmbalagem());
        
        return sb.toString();
    }
    
    @Override
    public float calcularVenda() {
        return this.getPreco() + (this.isProducaoOrganica() ? 4 : 0) + this.getPeso() * 0.05f;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public void setPeso (float peso) throws PesoInvalidoException {
        if (peso <= 0){
            throw new PesoInvalidoException("Peso Inválido.");
        }
        
        this.peso = peso;
    }
    
    public String getEmbalagem() {
        return embalagem;
    }
    
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
    
}
