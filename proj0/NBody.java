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
			img = "images/" + in.readString();
			arr[k] = new Body(xp, yp, xv, yv, m, img);
		}
		return arr;
	}
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double rad = readRadius(filename);
		Body[] arr = readBodies(filename);
		//StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-rad, rad);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (int k = 0; k < arr.length; k += 1) {
			arr[k].draw();
		}
		StdDraw.show();
                //StdDraw.pause(2000);
	}
}
