/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.ticket;

import estacionabem.programa.Vaga;
import estacionabem.programa.Veiculo;

import java.time.LocalDateTime;


public class TicketMensalista extends Ticket{

    double valorUnico;
    long quantidadeDias;

    public TicketMensalista(Vaga vaga, Veiculo veiculo, double valor){
        super(vaga, veiculo);
        this.valorUnico = valor;
        
        estacionabem.tarifa.TarifaMensalista tarifa = new estacionabem.tarifa.TarifaMensalista(veiculo.getTipo(), valor);
        super.setTarifa(tarifa);
    }
    
    @Override
    public void finalizaTicket() {
        super.setFim(LocalDateTime.now());
        
        this.quantidadeDias = super.getTarifa().calculaTarifa(super.getInicio(), super.getFim(), super.getVaga());
    }
    
    @Override
    public String toString(){
        String saida = "";
        saida += super.toString() + "\n";
        saida += "Valor Unico integral: " + this.valorUnico;
        saida += "Total de dias estacionados: " + this.quantidadeDias;
        return saida;
    }
    
}
