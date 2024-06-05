/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

import estacionabem.programa.Cliente;
import estacionabem.programa.TabelaValores;
import estacionabem.ticket.Ticket;
import estacionabem.programa.Vaga;
import estacionabem.programa.Veiculo;
import estacionabem.ticket.TicketHorista;
import estacionabem.ticket.TicketMensalista;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BrenoTakeshiCamargod
 */
public class OperacaoEstacionar {
    /*============================Operações 3- Estacionamento====================================*/   
    
    /*1 - Estacionar================================*/
    
    OperacaoVaga opVaga;

    
    public void estacionar(ArrayList<Vaga> vagas ,ArrayList<Cliente> clientes, ArrayList<TicketHorista> ticketsHoristas, ArrayList<TicketMensalista> ticketsMensais, TabelaValores[] dias){

        opVaga = new OperacaoVaga();
        OperacaoCliente opCliente = new OperacaoCliente();
        Vaga vaga;
        
        JOptionPane.showMessageDialog(null, listaVagas(vagas));
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da vaga que queira estacionar", "123"));
        String rua = JOptionPane.showInputDialog(null, "Digite a Rua da vaga que queira estacionar", "Rua Tal");
        
        vaga = opVaga.buscaVaga(vagas, numero, rua);
        
        if(vaga == null){
            JOptionPane.showMessageDialog(null, "Vaga não encontrada!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        } else{
            
            if(vaga.getDisponibilidade().equals("Disponivel") ){
                String documento = JOptionPane.showInputDialog(null, "Digite o documento do cliente:", "123");
                Cliente cliente = opCliente.buscaCliente(clientes, documento);

                if(cliente == null){
                    JOptionPane.showMessageDialog(null, "Cliente não encontrados!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
                } else{
                    String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo:", "Placa Y");
                    Veiculo veiculo = cliente.buscaVeiculo(placa);

                    if(veiculo == null){
                        JOptionPane.showMessageDialog(null, "Veiculo não encontrado!", "Estaciona Bem",JOptionPane.ERROR_MESSAGE);
                    } else if(veiculo.getTipo().equals(vaga.getTipo())){
                        vaga.setDisponibilidade("ocupada");

                        Ticket ticket;
                        do{
                            String strTipo = JOptionPane.showInputDialog(null, "Como deseja gerar o ticket, Mensal ou Hora", "Mensal/Hora");
                            strTipo = strTipo.toLowerCase();
                            if(strTipo.equals("mensal")){
                        
                                ticket = new TicketMensalista(vaga, veiculo, TabelaValores.INTEGRAL.getValorHorasubsequenteMoto());
                                ticketsMensais.add( (TicketMensalista) ticket);
                                break;
                            }
                            
                            if(strTipo.equals("hora")){
                                int dia = LocalDateTime.now().getDayOfWeek().getValue();
                        
                                ticket = new TicketHorista(vaga,veiculo, dias[dia-1]);
                                ticketsHoristas.add( (TicketHorista) ticket);
                                break;
                            } 
                            
                        }while(true);
                       
                        
                        /*função para começar a contar o tempo e criar o ticket*/
                        JOptionPane.showMessageDialog(null, "Estacionamento iniciado com sucesso!!", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);

                    } else{
                        JOptionPane.showMessageDialog(null, "Veiculo não possui o mesmo tipo que a vaga desejada!", "Estaciona Bem",JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else{
                JOptionPane.showMessageDialog(null, "Vaga indisponivel ou ocupada!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);

            }   
        }
    }
    
    
    /*2 - Retirar================================*/
    public void retirar(ArrayList<Vaga> vagas, ArrayList<Cliente> clientes, ArrayList<TicketHorista> ticketsHoristas,  ArrayList<TicketMensalista> ticketsMensais, ArrayList<Ticket> ticketsFinalizados ,TabelaValores[] dias){

        opVaga = new OperacaoVaga();
        String placa = JOptionPane.showInputDialog(null, "Digite a placa do veiculo que irá retirar:", "Placa Y");
        
        TicketHorista ticketHorista = buscaTicketHorista(ticketsHoristas, placa);
        TicketMensalista ticketMensalista = buscaTicketMensalista(ticketsMensais, placa);
        
        if(ticketHorista == null && ticketMensalista == null){
            JOptionPane.showMessageDialog(null, "Ticket não encontrado!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
        } else if(ticketHorista != null){
            
            ticketHorista.finalizaTicket();
            ticketsFinalizados.add(ticketHorista);
            
            Vaga vaga = opVaga.buscaVaga(vagas, ticketHorista.getVaga().getNumero(), ticketHorista.getVaga().getRua());
            vaga.setDisponibilidade("Disponivel");
            
            JOptionPane.showMessageDialog(null, ticketHorista.toString());
        } else{
            ticketMensalista.finalizaTicket();
            ticketsFinalizados.add(ticketMensalista);
            
            Vaga vaga = opVaga.buscaVaga(vagas, ticketMensalista.getVaga().getNumero(), ticketMensalista.getVaga().getRua());
            vaga.setDisponibilidade("Disponivel");
            
            JOptionPane.showMessageDialog(null, ticketMensalista.toString());
        }
    }
    
    
    /*3 - Listar todas as vagas================================*/
    public String listaVagas(ArrayList<Vaga> vagas){
        String saida="";
        saida += "---Lista de vagas---\n";
        for(Vaga vaga : vagas){

            if(vaga.getDisponibilidade().equals("Disponivel"))
                saida += "*-*Vaga: \n" + vaga.toString();
            
        }
        return saida;
    }
    
    /*4 - Gerenciar Tarifas================================*/
    public void gerenciarTarifa(TabelaValores[] dias){
        int numDia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o dia que você quer gerenciar: 1-domingo, 2-segunda.... até 7-sabado", "Numero de 1 a 7"));
        String tipo = JOptionPane.showInputDialog(null, "Qual o tipo da vaga: ", "Moto ou Carro");
        
        if(tipo.equals("Moto") && numDia > 0 && numDia < 8){
            int novoPrimeiro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da primeira hora:"));
            int novoSegundo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da hora subsquente:"));
            dias[numDia].setValorPrimeiraHoraMoto(novoPrimeiro);
            dias[numDia].setValorHorasubsequenteMoto(novoSegundo);
        }else if(tipo.equals("Carro") && numDia > 0 && numDia < 8){
            int novoPrimeiro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da primeira hora:"));
            int novoSegundo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual o novo valor da hora subsquente:"));
            dias[numDia].setValorPrimeiraHoraCarro(novoPrimeiro);
            dias[numDia].setValorHorasubsequenteCarro(novoSegundo);
        } else{
            JOptionPane.showMessageDialog(null, "Tipo inválido, confira se você digitou Moto ou Carro corretamente, Ou Dia inválido!", "Estaciona Bem", JOptionPane.ERROR_MESSAGE);
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
    
    public TicketHorista buscaTicketHorista(ArrayList<TicketHorista> ticketsHoristas, String placa){
        
        for(TicketHorista ticket: ticketsHoristas){
            if(ticket.getVeiculo().getPlaca().equals(placa)){
                return ticket;
            }
        }
        return null;
    }

    public TicketMensalista buscaTicketMensalista(ArrayList<TicketMensalista> ticketsMensalistas, String placa){

        for(TicketMensalista ticket: ticketsMensalistas){
            if(ticket.getVeiculo().getPlaca().equals(placa)){
                return ticket;
            }
        }
        return null;
    }
    
    
    
/*============================Operações 3- Estacionamento====================================*/


/*------------------------------------------------------------------------------------*/  
}
