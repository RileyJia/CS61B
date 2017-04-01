public class Planet {
    double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;
    
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
	this.xxPos = xP;
	this.yyPos = yP;
	this.xxVel = xV;
	this.yyVel = yV;
	this.mass = m;
	this.imgFileName = img;
    }
    
    public Planet(Planet p){
	this.xxPos = p.xxPos;
	this.yyPos = p.yyPos;
	this.xxVel = p.xxVel;
	this.yyVel = p.yyVel;
	this.mass = p.mass;
	this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
	double dx = this.xxPos - p.xxPos;
	double dy = this.yyPos - p.yyPos;
	double R = Math.sqrt(dx * dx + dy * dy);
	return R;
    }

    public double calcForceExertedBy(Planet p){
	double G = 6.67E-11;
	double sqrR = Math.pow(this.calcDistance(p), 2);
	double force = this.mass * p.mass * G / sqrR;
	return force;
    }

    public double calcForceExertedByX (Planet p){
	double dx = p.xxPos - this.xxPos;
	double forceX = this.calcForceExertedBy(p) * dx / (this.calcDistance(p));
	return forceX;
    }
    
    public double calcForceExertedByY (Planet p){
	double dy = p.yyPos - this.yyPos;
	double forceY = this.calcForceExertedBy(p) * dy / (this.calcDistance(p));
	return forceY;
    }
    
    public double calcNetForceExertedByX (Planet[] p){
	double netForceX = 0;
	for (int i = 0; i < p.length; i++){
	    if (!this.equals(p[i])){
		netForceX += this.calcForceExertedByX(p[i]);
	    }
	}
	return netForceX;
    }

    public double calcNetForceExertedByY (Planet[] p){
	double netForceY = 0;
	for (int i = 0; i < p.length; i++){
	    if (!this.equals(p[i])){
		netForceY += this.calcForceExertedByY(p[i]);
	    }
	}
	return netForceY;
    }
	
    public void update(double t, double fX, double fY){
	double aX = fX / this.mass;
	double aY = fY / this.mass;
	this.xxVel += aX * t;
	this.yyVel += aY * t;
	this.xxPos += this.xxVel * t;
	this.yyPos += this.yyVel * t;	
    }

    public void draw(){
	StdDraw.picture(this.xxPos, this.yyPos,"./images/"+ this.imgFileName);
    }
}
