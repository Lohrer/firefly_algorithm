package fa;

/**
 * @author Mike
 * @version 0.1
 *
 */
public class FA {

	int numFireflies;
	int maxGen;
	int absorptionCoefficient;
	
	/**
	 * @param Number of Fireflies
	 * @param Generations (Max)
	 * @param Absorption coefficient
	 *
	 */
	public FA( int numFlies, int maxGenerations, int gamma ) {
		numFireflies = numFlies;
		absorptionCoefficient = gamma;
		maxGen = maxGenerations;
	}
}
