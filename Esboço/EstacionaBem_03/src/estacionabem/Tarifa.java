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

    
    public Tarifa(Ticket ticket, DiaDaSemana[] dias) {
        this.diaSaida = defineDia(ticket.getInicio().getDayOfWeek().getValue(), dias);
        this.ticket = ticket;
        this.valorTotal = calculaTarifa(dias);
        
    }

    public DiaDaSemana defineDia(int numDia, DiaDaSemana[] dias)
    {
        DiaDaSemana dia = new DiaDaSemana("");
        switch(numDia){
            case 1:
                dia.setDia("Domingo");
                dia.setValorHorasubsequente(dias[0].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[0].getValorPrimeiraHora());
                break;
            case 2:
                dia.setDia("Segunda");
                dia.setValorHorasubsequente(dias[1].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[1].getValorPrimeiraHora());
                break;   
            case 3:
                dia.setDia("Terça");
                dia.setValorHorasubsequente(dias[2].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[2].getValorPrimeiraHora());
                break;
            case 4:
                dia.setDia("Quarta");
                dia.setValorHorasubsequente(dias[3].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[3].getValorPrimeiraHora());
                break;
            case 5:
                dia.setDia("Quinta");
                dia.setValorHorasubsequente(dias[4].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[4].getValorPrimeiraHora());
                break;
            case 6:
                dia.setDia("Sexta");
                dia.setValorHorasubsequente(dias[5].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[5].getValorPrimeiraHora());
                break;
            case 7:
                dia.setDia("Sabado");
                dia.setValorHorasubsequente(dias[6].getValorHorasubsequente());
                dia.setValorPrimeiraHora(dias[6].getValorPrimeiraHora());
                break;    
        }
        return dia;
    }
    
    public double calculaTarifa(DiaDaSemana[] diasDaSemana){
        double valorTotal = this.diaSaida.getValorPrimeiraHora();
        long diasCompletos = ChronoUnit.DAYS.between(this.ticket.getInicio().toLocalDate(), this.ticket.getFim().toLocalDate());
        long minutosEstacionados = ChronoUnit.MINUTES.between(this.ticket.getInicio(), this.ticket.getFim());
        long horasEstacionadas = minutosEstacionados / 60;

        
        valorTotal += horasEstacionadas * this.diaSaida.getValorHorasubsequente();
        if (diasCompletos == 0){
            
        }else{
            
        }
        return valorTotal;
        
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
