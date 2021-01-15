package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day05b {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day05/input.txt";
        ArrayList<String> inputAL = new ArrayList<>();
        readToArrayList(filename, inputAL);

        ArrayList<String> rowAL = new ArrayList<>();
        ArrayList<String> colAL = new ArrayList<>();
        parseIntoRowCol(inputAL, rowAL, colAL);

        int maxSeatID = 0;
        int minSeatID = 1032;
        minSeatID = findMinSeatID(rowAL, colAL);
        maxSeatID = findMaxSeatID(rowAL, colAL);
        System.out.println(minSeatID);
        System.out.println(maxSeatID);

        Boolean[] seatArr = new Boolean[maxSeatID + 1];
        System.out.println(findMissingSeat(seatArr, rowAL, colAL));

    }

    public static int findMissingSeat(Boolean[] seatArr, ArrayList<String> rowAL, ArrayList<String> colAL) {
        for (int i = 0; i < rowAL.size(); i++) {
            seatArr[calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i))] = true;
        }
        int seatID = 0;
        for (int i = findMinSeatID(rowAL, colAL); i < seatArr.length; i++) {
            if (seatArr[i] == null) {
                seatID = i;
            }
        }
        return seatID;
    }

    public static int findMaxSeatID(ArrayList<String> rowAL, ArrayList<String> colAL) {
        int maxSeatID = 0;
        for (int i = 0; i < rowAL.size(); i++) {
            if (maxSeatID < calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i))) {
                maxSeatID = calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i));
            }
        }
        return maxSeatID;
    }

    public static int findMinSeatID(ArrayList<String> rowAL, ArrayList<String> colAL) {
        int minSeatID = 1032;
        for (int i = 0; i < rowAL.size(); i++) {
            if (minSeatID > calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i))) {
                minSeatID = calculateSeatRow(rowAL.get(i)) * 8 + calculateSeatCol(colAL.get(i));
            }
        }
        return minSeatID;
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
