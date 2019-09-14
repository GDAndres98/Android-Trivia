package co.poligran.android_trivia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Trivia extends AppCompatActivity {

    public boolean[] results;
    public ArrayList<Question> list;
    public int actualQuestion;
    public Button[] buttons;
    public int corrects;
    public TextView corectsText;
    public TextView questionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        corectsText = findViewById(R.id.counter);
        questionText = findViewById(R.id.textViewQuestion);
        corrects = 0;
        actualQuestion = 0;
        Intent intent = getIntent();
        list = (ArrayList<Question>) intent.getSerializableExtra("questions");
        results = new boolean[list.size()];

        buttons = new Button[4];
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);
        setQuestion();


    }

    public void setQuestion() {
        colorAll();
        corectsText.setText(corrects+" correctas :D");
        questionText.setText(list.get(actualQuestion).getQuestion());
        ArrayList<String> answers = list.get(actualQuestion).getRandomOrder();
        for (int i = 0; i < 4; i++)
            buttons[i].setText(answers.get(i));
    }

    public void checkAnswer(View v) {
        colorAll();
        Button x = (Button) v;
        x.setBackgroundColor(Color.parseColor("#A3FF26"));
        x.setTextColor(Color.parseColor("#212121"));
        results[actualQuestion] = list.get(actualQuestion).checkQuestion(x.getText().toString());

    }

    private void colorAll() {
        for (int i = 0; i < 4; i++) {
            buttons[i].setBackgroundColor(Color.parseColor("#0472FE"));
            buttons[i].setTextColor(Color.parseColor("#CCCCCC"));
        }
    }

    public void send(View v) {
        if(results[actualQuestion])
            corrects++;
        actualQuestion++;
        if (actualQuestion >= list.size()) {
            ArrayList<Integer> goodBad = new ArrayList<Integer>();
            goodBad.add(0);
            goodBad.add(0);
            for (int i = 0; i < results.length; i++)
                if (results[i])
                    goodBad.set(0,goodBad.get(0)+1);
                else
                    goodBad.set(1,goodBad.get(1)+1);
            Intent intent = new Intent(this, Results.class);
            intent.putExtra("miLista", goodBad);
            startActivity(intent);
            finish();


        } else {
            setQuestion();
        }
    }

}
