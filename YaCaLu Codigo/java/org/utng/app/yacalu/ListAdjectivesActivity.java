package org.utng.app.yacalu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ClipData;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import org.utng.app.yacalu.R;
import java.util.Random;




public class ListAdjectivesActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout targetNew, targetDreaf, targetRound, targetInter,targetBeaut, targetBlue,targetThis, targetThos, targetMany, targetMuch;
    Button testNew, testDreaf, testRound, testInter, testBeaut, btnNew, btnDreaf, btnRound, btnInter, btnBeaut, btnBlue, btnThis, btnThos,btnMany, btnMuch,
            testBlue, testThis, testThos, testMany, testMuch,  btnQuestion;



    int[] preg ={R.id.target_new, R.id.target_dreaf, R.id.target_round, R.id.target_inter, R.id.target_beaut, R.id.target_blue, R.id.target_this, R.id.target_thos, R.id.target_many, R.id.target_much};
    int [] resp={R.id.btn_new, R.id.btn_dreaf, R.id.btn_round,  R.id.btn_their,  R.id.btn_beaut,
            R.id.btn_blue,  R.id.btn_this, R.id.btn_thos,  R.id.btn_many,  R.id.btn_much,  R.id.btn_much};
    int y;
    int corrects;
    int errors;
    boolean[] right= new boolean[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_list_adjectives);



        targetNew = (LinearLayout) findViewById(R.id.target_new);
        targetDreaf = (LinearLayout) findViewById(R.id.target_dreaf);
        targetRound = (LinearLayout) findViewById(R.id.target_round);
        targetInter = (LinearLayout) findViewById(R.id.target_inter);
        targetBeaut = (LinearLayout) findViewById(R.id.target_beaut);
        targetBlue = (LinearLayout) findViewById(R.id.target_blue);
        targetThis = (LinearLayout) findViewById(R.id.target_this);
        targetThos = (LinearLayout) findViewById(R.id.target_thos);
        targetMany = (LinearLayout) findViewById(R.id.target_many);
        targetMuch = (LinearLayout) findViewById(R.id.target_much);


        testNew = (Button) findViewById(R.id.test_new);
        testDreaf = (Button) findViewById(R.id.test_dreaf);
        testRound = (Button) findViewById(R.id.test_round);
        testInter = (Button) findViewById(R.id.test_inter);
        testBeaut = (Button) findViewById(R.id.test_beaut);
        testBlue = (Button) findViewById(R.id.test_blue);
        testThis = (Button) findViewById(R.id.test_this);
        testThos = (Button) findViewById(R.id.test_thos);
        testMany = (Button) findViewById(R.id.test_many);
        testMuch = (Button) findViewById(R.id.test_much);



        btnNew = (Button) findViewById(R.id.btn_new);
        btnDreaf = (Button) findViewById(R.id.btn_dreaf);
        btnRound = (Button) findViewById(R.id.btn_round);
        btnInter = (Button) findViewById(R.id.btn_their);
        btnBeaut = (Button) findViewById(R.id.btn_beaut);
        btnBlue = (Button) findViewById(R.id.btn_blue);
        btnThis = (Button) findViewById(R.id.btn_this);
        btnThos = (Button) findViewById(R.id.btn_thos);
        btnMany = (Button) findViewById(R.id. btn_many);
        btnMuch = (Button) findViewById(R.id.btn_much);
        btnQuestion = (Button) findViewById(R.id.btn_newquestion);



        //txtcorrects = (EditText) findViewById(R.id.txt_corrects);
        //  txterrors = (EditText) findViewById(R.id.txt_errors);
        //target1.setOnDragListener(dragListenre);
        //target2.setOnDragListener(dragListenre);
        //target_round.setOnDragListener(dragListenre);
        //target_inter.setOnDragListener(dragListenre);
        //target_beaut.setOnDragListener(dragListenre);


        btnNew.setOnLongClickListener(longClickListener);
        btnDreaf.setOnLongClickListener(longClickListener);
        btnRound.setOnLongClickListener(longClickListener);
        btnInter.setOnLongClickListener(longClickListener);
        btnBeaut.setOnLongClickListener(longClickListener);
        btnBlue.setOnLongClickListener(longClickListener);
        btnThis.setOnLongClickListener(longClickListener);
        btnThos.setOnLongClickListener(longClickListener);
        btnMany.setOnLongClickListener(longClickListener);
        btnMuch.setOnLongClickListener(longClickListener);
        btnQuestion.setOnClickListener(this);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadwoBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadwoBuilder, v, 0);
            return true;

        }
    };

    View.OnDragListener dragListenre = new View.OnDragListener() {


        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();



            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    if (view.getId() == R.id.btn_new){
                        testNew.setText("The Car is new");
                    }else if (view.getId() == R.id.btn_dreaf){
                        testDreaf.setText("What you wrote her is dreadful");

                    }
                    else
                    if (view.getId() == R.id.btn_round){
                        testRound.setText("The Earth is round");

                    }
                    else
                    if (view.getId() == R.id.btn_their){
                        testInter.setText("The meeting was interesting.");

                    }
                    else
                    if (view.getId() == R.id.btn_beaut){
                        testBeaut.setText("It is a beautiful dog");

                    }
                    else
                    if (view.getId() == R.id.btn_blue){
                        testBlue.setText("I have a blue skirt");

                    }
                    else
                    if (view.getId() == R.id.btn_this){
                        testThis.setText("This car is very fast");

                    }
                    else
                    if (view.getId() == R.id.btn_thos){
                        testThos.setText("Those are my shoes");

                    }
                    else
                    if (view.getId() == R.id.btn_many){
                        testMany.setText("There are so many thigs to do.");

                    }
                    else
                    if (view.getId() == R.id.btn_much){
                        testMuch.setText("there is no much time.");

                    }
                    break;

                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    if(view.getId() == R.id.btn_new){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[0]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        //txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_dreaf && v.getId() == R.id.target_dreaf){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[1]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        //txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_round && v.getId() == R.id.target_round) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[2]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        //  txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_their && v.getId() == R.id.target_inter) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[3]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        //    txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_beaut && v.getId() == R.id.target_beaut){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[4]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        // txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_blue && v.getId() == R.id.target_blue){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[5]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        // txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_this && v.getId() == R.id.target_this){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[6]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        // txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_thos && v.getId() == R.id.target_thos){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[7]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        // txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_many && v.getId() == R.id.target_many){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[8]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        // txtcorrects.setText(""+ corrects);
                    }else
                    if(view.getId() == R.id.btn_much && v.getId() == R.id.target_much){
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        right[9]=true;
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.good),Toast.LENGTH_SHORT).show();
                        corrects++;
                        // txtcorrects.setText(""+ corrects);
                    }

                    else{
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.erros),Toast.LENGTH_SHORT).show();
                        errors ++;
                        //txterrors.setText(""+ errors);
                    }
                    if (corrects==10){
                        int calif =corrects*10/(corrects+errors);
                        Toast.makeText(getApplication(),("android.resource://org.utng.app.yacalu/"+R.string.finishGame) +corrects+("android.resource://org.utng.app.yacalu/"+R.string.good) +
                                errors + ("android.resource://org.utng.app.yacalu/"+R.string.finishGame) + calif,Toast.LENGTH_LONG).show();
                        btnQuestion.setEnabled(false);
                    }
                    break;

            }
            return true;
        }

    };

    @Override
    public void onClick(View view) {
        Random rn = new Random();

        //for(int i =0; i < 5; i++)
        //{
        switch (y){
            case 0:
                testNew.setVisibility(View.INVISIBLE);
                break;
            case 1:
                testDreaf.setVisibility(View.INVISIBLE);
                break;
            case 2:
                testRound.setVisibility(View.INVISIBLE);
                break;
            case 3:
                testInter.setVisibility(View.INVISIBLE);
                break;
            case 4:
                testBeaut.setVisibility(View.INVISIBLE);
            case 5:
                testBlue.setVisibility(View.INVISIBLE);
                break;
            case 6:
                testThis.setVisibility(View.INVISIBLE);
                break;
            case 7:
                testThos.setVisibility(View.INVISIBLE);
                break;
            case 8:
                testMany.setVisibility(View.INVISIBLE);
                break;
            case 9:
                testMuch.setVisibility(View.INVISIBLE);

        }
        do {
            y = rn.nextInt(preg.length);
        }while(right[y]);
        switch (y){
            case 0:
                targetNew.setOnDragListener(dragListenre);
                break;
            case 1:
                targetDreaf.setOnDragListener(dragListenre);
                break;
            case 2:
                targetRound.setOnDragListener(dragListenre);
                break;
            case 3:
                targetInter.setOnDragListener(dragListenre);
                break;
            case 4:
                targetBeaut.setOnDragListener(dragListenre);
                break;
            case 5:
                targetBlue.setOnDragListener(dragListenre);
                break;
            case 6:
                targetThis.setOnDragListener(dragListenre);
                break;
            case 7:
                targetThos.setOnDragListener(dragListenre);
                break;
            case 8:
                targetMany.setOnDragListener(dragListenre);
                break;
            case 9:
                targetMuch.setOnDragListener(dragListenre);
                break;

        }
        ;
        //System.out.println(preg[x]);
        //}
        switch (y){
            case 0:
                testNew.setText("android.resource://org.utng.app.yacalu/"+R.string.test_new);
                testNew.setVisibility(View.VISIBLE);
                break;
            case 1:
                testDreaf.setText("android.resource://org.utng.app.yacalu/"+R.string.test_dreaf);
                testDreaf.setVisibility(View.VISIBLE);
                break;
            case 2:
                testRound.setText("android.resource://org.utng.app.yacalu/"+R.string.test_round);
                testRound.setVisibility(View.VISIBLE);
                break;
            case 3:
                testInter.setText("android.resource://org.utng.app.yacalu/"+R.string.test_inter);
                testInter.setVisibility(View.VISIBLE);
                break;
            case 4:
                testBeaut.setText("android.resource://org.utng.app.yacalu/"+R.string.test_beaut);
                testBeaut.setVisibility(View.VISIBLE);
                break;
            case 5:
                testBlue.setText("android.resource://org.utng.app.yacalu/"+R.string.test_blue);
                testBlue.setVisibility(View.VISIBLE);
                break;
            case 6:
                testThis.setText("android.resource://org.utng.app.yacalu/"+R.string.test_this);
                testThis.setVisibility(View.VISIBLE);
                break;
            case 7:
                testThos.setText("android.resource://org.utng.app.yacalu/"+R.string.test_thos);
                testThos.setVisibility(View.VISIBLE);
                break;
            case 8:
                testMany.setText("android.resource://org.utng.app.yacalu/"+R.string.test_their);
                testMany.setVisibility(View.VISIBLE);
                break;
            case 9:
                testMuch.setText("android.resource://org.utng.app.yacalu/"+R.string.test_much);
                testMuch.setVisibility(View.VISIBLE);

        }
    }
}
