package mortgagetools;

public class mortgageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mortgage testMortgage = new Mortgage(645685.83, .07375, 4491.12, 347.41, "09/2054");
		
		System.out.print(testMortgage.mortgageInfoToString());
	}

}
