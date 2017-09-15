package monster.controller;

import monster.model.MarshmallowMonster;

public class MonsterController 
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Scary", 8, 7, 5, true);
	}
}
