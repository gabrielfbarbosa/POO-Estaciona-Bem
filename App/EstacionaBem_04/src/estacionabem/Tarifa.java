/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author breno
 */
public class Tarifa {
    private DiaDaSemana diaSaida;
    private Ticket ticket;
    private long horasEstacionadas;
    private double valorTotal;

    
    public Tarifa(Ticket ticket, DiaDaSemana dia) {
        this.diaSaida = dia;
        this.ticket = ticket;    
    }

    
    
    
    public DiaDaSemana buscaDia(DiaDaSemana[] diasDaSemana, String strDia){
        
        for(DiaDaSemana dia : diasDaSemana){
            if(dia.getDia().equals(strDia)){
                return dia;
            }
        }
        return null;
    }

    public String toString(){
            String saida="";
            saida += "Dia da entrada: " + this.ticket.getInicio() + "\n";
            saida += "Dia da saida: " + this.diaSaida + "\n";
            saida += "Horas totais: " + this.horasEstacionadas + "\n";
            saida += "==================================\n";
            saida += "Total a pagar: " + this.valorTotal + "\n";
            return saida;
        }
    
    public double getValorTotal() {
        return valorTotal;
    }


    public DiaDaSemana getDiaSaida() {
        return diaSaida;
    }

    public void setDiaSaida(DiaDaSemana dia) {
        this.diaSaida = dia;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
}
