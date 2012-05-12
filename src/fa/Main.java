package fa;

import java.util.Random;

/**
 * @author Michael Lohrer
 * @version 0.1
 * 
 */
public class Main implements FAConstants {
	
	private static Firefly[] fireflies;
	
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int numEvaluations = 0;
		
		ProblemSet fitnessFunction = new ProblemSet(NUM_DIMENSIONS);
		
		System.out.println("Initializing Fireflies");
		fireflies = new Firefly[NUM_FIREFLIES];
		for (int i = 0; i < NUM_FIREFLIES; i++) {
			Firefly f = new Firefly(NUM_DIMENSIONS);
			f.setIntensity( 1/fitnessFunction.evaluate(f.getPosition()) );
			fireflies[i] = f;
		}
		
		long initTime = System.nanoTime();
		System.out.println("\tFireflies initialized in " + (initTime - startTime) / 1000 + " us");
		
		System.out.println("Running Algorithm");
		double alpha = ALPHA;	// Allow alpha to be reduced
		int currentGeneration = 0;
		while (currentGeneration < MAX_GENERATION) {
			// Rank fireflies
			
			
			// Update Firefly positions
			for (int i = 0; i < NUM_FIREFLIES; i++) {
				for (int j = 0; j < NUM_FIREFLIES; j++) {	//for (int j = 0; j < i; j++) {
					// Move firefly i towards j in d-dimension
					if (fireflies[i].getIntensity() < fireflies[j].getIntensity()) {
						// Get distance r from firefly i to j
						double r = calculateDistance(fireflies[i].getPosition(), fireflies[j].getPosition());
						// Calculate attractiveness
						double beta = BETA0*Math.exp(-GAMMA*r*r);
						// Move firefly i towards j
						moveFirefly(alpha, beta, i, j);
						// Update firefly i's intensity
						fireflies[i].setIntensity( 1/fitnessFunction.evaluate(fireflies[i].getPosition()) );
						numEvaluations++;
					}
				}
			}
			// Reduce alpha for the next iteration
			alpha = alpha*DELTA;
			currentGeneration++;
		}
		long algTime = System.nanoTime();
		System.out.println("\tAlgorithm completed in " + (algTime - initTime) / 1000000 + " ms");
		
		System.out.println("Calculating Results:");
		double bestIntensity = fireflies[0].getIntensity();
		for (int i = 1; i < NUM_FIREFLIES; i++) {
			if (fireflies[i].getIntensity() > bestIntensity) {
				bestIntensity = fireflies[i].getIntensity();
			}
		}
		System.out.println("\tBest Value: " + 1/bestIntensity);
		long endTime = System.nanoTime();
		System.out.println("\tResult calculation time: " + (endTime - algTime) / 1000 + " us");
		System.out.println("Total time taken: " + (endTime - startTime) / 1000000 + " ms");
		System.out.println("Number of function evaluations: " + numEvaluations);
	}
	
	/**
	 * Calculate the Cartesian distance between two points
	 * @return Distance
	 */
	public static double calculateDistance(double[] position1, double[] position2) {
		double sum = 0;
		for (int i = 0; i < NUM_DIMENSIONS; i++) {
			sum += Math.pow(position2[i]-position1[i],2);
		}
		return Math.sqrt(sum);
	}
	
	/**
	 * Move firefly i towards j
	 */
	public static void moveFirefly(double alpha, double beta, int i, int j) {
		double position;
		Random r = new Random();
		for (int k = 0; k < NUM_DIMENSIONS; k++) {
			position = fireflies[i].getPosition()[k];
			position += beta*(fireflies[j].getPosition()[k]-position) + ALPHA*r.nextGaussian();
			fireflies[i].setPosition(position, k);
			//ALPHA*r.nextGaussian()
		}
	}
}