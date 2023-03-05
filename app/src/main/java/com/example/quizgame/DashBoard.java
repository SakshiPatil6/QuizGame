package com.example.quizgame;

import static com.example.quizgame.MainActivity.list_of_que;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;


import java.util.Collections;
import java.util.List;

public class DashBoard extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timer_value=20;
    LinearProgressIndicator progressIndicator;
    List<Modal> all_que_list;
    Modal modal_class;
    int index=0;
    TextView que, opa,opb,opc,opd;
    CardView cardA, cardB, cardC , cardD;
    int correct_count=0;
    int wrong_count=0;
    LinearLayout next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        idMethod();

        all_que_list=list_of_que;
        //Collections.shuffle(all_que_list);
        modal_class=list_of_que.get(index);


        countDownTimer=new CountDownTimer(20000,50000) {
            @Override
            public void onTick(long l) {
                timer_value=timer_value-1;
                progressIndicator.setProgress(timer_value);
            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(DashBoard.this,R.style.Dial);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogue);
                dialog.show();

                dialog.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i= new Intent(DashBoard.this, MainActivity.class);
                        startActivity(i);
                    }
                });

            }
        }.start();
        index=0;
        setAllData();
    }

    private void setAllData()
    {
        que.setText(modal_class.getQ());
        opa.setText(modal_class.getoA());
        opb.setText(modal_class.getoB());
        opc.setText(modal_class.getoC());
        opd.setText(modal_class.getoD());

    }

    private void idMethod()
    {
        progressIndicator=findViewById(R.id.quiz_timer);

        que=findViewById(R.id.que);
        opa=findViewById(R.id.op1);
        opb=findViewById(R.id.op2);
        opc=findViewById(R.id.op3);
        opd=findViewById(R.id.op4);

        cardA=findViewById(R.id.card2);
        cardB=findViewById(R.id.card3);
        cardC=findViewById(R.id.card4);
        cardD=findViewById(R.id.card5);

        next=findViewById(R.id.next);

    }

    public void nextClick()
    {
        next.setClickable(true);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(index<list_of_que.size()-1)
                {
                    index++;
                    modal_class=list_of_que.get(index);
                    setAllData();
                    resetColor();
                }
                else
                {
                    GameWon();
                }
            }
        });
        enable();
    }


    public void correct(CardView card)
    {
        card.setCardBackgroundColor(getResources().getColor(R.color.green));
        correct_count++;
        nextClick();

    }
    public void wrong(CardView card)
    {
        card.setCardBackgroundColor(getResources().getColor(R.color.red));
        wrong_count++;
        nextClick();

    }

    private void GameWon()
    {
        Intent i=new Intent(DashBoard.this,WonActivity.class);
        i.putExtra("correct",correct_count);
        i.putExtra("wrong",wrong_count);
        startActivity(i);
    }

    public void enable()
    {
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }

    public void disable()
    {
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);
    }

    public void resetColor()
    {
        cardA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    public void opA(View view) {
        next.setClickable(true);
        disable();
        if(modal_class.getoA().equals(modal_class.getAns()))
        {
            if(index<list_of_que.size()-1)
            {
                correct(cardA);
            }
            else
            {
                GameWon();
            }
        }
        else
        {
            wrong(cardA);
        }
    }

    public void opB(View view) {
        next.setClickable(true);
        disable();
        if(modal_class.getoB().equals(modal_class.getAns()))
        {
            if(index<list_of_que.size()-1)
            {
                correct(cardB);
            }
            else
            {
                GameWon();
            }
        }
        else
        {
            wrong(cardB);
        }
    }

    public void opC(View view) {
        next.setClickable(true);
        disable();
        if(modal_class.getoC().equals(modal_class.getAns()))
        {
            if(index<list_of_que.size()-1)
            {
               correct(cardC);
            }
            else
            {
                GameWon();
            }
        }
        else {
            wrong(cardC);
        }
    }

    public void opD(View view) {
        next.setClickable(true);
        disable();
        if(modal_class.getoD().equals(modal_class.getAns()))
        {

            if(index<list_of_que.size()-1)
            {
                correct(cardD);
            }
            else
            {
                GameWon();
            }
        }
        else
        {
            wrong(cardD);
        }
    }
}
