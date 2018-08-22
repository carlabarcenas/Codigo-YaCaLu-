package org.utng.app.yacalu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class OurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizone);
    }
}

class QuestionLibrary {
    private String mQuestions [] = {
            "Como se dice \"romper\" en tiempo pasado",
            "Completa: I have ___ apple.",
            "Contesta: how are old you?.",
            "Traduce: Soy un niño",
            "Contesta: How are you doing",
            "Contesta: How was the exam ",
            "A que se refiere CUT DOWN en la oración: We will cut down on spending",
            "Traduce REVISAR.",
            "Que significa: GET OUT",
            "A que se refiere BOUGHT en la oración: My brother bought a new car"


    };


    private String mChoices [][] = {
            {"broke", "break", "broked"},
            {"a", "an", "on"},
            {"20 years old", "20 years", "since 20 years"},
            {"I am a boy ", "I am a girl", "I boy"},
            {"I´m studying", "I´m going to my house", "I´m fine"},
            {"It was in library", "It was a piece of cake", "The evaluation was the last Monday"},
            {"Reduce", "Cut", "got in front"},
            {"Go over", "Came over", "drop out"},
            {"Venir", "Salir", "Regresar"},
            {"Sale", "Sold", "Purchased"}
    };



    private String mCorrectAnswers[] = {"broke", "an", "20 years old","I am a boy",
            "I´m fine","It was a piece of cake","Reduce","Go over","Salir","Purchased"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoiceOne(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoiceTwo(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoiceThree(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}