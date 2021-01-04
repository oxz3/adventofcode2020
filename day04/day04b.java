package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class day04b {
    public static void main(String[] args) {
        final String filename = "/home/me/Projects/adventofcode2020/day04/input.txt";
        ArrayList<String> inputAL = new ArrayList<>();
        readToArrayList(filename, inputAL);

        ArrayList<Passport> passportAL = new ArrayList<>();
        parseInputToPassportAL(inputAL, passportAL);

        System.out.println(validCountPassportAL(passportAL));
    }

    public static boolean validatePID (Passport passport) {
        if (passport.pid != null) {
            if (passport.pid.getValue().length() == 9) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateECL (Passport passport) {
        if (passport.ecl != null) {
            switch (passport.ecl.getValue()) {
                case "amb":
                case "blu":
                case "brn":
                case "gry":
                case "grn":
                case "hzl":
                case "oth":
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean validateHCL (Passport passport) {
        if (passport.hcl != null) {
            Character c = '#';
            if (c.equals(passport.hcl.getValue().charAt(0))) {
                if (passport.hcl.getValue().length() == 7) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateHGT (Passport passport) {
        if (passport.hgt != null) {
            if (passport.hgt.getValue().contains("cm")) {
                if (passport.hgt.getValue().compareTo("150cm") >= 0 && passport.hgt.getValue().compareTo("193cm") <= 0) {
                    return true;
                }
            } else if (passport.hgt.getValue().contains("in")) {
                if (passport.hgt.getValue().compareTo("59in") >= 0 && passport.hgt.getValue().compareTo("76in") <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateEYR (Passport passport) {
        if (passport.eyr != null) {
            if (passport.eyr.getValue().compareTo("2020") >= 0 && passport.eyr.getValue().compareTo("2030") <= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateIYR (Passport passport) {
        if (passport.iyr != null) {
            if (passport.iyr.getValue().compareTo("2010") >= 0 && passport.iyr.getValue().compareTo("2020") <= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateBYR (Passport passport) {
        if (passport.byr != null) {
            if (passport.byr.getValue().compareTo("1920") >= 0 && passport.byr.getValue().compareTo("2002") <= 0) {
                return true;
            }
        }
        return false;
    }

    public static int validCountPassportAL(ArrayList<Passport> passportAL) {
        int count = 0;
        for (Passport p : passportAL) {
            if (p.byr == null || p.iyr == null || p.eyr == null || p.hgt == null || p.hcl == null ||
                    p.ecl == null || p.pid == null) {
            } else {
                if (validateBYR(p) && validateIYR(p) && validateEYR(p) && validateHGT(p) && validateHCL(p) &&
                        validateECL(p) && validatePID(p)) {
                    count++;
                    System.out.println(p.toString());
                }
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
