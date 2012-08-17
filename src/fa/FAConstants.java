package fa;

/**
 * @author Michael Lohrer
 * 
 */
public interface FAConstants
{
	final static double ALPHA = 0.5f; // Randomness: 0--1 (highly random)
	final static double DELTA = 0.97f; // Randomness reduction, similar to an annealing schedule
	final static double GAMMA = 1.0f; // Absorption Coefficient
	final static double BETA_MIN = 0.2f; // Minimum Attraction

	final static int NUM_FIREFLIES = 1024;
	final static int MAX_GENERATION = 500;
	final static double ERR_THRESHOLD = 1;

	final static FunctionType FUNCTIONTYPE = FunctionType.ACKLEY;
	final static double UPPER_BOUND = 500f;
	final static double LOWER_BOUND = -500f;
	final static int NUM_DIMENSIONS = 30;
}

enum FunctionType
{
	ACKLEY, EMISSION_SOURCE_LOCALIZATION, GRIEWANK, MICHALEWICZ, RASTRIGIN, ROSENBROCK, SPHERE, SCHWEFEL
}

/**
 * SPHERE FUNCTION OPTIMAL SETTINGS:
 * 
 * final static double ALPHA = 0.5f; // Randomness: 0--1 (highly random) final
 * static double DELTA = 0.97f; // Randomness reduction, similar to an annealing
 * schedule final static double GAMMA = 1.0f; // Absorption Coefficient final
 * static double BETA_MIN = 0.2f; // Minimum Attraction
 * 
 * final static int NUM_FIREFLIES = 20; final static int MAX_GENERATION = 500;
 * final static double ERR_THRESHOLD = .01f;
 * 
 * final static FunctionType FUNCTIONTYPE = FunctionType.SPHERE; final static
 * double UPPER_BOUND = 100; final static double LOWER_BOUND = -100; final static
 * int NUM_DIMENSIONS = 30;
 * 
 * 
 * ROSENBROCK FUCTION OPTIMAL SETTINGS:
 * 
 * final static double ALPHA = 0.01f; // Randomness: 0--1 (highly random) final
 * static double DELTA = 0.97f; // Randomness reduction, similar to an annealing
 * schedule final static double GAMMA = 0.05f; // Absorption Coefficient final
 * static double BETA0 = 1.0f; // Maximum Attraction
 * 
 * final static int NUM_FIREFLIES = 15; final static int MAX_GENERATION = 3000;
 * final static double ERR_THRESHOLD = 20f;
 * 
 * final static FunctionType FUNCTIONTYPE = FunctionType.ROSENBROCK; final
 * static double BOUND = 30; final static int NUM_DIMENSIONS = 30;
 * 
 */
