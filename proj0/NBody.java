public class NBody {
    public static void main(String[] args) {
	double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
	String imageToDraw = "./images/starfield.jpg";

	StdAudio.loop("./audio/2001.mid");
	
	StdDraw.setScale(-radius, radius);
	StdDraw.picture(0, 0, imageToDraw);
	for (int i = 0; i < planets.length; i++){
	    planets[i].draw();
	}

	for (double t = 0; t <= T; t = t + dt){
	    double[] xForce = new double[planets.length];
	    double[] yForce = new double[planets.length];
	    for (int i = 0; i < planets.length; i++){
	        xForce[i] = planets[i].calcNetForceExertedByX(planets);
		yForce[i] = planets[i].calcNetForceExertedByY(planets);
	    }
	    StdDraw.picture(0, 0, imageToDraw);
	    for (int i = 0; i < planets.length; i++){
		planets[i].update(dt, xForce[i], yForce[i]);
		planets[i].draw();
	    }
	    StdDraw.show(100);
	}
	
	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < planets.length; i++) {
	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);		}
    }

  
    
    
    public static double readRadius(String data) {
	double radius = 0;
	In in = new In(data);	
	if(!in.isEmpty()){
	    int number = in.readInt();
	    radius = in.readDouble();
	}
	return radius;
    }

    public static Planet[] readPlanets(String data){
	Planet[] result = new Planet[5];
	for (int i = 0 ; i < 5 ; result[i++] = new Planet(0,0,0,0,0,""));
	int i = 0;
	In in = new In(data);
       	if(!in.isEmpty()){
	    int number = in.readInt();
	    double radius = in.readDouble();
	    while (i < 5){
		result[i].xxPos = in.readDouble();	
		result[i].yyPos = in.readDouble();
		result[i].xxVel = in.readDouble();
		result[i].yyVel = in.readDouble();
		result[i].mass = in.readDouble();
		result[i].imgFileName = in.readString();
		i++;
	    }
	}
	return result;
    }
    
}

		

