package br.com.fiap.ws.bo;

public class CalculadoraBO {

	public int somar(int j, int i) {
		return j + i;
	}
	
	public int fatoria(int x) {
		int resultado = x;
		for (int i = x - 1; i > 1; i--) {
			resultado *= i;
		}
		return resultado;
	}
	
	public double raizQuadrada(int x) {
		return Math.sqrt(x);
	}
	
}