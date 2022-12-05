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

    protected void openScanner(String filePath){
        try {
            URL res = getClass().getClassLoader().getResource(filePath);
            File file = Paths.get(res.toURI()).toFile();
            String path = file.getAbsolutePath();
            System.out.println(path);

            Reader = new Scanner((file));
        }
        catch(URISyntaxException | FileNotFoundException ex){
            System.out.println("Error has occurred!");
            ex.printStackTrace();
        }
    }

    protected void printAnswer(){
        makeTask();
        Reader.close();
        System.out.println(getClass().getName() + ": " + answer);
    }

    protected abstract void makeTask();
}
