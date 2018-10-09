package modelo;

import java.awt.Color;
import java.util.Stack;

import javax.swing.JFrame;

public class Main extends JFrame {

	private int xInicio;
	private int yInicio;
	private int xFin;
	private int yFin;
	private int xInicio2;
	private int yInicio2;
	private int xFin2;
	private int yFin2;
	private Color color;
	
	public Main() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		xInicio = 100;
		xFin = 800;
		yInicio = 200;
		yFin = 100;
		xInicio2 = 100;
		xFin2 = 800;
		yInicio2 = 200;
		yFin2 = 100;
		color = new Color(200, 100, 50);
		mover();
	}

	public void mover() {
		for (; xInicio2 <= xFin2; xInicio2++) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {

			}
			repaint();
		}
	}

	public static void main(String... arg) {
		// "Enter number of disks:
		int n = 5;// new Scanner(System.in).nextInt();
		Stack<Integer>[] TOH = new Stack[4];
		TOH[1] = new Stack<Integer>();
		TOH[2] = new Stack<Integer>();
		TOH[3] = new Stack<Integer>();
		pushDisk(n, n, TOH);
	}

	public static void pushDisk(int n, int num, Stack<Integer>[] TOH) {
		for (int i = n; i > 0; i--)
			TOH[1].push(i);
		display(n, TOH);
		moveDisk(n, num, 1, 2, 3, TOH);
		System.out.println("Solved!");
	}

	public static void moveDisk(int n, int num, int i, int j, int k, Stack<Integer>[] TOH) {

		if (num > 0) {

			moveDisk(n, num - 1, i, k, j, TOH);
			int m = TOH[i].pop();
			TOH[k].push(m);
			display(n, TOH);
			moveDisk(n, num - 1, j, i, k, TOH);
		}

	}

	public static void display(int n, Stack<Integer>[] TOH) {
		System.out.println(" T-1 | T-2 | T-3\n------------------");
		for (int i = n - 1; i >= 0; i--)
			System.out.printf("  %s  |  %s  |  %s%n%s", i < TOH[1].size() ? String.valueOf(TOH[1].get(i)) : " ",
					i < TOH[2].size() ? String.valueOf(TOH[2].get(i)) : " ",
					i < TOH[3].size() ? String.valueOf(TOH[3].get(i)) : " ", i == 0 ? "\n\n" : "");
	}
}