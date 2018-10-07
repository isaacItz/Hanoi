package modelo;

public class Hanoi4 {

	public static void main(String[] args) {
		hanoi(6);
	}

	static void hanoi(int n) {
		hanoi(n, 1, 3, 2);
	}

	static void hanoi(int n, int from, int to, int work) {
		if (n == 0)
			return;

		hanoi(n - 1, from, work, to);
		move(from, to);
		hanoi(n - 1, work, to, from);
	}

	static void move(int from, int to) {
		System.out.println(from + "->" + to);
	}
}
