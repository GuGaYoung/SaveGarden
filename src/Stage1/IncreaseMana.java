package Stage1;


public class IncreaseMana extends Thread{
	
	//일정시간마다 마나의 수를 증가시키는 쓰레드
	boolean running = true;
	
	@Override
	public synchronized void run() {
		
		while (running) {
			try {
				Vegetable_VS_Enemy.mana++;
				Vegetable_VS_Enemy.manaText.setText("마나 : " + Vegetable_VS_Enemy.mana);
				
				Thread.sleep(500);

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}

}
