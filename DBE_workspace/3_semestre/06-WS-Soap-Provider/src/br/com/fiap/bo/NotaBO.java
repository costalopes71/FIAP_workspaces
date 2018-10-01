package br.com.fiap.bo;

public class NotaBO {

	public float calcularMedia(float nac, float am, float ps) {
		return (float) (nac * 0.2 + am * 0.3 + ps * 0.5);
	}
	
	public float calcularPs(float nac, float am) {
		return (6 - (nac * 0.2f + am * 0.3f)) * 2;
	}
	
	
}
