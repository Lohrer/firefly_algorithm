package fa;

/**
 * @author Michael Lohrer
 * 
 */
public class Functions implements FAConstants
{
	private FunctionType functionType;

	public Functions(FunctionType funcType)
	{
		functionType = funcType;
	}

	/**
	 * Determines the fitness value for a specified point.
	 * 
	 * @return Fitness Value
	 */
	public double evaluate(double[] point)
	{
		double fitnessValue = 0;

		switch (functionType)
		{
		case ACKLEY: // The global minimum: x* =  (0, …, 0), f(x*) = 0
			double sumsq = 0;
			double sumcos = 0;
			double c = Math.PI * 2;
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				sumsq += point[i] * point[i];
				sumcos += Math.cos(c * point[i]);
			}
			fitnessValue = -20.0f *  Math.exp(-0.2 * Math.sqrt(1.0f / NUM_DIMENSIONS * sumsq)) - Math.exp(1.0f / NUM_DIMENSIONS * sumcos) + 20.0f + Math.E;
			break;
		case EMISSION_SOURCE_LOCALIZATION:
			// TODO: Put correct code here
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				fitnessValue += point[i] * point[i];
			}
			break;
		case GRIEWANK: // The global minima: x* = (0, …, 0), f(x*) = 0
			double s = 0;
			double p = 1;
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				s += point[i] * point[i];
			}
			for (int i = 1; i <= NUM_DIMENSIONS; i++)
			{
				p = p * Math.cos(point[i - 1] / Math.sqrt(i));
			}
			fitnessValue = s / 4000 - p + 1;
			break;
		case MICHALEWICZ: // For m=10. The global minima: at n=2, f(x*) = -1.8013; at n=5, f(x*) = -4.687658; at n=10, f(x*) = -9.66015.
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				fitnessValue += Math.sin(point[i]) * Math.pow(Math.sin(i * point[i] * point[i] / Math.PI), 20);
			}
			fitnessValue = -fitnessValue;
			break;
		case RASTRIGIN: // The global minima: x* = (0, …, 0), f(x*) = 0
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				fitnessValue += Math.pow(point[i], 2) - 10 * Math.cos(2 * Math.PI * point[i]);
			}
			fitnessValue += 10 * NUM_DIMENSIONS;
			break;
		case ROSENBROCK: // The global minima: x* = (1, …, 1), f(x*) = 0
			for (int i = 0; i < NUM_DIMENSIONS - 1; i++)
			{
				fitnessValue += 100 * Math.pow(Math.pow(point[i], 2) - point[i + 1], 2) + Math.pow(point[i] - 1, 2);
			}
			break;
		case SPHERE: // The global minima: x* = (0, …, 0), f(x*) = 0
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				fitnessValue += point[i] * point[i];
			}
			break;
		case SCHWEFEL: // The global minima: x* = (0, …, 0), f(x*) = 0
			for (int i = 0; i < NUM_DIMENSIONS; i++)
			{
				fitnessValue += -point[i] * Math.sin(Math.sqrt(Math.abs(point[i])));
			}
			fitnessValue += 418.9829*NUM_DIMENSIONS;
			break;
		default:
			break;
		}

		return fitnessValue;
	}
}
