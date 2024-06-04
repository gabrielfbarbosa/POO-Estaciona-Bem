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
       
       boolean sair=false;
       
       while(sair = false){
           opPrimaria = menu.menuPrincipal();
           
           switch(opPrimaria){
               
               case 1:
                   opSecundaria = menu.menuGerenciarClientes();
                   if(opSecundaria == 1){
                       funcao.cadastrarCliente(clientes);
                   } else if(opSecundaria == 2){
                       funcao.consultarDocumento(clientes);
                   } else if(opSecundaria == 3){
                       funcao.excluirCliente(clientes);
                   } else if(opSecundaria == 4){
                       funcao.editarCliente(clientes);
                   } else if(opSecundaria == 5){
                       funcao.gerenciarVeiculos(clientes);
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
                       funcao.cadastrarVaga(vagas);
                   } else if(opSecundaria == 2){
                       funcao.consultarVaga(vagas);
                   } else if(opSecundaria == 3){
                       funcao.excluirVaga(vagas);
                   } else if(opSecundaria == 4){
                       funcao.editarVaga(vagas);
                   } else if(opSecundaria == 5){
                       funcao.operacaoAlteraDisponibilidade(vagas, disponiveis, indisponiveis, ocupadas);
                   } else if(opSecundaria == 6){
                       
                   } else{
                       JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
               case 3:
                   
                   opSecundaria = menu.menuGerenciarEstacionamento();
                   if(opSecundaria == 1){
                       
                   } else if(opSecundaria == 2){
                       
                   } else if(opSecundaria == 3){
                       
                   } else if(opSecundaria == 4){
                       
                   } else if(opSecundaria == 5){
                       
                   } else{
                       JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
                   
               case 4:
                   
                   break;
                   
               case 5:
                   
                   break;
                   
               case 6:
                   
                   sair = true;
                   break;
           }
       }
    }
    
}
