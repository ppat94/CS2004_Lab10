import java.util.ArrayList;

public class Lab10 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 10.3, Exercise 1: The Cannon Class
		double r = Cannon.GetMaxRange(40.0,1575.0);
//		System.out.println(r);
		ArrayList<Double> xt = Cannon.GetX();
		ArrayList<Double> yt = Cannon.GetY();
//		System.out.println(xt.size());
//		System.out.println(yt.size());

//		for (int i = 0; i < xt.size(); i++) {
//			System.out.println("X: " + xt.get(i) + ", Y: " + yt.get(i));
//		}
		
//		System.out.println(CannonSolution.generateRandomAngle(25, 55));
//		System.out.println(CannonSolution.generateRandomMuzzleVel(1500, 1650));
		
		//System.out.println(Cannon.GetMaxRange(53.439, 1649.9107));
		//RMHC(1000);
		//RMHCMin(1000);
		RMHCTargetRange(1000, 95000);
		
	}
	
	@SuppressWarnings("unused")
	public static double RMHC(int iter)
	{
		CannonSolution cannonSolution = new CannonSolution();
		
		double currentAngle = CannonSolution.getAngle();
		double currentMuzzleVel = CannonSolution.getMuzzleVel();
		double newAngle = 0;
		double newMuzzleVel = 0;
		double newFitness = 0;
		double currentFitness;
		
		currentFitness = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
		
		for(int i = 0; i <= iter; i++)
		{
			currentAngle = CannonSolution.generateRandomAngle(25, 55);
			currentMuzzleVel = CannonSolution.generateRandomMuzzleVel(1500, 1650);
			
			CannonSolution.SmallChange();
			
			newFitness = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
			
			if (newFitness < currentFitness) 
			{
				newFitness = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
			}
			else
			{
				newAngle = currentAngle;
				newMuzzleVel = currentMuzzleVel;
				currentFitness = newFitness;
			}
			if (i % 100 == 0) {
				System.out.println(currentFitness);
				//System.out.println("Iteration: " + i + ", Max Fit: " + currentFitness + ", Velocity: " + currentMuzzleVel + ", Angle: " + currentAngle);
			}
//			System.out.println("Max Fitness: " + currentFitness);
//			System.out.println("Muzzle Velocity: " + currentMuzzleVel);
//			System.out.println("Angle: " + currentAngle);
		}
		return(newFitness);
	}
	
	@SuppressWarnings("unused")
	public static double RMHCMin(int iter)
	{
		CannonSolution cannonSolution = new CannonSolution();
		
		double currentAngle = CannonSolution.getAngle();
		double currentMuzzleVel = CannonSolution.getMuzzleVel();
		double newAngle = 0;
		double newMuzzleVel = 0;
		double newFitness = 0;
		double currentFitness;
		
		currentFitness = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
		
		for(int i = 0; i <= iter; i++)
		{
			currentAngle = CannonSolution.generateRandomAngle(25, 55);
			currentMuzzleVel = CannonSolution.generateRandomMuzzleVel(1500, 1650);
			
			CannonSolution.SmallChange();
			
			newFitness = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
			
			if (newFitness > currentFitness) 
			{
				newFitness = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
			}
			else
			{
				newAngle = currentAngle;
				newMuzzleVel = currentMuzzleVel;
				currentFitness = newFitness;
			}
			if (i % 100 == 0) {
				System.out.println(currentFitness);
				//System.out.println("Iteration: " + i + ", Max Fit: " + currentFitness + ", Velocity: " + currentMuzzleVel + ", Angle: " + currentAngle);
			}
//			System.out.println("Min Fitness: " + currentFitness);
//			System.out.println("Muzzle Velocity: " + currentMuzzleVel);
//			System.out.println("Angle: " + currentAngle);
		}
		return(newFitness);
	}
	
	@SuppressWarnings("unused")
	public static void RMHCTargetRange(int iter, int targetRange)
	{
		CannonSolution cannonSolution = new CannonSolution();
		
		double newAngle;
		double newMuzzleVel;
		double newFitness;
		double newRange;
		double currentFitness;
		double currentRange;
		double currentMuzzleVel;
		double currentAngle;
		
		currentAngle = CannonSolution.generateRandomAngle(25, 55);
		currentMuzzleVel = CannonSolution.generateRandomMuzzleVel(1500, 1650);
		CannonSolution.setValues(currentAngle, currentMuzzleVel);
		
		for(int i = 0; i <= iter; i++)
		{	
			currentAngle = CannonSolution.getAngle();
			currentMuzzleVel = CannonSolution.getMuzzleVel();
			//System.out.println("Current Angle: " + currentAngle + ", " + "Current Velocity: " + currentMuzzleVel);
			currentRange = Cannon.GetMaxRange(currentAngle, currentMuzzleVel);
			//System.out.println("Current Range: " + currentRange);
			currentFitness = Math.abs(currentRange - targetRange);
			//System.out.println("Current Fitness: " + currentFitness);
			
			CannonSolution.SmallChange();
			
			newAngle = CannonSolution.getAngle();
			newMuzzleVel = CannonSolution.getMuzzleVel();
			//System.out.println("New Angle: " + newAngle + ", " + "New Velocity: " + newMuzzleVel);
			
			newRange = Cannon.GetMaxRange(newAngle, newMuzzleVel);
			//System.out.println("New Range: " + newRange);
			
			newFitness = Math.abs(newRange - targetRange);
			
			if (newFitness < currentFitness) 
			{
				currentFitness = newFitness;
			}
			else
			{
				CannonSolution.setValues(currentAngle, currentMuzzleVel);
			}
			double angle = CannonSolution.getAngle();
			double velocity = CannonSolution.getMuzzleVel();
			if (i % 100 == 0) {
				System.out.println(currentFitness);
				//System.out.println("Iteration: " + i + ", Max Fit: " + currentFitness + ", Velocity: " + currentMuzzleVel + ", Angle: " + currentAngle);
			}
			//System.out.println("Iteration: " + i + ", Fitness: " + currentFitness + ", Velocity: " + velocity + ", Angle: " + angle + ", Range: " + Cannon.GetMaxRange(angle, velocity));
			//System.out.println();
		}
	}
	
}
