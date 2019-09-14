package co.poligran.android_trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Results extends AppCompatActivity {

    private Button restart;
    private int[] r = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        restart = findViewById(R.id.button);
    }

    public void restartGame(View view){
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("miLista", r);
        startActivity(intent);
        finish();
    }
}
