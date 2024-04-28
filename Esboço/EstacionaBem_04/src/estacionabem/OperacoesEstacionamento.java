/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class OperacoesEstacionamento {
    
    /*1- Cadastrar Clientes================================*/
    public void cadastrarCliente(ArrayList<Cliente> clientes){ 

        listaCadastros(clientes);
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente:", "Numero do documento");
        Cliente cliente = buscaCliente(clientes, documento);
        
        if(cliente == null){
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente", "Fulano de Tal");
            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veículo do cliente:", "Placa X");
            String tipo = JOptionPane.showInputDialog(null, "Digite o tipo do veículo do cliente:", "Moto ou Carro");
            //Laço de cadastro de veiculos
            if(tipo.equals("Moto") || tipo.equals("Carro")){
                ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
                Veiculo veiculo = new Veiculo(placa, cliente);
                veiculos.add(veiculo);
                
                cliente = new Cliente(nome, documento, veiculos);
            
                clientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        } else{
            JOptionPane.showMessageDialog(null, "Documento já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /*2- Consultar documento de Clientes================================*/
    public void consultarDocumento(ArrayList<Cliente> clientes){
        listaCadastros(clientes);
        if(clientes.size() > 0){
            Cliente cliente;
        
            String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Numero do Documento");
            cliente = buscaCliente(clientes, documento);

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
    public void excluirCliente(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        listaCadastros(clientes);
        if(clientes.size() > 0){
            Cliente cliente;
        
            String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Numero do Documento");
            cliente = buscaCliente(clientes, documento);

            boolean ticketCadastrado = buscaClienteTicket(tickets, documento);
            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                
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
    public void editarCliente(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        listaCadastros(clientes);
        if(clientes.size() > 0){
            Cliente cliente;
        
            String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Numero do Documento");
            cliente = buscaCliente(clientes, documento);

            boolean ticketCadastrado = buscaClienteTicket(tickets, documento);
            
            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);                
            
            } else if(ticketCadastrado){
                JOptionPane.showMessageDialog(null, "Não é possível editar o Cliente, ele ainda possui Ticket Ativado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);                                
            
            } else{
               JOptionPane.showMessageDialog(null, cliente.toString());
                int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o nome do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);

                if(alteracao == JOptionPane.YES_OPTION){
                    String nome = JOptionPane.showInputDialog(null, "Digite o novo nome do cliente: ", "Fulano de Tal");
                    cliente.setNome(nome);
                }

                alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o documento do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);

                if(alteracao == JOptionPane.YES_OPTION){
                    documento = JOptionPane.showInputDialog(null, "Digite o novo documento do cliente: ", "Novo Documento");
                    cliente.setDocumento(documento);
                }

                alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar os veiculos do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);

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
    
    public void gerenciarVeiculos(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        if(clientes.size() > 0){
            Cliente cliente;
            Menus menu = new Menus();

            String documento = JOptionPane.showInputDialog(null, "Digite o documento do Proprietário", "Documento do proprietário");
            cliente = buscaCliente(clientes, documento);

            int op = menu.menuGerenciarVeiculos();
            switch(op){
                case 1:
                    cadastrarVeiculo(cliente);
                    break;
                case 2:
                    removerVeiculo(cliente, tickets);
                    break;
                case 3:
                    alterarVeiculo(cliente, tickets);
                    break;
                case 4:

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                    break;

            }
        } else{
            JOptionPane.showMessageDialog(null, "Ainda não há veículos cadastrados", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    /*6 - Listar todos os cadastros================================*/
    public void listaCadastros(ArrayList<Cliente> clientes){
        String lista="";
        lista += "=======Lista de Cliente=======\n";
        for(int i=0; i<clientes.size(); i++){
            lista += clientes.get(i).toString() + "/n";
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
    
    
/*----------------------------------Operações - veiculos--------------------------------------------------*/  
public void cadastrarVeiculo(Cliente cliente){
        Veiculo veiculoCadastrado;
        
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, cliente.listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);
            String tipo = JOptionPane.showInputDialog(null, "Digite o tipo do veiculo", "Moto ou Carro");
            String placa = JOptionPane.showInputDialog(null, "Digite a Placa do veiculo", "Placa X");
            veiculoCadastrado = cliente.buscaVeiculo(placa);
            
            if(veiculoCadastrado == null){
                Veiculo novoVeiculo;
                if(tipo.equals("Moto")){
                    novoVeiculo = new Veiculo(placa, cliente, true);
                } else if (tipo.equals("Carro")){
                    novoVeiculo = new Veiculo(placa, cliente);
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
    
    public void removerVeiculo(Cliente cliente, ArrayList<Ticket> tickets){
    Veiculo veiculoCadastrado;
        
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION || cliente.getVeiculos().size() > 0){
            JOptionPane.showMessageDialog(null, cliente.listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);
            String placa = JOptionPane.showInputDialog(null, "Digite a Placa do veiculo", "Placa X");
            veiculoCadastrado = cliente.buscaVeiculo(placa);
            
            boolean ticketCadastrado = buscaPlacaTicket(tickets, placa);
            
            if(veiculoCadastrado == null){
                JOptionPane.showMessageDialog(null, "Placa não encontrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
                
            } else if(ticketCadastrado){
               JOptionPane.showMessageDialog(null, "Não é possível remover Veiculo, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
            
            } else{
                cliente.removeVeiculo(veiculoCadastrado);
                JOptionPane.showMessageDialog(null, "Veículo Excluído com sucesso!!", "Gerenciar Veiculos", JOptionPane.INFORMATION_MESSAGE);
            
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum veiculo? ", "Remover Veiculos",JOptionPane.YES_NO_OPTION);
            
        }
        
    }
                
    public void alterarVeiculo(Cliente cliente, ArrayList<Ticket> tickets){
        int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar algum veiculo do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
        while(alteracao == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, cliente.listaVeiculos(), "Lista de Veiculos", JOptionPane.INFORMATION_MESSAGE);

            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo que deseja alterar");
            Veiculo veiculo = cliente.buscaVeiculo(placa);

            boolean ticketCadastrado = buscaPlacaTicket(tickets, placa);
            if(veiculo == null){
                JOptionPane.showMessageDialog(null, "Placa não encontrada!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
                
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
    
    
/*============================Operações 2- Vagas====================================*/
    
    /*1 - Cadastrar Vaga================================*/
    public void cadastrarVaga(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis){ 

        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, listaVagas(vagas));
            int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira cadastrar:", "123456789"));
            String rua = JOptionPane.showInputDialog(null, "Digite o nome da rua da vaga que queira cadastrar:", "Rua Tal");
            Vaga vaga = buscaVaga(vagas, numero, rua);

            if(vaga == null){
                String tipo = JOptionPane.showInputDialog(null, "Digite o tipo da nova vaga", "Moto ou Carro");
                if(tipo.equals("Moto")){
                    Vaga novaVaga = new Vaga(numero, rua, true);
                    vagas.add(novaVaga);
                    JOptionPane.showMessageDialog(null, "Vaga cadastrada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
                } else if(tipo.equals("Carro")){
                    Vaga novaVaga = new Vaga(numero, rua);
                    vagas.add(novaVaga);
                    disponiveis.add(vaga);
                    JOptionPane.showMessageDialog(null, "Vaga cadastrada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, "Tipo de vaga inválido, verifique se digitou corretamente Motou ou Carro!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(null, "Combinação entre Rua e número já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais alguma vaga? ", "Cadastrar Vaga",JOptionPane.YES_NO_OPTION);
        }
    }
    
    /*2 - Consultar por número================================*/
    public void consultarVaga(ArrayList<Vaga> vagas){
        Vaga vaga;
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga: ", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga: ", "Rua Tal");
        vaga = buscaVaga(vagas, numero, rua);
        
        if(vaga != null){
            JOptionPane.showMessageDialog(null, vaga.toString(), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Combinação entre numero e rua não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /*3 - Excluir Vaga================================*/
    public void excluirVaga(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> indisponiveis, ArrayList<Vaga> ocupadas,ArrayList<Ticket> tickets){
        Vaga vaga;
        JOptionPane.showMessageDialog(null, listaVagas(vagas));
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira excluir", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Rua Tal");
        vaga = buscaVaga(vagas, numero, rua);
        
        boolean ticketCadastrado = buscaVagaTicket(tickets, rua, numero);
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            
        } else if(ticketCadastrado){
            JOptionPane.showMessageDialog(null, "Não é possível remover Vaga, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);            
        } else{
            Vaga disponibilidade = buscaVaga(disponiveis, numero, rua);
            if(disponibilidade != null){
                disponiveis.remove(disponibilidade);
                
            }else{
                disponibilidade = buscaVaga(ocupadas, numero, rua);
                if(disponibilidade != null){
                    ocupadas.remove(disponibilidade);
                    
                }else{
                    disponibilidade = buscaVaga(indisponiveis, numero, rua);
                    indisponiveis.remove(disponibilidade);
                }  
            }
            
            
            vagas.remove(vaga);
            JOptionPane.showMessageDialog(null, "Vaga Excluído com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*4 - Editar Vaga================================*/
    public void editarVaga(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> indisponiveis, ArrayList<Vaga> ocupadas,ArrayList<Ticket> tickets){
        Vaga vaga, alteraOutros;
        JOptionPane.showMessageDialog(null, listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira excluir", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Rua Tal");
        
        vaga = buscaVaga(vagas, numero, rua);
        boolean ticketCadastrado = buscaVagaTicket(tickets, rua, numero);
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            
        } else if(ticketCadastrado){
            JOptionPane.showMessageDialog(null, "Não é possível remover Vaga, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);            
        } else{
            JOptionPane.showMessageDialog(null, vaga.toString());
            alteraOutros = buscaVaga(disponiveis, numero, rua);
            if(alteraOutros == null){
                alteraOutros = buscaVaga(indisponiveis, numero, rua);
            }
            int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o tipo da vaga? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            if(alteracao == JOptionPane.YES_OPTION){
                String tipo = JOptionPane.showInputDialog(null, "Digite o novo tipo de vaga: ", "Moto ou Carro");
                if(tipo.equals("Moto") || tipo.equals("Carro")){
                    vaga.setTipo(tipo);
                    alteraOutros.setTipo(tipo);
                } else{
                    JOptionPane.showMessageDialog(null, "Tipo inválido, confira se você escreveu corretamente Moto ou Carro!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o numero? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            if(alteracao == JOptionPane.YES_OPTION){
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo numero da vaga: ", "123456789"));
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar a Rua da vaga? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            if(alteracao == JOptionPane.YES_OPTION){
                rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Rua Tal");
            }
            
            vaga = buscaVaga(vagas, numero, rua);
            if(vaga != null){
                JOptionPane.showMessageDialog(null, "Combinação de numero e rua já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            } else{
                vaga.setNumero(numero);
                vaga.setRua(rua);
                alteraOutros.setNumero(numero);
                alteraOutros.setRua(rua);
            }
            
            
            JOptionPane.showMessageDialog(null, "Vaga Alterada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    /*5- Alterar Disponibilidade================================*/
    
    
    public void operacaoAlteraDisponibilidade(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> indisponiveis, ArrayList<Vaga> ocupadas, ArrayList<Ticket> tickets){
        Vaga vaga;
        boolean verificador;
        JOptionPane.showMessageDialog(null, listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira alterar a disponibilidade", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira alterar a disponibilidade", "Rua Tal");
        
        vaga = buscaVaga(vagas, numero, rua);
        boolean ticketCadastrado = buscaVagaTicket(tickets, rua, numero);
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            
        } else if(ticketCadastrado){
            JOptionPane.showMessageDialog(null, "Não é possível alterar a disponibilidade da Vaga, ela ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);            
        } else{
            String disponibilidade = JOptionPane.showInputDialog(null, "Digite uma nova disponibilidade: ");
            verificador = alteraDisponibilidade(vagas, disponiveis, indisponiveis, ocupadas, vaga, disponibilidade);
            
            if(verificador){
                JOptionPane.showMessageDialog(null, "Disponibilidade de Vaga Alterada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "É a Mesma disponibilidade digitada com a que se tem cadastrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /*Vou usar para ocupar ela nos ticket e desocupar*/
    public boolean alteraDisponibilidade(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> ocupadas, ArrayList<Vaga> indisponiveis, Vaga vaga, String disponibilidade){
        

        if(!disponibilidade.equals(vaga.getDisponibilidade())){
            
            if(vaga.getDisponibilidade().equals("disponivel")){
                disponiveis.remove(vaga);
            }   else if(vaga.getDisponibilidade().equals("indisponivel")){
                indisponiveis.remove(vaga);
            } else if(vaga.getDisponibilidade().equals("ocupada")){
                ocupadas.remove(vaga);
            }
            
            vaga.setDisponibilidade(disponibilidade);
            if(disponibilidade.equals("disponivel")){
                disponiveis.add(vaga);
            } else if(disponibilidade.equals("indisponivel")){
                indisponiveis.add(vaga);
            } else if(disponibilidade.equals("ocupada")){
                ocupadas.add(vaga);
            } 
            return true;
        }
        return false;
    }
    
   
    
    public Vaga buscaVaga(ArrayList<Vaga> vagas, int numero, String rua){
        Vaga vaga=null;
        for(int i=0; i < vagas.size(); i++){
            if(vagas.get(i).getNumero() == numero && vagas.get(i).getRua().equals(rua)){
                vaga = vagas.get(i);
            }
        }
        return vaga;
    }
    
    
/*============================Operações 2- Vagas====================================*/


/*------------------------------------------------------------------------------------*/  

    
/*============================Operações 3- Estacionamento====================================*/   
    
    /*1 - Estacionar================================*/
    public void estacionar(ArrayList<Vaga> vagas,ArrayList<Vaga> disponiveis, ArrayList<Vaga> ocupadas ,ArrayList<Cliente> clientes, ArrayList<Ticket> tickets){
        Vaga vaga;
        boolean verificador;
        
        JOptionPane.showMessageDialog(null, listaVagas(disponiveis));
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira estacionar", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira estacionar", "Rua Tal");
        
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente:", "Documento do cliente");
        Cliente cliente = buscaCliente(clientes, documento);
        
        String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo:", "Placa X");
        
        Veiculo veiculo = null;
        if(cliente != null){
            veiculo = cliente.buscaVeiculo(placa);
        }
        
        vaga = buscaVaga(vagas, numero, rua);
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Vaga não encontrada!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);

        } else if (cliente == null){
            JOptionPane.showMessageDialog(null, "Cliente não encontrados!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);

        } else if(veiculo == null || !vaga.getTipo().equals(veiculo.getPlaca())){
            JOptionPane.showMessageDialog(null, "Veiculo não possui o mesmo tipo que a vaga desejada!", "Estaciona Bem",JOptionPane.ERROR_MESSAGE);
        } else{
            vaga = buscaVaga(disponiveis, numero, rua);
            if(vaga == null ){
                JOptionPane.showMessageDialog(null, "Vaga indisponivel ou ocupada!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            } else{
                verificador = alteraDisponibilidade(vagas, disponiveis, ocupadas, null, vaga, "Ocupada");
                
                Ticket ticket = new Ticket(vaga,veiculo);
                tickets.add(ticket);
                
                disponiveis.remove(vaga);
                ocupadas.add(vaga);
                /*função para começar a contar o tempo e criar o ticket*/
                JOptionPane.showMessageDialog(null, "Estacionamento iniciado com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    
    /*2 - Retirar================================*/
    public void retirar(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> ocupadas ,ArrayList<Cliente> clientes, ArrayList<Ticket> tickets, ArrayList<Tarifa> tarifas,DiaDaSemana[] dias){
        
        String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo que irá retirar:", "Placa X");
        
        Ticket ticket = buscaTicket(tickets, placa);
        
        if(ticket == null){
            JOptionPane.showMessageDialog(null, "Ticket não encontrado!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        } else{
            ticket.finalizaTicket();
            
            DiaDaSemana dia = defineDia(ticket.getFim().getDayOfWeek().getValue(), dias);
            Tarifa tarifa = new Tarifa(ticket, dia);
            double valorTotal = calculaTarifa(tarifa, dias);
            
            tarifas.add(tarifa);
            
            Vaga vaga = buscaVaga(ocupadas, ticket.getVaga().getNumero(), ticket.getVaga().getRua());
            disponiveis.add(vaga);
            ocupadas.remove(vaga);
            
            JOptionPane.showMessageDialog(null, tarifa.toString());
        }
    }
    
    
    /*3 - Listar todas as vagas================================*/
    public String listaVagas(ArrayList<Vaga> vagas){
        String saida="";
        saida += "---Lista de vagas---\n";
        for(Vaga vaga : vagas){
            saida += "**vaga: \n" + vaga.toString();
        }
        return saida;
    }
    
    /*4 - Gerenciar Tarifas================================*/
    public void gerenciarTarifa(DiaDaSemana[] dias){
        int numDia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o dia que vc quer gerenciar: 1-domingo, 2-segunda.... até 7-sabado", "Numero de 1 a 7"));
        String tipo = JOptionPane.showInputDialog(null, "Qual o tipo da vaga: ", "Moto ou Carro");
        
        if(tipo.equals("Moto")){
            int novoPrimeiro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da primeira hora:"));
            int novoSegundo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da hora subsquente:"));
            dias[numDia].setValorPrimeiraHoraMoto(novoPrimeiro);
            dias[numDia].setValorHorasubsequenteMoto(novoSegundo);
        }else if(tipo.equals("Carro")){
            int novoPrimeiro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da primeira hora:"));
            int novoSegundo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da hora subsquente:"));
            dias[numDia].setValorPrimeiraHoraCarro(novoPrimeiro);
            dias[numDia].setValorHorasubsequenteCarro(novoSegundo);
        } else{
            JOptionPane.showMessageDialog(null, "Tipo inválido, confira se você digitou Moto ou Carro corretamente!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(null, "Gerenciamento concluido com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public boolean buscaPlacaTicket(ArrayList<Ticket> tickets, String placa){
        boolean achou = false;
        
        for(Ticket ticket : tickets){
            if(ticket.getVeiculo().getPlaca().equals(placa)){
                achou = true;
            }
        }
        return achou;
    }
    public boolean buscaClienteTicket(ArrayList<Ticket> tickets, String documento){
        boolean achou = false;
        
        for(Ticket ticket : tickets){
            if(ticket.getVeiculo().getProprietario().getDocumento().equals(documento)){
                achou = true;
            }
        }
        return achou;
    }
    
    public boolean buscaVagaTicket(ArrayList<Ticket> tickets, String rua, int numero){
        boolean achou = false;
        
        for(Ticket ticket : tickets){
            if(ticket.getVaga().getRua().equals(rua) && ticket.getVaga().getNumero() == numero){
                achou = true;
            }
        }
        return achou;
    }
    
    public Ticket buscaTicket(ArrayList<Ticket> tickets, String placa){
        
        for(Ticket ticket: tickets){
            if(ticket.getVeiculo().getPlaca().equals(placa)){
                return ticket;
            }
        }
        return null;
    }
    
    public DiaDaSemana defineDia(int numDia, DiaDaSemana[] dias)
    {
        DiaDaSemana dia = new DiaDaSemana("");
        switch(numDia){
            case 1:
                dia.setDia("Domingo");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;
            case 2:
                dia.setDia("Segunda");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;   
            case 3:
                dia.setDia("Terça");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;
            case 4:
                dia.setDia("Quarta");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;
            case 5:
                dia.setDia("Quinta");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;
            case 6:
                dia.setDia("Sexta");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;
            case 7:
                dia.setDia("Sabado");
                dia.setValorHorasubsequenteMoto(dias[0].getValorHorasubsequenteMoto());
                dia.setValorPrimeiraHoraMoto(dias[0].getValorPrimeiraHoraMoto());
                dia.setValorHorasubsequenteCarro(dias[0].getValorHorasubsequenteCarro());
                dia.setValorPrimeiraHoraCarro(dias[0].getValorPrimeiraHoraCarro());
                break;    
        }
        return dia;
    }
    
    
    
    public double calculaTarifa(Tarifa tarifa ,DiaDaSemana[] diasDaSemana){
        long diasCompletos = ChronoUnit.DAYS.between(tarifa.getTicket().getInicio().toLocalDate(), tarifa.getTicket().getFim().toLocalDate());
        long minutosEstacionados = ChronoUnit.MINUTES.between(tarifa.getTicket().getInicio(), tarifa.getTicket().getFim());
        long horasEstacionadas = minutosEstacionados / 60;

        double valorTotal = 0;
        if (diasCompletos == 0){
            if(tarifa.getTicket().getVeiculo().getTipo().equals("Moto")){
                valorTotal = tarifa.getDiaSaida().getValorPrimeiraHoraMoto();
                valorTotal += horasEstacionadas * tarifa.getDiaSaida().getValorHorasubsequenteMoto();
            }else{
                valorTotal = tarifa.getDiaSaida().getValorPrimeiraHoraCarro();
                valorTotal += horasEstacionadas * tarifa.getDiaSaida().getValorHorasubsequenteCarro();
            }
        }else{
            
        }
        return valorTotal;
        
    }
/*============================Operações 3- Estacionamento====================================*/


/*------------------------------------------------------------------------------------*/  

    
/*============================Operações 4- Cadastros Geraias====================================*/     
    
    
    
    
    
/*============================Operações 4- Cadastros Geraias====================================*/        


/*------------------------------------------------------------------------------------*/  

    
/*============================Operações 5- Consultar Total Faturado====================================*/     
    public void consultaTotalFaturado(ArrayList<Tarifa> tarifas){
        JOptionPane.showMessageDialog(null, "Consultar total faturado dentre um período", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        String strInicio = JOptionPane.showInputDialog(null, "Digite o início do período: ", "DD-MM-AAAA");
        String strFim = JOptionPane.showInputDialog(null, "Digite o fim do período: ", "DD-MM-AAAA");
        
        LocalDate inicio = LocalDate.parse(strInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fim = LocalDate.parse(strFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        double totalFaturado = 0;
        for(Tarifa tarifa : tarifas){
            LocalDate dataTarifa = tarifa.getTicket().getFim().toLocalDate();
            if(!dataTarifa.isBefore(inicio) && !dataTarifa.isBefore(fim)){
                totalFaturado += tarifa.getValorTotal();
            }
        }
        
        if(totalFaturado == 0){
            JOptionPane.showMessageDialog(null, "Não houve fatura dentre esse período", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
        JOptionPane.showMessageDialog(null, "Total da fatura entre " + strInicio + " e " + strFim + "\nR$ " + totalFaturado, "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
