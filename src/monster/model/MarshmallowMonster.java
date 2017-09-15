package monster.model;

public class MarshmallowMonster 
{
	//Decloration section
	private String name;
	private int eyeCount;
	private int armCount;
	private double tentacleAmount;
	private boolean hasBloop;

	public MarshmallowMonster()
	{
		//unless we specify values all data members are a zero, false, or null. 
	}
	
	public MarshmallowMonster(String nam, int eyeCount, int arms, double tentacleCount, boolean hasBloop)
	{
		this.name = name;
		this.eyeCount = eyeCount;
		this.armCount = arms;
		this.tentacleAmount = tentacleCount;
		this.hasBloop = hasBloop;
	}
	
	public String toString()
	{
		String description = "Raaaar, I am a dank monster! My name is " + name + ", and I have " + eyeCount;
		description += " eyes and I have " + armCount + " arms, and I have " + tentacleAmount +" tentacles";
		description += " and my bloop existe is " + hasBloop;
		
		return description;
	}
}
