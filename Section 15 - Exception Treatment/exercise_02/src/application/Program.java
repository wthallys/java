package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


            System.out.println("Enter account data");
            System.out.print("Number: ");
            int accNumber = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            System.out.print("Inicial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(accNumber, holder, balance, withdrawLimit);
            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
            System.out.print("New balance: " + account.getBalance());
        }
        catch (BusinessException exception) {
            System.out.println("Withdraw error: " + exception.getMessage());
        }


    }
}
