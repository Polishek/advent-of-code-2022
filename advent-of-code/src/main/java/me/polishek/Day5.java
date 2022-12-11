package me.polishek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Day5 extends Day {

    private final String filename = "day5/main.txt";
    List<List<String>> containersList;

    public Day5(){
        openScanner(filename);
        containersList = new ArrayList<>();
        containersList.add(new ArrayList<String>());
    }
    @Override
    protected void makeTask() {
        loadShipContainers();
        Reader.nextLine();

        while(Reader.hasNextLine()){
            String line = Reader.nextLine();
            String[] commandLine = line.split(" ");
            int amount = Integer.parseInt(commandLine[1]);
            int from = Integer.parseInt(commandLine[3]) - 1;
            int to = Integer.parseInt(commandLine[5]) - 1;

// ================= TASK 1 =================
//            for(int i = 0; i < amount; i++){
//                String tempContainer = containersList.get(from).get(containersList.get(from).size() - 1);
//                containersList.get(from).remove(containersList.get(from).size() - 1);
//                containersList.get(to).add(tempContainer);
//            }

// ================= TASK 2 =================
            for(int i = amount; i > 0; i--){
                String tempContainer = containersList.get(from).get(containersList.get(from).size() - i);
                containersList.get(from).remove(containersList.get(from).size() - i);
                containersList.get(to).add(tempContainer);
            }

        }

        for (int i = 0; i < containersList.size(); i++){
            System.out.println(containersList.get(i).get(containersList.get(i).size() - 1));
        }

        answer = Arrays.toString(containersList.toArray());
    }

    private void loadShipContainers(){

        boolean containerLoaded = false;

        while(Reader.hasNextLine() && !containerLoaded){
            String line = Reader.nextLine();    //line getter
            int columnNumber = 0;

            while(!line.isBlank()){
                String tempString = line.substring(0, 3).trim();    //first three characters
                if(tempString.equals("1")){ //if line describes each ship row - stop function
                    containerLoaded = true;
                    break;
                } else if (containersList.size() > columnNumber) {
                    containersList.get(columnNumber).add(tempString);
                }
                else{
                    containersList.add(new ArrayList<String>());
                    containersList.get(columnNumber).add(tempString);
                }

                columnNumber++;
                if(line.length() > 3) {
                    line = line.substring(4);
                }
                else{
                    line = "";
                }
            }
        }

        containersList.forEach( column -> {
            Collections.reverse(column);
            column.removeAll(Arrays.asList("", null));
        });
    }

    private void moveGroup(int howMany, int source, int destination){

    }
}
