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

    public void cadastrarVeiculo(Cliente cliente){
        Veiculo veiculoCadastrado;
        
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);
            String tipo = JOptionPane.showInputDialog(null, "Digite o tipo do veiculo", "Cadastrar Veiculos");
            String placa = JOptionPane.showInputDialog(null, "Digite a Placa do veiculo", "Cadastrar Veiculos");
            veiculoCadastrado = procuraVeiculo(placa);
            
            if(veiculoCadastrado == null){
                Veiculo novoVeiculo;
                if(tipo.equals("Moto")){
                    novoVeiculo = new Veiculo(placa, cliente, true);
                } else{
                    novoVeiculo = new Veiculo(placa, cliente);
                }
                this.veiculos.add(novoVeiculo);
            } else{
                JOptionPane.showMessageDialog(null, "Placa já cadastrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum veiculo? ", "Cadastrar Veiculos",JOptionPane.YES_NO_OPTION);
            
        }
        
    }
    
    public void removerVeiculo(){
    Veiculo veiculoCadastrado;
        
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION || this.veiculos.size() < 0){
            JOptionPane.showMessageDialog(null, listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);
            String placa = JOptionPane.showInputDialog(null, "Digite a Placa do veiculo", "Remover Veiculos");
            veiculoCadastrado = procuraVeiculo(placa);
            
            if(veiculoCadastrado != null){
                this.veiculos.remove(veiculoCadastrado);
                JOptionPane.showMessageDialog(null, "Veículo Excluído com sucesso!!", "Gerenciar Veiculos", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Placa não encontrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum veiculo? ", "Remover Veiculos",JOptionPane.YES_NO_OPTION);
            
        }
    }
    
    public void alterarVeiculo(){
        int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar algum veiculo do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
        while(alteracao == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);

            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo que deseja alterar");
            Veiculo veiculo = procuraVeiculo(placa);

            if(veiculo != null){
                int aux=1;
                String tipo = JOptionPane.showInputDialog(null, "Digite o tipo do veiculo: ");
                String novaPlaca = JOptionPane.showInputDialog(null, "Digite a nova placa ou a mesma placa");
                if(novaPlaca.equals(placa)){
                    Veiculo veiculoNovo = procuraVeiculo(novaPlaca);
                    if(veiculoNovo != null){
                        JOptionPane.showMessageDialog(null, "Placa ja cadastrada", "Gerenciar Veiculos",JOptionPane.ERROR_MESSAGE);
                        aux = 0;
                    }   
                } 

                if(aux == 1){
                    veiculo.setPlaca(novaPlaca);
                    veiculo.setTipo(tipo);
                    JOptionPane.showMessageDialog(null, "Veiculo Alterado");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Placa não encontrada!!", "Gerenciar Veiculos",JOptionPane.ERROR_MESSAGE);

            }
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar mais algum veiculo? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
        }
    }
    
    
    
    public Veiculo procuraVeiculo(String placa){
        
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
