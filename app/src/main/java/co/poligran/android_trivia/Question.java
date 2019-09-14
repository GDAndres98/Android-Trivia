package co.poligran.android_trivia;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question;
    private ArrayList options;
    private String[] randomOrder;
    private boolean[] result;

    public Question(String q, String c, ArrayList<String> o){
        question = q.toString();
    }
}
