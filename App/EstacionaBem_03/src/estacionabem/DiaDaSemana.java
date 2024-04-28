/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

/**
 *
 * @author breno
 */
public class DiaDaSemana {
    
    private String dia;
    private double valorPrimeiraHora;
    private double valorHorasubsequente;

    public DiaDaSemana(String dia) {
        this.dia = dia;
        this.valorPrimeiraHora = 10;
        this.valorHorasubsequente = 5;
    }

    
    
    public String getDia(){
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getValorPrimeiraHora() {
        return valorPrimeiraHora;
    }

    public void setValorPrimeiraHora(double valorPrimeiraHora) {
        this.valorPrimeiraHora = valorPrimeiraHora;
    }

    public double getValorHorasubsequente() {
        return valorHorasubsequente;
    }

    public void setValorHorasubsequente(double valorHorasubsequente) {
        this.valorHorasubsequente = valorHorasubsequente;
    }

    
    
}
