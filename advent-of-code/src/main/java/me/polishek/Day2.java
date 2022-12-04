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

    public void makeTask(){

        int opponent = 0, me = 0, myTotalScore = 0;

        while(Reader.hasNextLine()){
            String[] line = Reader.nextLine().split(" ");

            switch(line[0]){
                case "A" -> opponent = 1;
                case "B" -> opponent = 2;
                case "C" -> opponent = 3;
            }

            switch(line[1]){
                case "X" -> me = 1;
                case "Y" -> me = 2;
                case "Z" -> me = 3;
            }

            if(opponent < me){
                myTotalScore += 6 + me;
            } else if (opponent == me) {
                myTotalScore += 3 + me;
            }
            else {
                myTotalScore += me;
            }
        }
        Reader.close();
        System.out.println("My points: " + myTotalScore);
        answer = Integer.toString(myTotalScore);
    }
}
