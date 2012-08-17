package fa;

import java.util.Random;

/**
 * @author Michael Lohrer
 * 
 */
public class Firefly implements FAConstants
{

	private double lightIntensity;
	private double[] position;

	/**
	 * @param numDimensions
	 * 
	 *            Newly created fireflies are given a random location.
	 */
	public Firefly(int numDimensions)
	{
		position = new double[numDimensions];
		Random r = new Random();
		for (int i = 0; i < numDimensions; i++)
		{
			position[i] = LOWER_BOUND + (UPPER_BOUND - LOWER_BOUND) * r.nextDouble();
		}
	}

	public double[] getPosition()
	{
		return position;
	}

	public void setPosition(double[] newPosition)
	{
		position = newPosition;
	}

	public void setPosition(double newPosition, int dimension)
	{
		position[dimension] = newPosition;
	}

	public double getIntensity()
	{
		return lightIntensity;
	}

	public void setIntensity(double intensity)
	{
		lightIntensity = intensity;
	}
}
