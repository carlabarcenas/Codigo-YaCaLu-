package org.utng.app.yacalu;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import org.utng.app.yacalu.R;

import java.util.Random;

public class MemoActivity extends AppCompatActivity implements View.OnClickListener  {
    boolean banOk= false;
    Button btnStar;
    EditText etPoint;
    EditText etIntents;
    ImageButton[] board=new ImageButton[20];
    int[] cards=new int[20];
    int[] data= new int[20];
    int click=0;
    int point=0;
    int pos1;//posición del primer click
    int pos2;//posición del segundo click
    boolean[] blocked = new boolean[20];
    int fails=0;

    int[]image={R.drawable.ic_attend, R.drawable.ic_buy, R.drawable.ic_call, R.drawable.ic_care, R.drawable.ic_celebrate,
            R.drawable.ic_chatch, R.drawable.ic_cook, R.drawable.ic_drive, R.drawable.ic_eat, R.drawable.ic_listen,
            R.drawable.ic_love, R.drawable.ic_pay, R.drawable.ic_save, R.drawable.ic_share, R.drawable.ic_sleep, R.drawable.ic_talk, R.drawable.ic_win};
    int[]verb={R.drawable.ic_respattend, R.drawable.ic_respbuy, R.drawable.ic_respcall, R.drawable.ic_respcare, R.drawable.ic_respcelebrate, R.drawable.ic_respcatch,
            R.drawable.ic_respcook, R.drawable.ic_respdrive, R.drawable.ic_respeat, R.drawable.ic_resplisten, R.drawable.ic_resplove, R.drawable.ic_resppay, R.drawable.ic_respsave, R.drawable.ic_respshare, R.drawable.ic_respsleep, R.drawable.ic_resptalk, R.drawable.ic_respwin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        Starboard();etPoint=(EditText)findViewById(R.id.et_point);
        etIntents=(EditText)findViewById(R.id.et_intents);
        btnStar=(Button)findViewById(R.id.btn_new);
        btnStar.setOnClickListener(this);
    }
    public void Starboard(){
        board[0]= (ImageButton)findViewById(R.id.btn_attend);
        board[1]= (ImageButton)findViewById(R.id.btn_buy);
        board[2]= (ImageButton)findViewById(R.id.btn_call);
        board[3]= (ImageButton)findViewById(R.id.btn_care);
        board[4]= (ImageButton)findViewById(R.id.btn_celebration);
        board[5]= (ImageButton)findViewById(R.id.btn_chatch);
        board[6]= (ImageButton)findViewById(R.id.btn_cook);
        board[7]= (ImageButton)findViewById(R.id.btn_drive);
        board[8]= (ImageButton)findViewById(R.id.btn_eat);
        board[9]= (ImageButton)findViewById(R.id.btn_listen);
        board[10]= (ImageButton)findViewById(R.id.btn_love);
        board[11]= (ImageButton)findViewById(R.id.btn_pay);
        board[12]= (ImageButton)findViewById(R.id.btn_save);
        board[13]= (ImageButton)findViewById(R.id.btn_share);
        board[14]= (ImageButton)findViewById(R.id.btn_sleep);
        board[15]= (ImageButton)findViewById(R.id.btn_talk);
        board[16]= (ImageButton)findViewById(R.id.btn_win);
        board[17]= (ImageButton)findViewById(R.id.btn_jump);
        board[18]= (ImageButton)findViewById(R.id.btn_run);
        board[19]= (ImageButton)findViewById(R.id.btn_ride);
        for(int i= 0; i<20;i++){
            board[i].setOnClickListener(this);
        }

    }

    public void mezclar() {
        boolean[]seleccionadas = new boolean[15];
        Random aleatoria=new Random();
        int x;
        int n=0;
        while(n<10){
            x= aleatoria.nextInt(seleccionadas.length);
            if(!seleccionadas[x]){
                cards[n]= image[x];
                cards[n+10]=verb[x];
                data[n]=n;
                data[n+10]=n;
                n++;
                seleccionadas[x]=true;

            }
        }
        int tempo;
        int y;
        for(int i=1;i<=100;i++){
            x=aleatoria.nextInt(20);
            y=aleatoria.nextInt(20);
            tempo= cards[x];
            cards[x]=cards[y];
            cards[y]=tempo;
            tempo= data[x];
            data[x]=data[y];
            data[y]=tempo;
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_new) {
            mezclar();
            for (int i = 0; i < 20; i++) {
                board[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_memfond));
                blocked[i]=false;
                fails=0;
                click=0;
                point=0;
                etIntents.setText(""+fails);
                etPoint.setText(""+point);
            }
            banOk=true;
        }
        else if(banOk){
            switch (view.getId()) {

                case R.id.btn_attend:
                    seleccionar(0);
                    break;
                case R.id.btn_buy:
                    seleccionar(1);
                    break;
                case R.id.btn_call:
                    seleccionar(2);
                    break;
                case R.id.btn_care:
                    seleccionar(3);
                    break;
                case R.id.btn_celebration:
                    seleccionar(4);
                    break;

                case R.id.btn_chatch:
                    seleccionar(5);
                    break;
                case R.id.btn_cook:
                    seleccionar(6);
                    break;
                case R.id.btn_drive:
                    seleccionar(7);
                    break;
                case R.id.btn_eat:
                    seleccionar(8);
                    break;
                case R.id.btn_listen:
                    seleccionar(9);
                    break;
                case R.id.btn_love:
                    seleccionar(10);
                    break;
                case R.id.btn_pay:
                    seleccionar(11);
                    break;
                case R.id.btn_save:
                    seleccionar(12);
                    break;
                case R.id.btn_share:
                    seleccionar(13);
                    break;
                case R.id.btn_sleep:
                    seleccionar(14);
                    break;
                case R.id.btn_talk:
                    seleccionar(15);
                    break;
                case R.id.btn_win:
                    seleccionar(16);
                    break;
                case R.id.btn_jump:
                    seleccionar(17);
                    break;
                case R.id.btn_run:
                    seleccionar(18);
                    break;
                case R.id.btn_ride:
                    seleccionar(19);
                    break;
            }
            Handler handler=new Handler();
            if(click==2&&data[pos1]==data[pos2]){
                Toast.makeText(getApplication(),(R.string.right),Toast.LENGTH_SHORT).show();
                point++;
                etPoint.setText(""+point);
                if (point ==10){
                    Toast.makeText(getApplication(),(R.string.right)+fails+(R.string.Fails),Toast.LENGTH_SHORT).show();
                }
            }else if(click==2&&data[pos1]!=data[pos2]){
                Toast.makeText(getApplication(),(R.string.erros),Toast.LENGTH_SHORT).show();
                blocked[pos1]=false;
                blocked[pos2]=false;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        board[pos1].setBackgroundDrawable(
                                getResources().getDrawable(R.drawable.ic_memfond));
                        board[pos2].setBackgroundDrawable(
                                getResources().getDrawable(R.drawable.ic_memfond));
                    }
                },300);


            }
            if(click==3){
                click=1;
            }
        }
    }

    public void seleccionar(int pos){
        if (blocked[pos]==false) {
            board[pos].setBackgroundDrawable(getResources().getDrawable(cards[pos]));
            if (click == 1) {
                pos1 = pos;
            } else {
                pos2 = pos;
            }
            blocked[pos] = true;
            click++;
            fails++;
            etIntents.setText(""+fails);
        }
    }
}
