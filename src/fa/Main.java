package fa;

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
		ProblemSet fitnessFunction = new ProblemSet(NUM_DIMENSIONS);
		
		System.out.println("Initializing Fireflies");
		for (int i = 0; i < NUM_FIREFLIES; i++) {
			Firefly f = new Firefly(NUM_DIMENSIONS);
			f.setIntensity(fitnessFunction.evaluate(f.getPosition()));
			fireflies[i] = f;
		}
		
		System.out.println("Running Algorithm");
		int currentGeneration = 0;
		while (currentGeneration < MAX_GENERATION) {
			// Update Firefly positions
			for (int i = 0; i < NUM_FIREFLIES; i++) {
				for (int j = 0; j < i; j++) {
					if (fireflies[j].getIntensity() < fireflies[i].getIntensity()) {
					//Move firefly i towards j in d-dimension;
					}
					//Attractiveness varies with distance r via exp[-yr^2]
					//Evaluate new solutions and update light intensity
				}
			}
		}
		
		// Output results
		System.out.println(" ");
	}
}