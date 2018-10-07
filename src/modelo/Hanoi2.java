package modelo;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi2 {

	public static Stack<Integer>[] rodCollection = new Stack[3];
	public static Stack<Integer> rod1 = new Stack<Integer>();
	public static Stack<Integer> rod2 = new Stack<Integer>();
	public static Stack<Integer> rod3 = new Stack<Integer>();

	public static void main(String[] args) {
		System.out.println("Enter the amount of disk: ");
		int input = new Scanner(System.in).nextInt();
		setup(rod1, input);
		rodCollection[0] = rod1;
		rodCollection[1] = rod2;
		rodCollection[2] = rod3;
		solve(input, 0, 1, 2);
	}

	public static void solve(int number, int start, int middle, int end) {
		if (number > 0) {
			solve(number - 1, start, end, middle);
			int trans = rodCollection[start].pop();
			rodCollection[end].push(trans);
			display();
			solve(number - 1, middle, start, end);
		}
	}

	public static void setup(Stack<Integer> rod1, int number) {
		for (int i = number; i >= 1; i--) {
			rod1.push(i);
		}
		display();
	}

	public static void display() {
		System.out.println();
		System.out.print("rod1: ");
		for (int i = 0; i < rod1.size(); i++) {
			System.out.print(rod1.get(i) + " ");
		}
		System.out.println();
		System.out.print("rod2: ");
		for (int i = 0; i < rod2.size(); i++) {
			System.out.print(rod2.get(i) + " ");
		}
		System.out.println();
		System.out.print("rod3: ");
		for (int i = 0; i < rod3.size(); i++) {
			System.out.print(rod3.get(i) + " ");
		}
		System.out.println();
	}

}
