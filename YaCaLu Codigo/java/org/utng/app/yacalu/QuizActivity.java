package org.utng.app.yacalu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.utng.app.yacalu.quiz.ScoreActivity;

public class QuizActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView tvScoreView;
    private TextView tvQuestionView;
    private Button btnChoiceOne;
    private Button btnChoiceTwo;
    private Button btnChoiceThree;
    private Button btnQuit;
    private int arrayQuestions[];


    private String Answer;
    private int Score = 0;
    private int QuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvScoreView = (TextView)findViewById(R.id.tv_score);
        tvQuestionView = (TextView)findViewById(R.id.tv_question);
        btnChoiceOne = (Button)findViewById(R.id.btn_choice_one);
        btnChoiceTwo = (Button)findViewById(R.id.btn_choice_two);
        btnChoiceThree = (Button)findViewById(R.id.btn_choice_three);
        btnQuit = (Button)findViewById(R.id.btn_quit);
        arrayQuestions=new int[5];

        btnQuit.setEnabled(false);

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePoints();
            }
        });


        updateQuestion();

        //Start of Button Listener for Button1
        btnChoiceOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (btnChoiceOne.getText() == Answer){
                    Score = Score + 1;
                    updateScore(Score);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, (R.string.good), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, (R.string.erros), Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        btnChoiceTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (btnChoiceTwo.getText() == Answer){
                    Score = Score + 1;
                    updateScore(Score);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, (R.string.good), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, (R.string.erros), Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        btnChoiceThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (btnChoiceThree.getText() == Answer){
                    Score = Score + 1;
                    updateScore(Score);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, (R.string.good), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, (R.string.erros), Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3


    }


    private void updateQuestion()
    {
        try {

            generaArregloNum();
            tvQuestionView.setText(mQuestionLibrary.getQuestion(arrayQuestions[QuestionNumber]));
            btnChoiceOne.setText(mQuestionLibrary.getChoiceOne(arrayQuestions[QuestionNumber]));
            btnChoiceTwo.setText(mQuestionLibrary.getChoiceTwo(arrayQuestions[QuestionNumber]));
            btnChoiceThree.setText(mQuestionLibrary.getChoiceThree(arrayQuestions[QuestionNumber]));

            Answer = mQuestionLibrary.getCorrectAnswer(arrayQuestions[QuestionNumber]);
            QuestionNumber++;

            if(QuestionNumber>5){
                Toast.makeText(QuizActivity.this, (R.string.finish), Toast.LENGTH_LONG).show();
                btnChoiceOne.setEnabled(false);
                btnChoiceTwo.setEnabled(false);
                btnChoiceThree.setEnabled(false);
                btnQuit.setEnabled(true);
            }




        }catch (Exception e){
            btnChoiceOne.setEnabled(false);
            btnChoiceTwo.setEnabled(false);
            btnChoiceThree.setEnabled(false);
            btnQuit.setEnabled(true);
            Toast.makeText(QuizActivity.this, (R.string.testFinish), Toast.LENGTH_LONG).show();

        }
    }

    private void savePoints() {
        tvScoreView.setText("" + Score);
        //Para poder lanzar otra activity se utiliza la clase Intent
        Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
        //Creamos la información en un Bundle
        Bundle b = new Bundle();
        b.putString("points", tvScoreView.getText().toString());

        //Se añade la información al Intent
        intent.putExtras(b);
        startActivity(intent); // Se inicia la otra Activity
        finish();

    }


    private void updateScore(int point) {
        tvScoreView.setText("" + Score);

    }

    private void generaArregloNum(){
        for(int i=0;i<arrayQuestions.length;i++){
            // Producir nuevo int aleatorio entre 0 y 99
            int intAletorio=(int)(Math.random()*9)+1;
            for (int j=0;j<i;j++){
                if (arrayQuestions[j]==intAletorio)
                    intAletorio=(int)(Math.random()*9)+1;
            }
            arrayQuestions[i]=intAletorio;
            System.out.println(arrayQuestions[i]);

        }
    }

}