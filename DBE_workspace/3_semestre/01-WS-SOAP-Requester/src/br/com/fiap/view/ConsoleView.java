package br.com.fiap.view;

import java.rmi.RemoteException;
import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularMedia;
import br.com.fiap.bo.NotaBOStub.CalcularMediaResponse;

public class ConsoleView {

	public static void main(String[] args) throws RemoteException {
		
		NotaBOStub stub = new NotaBOStub();
		
		//parametros para enviar ao web service
		CalcularMedia parametros = new CalcularMedia();
		parametros.setAm(10);
		parametros.setNac(10);
		parametros.setPs(9.2f);
		
		//chama o web service e recupera o retorno
		CalcularMediaResponse media = stub.calcularMedia(parametros);
		
		//Exibe o valor calculado do web service
		System.out.println(media.get_return());
		
		
	}
	
}
