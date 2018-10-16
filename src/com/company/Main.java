package com.company;

import java.util.Scanner;

public class Main {
    public static String readRange0to9(int num){
        String[] read = {"","one","two","three","four","five","six","seven","eight","nine"};
        return read[num];
    }
    public static String readRange10to19(int num){
        int index = (num%10);
        String[] read = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        return read[index];
    }
    public static String readRange20to99(int num){
        int indexTens = (num/10)-2;
        int indexOnes = num%10;
        String[] readTens = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        return readTens[indexTens] + " " + readRange0to9(indexOnes);
    }
    public static String readRange100to999(int num){
        int indexHundred = num/100;
        int number1to99 = num%100;
        boolean onlyHundred = number1to99 == 0;
        boolean range1to9 = number1to99<10&&number1to99>0;
        boolean range10to19 = number1to99<20&&number1to99>=10;
        if(onlyHundred) return readRange0to9(indexHundred)+" hundred";
        if(range1to9) return readRange0to9(indexHundred)+" hundred and "+readRange0to9(number1to99);
        if(range10to19) return readRange0to9(indexHundred)+" hundred and "+readRange10to19(number1to99);
        return readRange0to9(indexHundred)+" hundred and "+readRange20to99(number1to99);
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to read (1-999)");
        int num = scanner.nextInt();
        // here damn
        String result = null;
        // here damn
        boolean range0to9 = num<10 && num>=0;
        boolean range10to19 = num>9 && num<20;
        boolean range20to99 = num>=20 && num<100;
        boolean range100to999 = num>=100 &&num<1000;
        if(range0to9)result=readRange0to9(num);
        if(range10to19)result=readRange10to19(num);
        if(range20to99)result=readRange20to99(num);
        if(range100to999)result=readRange100to999(num);
        System.out.println(result);
    }
}
