package controler;

public class Multiplos {

	public String fooBar(int x) {

		String volta = "";

		if (x % 3 == 0) {
			volta = "Foo";
		}

		if (x % 5 == 0) {
			volta += "Bar";
		}
		
		if((x % 5 != 0) && (x % 3 != 0)) {
			volta = Integer.toString(x);
		}
		
		return volta;
	}

}
