package co.poligran.android_trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    private Button restart;
    private ArrayList<Integer> r;

    private TextView a;
    private TextView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        restart = findViewById(R.id.button);

        Intent intent = getIntent();
        r = (ArrayList<Integer>) intent.getSerializableExtra("miLista");
        a = findViewById(R.id.textView2);
        b = findViewById(R.id.textView3);

        a.setText(r.get(0)+" CORRECTAS");
        b.setText(r.get(1)+" INCAORRECTAS");



    }

    public void restartGame(View view){
        finish();
    }
}
