package com.example.dominic_urso.buttonapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private View Window;
    private Button BgButton;
    private int[] colors;
    private EditText txt_box;
    private TextView txt_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window = findViewById(R.id.Window);
        BgButton = findViewById(R.id.BgButton);
        Window.setBackgroundColor(Color.BLACK);
        txt_box = findViewById(R.id.txt_box);
        txt_view = findViewById(R.id.txt_view);




        BgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                String command = txt_box.getText().toString();
                switch  (command.toLowerCase()){
                    case "test1":
                        txt_view.setText("its not kevin");
                        break;
                    case "test2":
                        txt_view.setText("its working");
                        break;
                    case "finders fee":
                        txt_view.setText("cool");
                        break;
                    case "password":
                        txt_view.setText("Enter Password...");
                    default:
                        txt_view.setText("its broke");
                        break;

                }

            }
        });



    }
}

