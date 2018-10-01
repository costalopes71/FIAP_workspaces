package br.com.fiap.nac02.rm78573;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkLaMafia;
    CheckBox chkTheLegend;
    CheckBox chkBatataFrita;
    TextView txtPrecoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkLaMafia = findViewById(R.id.chkLaMafia);
        chkTheLegend = findViewById(R.id.chkTheLegend);
        chkBatataFrita = findViewById(R.id.chkBatataFrita);
        txtPrecoFinal = findViewById(R.id.txtPrecoFinal);

    }

    public void calcular(View view) {

        double precoFinal = 0;

        if (chkTheLegend.isChecked()) {
            precoFinal += 25.90;
        }

        if (chkLaMafia.isChecked()) {
            precoFinal += 28.90;
        }

        if (chkBatataFrita.isChecked()) {
            precoFinal += 12.90;
        }

        txtPrecoFinal.setText(String.format("R$ %.2f", precoFinal));

    }

    public void saibamaisLegend(View view) {
        Intent it = new Intent(this, TheLegendActivity.class);
        startActivity(it);
    }


    public void saibamaisBatata(View view) {
        Intent it = new Intent(this, BatataFriteActivity.class);
        startActivity(it);
    }

    public void saibamaisMafia(View view) {
        Intent it = new Intent(this, MafiaActivity.class);
        startActivity(it);
    }
}
