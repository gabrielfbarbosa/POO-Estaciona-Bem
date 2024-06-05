/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionabem.operacoes;

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
