package fa;


/**
 * @author Michael Lohrer
 *
 */
public class ProblemSet {
	
	private static final FunctionTypes FUNCTIONTYPE = FunctionTypes.SPHERE;
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
					fitnessValue += 100*(point[i]*point[i]-point[i+1])*(point[i]*point[i]-point[i+1])+(point[i]-1)*(point[i]-1);
				}
				break;
			case GRIEWANK:
				double s = 0;
				double p = 1;
				for (int i = 0; i < numDimensions; i++) {
					s += point[i]*point[i];
				}
				for (int i = 0; i < numDimensions; i++) {
					p = p*Math.cos(point[i]/Math.sqrt(i));
				}
				fitnessValue = s/4000-p+1;
				break;
			default:
				break;
		}
		
		return fitnessValue;
	}
}
