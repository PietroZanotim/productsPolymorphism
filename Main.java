package Main;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> listProducts = new ArrayList<>();

        int numProducts;
        System.out.print("Enter the number of products: ");
        numProducts = sc.nextInt();

        for(int i=0; i<numProducts; i++){

            Character model;
            String name;
            Double price;


            System.out.printf("Product #%d data:\n", (i+1));
            System.out.print("Common, used or imported (c/u/i): ");
            model = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Price: ");
            price = sc.nextDouble();


            if(model=='c'){

                Product tempProduct = new Product(name, price);
                listProducts.add(tempProduct);

            } else if(model=='u'){

                sc.nextLine();
                String tempDateString;
                LocalDate tempDate;
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                tempDateString = sc.nextLine();
                tempDate = LocalDate.parse(tempDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                Product tempProduct = new UsedProduct(name, price, tempDate);
                listProducts.add(tempProduct);

            } else if(model=='i'){

                Double customsFee;
                System.out.print("Customs fee: ");
                customsFee = sc.nextDouble();

                Product tempProduct = new ImportedProduct(name, price, customsFee);
                listProducts.add(tempProduct);

            }
        }

        System.out.println("\n\nPRICE TAGS:");
        for(Product product : listProducts){
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}