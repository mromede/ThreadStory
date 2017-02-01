
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The number of gnomes you want should be entered as argument!");
		//If you want, you can set up an input for the # of gnomes. 
		 
		gnome[] gnome_number = new gnome[Integer.parseInt(args[0])]; 
		for(int i = 0; i < gnome_number.length; i++){
			gnome_number[i] = new gnome(i); //An array of 11 gnomes
			gnome_number[i].start();
		}
	}

}
