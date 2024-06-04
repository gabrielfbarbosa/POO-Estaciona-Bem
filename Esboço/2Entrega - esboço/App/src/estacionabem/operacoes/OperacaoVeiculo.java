/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

import estacionabem.Cliente;
import estacionabem.ticket.Ticket;
import estacionabem.Veiculo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BrenoTakeshiCamargod
 */
public class OperacaoVeiculo {
    /*----------------------------------Operações - veiculos--------------------------------------------------*/  
    /*Realiza cadastros de novos veiculos no nome do cliente, verificando se já existe a placa cadastrada para todos os clientes, usando
    buscaVeiculo dentro de um laço que percorre todos os clientes, a função verifica se tem algum veiculo com a mesma placa caso houver
    ela retorna o objeto com a mesma placa*/
    
    OperacaoEstacionar opEstacionamento = new OperacaoEstacionar();
    
    public void cadastrarVeiculo(ArrayList<Cliente> clientes, Cliente cliente){
        Veiculo veiculoCadastrado=null;
        
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, cliente.listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);
            String tipo = JOptionPane.showInputDialog(null, "Digite o tipo do veiculo", "Moto ou Carro");
            String placa = JOptionPane.showInputDialog(null, "Digite a Placa do veiculo", "Placa X");
            
            /*verifica se já existe a placa cadastrada para todos os veiculos*/
            for(Cliente c1: clientes){
                if(c1.buscaVeiculo(placa).equals(placa)){
                    veiculoCadastrado = cliente.buscaVeiculo(placa);
                }
            }
            
            if(veiculoCadastrado == null){
                Veiculo novoVeiculo;
                /*verifica o tipo do veiculo*/
                if(tipo.equals("Moto") || tipo.equals("Carro")){
                    novoVeiculo = new Veiculo(placa, cliente, tipo);
                } else{
                    JOptionPane.showMessageDialog(null, "Tipo de veículo inválido, verifique se digitou corretamente Motou ou Carro!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                cliente.adicionaVeiculo(novoVeiculo);
            } else{
                JOptionPane.showMessageDialog(null, "Placa já cadastrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum veiculo? ", "Cadastrar Veiculos",JOptionPane.YES_NO_OPTION);
            
        }
        
    }
    /*Remove o veiculo se encontrar a sua placa dentro o ArrayList de veiculos do cliente e se ele não possuir ticket ativado, o programa vai 
    rodar até o usuário não querer mais excluir ou se cliente tiver apenas um veiculo*/
    public void removerVeiculo(Cliente cliente, ArrayList<Ticket> tickets){
    Veiculo veiculoCadastrado;
        
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION || cliente.getVeiculos().size() > 0){
            JOptionPane.showMessageDialog(null, cliente.listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);
            String placa = JOptionPane.showInputDialog(null, "Digite a Placa do veiculo", "Placa X");
            veiculoCadastrado = cliente.buscaVeiculo(placa);
            
            boolean ticketCadastrado = opEstacionamento.buscaPlacaTicket(tickets, placa);
            
            /*verifica se existe a placa no ArrayList de veiculos do cliente*/
            if(veiculoCadastrado == null){
                JOptionPane.showMessageDialog(null, "Placa não encontrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
             
            /*verifica se o veiculo ainda possui ticket ativado*/    
            } else if(ticketCadastrado){
               JOptionPane.showMessageDialog(null, "Não é possível remover Veiculo, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            
            } else{
                /*Remove o veiculo cadastrado do ArrayList*/
                cliente.removeVeiculo(veiculoCadastrado);
                JOptionPane.showMessageDialog(null, "Veículo Excluído com sucesso!!", "Gerenciar Veiculos", JOptionPane.INFORMATION_MESSAGE);
            
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum veiculo? ", "Remover Veiculos",JOptionPane.YES_NO_OPTION);
            
        }
        
    }
                
    /*Procura pelo veiculo no ArrayList de veiculos do cliente, se encontrar o programa pede para informar qual o dado que será alterado
    O pograma vai fazer alterações até o usuário definir que não quer mais alterar*/
    public void alterarVeiculo(Cliente cliente, ArrayList<Ticket> tickets){

        int alteracao = JOptionPane.YES_OPTION;
        while(alteracao == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, cliente.listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);

            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo que deseja alterar");
            Veiculo veiculo = cliente.buscaVeiculo(placa);

            boolean ticketCadastrado = opEstacionamento.buscaPlacaTicket(tickets, placa);
            /*verifica se existe a placa no ArrayList de veiculos do cliente*/
            if(veiculo == null){
                JOptionPane.showMessageDialog(null, "Placa não encontrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            
            /*verifica se o veiculo possui ticket ativo*/    
            } else if(ticketCadastrado){
               JOptionPane.showMessageDialog(null, "Não é possível remover Veiculo, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            
            } else{
                int aux=1;
                String tipo = JOptionPane.showInputDialog(null, "Digite o novo tipo do veiculo: ");
                
                if(tipo.equals("Moto") || tipo.equals("Carro")){
                    String novaPlaca = JOptionPane.showInputDialog(null, "Digite a nova placa ou a mesma placa");
                    if(novaPlaca.equals(placa)){
                        Veiculo veiculoNovo = cliente.buscaVeiculo(novaPlaca);
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
                    JOptionPane.showMessageDialog(null, "Tipo de veículo inválido, verifique se digitou corretamente Motou ou Carro!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);

                }
                
            }
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar mais algum veiculo? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
        }
    }
    
}
