package com.mhyusuf;

public class ReverseWordOrderInString {
    public static void main(String[] args) {

        System.out.println("Reverse Word Order In String!");
        String str = "Lorem Ipsum Dolor Sit Amet";

        String[] strArray = str.split(" ");
        String newStr = "";

        for (int i = strArray.length - 1; i >= 0; i--) {
            System.out.println(strArray[i]);
            newStr += strArray[i] + " ";
        }

        System.out.println(str);
        System.out.println(newStr);

    }
}