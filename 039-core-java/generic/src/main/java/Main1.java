/**
 * @author keqi
 */
public class Main1 {
	
	public static void main(String[] args) {
		Main1 obj = new Main1();
		System.out.println(obj.test1(1, 2));
	}
	
	public <T extends Comparable<T>> int test1(T t1, T t2) {
		return t1.compareTo(t2);
	}
	
	public static <T extends Number> void addAll() {
	
	}
}
