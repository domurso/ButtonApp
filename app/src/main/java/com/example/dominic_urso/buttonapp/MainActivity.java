package com.example.dominic_urso.buttonapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private View Window;
    private Button BgButton;
    private int[] colors;
    private EditText txt_box;
    private TextView txt_view;
    private String test = "not working";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window = findViewById(R.id.Window);
        BgButton = findViewById(R.id.BgButton);
        Window.setBackgroundColor(Color.BLACK);
        txt_box = findViewById(R.id.txt_box);
        txt_view = findViewById(R.id.txt_view);
        txt_view.setMovementMethod(new ScrollingMovementMethod());
        txt_view.setText("1 to play war, 2 to do nothing, 3 for test, 4 for new password, 5 for last passwords generated");
        final ArrayList<String> prevPasswords = new ArrayList<String>();


        BgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                String command = txt_box.getText().toString();
                switch  (command.toLowerCase()){
                    case "1":
                        war();
                        break;
                    case "2":
                        //connect4();
                        break;
                    case "3":
                        txt_view.setText(test);
                        break;
                    case "4":
                        String password = "";
                        txt_view.setText("");
                        int length, numChars = 0;
                        Random rand = new Random();
                        //Scanner scan = new Scanner(System.in);
                        //txt_view.setText("Length Of Password = ");
                        length = 12;
                        while(numChars != length) {
                            int character = rand.nextInt(93) + 33;
                            password +=("" +(char) character);
                            numChars++;
                        }
                        prevPasswords.add(password);
                        txt_view.setText(password);
                        break;
                    case "5":
                        txt_view.setText(" ");
                        for(int i = 0; i < prevPasswords.size(); i++){
                            txt_view.append(prevPasswords.get(i) + "\n");
                        }
                        break;

                    default:
                        txt_view.setText("its broke");
                        break;

                }

            }
        });



    }

    public void war(){
        txt_view.setText("");
        String winner = "";
        String mWinner = "";
        int temps = 0;
        int draws = 0;
        int p1Wins = 0;
        int p2Wins = 0;
        int tieWins = 0;
        boolean draw = false;
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> half = new ArrayList();
        ArrayList<Card> half2 = new ArrayList();
        ArrayList<Card> temp = new ArrayList();
        for(int i = 0; i < 26; i++){
            half.add(deck.deal());
        }
        for(int i = 0; i < 26; i++){
            half2.add(deck.deal());
        }
        Scanner scan = new Scanner(System.in);
        while(half2.size() > 0 && half.size() > 0){
            while(draw == true){
                txt_view.append("press 1 to draw");
                if(scan.nextInt() == 1){
                    draw = true;
                }
            }
            txt_view.append(half.get(half.size() - 1).toString() + " vs " + half2.get(half2.size() - 1).toString() );
            if(half.get(half.size() - 1).getRank() > half2.get(half2.size() - 1).getRank()){
                half.add(0, half2.remove(half2.size() - 1));
                half.add(0, half.remove(half.size() - 1));
                for(int i = 0; i < temps; i++){
                    half.add(0, temp.remove(0));
                }
                winner = "Player 1";
                p1Wins++;
            }

            else if(half.get(half.size() - 1).getRank() < half2.get(half2.size() - 1).getRank()){
                half2.add(1, half.remove(half.size() - 1));

                half2.add(0, half2.remove(half2.size() - 1));
                for(int i = 0; i < temps; i++){
                    half2.add(0, temp.remove(0));
                }
                winner = "Player 2";
                p2Wins++;
            }
            else if(half.get(half.size() - 1).getRank() == half2.get(half2.size() - 1).getRank()){
                temp.add(0, half.remove(half.size() - 1));
                temp.add(0, half.remove(half.size() - 1));
                temp.add(0, half.remove(half.size() - 1));

                temp.add(0, half2.remove(half2.size() - 1));
                temp.add(0, half2.remove(half2.size() - 1));
                temp.add(0, half2.remove(half2.size() - 1));
                winner = "Tie";
                tieWins++;


            }
            draw = false;
            draws++;
            txt_view.append("Hand Details:\tP1 Cards Left " + half.size()  + " \tP2 Cards Left " + half2.size() + " \tPile Of Cards " + temp.size() + "\t\tdraw: " + draws + "\tResult: " + winner + "\n");
            temps = temp.size();

        }

        if(half2.size() != 0)
            mWinner = "Player 2";
        else
            mWinner = "Player 1";
        txt_view.append("Match Details\n-------------- \n"+mWinner + " Won\n" +draws + " Hands Played\n" + "Player 1 Won " + p1Wins + " Hands\n" + "Player 2 Won " + p2Wins + " Hands\n" + tieWins + " Tied Hands\n"  );

    }
}

