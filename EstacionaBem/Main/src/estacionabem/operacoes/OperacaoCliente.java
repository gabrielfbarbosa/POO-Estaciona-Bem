/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

import estacionabem.programa.Cliente;
import estacionabem.programa.Menus;
import estacionabem.programa.Tipo;
import estacionabem.ticket.Ticket;
import estacionabem.programa.Veiculo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BrenoTakeshiCamargod
 */
public class OperacaoCliente {
    /*================================1- Cadastrar Clientes================================*/
    /*A função vai listar todos os clientes cadastrados, vai pedir um documento para novo cadastro e procurar se ele já se encontra
    no ArrayList clientes(Verficado pelo buscaCliente que retorna o objeto inteiro que possui esse docuemtno), se não possuir é feito 
    a coleta dos outros dados e realizado o cadastro*/
    
    OperacaoVeiculo opVeiculo = new OperacaoVeiculo();
    OperacaoEstacionar opEstacionamento = new OperacaoEstacionar();
    
    public void cadastrarCliente(ArrayList<Cliente> clientes){ 

        listaCadastros(clientes);
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente:", "Numero do documento");
        Cliente cliente = buscaCliente(clientes, documento);
        
        if(cliente == null){
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente", "Fulano de Tal");
            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veículo do cliente:", "Placa Y");
            String strTipo = JOptionPane.showInputDialog(null, "Digite o tipo do veículo do cliente:", "moto, carro ou onibus");
            strTipo = strTipo.toLowerCase();
            /*Verifica se o tipo é Moto ou Carro, se for o cadastro é feito e o cliente é adicionado no Array, caso contrário volta uma mensagem de erro*/
            if(strTipo.equals("moto") || strTipo.equals("carro") || strTipo.equals("onibus")){
                ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
                Tipo tipo = Tipo.converteString(strTipo);
                Veiculo veiculo = new Veiculo(placa, cliente, tipo);
                veiculos.add(veiculo);
                
                cliente = new Cliente(nome, documento, veiculos);
            
                clientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Tipo de Veiculo inválido, verifique se você digitou corretamente Moto ou Carro!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }
            
            
        } else{
            JOptionPane.showMessageDialog(null, "Documento já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /*2- Consultar documento de Clientes================================*/
    /*Lista todos os clientes para facilitar a escolha, pede um documento e verifica se esse existe no ArrayList(Verificado por buscaCliente), caso existir
    é retornado as informações do cliente através do método toString feito na classe cliente*/
    public void consultarDocumento(ArrayList<Cliente> clientes){
        listaCadastros(clientes);
        
        /*Caso não exista clientes cadastros não é feito a funcionalidade e devolve uma mensagem de erro*/
        if(clientes.size() > 0){
            Cliente cliente;
        
            String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Numero do Documento");
            cliente = buscaCliente(clientes, documento);
            
            /*verifica cliente cadastrado*/
            if(cliente != null){
                JOptionPane.showMessageDialog(null, cliente.toString(), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Ainda não há clientes cadastrados", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
        
    } 
    
    
    /*3- Excluir Clientes================================*/
    /*O usuário informa um documento, caso ele exista no ArrayList de clientes(verificado por buscaCliente), ele é excluido no ArrayList de clientes, com uso
    do método .remove(object o), não podendo excluir clientes com tickets cadastrados que é verificado pelo método buscaClienteTicket que retorna true caso encontre
    ou false se não tiver nenhum ticket*/
    public void excluirCliente(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        listaCadastros(clientes);
        if(clientes.size() > 0){
            Cliente cliente;
        
            String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Numero do Documento");
            cliente = buscaCliente(clientes, documento);

            boolean ticketCadastrado = opEstacionamento.buscaClienteTicket(tickets, documento);
            /*verifica cliente cadastrado*/
            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            
            /*verifica ticket cadastrado com esse cliente*/    
            } else if(ticketCadastrado){
                JOptionPane.showMessageDialog(null, "Não é possível remover o Cliente, ele ainda possui Ticket Ativado", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            } else{
                clientes.remove(cliente);
                JOptionPane.showMessageDialog(null, "Cliente Excluído com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Ainda não há clientes cadastrados", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /*4 - Editar================================*/
    /*busca um documento dado pelo usuário, se existir o sistema verá qual o dado que o usuário vai desejar alterar usando caixas de textos
    com opções de sim ou não na pergunta se ele quer alterar tal campo, caso ele queira o programa vai ler o novo valor e alterar o objeto
    correspondente, não podendo alterar clientes que possuem tickets cadastrados*/
    public void editarCliente(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        listaCadastros(clientes);
        if(clientes.size() > 0){
            Cliente cliente;
        
            String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Numero do Documento");
            cliente = buscaCliente(clientes, documento);

            boolean ticketCadastrado = opEstacionamento.buscaClienteTicket(tickets, documento);
            
            /*verifica cliente cadastrado*/
            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);                
            
            /*verifica ticket cadastrado com esse cliente*/
            } else if(ticketCadastrado){
                JOptionPane.showMessageDialog(null, "Não é possível editar o Cliente, ele ainda possui Ticket Ativado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);                                
            
            } else{
               JOptionPane.showMessageDialog(null, cliente.toString());
                int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o nome do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);

                /*verifica se vai alterar nome*/
                if(alteracao == JOptionPane.YES_OPTION){
                    String nome = JOptionPane.showInputDialog(null, "Digite o novo nome do cliente: ", "Fulano de Tal");
                    cliente.setNome(nome);
                }

                alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o documento do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);

                /*verifica se vai alterar documento*/
                if(alteracao == JOptionPane.YES_OPTION){
                    documento = JOptionPane.showInputDialog(null, "Digite o novo documento do cliente: ", "Novo Documento");
                    cliente.setDocumento(documento);
                }

                alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar os veiculos do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);

                /*verifica se vai alterar veiculos do cliente*/
                if(alteracao == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Escolha a opcao 5- Gerenciar veículos, do menu de clientes", "Estaciona Bem",JOptionPane.INFORMATION_MESSAGE);
                }

                JOptionPane.showMessageDialog(null, "Cliente Alterado", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        } else{
            JOptionPane.showMessageDialog(null, "Ainda não há clientes cadastrados", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /*5 - Gerenciar veículos================================*/
    /*Possui verificações parecidas com as anteriores, quando passar por elas vai abrir um menu próprio para área dos veiculos
    podendo cadastrar, remover se houver mais de 2 veiculos e alterar, caso eles não estejam cadastrados em tickets */
    public void gerenciarVeiculos(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        if(clientes.size() > 0){
            Cliente cliente;
            Menus menu = new Menus();

            String documento = JOptionPane.showInputDialog(null, "Digite o documento do Proprietário", "Documento do proprietário");
            cliente = buscaCliente(clientes, documento);

            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                
            } else{
                int op = menu.menuGerenciarVeiculos();
                switch(op){
                    case 1:
                        opVeiculo.cadastrarVeiculo(clientes, cliente);
                        break;
                    case 2:
                        opVeiculo.removerVeiculo(cliente, tickets);
                        break;
                    case 3:
                        opVeiculo.alterarVeiculo(cliente, tickets);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Voltando para o Menu Principal!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE); 
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção invalida!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                        break;

                }
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Ainda não há veículos cadastrados", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    /*6 - Listar todos os cadastros================================*/
    public void listaCadastros(ArrayList<Cliente> clientes){
        String lista="";
        lista += " ===== Lista de Cliente =====\n";
        for(int i=0; i<clientes.size(); i++){
            lista += clientes.get(i).toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista, "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Cliente buscaCliente(ArrayList<Cliente> clientes, String documento){
        Cliente cliente=null;
        for(int i=0; i < clientes.size(); i++){
            if(clientes.get(i).getDocumento().equals(documento)){
                cliente = clientes.get(i);
            }
        }
        return cliente;
    }
    
/*============================Operações 1- Cliente====================================*/
    
}
