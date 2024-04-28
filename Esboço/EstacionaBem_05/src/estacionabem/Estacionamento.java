/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionabem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class Estacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Menus menu = new Menus();
       OperacoesEstacionamento funcao = new OperacoesEstacionamento();
       int opPrimaria, opSecundaria;
       
       ArrayList<Cliente> clientes = new ArrayList<Cliente>();
       ArrayList<Vaga> vagas = new ArrayList<Vaga>() ;
       ArrayList<Vaga> disponiveis = new ArrayList<Vaga>();
       ArrayList<Vaga> ocupadas = new ArrayList<Vaga>();
       ArrayList<Vaga> indisponiveis = new ArrayList<Vaga>();
       ArrayList<Ticket> tickets = new ArrayList<Ticket>();
       ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
       
       
       ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
       Cliente c1 = new Cliente("Brenildu", "123", veiculos);
       Veiculo v1 = new Veiculo("Placa X",  c1);
       c1.getVeiculos().add(v1);
       Veiculo v2 = new Veiculo("Placa Y",  c1, true);
       c1.getVeiculos().add(v2);
       Veiculo v3 = new Veiculo("Placa Z",  c1);
       c1.getVeiculos().add(v3);
       clientes.add(c1);
       
       
       Vaga vaga1 = new Vaga(123, "Rua Tal");
       vagas.add(vaga1);
       disponiveis.add(vaga1);
       Vaga vaga2 = new Vaga(124, "Rua Tal", true);
       vagas.add(vaga2);
       disponiveis.add(vaga2);
       
       
       DiaDaSemana[] dias = new DiaDaSemana[7];
       dias[0] = new DiaDaSemana("Domingo");
       dias[1] = new DiaDaSemana("Segunda");
       dias[2] = new DiaDaSemana("Terça");
       dias[3] = new DiaDaSemana("Quarta");
       dias[4] = new DiaDaSemana("Quinta");
       dias[5] = new DiaDaSemana("Sexta");
       dias[6] = new DiaDaSemana("Sabado");
       
       
       boolean sair=false;
       
       while(sair == false){
           opPrimaria = menu.menuPrincipal();
           
           switch(opPrimaria){
               
                case 1:
                   opSecundaria = menu.menuGerenciarClientes();
                   if(opSecundaria == 1){
                       funcao.cadastrarCliente(clientes);
                   } else if(opSecundaria == 2){
                       funcao.consultarDocumento(clientes);
                   } else if(opSecundaria == 3){
                       funcao.excluirCliente(clientes, tickets);
                   } else if(opSecundaria == 4){
                       funcao.editarCliente(clientes, tickets);
                   } else if(opSecundaria == 5){
                       funcao.gerenciarVeiculos(clientes, tickets);
                   } else if(opSecundaria == 6){
                       funcao.listaCadastros(clientes);
                   } else if(opSecundaria == 7){
                       
                   } else{
                       JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
                   
                case 2:
                   
                   opSecundaria = menu.menuGerenciarVagas();
                   if(opSecundaria == 1){
                       funcao.cadastrarVaga(vagas, disponiveis);
                   } else if(opSecundaria == 2){
                       funcao.consultarVaga(vagas);
                   } else if(opSecundaria == 3){
                       funcao.excluirVaga(vagas, disponiveis, indisponiveis, ocupadas, tickets);
                   } else if(opSecundaria == 4){
                       funcao.editarVaga(vagas, disponiveis, indisponiveis, ocupadas,tickets);
                   } else if(opSecundaria == 5){
                       funcao.operacaoAlteraDisponibilidade(vagas, disponiveis, indisponiveis, ocupadas, tickets);
                   } else if(opSecundaria == 6){
                       
                   } else{
                       JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
                case 3:
                   
                    if(clientes.size() > 0 && vagas.size() > 0){
                        opSecundaria = menu.menuGerenciarEstacionamento();
                        if(opSecundaria == 1){
                            funcao.estacionar(vagas, disponiveis, ocupadas, clientes, tickets, dias);
                        } else if(opSecundaria == 2){
                            funcao.retirar(vagas, disponiveis, ocupadas, clientes, tickets, tarifas, dias);
                        } else if(opSecundaria == 3){
                            JOptionPane.showMessageDialog(null, funcao.listaVagas(disponiveis), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
                        } else if(opSecundaria == 4){
                            funcao.gerenciarTarifa(dias);
                        } else if(opSecundaria == 5){

                        } else{
                            JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "O sistema ainda não possui Clientes ou Vagas cadastradas!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                    }
                   
                   break;
                   
                case 4:
                   /*não entendi oq fazer*/
                   break;
                   
                case 5:
                    if(tarifas.size() > 0){
                        funcao.consultaTotalFaturado(tarifas);
                    } else{
                        JOptionPane.showMessageDialog(null, "O sistema ainda não possui lucro cadastrado!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                    }
                   
                   break;
                   
                case 6:
                   
                   sair = true;
                   break;
                   
                default:
                   JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                   break;
           }
       }
    }
    
}
