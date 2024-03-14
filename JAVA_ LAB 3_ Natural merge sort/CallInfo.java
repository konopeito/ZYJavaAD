import java.util.*;

// CallInfo stores the arguments provided in a call to one of the three
// methods of GradingSorter. Each has a reference to an integer array and a
// ArrayList of integers for the arguments that follow.
public class CallInfo {
	public String name = "";
	public int[] array;
	public ArrayList<Integer> args = new ArrayList<Integer>();
	
	public CallInfo(String methodName, int[] array, ArrayList<Integer> methodParams) {
		name = methodName;
		this.array = array;
		args = new ArrayList<Integer>(methodParams);
	}
	
	public CallInfo(final CallInfo toCopy) {
		name = toCopy.name;
		array = toCopy.array;
		args = new ArrayList<Integer>(toCopy.args);
	}
}