/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem;

/**
 *
 * @author breno
 */
public enum Tipo {
    
    MOTO(1, 0.5),
    CARRO(2, 1),
    ONIBUS(3, 1.5);

    private final int tipo;
    private double tarifa;
    
    Tipo(int tipo, double tarifa){
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
}
