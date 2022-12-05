package me.polishek;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class Day3 extends Day {

    private int sumOfPriorities = 0;
    public Day3(){ openScanner("day3/test.txt"); }
    @Override
    protected void makeTask() {
        Set<Character> characterSet = new HashSet<>();

        while (Reader.hasNextLine()){
            String line = Reader.nextLine();
            int half = line.length()/2;
            String firstCompartment = line.substring(0, half);
            String secondCompartment = line.substring(half);

            for(int i = 0; i < half; i++){
                char firstCharacter = firstCompartment.charAt(i);

                for(int j = 0; j < half; j++){
                    char secondCharacter = secondCompartment.charAt(j);
                    if(firstCharacter == secondCharacter) {
                        characterSet.add(firstCharacter);
//                        System.out.println("Added: " + firstCharacter);
                    }
                }
            }
        }

        answer = Integer.toString(sumOfPriorities(characterSet));
    }

    private int sumOfPriorities(Set<Character> set){
        set.forEach(character -> {
            if(character >= 97){
                sumOfPriorities += character - 96;
            }
            else {
                sumOfPriorities += character - 38;
            }
//            sumOfPriorities += (character >= 97) ? character - 96 : character - 38;
            });

        return sumOfPriorities;
    }
}
