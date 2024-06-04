package estacionabem.ticket;

import estacionabem.*;
import java.time.LocalDateTime;

public abstract class Ticket {
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Vaga vaga;
    private Veiculo veiculo;
    private estacionabem.tarifa.Tarifa tarifa;

    public Ticket(Vaga vaga, Veiculo veiculo) {
        this.inicio = LocalDateTime.now();
        this.vaga = vaga;
        this.veiculo = veiculo;

    }
    
    public abstract void finalizaTicket();
    
    public String toString(){
        String saida = "";
        saida += "Vaga: " + this.vaga + "\n";
        saida += "Veiculo: " + this.veiculo + "\n";
        saida += "Inicio: " + this.inicio + "\n";
        saida += "Fim: " + this.fim + "\n";
        saida += "----" + "\n" + this.tarifa.toString() + "\n";
        
        return saida;
    }
    
    public estacionabem.tarifa.Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(estacionabem.tarifa.Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
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
