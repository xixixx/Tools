package com.show.zyh.show_time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.show.zyh.show_time.utils.TouchDelegates;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view=findViewById(R.id.extend_view);

        pudateViewTouchDegree(view);
    }

    private void pudateViewTouchDegree(View  view) {
        TouchDelegates.extendTouchRang(400,view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"测试TouchDelegate这个类实现扩大Touch范围",Toast.LENGTH_LONG).show();
            }
        });
    }
}
