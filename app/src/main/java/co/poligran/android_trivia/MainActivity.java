package co.poligran.android_trivia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.json.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout editText;
    private Button startButton;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        startButton = findViewById(R.id.startButton);
        questions = new ArrayList<>();
    }

    public void start(View view) throws JSONException{
        System.out.println(editText.getEditText().getText().toString());
        String str = editText.getEditText().getText().toString();
        str = "{\"response_code\":0,\"results\":[{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In World of Warcraft lore, who was first to have the title &quot;The Ashbringer&quot;?\",\"correct_answer\":\"Alexandros Mograine\",\"incorrect_answers\":[\"Tirion Fordring\",\"Arthas Menethil\",\"Uther the Lightbringer\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In WarioWare: Smooth Moves, which one of these is NOT a Form?\",\"correct_answer\":\"The Hotshot\",\"incorrect_answers\":[\"The Discard\",\"The Elephant\",\"The Mohawk\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"This weapon in Counter-Strike: Global Offensive does not exist in real life.\",\"correct_answer\":\"M4A4\",\"incorrect_answers\":[\"AWP\",\"M4A1\",\"MP9\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which of these characters was almost added into Super Smash Bros. Melee, but not included as the game was too far in development?\",\"correct_answer\":\"Solid Snake\",\"incorrect_answers\":[\"Pit\",\"Meta Knight\",\"R.O.B.\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What level do you have to be to get a service medal on CS:GO?\",\"correct_answer\":\"40\",\"incorrect_answers\":[\"50\",\"30\",\"20\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In &quot;Call Of Duty: Zombies&quot;, completing which map&#039;s easter egg will reward you with the achievement, &quot;Time Travel Will Tell&quot;?\",\"correct_answer\":\"Shangri-La\",\"incorrect_answers\":[\"Ascension\",\"Moon\",\"Die Rise\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which character does the player play as in the video game &quot;Bastion&quot;?\",\"correct_answer\":\"The Kid\",\"incorrect_answers\":[\"Rucks\",\"Zulf\",\"Zia\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In Portal, what color is the Intelligence Core?\",\"correct_answer\":\"Blue\",\"incorrect_answers\":[\"Purple\",\"Red\",\"Orange\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which Sonic the Hedgehog game introudced Knuckles the Echidna?\",\"correct_answer\":\"Sonic the Hedgehog 3\",\"incorrect_answers\":[\"Sonic the Hedgehog 2\",\"Sonic &amp; Knuckles\",\"Sonic Adventure\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Who is credited with having created the world&#039;s first video game Easter Egg?\",\"correct_answer\":\"Warren Robinett\",\"incorrect_answers\":[\"Julius Smith\",\"Will Crowther\",\"Don Woods\"]}]}";

        JSONObject obj = new JSONObject(str);
        JSONArray  arr = obj.getJSONArray("results");
        for(int i = 0; i < arr.length(); i++){
            String question = arr.getJSONObject(i).getString("question");
            String answer = arr.getJSONObject(i).getString("correct_answer");
            ArrayList<String> o = new ArrayList<>();
            JSONArray  arr2 = arr.getJSONObject(i).getJSONArray("incorrect_answers");
            for(int j = 0; j < arr2.length(); j++){
                  String wa = arr2.getString(j);
                  o.add(wa);
            }
            Question q = new Question(question, answer, o);
            questions.add(q);
        }
    }
}
