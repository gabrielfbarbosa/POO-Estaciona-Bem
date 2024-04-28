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
    private double preco;

    public DiaDaSemana(String dia, double preco) {
        this.dia = dia;
        this.preco = preco;
    }

    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
