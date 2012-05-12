package fa;

/**
 * @author Michael Lohrer
 *
 */
public interface FAConstants {
	final static double	ALPHA			= 0.2;	// Randomness: 0--1 (highly random)
	final static double	DELTA			= 0.97;	// Randomness reduction, similar to an annealing schedule
	final static double	GAMMA			= 1.0;	// Absorption Coefficient
	final static double BETA0			= 1.0;	// Maximum Attraction
	final static int	MAX_GENERATION	= 100;
	final static int	NUM_DIMENSIONS	= 2;
	final static int	NUM_FIREFLIES	= 40;
	
	final static double	BOUND			= 5;
	
//	final static double	ERR_TOLERANCE	= 1E-20;
}
