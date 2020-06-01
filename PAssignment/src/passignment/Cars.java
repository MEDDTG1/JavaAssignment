package passignment;

public class Cars implements Comparable<Cars> {
	private String carName;
	private String origin;
	private String price;
	private String type;
	private String driveTrain;
	private String transmission;
	private String weight;
	
	public Cars(String carName, String origin, String price, String type, String driveTrain, String transmission, String weight) {
		this.carName = carName;
		this.origin = origin;
		this.price = price;
		this.type = type;
		this.driveTrain = driveTrain;
		this.transmission = transmission;
		this.weight = weight;
	}
	
	public void setcarName(String carName) {this.carName = carName;}
	public void setorigin(String origin) {this.origin = origin;}
	public void setprice(String price) {this.price = price;}
	public void settype(String type) {this.type = type;}
	public void setdriveTrain(String driveTrain) {this.driveTrain = driveTrain;}
	public void settransmission(String transmission) {this.transmission = transmission;}
	public void setweight(String weight) {this.weight = weight;}
	
	public String getcarName(){ return carName;}
	public String getorigin(){ return origin;}
	public String getprice(){ return price;}
	public String gettype(){ return type;}
	public String getdriveTrain(){ return driveTrain;}
	public String gettransmission(){ return transmission;}
	public String getweight(){ return weight;}
	
	public String toString(){
        return carName +" "+origin +" "+price+" "+type +" "+driveTrain +" "+transmission +" "+weight;
        }
		
	@Override
    public int compareTo(Cars car1) {
        // Set Natural sort order
        return carName.compareTo(car1.getcarName());
	}
}
