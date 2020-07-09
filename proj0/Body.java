public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    public static final double g = 6.67e-11;
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
	xxPos = xP;
	yyPos = yP;
	xxVel = xV;
	yyVel = yV;
	mass = m;
	imgFileName = img;
    }
    public Body(Body b) {
	xxPos = b.xxPos;
	yyPos = b.yyPos;
	xxVel = b.xxVel;
	yyVel = b.yyVel;
	mass = b.mass;
	imgFileName = b.imgFileName;
    }
    public double calcDistance(Body other) {
	return Math.sqrt((xxPos - other.xxPos) * (xxPos - other.xxPos) + (yyPos - other.yyPos) * (yyPos - other.yyPos));
    }
    public double calcForceExertedBy(Body other) {
	double r = calcDistance(other);
	return (g * mass * other.mass / r / r);
    }
    public double calcForceExertedByX(Body other) {
	return calcForceExertedBy(other) * (other.xxPos - xxPos) / calcDistance(other);
    }
    public double calcForceExertedByY(Body other) {
        return calcForceExertedBy(other) * (other.yyPos - yyPos) / calcDistance(other);
    }
}
