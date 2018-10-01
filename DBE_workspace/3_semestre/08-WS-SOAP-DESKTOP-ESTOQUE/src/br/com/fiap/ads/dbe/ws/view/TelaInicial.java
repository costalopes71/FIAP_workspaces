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

import br.com.fiap.ads.dbe.ws.repository.EstoqueRepository;
import br.com.fiap.inventario.EstoqueStub.ProdutoTO;

public class TelaInicial {

	protected Shell shlConsultaProduto;
	private Text txtCodigoPesquisa;
	private Text txtCodigoProduto;
	private Text txtDescricao;
	private Text txtPreco;
	private Text txtNome;
	private Label lblErro;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaInicial window = new TelaInicial();
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
		shlConsultaProduto.open();
		shlConsultaProduto.layout();
		while (!shlConsultaProduto.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConsultaProduto = new Shell();
		shlConsultaProduto.setSize(450, 351);
		shlConsultaProduto.setText("Consulta Produto");
		
		Label lblDigiteOCdigo = new Label(shlConsultaProduto, SWT.NONE);
		lblDigiteOCdigo.setBounds(28, 43, 250, 22);
		lblDigiteOCdigo.setText("Digite o c\u00F3digo do produto a ser pesquisado:");
		
		txtCodigoPesquisa = new Text(shlConsultaProduto, SWT.BORDER);
		txtCodigoPesquisa.setBounds(284, 40, 76, 21);
		
		Button btnPesquisar = new Button(shlConsultaProduto, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int codigoProduto = Integer.parseInt(txtCodigoPesquisa.getText());
				
				ProdutoTO produto = null;
				try {
					produto = new EstoqueRepository().buscarProduto(codigoProduto);
					txtCodigoProduto.setText(String.valueOf(produto.getCodigo()));
					txtNome.setText(produto.getNome());
					txtDescricao.setText(produto.getDescricao());
					txtPreco.setText(String.valueOf(produto.getPreco()));
				} catch (RemoteException e1) {
					lblErro.setText("ERRO AO CONSULTAR O WS");
				}
				
			}
		});
		btnPesquisar.setBounds(178, 71, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		Label lblCdigo = new Label(shlConsultaProduto, SWT.NONE);
		lblCdigo.setBounds(40, 118, 55, 15);
		lblCdigo.setText("C\u00F3digo:");
		
		txtCodigoProduto = new Text(shlConsultaProduto, SWT.BORDER);
		txtCodigoProduto.setBounds(101, 115, 76, 21);
		
		Label lblDescrio = new Label(shlConsultaProduto, SWT.NONE);
		lblDescrio.setBounds(40, 159, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o:");
		
		txtDescricao = new Text(shlConsultaProduto, SWT.BORDER);
		txtDescricao.setBounds(101, 156, 259, 21);
		
		Label lblPreo = new Label(shlConsultaProduto, SWT.NONE);
		lblPreo.setBounds(40, 198, 55, 15);
		lblPreo.setText("Pre\u00E7o:");
		
		txtPreco = new Text(shlConsultaProduto, SWT.BORDER);
		txtPreco.setBounds(101, 195, 76, 21);
		
		Label lblNewLabel = new Label(shlConsultaProduto, SWT.NONE);
		lblNewLabel.setBounds(40, 236, 55, 15);
		lblNewLabel.setText("Nome:");
		
		txtNome = new Text(shlConsultaProduto, SWT.BORDER);
		txtNome.setBounds(101, 230, 76, 21);
		
		lblErro = new Label(shlConsultaProduto, SWT.NONE);
		lblErro.setBounds(40, 277, 320, 25);

	}

}
