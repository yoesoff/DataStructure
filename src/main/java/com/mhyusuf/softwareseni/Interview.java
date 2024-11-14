package com.mhyusuf.softwareseni;

public class Interview {

    public static void main(String[] args) {
        SeniHitungSederhana seniHitungSederhana = new SeniHitungSederhanaSDUtama();
        int[] angka = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int a = 1;
        int b = 10;
        System.out.println("Sum ganjil: " + seniHitungSederhana.hitungSumGanjil(angka));
        System.out.println("Sum bilangan prima: " + seniHitungSederhana.hitungSumBilanganPrima(a, b));
    }
}
