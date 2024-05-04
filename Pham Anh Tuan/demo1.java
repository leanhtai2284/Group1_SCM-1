package Demo;
import java.util.*;

class Bike{
	int speedlimit = 90;
}
class Honda extends Bike{
	int speedlimit = 150;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Bike obj = new Honda();
       
       System.out.println(obj.speedlimit);
	}

}
