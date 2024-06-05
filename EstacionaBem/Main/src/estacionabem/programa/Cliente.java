package estacionabem.programa;

import java.util.ArrayList;

public class Cliente {
    
    private String nome;
    private String documento;
    private ArrayList<Veiculo> veiculos;

    public Cliente(String nome, String documento, ArrayList<Veiculo> veiculos) {
        this.nome = nome;
        this.documento = documento;
        this.veiculos = veiculos;
    }

    public void adicionaVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }
    
    public void removeVeiculo(Veiculo veiculo){
        this.veiculos.remove(veiculo);
    }
    
    public Veiculo buscaVeiculo(String placa){
        
        for(Veiculo veiculo : this.veiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }
    
    public String listaVeiculos(ArrayList<Veiculo> veiculos){
        String saida="";
        saida += "--- Lista de Veículos ---\n";
        for(Veiculo veic: veiculos){
            saida += "- " + veic.toString() + "\n";
        }
        return saida;
    }
    
    public String toString(){
        String saida="";
        saida += "======= Cliente =======\n";
        saida += "Nome: " + this.nome + "\n";
        saida += "Documento: " + this.documento + "\n";
        saida += listaVeiculos(this.veiculos);
        
        return saida;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
