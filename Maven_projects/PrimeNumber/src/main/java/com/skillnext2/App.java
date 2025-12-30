package com.skillnext2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean isPrime = true;

        // Prime number logic
        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // Output
        if (isPrime) {
            System.out.println(num + " is a PRIME number");
        } else {
            System.out.println(num + " is NOT a prime number");
        }

        sc.close();
    }
}
