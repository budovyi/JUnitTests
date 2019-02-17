import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
    	new SecondTask().start();
    }

    public int[] restoreArray(int[] array){
    	return restore(array);
	}

    private void start() {
		int [] array = new int[keyboard("input array length")];
    	for (int i = 0; i < array.length; i++) {	
    	    array[i] = keyboard("input number: ");
    		}
    	print(restore(array));
	}

	private int[] restore(int[] incArray) {
		int[] array = Arrays.copyOf(incArray, incArray.length);
		for (int i = 0; i < array.length; i++) {  
	        if (0 < i && 0 > array[i - 1]) { 
	        	array[i - 1] = array[i] - (array[i] - array[i - 2]) / 2;
	        }
		}
		return array;
	}

	private int keyboard(String ms) {
		System.out.println(ms);
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}	
	
    private void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
	        System.out.print (array[i]+ " ");
		}
	}  
}
