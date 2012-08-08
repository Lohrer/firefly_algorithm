package fa;

import fa.ProblemSet.FunctionType;

/**
 * @author Michael Lohrer
 * 
 */
public interface FAConstants
{
	final static float			ALPHA			= 0.013f;	// Randomness: 0--1 (highly random)
	final static float			DELTA			= 0.97f;	// Randomness reduction, similar to an annealing schedule
	final static float			GAMMA			= 0.1f;		// Absorption Coefficient
	final static float			BETA0			= 1.0f;		// Maximum Attraction

	final static int			NUM_FIREFLIES	= 40;
	final static int			MAX_GENERATION	= 10000;
	final static float			ERR_THRESHOLD	= .01f;

	final static FunctionType	FUNCTIONTYPE	= FunctionType.SPHERE;
	final static float			BOUND			= 100;
	final static int			NUM_DIMENSIONS	= 30;
}
