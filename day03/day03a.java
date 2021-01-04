package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class day03a {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day03/input.txt";
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


        // 3 right, 1 down
        final int right = 3;
        final int down = 1;

        ArrayList<String> forestAL = new ArrayList<>();
        populateForest(inputAL, forestAL, right / down);

        System.out.println(traverseForest(forestAL, right, right / down));

    }

    public static int traverseForest(ArrayList<String> forestAL, int right, int mult) {
        int count = 0;
        Character tree = '#';
        for (int row = 0; row < forestAL.size(); row++) {
            if (tree.equals(forestAL.get(row).charAt(row * mult))) {
                count++;
            }
        }
        return count;
    }

    public static void populateForest(ArrayList<String> inputAL, ArrayList<String> forestAL, int mult) {
        int factor = inputAL.size() / inputAL.get(0).length() + 1;
        for (int i = 0; i < inputAL.size(); i++) {
            StringBuffer rowSB = new StringBuffer();
            for (int j = 0; j < mult * factor; j++) {
                rowSB.append(inputAL.get(i));
            }
            forestAL.add(i, rowSB.toString());
        }
    }

}