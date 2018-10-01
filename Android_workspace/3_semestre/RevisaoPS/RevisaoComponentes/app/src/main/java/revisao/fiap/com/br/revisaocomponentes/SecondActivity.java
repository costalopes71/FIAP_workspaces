package revisao.fiap.com.br.revisaocomponentes;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;

public class SecondActivity extends AppCompatActivity {

    DatePicker dtpDataNascimento;
    TimePicker tmpHrMeditacao;
    Spinner spnEstados;
    AutoCompleteTextView actPaises;
    String[] estados = {
            "SP", "SC", "RS", "PR", "RJ", "ES", "GO", "PE", "MS", "RN", "BA", "MG", "AC", "RR", "DF", "AM", "PI", "CE"
    };

    String[] paises = {
            "Brasil", "Portugal", "Alemanha", "EUA", "Canada", "Bolivia", "Equador", "Venezuela", "Dinamarca", "Eslovenia", "Finlandia"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dtpDataNascimento = findViewById(R.id.dtpNascimento);
        tmpHrMeditacao = findViewById(R.id.tmpMeditacao);
        spnEstados = findViewById(R.id.spnEstado);
        actPaises = findViewById(R.id.actPais);

        ArrayAdapter<String> adapterEstado = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estados);
        ArrayAdapter<String> adapterPaises = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);

        spnEstados.setAdapter(adapterEstado);
        actPaises.setAdapter(adapterPaises);


    }
}
