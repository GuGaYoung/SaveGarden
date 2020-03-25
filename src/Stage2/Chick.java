package Stage2;


public class Chick extends Animal{

	@Override
	public void animalInitialize() {
		strength = 6;
		speed = 80;
		attackInterval = 700;
		attackPower = 1;
		animalKind = "chick";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\chick.png";
		Minimis.minimisNum++;
		MinimiMove.totalMinimiNum = MinimiMove.totalMinimiNum + Minimis.NUM_OF_MINIMIS;
	}
}
