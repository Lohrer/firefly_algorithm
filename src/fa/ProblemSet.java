package fa;


/**
 * @author Michael Lohrer
 *
 */
public class ProblemSet {
	
	private static final FunctionTypes FUNCTIONTYPE = FunctionTypes.ROSENBROCK;
	private int numDimensions;
	
	public ProblemSet(int dimensions) {
		numDimensions = dimensions;
	}
	
	/**
	 * Determines the fitness value for a specified point.
	 * @return Fitness Value
	 */
	public double evaluate(double[] point) {
		double fitnessValue = 0;
		
		switch (FUNCTIONTYPE) {
			case SPHERE:
				for (int i = 0; i < numDimensions; i++) {
					fitnessValue += point[i]*point[i];
				}
				break;
			case ROSENBROCK:
				for (int i = 0; i < numDimensions-1; i++) {
					fitnessValue += 100*Math.pow(Math.pow(point[i],2)-point[i+1],2)+Math.pow(point[i]-1,2);
				}
				break;
			case GRIEWANK:
				double s = 0;
				double p = 1;
				for (int i = 0; i < numDimensions; i++) {
					s += point[i]*point[i];
				}
				for (int i = 1; i <= numDimensions; i++) {
					p = p*Math.cos(point[i-1]/Math.sqrt(i));
				}
				fitnessValue = s/4000-p+1;
				break;
			default:
				break;
		}
		
		return fitnessValue;
	}
}
