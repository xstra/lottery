package com.xstra.lottery;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
    int[] random =new int[6];
    String[] num = new String[6];

    LottieAnimationView lotteryButton = findViewById( R.id.lotteryButton );
    ArrayList<TextView> Numbers = new ArrayList<>( Arrays.asList( n1, n2, n3, n4, n5, n6 ) );
//    HashSet<TextView> Numbers = new HashSet<>(Arrays.asList( n1, n2, n3, n4, n5, n6 ));
    final CountDownTimer countDownTimer = new CountDownTimer( 2000, 100 ) {
            //2초 동안 0.1초의 간격으로 onTick 메소드를 호출합니다
            @Override
            public void onFinish() {
            } //종료

            @Override
            public void onTick(long p0) {
                for (int i = 0; i < 6; i++) {
                    random[i] = (int) (Math.random() * 45) + 1;
                    for (int j = 0; j < i; j++) {
                        if (random[i] == random[j]) {
                            i--;
                        }
                    }
                    Numbers.get( i ).setText(String.valueOf(random[i]));
                }
            };
        };
        lotteryButton.setOnClickListener( view -> {
            if (lotteryButton.isAnimating()) {
                lotteryButton.cancelAnimation();
                countDownTimer.cancel();
            } else {
                lotteryButton.playAnimation();
                countDownTimer.start();
            }
        } );
    }
}

