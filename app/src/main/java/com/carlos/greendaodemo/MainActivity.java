package com.carlos.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.carlos.greendaodemo.entity.User;
import com.carlos.greendaodemo.utils.Dbutils;

import java.util.List;

import static com.carlos.greendaodemo.application.MyApplication.I;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dbutils.deleteAll();
                final User user = new User(I+"","Sxl","711");
                final User user1 = new User(I*10+"","mmm","711");
                Dbutils.insertUser(user);
                Dbutils.insertUser(user1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> user1 = Dbutils.queryAllUser();
                String result="";
                for (User user :user1){
                    result += user.toString() + '\n';
                }
                textView.setText(result );
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> user1 = Dbutils.querydataBy("Sxl");
                String result="";
                for (User user :user1){
                    result += user.toString() + '\n';
                }
                textView.setText(result );
            }
        });
    }
}
