package me.polishek;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public class Day2 extends Day {

    private enum Score{
        A(1),
        B(2),
        C(3),
        X(1),
        Y(2),
        Z(3);

        public final int value;

        Score(int value) {
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public static Score valueOfLabel(int label) {
            for (Score e : values()) {
                if (e.value == label) {
                    return e;
                }
            }
            return null;
        }
    }

    private File file;

    public Day2(){
        openScanner("day2/main.txt");
    }

    @Override
    protected void makeTask(){

        int myTotalScore = 0;

//======================= TASK 1 =======================
//        int opponent = 0, me = 0;
//        int lines = 0, wins = 0, losts = 0, draws = 0;
//
//        while(Reader.hasNextLine()){
//            String[] line = Reader.nextLine().split(" ");
//            lines++;
//            switch(line[0]){
//                case "A" -> opponent = 1;   // Rock
//                case "B" -> opponent = 2;   // Paper
//                case "C" -> opponent = 3;   // Scissors
//            }
//
//            switch(line[1]){
//                case "X" -> me = 1; // Rock
//                case "Y" -> me = 2; // Paper
//                case "Z" -> me = 3; // Scissors
//            }
//
//            if((line[0].equals("A") && line[1].equals("Y")) || (line[0].equals("B") && line[1].equals("Z")) || (line[0].equals("C") && line[1].equals("X"))) { // I win
//                myTotalScore += 6 + me;
//                wins++;
//            } else if (opponent == me) { // It's a draw
//                myTotalScore += 3 + me;
//                draws++;
//            }
//            else { // I lose
//                myTotalScore += me;
//                losts++;
//            }
//        }
//
//        System.out.println("Lines: " + lines +"\n" +
//                "Wins: " + wins + "\n" +
//                "Draws: " + draws + "\n" +
//                "Losts:" + losts +"\n" +
//                "Total games: " + (wins + losts + draws) );

//======================= TASK 2 =======================

        int figure = 0, result = 0;

        while(Reader.hasNextLine()){
            String[] line = Reader.nextLine().split(" ");

            switch(line[0]){
                case "A" -> figure = 1;   // Rock
                case "B" -> figure = 2;   // Paper
                case "C" -> figure = 3;   // Scissors
            }

            switch(line[1]){
                case "X" -> result = 1; // lose
                case "Y" -> result = 2; // draw
                case "Z" -> result = 3; // win
            }

            if(result == 2) { // It's a draw
                myTotalScore += 3 + figure;
            } else if (result == 3) { // It's a win
                if(figure == 3) // Opponent gave Scissors
                    myTotalScore += 6 + 1;
                else if (figure == 2) // Opponent gave Paper
                    myTotalScore += 6 + 3;
                else  // Opponent gave Rock
                    myTotalScore += 6 + 2;
            }
            else { // I lose
                if(figure == 3) // Opponent gave Scissors
                    myTotalScore += 2;
                else if (figure == 2) // Opponent gave Paper
                    myTotalScore +=  1;
                else  // Opponent gave Rock
                    myTotalScore += 3;
            }
        }

        Reader.close();

        answer = Integer.toString(myTotalScore);
    }
}