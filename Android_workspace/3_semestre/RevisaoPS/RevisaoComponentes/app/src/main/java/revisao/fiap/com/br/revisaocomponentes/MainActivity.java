package revisao.fiap.com.br.revisaocomponentes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
    }

    public void logar(View view) {

        if (edtEmail.getText().toString().equals("joaolopes71@hotmail.com") && edtPassword.getText().toString().equals("1234")) {
            Intent it = new Intent(this, SecondActivity.class);
            it.putExtra("nomeUsuario", "João");
            startActivity(it);
        } else {
            Toast.makeText(this, "Login/Senha incorretos.", Toast.LENGTH_LONG).show();
        }

    }

}
