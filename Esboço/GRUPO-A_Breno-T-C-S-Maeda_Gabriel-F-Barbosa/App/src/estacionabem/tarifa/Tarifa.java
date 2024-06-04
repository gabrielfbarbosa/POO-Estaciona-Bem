package estacionabem.tarifa;

import estacionabem.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Tarifa {
    
    private String tipo;
    private double valorTotal;
    private static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    
    public Tarifa(String tipo) {
        this.tipo = tipo;
    }
    
    public abstract long calculaTarifa(LocalDateTime inicio, LocalDateTime fim, Vaga vaga);
    
    public String toString(){
            String saida="";
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


}
