import java.util.*;

public class GradingSorter extends NaturalMergeSorter {
   	private ArrayList<CallInfo> tracking = new ArrayList<CallInfo>();

   	public final ArrayList<CallInfo> getCallInfo(String methodName) {
		ArrayList<CallInfo> result = new ArrayList<CallInfo>();
		for (CallInfo info : tracking) {
			if (info.name.equals(methodName)) {
				result.add(info);
			}
		}
		return new ArrayList<CallInfo>(result);
   	}

   	@Override
   	public int getSortedRunLength(int[] array, int arrayLength, int startIndex) {
		// Store tracking information first
	   	ArrayList<Integer> constructorArgs = new ArrayList<Integer>();
	   	constructorArgs.add(arrayLength);
	   	constructorArgs.add(startIndex);
	   	CallInfo callInfo = new CallInfo("getSortedRunLength", array, constructorArgs);
	   	tracking.add(callInfo);

		// Then route call to parent class's implementation
		return super.getSortedRunLength(array, arrayLength, startIndex);
   	}

   	@Override
   	public void merge(int[] array, int leftFirst, int leftLast, int rightLast) {
	   	// Store tracking information first
		ArrayList<Integer> args = new ArrayList<Integer>(Arrays.asList(leftFirst, leftLast, rightLast));
		CallInfo callInfo = new CallInfo("merge", array, args);
		tracking.add(callInfo);

		// Then route call to parent class's implementation
		super.merge(array, leftFirst, leftLast, rightLast);
   	}

	// Implementation of regular merge sort so that the merge() call patterns
   	// can be obtained, if needed.
   	public final void mergeSort(int[] numbers, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int mid = (startIndex + endIndex) / 2;

			mergeSort(numbers, startIndex, mid);
			mergeSort(numbers, mid + 1, endIndex);

			merge(numbers, startIndex, mid, endIndex);
		}
   	}

   	@Override
   	public void naturalMergeSort(int[] array, int arrayLength) {
		// Store tracking information first
		ArrayList<Integer> constructorArgs = new ArrayList<Integer>();
		constructorArgs.add(arrayLength);
		CallInfo callInfo = new CallInfo("naturalMergeSort", array, constructorArgs);
		tracking.add(callInfo);

		// Then route call to parent class's implementation
		super.naturalMergeSort(array, arrayLength);
   	}

   	public final void naturalMergeSort_Solution(int[] array, int arrayLength) {
		// Store tracking information first
		ArrayList<Integer> constructorArgs = new ArrayList<Integer>();
		constructorArgs.add(arrayLength);
		CallInfo callInfo = new CallInfo("mergeSortVariant_Solution", array, constructorArgs);
		tracking.add(callInfo);

		// Actual solution follows
		int i1 = 0;
		int run1Length = getSortedRunLength(array, arrayLength, i1);
		while (run1Length < arrayLength) {
			// Compute the second run's starting index
			int i2 = i1 + run1Length;

			// If i2 equals the array's length, then the run starting at i1 goes
         	// up to, and includes, the array's last item.
			if (i2 == arrayLength) {
				i1 = 0;
			}
			else {
				// Determine run 2's length
				int run2Length = getSortedRunLength(array, arrayLength, i2);

				// Merge the two runs
				merge(array, i1, i2 - 1, i2 + run2Length - 1);

				// Move run1's starting index for the next pass
				i1 = i2 + run2Length;

				// Reset i1 to 0 if array's end is reached
				if (i1 == arrayLength) {
					i1 = 0;
				}
			}

			// Compute first run's length for next pass
			run1Length = getSortedRunLength(array, arrayLength, i1);
		}
   	}

   	public final void resetCallInfo() {
	  	tracking.clear();
   	}
}