package pass;

import java.util.ArrayList;
import java.util.Random;

public class Password {

    //    static ArrayList<String> finalString;
    private static Random random = new Random();

//  * * *       Pass filter buckets     * * *

    private static ArrayList<Character> mainBucket = new ArrayList<>();
    private static ArrayList<Integer> bigLetter = new ArrayList<>();
    private static ArrayList<Integer> smallLetter = new ArrayList<>();
    private static ArrayList<Integer> digit = new ArrayList<>();
    private static ArrayList<Integer> specialCharacter = new ArrayList<>();
    private static ArrayList[] listOfChars = new ArrayList[]{bigLetter, smallLetter, digit, specialCharacter};
/*
    private static ArrayList<Integer>[] listOfChars = new ArrayList[]{bigLetter, smallLetter, digit, specialCharacter};
*/      //  Password:18 - old version

//  * * *       Charset areas          * * *

    private static int[][][] charts = new int[][][]{
            {{64, 90 - 64}},            //  *   A   -   Z
            {{97, 122 - 97}},           //  *   a   -   z
            {{48, 57 - 48}},            //  *   0   -   9
            {{33, 47 - 33},             //  *   !   -   /
                    {56, 64 - 56},      //  *   :   -   @
                    {91, 96 - 91},      //  *   [   -   '
                    {123, 126 - 122}    //  *   {   -   ~
                /*  {128, 146
                    {151, 154
                    {157
                    {159, 169
                    {171, 173
                    {181, 184
                    {189, 190
                    {198, 199
                    {208, 216
                    {251, 253
                */                 //  *   other areas
            }
    };

//  * * *       Pass safety conditions      * * *

    private static int passwordLength = 16;
    private static int bigLetterAmount = 1;
    private static int smallLetterAmount = 2;
    private static int digitAmount = 2;
    private static int specialCharacterAmount = 2;
    private static int obligatoryDraw = bigLetterAmount + smallLetterAmount + digitAmount + specialCharacterAmount;
    private static int[] conditions = new int[]{bigLetterAmount, smallLetterAmount, digitAmount, specialCharacterAmount};

    public static int getPasswordLength() {
        return passwordLength;
    }
/*

    public static void setPasswordLength(int passwordLength) {
        Password.passwordLength = passwordLength;
    }

    public static int getBigLetterAmount() {
        return bigLetterAmount;
    }

    public static void setBigLetterAmount(int bigLetterAmount) {
        Password.bigLetterAmount = bigLetterAmount;
    }

    public static int getSmallLetterAmount() {
        return smallLetterAmount;
    }

    public static void setSmallLetterAmount(int smallLetterAmount) {
        Password.smallLetterAmount = smallLetterAmount;
    }

    public static int getDigitAmount() {
        return digitAmount;
    }

    public static void setDigitAmount(int digitAmount) {
        Password.digitAmount = digitAmount;
    }

    public static int getSpecialCharacterAmount() {
        return specialCharacterAmount;
    }

    public static void setSpecialCharacterAmount(int specialCharacterAmount) {
        Password.specialCharacterAmount = specialCharacterAmount;
    }
*/      // ?    unused methods

//  * * *       Pass algorithm methods  * * *

    static void drawMachine() {

//        int i;        //index znaku w haśle
        int type = 0;   //index typu znaku
        int part;   // index zakresu w typie

        for (int i = 0; i < passwordLength; i++) {
            //  * * *       char general counter      * * *

            if (i < obligatoryDraw) {
                //  * * *   obligatory char counter     * * *

                if (type < conditions.length) {
                    //  * * *   max char amount condition   * * *

                    if (conditions[type] <= listOfChars[type].size()) {
                        type++;
                        i--;
                    }
                    //  * * *   char type switch   * * *

                    else {
                        part = random.nextInt(charts[type].length);
                        //  * * *   first draw   * * *

                        listOfChars[type].add(random.nextInt(charts[type][part][1]) + charts[type][part][0]);
                        //  * * *   second draw   * * *

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

/*    public static void main(String[] args) {
        String cache = generatePass();
        System.out.println(cache);

    }*/
}

//}


