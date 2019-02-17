import java.util.Scanner;

public class ThirdTask {
	public static void main(String[] args) {
		new ThirdTask().start();
	}

	public String findRanges(int[] array) {
		return find(array);
	}

	private void start() {
		int[] array = new int[keyboard("input array length")];
		for (int i = 0; i < array.length; i++) {
			array[i] = keyboard("input number: ");
		}
		System.out.println(find(array));
	}

	private String find(int[] array) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int diff = 1;
		for (int i = 0; i < array.length - 1; i++) {
			if (0 == start && diff != array[i + 1] - array[i]) {
				sb.append("[").append(array[i]).append("]");
			}
			if (1 == start && diff != array[i + 1] - array[i]) {
				sb.append(array[i]).append("]");
				start = 0;
			}
			if (0 == start && diff == array[i + 1] - array[i]) {
				sb.append("[").append(array[i]).append(" ");
				start = 1;
			}
			if (0 == start && i + 2 == array.length) {
				sb.append("[").append(array[i + 1]).append("]");
			}
			if (1 == start && i + 2 == array.length) {
				sb.append(array[i + 1]).append("]");
			}
		}
		return sb.toString();
	}

	private int keyboard(String ms) {
		System.out.println(ms);
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
}
