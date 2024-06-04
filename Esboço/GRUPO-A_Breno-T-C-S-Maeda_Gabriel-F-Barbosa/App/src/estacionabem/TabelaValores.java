package estacionabem;

public enum TabelaValores {
    
    DOMINGO(1, 10, 5, 10, 5, 0),
    SEGUNDA(2, 10, 5, 10, 5, 0),
    TERCA(3, 10, 5, 10, 5, 0),
    QUARTA(4, 10, 5, 10, 5, 0),
    QUINTA(5, 10, 5, 10, 5, 0),
    SEXTA(6, 10, 5, 10, 5, 0),
    SABADO(7, 10, 5, 10, 5, 0),
    INTEGRAL(8, 0, 0, 0, 0, 20);
    
    private final int dia;
    private double valorPrimeiraHoraCarro;
    private double valorHorasubsequenteCarro;
    private double valorPrimeiraHoraMoto;
    private double valorHorasubsequenteMoto;
    private double valorIntegral;
    
    TabelaValores(int dia, double valorPrimeiraHoraCarro, double valorHorasubsequenteCarro,
                double valorPrimeiraHoraMoto, double valorHorasubsequenteMoto, double valorIntegral) {
        this.dia = dia;
        this.valorPrimeiraHoraCarro = valorPrimeiraHoraCarro;
        this.valorHorasubsequenteCarro = valorHorasubsequenteCarro;
        this.valorPrimeiraHoraMoto = valorPrimeiraHoraMoto;
        this.valorHorasubsequenteMoto = valorHorasubsequenteMoto;
        this.valorIntegral = valorIntegral;
    }
    
    public int getDia(){
        return this.dia;
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

    public double getValorIntegral() {
        return valorIntegral;
    }

    public void setValorIntegral(double valorIntegral) {
        this.valorIntegral = valorIntegral;
    }
    
    
}
