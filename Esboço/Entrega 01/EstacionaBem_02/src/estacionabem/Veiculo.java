/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

/**
 *
 * @author breno
 */
public class Veiculo {
    
    private String tipo;
    private String placa;
    private Cliente proprietario;

    public Veiculo(String placa, Cliente proprietario) {
        this.tipo = "Carro";
        this.placa = placa;
        this.proprietario = proprietario;
    }
    
    public Veiculo(String placa, Cliente proprietario, Boolean moto) {
        this.tipo = "Moto";
        this.placa = placa;
        this.proprietario = proprietario;
    }


    public String toString(){
        String saida="";
        saida += "Placa: " + this.placa + "\n";
        saida += "Tipo: " + this.tipo + "\n";
        
        return saida;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }
    
    
}
