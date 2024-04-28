/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
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
    
    public String listaVeiculos(){
        String saida="";
        saida += "---Lista de Veículos---\n";
        for(int i=0; i<veiculos.size(); i++){
            saida += i+1 + "- " + veiculos.get(i).toString();
        }
        return saida;
    }
    
    public String toString(){
        String saida="";
        saida += "=======Cliente=======\n";
        saida += "Nome: " + this.nome + "\n";
        saida += "Documento: " + this.documento + "\n";
        saida += listaVeiculos();
        
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
