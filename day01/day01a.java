package day01;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day01a {
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

        long product = 0;
        for (int i = 0; i < inputAL.size(); i++) {
            for (int j = i + 1; j < inputAL.size() - 1; j++) {
                if (inputAL.get(i) + inputAL.get(j) == 2020) {
                    product = inputAL.get(i) * inputAL.get(j);
                    System.out.println(inputAL.get(i) + " * " + inputAL.get(j));
                }
            }
        }

        System.out.println(product);
    }
}