/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.tarifa;

import estacionabem.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author breno
 */
public class TarifaHorista extends Tarifa{
    DiaDaSemana dia;
    String tipo;
    
    public TarifaHorista(String tipo, DiaDaSemana dia){
        super(tipo);
        this.dia = dia;
    }
    
    @Override
    public long calculaTarifa(LocalDateTime inicio, LocalDateTime fim, Vaga vaga){

        long minutosEstacionados = ChronoUnit.MINUTES.between(inicio.toLocalDate(), fim.toLocalDate());
        long horasEstacionadas = minutosEstacionados / 60;

        double valorTotal = 0;
        if(vaga.getTipo().equals("Moto")){
            valorTotal = this.dia.getValorPrimeiraHoraMoto();
        } else{
            valorTotal = this.dia.getValorPrimeiraHoraCarro();
        }   
        

            
        if(vaga.getTipo().equals("Moto"))
            valorTotal += horasEstacionadas * this.dia.getValorHorasubsequenteMoto();
        else
            valorTotal += horasEstacionadas * this.dia.getValorHorasubsequenteCarro();
            

        super.setValorTotal(valorTotal);
        return horasEstacionadas;
    }
    
}
