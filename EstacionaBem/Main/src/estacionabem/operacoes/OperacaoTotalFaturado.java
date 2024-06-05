/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

import estacionabem.ticket.Ticket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BrenoTakeshiCamargod
 */
public class OperacaoTotalFaturado {
    /*============================Operações 5- Consultar Total Faturado====================================*/     
    public void consultaTotalFaturado(ArrayList<Ticket> ticketFinalizados){
        
        String strInicio;
        String strFim;
        LocalDate inicio = null;
        LocalDate fim = null;
        
        JOptionPane.showMessageDialog(null, "Consultar total faturado dentre um período", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        
        do {
            
            strInicio = JOptionPane.showInputDialog(null, "Digite o início do período: ", "DD/MM/AAAA");
            
            if(!validarData(strInicio)) {
                JOptionPane.showMessageDialog(null, "Insira uma data de Início no formato Dia/Mes/Ano");
            }
            
        } while(!validarData(strInicio));
        
        
        do {
            
            strFim = JOptionPane.showInputDialog(null, "Digite o fim do período: ", "DD/MM/AAAA");
             
            if(!validarData(strFim)) {
                JOptionPane.showMessageDialog(null, "Insira uma data de Fim no formato Dia/Mes/Ano");
            }
            
        } while(!validarData(strFim));
        
            
        inicio = LocalDate.parse(strInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
        fim = LocalDate.parse(strFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        double totalFaturado = 0;
        LocalDate dataTarifa;
        for(Ticket ticket : ticketFinalizados){
            dataTarifa = ticket.getFim().toLocalDate();
            
            if(!dataTarifa.isBefore(inicio) && !dataTarifa.isAfter(fim)){
                totalFaturado += ticket.getTarifa().getValorTotal();
            }
        }
        
        if(totalFaturado == 0){
            JOptionPane.showMessageDialog(null, "Não houve fatura dentre esse período", "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Total da fatura entre " + strInicio + " e " + strFim + "\nR$ " + totalFaturado, "Estaciona Bem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private boolean validarData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}
