
public class Sky_blue extends Thread {
	private static int elm = 0;
	
	public Sky_blue(int id) {
		 setName("Sky_blue-" + id);
	}

	public static long time = System.currentTimeMillis();

	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+":"+m);
	}
	
	public void run() {
		if(elm==0){
		msg("Princess has arrived and is now cleaning and cooking!");
		msg("Princess is tired and is now going to sleep...");
		try {
			Thread.sleep(2000);
			interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			msg("Princess has been woken up by gnomes");
		}
			elm++;
		}
		msg("Princess Tells her story and how she came...");
		//yield() and sleep() have to be defined in the thread class
		
	}

	
}
