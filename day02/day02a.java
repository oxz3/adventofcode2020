package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day02a {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day02/input.txt";
        ArrayList<String> inputAL = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                inputAL.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found error.");
            e.printStackTrace();
        }

        ArrayList<String> ruleAL = new ArrayList<>();
        ArrayList<String> passwordAL = new ArrayList<>();
        splitAL (inputAL, ":", ruleAL, passwordAL);

        ArrayList<String> letterAL = new ArrayList<>();
        ArrayList<String> occurrenceAL = new ArrayList<>();
        splitAL(ruleAL, " ", occurrenceAL, letterAL);

        ArrayList<Integer> minAL = new ArrayList<>();
        ArrayList<Integer> maxAL = new ArrayList<>();
        splitIntAL(occurrenceAL, "-", minAL, maxAL);

        int total = 0;
        for (int i = 0; i < passwordAL.size(); i++) {
            int count = countOfChar(passwordAL.get(i), letterAL.get(i));
            if (count >= minAL.get(i) && count <= maxAL.get(i)) {
                total++;
            }
        }

        System.out.println(total);
    }

    static int countOfChar (String string, String val) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (val.equals(String.valueOf(string.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    static void splitAL (ArrayList<String> sourceAL, String splitter, ArrayList<String> leftAL, ArrayList<String> rightAL) {

        for (String s : sourceAL) {
            String[] line = new String[2];
            line = s.split(splitter);
            leftAL.add(line[0]);
            rightAL.add(line[1].trim());
        }
    }

    static void splitIntAL (ArrayList<String> sourceAL, String splitter, ArrayList<Integer> leftIntAL, ArrayList<Integer> rightIntAL) {
        for (String s : sourceAL) {
            String[] line = new String[2];
            line = s.split(splitter);
            leftIntAL.add(Integer.parseInt(line[0]));
            rightIntAL.add(Integer.parseInt(line[1]));
        }
    }
}