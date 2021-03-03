package race;
import javax.swing.JFrame;



public class RaceMain {

	public static void main(String[] args) {
	
		
			
JFrame f = new JFrame("Java Racing");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(1100,550);
f.add(new Road());
f.setVisible(true);


	}
	
}
