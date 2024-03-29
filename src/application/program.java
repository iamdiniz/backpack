// encapsulation, inheritance and polymorphism !
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)?");
			char cr = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (cr == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			else if (cr == 'u') {
				System.out.print("Manufacture date (DD/MM/YY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));

			}
			
			else {
				list.add(new Product(name, price));
			}
			
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product pdct : list) {
			System.out.println(pdct.priceTag());

		}

		sc.close();

	}
}