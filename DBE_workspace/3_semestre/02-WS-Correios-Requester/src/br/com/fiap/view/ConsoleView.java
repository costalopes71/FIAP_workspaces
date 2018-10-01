package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) throws RemoteException {
		
		Scanner sc = new Scanner(System.in);
		int codigoServico = 4014;

		System.out.println("Digite o CEP de origem (sem hifen): ");
		int cepOrigem = sc.nextInt();
		System.out.println("Digite o CEP de destino (sem hifen): ");
		int cepDestino = sc.nextInt();
		
		CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
		
		//setando os parametros
		CalcPrazo parametros = new CalcPrazo();
		parametros.setSCepDestino(String.valueOf(cepDestino));
		parametros.setSCepOrigem(String.valueOf(cepOrigem));
		parametros.setNCdServico(String.valueOf(codigoServico));
		
		//Calculado
		CalcPrazoResponse response = stub.calcPrazo(parametros);
		
		System.out.println(response.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
		sc.close();
		
	}
	
}
