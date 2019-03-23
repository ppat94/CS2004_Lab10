import java.util.Random;


public class CannonSolution {

	public static double angle;
	public static double muzzleVel;
	static private Random rand;

	public CannonSolution() 
	{
			
	}
	
	public static double findFitness(double range, double targetRange) {
		double fitness = Math.abs(range - targetRange);
		return fitness;
	}

	public static double generateRandomAngle(double startRange, double endRange) {
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}

		return((endRange-startRange)*rand.nextDouble()+startRange);
	}

	public static double generateRandomMuzzleVel(double startRange, double endRange) {
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}

		return((endRange-startRange)*rand.nextDouble()+startRange);
	}

	public static void SmallChange() 
	{
		int n = rand.nextInt(2) + 0;

		if (n == 0) 
		{
			double x = rand.nextDouble() * (0.3 - (-0.3)) + (-0.3);
			angle += x;
			if (angle > 55) 
			{
				angle = 55;
			}
			else if (angle < 25) {
				angle = 25;
			}
		}
		else if (n == 1)
		{
			double y = rand.nextDouble() * (1.5 - (-1.5)) + (-1.5);
			muzzleVel += y;
			if (muzzleVel > 1650)
			{
				muzzleVel = 1650;
			}
			else if (muzzleVel < 1500)
			{
				muzzleVel = 1500;
			}
		}

	}

	public static void setValues(double currentAngle, double currentVelocity) {
		angle = currentAngle;
		muzzleVel = currentVelocity;
	}
	
	public static double getAngle() {
		return angle;
	}

	public static double getMuzzleVel()
	{
		return muzzleVel;
	}

	//Display the string with a new line
	public void printAngleAndMuzzle()
	{
		System.out.println("Angle: " + angle + ", Muzzle Velocity: " + muzzleVel);
	}

}
