/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

/**
 *
 * @author breno
 */
public class Vaga {
    
    private int numero;
    private String rua;
    private String tipo;
    private String disponibilidade;

    
    public Vaga(int numero, String rua) {
        this.numero = numero;
        this.rua = rua;
        this.tipo = "Carro";
    }

    public Vaga(int numero, String rua, Boolean moto) {
        this.numero = numero;
        this.rua = rua;
        this.tipo = "Moto";
    }

    
    
    public String toString(){
        String saida="";
        saida += "Numero: " + this.numero + "\n";
        saida += "Rua: " + this.rua + "\n";
        saida += "Tipo: " + this.tipo + "\n";
        
        return saida;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
   

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
   
}
