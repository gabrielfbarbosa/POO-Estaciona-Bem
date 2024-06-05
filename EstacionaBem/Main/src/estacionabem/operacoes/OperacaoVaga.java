 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

import estacionabem.programa.Tipo;
import estacionabem.ticket.Ticket;
import estacionabem.programa.Vaga;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BrenoTakeshiCamargod
 */
public class OperacaoVaga {
    /*============================Operações 2- Vagas====================================*/
    /*É feito o cadastros das vagas que nao possuirem a mesma combinação de rua e numero, sendo validado pelo buscaVaga
    se for encontrado a mesma combinação no ArrayList de vagas o método retorna o objeto encontrado, se ele for null então o cadastro
    é feito*/
    /*1 - Cadastrar Vaga================================*/
    OperacaoEstacionar opEstacionamento;

    public void cadastrarVaga(ArrayList<Vaga> vagas){

        opEstacionamento = new OperacaoEstacionar();

        int continuar = JOptionPane.YES_OPTION;

        while(continuar == JOptionPane.YES_OPTION){

            JOptionPane.showMessageDialog(null, opEstacionamento.listaVagas(vagas));
            int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira cadastrar:", "123"));
            String rua = JOptionPane.showInputDialog(null, "Digite o nome da rua da vaga que queira cadastrar:", "Rua Tal");
            Vaga vaga = buscaVaga(vagas, numero, rua);

            /*verifica se existe a vaga no ArrayList de vagas*/
            if(vaga == null){

                String strTipo = JOptionPane.showInputDialog(null, "Digite o tipo da nova vaga", "Moto ou Carro");

                /* Caso o usuario escrever de forma diferente da varificação em letra minuscula */
                strTipo = !strTipo.isEmpty() ? strTipo.toLowerCase() : "";

                /*verifica o tipo da vaga*/
                if(strTipo.equals("moto")){

                    Tipo tipo = Tipo.converteString(strTipo);
                    Vaga novaVaga = new Vaga(numero, rua, tipo);
                    vagas.add(novaVaga);
                    JOptionPane.showMessageDialog(null, "Vaga cadastrada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);

                } else if(strTipo.equals("carro")){

                    Tipo tipo = Tipo.converteString(strTipo);
                    Vaga novaVaga = new Vaga(numero, rua, tipo);
                    vagas.add(novaVaga);
                    JOptionPane.showMessageDialog(null, "Vaga cadastrada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);

                } else if(strTipo.equals("onibus")){

                    Tipo tipo = Tipo.converteString(strTipo);
                    Vaga novaVaga = new Vaga(numero, rua, tipo);
                    vagas.add(novaVaga);
                    JOptionPane.showMessageDialog(null, "Vaga cadastrada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);

                }else{

                    JOptionPane.showMessageDialog(null, "Tipo de vaga inválido, verifique se digitou corretamente Motou ou Carro!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);
                }
            } else{

                JOptionPane.showMessageDialog(null, "Combinação entre Rua e número já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }

            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais alguma vaga? ", "Cadastrar Vaga",JOptionPane.YES_NO_OPTION);
        }
    }
    /*Retornará as informações da vaga caso ela exista no ArrayList da vagas*/
    /*2 - Consultar por número================================*/
    public void consultarVaga(ArrayList<Vaga> vagas){

        opEstacionamento = new OperacaoEstacionar();
        Vaga vaga;
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga: ", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga: ", "Rua Tal");
        vaga = buscaVaga(vagas, numero, rua);
        
        /*verifica se existe a vaga no ArrayList de vagas*/
        if(vaga != null){
            JOptionPane.showMessageDialog(null, vaga.toString(), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Combinação entre numero e rua não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /*3 - Excluir Vaga================================*/
    /*Exclui a vaga caso o usuário informe uma combinação de rua e numero de vaga que esteja dentro do ArrayList de vagas,
    essa vaga nao pode ter ticket ativo, se tiver não é feito a exclusão*/
    public void excluirVaga(ArrayList<Vaga> vagas, ArrayList<Ticket> tickets){

        opEstacionamento = new OperacaoEstacionar();
        Vaga vaga;

        JOptionPane.showMessageDialog(null, opEstacionamento.listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira excluir", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Rua Tal");
        vaga = buscaVaga(vagas, numero, rua);
        
        boolean ticketCadastrado = opEstacionamento.buscaVagaTicket(tickets, rua, numero);
        /*verifica se existe a vaga no ArrayList de vagas*/
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        
        /*verifica se a vaga esta ocupada*/
        } else if(ticketCadastrado){
            JOptionPane.showMessageDialog(null, "Não é possível remover Vaga, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);            
        } else{
     
            if(vaga.getDisponibilidade().equals("disponivel") ){
                vagas.remove(vaga);
                
            JOptionPane.showMessageDialog(null, "Vaga Excluído com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /*4 - Editar Vaga================================*/
    /*Edita a vaga caso o usuário informe uma combinação de rua e numero de vaga que esteja dentro do ArrayList de vagas,
    essa vaga nao pode ter ticket ativo, se tiver não é feito a edição, é feitas perguntas  para qual dado o usuário vai querer alterar*/
    public void editarVaga(ArrayList<Vaga> vagas, ArrayList<Ticket> tickets){

        opEstacionamento = new OperacaoEstacionar();
        Vaga vaga;
        JOptionPane.showMessageDialog(null, opEstacionamento.listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira editar", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira editar", "Rua Tal");
        
        vaga = buscaVaga(vagas, numero, rua);
        boolean ticketCadastrado = opEstacionamento.buscaVagaTicket(tickets, rua, numero);
        /*Verifica se existe a vaga*/
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        
        /*Verifica se existe ticket ativo*/    
        } else if(ticketCadastrado){
            JOptionPane.showMessageDialog(null, "Não é possível Alterar Vaga, ele ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);            
        } else{
            JOptionPane.showMessageDialog(null, vaga.toString());
            
            
            int alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o tipo da vaga? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            
            /*Verifica se vai alterar o tipo da vaga*/
            if(alteracao == JOptionPane.YES_OPTION){
                String strTipo = JOptionPane.showInputDialog(null, "Digite o novo tipo de vaga: ", "Moto ou Carro");
                
                /*Verifica o tipo da vaga*/
                if(strTipo.equals("moto") || strTipo.equals("caro") || strTipo.equals("onibus")){
                    Tipo tipo = Tipo.converteString(strTipo);
                    vaga.setTipo(tipo);
                } else{
                    JOptionPane.showMessageDialog(null, "Tipo inválido, confira se você escreveu corretamente Moto ou Carro!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                }
            }
           
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar o numero? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            /*Verifica se vai alterar o numero da vaga*/
            if(alteracao == JOptionPane.YES_OPTION){
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo numero da vaga: ", "123456789"));
            }
            
            alteracao = JOptionPane.showConfirmDialog(null, "Deseja alterar a Rua da vaga? ", "Alterar Vaga",JOptionPane.YES_NO_OPTION);
            /*Verifica se vai alterar a rua da vaga*/
            if(alteracao == JOptionPane.YES_OPTION){
                rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira excluir", "Rua Tal");
            }
            
            vaga = buscaVaga(vagas, numero, rua);
            /*Verifica se a nova alteração não é igual a anterior*/
            if(vaga != null){
                JOptionPane.showMessageDialog(null, "Combinação de numero e rua já cadastrado!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            } else{
                vaga.setNumero(numero);
                vaga.setRua(rua);
            }
            
            
            JOptionPane.showMessageDialog(null, "\"Onde não houve erros\" Vaga Alterada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    /*5- Alterar Disponibilidade================================*/
    public void operacaoAlteraDisponibilidade(ArrayList<Vaga> vagas, ArrayList<Ticket> tickets){

        opEstacionamento = new OperacaoEstacionar();
        Vaga vaga;
        boolean verificador;
        JOptionPane.showMessageDialog(null, opEstacionamento.listaVagas(vagas));

        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira alterar a disponibilidade", "123456789"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira alterar a disponibilidade", "Rua Tal");
        
        vaga = buscaVaga(vagas, numero, rua);
        boolean ticketCadastrado = opEstacionamento.buscaVagaTicket(tickets, rua, numero);
        
        /*Verifica se existe a vaga*/
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Combinação de Rua e numero não encontrada!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
         
        /*Verifica se a vaga não possui ticket ativo*/
        } else if(ticketCadastrado){
            JOptionPane.showMessageDialog(null, "Não é possível alterar a disponibilidade da Vaga, ela ainda possui Ticket Ativado!!", "Gerenciar Veiculos", JOptionPane.ERROR_MESSAGE);            
        } else{
            String disponibilidade = JOptionPane.showInputDialog(null, "Digite uma nova disponibilidade: ");
            verificador = validaDisponibilidade(vagas, vaga, disponibilidade);
            
            /*Caso retorne true a vaga foi alterada se não a disponibilidade é igual*/
            if(verificador){
                vaga.setDisponibilidade(disponibilidade);
                JOptionPane.showMessageDialog(null, "Disponibilidade de Vaga Alterada", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Disponibilidade inválida!!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /*o metodo recebe varias ArrayList para que possa migrar de um para outro, removendo de um e adicionando de outro, cada ArrayList
    representa uma disponibilidade, então a vaga vai ser alterada nas vagas mudando seu campo disponibilidade e depois vai mudar de ArrayList*/
    public boolean validaDisponibilidade(ArrayList<Vaga> vagas, Vaga vaga, String disponibilidade){
        
        /*Caso contrário irá movimentar a vaga de um ArrayList para outro e vai trocar o seu campo disponibilidade*/
        /*Removendo de um ArrayList*/
        if(vaga.getDisponibilidade().equals("disponivel")){
            return true;
        }   else if(vaga.getDisponibilidade().equals("indisponivel")){
            return true;
        } else if(vaga.getDisponibilidade().equals("ocupada")){
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
}
