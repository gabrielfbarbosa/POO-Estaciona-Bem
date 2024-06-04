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
public class TarifaMensalista extends Tarifa{
    
    double valorUnico;

    public TarifaMensalista(Tipo tipo, double valor){
        super(tipo);
        this.valorUnico = valor;
    }
    
    @Override
    public long calculaTarifa(LocalDateTime inicio, LocalDateTime fim, Vaga vaga) {
        double valorTotal;
        long diasCompletos = ChronoUnit.DAYS.between(inicio.toLocalDate(), fim.toLocalDate());

        valorTotal = this.valorUnico;
        if(vaga.getTipo().equals("Moto"))
            valorTotal += diasCompletos * this.valorUnico;
        else
            valorTotal += diasCompletos * this.valorUnico;
            
         
        super.setValorTotal(valorTotal);
        return diasCompletos;
    }
}
