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
import estacionabem.tarifa.Tarifa;
import estacionabem.ticket.Ticket;
import estacionabem.ticket.TicketHorista;

public class Estacionamento {

    public static void main(String[] args) {
       
       Menus menu = new Menus();
       estacionabem.operacoes.OperacoesEstacionamento funcao = new estacionabem.operacoes.OperacoesEstacionamento();
       int opPrimaria, opSecundaria;
       
       ArrayList<Cliente> clientes = new ArrayList<Cliente>();
       ArrayList<Vaga> vagas = new ArrayList<Vaga>() ;
       ArrayList<Vaga> indisponiveis = new ArrayList<Vaga>();
       ArrayList<TicketHorista> ticketsHoristas = new ArrayList<TicketHorista>();
       ArrayList<TicketMensalista> ticketsMensais = new ArrayList<TicketMensalista>();
       ArrayList<Ticket> ticketsFinalizados = new ArrayList<Ticket>();
       
       
       ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
       Cliente c1 = new Cliente("Brenildu", "123", veiculos);
       Tipo[] tipos = Tipo.values();
       Veiculo v1 = new Veiculo("Placa X",  c1, Tipo.CARRO);
       c1.getVeiculos().add(v1);
       Veiculo v2 = new Veiculo("Placa Y",  c1, Tipo.MOTO);
       c1.getVeiculos().add(v2);
       Veiculo v3 = new Veiculo("Placa Z",  c1, Tipo.ONIBUS);
       c1.getVeiculos().add(v3);
       clientes.add(c1);
       
       
       Vaga vaga1 = new Vaga(123, "Rua Tal", Tipo.MOTO);
       vagas.add(vaga1);
       Vaga vaga2 = new Vaga(124, "Rua Tal", Tipo.CARRO);
       vagas.add(vaga2);
       Vaga vaga3 = new Vaga(125, "Rua Tal", Tipo.ONIBUS);
       vagas.add(vaga3);
       
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
                       funcao.getOpCliente().cadastrarCliente(clientes);
                   } else if(opSecundaria == 2){
                       funcao.getOpCliente().consultarDocumento(clientes);
                   } else if(opSecundaria == 3){
                       funcao.getOpCliente().excluirCliente(clientes, tickets);
                   } else if(opSecundaria == 4){
                       funcao.getOpCliente().editarCliente(clientes, tickets);
                   } else if(opSecundaria == 5){
                       funcao.getOpCliente().gerenciarVeiculos(clientes, tickets);
                   } else if(opSecundaria == 6){
                       funcao.getOpCliente().listaCadastros(clientes);
                   } else if(opSecundaria == 7){
                       
                   } else{
                       JOptionPane.showMessageDialog(null, "Opção Inválida!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
                   
                case 2:
/*===============================================2 - Gerenciar vagas===============================================*/                   
                   opSecundaria = menu.menuGerenciarVagas();
                   if(opSecundaria == 1){
                       funcao.getOpVaga().cadastrarVaga(vagas);
                   } else if(opSecundaria == 2){
                       funcao.getOpVaga().consultarVaga(vagas);
                   } else if(opSecundaria == 3){
                       funcao.getOpVaga().excluirVaga(vagas, tickets);
                   } else if(opSecundaria == 4){
                       funcao.getOpVaga().editarVaga(vagas, tickets);
                   } else if(opSecundaria == 5){
                       funcao.getOpVaga().operacaoAlteraDisponibilidade(vagas, tickets);
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
                            funcao.getOpEstacionar().estacionar(vagas, clientes, ticketsHoristas, ticketsMensais, valores);
                        } else if(opSecundaria == 2){
                            funcao.getOpEstacionar().retirar(vagas,clientes, ticketsHoristas, ticketsMensais, ticketsFinalizados, valores);
                        } else if(opSecundaria == 3){
                            JOptionPane.showMessageDialog(null, funcao.getOpEstacionar().listaVagas(vagas), "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
                        } else if(opSecundaria == 4){
                            funcao.getOpEstacionar().gerenciarTarifa(valores);
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
                        funcao.getOpTotalFaturado().consultaTotalFaturado(ticketsFinalizados);
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
