package modelo;

import java.util.Scanner;

public class Hanoi3 {

	private static int step = 1;
	private static final String OUTPUT = "%2d: disc #%d %s -> %s%n";

	public static void main(String[] args) {
		hanoi(input("Number of disks? "), 'A', 'B', 'C');
	}

	private static void hanoi(int amount, char base, char reserve, char target) {
		if (amount == 1) {
			System.out.printf(OUTPUT, step++, 1, base, target);
		} else {
			hanoi(amount - 1, base, target, reserve);
			System.out.printf(OUTPUT, step++, amount, base, target);
			hanoi(amount - 1, reserve, base, target);
		}
	}

	private static int input(String message) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(message);
			String msg = sc.nextLine();
			try {
				return Integer.parseInt(msg);
			} catch (NumberFormatException ex) {
				System.err.println(ex.toString());
			}
		}
	}
}
