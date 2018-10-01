package br.com.fiap.view;

import java.rmi.RemoteException;
import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularPs;
import br.com.fiap.bo.NotaBOStub.CalcularPsResponse;

public class CalcularPSView {

	public static void main(String[] args) throws RemoteException {
		
		//calcular quanto falta pra PS atraves do WS
		NotaBOStub stub = new NotaBOStub();
		//parametros
		CalcularPs parametros = new CalcularPs();
		parametros.setAm(8.7f);
		parametros.setNac(10);
		
		//calcular PS
		CalcularPsResponse notaPs = stub.calcularPs(parametros);
		
		System.out.println(notaPs.get_return());
		
	}
	
}
