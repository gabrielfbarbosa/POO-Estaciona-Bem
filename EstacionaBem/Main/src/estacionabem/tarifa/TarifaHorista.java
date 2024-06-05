/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.tarifa;

import estacionabem.programa.TabelaValores;
import estacionabem.programa.Tipo;
import estacionabem.programa.Vaga;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author breno
 */
public class TarifaHorista extends Tarifa{
    TabelaValores dia;
    
    public TarifaHorista(Tipo tipo, TabelaValores dia){
        super(tipo);
        this.dia = dia;
    }
    
    @Override
    public long calculaTarifa(LocalDateTime inicio, LocalDateTime fim, Vaga vaga){

        long minutosEstacionados = ChronoUnit.MINUTES.between(inicio, fim);
        long horasEstacionadas = minutosEstacionados / 60;
        long minutosRestantes = minutosEstacionados % 60;

        double valorTotal = 0;

        if(vaga.getTipo().equals("Moto")){

            valorTotal = this.dia.getValorPrimeiraHoraMoto();

            if (horasEstacionadas > 0) {
                valorTotal += (horasEstacionadas - 1) * this.dia.getValorHorasubsequenteMoto();
            }
            if (minutosRestantes > 0) {
                valorTotal += this.dia.getValorHorasubsequenteMoto();
            }
        } else{

            valorTotal = this.dia.getValorPrimeiraHoraCarro();

            if (horasEstacionadas > 0) {
                valorTotal += (horasEstacionadas - 1) * this.dia.getValorHorasubsequenteCarro();
            }
            if (minutosRestantes > 0) {
                valorTotal += this.dia.getValorHorasubsequenteCarro();
            }
        }   
        

            
//        if(vaga.getTipo().equals("Moto"))
//            valorTotal += horasEstacionadas * this.dia.getValorHorasubsequenteMoto();
//        else
//            valorTotal += horasEstacionadas * this.dia.getValorHorasubsequenteCarro();
            

        super.setValorTotal(valorTotal);
        return horasEstacionadas;
    }
    
}
