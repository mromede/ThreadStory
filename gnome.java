import java.util.Random;

public class gnome extends Thread{
	private static boolean doorOpen = false;
	private static int counter = 11;
	Sky_blue p1 = new Sky_blue(2);
	private static int num = 0;
	boolean dinnerOn = true;
	
	public gnome(int id) {
		setName("gnome-" + id);
	}
	
	public static synchronized void reduce(){
		counter--;
	}

	public static synchronized void increase(){
		counter++;
	}
	public static long time = System.currentTimeMillis();

	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+":"+m);
	}

	public void run() {
		if(num==0){
			p1.start();
			//p1.msg("Princess has arrived and is now cleaning and cooking!");
			//num++;
		}
		num++;
		if(num==1){
			//p1.msg("Princess is tired and is now going to sleep...");
			try {
				Sky_blue.sleep(2000);
				//System.out.println("IT WOOOOOOOORKED");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				System.out.println("Princess has been woken up");
			}
			num++;
		}
		msg("Gnome thread has started");
		Random rand = new Random();
		int random = rand.nextInt((800 - 150) + 1) + 150;
		msg("Gnome going to sleep for random time so others can catch up");
		try {
			sleep(random);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!doorOpen){
			if(counter > 0){
				reduce();
				Thread.yield();
			}
			if(counter <= 0){
				doorOpen = true;
			}
		}
		msg("In the house now.");
		msg("waiting for table");
		while(dinnerOn){
			dinnerOn = false;
		}
		msg("rushing to the table to grab food");
		msg("Time to sleep...");
		int randomz = rand.nextInt((900 - 150) + 1) + 150;
		int a = getPriority();
		try {
			sleep(randomz);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPriority(a);
		System.out.println("Dinner over. Going to bed");
		int r = rand.nextInt((900 - 150) + 1) + 150;
		try {
			sleep(r);
			interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			msg("Princess has woken me up");
		} 

		/*if(num==1) {
			p1.interrupt();

			num++;
		}else{
			p1.interrupt();
		}
		*///Can do Thread.sleep()
		//Can send an interrupt
		
	}
	
	public boolean getDoor(){
		return doorOpen;
	}

}
