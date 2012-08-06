package fa;


/**
 * @author Michael Lohrer
 *
 */
public class ProblemSet {
	
	enum FunctionTypes {
		SPHERE, ROSENBROCK, GRIEWANK, MICHALEWICZ, RASTRIGIN, HUMP, ESL
	}
	
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
			case SPHERE:		// The global minima: x* =  (0, …, 0), f(x*) = 0
				for (int i = 0; i < numDimensions; i++) {
					fitnessValue += point[i]*point[i];
				}
				break;
			case ROSENBROCK:	// The global minima: x* =  (1, …, 1), f(x*) = 0
				for (int i = 0; i < numDimensions-1; i++) {
					fitnessValue += 100*Math.pow( Math.pow(point[i],2)-point[i+1],2) + Math.pow(point[i]-1,2);
				}
				break;
			case GRIEWANK:		// The global minima: x* =  (0, …, 0), f(x*) = 0
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
			case MICHALEWICZ:	// For m=10. The global minima: at n=2, f(x*) = -1.8013; at n=5, f(x*) = --4.687658; at n=10, f(x*) = -9.66015.
				for (int i = 0; i < numDimensions; i++) {
					fitnessValue += Math.sin(point[i])*Math.pow( Math.sin((i+1)*Math.pow(point[i],2)/Math.PI) ,20);
				}
				fitnessValue = -fitnessValue;
				break;
			case RASTRIGIN:		// The global minima: x* =  (0, …, 0), f(x*) = 0
				for (int i = 0; i < numDimensions; i++) {
					fitnessValue += Math.pow(point[i],2) - 10*Math.cos(2*Math.PI*point[i]);
				}
				fitnessValue += 10*numDimensions;
				break;
			case HUMP:			// The global minima: x* =  (0.0898, -0.7126), (-0.0898, 0.7126), f(x*) = 0
				if (numDimensions == 2) {
					fitnessValue = 1.0316285+4*Math.pow(point[0],2)-2.1*Math.pow(point[0],4)+Math.pow(point[0],6)/3+point[0]*point[1]-4*Math.pow(point[1],2)+4*Math.pow(point[1],4);
				}
				break;
			case ESL:			// Emission Source Localization
				for (int i = 0; i < numDimensions; i++) {
					fitnessValue += point[i]*point[i];
				}
				break;
			default:
				break;
		}
		
		return fitnessValue;
	}
}
