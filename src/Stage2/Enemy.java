package Stage2;

public abstract class Enemy {
	
	int strength = 0;
	int speed = 0;
	int attackPower = 0;
	int attackInterval = 0;
	String enemyKind = "";
	String ImageURL = "";
	
	public abstract void enemyInitialize();
	
}
