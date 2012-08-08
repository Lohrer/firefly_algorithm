package fa;

import java.util.Random;

/**
 * @author Michael Lohrer
 * @version 0.1
 */
public class Firefly implements FAConstants
{

	private float lightIntensity;
	private float[] position;

	/**
	 * @param numDimensions
	 */
	public Firefly(int numDimensions)
	{
		position = new float[numDimensions];
		Random r = new Random();
		for (int i = 0; i < numDimensions; i++)
		{
			position[i] = (r.nextFloat() - 0.5f) * BOUND;
		}
	}

	public float[] getPosition()
	{
		return position;
	}

	public void setPosition(float[] newPosition)
	{
		position = newPosition;
	}

	public void setPosition(float newPosition, int dimension)
	{
		position[dimension] = newPosition;
	}

	public float getIntensity()
	{
		return lightIntensity;
	}

	public void setIntensity(float intensity)
	{
		lightIntensity = intensity;
	}
}
