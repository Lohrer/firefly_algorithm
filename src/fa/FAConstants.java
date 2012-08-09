package fa;

import fa.ProblemSet.FunctionType;

/**
 * @author Michael Lohrer
 * 
 */
public interface FAConstants
{
	final static float			ALPHA			= 0.01f;	// Randomness: 0--1 (highly random)
	final static float			DELTA			= 0.97f;	// Randomness reduction, similar to an annealing schedule
	final static float			GAMMA			= 1.0f;		// Absorption Coefficient
	final static float			BETA_MIN		= 0.2f;		// Maximum Attraction

	final static int			NUM_FIREFLIES	= 30;
	final static int			MAX_GENERATION	= 500;
	final static float			ERR_THRESHOLD	= .01f;

	final static FunctionType	FUNCTIONTYPE	= FunctionType.SPHERE;
	final static float			BOUND			= 100;
	final static int			NUM_DIMENSIONS	= 30;
}


/**
 *	SPHERE FUNCTION OPTIMAL SETTINGS:
 *
 *	final static float			ALPHA			= 0.01f;	// Randomness: 0--1 (highly random)
 *	final static float			DELTA			= 0.97f;	// Randomness reduction, similar to an annealing schedule
 *	final static float			GAMMA			= 0.07f;		// Absorption Coefficient
 *	final static float			BETA0			= 1.0f;		// Maximum Attraction
 *
 *	final static int			NUM_FIREFLIES	= 30;
 *	final static int			MAX_GENERATION	= 10000;
 *	final static float			ERR_THRESHOLD	= .01f;
 *
 *	final static FunctionType	FUNCTIONTYPE	= FunctionType.SPHERE;
 *	final static float			BOUND			= 100;
 *	final static int			NUM_DIMENSIONS	= 30;
 *
 *
 * ROSENBROCK FUCTION OPTIMAL SETTINGS:
 * 
 * 	final static float			ALPHA			= 0.01f;	// Randomness: 0--1 (highly random)
 *	final static float			DELTA			= 0.97f;	// Randomness reduction, similar to an annealing schedule
 *	final static float			GAMMA			= 0.05f;		// Absorption Coefficient
 *	final static float			BETA0			= 1.0f;		// Maximum Attraction
 *
 *	final static int			NUM_FIREFLIES	= 15;
 *	final static int			MAX_GENERATION	= 3000;
 *	final static float			ERR_THRESHOLD	= 20f;
 *
 *	final static FunctionType	FUNCTIONTYPE	= FunctionType.ROSENBROCK;
 *	final static float			BOUND			= 30;
 *	final static int			NUM_DIMENSIONS	= 30;
 *
 */