package br.com.fiap.jogodedado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgDado;
    int[] imgs = {
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


    public void jogar(View view) {
        Random random = new Random();
        int sorteado = random.nextInt(imgs.length);

        imgDado.setImageResource( imgs[sorteado]);

    }
}
