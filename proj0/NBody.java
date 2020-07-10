public class NBody {
	public static double readRadius(String file) {
		In in = new In(file);
		int num = in.readInt();
		return in.readDouble();
	}
	public static Body[] readBodies(String file) {
		In in = new In(file);
		int num = in.readInt();
		double rad = in.readDouble();
		Body[] arr = new Body[num];
		for (int k = 0; k < num; k += 1) {
			double xp, yp, xv, yv, m;
			String img;
			xp = in.readDouble();
			yp = in.readDouble();
			xv = in.readDouble();
			yv = in.readDouble();
			m = in.readDouble();
			img = in.readString();
			arr[k] = new Body(xp, yp, xv, yv, m, img);
		}
		return arr;
	}
}
