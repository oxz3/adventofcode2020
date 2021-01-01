package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day01b {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day01/input.txt";
        ArrayList<Integer> inputAL = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                inputAL.add(input.nextInt());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found error.");
            e.printStackTrace();
        }

        // Is this possible to do without 3 nested loops?
        long product = 0;
        for (int i = 0; i < inputAL.size(); i++) {
            for (int j = i + 1; j < inputAL.size() - 1; j++) {
                for (int k = j + 1; k < inputAL.size() - 2; k ++) {
                    if (inputAL.get(i) + inputAL.get(j) + inputAL.get(k) == 2020) {
                        product = inputAL.get(i) * inputAL.get(j) * inputAL.get(k);
                        System.out.println(inputAL.get(i) + " * " + inputAL.get(j) + " * " + inputAL.get(k));
                    }
                }
            }
        }

        System.out.println(product);
    }
}