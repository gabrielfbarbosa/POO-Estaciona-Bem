package estacionabem.ticket;

import estacionabem.programa.Vaga;
import estacionabem.programa.Veiculo;
import estacionabem.tarifa.Tarifa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Ticket {
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Vaga vaga;
    private Veiculo veiculo;
    private Tarifa tarifa;
    private static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Ticket(Vaga vaga, Veiculo veiculo) {
        this.inicio = LocalDateTime.now();
        this.vaga = vaga;
        this.veiculo = veiculo;

    }
    
    public abstract void finalizaTicket();
    
    public String toString(){
        String saida = "";
        saida += "--- Vaga ----" + "\n" + this.vaga + "\n";
        saida += "--- Veiculo ---" + "\n" + this.veiculo + "\n";
        saida += "Inicio: " + FORMATADOR_DATA_HORA.format(this.inicio) + "\n";
        saida += "Fim: " + FORMATADOR_DATA_HORA.format(this.fim) + "\n";
        saida += "----" + "\n" + this.tarifa.toString() + "\n";
        
        return saida;
    }
    
    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
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
