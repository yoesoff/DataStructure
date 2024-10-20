package com.mhyusuf;

public class ReverseString {
    public static void main(String[] args) {

        System.out.println("Reverse String!");
//        String str = "Lorem Ipsum Dolor Sit Amet";
        String str = "Kasur Nababan rusak";

        char[] strArray = str.toCharArray();

        String newStr = "";

        for (int i=0; i < strArray.length ; i++) {
            System.out.println(strArray[i]);
            newStr += strArray[strArray.length - i - 1];
        }
        System.out.println(str);
        System.out.println(newStr);

        System.out.println("Is palyndrome: " + (str.replaceAll("\\s+","").equalsIgnoreCase(newStr.replaceAll("\\s+",""))));

    }
}