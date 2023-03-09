
public class FMain2 {

	public static void main(String[] args) {
		System.out.println(getHab(4));
		System.out.println(getMul(17));
		System.out.println(getFibo(3));
	}

	public static int getHab(int i) {
		return (i == 1) ? 1 : getHab(i - 1) + i;
		/*
		 * getHab(1) = 1 
		 * getHab(2) = 1 + 2 = getHab(1) + 2 = 3 
		 * getHab(3) = 1 + 2 + 3 = getHab(2) + 3
		 */
	}

	public static long getMul(long i) {
		return (i == 1) ? 1 : getMul(i - 1) * i;
	}

	/*
	 * public static int getFibo(int a) {
	 * return (a >=3) ? getFibo(a - 1) + getFibo(a - 2) : 1; }
	 */

	public static int getFibo(int as) {
		return (as < 3) ? 1 : (getFibo(as - 2) + getFibo(as - 1));
	}
}
