package com.company;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.Random;

import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        int[][] board = new int[250][250];
        Random rand = new Random();

        while (true) {
            //Add one random color to the board
            int xx = rand.nextInt(20);
            int yy = rand.nextInt(20);
            board[xx][yy] = 255; // rand.nextInt(255);
            //TODO: Insert you’re your code to draw on the screen here

            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board.length; y++) {
                    terminal.moveCursor(x, y);
                    terminal.applyForegroundColor(board[x][y], board[x][y], board[x][y]);
                    terminal.putCharacter('\u2588');
                }
            }
            //Formula to take the average value of the current cell
            //and all of its neighbors
            int[][] tmpboard = new int[250][250];
            for (int y = 1; y < 249; y++) {
                for (int x = 1; x < 249; x++) {
                    int color = 0;
                    color += board[x - 1][y - 1];
                    color += board[x][y - 1];
                    color += board[x + 1][y - 1];

                    color += board[x - 1][y];
                    color += board[x][y];
                    color += board[x + 1][y];

                    color += board[x - 1][y + 1];
                    color += board[x][y + 1];
                    color += board[x + 1][y + 1];

                    if (color > 0) {
                        color /= 9;
                    }
                    tmpboard[x][y] = color;
                }
            }
            board = tmpboard;
            //Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);
        }
    }
}

 /*       int[][] board = new int[250][250];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Random rand = new Random();
                int random = rand.nextInt(100) + 1;
                board[i][j] = random;
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                terminal.moveCursor(x, y);
                terminal.applyForegroundColor(board[x][y], board[x][y], board[x][y]);
                terminal.putCharacter('\u2588');
            }
        }
    }
}*/

        /*boolean [][] board = new boolean[8][8];

        //Put logic here to fill the board array with the chess pattern
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        board[i][j] = true;
                    } else {
                        board[i][j] = false;
                    }
                }
                else {
                    if (j % 2 == 1) {
                        board[i][j] = true;
                    }
                    else {
                        board[i][j] = false;
                    }
                }
            }
        }
        terminal.applyBackgroundColor(Terminal.Color.BLUE);
        terminal.applyForegroundColor(Terminal.Color.WHITE);
        for(int y=0; y < board.length; y++) {
            for(int x=0; x < board.length; x++) {
                boolean state = board[x][y];

                terminal.moveCursor(y,x);
                if (state == false)
                    terminal.putCharacter('O');
                else
                    terminal.putCharacter('X');
            }
        }*/
/*
        int[] input = new int[]{1, 4, 5, 7,20000, -511, 100, -200, 400};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int value : input) {
            if (value >= max) {
                max = value;
            }
            if (value <= min) {
                min = value;
            }
            sum = sum + value;
        }
        System.out.println("Max: " + max + "\nMin: " + min + "\nSum: " + sum);
    }
*/


//Put logic here to output the board to the screen

/*
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int input = sc.nextInt();

        String calc = "";
        int sum = 0;
        for (int i = 1; i <= input; i++) {
            sum += i;
            if (i < input) {
                calc += i + " + ";
            }
            if (i == input) {
                calc += i;
            }

        }
        System.out.println("Answer: " + sum);
        System.out.println(calc + " = " + sum);
*/

//        int[] input = new int[]{1, 4, 5, 7,20000, -511, 100, -201, 400};
//        int[] result;
//
//        int count = 0;
//        for (int item : input)
//            if (item % 2 == 0)
//                count++;
//
//        int index = 0;
//        result = new int[count];
//        for (int item : input)
//            if (item % 2 == 0) {
//                result[index] = item;
//                index++;
//            }
//
//        for (int item : result) {
//            System.out.println(item);
//        }
