package me.polishek;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public abstract class Day {
    protected Scanner Reader;
    protected String answer;

    public Day(){
        try {
            URL res = getClass().getClassLoader().getResource("day1/main.txt");
            File file = Paths.get(res.toURI()).toFile();
            String path = file.getAbsolutePath();
            System.out.println(path);

            Scanner Reader = new Scanner((file));
        }
        catch(URISyntaxException | FileNotFoundException ex){
            System.out.println("Error has occurred!");
            ex.printStackTrace();
        }
    }

    protected void printAnswer(){
        System.out.println(this.answer);
    }
}
