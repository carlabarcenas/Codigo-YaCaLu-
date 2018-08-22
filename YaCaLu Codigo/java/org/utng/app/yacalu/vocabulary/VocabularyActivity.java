package org.utng.app.yacalu.vocabulary;


import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import org.utng.app.yacalu.R;

import android.os.Bundle;

public class VocabularyActivity extends AppCompatActivity {

    //Variables que se van a mover
    private ImageView ivPartyOne;
    private ImageView ivAskOne;
    private ImageView ivWebOne;
    private ImageView ivThrottleOne;
    private ImageView ivLuggageOne;
    private ImageView ivkeyboardOne;


    //Variables de ayuda
    private ImageView ivParty;
    private ImageView ivAsk;
    private ImageView ivWeb;
    private ImageView ivThrottle;
    private ImageView ivLuggage;
    private ImageView ivKeyboard;

    //Variables de contenedor
    private LinearLayout llParty;
    private LinearLayout llAsk;
    private LinearLayout llWeb;
    private LinearLayout llThrottle;
    private LinearLayout llLuggage;
    private LinearLayout llKeyboard;

    //Variables para el sonido
    private MediaPlayer mediaParty;
    private MediaPlayer mediaAsk;
    private MediaPlayer mediaWeb;
    private MediaPlayer mediaThrottle;
    private MediaPlayer mediaLuggage;
    private MediaPlayer mediaKeyboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);


        //Se asigna a la variable su correspondiente de la vista
        ivPartyOne = (ImageView)findViewById(R.id.iv_party_one);
        ivAskOne = (ImageView)findViewById(R.id.iv_ask_one);
        ivWeb = (ImageView)findViewById(R.id.iv_web_one);
        ivThrottle = (ImageView)findViewById(R.id.iv_throttle_one);
        ivLuggage = (ImageView)findViewById(R.id.iv_keyboard_one);
        ivkeyboardOne = (ImageView)findViewById(R.id.iv_keyboard_one);

        ivParty = (ImageView)findViewById(R.id.iv_party);
        ivAsk = (ImageView)findViewById(R.id.iv_ask);
        ivWeb = (ImageView)findViewById(R.id.iv_server);
        ivThrottle = (ImageView)findViewById(R.id.iv_throttle);
        ivLuggage = (ImageView)findViewById(R.id.iv_luggage);
        ivKeyboard = (ImageView)findViewById(R.id.iv_keyboard);

        llParty = (LinearLayout)findViewById(R.id.ll_party);
        llAsk = (LinearLayout)findViewById(R.id.ll_ask);
        llWeb = (LinearLayout)findViewById(R.id.ll_web);
        llThrottle= (LinearLayout)findViewById(R.id.ll_throttle);
        llLuggage = (LinearLayout)findViewById(R.id.ll_lugga);
        llKeyboard = (LinearLayout)findViewById(R.id.ll_key);

        //Se asina el metodo de sombra de arrastre longClickListener
        ivPartyOne.setOnLongClickListener(longClickListener);
        ivAskOne.setOnLongClickListener(longClickListener);
        ivWebOne.setOnLongClickListener(longClickListener);
        ivThrottleOne.setOnLongClickListener(longClickListener);
        ivLuggageOne.setOnLongClickListener(longClickListener);
        ivkeyboardOne.setOnLongClickListener(longClickListener);

        //Se le asigna el metodo de arrastrar y soltar dragListener
        ivParty.setOnDragListener(dragListener);
        ivAsk.setOnDragListener(dragListener);
        ivWeb.setOnDragListener(dragListener);
        ivThrottle.setOnDragListener(dragListener);
        ivLuggage.setOnDragListener(dragListener);
        ivKeyboard.setOnDragListener(dragListener);

        //Se extrae el audio y se prepara para su reproduccion
        mediaParty = MediaPlayer.create(this, R.raw.party);
        mediaAsk = MediaPlayer.create(this, R.raw.ask);
        mediaWeb = MediaPlayer.create(this, R.raw.web);
        mediaThrottle = MediaPlayer.create(this, R.raw.throttle);
        mediaLuggage = MediaPlayer.create(this, R.raw.lugg);
        mediaKeyboard = MediaPlayer.create(this, R.raw.keyboard);
    }


    /**
     * se crea una sombra del objeto que se decea mover
     * @param
     */
    View.OnLongClickListener longClickListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,shadowBuilder,v,0);
            return true;
        }
    };

    /**
     * se captura el momento que el ususario deja precionado la tecla por un tiempo
     * y cuando arrastra el objeto hasta el momento en que lo suelta
     * @param v,event
     */
    View.OnDragListener dragListener = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view =(View)event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.iv_party_one && v.getId()==R.id.ll_party){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivParty.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaParty.start();

                    }else if (view.getId() == R.id.iv_ask_one && v.getId()==R.id.ll_ask){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivAsk.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaAsk.start();

                    }else if (view.getId()==R.id.iv_web_one && v.getId()==R.id.ll_web){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivWeb.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaWeb.start();

                    }else if (view.getId()==R.id.iv_throttle_one && v.getId()==R.id.ll_throttle){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivThrottle.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaThrottle.start();

                    }else if (view.getId()==R.id.iv_luggage_one&& v.getId()==R.id.ll_lugga){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivLuggage.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaLuggage.start();

                    }else if (view.getId()==R.id.iv_keyboard_one && v.getId()==R.id.ll_key){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivLuggage.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaKeyboard.start();
                    }
                    break;
            }
            return true;
        }
    };
}