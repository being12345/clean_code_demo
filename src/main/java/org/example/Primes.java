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
        if (maxValue < 2) {
            return new int[0];
        } else {
            initisPrimes(maxValue);

            sievePrimes(maxValue);

            int[] result = new int[countPrimes(maxValue)];

            setPrimes(maxValue, result);
            
            return result;
        }
    }

    public static void initisPrimes(int maxValue) {
        isPrimes = new boolean[maxValue + 1];

        isPrimes[0] = isPrimes[1] = false;
        for (int i = 2; i < isPrimes.length; i++) {
            isPrimes[i] = true;
        }
    }

    public static void sievePrimes(int maxValue) {
        for (int i = 2; i < Math.sqrt(isPrimes.length) + 1; i++) {
            if (isPrimes[i]) {
                markMultiples(maxValue, i);
            }
        }
    }

    public static void markMultiples(int maxValue, int prime) {
        for (int j = 2 * prime; j < isPrimes.length; j += prime) {
            isPrimes[j] = false;
        }
    }

    public static int countPrimes(int maxValue) {
        int count = 0;
        for (int i = 0; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void setPrimes(int maxValue, int[] result) {
        for (int i = 0, j = 0; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                result[j++] = i;
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
