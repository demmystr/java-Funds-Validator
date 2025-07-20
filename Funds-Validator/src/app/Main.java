package app;

import java.util.Scanner;

public class Main {

    static double balance = 1000.00; // Initial balance

    public static void main(String[] args) {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        validateAmount(balance, getAmount());
    }

    private static double getAmount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
    }

    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
