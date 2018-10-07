package modelo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Tower of Hanoi (also called the Tower of Brahma or Lucas's Tower and
 * sometimes pluralized) is a mathematical game or puzzle.<br>
 * It consists of three rods and a number of disks of different sizes, which can
 * slide onto any rod. <br>
 * The puzzle starts with the disks in a neat stack in ascending order of size
 * on one rod, the smallest at the top, thus making a conical shape.<br>
 * The objective of the puzzle is to move the entire stack to another rod,
 * obeying the following simple rules:<br>
 * 1.Only one disk can be moved at a time.<br>
 * 2.Each move consists of taking the upper disk from one of the stacks and
 * placing it on top of another stack<br>
 * 3.No disk may be placed on top of a smaller disk<br>
 * The minimal number of moves required to solve a Tower of Hanoi puzzle is 2^n
 * − 1, where n is the number of disks.
 */
public class Hanoi {

	public static void main(String[] args) {
		System.out.print("The number of discs: ");
		Scanner scanner = new Scanner(System.in);
		String discs = scanner.nextLine();
		scanner.close();
		System.out.println(discs + "\n========================================");
		RecursiveSolution solution = new RecursiveSolution(discs);
		solution.problemSolving();
	}

	/**
	 * Using recursive to solve the math
	 */
	public static class RecursiveSolution extends Solution {
		/**
		 * Constructor
		 */
		public RecursiveSolution(String discs) {
			super(discs);
		}

		@Override
		public void problemSolving() {
			displayAll();
			move(discs, sourceRod, targetRod, middleRod);
			System.out.println("Number of moves: " + moveCount);
			System.out.println("Minimal number of moves expected: " + minimalExpectedMoves());
		}

		/**
		 * @param n
		 *            n
		 * @param source
		 *            Move discs from this rod
		 * @param target
		 *            Move discs to this rod
		 * @param bridge
		 *            Bridge rod to move discs
		 */
		private void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> bridge) {
			if (n > 0) {
				// move n - 1 disks from source to bridge, so they are out of the way
				move(n - 1, source, bridge, target);
				// move the nth disk from source to target
				target.push(source.pop());
				// display and count
				displayAll();
				moveCount++;
				// move the n - 1 disks that we left on bridge onto target
				move(n - 1, bridge, target, source);
			}
		}
	}

	public static abstract class Solution {
		/**
		 * Define the value of first disc
		 */
		protected static final int FIRST_DISC = 1;

		/**
		 * Source Rod
		 */
		protected Stack<Integer> sourceRod;

		/**
		 * Middle Rod
		 */
		protected Stack<Integer> middleRod;

		/**
		 * Target Rod
		 */
		protected Stack<Integer> targetRod;

		/**
		 * Number of discs
		 */
		protected int discs;

		/**
		 * Number of move that required to solve the math
		 */
		protected int moveCount = 0;

		/**
		 * Constructor
		 * 
		 * @param discs
		 *            number of discs on source rod
		 */
		public Solution(String discs) {
			try {
				this.discs = Math.abs(Integer.parseInt(discs));
			} catch (Exception e) {
				this.discs = 0;
			}
			initRods();
		}

		/**
		 * Constructor
		 * 
		 * @param discs
		 *            number of discs on source rod
		 */
		public Solution(int discs) {
			this.discs = Math.abs(discs);
			initRods();
		}

		/**
		 * Initialize discs for rod
		 */
		protected void initRods() {
			this.sourceRod = new Stack<>();
			this.sourceRod.addAll(range(FIRST_DISC, this.discs));
			this.middleRod = new Stack<>();
			this.targetRod = new Stack<>();
		}

		/**
		 * Solve the math
		 */
		public void problemSolving() {
		}

		/**
		 * Display discs from all of the rods
		 */
		public void displayAll() {
			System.out.println(Arrays.toString(this.sourceRod.toArray()));
			System.out.println(Arrays.toString(this.middleRod.toArray()));
			System.out.println(Arrays.toString(this.targetRod.toArray()));
			System.out.println("________________________________________");
		}

		/**
		 * @return 2^n − 1
		 */
		protected int minimalExpectedMoves() {
			return (int) Math.pow(2, discs) - 1;
		}

		/**
		 * @param from
		 *            Start of sequence
		 * @param to
		 *            End of sequence
		 * @return A sequence increase by 1
		 */
		private Collection<Integer> range(int from, int to) {
			return IntStream.rangeClosed(from, to).map(i -> to - i + from).boxed().collect(Collectors.toList());
		}
	}
}