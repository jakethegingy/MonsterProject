package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController 
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Jaquabious", 5, 6, 5, true);
		System.out.println(realMonster);
		System.out.println("Jaquabious is very hangry. He is going to eat is own tensticle");
		realMonster.setTentacleAmount(5);
		System.out.println(realMonster);
		
		interactWithTheMonster(realMonster);
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, he has " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		if(consumed < 0)
		{
			System.out.println("You cannot eat a negative ammount silly human");
		}
		else if(consumed == 0)
		{
			System.out.println("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
			consumed = myScanner.nextInt();
			if(consumed != 6)
			{
				System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat");
				System.out.println(currentMonster.getName() + " suggests just a couple, he has " + currentMonster.getArmCount());
				System.out.println("How many do you want to eat?");
				int eyeCount = myScanner.nextInt();
				if(eyeCount == 5)
				{
					System.out.println("Ah!!! I can't see!!! What have you done silly human");
				}
				else if(eyeCount < 0)
				{
					System.out.println("Silly Human, I can not have a negative quantity of eyes!");
				}
				else
				{
					currentMonster.setEyeCount(currentMonster.getArmCount() - consumed);
					System.out.println("I now have" + currentMonster.getEyeCount() + " eyes now.");
				}
			}
			else
			{
				System.out.println("I didn't eat anything and thus I am hangry. I will no longer give you the next question.");
			}
		}	
	}
}
