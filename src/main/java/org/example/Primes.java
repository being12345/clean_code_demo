package org.example;

import java.util.Arrays;

/**
 * @className: Primes
 * @description: generate primes(practice for chapter4)
 * @Author: zhuofengli
 * @Date: 2023/5/22 13:50
 */
public class Primes {
    private static boolean[] isPrimes;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue >= 2) {
            int s = maxValue + 1;

            initisPrimes(maxValue);

            sievePrimes(maxValue);

            int count = 0;
            for (int i = 0; i < s; i++) {
                if (isPrimes[i]) {
                    count++;
                }
            }
            int[] primes = new int[count];

            for (int i = 0, j = 0; i < s; i++) {
                if (isPrimes[i]) {
                    primes[j++] = i;
                }
            }
            return primes;
        } else {
            return new int[0];
        }
    }

    public static void initisPrimes(int maxValue) {
        isPrimes = new boolean[maxValue + 1];

        isPrimes[0] = isPrimes[1] = false;
        for (int i = 2; i < maxValue + 1; i++) {
            isPrimes[i] = true;
        }
    }

    public static void sievePrimes(int maxValue) {
        for (int i = 2; i < Math.sqrt(maxValue + 1) + 1; i++) {
            if (isPrimes[i]) {
                for (int j = 2 * i; j < maxValue + 1; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        String expected = "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]";
        String actual = Arrays.toString(generatePrimes(50));
        if (expected.equals(actual)) {
            System.out.println(true);
        }

    }
}
