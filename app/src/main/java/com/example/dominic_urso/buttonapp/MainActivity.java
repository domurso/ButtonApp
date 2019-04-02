package com.example.dominic_urso.buttonapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


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




        BgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                String command = txt_box.getText().toString();
                switch  (command.toLowerCase()){
                    case "1":
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
                                txt_view.setText("press 1 to draw");
                                if(scan.nextInt() == 1){
                                    draw = true;
                                }
                            }
                            txt_view.setText(half.get(half.size() - 1).toString() + " vs " + half2.get(half2.size() - 1).toString() );
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
                            txt_view.setText("Hand Details:\tP1 Cards Left " + half.size()  + "\t P2 Cards Left " + half2.size() + "\tPile Of Cards " + temp.size() + "\tdraw: " + draws + "\tResult: " + winner + "\n");
                            temps = temp.size();

                        }

                        if(half2.size() != 0)
                            mWinner = "Player 2";
                        else
                            mWinner = "Player 1";
                        txt_view.setText("Match Details\n-------------- \n"+mWinner + " Won\n" +draws + " Hands Played\n" + "Player 1 Won " + p1Wins + " Hands\n" + "Player 2 Won " + p2Wins + " Hands\n" + tieWins + " Tied Hands\n"  );

                        break;
                    case "2":
                        Scanner scan = new Scanner(System.in);
                        // BUILDING BOARD
                        // System.out.print("Board Size\nRows:");
                        // int row = scan.nextInt();
                        // System.out.print("Colums:");
                        // int column = scan.nextInt();
                        int column = 8;
                        int row = 8;
                        Boolean[][] board = new Boolean [row][column];
                        //test conditions
                        // //4 in a row
                        // board[7][4] = false;
                        // board[7][5] = false;
                        // board[7][6] = false;
                        // board[7][7] = true;
                        // //4 in a column
                        // board[4][7] = false;
                        // board[5][7] = false;
                        // board[6][7] = false;
                        // board[7][7] = false;


                        for(int i = 0; i<row; i++)
                        {

                            for(int j = 0; j<column; j++)
                            {
                                System.out.print("   |   ");
                                if(board[i][j] == null)
                                    System.out.print(" ");
                                else
                                if(board[i][j] == true)
                                    System.out.print("X");
                                else
                                if(board[i][j] == false)
                                    System.out.print("O");

                            }
                            System.out.print("   |   \n------------------------------------------------------------------------\n");

                        }
                        for(int j = 0; j<column; j++)
                        {
                            System.out.print("   |   ");
                            System.out.print(j);

                        }
                        System.out.print("   |");
                        // END OF BUILDING BOARD

                        int playerChoice = -1;
                        int compChoice = -1;
                        int draw = 0;
                        String winner = "none";
                        boolean winCondition = false;
                        Random rand = new Random();
                        while(winCondition != true)
                        {
                            System.out.print("\nSelect Row (0-" + (column - 1) + ")");
                            playerChoice = scan.nextInt();
                            for(int m = column - 1; m>-1 ; m--){
                                if(board[m][playerChoice] == null){
                                    board[m][playerChoice] = true;
                                    break;
                                }
                            }
                            // WIN CONDITIONS
                            // 4 in a row
                            for(int i = 0; i<row; i++)
                            {

                                for(int j = 0; j<column - 3; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }

                                }
                            }
                            // 4 in a column
                            for(int i = 0; i<row- 3; i++)
                            {

                                for(int j = 0; j<column; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }
                                }
                            }
                            // 4 in diagonal slope x
                            for(int i = 0; i<row - 3; i++)
                            {

                                for(int j = 0; j<column - 3; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j+ 2] && board[i][j] == board[i + 3][j + 3]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }
                                }
                            }
                            // 4 in diagonal slope -x
                            for(int i = 4; i<row; i++)
                            {

                                for(int j = 0; j<column - 3; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j+ 2] && board[i][j] == board[i - 3][j + 3]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }
                                }
                            }
                            // draw??
                            for(int i = 4; i<row; i++)
                            {

                                for(int j = 0; j<column; j++)
                                {
                                    if(board[i][j] != null)
                                        draw++;
                                }
                            }
                            if (draw == row*column){
                                winCondition = true;
                                winner = "Nobody";
                            }
                            else {
                                draw = 0;
                            }


                            compChoice = rand.nextInt(column);
                            for(int m = column - 1; m>-1 ; m--){
                                if(board[m][compChoice] == null){
                                    board[m][compChoice] = false;
                                    break;
                                }
                            }
                            // WIN CONDITIONS
                            // 4 in a row
                            for(int i = 0; i<row; i++)
                            {

                                for(int j = 0; j<column - 3; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }

                                }
                            }
                            // 4 in a column
                            for(int i = 0; i<row- 3; i++)
                            {

                                for(int j = 0; j<column; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }
                                }
                            }
                            // 4 in diagonal slope x
                            for(int i = 0; i<row - 3; i++)
                            {

                                for(int j = 0; j<column - 3; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j+ 2] && board[i][j] == board[i + 3][j + 3]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }
                                }
                            }
                            // 4 in diagonal slope -x
                            for(int i = 4; i<row; i++)
                            {

                                for(int j = 0; j<column - 3; j++)
                                {
                                    if(board[i][j] != null && board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j+ 2] && board[i][j] == board[i - 3][j + 3]){
                                        winCondition = true;
                                        if(board[i][j].booleanValue() == true)
                                            winner = "Player";
                                        else
                                            winner = "Computer";
                                    }
                                }
                            }
                            // draw??
                            for(int i = 4; i<row; i++)
                            {

                                for(int j = 0; j<column; j++)
                                {
                                    if(board[i][j] != null)
                                        draw++;
                                }
                            }
                            if (draw == column*row){
                                winCondition = true;
                                winner = "Nobody";
                            }
                            else{
                                draw = 0;
                            }


                            for(int i = 0; i<row; i++)
                            {

                                for(int j = 0; j<column; j++)
                                {
                                    System.out.print("   |   ");
                                    if(board[i][j] == null)
                                        System.out.print(" ");
                                    else
                                    if(board[i][j] == true)
                                        System.out.print("X");
                                    else
                                    if(board[i][j] == false)
                                        System.out.print("O");

                                }
                                System.out.print("   |   \n------------------------------------------------------------------------\n");

                            }
                            for(int j = 0; j<column; j++)
                            {
                                System.out.print("   |   ");
                                System.out.print(j);

                            }
                            System.out.print("   |");
                        }
                        System.out.print("\n" + winner + " wins");
                        // End Of Win Conditions


                        break;
                    case "3":
                        txt_view.setText(test);
                        break;
                    case "4":
                        txt_view.setText("Enter Password...");
                    default:
                        txt_view.setText("its broke");
                        break;

                }

            }
        });



    }
}

