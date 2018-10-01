package br.com.fiap.ads.dbe.ws.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularPs;
import br.com.fiap.bo.NotaBOStub.CalcularPsResponse;

public class NotaRepository {

	private NotaBOStub stub;
	private CalcularPs params;
	
	public NotaRepository() throws AxisFault {
		stub = new NotaBOStub();
		params = new CalcularPs();
	}
	
	public float calcularPS(float am, float nac) throws RemoteException {
		
		params.setAm(am);
		params.setNac(nac);
		
		CalcularPsResponse resposta = null;
		resposta = stub.calcularPs(params);
		
		return resposta.get_return();
	}
	
	
}
