/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

import java.time.LocalDate;

/**
 *
 * @author breno
 */
public class Ticket {
    
    private LocalDate inicio;
    private double valorPrimeiraHora;
    private double valorHoraSubsequente;
    private DiaDaSemana dia;
    private Vaga vaga;
    private Veiculo veiculo;

    public Ticket(LocalDate inicio, double valorPrimeiraHora, double valorHoraSubsequente, DiaDaSemana dia, Vaga vaga, Veiculo veiculo) {
        this.inicio = inicio;
        this.valorPrimeiraHora = valorPrimeiraHora;
        this.valorHoraSubsequente = valorHoraSubsequente;
        this.dia = dia;
        this.vaga = vaga;
        this.veiculo = veiculo;
    }

    
    
    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public double getValorPrimeiraHora() {
        return valorPrimeiraHora;
    }

    public void setValorPrimeiraHora(double valorPrimeiraHora) {
        this.valorPrimeiraHora = valorPrimeiraHora;
    }

    public double getValorHoraSubsequente() {
        return valorHoraSubsequente;
    }

    public void setValorHoraSubsequente(double valorHoraSubsequente) {
        this.valorHoraSubsequente = valorHoraSubsequente;
    }

    public DiaDaSemana getDia() {
        return dia;
    }

    public void setDia(DiaDaSemana dia) {
        this.dia = dia;
    }
    
    
}
