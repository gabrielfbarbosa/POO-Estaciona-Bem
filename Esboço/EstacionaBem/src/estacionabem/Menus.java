/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class Menus {
    
    public int menuPrincipal(){
        String menu = "";
        menu += "Escolha uma opção:\n";
        menu += "1- Gerenciar Clientes\n";
        menu += "2 - Gerenciar vagas\n";
        menu += "3 - Gerenciar estacionamento\n";
        menu += "4 - Cadastros gerais\n";
        menu += "5 - Consultar total faturado em um período\n";
        menu += "6 - Sair do programa\n";        
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(null,menu, "Menu Principal"));
        return op;
    }
    
    public int menuGerenciarClientes(){
        String menu = "";
        menu += "1 - Cadastrar\n";
        menu += "2 - Consultar por documento\n";
        menu += "3 - Excluir\n";
        menu += "4 - Editar\n";
        menu += "5 - Gerenciar veículos\n";
        menu += "6 - Listar todos os cadastros\n";
        menu += "7 - Voltar\n";

        int op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu Gerenciamento de Clientes", JOptionPane.INFORMATION_MESSAGE));
        return op;
    }
    
    
    public int menuGerenciarVagas(){
        String menu = "";
        menu += "1 - Cadastrar\n";
        menu += "2 - Consultar por número\n";
        menu += "3 - Excluir\n";
        menu += "4 - Editar\n";
        menu += "5 - Alterar disponibilidade\n";
        menu += "6- Voltar\n";
        menu += "\n";
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu Gerenciamento de Vagas", JOptionPane.INFORMATION_MESSAGE));
        return op;
    }
    
    public int menuGerenciarEstacionamento(){
        String menu= "";
        menu += "1 - Estacionar\n";
        menu += "2 - Retirar\n";
        menu += "3 - Listar todas as vagas disponíveis\n";
        menu += "4 - Gerenciar tarifas\n";
        menu += "5 - Voltar\n";
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu Gerenciamento de Estacionamento", JOptionPane.INFORMATION_MESSAGE));
        return op;
    }
    
    
}
