package estacionabem.programa;

public class Veiculo {
    
    private Tipo tipo;
    private String placa;
    private Cliente proprietario;

    public Veiculo(String placa, Cliente proprietario, Tipo tipo) {
        this.tipo = tipo;
        this.placa = placa;
        this.proprietario = proprietario;
    }
    

    public String toString(){
        String saida="";
        saida += "Placa: " + this.placa + "\n";
        saida += "Tipo: " + this.tipo;
        return saida;
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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
