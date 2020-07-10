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
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-rad, rad);
		StdDraw.clear();
		for (int time = 0; time < T; time += dt) {
			double[] xForces = new double[arr.length];
			double[] yForces = new double[arr.length];
			for (int k = 0; k < arr.length; k += 1) {
				xForces[k] = arr[k].calcNetForceExertedByX(arr);
				yForces[k] = arr[k].calcNetForceExertedByY(arr);
			}
			for (int k = 0; k < arr.length; k += 1) {
        	                arr[k].update(dt, xForces[k], yForces[k]);
               		 }
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int k = 0; k < arr.length; k += 1) {
				arr[k].draw();
			}
			StdDraw.show();
        	        StdDraw.pause(10);
		}
		StdOut.printf("%d\n", arr.length);
		StdOut.printf("%.2e\n", rad);
		for (int i = 0; i < arr.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
               				arr[i].xxPos, arr[i].yyPos, arr[i].xxVel,
                  			arr[i].yyVel, arr[i].mass, arr[i].imgFileName);   
		}
	}
}
