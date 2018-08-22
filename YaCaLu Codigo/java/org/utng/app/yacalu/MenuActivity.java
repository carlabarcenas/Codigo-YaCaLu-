package org.utng.app.yacalu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.utng.app.yacalu.figuresgeometric.FigureActivity;
import org.utng.app.yacalu.objects.EntryActivity;
import org.utng.app.yacalu.vocabulary.MainVocabularyActivity;


public class MenuActivity extends AppCompatActivity {

    private ImageButton ibWritting;
    private ImageButton ibVerbList;
    private ImageButton ibGramar;
    private ImageButton ibAdjetives;
    private ImageButton ibVocabulary;
    private ImageButton ibCompleteSentences;
    private ImageButton ibMemory;
    private ImageButton ibObjects;
    private ImageButton ibConectors;
    private ImageButton ibFigures;
    private ImageButton ibJobInterview;
    private ImageButton ibConditionals;
    private ImageButton ibBussinesTips;
    private ImageButton ibMusicUrl;
    private ImageButton btnQuiz;
    private ImageButton btnInfo;
    private Button btnFacebook;
    private Button btnYoutube;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menu);

        ibWritting = (ImageButton) findViewById(R.id.btn_writing);
        ibWritting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), WritingReportsActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        ibVerbList = (ImageButton) findViewById(R.id.btn_verbs);
        ibVerbList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), VerbsListActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        ibGramar= (ImageButton) findViewById(R.id.btn_grammar);
        ibGramar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), GrammarActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        ibAdjetives= (ImageButton) findViewById(R.id.btn_adjectives);
        ibAdjetives.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ListAdjectivesActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        ibVocabulary= (ImageButton) findViewById(R.id.btn_vocabulary);
        ibVocabulary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),MainVocabularyActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        ibCompleteSentences= (ImageButton) findViewById(R.id.btn_sentences);
       ibCompleteSentences.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), GameComplementationActivity.class);
                startActivityForResult(intent, 0);
            }
        });

       ibMemory= (ImageButton) findViewById(R.id.btn_Memory);
       ibMemory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MemoActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        ibObjects= (ImageButton) findViewById(R.id.btn_objetss);
        ibObjects.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), EntryActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        ibConectors = (ImageButton) findViewById(R.id.btn_conect);
        ibConectors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ProcessConnectorsActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        ibFigures= (ImageButton) findViewById(R.id.btn_figures);
        ibFigures.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), FigureActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        ibJobInterview= (ImageButton) findViewById(R.id.btn_pre);
        ibJobInterview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), TipsActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        ibConditionals= (ImageButton) findViewById(R.id.btn_condicionalss);
        ibConditionals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), CondicionalsActivity.class);
                startActivityForResult(intent, 0);
            }
        });


       ibBussinesTips= (ImageButton) findViewById(R.id.btn_expressions);
        ibBussinesTips.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), BusinessEnglishActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        ibMusicUrl= (ImageButton) findViewById(R.id.btn_urls);
        ibMusicUrl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MusicUrlActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btnQuiz= (ImageButton) findViewById(R.id.btn_quiz);
        btnQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), QuizActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        btnInfo= (ImageButton) findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), CreditsActivity.class);
                startActivityForResult(intent, 0);
            }
        });



       btnFacebook = (Button) findViewById(R.id.btn_Fb);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), FacebookActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        btnYoutube = (Button) findViewById(R.id.btn_youtube);
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), YoutubeActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuActivity.this, SplashActivity.class);
        startActivity(i);
        finish();
    }
}

