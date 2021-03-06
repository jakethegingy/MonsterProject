package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController 
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	
	public MonsterController() 
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	public void start()
	{
		//boolean finished = true;
		//int count = 0;
		//while(count < 100)
		//{
		//	popup.displayText("" + count);
		//	count++;
		//}
		
		for(int loop = 0; loop < 15; loop += 1)
		{
			popup.displayText("I am looping " + (loop + 1) + " times out of 15!");
		}
		MarshmallowMonster sample = new MarshmallowMonster();
		//System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Jaquabious", 5, 6, 5, true);
		popup.displayText(sample.toString());
		//System.out.println(realMonster);
		//System.out.println("Jaquabious is very hangry. He is going to eat is own tensticle");
		popup.displayText("Jaquabious is very hangry. He is going to eat is own tensticle");
		realMonster.setTentacleAmount(5);
		popup.displayText(realMonster.toString());
		//System.out.println(realMonster);
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
		interactWithTheMonster(realMonster);
	}
	
	private void testList()
	{
		for(int index = 0; index < monsterList.size(); index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What shoul my new name be???");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
		}
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("What should my new name be???");
			current.setName(newName);
			popup.displayText(current.getName());
		}
	}
	
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only integer values are valid " + sample + "is not");
		}
		 return valid;
	}
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " + sampleDouble + " is not.");
		}
		
		return valid;
	}
	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only boolean values are valid: " + sampleBoolean + " is not.");
		}
		
		return valid;
	}
	private void interactWithTheMonster(MarshmallowMonster currentMonster)	
	{	
		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, he has " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		int specialAnswer = 0;
		String unconverted = popup.getResponse("How many do you want to eat?");

		while(!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms?????");
		}
		
		if(isValidInteger(unconverted))
		{
			specialAnswer = Integer.parseInt(unconverted);
		}
		
		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
		consumed = specialAnswer;
		if(consumed < 0)
		{
			popup.displayText(currentMonster.getName() + "You cannot eat a negive ammount silly human");
			//System.out.println("You cannot eat a negative ammount silly human");
		}
		else if(consumed == 0)
		{
			popup.displayText(currentMonster.getName() + "Not that hungry are you?");
			//System.out.println("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			popup.displayText(currentMonster.getName() + "That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
			//System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			//Here I am trying to say that if the value of consumed changes then give the new question. Otherwise dont give the question. 
			//It doesn't quite work for some reason but I think it taught me what i needed it to. 
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
			consumed = myScanner.nextInt();
			while(consumed > 0)
			{
				popup.displayText(currentMonster.getName() + " wants to know what to eat next");
				//System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat");
				popup.displayText(currentMonster.getName() + "suggests arms they have " + currentMonster.getArmCount());
				//System.out.println(currentMonster.getName() + " suggests just a couple, he has " + currentMonster.getArmCount());
				popup.getResponse("How many do you want to eat?");
				//System.out.println("How many do you want to eat?");
				int eyeCount = myScanner.nextInt();
				if(eyeCount == 5)
				{
					popup.displayText(currentMonster.getName() + "Ah!!! I can't see!!! What have you done silly human?");
					//System.out.println("Ah!!! I can't see!!! What have you done silly human");
				}
				else if(eyeCount < 0)
				{
					popup.displayText(currentMonster.getName() + "Silly Human, I can not have a negative quantity of eyes!");
					//System.out.println("Silly Human, I can not have a negative quantity of eyes!");
				}
				else
				{
					currentMonster.setEyeCount(currentMonster.getArmCount() - consumed);
					popup.displayText(currentMonster.getName() + "I now have" + currentMonster.getEyeCount() + " eyes now");
					//System.out.println("I now have" + currentMonster.getEyeCount() + " eyes now.");
				}
			consumed = consumed - 1;
			}
//			else
			{
				popup.displayText(currentMonster.getName() + "I didn't eat anything and thus I am Hangry! I will no longer give you the next question.");
				//System.out.println("I didn't eat anything and thus I am hangry. I will no longer give you the next question.");
			}
		}	
		popup.displayText("Hey look at me!!!");
		String answer = popup.getResponse("How many meals are you eating today");
		System.out.println(answer);
		popup.displayText(answer);
	}
}
