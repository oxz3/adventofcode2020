package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class day04a {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day04/input.txt";
        ArrayList<String> inputAL = new ArrayList<>();
        readToArrayList(filename, inputAL);

        ArrayList<Passport> passportAL = new ArrayList<>();
        parseInputToPassportAL(inputAL, passportAL);

        System.out.println(validCountPassportAL(passportAL));
    }

    public static int validCountPassportAL(ArrayList<Passport> passportAL) {
        int count = 0;
        for (Passport p : passportAL) {
            if (p.byr == null || p.iyr == null || p.eyr == null || p.hgt == null || p.hcl == null ||
                    p.ecl == null || p.pid == null) {
            } else {
                count++;
                System.out.println(p.toString());
            }
        }
        return count;
    }

    public static void parseInputToPassportAL(ArrayList<String> inputAL, ArrayList<Passport> passportAL) {
        Passport passport = new Passport();
        for (String s : inputAL) {
            if ("".equals(s)) {
                passportAL.add(passport);
                passport = new Passport();
            } else {
                String[] inputBlocks = parseLine(s);
                for (String t : inputBlocks) {
                    String[] splitBlock = t.split(":");

                    if ("byr".equals(splitBlock[0])) {
                        passport.byr = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("iyr".equals((splitBlock[0]))) {
                        passport.iyr = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("eyr".equals((splitBlock[0]))) {
                        passport.eyr = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("hgt".equals((splitBlock[0]))) {
                        passport.hgt = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("hcl".equals((splitBlock[0]))) {
                        passport.hcl = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("ecl".equals((splitBlock[0]))) {
                        passport.ecl = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("pid".equals((splitBlock[0]))) {
                        passport.pid = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    } else if ("cid".equals((splitBlock[0]))) {
                        passport.cid = new AbstractMap.SimpleEntry<>(splitBlock[0], splitBlock[1]);
                    }

                }

            }
        }


    }

    public static String[] parseLine(String input) {
        String[] parsedArr = input.split(" ");
        return parsedArr;
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

class Passport {
    AbstractMap.SimpleEntry<String, String> byr;
    AbstractMap.SimpleEntry<String, String> iyr;
    AbstractMap.SimpleEntry<String, String> eyr;
    AbstractMap.SimpleEntry<String, String> hgt;
    AbstractMap.SimpleEntry<String, String> hcl;
    AbstractMap.SimpleEntry<String, String> ecl;
    AbstractMap.SimpleEntry<String, String> pid;
    AbstractMap.SimpleEntry<String, String> cid;

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        output.append("Passport{");
        if (byr == null) { } else {
            output.append(byr.toString() + ", ");
        }
        if (iyr == null) { } else {
            output.append(iyr.toString() + ", ");
        }
        if (eyr == null) { } else {
            output.append(eyr.toString() + ", ");
        }
        if (hgt == null) { } else {
            output.append(hgt.toString() + ", ");
        }
        if (hcl == null) { } else {
            output.append(hcl.toString() + ", ");
        }
        if (ecl == null) { } else {
            output.append(ecl.toString() + ", ");
        }
        if (pid == null) { } else {
            output.append(pid.toString() + ", ");
        }
        if (cid == null) { } else {
            output.append(cid.toString() + ", ");
        }
        output.append("}");
        return output.toString();
    }
}