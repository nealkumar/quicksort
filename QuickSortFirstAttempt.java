import java.util.Random;

public class QuickSortFirstAttempt {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 6, 4, 3, 3, 2, 1 };
		System.out.println("Initial Array: ");
		printArray(arr);
		quickSort(arr, 0, arr.length-1);
		System.out.println("Final Array: ");
		printArray(arr);
	}
	
	private static void quickSort(int[] arr, int leftPointer, int rightPointer) {
		//there's more than one item to sort
		if(leftPointer <= rightPointer) {
			int pivot = partition(arr, leftPointer, rightPointer);
			quickSort(arr, leftPointer, pivot-1);
			quickSort(arr, pivot+1, rightPointer);
		}
	}
	
	private static int partition(int[] arr, int leftPointer, int rightPointer) {
		swap(arr, leftPointer, getPivot(leftPointer, rightPointer));
		int border = leftPointer+1;
		for(int index=border; index<=rightPointer; index++) {
			if(arr[index] < arr[leftPointer]) {
				swap(arr, index, border++);
			}
		}
		swap(arr, leftPointer, border-1);
		return border-1;
	}
	
	private static int getPivot(int leftPointer, int rightPointer) {
		Random randy = new Random();
		return randy.nextInt((rightPointer-leftPointer)+1) + leftPointer;
	}
	
	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	

	// Helper method to print out the integer array.
	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
