package passignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ReaderApp {

	public static void load(ArrayList<Cars> cars) {
		String carName;
		String origin;
		String price;
		String type;
		String driveTrain;
		String transmission;
		String weight;
		String line;
		try {
			BufferedReader in = new BufferedReader (new FileReader("Cars.csv"));
			while ((line = in.readLine()) !=null) {
				String[] fields = line.split(",");
				carName = fields[0];
				origin = fields[1];
				price = fields[2];
				type = fields[3];
				driveTrain = fields[4];
				transmission = fields[5];
				weight = fields[6];
				cars.add(new Cars(carName, origin, price, type, driveTrain, transmission, weight));
			}
		}catch (IOException e) {
            System.out.println("There was a problem with the file");
            e.printStackTrace();
			}
		
		Collections.sort(cars);

        for (Cars item: cars) {
            System.out.println(item);
        }
	}
}
