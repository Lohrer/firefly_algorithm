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
	final static int	MAX_GENERATION	= 10000;
	final static int	NUM_DIMENSIONS	= 30;
	final static int	NUM_FIREFLIES	= 50;
	
	final static double	BOUND			= 100;
	
	final static double	ERR_THRESHOLD	= 1;
}
