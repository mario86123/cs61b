public class NBody {
	public static double readRadius(String file) {
		In in = new In(file);
		int num = in.readInt();
		return in.readDouble();
	}
}
