/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.validatecheckdigits;

/**
 *
 * @author uwais
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ValidateCheckDigits {

    public static void main(String[] args) throws Exception {

        File inputFile = new File("accounts.txt");
        Scanner fileReader = new Scanner(inputFile);

        PrintWriter fileWriter = new PrintWriter("valid_accounts.txt");

        while (fileReader.hasNextLine()) {

            String accountNumber = fileReader.nextLine().trim();

            if (accountNumber.isEmpty()) {
                continue;
            }

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                char c = accountNumber.charAt(i);
                int digit = c - '0';  
                sum = sum + digit;
            }

            int remainder = sum % 10;

            // Get the sixth digit
            char lastChar = accountNumber.charAt(5);
            int lastDigit = lastChar - '0';

            if (remainder == lastDigit) {
                System.out.println(accountNumber + " -> VALID");
                fileWriter.println(accountNumber);   
            } else {
                System.out.println(accountNumber + " -> INVALID");
            }
        }

        fileReader.close();
        fileWriter.close();

        System.out.println("\nDone! Valid accounts saved to valid_accounts.txt");
    }
}
