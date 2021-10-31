package com.company;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {

    static String[][] board = new String[10][10];

    public static String[][] Board() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "[]";
                System.out.print(board[i][j]);

            }
            System.out.println("");
        }
        return board;
    }

    public static String[][] InsertMoney(String[][] Table) {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(15)+30; i++) {
            Table[random.nextInt(10)][random.nextInt(10)] = Integer.toString(random.nextInt(1000));
        }
        return Table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String[][] Board = InsertMoney(Board());
        int userMoney = 0;
        System.out.println("You will have 10 guesses!");
        int guessNumber;

        for (guessNumber = 1; guessNumber < 3; guessNumber++) {
            System.out.println("What column would you like to guess?");
            int columnGuess = input.nextInt();
            System.out.println("What row would you like to guess?");
            int rowGuess = input.nextInt();
            String guess = Board[rowGuess-1][columnGuess-1];

            System.out.println("You have had " + (guessNumber) + " guesses!");
            if (guess.charAt(0) != '[')      {
                Integer.parseInt(guess);
                userMoney = userMoney + Integer.parseInt(guess);
                System.out.println("You got: £" + Board[rowGuess-1][columnGuess-1]);
                System.out.println("You currently have: £" + userMoney);
                guess = "X";
                //guessed column and row should now be X
            } else if (guess.charAt(0) == 'X') {
                System.out.println("You've already guessed there!");
                guessNumber--;
            }
            else {
                System.out.println("Unlucky, you got no money that try!");
                System.out.println("You currently have: £" + userMoney);
                guess = "X";
            }
            System.out.println(Board());
        }
        System.out.println("Your final total is: £ " + userMoney);




    }

}


// ISSUE WITH CODE TO REMEMBER: WHEN USER GUESSES SAME PLACE AGAIN, THE VALUE ISN'T RECOGNISED AT "X" SO IT COUNTS AS A GUESS WHEN IT SHOULDN'T