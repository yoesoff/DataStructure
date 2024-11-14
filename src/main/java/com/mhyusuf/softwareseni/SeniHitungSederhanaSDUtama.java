package com.mhyusuf.softwareseni;

public class SeniHitungSederhanaSDUtama implements SeniHitungSederhana {
    public int hitungSumGanjil(int[] angka) {
        int sum = 0;
        for (int i = 0; i < angka.length; i++) {
            if (angka[i] % 2 != 0) {
                sum += angka[i];
            }
        }
        return sum;
    }

    public int hitungSumBilanganPrima(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (i == 1) {
                continue;
            }
            boolean isPrima = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrima = false;
                    break;
                }
            }
            if (isPrima) {
                sum += i;
            }
        }
        return sum;
    }

}
