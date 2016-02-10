
public class Freefall {
      public double fallingDistance(double time, double velo){
      double distance; // d = v*t + 0.5v*t^2
      double g = 9.8;
      distance = velo * time + 0.5 * g * Math.pow(time, 2);
      return distance;
      }
  }