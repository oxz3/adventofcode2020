package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day03b {
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


        // Largest forest 7 right, 1 down
        final int largestRight = 7;
        final int down = 1;

        ArrayList<String> forestAL = new ArrayList<>();
        populateForest(inputAL, forestAL, largestRight / down);


        System.out.println(traverseForest(forestAL, 1 / down));
        System.out.println(traverseForest(forestAL, 3 / down));
        System.out.println(traverseForest(forestAL, 5 / down));
        System.out.println(traverseForest(forestAL, 7 / down));
        System.out.println(traverseForestHalfSlope(forestAL));

        System.out.println(traverseForest(forestAL, 1 / down)
                * (traverseForest(forestAL, 3 / down))
                * (traverseForest(forestAL, 5 / down))
                * (traverseForest(forestAL, 7 / down))
                * (traverseForestHalfSlope(forestAL)));
    }

    public static int traverseForestHalfSlope(ArrayList<String> forestAL) {
        int count = 0;
        Character tree = '#';
        for (int row = 0; row < forestAL.size(); row += 2) {
            if (tree.equals(forestAL.get(row).charAt(row / 2))) {
                count++;
            }
        }
        return count;
    }

    public static int traverseForest(ArrayList<String> forestAL, int mult) {
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