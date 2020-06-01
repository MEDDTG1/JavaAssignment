package passignment;

import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args) 
	{
		ArrayList<Cars> cars = new ArrayList<Cars>();
		ReaderApp.load(cars);
		
		CarsGUI gui = new CarsGUI(cars);
		gui.setVisible(true);
	}
}
