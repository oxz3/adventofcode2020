package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day05a {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day05/input.txt";
        ArrayList<String> inputAL = new ArrayList<>();
        readToArrayList(filename, inputAL);

        ArrayList<String> rowAL = new ArrayList<>();
        ArrayList<String> colAL = new ArrayList<>();
        parseIntoRowCol(inputAL, rowAL, colAL);

        int maxSeatID = 0;
        for (int i = 0; i < rowAL.size(); i++) {
            if (maxSeatID < calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i))) {
                maxSeatID = calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i));
            }
        }
        System.out.println(maxSeatID);

        System.out.println(inputAL.size());
        System.out.println(rowAL.size());


    }

    public static int calculateSeatCol(String parseCol) {
        StringBuffer binarySeat = new StringBuffer();
        for (int i = 0; i < parseCol.length(); i++) {
            Character c = 'L';
            if (c.equals(parseCol.charAt(i))) {
                binarySeat.append("0");
            } else {
                binarySeat.append("1");
            }
        }
        return Integer.parseInt(binarySeat.toString(), 2);
    }

    public static int calculateSeatRow(String parseRow) {
        StringBuffer binarySeat = new StringBuffer();
        for (int i = 0; i < parseRow.length(); i++) {
            Character c = 'F';
            if (c.equals(parseRow.charAt(i))) {
                binarySeat.append("0");
            } else {
                binarySeat.append("1");
            }
        }
        return Integer.parseInt(binarySeat.toString(), 2);
    }

    public static void parseIntoRowCol(ArrayList<String> inputAL, ArrayList<String> rowAL, ArrayList<String> colAL) {
        for (String s : inputAL) {
            rowAL.add(s.substring(0, 7));
            colAL.add(s.substring(7, 10));
        }
    }

    public static void readToArrayList(String filename, ArrayList<String> inputAL) {
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
    }
}
