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
public class OperacoesEstacionamento {
    
    /*1- Cadastrar Clientes================================*/
    public void cadastrarCliente(ArrayList<Cliente> clientes){ 

        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente:", "Cadastro Cliente");
        Cliente cliente = buscaCliente(clientes, documento, 0);
        
        if(cliente == null){
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente", "Cadastro Cliente");
            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veículo do cliente:", "Cadastro Cliente");
            //Laço de cadastro de veiculos

            ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
            cliente = new Cliente(nome, documento, veiculos);
            
            clientes.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Documento já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /*2- Consultar documento de Clientes================================*/
    public void consularDocumento(ArrayList<Cliente> clientes){
        Cliente cliente;
        
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Consulta Cliente");
        cliente = buscaCliente(clientes, documento, 0);
        
        if(cliente != null){
            JOptionPane.showMessageDialog(null, cliente.toString(), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    } 
    
    
    /*3- Excluir Clientes================================*/
    public void excluirCliente(ArrayList<Cliente> clientes){
        Cliente cliente;
        
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Excluir Cliente");
        cliente = buscaCliente(clientes, documento, 0);
        
        if(cliente != null){
            clientes.remove(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Excluído com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /*4 - Editar================================*/
    public void editarCliente(ArrayList<Cliente> clientes){
        Cliente cliente;
        
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente", "Excluir Cliente");
        int indice=0;
        cliente = buscaCliente(clientes, documento, indice);
        
        if(cliente != null){
            JOptionPane.showMessageDialog(null, cliente.toString());
            int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o nome do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
            
            if(alteracao == JOptionPane.YES_OPTION){
                String nome = JOptionPane.showInputDialog(null, "Digite o novo nome do cliente: ", "Alterar Cliente");
                clientes.get(indice).setNome(nome);
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o documento do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
            
            if(alteracao == JOptionPane.YES_OPTION){
                documento = JOptionPane.showInputDialog(null, "Digite o novo documento do cliente: ", "Alterar Cliente");
                cliente.setDocumento(documento);
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar os veiculos do cliente? ", "Alterar Cliente",JOptionPane.YES_NO_OPTION);
            
            if(alteracao == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Escolha a opcao 5- Gerenciar veículos, do menu de clientes", "Estaciona Bem",JOptionPane.INFORMATION_MESSAGE);
            }
            
            JOptionPane.showMessageDialog(null, "Cliente Alterado", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Documento não encontrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*5 - Gerenciar veículos================================*/
    
    public void gerenciarVeiculos(ArrayList<Cliente> clientes){
        Cliente cliente;
        Menus menu = new Menus();
        
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do Proprietário", "Gerenciar Veiculos");
        int indice=0;
        cliente = buscaCliente(clientes, documento, indice);
        
        int op = menu.menuGerenciarVeiculos();
        switch(op){
            case 1:
                cliente.cadastrarVeiculo(cliente);
                break;
            case 2:
                cliente.removerVeiculo();
                break;
            case 3:
                cliente.alterarVeiculo();
                break;
            case 4:
                
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                break;
              
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
    
    public Cliente buscaCliente(ArrayList<Cliente> clientes, String documento, int indice){
        Cliente cliente=null;
        for(int i=0; i < clientes.size(); i++){
            if(clientes.get(i).getDocumento().equals(documento)){
                cliente = clientes.get(i);
                indice = i;
            }
        }
        return cliente;
    }
    
/*============================Operações 1- Cliente====================================*/
    
    
/*------------------------------------------------------------------------------------*/  
    
    
/*============================Operações 2- Vagas====================================*/
    
    /*1 - Cadastrar Vaga================================*/
    public void cadastrarVaga(ArrayList<Vaga> vagas){ 

        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, listaVagas(vagas));
            int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira cadastrar:", "Cadastro Vaga"));
            String rua = JOptionPane.showInputDialog(null, "Digite o nome da rua da vaga que queira cadastrar:", "Cadastro Vaga");
            Vaga vaga = buscaVaga(vagas, numero, rua);

            if(vaga == null){
                Vaga novaVaga;
                String tipo = JOptionPane.showInputDialog(null, "Digite o tipo da nova vaga", "Cadastro Cliente");
                if(tipo.equals("Moto")){
                    novaVaga = new Vaga(numero, rua, true);
                } else{
                    novaVaga = new Vaga(numero, rua);
                }

                vagas.add(novaVaga);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Documento já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }
            
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum veiculo? ", "Cadastrar Veiculos",JOptionPane.YES_NO_OPTION);
        }
    }
    
    /*2 - Consultar por número================================*/
    public void consularVaga(ArrayList<Vaga> vagas){
        Vaga vaga;
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga: ", "Consulta Vaga"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga: ", "Consulta Vaga");
        vaga = buscaVaga(vagas, numero, rua);
        
        if(vaga != null){
            JOptionPane.showMessageDialog(null, vaga.toString(), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Combinação entre numero e rua não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /*3 - Excluir Vaga================================*/
    public void excluirVaga(ArrayList<Vaga> vagas){
        Vaga vaga;
        JOptionPane.showMessageDialog(null, listaVagas(vagas));
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira excluir", "Excluir Vaga"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Excluir Vaga");
        vaga = buscaVaga(vagas, numero, rua);
        
        if(vaga != null){
            vagas.remove(vaga);
            JOptionPane.showMessageDialog(null, "Vaga Excluído com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*4 - Editar Vaga================================*/
    public void editarVaga(ArrayList<Vaga> vagas){
        Vaga vaga;
        JOptionPane.showMessageDialog(null, listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira excluir", "Excluir Vaga"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Excluir Vaga");
        
        vaga = buscaVaga(vagas, numero, rua);
        if(vaga != null){
            JOptionPane.showMessageDialog(null, vaga.toString());
            
            int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o tipo da vaga? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            if(alteracao == JOptionPane.YES_OPTION){
                String tipo = JOptionPane.showInputDialog(null, "Digite o novo tipo de vaga: ", "Alterar Vaga");
                vaga.setTipo(tipo);
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o numero? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            if(alteracao == JOptionPane.YES_OPTION){
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo numero da vaga: ", "Alterar Vaga"));
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar a Rua da vaga? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            if(alteracao == JOptionPane.YES_OPTION){
                rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Excluir Vaga");
            }
            
            vaga = buscaVaga(vagas, numero, rua);
            if(vaga != null){
                JOptionPane.showMessageDialog(null, "Combinação de numero e rua já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            } else{
                vaga.setNumero(numero);
                vaga.setRua(rua);
            }
            
            
            JOptionPane.showMessageDialog(null, "Vaga Alterada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Combinação de numero e rua não encontrados!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /*5- Alterar Disponibilidade================================*/
    
    
    public void OperacaoAlteraDisponibilidade(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> indisponiveis, ArrayList<Vaga> ocupadas){
        Vaga vaga;
        boolean verificador;
        JOptionPane.showMessageDialog(null, listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira alterar a disponibilidade", "Alterar disponibilidade da Vaga"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira alterar a disponibilidade", "Alterar disponibilidade da Vaga");
        
        vaga = buscaVaga(vagas, numero, rua);
        if(vaga != null){
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
    
    
    public String listaVagas(ArrayList<Vaga> vagas){
        String saida="";
        saida += "---Lista de vagas---\n";
        for(Vaga vaga : vagas){
            saida += "**vaga: \n" + vaga.toString();
        }
        return saida;
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
    public void estacionar(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> ocupadas ,ArrayList<Cliente> clientes){
        Vaga vaga;
        boolean verificador;

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira alterar a disponibilidade", "Alterar disponibilidade da Vaga"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira alterar a disponibilidade", "Alterar disponibilidade da Vaga");
        
        String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente:", "Cadastro Cliente");
        Cliente cliente = buscaCliente(clientes, documento, 0);
        
        vaga = buscaVaga(vagas, numero, rua);
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Vaga não encontrada!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);

        } else if (cliente == null){
            JOptionPane.showMessageDialog(null, "Cliente não encontrados!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);

        } else{
            vaga = buscaVaga(disponiveis, numero, rua);
            if(vaga == null){
                JOptionPane.showMessageDialog(null, "Vaga indisponiveis ou ocupada!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            } else{
                verificador = alteraDisponibilidade(vagas, disponiveis, ocupadas, null, vaga, "Ocupada");
                /*função para começar a contar o tempo e criar o ticket*/
                JOptionPane.showMessageDialog(null, "Estacionamento iniciado com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    
    /*2 - Retirar================================*/
    public void retirar(ArrayList<Vaga> vagas, ArrayList<Vaga> disponiveis, ArrayList<Vaga> ocupadas ,ArrayList<Cliente> clientes){
        
    }
}
