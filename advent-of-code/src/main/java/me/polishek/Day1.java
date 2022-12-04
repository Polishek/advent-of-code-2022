package me.polishek;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class Day1 {

    private String answer;
    private File file;

    private List<Integer> caloriesList;
    public Day1() {

//        file = new File("resources/test.txt");

        try {
            URL res = getClass().getClassLoader().getResource("day1/main.txt");
            file = Paths.get(res.toURI()).toFile();
            String path = file.getAbsolutePath();
            System.out.println(path);

            Scanner Reader = new Scanner((file));

            caloriesList = new ArrayList<>();
            caloriesList.add(0);
            int listIndex = 0;
            int newValue = 0;
            boolean isFileBeginning = true;

            while(Reader.hasNextLine()){
                String data = Reader.nextLine();
                if(data.equals("") && !isFileBeginning){
                    listIndex++;
                    caloriesList.add(0);
                } else if (data.equals("") && isFileBeginning) {
                    continue;
                } else {
                    if(listIndex == 0 && isFileBeginning){
                        isFileBeginning = false;
                    }

                    newValue = caloriesList.get(listIndex) + Integer.parseInt(data);
                    caloriesList.remove(listIndex);
                    caloriesList.add(newValue);
                }
            }
            Reader.close();
        }
        catch(URISyntaxException | FileNotFoundException ex){
            System.out.println("Error has occurred!");
            ex.printStackTrace();
        }

        Collections.sort(caloriesList, Collections.reverseOrder());

        System.out.println("Day1: [" + caloriesList.get(0) + "] [" + (caloriesList.get(0) + caloriesList.get(1) + caloriesList.get(2)) + "]\n");
    }
}
