package fa;

import java.util.Random;

/**
 * @author Michael Lohrer
 * @version 1.0
 * 
 */
public class Main implements FAConstants
{

	private static Firefly[] fireflies;
	private static Random r;

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		//int best = 0;

		Functions fitnessFunction = new Functions(FUNCTIONTYPE);
		r = new Random();

		// Create and initialize the array of fireflies
		fireflies = new Firefly[NUM_FIREFLIES];
		for (int i = 0; i < NUM_FIREFLIES; i++)
		{
			Firefly f = new Firefly(NUM_DIMENSIONS);
			f.setIntensity( 1/fitnessFunction.evaluate(f.getPosition()) );
			fireflies[i] = f;
		}

		// Find the max distance between fireflies and reduce GAMMA accordingly
		double maxDistance = 0, tempDist;
		for (int i = 0; i < (NUM_FIREFLIES - 1); i++)
		{
			for (int j = (i + 1); j < NUM_FIREFLIES; j++)
			{
				tempDist = 0;
				for (int k = 0; k < NUM_DIMENSIONS; k++)
				{
					tempDist += Math.pow(fireflies[j].getPosition()[k] - fireflies[i].getPosition()[k], 2);
				}
				tempDist = Math.sqrt(tempDist);
				if (tempDist > maxDistance)
				{
					maxDistance = tempDist;
				}
			}
		}
		double adjustedGamma = GAMMA / maxDistance;

		// Variables for determining progress
		System.out.println("Progress: ");
		double percentDone;
		int iPercentDone = 0;
		long currentTime;
		long timeRemaining;

		double alpha = ALPHA; // Allow alpha to be reduced
		int currentGeneration = 0;
		double bestEvaluation = java.lang.Double.POSITIVE_INFINITY;
		boolean moved = false;
		
		// Run main algorithm
		while (currentGeneration < MAX_GENERATION && bestEvaluation >= ERR_THRESHOLD)
		{
			// Calculate new firefly positions
			for (int i = 0; i < NUM_FIREFLIES; i++)
			{
				// Compare firefly i against all others and move towards any brighter ones
				for (int j = 0; j < NUM_FIREFLIES; j++)
				{
					// Move firefly i towards j in d-dimension if j is brighter (lower)
					if (fireflies[i].getIntensity() > fireflies[j].getIntensity())
					{
						// Get distance r from firefly i to j
						double r = calculateDistance(fireflies[i].getPosition(), fireflies[j].getPosition());

						// Calculate attractiveness
						double beta = (1 - BETA_MIN) * Math.exp(-adjustedGamma * r * r) + BETA_MIN;

						// Move firefly i towards j
						moveFirefly(alpha, beta, i, j);
						
						moved = true;
					}
				}
				
				// If the firefly was never moved, move it a bit randomly
				if(!moved)
				{
					for (int d = 0; d < NUM_DIMENSIONS; d++)
					{
						fireflies[i].getPosition()[d] += alpha * (r.nextDouble() - 0.5f);
					}
				}
				moved = false;
				
				// Update firefly i's intensity
				double newEvaluation = fitnessFunction.evaluate(fireflies[i].getPosition());
				fireflies[i].setIntensity( newEvaluation );
				
				// Check if best position found so far
				if (newEvaluation < bestEvaluation)
				{
					bestEvaluation = newEvaluation;
				}
			}	// END firefly position update

			// Reduce alpha for the next generation
			alpha = alpha * DELTA;
			currentGeneration++;

			// Display percent done
			if ( (int)(100*currentGeneration/MAX_GENERATION) - iPercentDone > 0 )
			{
				iPercentDone = (int)(100*currentGeneration/MAX_GENERATION);
				currentTime = System.nanoTime();
				System.out.print( iPercentDone + "% in " + (currentTime-startTime)/1000000000 + "s" );
				
				percentDone = ((double)currentGeneration/(double)MAX_GENERATION);
				timeRemaining = (long)( (float)(currentTime - startTime) * (1/percentDone - 1) / 1000000000 );
				System.out.println("\t\tTime remaining: " + timeRemaining + "s");
			}
		}

		double bestIntensity = fireflies[0].getIntensity();
		for (int i = 1; i < NUM_FIREFLIES; i++)
		{
			if (fireflies[i].getIntensity() < bestIntensity)
			{
				bestIntensity = fireflies[i].getIntensity();
			}
		}

		long endTime = System.nanoTime();

		System.out.println("Total time taken: " + (endTime - startTime) / 1000000 + " ms\n");
		System.out.println("Number of function evaluations: " + (currentGeneration*NUM_FIREFLIES+NUM_FIREFLIES) + "\n");
		System.out.println("Best Value: " + bestIntensity + "\n");

		//System.out.println("Located at:"); for (int i = 0; i <NUM_DIMENSIONS; i++)
		//{
		//	System.out.println("\t" + fireflies[best].getPosition()[i]);
		//}
	}

	/**
	 * Calculate the Cartesian distance between two points
	 * 
	 * @return Distance
	 */
	public static double calculateDistance(double[] position1, double[] position2)
	{
		double sum = 0;
		for (int d = 0; d < NUM_DIMENSIONS; d++)
		{
			sum += Math.pow(position2[d] - position1[d], 2);
		}
		return Math.sqrt(sum);
	}

	/**
	 * Move firefly i towards j
	 */
	public static void moveFirefly(double alpha, double beta, int i, int j)
	{
		double position;
		double randomComponent;
		for (int d = 0; d < NUM_DIMENSIONS; d++)
		{
			position = fireflies[i].getPosition()[d];
			randomComponent = alpha * (r.nextDouble() - 0.5f) * (UPPER_BOUND - LOWER_BOUND);
			position += beta * (fireflies[j].getPosition()[d] - position) + randomComponent;

			// Make sure the firefly stays within the bounds
			if (position > UPPER_BOUND)
			{
				position = UPPER_BOUND;
			}
			if (position < LOWER_BOUND)
			{
				position = LOWER_BOUND;
			}
			fireflies[i].setPosition(position, d);
		}
	}
}