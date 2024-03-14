// Basic class implementation of Tuple object
public class Tuple <T, U, V> 
{
	public T var0;
	public U var1;
	public V var2;
	
	public Tuple(T x, U y, V z) {
		var0 = x;
		var1 = y;
		var2 = z;
	}
	
	public T getVar0() {
		return var0;
	}
	
	public U getVar1() {
		return var1;
	}
	
	public V getVar2() {
		return var2;
	}
}
