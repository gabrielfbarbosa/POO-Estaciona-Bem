package estacionabem;

public class Vaga {
    
    private int numero;
    private String rua;
    private String tipo;
    private String disponibilidade;

    
    public Vaga(int numero, String rua) {
        this.numero = numero;
        this.rua = rua;
        this.tipo = "Carro";
        this.disponibilidade = "Disponivel";
    }

    public Vaga(int numero, String rua, Boolean moto) {
        this.numero = numero;
        this.rua = rua;
        this.tipo = "Moto";
        this.disponibilidade = "Disponivel";
    }

    
    
    public String toString(){
        String saida="";
        saida += "Numero: " + this.numero + "\n";
        saida += "Rua: " + this.rua + "\n";
        saida += "Tipo: " + this.tipo + "\n";
        saida += "Disponibilidade: " + this.disponibilidade + "\n";
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
