import java.util.*;
import java.io.PrintWriter;

public class LabUtility {
	// Determines if two arrays of equal size have the same set of elements, and
   	// the same frequency of each element.
	public static boolean doArraysHaveSameElements(int[] array1, int[] array2, 
		int size, Tuple<Integer,Integer,Integer> mismatchOutput) {
		// Build each array's frequency table
		var arr1Map = LabUtility.makeFrequencyTable(array1, size);
		var arr2Map = LabUtility.makeFrequencyTable(array2, size);
		
		// Check if each key/value pair from the first map exists in the second
		if(!arr1Map.equals(arr2Map)) {
			return false;
		}
	
		return true;
	}
	
	public static boolean isArraySorted(int[] arr, int arrSize, PrintWriter optionalFeedback) {
		for (int i = 1; i < arrSize; i++) {
			if (arr[i] < arr[i - 1]) {
				// If non-null, use the PrintWriter to provide feedback
				if (optionalFeedback != null) {
					PrintWriter feedback = optionalFeedback;
					feedback.write("FAIL: Array is not properly sorted. Ex: Element ");
					feedback.write(arr[i] + " at index " + i);
					feedback.write(" comes after element " + arr[i - 1]);
					feedback.write(" at index " + (i - 1) + "." + "\n");
				}
				return false;
			}
		}
		return true;
	}

	public static HashMap<Integer, Integer> makeFrequencyTable(int[] array, int arrayLength) {
		HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
		for (int i = 0; i < arrayLength; i++) {
			int element = array[i];
	
			if (result.get(element) == null) {
				result.put(element, 1);
			}
			else {
				// Not first occurrence of element
				int elementFrequency = result.get(element);
				result.put(element, elementFrequency + 1);
			}
		}

		return result;
	}
	
	// Performs random swaps to shuffle an array. The number of swaps performed
   	// equals the array's length.
	public static <T> void shuffle(T[] array, int arrayLength) {
		Random rnd = new Random();

		// Perform arrayLength random swaps
		for (int i = 0; i < arrayLength; i++) {
			// Generate two random indices
			int index1 = (int)(rnd.nextInt(999999) % arrayLength);
			int index2 = (int)(rnd.nextInt(999999) % arrayLength);

			// Swap
			T temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}
	
	// Performs random swaps to shuffle an array. The number of swaps performed
   	// equals the array's length.
	public static <T> void shuffle(ArrayList<T> arrayToShuffle) {
		int length = (int)arrayToShuffle.size();

		// Perform arrayLength random swaps
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			// Generate two random indices
			int index1 = (int)(rnd.nextInt(999999) % length);
			int index2 = (int)(rnd.nextInt(999999) % length);

			// Swap
			T temp = arrayToShuffle.get(index1);
			arrayToShuffle.set(index1, arrayToShuffle.get(index2));
			arrayToShuffle.set(index2, temp);
		}
	}
}