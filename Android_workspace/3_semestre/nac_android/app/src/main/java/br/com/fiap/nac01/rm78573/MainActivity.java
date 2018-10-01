package br.com.fiap.nac01.rm78573;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgMateriais;
    EditText edtQuantidade;
    CheckBox chkFrete;
    TextView txtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgMateriais = findViewById(R.id.rdgMateriais);
        edtQuantidade = findViewById(R.id.edtQuantidade);
        chkFrete = findViewById(R.id.chkFrete);
        txtPreco = findViewById(R.id.txtPreco);

    }

    public void calcular(View view) {

        double precoMaterialSelecinado = 0;
        double precoFinal = 0;
        double quantidadeMaterial = Double.parseDouble(edtQuantidade.getText().toString());

        switch (rdgMateriais.getCheckedRadioButtonId()) {
            case R.id.rdbPisoBranco:
                precoMaterialSelecinado += 24.9;
                break;
            case R.id.rdbPisoAlbania:
                precoMaterialSelecinado += 11.9;
                break;
            case R.id.rdbPorcelanatoPerlato:
                precoMaterialSelecinado += 39.9;
                break;
            case R.id.rdbRevestimentoMosaico:
                precoMaterialSelecinado += 16.9;
                break;
            }

        if (chkFrete.isChecked()) {
            precoFinal = (quantidadeMaterial * precoMaterialSelecinado) * 1.3;
        } else {
            precoFinal = (quantidadeMaterial * precoMaterialSelecinado);
        }

        txtPreco.setText(String.format("R$ %.2f", precoFinal));

    }

}
