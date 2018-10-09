package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Hanoi6 {

	static List<Stack<Integer>> stacks = new ArrayList<>();

	public static void main(String[] args) {

		List<String> lista = new ArrayList<>();
		lista.add("fda");

		System.out.println(lista.indexOf("fdaa"));
		;

		int n = Integer.parseInt(JOptionPane.showInputDialog("cant..."));

		Stack<Integer> o = new Stack<Integer>();
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> d = new Stack<Integer>();

		stacks.add(o);
		for (int i = n; i > 0; i--) {
			o.push(i);
		}
		stacks.add(a);
		stacks.add(d);

		visualizar();
		hanoi(n, stacks.get(0), stacks.get(1), stacks.get(2));

	}

	static <T> void hanoi(int n, Stack<T> o, Stack<T> a, Stack<T> d) {
		if (n > 0) {
			hanoi(n - 1, o, d, a);
			d.push(o.pop());
			visualizar();
			System.out.println("movimiento ejecutado desde la torre " + (stacks.indexOf(o) + 1) + " a la torre "
					+ (stacks.indexOf(d) + 1));
			hanoi(n - 1, a, o, d);
		}

	}

	static void visualizar() {
		System.out.println();
		System.out.print("torre de origen: ");
		for (int i = 0; i < stacks.get(0).size(); i++) {
			System.out.print(stacks.get(0).get(i) + " ");
		}
		System.out.println();
		System.out.print("torre auxiliar: ");
		for (int i = 0; i < stacks.get(1).size(); i++) {
			System.out.print(stacks.get(1).get(i) + " ");
		}
		System.out.println();
		System.out.print("torre de destino: ");
		for (int i = 0; i < stacks.get(2).size(); i++) {
			System.out.print(stacks.get(2).get(i) + " ");
		}
		System.out.println();
	}

}
