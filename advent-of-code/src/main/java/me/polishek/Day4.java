package me.polishek;

import java.util.ArrayList;
import java.util.List;

public class Day4 extends Day{

    List<String> listOfSectionPairs;

    int assignmentPair = 0;
    public Day4(){
        openScanner("day4/main.txt");
        listOfSectionPairs = new ArrayList<>(0);
    }
    @Override
    protected void makeTask() {

//================== PART 1 ==================
//        while(Reader.hasNextLine()){
//            String line = Reader.nextLine();
//            int firstSectionLeft = Integer.parseInt(line.substring(0, line.indexOf('-')));
//            line = line.substring(line.indexOf('-') + 1);
//            int firstSectionRight = Integer.parseInt(line.substring(0, line.indexOf(',')));
//            line = line.substring(line.indexOf(',') + 1);
//            int secondSectionLeft = Integer.parseInt(line.substring(0, line.indexOf('-')));
//            line = line.substring(line.indexOf('-') + 1);
//            int secondSectionRight = Integer.parseInt(line);
//
//            if((firstSectionLeft <= secondSectionLeft && firstSectionRight >= secondSectionRight) ||
//                    (firstSectionLeft >= secondSectionLeft && firstSectionRight <= secondSectionRight)){
//                listOfSectionPairs.add(line);
//                assignmentPair++;
//            }
//        }
//
//        System.out.println(listOfSectionPairs.size());
//        answer = Integer.toString(assignmentPair);

//================== PART 2 ==================
        while(Reader.hasNextLine()){
            String line = Reader.nextLine();
            int firstSectionLeft = Integer.parseInt(line.substring(0, line.indexOf('-')));
            line = line.substring(line.indexOf('-') + 1);
            int firstSectionRight = Integer.parseInt(line.substring(0, line.indexOf(',')));
            line = line.substring(line.indexOf(',') + 1);
            int secondSectionLeft = Integer.parseInt(line.substring(0, line.indexOf('-')));
            line = line.substring(line.indexOf('-') + 1);
            int secondSectionRight = Integer.parseInt(line);

            if((firstSectionLeft < secondSectionLeft && firstSectionRight < secondSectionRight && firstSectionRight < secondSectionLeft) ||
                    (firstSectionLeft > secondSectionLeft && firstSectionRight > secondSectionRight && secondSectionRight < firstSectionLeft)) {
                continue;
            }
            else{
                listOfSectionPairs.add(line);
                assignmentPair++;
            }
        }

        System.out.println(listOfSectionPairs.size());
        answer = Integer.toString(assignmentPair);
    }
}
