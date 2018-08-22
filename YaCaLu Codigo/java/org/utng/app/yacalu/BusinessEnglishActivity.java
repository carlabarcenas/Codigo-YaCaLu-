package org.utng.app.yacalu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.utng.app.yacalu.businesstips.BusinessTipsPracticActivity;
import org.utng.app.yacalu.businesstips.BusinessTipsProgramsActivity;
import org.utng.app.yacalu.businesstips.BusinessTipsReadActivity;
import org.utng.app.yacalu.businesstips.BusinessTipsSentenActivity;
import org.utng.app.yacalu.businesstips.BusinessTipsSituationsActivity;
import org.utng.app.yacalu.businesstips.BusinessTipsVocabularyctivity;

public class BusinessEnglishActivity extends AppCompatActivity {

    private ImageView ivTipRead;
    private ImageView ivTipPrograms;
    private ImageView ivTipVocabulary;
    private ImageView ivTipSentences;
    private ImageView ivTipPractics;
    private ImageView ivTipSituations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_english);


        ivTipRead = (ImageView) findViewById(R.id.iv_tip_read);
        ivTipRead.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), BusinessTipsReadActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        ivTipPrograms = (ImageView) findViewById(R.id.iv_tip_programs);
        ivTipPrograms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), BusinessTipsProgramsActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        ivTipVocabulary = (ImageView) findViewById(R.id.iv_tip_vocab);
        ivTipVocabulary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),  BusinessTipsVocabularyctivity.class);
                startActivityForResult(intent, 0);
            }
        });
        ivTipSentences= (ImageView) findViewById(R.id.iv_tip_senten);
        ivTipSentences.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),  BusinessTipsSentenActivity.class);
                startActivityForResult(intent, 0);
            }
        });
       ivTipPractics = (ImageView) findViewById(R.id.iv_tip_pract);
        ivTipPractics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),  BusinessTipsPracticActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        ivTipSituations = (ImageView) findViewById(R.id.iv_tip_situations);
        ivTipSituations.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),  BusinessTipsSituationsActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
