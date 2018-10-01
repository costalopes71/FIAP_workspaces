package revisao.fiap.com.br.revisaopetshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvValorTotal;
    CheckBox chkAdestrado;
    CheckBox chkFemea;
    CheckBox chkVacinas;
    RadioGroup rdgRacas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvValorTotal = findViewById(R.id.tvValorTotal);
        chkAdestrado = findViewById(R.id.chkAdestrado);
        chkFemea = findViewById(R.id.chkFemea);
        chkVacinas = findViewById(R.id.chkVacinas);
        rdgRacas = findViewById(R.id.rdgRacas);

    }

    public void calcular(View view) {

        double total = 0;

        switch (rdgRacas.getCheckedRadioButtonId()) {
            case (R.id.rbBoderCollie) :
                total += 800;
                break;
            case (R.id.rbPitBull) :
                total += 750;
                break;
            case (R.id.rbPastorAlemao) :
                total += 700;
                break;
            case (R.id.rbPastorCanadense) :
                total += 800;
                break;
        }

        if (chkAdestrado.isChecked()) {
            total += 400;
        }

        if (chkFemea.isChecked()) {
            total += 180;
        }

        if (chkVacinas.isChecked()) {
            total += 200;
        }

        tvValorTotal.setText(String.format("R$%.2f", total));

    }
}
