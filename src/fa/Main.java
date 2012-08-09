package fa;

import java.util.Random;

/**
 * @author Michael Lohrer
 * @version 0.1
 * 
 */
public class Main implements FAConstants
{

	private static Firefly[] fireflies;

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		long numEvaluations = 0;

		ProblemSet fitnessFunction = new ProblemSet(NUM_DIMENSIONS, FUNCTIONTYPE);

		// System.out.println("Initializing Fireflies");
		fireflies = new Firefly[NUM_FIREFLIES];
		for (int i = 0; i < NUM_FIREFLIES; i++)
		{
			Firefly f = new Firefly(NUM_DIMENSIONS);
			f.setIntensity(1 / fitnessFunction.evaluate(f.getPosition()));
			fireflies[i] = f;
		}

		// Find max distance and reduce gamma accordingly
		float maxDistance = 0, tempDist;
		for (int i = 0; i < (NUM_FIREFLIES - 1); i++)
		{
			for (int j = (i + 1); j < NUM_FIREFLIES; j++)
			{
				tempDist = 0;
				for (int k = 0; k < NUM_DIMENSIONS; k++)
				{
					tempDist += Math.pow(fireflies[j].getPosition()[k] - fireflies[i].getPosition()[k], 2);
				}
				tempDist = (float) Math.sqrt(tempDist);
				if (tempDist > maxDistance)
				{
					maxDistance = tempDist;
				}
			}
		}
		float adjustedGamma = GAMMA / maxDistance;

		// Variables for determining progress
		System.out.println("Progress: ");
		float fPercentDone;
		int iPercentDone = 0;
		long currentTime;
		long timeRemaining;

		float alpha = ALPHA; // Allow alpha to be reduced
		int currentGeneration = 0;
		float bestEvaluation = java.lang.Float.POSITIVE_INFINITY;
		while (currentGeneration < MAX_GENERATION && bestEvaluation >= ERR_THRESHOLD)
		{
			// Update Firefly positions
			for (int i = 0; i < NUM_FIREFLIES; i++)
			{
				for (int j = 0; j < NUM_FIREFLIES; j++)
				{
					// Move firefly i towards j in d-dimension
					if (fireflies[i].getIntensity() < fireflies[j].getIntensity())
					{
						// Get distance r from firefly i to j
						float r = calculateDistance(fireflies[i].getPosition(), fireflies[j].getPosition());

						// Calculate attractiveness
						float beta = (1 - BETA_MIN) * (float) Math.exp(-adjustedGamma * r * r) + BETA_MIN;

						// Move firefly i towards j
						moveFirefly(alpha, beta, i, j);

						float newEvaluation = fitnessFunction.evaluate(fireflies[i].getPosition());

						// Update firefly i's intensity
						fireflies[i].setIntensity(1 / newEvaluation);

						// Check if best firefly
						if (newEvaluation < bestEvaluation)
						{
							bestEvaluation = newEvaluation;
						}

						numEvaluations++;
					}
				}
			}

			// Reduce alpha for the next iteration
			alpha = alpha * DELTA;
			currentGeneration++;

			// Display percent done
			if ((int) (100 * currentGeneration / MAX_GENERATION) - iPercentDone > 0)
			{
				iPercentDone = (int) (100 * currentGeneration / MAX_GENERATION);
				currentTime = System.nanoTime();
				System.out.print(iPercentDone + "% in " + (currentTime - startTime) / 1000000000 + "s");

				fPercentDone = ((float) currentGeneration / (float) MAX_GENERATION);
				timeRemaining = (long) ((float) (currentTime - startTime) * (1 / fPercentDone - 1) / 1000000000);
				System.out.println("\t\tTime remaining: " + timeRemaining + "s");
			}
		}

		float bestIntensity = fireflies[0].getIntensity();
		for (int i = 1; i < NUM_FIREFLIES; i++)
		{
			if (fireflies[i].getIntensity() > bestIntensity)
			{
				bestIntensity = fireflies[i].getIntensity();
			}
		}

		long endTime = System.nanoTime();
		// System.out.println("\tResult calculation time: " + (endTime -
		// algTime) / 1000 + " us");

		System.out.println("Total time taken: " + (endTime - startTime) / 1000000 + " ms\n");
		System.out.println("Number of function evaluations: " + numEvaluations + "\n");
		System.out.println("Best Value: " + 1 / bestIntensity + "\n");
		// System.out.println("Located at:");
		// for (int i = 0; i < NUM_DIMENSIONS; i++)
		// {
		// System.out.println("\t" + fireflies[best].getPosition()[i]);
		// }
	}

	/**
	 * Calculate the Cartesian distance between two points
	 * 
	 * @return Distance
	 */
	public static float calculateDistance(float[] position1, float[] position2)
	{
		float sum = 0;
		for (int d = 0; d < NUM_DIMENSIONS; d++)
		{
			sum += Math.pow(position2[d] - position1[d], 2);
		}
		return (float) Math.sqrt(sum);
	}

	/**
	 * Move firefly i towards j
	 */
	public static void moveFirefly(float alpha, float beta, int i, int j)
	{
		float position;
		Random r = new Random();
		for (int d = 0; d < NUM_DIMENSIONS; d++)
		{
			position = fireflies[i].getPosition()[d];
			position += beta * (fireflies[j].getPosition()[d] - position) + ALPHA * r.nextGaussian();

			// Make sure the firefly stays within the bounds
			if (position > BOUND)
			{
				position = BOUND;
			}
			if (position < -BOUND)
			{
				position = -BOUND;
			}
			fireflies[i].setPosition(position, d);
		}
	}
}