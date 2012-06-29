package fa;

/**
 * @author Michael Lohrer
 *
 */
public interface FAConstants {
	final static double	ALPHA			= 0.1;	// Randomness: 0--1 (highly random)
	final static double	DELTA			= 0.97;	// Randomness reduction, similar to an annealing schedule
	final static double	GAMMA			= 1.0;	// Absorption Coefficient
	final static double BETA0			= 1.0;	// Maximum Attraction
	final static int	MAX_GENERATION	= 1000000;
	final static int	NUM_DIMENSIONS	= 30;
	final static int	NUM_FIREFLIES	= 1000;
	
	final static double	BOUND			= 2;
	
//	final static double	ERR_TOLERANCE	= 1E-20;
}
