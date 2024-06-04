/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

import estacionabem.Cliente;
import estacionabem.DiaDaSemana;
import estacionabem.ticket.Ticket;
import estacionabem.Vaga;
import estacionabem.Veiculo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BrenoTakeshiCamargod
 */
public class OperacoesEstacionamento {
    
    OperacaoCliente opCliente = new OperacaoCliente();
    OperacaoEstacionar opEstacionar = new OperacaoEstacionar();
    OperacaoTotalFaturado opTotalFaturado = new OperacaoTotalFaturado();
    OperacaoVaga opVaga = new OperacaoVaga();
    OperacaoVeiculo opVeiculo = new OperacaoVeiculo();
    
    
/*------------------------------------------------------------------------------------*/  

    public OperacaoCliente getOpCliente() {
        return opCliente;
    }

    public OperacaoEstacionar getOpEstacionar() {
        return opEstacionar;
    }

    public OperacaoTotalFaturado getOpTotalFaturado() {
        return opTotalFaturado;
    }

    public OperacaoVaga getOpVaga() {
        return opVaga;
    }

    public OperacaoVeiculo getOpVeiculo() {
        return opVeiculo;
    }
}
