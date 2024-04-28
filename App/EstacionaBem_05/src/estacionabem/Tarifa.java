package estacionabem;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Tarifa {
    
    private DiaDaSemana diaSaida;
    private Ticket ticket;
    private long horasEstacionadas;
    private double valorTotal;
    private static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    
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
            saida += "Dia da entrada: " + FORMATADOR_DATA_HORA.format(this.ticket.getInicio()) + "\n";
            saida += "Dia da saida: " + FORMATADOR_DATA_HORA.format(this.ticket.getFim()) + "\n";
            saida += "Horas estacionadas: " + this.horasEstacionadas + "\n";
            saida += "==================================\n";
            saida += "Total a pagar: " + this.valorTotal + "\n";
            return saida;
        }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
