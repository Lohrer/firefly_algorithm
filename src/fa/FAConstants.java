package fa;

/**
 * @author Michael Lohrer
 *
 */
public interface FAConstants {
	final static double	RANDOMNESS				= 0.2;	// 0--1 (highly random)
	final static double	RANDOMNESS_REDUCTION	= 0.97;	// Similar to an annealing schedule
	final static double	ABSORPTION_COEFFCIENT	= 1.0;
	final static int	MAX_GENERATION			= 500;
	final static int	NUM_DIMENSIONS			= 30;
	final static int	NUM_FIREFLIES			= 30;
	
	final static double	BOUND					= 5;
	
	//final static double ERR_TOLERANCE			= 1E-20;
}
