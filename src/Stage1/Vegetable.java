package Stage1;


public abstract class Vegetable {

	int attackSpeed = 0;
	int attackInterval = 0;
	int necessaryMana = 0;
	String Plants = "";
	String ImageURL = "";
	int bulletNum = 0; 
	
	public abstract void plantiInitialize();
	
	public void instalPlants() {
		//가지고 있는 돈에서 돈을 빼간다
		if(Vegetable_VS_Enemy.mana > necessaryMana) {
			Vegetable_VS_Enemy.mana = Vegetable_VS_Enemy.mana - necessaryMana;	
		}
	}
	
	public abstract void attack();
}
