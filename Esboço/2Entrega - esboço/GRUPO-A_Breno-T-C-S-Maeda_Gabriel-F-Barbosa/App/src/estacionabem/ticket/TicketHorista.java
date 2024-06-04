/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.ticket;

import estacionabem.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author breno
 */
public class TicketHorista extends Ticket{

    TabelaValores dia;
    long horasEstacionadas;
    
    public TicketHorista(Vaga vaga, Veiculo veiculo, TabelaValores dia){
        super(vaga, veiculo);
        this.dia = dia;
        
        estacionabem.tarifa.TarifaHorista tarifa = new estacionabem.tarifa.TarifaHorista(veiculo.getTipo(), dia);
        super.setTarifa(tarifa);
    }

    @Override
    public void finalizaTicket() {
        super.setFim(LocalDateTime.now());
        
        
        this.horasEstacionadas = super.getTarifa().calculaTarifa(super.getInicio(), super.getFim(), super.getVaga());
    }
    
    @Override
    public String toString(){
        String saida = "";
        saida += super.toString() + "\n";
        saida += "Dia da semana: " + this.dia.toString() + "\n";
        saida += "Total de horas estacionadas: " + this.horasEstacionadas;
        
        return saida;
    }
}
