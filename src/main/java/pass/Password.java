package pass;

import java.util.ArrayList;
import java.util.Random;

public class Password {

    //    static ArrayList<String> finalString;
    static Random random = new Random();

//    ============================================================
//    Password filter buckets

    static ArrayList<Character> mainBucket = new ArrayList<>();
    static ArrayList<Integer> bigLetter = new ArrayList<>();
    static ArrayList<Integer> smallLetter = new ArrayList<>();
    static ArrayList<Integer> digit = new ArrayList<>();
    static ArrayList<Integer> specialCharacter = new ArrayList<>();
    static ArrayList<Integer>[] listOfChars = new ArrayList[]{bigLetter, smallLetter, digit, specialCharacter};

//    ============================================================
//      Character type charset areas

    static int[][][] charts = new int[][][]{{{64, 90 - 64}}, {{97, 122 - 97}}, {{48, 57 - 48}}, {{33, 47 - 33}, {56, 64 - 56}, {91, 96 - 91}, {123, 126 - 122}}};

//    ============================================================
//    password safety conditions

    static int passwordLength = 16;
    static int bigLetterAmmount = 1;
    static int smallLetterAmmount = 2;
    static int digitAmmount = 2;
    static int specialCharacterAmmount = 2;
    static int obligatoryDraw = bigLetterAmmount + smallLetterAmmount + digitAmmount + specialCharacterAmmount;
    //    int additionalDraw = passwordLength - obligatoryDraw;
    static int[] conditions = new int[]{bigLetterAmmount, smallLetterAmmount, digitAmmount, specialCharacterAmmount};

    public static int getPasswordLength() {
        return passwordLength;
    }

    public static void setPasswordLength(int passwordLength) {
        Password.passwordLength = passwordLength;
    }

    public static int getBigLetterAmmount() {
        return bigLetterAmmount;
    }

    public static void setBigLetterAmmount(int bigLetterAmmount) {
        Password.bigLetterAmmount = bigLetterAmmount;
    }

    public static int getSmallLetterAmmount() {
        return smallLetterAmmount;
    }

    public static void setSmallLetterAmmount(int smallLetterAmmount) {
        Password.smallLetterAmmount = smallLetterAmmount;
    }

    public static int getDigitAmmount() {
        return digitAmmount;
    }

    public static void setDigitAmmount(int digitAmmount) {
        Password.digitAmmount = digitAmmount;
    }

    public static int getSpecialCharacterAmmount() {
        return specialCharacterAmmount;
    }

    public static void setSpecialCharacterAmmount(int specialCharacterAmmount) {
        Password.specialCharacterAmmount = specialCharacterAmmount;
    }

    //    ============================================================
//        cyryl i metody

    static void drawMachine() {

//        int i;        //index znaku w haśle
        int type = 0;   //index typu znaku
        int part;   // index zakresu w typie

        for (int i = 0; i < passwordLength; i++) {
//            licznik znaków hasła

            if (i < obligatoryDraw) {
//                licznik obowiązkowych znaków hasła

                if (type < conditions.length) {
//                    sprawdzenie, czy typ nie przekracza wartości max

                    if (conditions[type] <= listOfChars[type].size()) {
                        type++;
                        i--;
                    }
//                    sprawdzenie, czy ilość znaków typu nie przekracza wartości, przeskok do następnego typu

                    else {
                        part = random.nextInt(charts[type].length);
//                        losowanie zakresu znaków wybranego typu

                        listOfChars[type].add(random.nextInt(charts[type][part][1]) + charts[type][part][0]);
//                        losowanie i zapis numeru znaku ustalonego typu
                    }
                }
            } else {
                type = random.nextInt(listOfChars.length);
                part = random.nextInt(charts[type].length);
                listOfChars[type].add(random.nextInt(charts[type][part][1]) + charts[type][part][0]);
            }
        }
    }

    static void translateMachine() {
        for (ArrayList<Integer> listOfChar : listOfChars) {
            for (int number : listOfChar) {
                char symbol = (char) number;
                mainBucket.add(symbol);
            }
            listOfChar.clear();
        }
    }

    static String recombineMachine() {
        StringBuilder temporalString = new StringBuilder();
        mainBucket.add(0, '\n');
        for (; 0 < mainBucket.size() - 1; ) {
            int index = random.nextInt(mainBucket.size() - 1) + 1;

            temporalString.append(mainBucket.get(index));
            mainBucket.remove(index);
        }
        return temporalString.toString();
    }

    public static String generatePass() {
        drawMachine();
        translateMachine();
        return recombineMachine();
    }

    public static void main(String[] args) {
        String cache = generatePass();
        System.out.println(cache);

    }
}

//}


/*
 *   ======================================
 *      A-Z :   o64-o90
 *      a-z :   o97-122
 *      0-9 :   o48-o57
 *      !-/ :   o33-o47
 *      :-@ :   o58-o64
 *      [-' :   o91-o96
 *      {-~ :   123-126
 *      spec:   128-148
 *      spec:   151-154
 *      spec:   157
 *   spec:   159-169
 *   spec:   171-173
 *   spec:   181-184
 *   spec:   189-190
 *   spec:   198,199
 *   spec:   208-216
 *   spec:   224-238
 *   spec:   251-253
 *
 *   ======================================
 */  // notes
