package estacionabem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ticket {
    private double ValorHorasubsequente;
    private double ValorPrimeiraHora;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Vaga vaga;
    private Veiculo veiculo;

    public Ticket(Vaga vaga, Veiculo veiculo, DiaDaSemana dia) {
        this.inicio = LocalDateTime.now();
        this.vaga = vaga;
        this.veiculo = veiculo;
        
        if(vaga.getTipo().equals("Moto")){
            this.ValorHorasubsequente = dia.getValorHorasubsequenteMoto();
            this.ValorPrimeiraHora = dia.getValorPrimeiraHoraMoto();
        } else{
            this.ValorHorasubsequente = dia.getValorHorasubsequenteCarro();
            this.ValorPrimeiraHora = dia.getValorPrimeiraHoraCarro();
        }
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

    public double getValorHorasubsequente() {
        return ValorHorasubsequente;
    }

    public double getValorPrimeiraHora() {
        return ValorPrimeiraHora;
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
