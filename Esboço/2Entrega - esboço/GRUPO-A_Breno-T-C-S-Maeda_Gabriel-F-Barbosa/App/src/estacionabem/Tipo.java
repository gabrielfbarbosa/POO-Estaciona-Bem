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
    
    public static Tipo converteString(String strTipo){
        Tipo tipo;
        if(strTipo.equals("moto")){
            tipo = Tipo.MOTO;
        } else if(strTipo.equals("carro")){
            tipo = Tipo.CARRO;
        } else{
            tipo = Tipo.ONIBUS;
        }
        
        return tipo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
}
