package estacionabem;

/**
 *
 * @author BRENO TAKESHI CAMARGO DA SILVA MAEDA
 * @author GABRIEL FELIPE BARBOSA
 * 
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

import estacionabem.operacoes.OperacoesEstacionamento;
import estacionabem.popularprograma.PopularPrograma;
import estacionabem.programa.Cliente;
import estacionabem.programa.Menus;
import estacionabem.programa.TabelaValores;
import estacionabem.programa.Vaga;
import estacionabem.ticket.Ticket;
import estacionabem.ticket.TicketHorista;
import estacionabem.ticket.TicketMensalista;

public class EstacionaBemMain {

    public static void main(String[] args) {
       
        Menus menu = new Menus();
        OperacoesEstacionamento operacoesEstacionamento = new OperacoesEstacionamento();
        int opPrimaria, opSecundaria;

        ArrayList<Cliente> clientes = PopularPrograma.createClientes();
        ArrayList<Vaga> vagas = PopularPrograma.createVagas();
        ArrayList<Vaga> indisponiveis = new ArrayList<Vaga>();

        //Esse dois pode ser so um
        ArrayList<TicketHorista> ticketsHoristas = new ArrayList<TicketHorista>();
        ArrayList<TicketMensalista> ticketsMensais = new ArrayList<TicketMensalista>();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        ArrayList<Ticket> ticketsFinalizados = new ArrayList<Ticket>();


        /*Criação de tarifas de cada dia padrão, tendo apenas um posição para cada dia,
        DiaDaSemana possui uma string que é do dia, 4 valores double que são 2 valores para moto e 2 para carro, inicialializados com um valor
        padrão para que o usuário não precise criar 1 por 1, caso haja alterações é possivel se fazer*/
        TabelaValores[] valores = TabelaValores.values();


        /*O menu principal será mostrado até o usuário pedir para sair*/
        boolean sair=false;
       
        while(sair == false){
        opPrimaria = menu.menuPrincipal();

        switch(opPrimaria){
        /*===============================================1 - Gerenciar clientes===============================================*/
            case 1:
                opSecundaria = menu.menuGerenciarClientes();
                if(opSecundaria == 1){
                    operacoesEstacionamento.getOpCliente().cadastrarCliente(clientes);
                } else if(opSecundaria == 2){
                    operacoesEstacionamento.getOpCliente().consultarDocumento(clientes);
                } else if(opSecundaria == 3){
                    operacoesEstacionamento.getOpCliente().excluirCliente(clientes, tickets);
                } else if(opSecundaria == 4){
                    operacoesEstacionamento.getOpCliente().editarCliente(clientes, tickets);
                } else if(opSecundaria == 5){
                    operacoesEstacionamento.getOpCliente().gerenciarVeiculos(clientes, tickets);
                } else if(opSecundaria == 6){
                    operacoesEstacionamento.getOpCliente().listaCadastros(clientes);
                } else if(opSecundaria == 7){

                } else{
                JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                }
            break;

            case 2:
        /*===============================================2 - Gerenciar vagas===============================================*/
                opSecundaria = menu.menuGerenciarVagas();
                if(opSecundaria == 1){
                   operacoesEstacionamento.getOpVaga().cadastrarVaga(vagas);
                } else if(opSecundaria == 2){
                   operacoesEstacionamento.getOpVaga().consultarVaga(vagas);
                } else if(opSecundaria == 3){
                   operacoesEstacionamento.getOpVaga().excluirVaga(vagas, tickets);
                } else if(opSecundaria == 4){
                   operacoesEstacionamento.getOpVaga().editarVaga(vagas, tickets);
                } else if(opSecundaria == 5){
                   operacoesEstacionamento.getOpVaga().operacaoAlteraDisponibilidade(vagas, tickets);
                } else if(opSecundaria == 6){

                } else{
                   JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case 3:
        /*===============================================3 - Gerenciar estacionamento===============================================*/
                if(clientes.size() > 0 && vagas.size() > 0){
                    opSecundaria = menu.menuGerenciarEstacionamento();
                    if(opSecundaria == 1){
                        operacoesEstacionamento.getOpEstacionar().estacionar(vagas, clientes, ticketsHoristas, ticketsMensais, valores);
                    } else if(opSecundaria == 2){
                        operacoesEstacionamento.getOpEstacionar().retirar(vagas,clientes, ticketsHoristas, ticketsMensais, ticketsFinalizados, valores);
                    } else if(opSecundaria == 3){
                        JOptionPane.showMessageDialog(null, operacoesEstacionamento.getOpEstacionar().listaVagas(vagas), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
                    } else if(opSecundaria == 4){
                        operacoesEstacionamento.getOpEstacionar().gerenciarTarifa(valores);
                    } else if(opSecundaria == 5){

                    } else{
                        JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "O sistema ainda não possui Clientes ou Vagas cadastradas!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                }

               break;

            case 4:
        /*===============================================4 - Cadastros gerais===============================================*/
                /*não entendi oq fazer*/
               break;

            case 5:
        /*===============================================5 - Consultar total faturado em um período===============================================*/
                if(ticketsFinalizados.size() > 0){
                    operacoesEstacionamento.getOpTotalFaturado().consultaTotalFaturado(ticketsFinalizados);
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
