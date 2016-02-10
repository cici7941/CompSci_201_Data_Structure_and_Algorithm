import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import princeton.StdAudio;
import princeton.StdDraw;

public class NBody{
	
	public static final double G = 6.67E-11;

    /**
     * returns Euclidean distance between (x1, y1) and (x2, y2)
     *
     * @param x1
     *            x-coordinate of point 1
     * @param y1
     *            y-coordinate of point 1
     * @param x2
     *            x-coordinate of point 2
     * @param y2
     *            y-coordinate of point 2
     * @return Euclidean distance between (x1, y1) and (x2, y2)
     */
    public double distance(double x1, double y1, double x2, double y2) {
    	double dx = x1 - x2;
    	double dy = y1 - y2;
        return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
    }
    
    /**
     * return the magnitude of the gravitational force between two bodies of
     * mass m1 and m2 that are distance r apart
     *
     * @param m1
     *            mass of body 1 in kg
     * @param m2
     *            mass of body 2 in kg
     * @param r
     *            distance in m
     * @return force between m1 and m2 that are distance r apart
     */
    public double force(double m1, double m2, double r) {
        if(r == 0){
        	return 0;
        } else {
        	return(G*m1*m2/Math.pow(r, 2));
        }
    }

    /**
     * Returns the x positions and y positions of bodies
     * @param totalTime The total amount of universe time to run for
     * @param timeStep The value of delta t in the equations to calculate position
     * @param info The scanner with info about the initial conditions of the
     * bodies
     * @return an array whose first element is the x and y position of the first body, and so on
     * t = totalTime
     */
    public double[][] positions(Scanner info, int totalTime, int timeStep) {
    	int n = info.nextInt(); //the number of bodies
    	double R = info.nextDouble(); //the radius of the universe
       	StdDraw.setXscale(-R, R);
    	StdDraw.setYscale(-R, R);
    	
        double[][] output = new double[n][2]; //initialize an array to store positions of n bodies
        //read in the data
        double[] px = new double[n]; //x-coordinate of the body
        double[] py = new double[n]; //y-coordinate of the body
        double[] vx = new double[n]; //x-velocity of the body
        double[] vy = new double[n]; //y-velocity of the body
        double[] mass = new double[n]; //mass of the body
        String[] image = new String[n]; //name of the image file of the body
        
        for(int i = 0; i < n; i++){
        	px[i] = info.nextDouble();
        	py[i] = info.nextDouble();
        	vx[i] = info.nextDouble();
        	vy[i] = info.nextDouble();
        	mass[i] = info.nextDouble();
        	image[i] = info.next();
        }

        double[][] distance_xy = new double[n][n]; //distance array of n bodies
        double[][] fxy = new double[n][n]; //force between any two bodies
        double[] fx = new double[n]; //x-net force
        double[] fy = new double[n]; //y-net force
        //time
        for(int time = 0; time < totalTime; time += timeStep){
        	//update force
        	for(int i = 0; i < n; i++){
        		fx[i] = 0; //reset x-net force to zero
        		fy[i] = 0; //reset y-net force to zero
        		for(int j = 0; j < n; j++){
        			distance_xy[i][j] = distance(px[i], py[i], px[j], py[j]);
        			fxy[i][j] = force(mass[i], mass[j], distance_xy[i][j]);
        			if(i != j){
        				fx[i] += fxy[i][j]*(px[j]-px[i])/distance_xy[i][j]; 
        				fy[i] += fxy[i][j]*(py[j]-py[i])/distance_xy[i][j]; 
        			}
        		}
        	}
        	
        	//update acceleration and velocity
        	for(int i = 0; i < n; i++){
        		vx[i] += fx[i]/mass[i]*timeStep;
        		vy[i] += fy[i]/mass[i]*timeStep;
        	}
        	//update positions
        	for(int i = 0; i < n; i++){
        		px[i] += vx[i]*timeStep;
        		py[i] += vy[i]*timeStep;
        	}
        	//drawing
        	StdDraw.clear();
        	StdDraw.picture(0, 0, "data/starfield.jpg");
        	for(int i = 0; i < n; i++){
        		StdDraw.picture(px[i], py[i], "data/"+image[i]);
        	}
        	StdDraw.show(30);
        }
        for(int i = 0; i < n; i++){
        	output[i][0] = px[i];
        	output[i][1] = py[i];
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner info = openFile();
        int time = 10000000;
        int dt = 25000;
        
        if (info != null) {
            StdAudio.play("data/2001.mid");
            NBody myNBody = new NBody();
            double[][] results = myNBody.positions(info, time, dt);
            for(int i = 0; i < results.length; i++) {
                for(int j = 0; j < results[i].length; j++) {
                    System.out.print(results[i][j]+" ");
                }
                System.out.println();
            }
            StdAudio.close();
        }
    }
    /**
     * Displays file chooser for browsing in the project directory. and opens
     * the selected file
     *
     * @return a new Scanner that produces values scanned from the selected
     *         file. null if file could not be opened or was not selected
     */
    
    public static Scanner openFile() {
        Scanner scan = null;
        System.out.println("Opening file dialog.");
        JFileChooser openChooser = new JFileChooser(System.getProperties()
                                                    .getProperty("user.dir"));
        
        int retval = openChooser.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = openChooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            try {
                scan = new Scanner(file);
                System.out.println("Opening: " + file.getName() + ".");
            } catch (FileNotFoundException e) {
                System.out.println("Could not open selected file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File open canceled.");
            System.exit(0);
        }
        
        return scan;
    }
}