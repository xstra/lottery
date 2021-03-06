package com.xstra.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int count=0;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

    TextView n1 = findViewById( R.id.number1 );
    TextView n2 = findViewById( R.id.number2 );
    TextView n3 = findViewById( R.id.number3 );
    TextView n4 = findViewById( R.id.number4 );
    TextView n5 = findViewById( R.id.number5 );
    TextView n6 = findViewById( R.id.number6 );
    TextView[] save1 = new TextView[6];
    TextView[] save2 = new TextView[6];
    TextView[] save3 = new TextView[6];
    TextView[] save4 = new TextView[6];
    TextView[] save5 = new TextView[6];

    save1[0] = findViewById( R.id.save11 );
    save1[1] = findViewById( R.id.save12 );
    save1[2] = findViewById( R.id.save13 );
    save1[3] = findViewById( R.id.save14 );
    save1[4] = findViewById( R.id.save15 );
    save1[5] = findViewById( R.id.save16 );

    save2[0] = findViewById( R.id.save21 );
    save2[1] = findViewById( R.id.save22 );
    save2[2] = findViewById( R.id.save23 );
    save2[3] = findViewById( R.id.save24 );
    save2[4] = findViewById( R.id.save25 );
    save2[5] = findViewById( R.id.save26 );

    save3[0] = findViewById( R.id.save31 );
    save3[1] = findViewById( R.id.save32 );
    save3[2] = findViewById( R.id.save33 );
    save3[3] = findViewById( R.id.save34 );
    save3[4] = findViewById( R.id.save35 );
    save3[5] = findViewById( R.id.save36 );

    save4[0] = findViewById( R.id.save41 );
    save4[1] = findViewById( R.id.save42 );
    save4[2] = findViewById( R.id.save43 );
    save4[3] = findViewById( R.id.save44 );
    save4[4] = findViewById( R.id.save45 );
    save4[5] = findViewById( R.id.save46 );

    save5[0] = findViewById( R.id.save51 );
    save5[1] = findViewById( R.id.save52 );
    save5[2] = findViewById( R.id.save53 );
    save5[3] = findViewById( R.id.save54 );
    save5[4] = findViewById( R.id.save55 );
    save5[5] = findViewById( R.id.save56 );

    final int[] random =new int[6];

    LottieAnimationView lotteryButton = findViewById( R.id.lotteryButton );
    LottieAnimationView saveButton = findViewById( R.id.saveButton );
    LottieAnimationView resetButton = findViewById( R.id.resetButton );
    ArrayList<TextView> Numbers = new ArrayList<>( Arrays.asList( n1, n2, n3, n4, n5, n6 ) );

//    Toast.makeText(getApplicationContext(), "???????????????.", Toast.LENGTH_LONG).show();
        toast=Toast.makeText(this,"?????? ????????? ??????????????? ???????????? ???????????????.", Toast.LENGTH_LONG);
        toast.setGravity( Gravity.TOP,0,1570 );
        toast.show();

    final CountDownTimer countDownTimer = new CountDownTimer( 2000, 100 ) {
            //2??? ?????? 0.1?????? ???????????? onTick ???????????? ???????????????
            @Override
            public void onFinish() {
            } //??????
            //???????????? ?????? ??? ???????????? ?????? ??? ??????
            @Override
            public void onTick(long p0) {
                for (int i = 0; i < 6; i++) {
                    random[i] = (int) (Math.random() * 45) + 1;
                    for (int j = 0; j < i; j++) {
                        if (random[i] == random[j]) {
                            i--;
                        }
                    }
                    Numbers.get(i).setText(String.valueOf(random[i]));
                }
            }
        };
        lotteryButton.setOnClickListener( view -> {
                lotteryButton.playAnimation();
                countDownTimer.start();
            toast=Toast.makeText(getApplicationContext(),"????????? ???????????? Save ??? ???????????????.", Toast.LENGTH_LONG);
            toast.setGravity( Gravity.TOP,0,1570 );
            //            toast.setGravity( Gravity.TOP|Gravity.START,200,1420 );
            toast.show();
        });
        saveButton.setOnClickListener( view -> {
            saveButton.playAnimation();

            count += 1;
            if (count == 1 || save1[0].getText().toString().equals( "" )) {
                for (int i = 0; i < save1.length; i++) {
                save1[i].setText( (String.valueOf( random[i] )) );
            }
            } else if (count == 2 || save2[0].getText().toString().equals( "" )) {
                for (int i = 0; i < save2.length; i++) {
                    save2[i].setText( (String.valueOf( random[i] )) );
                }
            } else if (count == 3 || save3[0].getText().toString().equals( "" )) {
                for (int i = 0; i < save3.length; i++) {
                    save3[i].setText( (String.valueOf( random[i] )) );
                }
            }    else if (count == 4 || save4[0].getText().toString().equals( "" )) {
                for (int i = 0; i < save4.length; i++) {
                    save4[i].setText( (String.valueOf( random[i] )) );
                }
            }   else if (count == 5 || save5[0].getText().toString().equals( "" )) {
                for (int i = 0; i < save5.length; i++) {
                    save5[i].setText( (String.valueOf( random[i] )) );
                }
            }
                toast=Toast.makeText(getApplicationContext(),"????????? ???????????? $????????? ???????????????.", Toast.LENGTH_LONG);
                toast.setGravity( Gravity.TOP,0,1570 );
            //               toast.setGravity( Gravity.TOP|Gravity.START,200,1420 );
                toast.show();
        } );
        resetButton.setOnClickListener( view -> {
            resetButton.playAnimation();
            for (int i = 0; i < save1.length; i++) {
                save1[i].setText(null);
                save2[i].setText(null);
                save3[i].setText(null);
                save4[i].setText(null);
                save5[i].setText(null);
            }
        });
    }
}

