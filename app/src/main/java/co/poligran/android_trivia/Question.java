package co.poligran.android_trivia;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question;
    private ArrayList<String> options;
    private ArrayList<String> randomOrder;

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getRandomOrder() {
        return randomOrder;
    }

    private ArrayList<Integer> result;

    public Question(String q, String c, ArrayList<String> o) {
        question = q.toString();
        options = new ArrayList<>();
        options.add(c);
        options.addAll(o);
        randomOrder = new ArrayList<>();
        result = new ArrayList<>();
        randomize();
    }

    public void randomize() {
        randomOrder.clear();
        result.clear();
        for (int i = 0; i < options.size(); i++)
            result.add(i);
        Collections.shuffle(result);
        for (int i = 0; i < options.size(); i++)
            randomOrder.add(options.get(result.get(i)));
    }

    public boolean checkQuestion(int i){
        if(result.get(i)==0)
            return true;
        return false;
    }


}
