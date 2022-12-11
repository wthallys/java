package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the numbers of products: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Custom fee: ");
                double fee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, fee));
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = sc.nextLine();
                LocalDate date = LocalDate.parse(dateStr, fmt);
                list.add(new UsedProduct(name, price, date));
                }
            else {
                list.add(new Product(name, price));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : list) {
            System.out.println(prod.getName() + );
        }
    }
}
