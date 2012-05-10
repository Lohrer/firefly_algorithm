package fa;

import java.util.Random;

/**
 * @author Michael Lohrer
 * @version 0.1
 */
public class Firefly implements FAConstants {
	
	private double lightIntensity;
	private double[] position;
	
	/**
	 * @param numDimensions
	 */
	public Firefly(int numDimensions) {
		Random r = new Random();
		for (int i = 0; i < numDimensions; i++) {
			position[i] = (r.nextDouble()-0.5)*BOUND;
		}
	}
	
	public double[] getPosition() {
		return position;
	}
	
	public void setPosition(double[] newPosition) {
		position = newPosition;
	}
	
	public double getIntensity() {
		return lightIntensity;
	}
	
	public void setIntensity(double intensity) {
		lightIntensity = intensity;
	}
}
