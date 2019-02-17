import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        new FirstTask().start();
    }

    public int[] rotateElements(int size, int[] array) {
        return rotate(size, array);
    }

    private void start() {

        int elementsToMove = keyboard("input k-elements to move");
        int[] array = new int[keyboard("input array length")];
        for (int i = 0; i < array.length; i++) {
            array[i] = keyboard("input number: ");
        }
        print(rotate(elementsToMove, array));
    }

    private int[] rotate(int elementsToMove, int[] array) {
        int t = elementsToMove;
        int[] editedArray = new int[array.length];
        for (int i = 0; i < editedArray.length; i++) {
            if (elementsToMove > i) {
                editedArray[editedArray.length - t] = array[i];
                t--;
            } else {
                editedArray[i - elementsToMove] = array[i];
            }
        }
        return editedArray;
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private int keyboard(String ms) {
        System.out.println(ms);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
