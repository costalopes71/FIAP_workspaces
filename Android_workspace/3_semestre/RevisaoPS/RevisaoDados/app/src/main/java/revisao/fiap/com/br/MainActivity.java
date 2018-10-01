package revisao.fiap.com.br;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgDado;
    int[] imagens = {
            R.drawable.dado1,
            R.drawable.dado2,
            R.drawable.dado3,
            R.drawable.dado4,
            R.drawable.dado5,
            R.drawable.dado6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDado = findViewById(R.id.imgDado);

    }

    public void sortear(View view) {

        Random rdm = new Random();
        int sorteado = rdm.nextInt(imagens.length);

        imgDado.setImageResource(imagens[sorteado]);

    }

}
