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
    private double valorPrimeiraHoraCarro;
    private double valorHorasubsequenteCarro;
    private double valorPrimeiraHoraMoto;
    private double valorHorasubsequenteMoto;
    
    public DiaDaSemana(String dia) {
        this.dia = dia;
        this.valorPrimeiraHoraCarro = 10;
        this.valorPrimeiraHoraMoto = 10;
        this.valorHorasubsequenteMoto = 5;
        this.valorHorasubsequenteCarro = 5;
    }

    
    
    public String getDia(){
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getValorPrimeiraHoraCarro() {
        return valorPrimeiraHoraCarro;
    }

    public void setValorPrimeiraHoraCarro(double valorPrimeiraHoraCarro) {
        this.valorPrimeiraHoraCarro = valorPrimeiraHoraCarro;
    }

    public double getValorHorasubsequenteCarro() {
        return valorHorasubsequenteCarro;
    }

    public void setValorHorasubsequenteCarro(double valorHorasubsequenteCarro) {
        this.valorHorasubsequenteCarro = valorHorasubsequenteCarro;
    }

    public double getValorPrimeiraHoraMoto() {
        return valorPrimeiraHoraMoto;
    }

    public void setValorPrimeiraHoraMoto(double valorPrimeiraHoraMoto) {
        this.valorPrimeiraHoraMoto = valorPrimeiraHoraMoto;
    }

    public double getValorHorasubsequenteMoto() {
        return valorHorasubsequenteMoto;
    }

    public void setValorHorasubsequenteMoto(double valorHorasubsequenteMoto) {
        this.valorHorasubsequenteMoto = valorHorasubsequenteMoto;
    }

    

    
    
}
