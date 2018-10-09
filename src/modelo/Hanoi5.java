package modelo;

import java.util.Scanner;

public class Hanoi5 {
	/*
	 * Hanoi tower program with ascii representation
	 * 
	 * /
	 **/

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int height = s.nextInt();

		Hanoii hanoi = new Hanoii(height);
		hanoi.printTowers();
		hanoi.solve(height, 0, 1, 2);
		s.close();
	}
}

class Hanoii {
	protected int[][] towers;
	private int height;

	public Hanoii(int height) {
		this.height = height;
		this.towers = new int[3][height];
		for (int i = 0; i < this.height; i++) {
			this.towers[0][i] = i + 1;
			this.towers[1][i] = 0;
			this.towers[2][i] = 0;
		}
	}

	public boolean move(int start, int dest) {
		boolean cor = start >= 0 && start < 3 && dest < 3 && dest >= 0;
		cor = cor && this.lastDisc(start) < this.lastDisc(dest);
		if (cor) {
			int sldiscpos = this.lastDiscPos(start) + 1;
			int dldiscpos = this.lastDiscPos(dest);
			this.towers[dest][dldiscpos] = this.lastDisc(start);
			this.towers[start][sldiscpos] = 0;
		}
		/**/
		return cor;
	}

	public int lastDisc(int col) {
		if (col > 2) {
			return -1;
		} else {
			for (int i = 0; i < this.height; i++) {
				if (this.towers[col][i] != 0) {
					return this.towers[col][i];
				}
			}
			return this.height + 1;
		}
	}

	public int lastDiscPos(int col) {
		if (col > 2) {
			return -1;
		} else {
			for (int i = 0; i < this.height; i++) {
				if (this.towers[col][i] != 0) {
					return i - 1;
				}
			}
			return this.height - 1;
		}
	}

	public int firstDisc(int col) {
		if (col < 3) {
			return this.towers[col][this.height - 1];
		} else {
			return -1;
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < 3; j++) {
				int n = this.towers[j][i];
				s += n == 0 ? " |" : " " + n;
			}
			s += "\n";
		}
		s += "_^_^_^_";
		return s;
	}

	public void printTowers() {
		System.out.println(this.toString());
	}

	public String toDrawDisc(int col, int cos) {
		String d = "";
		for (int i = 0; i < this.height; i++) {
			if (i < this.towers[col][cos]) {
				d += "_";
			} else {
				d += " ";
			}
		}
		return d + " ";
	}

	public String drawTowers() {
		String s = "";
		for (int cos = 0; cos < this.height; cos++) {
			for (int col = 0; col < 3; col++) {
				s = s + this.toDrawDisc(col, cos);
			}
			s = s + "\n";
		}
		System.out.println(s);
		return s;
	}

	public void solve(int ndisc, int start, int pivot, int dest) {
		if (ndisc == 1) {
			move(start, dest);
			printTowers();
		} else {
			solve(ndisc - 1, start, dest, pivot);
			printTowers();
			move(start, dest);
			printTowers();
			solve(ndisc - 1, pivot, start, dest);
		}
	}
}
