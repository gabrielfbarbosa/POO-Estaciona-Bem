/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author breno
 */
public class Ticket {
    private DiaDaSemana dia;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Vaga vaga;
    private Veiculo veiculo;

    public Ticket(Vaga vaga, Veiculo veiculo) {
        this.inicio = LocalDateTime.now();
        this.vaga = vaga;
        this.veiculo = veiculo;
    }

    
    
    public long finalizaTicket(){
        this.fim = LocalDateTime.now();
        long minutosEstacionado = ChronoUnit.MINUTES.between(this.inicio, this.fim);
        long horasEstacionadas = minutosEstacionado/60;
        
        if(minutosEstacionado%60 > 0){
            horasEstacionadas++;
        }
        
        return horasEstacionadas;
    }

    
    public Vaga getVaga() {
        return vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    

    
    public LocalDateTime getFim() {
        return fim;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    
}
