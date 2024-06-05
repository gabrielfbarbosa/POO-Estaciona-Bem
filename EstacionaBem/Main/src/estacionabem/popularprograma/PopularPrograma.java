package estacionabem.popularprograma;

import estacionabem.programa.Cliente;
import estacionabem.programa.Tipo;
import estacionabem.programa.Vaga;
import estacionabem.programa.Veiculo;

import java.util.ArrayList;

public class PopularPrograma {

    public static ArrayList<Cliente> createClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        ArrayList<Veiculo> veiculosC1 = new ArrayList<>();
        Cliente c1 = new Cliente("Brenildu", "123", veiculosC1);
        Veiculo v2 = new Veiculo("Placa Y",  c1, Tipo.MOTO);
        Veiculo v1 = new Veiculo("Placa X",  c1, Tipo.CARRO);
        Veiculo v3 = new Veiculo("Placa Z",  c1, Tipo.ONIBUS);

        c1.adicionaVeiculo(v1);
        c1.adicionaVeiculo(v2);
        c1.adicionaVeiculo(v3);

        ArrayList<Veiculo> veiculosC10 = new ArrayList<>();
        Cliente c10 = new Cliente("Biel", "123.456.789-00", veiculosC10);
        Veiculo v20 = new Veiculo("ZXC-4561",  c10, Tipo.MOTO);
        Veiculo v10 = new Veiculo("QWE-7894",  c10, Tipo.CARRO);
        Veiculo v30 = new Veiculo("ZXC-1230",  c10, Tipo.ONIBUS);

        c10.adicionaVeiculo(v10);
        c10.adicionaVeiculo(v20);
        c10.adicionaVeiculo(v30);

        clientes.add(c1);
        clientes.add(c10);

        return clientes;
    }

    public static ArrayList<Vaga> createVagas() {
        ArrayList<Vaga> vagas = new ArrayList<>();

        Vaga vaga1 = new Vaga(123, "Rua Tal", Tipo.MOTO);
        vagas.add(vaga1);
        Vaga vaga2 = new Vaga(222, "Rua 10", Tipo.CARRO);
        vagas.add(vaga2);
        Vaga vaga3 = new Vaga(333, "Rua 300", Tipo.ONIBUS);
        vagas.add(vaga3);

        return vagas;
    }

}
