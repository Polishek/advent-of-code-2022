package me.polishek;

import java.util.*;

public class Day3 extends Day {

    private int sumOfPriorities = 0;

    private final List<Character> characterSet;
    public Day3(){
        openScanner("day3/main.txt");
        characterSet = new ArrayList<>();
    }

    @Override
    protected void makeTask() {
// ================ TASK 1 ================
//        while (Reader.hasNextLine()){
//            Set<Character> rucksackSet = new HashSet<>();
//            String line = Reader.nextLine();
//            int half = line.length()/2;
//            String firstCompartment = line.substring(0, half);
//            String secondCompartment = line.substring(half);
//
//            for(int i = 0; i < half; i++){
//                char firstCharacter = firstCompartment.charAt(i);
//
//                for(int j = 0; j < half; j++){
//                    char secondCharacter = secondCompartment.charAt(j);
//                    if(firstCharacter == secondCharacter) {
//                        rucksackSet.add(firstCharacter);
////                        System.out.println("Added: " + firstCharacter);
//                    }
//                }
//            }
//
//            characterSet.addAll(rucksackSet);
//
//        }

// ================ TASK 2 ================
        while (Reader.hasNextLine()){
            Set<Character> rucksackSet = new HashSet<>();
            String firstLine = Reader.nextLine();
            String secondLine = Reader.nextLine();
            String thirdLine = Reader.nextLine();

            for(int i = 0; i < firstLine.length(); i++){
                char firstCharacter = firstLine.charAt(i);

                for(int j = 0; j < secondLine.length(); j++){
                    char secondCharacter = secondLine.charAt(j);
                    if(firstCharacter == secondCharacter) {
                        for(int k = 0; k < thirdLine.length(); k++){
                            char thirdCharacter = thirdLine.charAt(k);
                            if (secondCharacter == thirdCharacter){
                                rucksackSet.add(firstCharacter);
//                              System.out.println("Added: " + firstCharacter);
                            }
                        }
                    }
                }
            }

            characterSet.addAll(rucksackSet);

        }

        answer = Integer.toString(sumOfPriorities(characterSet));
    }

    private int sumOfPriorities(List<Character> set){
        set.forEach(character -> {
            if(character >= 97){
                sumOfPriorities += character - 96;
                System.out.println(character - 96 + " (" + character + ")");
            }
            else {
                sumOfPriorities += character - 38;
                System.out.println(character - 38 + " (" + character + ")");
            }

//            sumOfPriorities += (character >= 97) ? character - 96 : character - 38;
            });

        return sumOfPriorities;
    }
}
