package estacionabem;

public enum DiaDaSemana {
    
    DOMINGO(1, 10, 5, 10, 5),
    SEGUNDA(2, 10, 5, 10, 5),
    TERCA(3, 10, 5, 10, 5),
    QUARTA(4, 10, 5, 10, 5),
    QUINTA(5, 10, 5, 10, 5),
    SEXTA(6, 10, 5, 10, 5),
    SABADO(7, 10, 5, 10, 5);
    
    private final int dia;
    private double valorPrimeiraHoraCarro;
    private double valorHorasubsequenteCarro;
    private double valorPrimeiraHoraMoto;
    private double valorHorasubsequenteMoto;
    
    DiaDaSemana(int dia, double valorPrimeiraHoraCarro, double valorHorasubsequenteCarro,
                double valorPrimeiraHoraMoto, double valorHorasubsequenteMoto) {
        this.dia = dia;
        this.valorPrimeiraHoraCarro = valorPrimeiraHoraCarro;
        this.valorHorasubsequenteCarro = valorHorasubsequenteCarro;
        this.valorPrimeiraHoraMoto = valorPrimeiraHoraMoto;
        this.valorHorasubsequenteMoto = valorHorasubsequenteMoto;
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
}
