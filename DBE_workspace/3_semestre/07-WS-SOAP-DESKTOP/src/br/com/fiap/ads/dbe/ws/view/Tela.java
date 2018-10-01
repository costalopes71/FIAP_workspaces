package br.com.fiap.ads.dbe.ws.view;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.ads.dbe.ws.repository.NotaRepository;

public class Tela {

	protected Shell shlFiapCalcula;
	private Text txtAm;
	private Text txtNAC;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFiapCalcula.open();
		shlFiapCalcula.layout();
		while (!shlFiapCalcula.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFiapCalcula = new Shell();
		shlFiapCalcula.setSize(319, 315);
		shlFiapCalcula.setText("FIAP - Calcula PS");
		
		txtAm = new Text(shlFiapCalcula, SWT.BORDER);
		txtAm.setBounds(119, 69, 76, 21);
		
		Label lblAm = new Label(shlFiapCalcula, SWT.NONE);
		lblAm.setBounds(58, 72, 55, 15);
		lblAm.setText("AM");
		
		txtNAC = new Text(shlFiapCalcula, SWT.BORDER);
		txtNAC.setBounds(119, 110, 76, 21);
		
		Label lblNac = new Label(shlFiapCalcula, SWT.NONE);
		lblNac.setBounds(58, 113, 55, 15);
		lblNac.setText("NAC");

		Button btnCalcular = new Button(shlFiapCalcula, SWT.NONE);
		btnCalcular.setBounds(119, 142, 75, 25);
		btnCalcular.setText("CALCULAR");
		
		Label lblCalcPS = new Label(shlFiapCalcula, SWT.NONE);
		lblCalcPS.setBounds(119, 206, 174, 21);
		
		Label lblPs = new Label(shlFiapCalcula, SWT.NONE);
		lblPs.setBounds(58, 206, 39, 21);
		lblPs.setText("PS");
		
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//clique do botao
				float am = Float.parseFloat(txtAm.getText());
				float nac = Float.parseFloat(txtNAC.getText());
				
				float ps = 0;
				try {
					ps = new NotaRepository().calcularPS(am, nac);
					lblCalcPS.setText(String.valueOf(ps));
				} catch (RemoteException e1) {
					lblCalcPS.setText("Erro ao chamar o WS.");
				}
			}
		});
		

	}
}
