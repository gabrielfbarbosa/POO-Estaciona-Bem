package estacionabem;

import javax.swing.JOptionPane;

/**
 *
 * @author BRENO TAKESHI CAMARGO DA SILVA MAEDA
 * @author GABRIEL FELIPE BARBOSA
 * 
 */

public class Menus {
    
    public int menuPrincipal(){
        String menu = "";
        String entrada = "";
        int op = 0;
        
        menu += "Escolha uma opção:\n";
        menu += "1- Gerenciar Clientes\n";
        menu += "2 - Gerenciar vagas\n";
        menu += "3 - Gerenciar estacionamento\n";
        menu += "4 - Cadastros gerais\n";
        menu += "5 - Consultar total faturado em um período\n";
        menu += "6 - Sair do programa\n";        
        
        entrada = JOptionPane.showInputDialog(null,menu, "numero de 1 a 6");
        
            
        if(entrada.matches("1") || entrada.matches("2") || entrada.matches("3") || entrada.matches("4") || entrada.matches("5") || entrada.matches("6")) {

            op = Integer.parseInt(entrada);

        } else {

            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números.");
        }
        
        
        return op;
    }
    
    public int menuGerenciarClientes(){
        String menu = "";
        String entrada;
        int op = 0;
        
        menu += "1 - Cadastrar\n";
        menu += "2 - Consultar por documento\n";
        menu += "3 - Excluir\n";
        menu += "4 - Editar\n";
        menu += "5 - Gerenciar veículos\n";
        menu += "6 - Listar todos os cadastros\n";
        menu += "7 - Voltar\n";

        entrada = JOptionPane.showInputDialog(null,menu, "numero de 1 a 6");
        
        if(entrada.matches("1") || entrada.matches("2") || entrada.matches("3") || entrada.matches("4") || entrada.matches("5") || entrada.matches("6")) {
            op = Integer.parseInt(entrada);
            
        } else {
             JOptionPane.showMessageDialog(null, "Por favor, insira apenas números.");
        }
        return op;
    }
    
    public int menuGerenciarVeiculos(){
        String menu = "";
        String entrada;
        int op = 0;
        
        menu += "1 - Cadastrar novo veiculo\n";
        menu += "2 - Excluir\n";
        menu += "3 - Editar\n";
        menu += "4 - Voltar\n";

        entrada = JOptionPane.showInputDialog(null,menu, "numero de 1 a 6");
        
        if(entrada.matches("1") || entrada.matches("2") || entrada.matches("3") || entrada.matches("4") || entrada.matches("5") || entrada.matches("6")) {
            op = Integer.parseInt(entrada);
            
        } else {
             JOptionPane.showMessageDialog(null, "Por favor, insira apenas números.");
        }
        return op;
    }
    
    public int menuGerenciarVagas(){
        String menu = "";
        String entrada;
        int op = 0;
        
        menu += "1 - Cadastrar\n";
        menu += "2 - Consultar por número\n";
        menu += "3 - Excluir\n";
        menu += "4 - Editar\n";
        menu += "5 - Alterar disponibilidade\n";
        menu += "6- Voltar\n";
        menu += "\n";
        
        entrada = JOptionPane.showInputDialog(null,menu, "numero de 1 a 6");
        
        if(entrada.matches("1") || entrada.matches("2") || entrada.matches("3") || entrada.matches("4") || entrada.matches("5") || entrada.matches("6")) {
            op = Integer.parseInt(entrada);
            
        } else {
             JOptionPane.showMessageDialog(null, "Por favor, insira apenas números.");
        }
        return op;
    }
    
    public int menuGerenciarEstacionamento(){
        String menu= "";
        String entrada;
        int op = 0;
        
        menu += "1 - Estacionar\n";
        menu += "2 - Retirar\n";
        menu += "3 - Listar todas as vagas disponíveis\n";
        menu += "4 - Gerenciar tarifas\n";
        menu += "5 - Voltar\n";
        
        entrada = JOptionPane.showInputDialog(null,menu, "numero de 1 a 6");
        
        if(entrada.matches("1") || entrada.matches("2") || entrada.matches("3") || entrada.matches("4") || entrada.matches("5") || entrada.matches("6")) {
            op = Integer.parseInt(entrada);
            
        } else {
             JOptionPane.showMessageDialog(null, "Por favor, insira apenas números.");
        }
        return op;
    }
}
