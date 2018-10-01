package revisao.fiap.com.br.alertsdialogsrevisao;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void deletar(View view) {

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.atencao);
        alertDialog.setMessage(R.string.confirma_deletar);

        alertDialog.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.item_deletado_sucesso, Toast.LENGTH_LONG).show();
            }
        });

        alertDialog.setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.acao_cancelada, Toast.LENGTH_LONG).show();
            }
        });

        alertDialog.show();

    }

    public void escolherData(View view) {

        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, getString(R.string.dia_escolhido) + dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();
            }
        },
        2018,
        0,
        30);

        datePicker.show();
    }

    public void processarArquivos(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle(getString(R.string.aguarde));
        pd.setMessage(getString(R.string.processando_arquivos));
        pd.show();
    }

    public void escolherHorario(View view) {

        TimePickerDialog timePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, getString(R.string.horario_escolhido) + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
            }
        },
        23,
        50,
        true);

        timePicker.show();
    }
}
