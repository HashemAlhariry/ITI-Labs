
class Arguments {

	public static void main(String[] args) {


		if (args.length == 0) {

			System.out.println("No parameters sent");

		} else {

			int intNumber;
			double doubleNumber;
			char character;

			int index = 0;

			for (; index < args.length; index++) {

				if (isNumeric(args[index])) {
					System.out.println("args [" + index + "] is number = " + args[index]);
				} else if (isFloat(args[index])) {
					System.out.println("args [" + index + "] is float = " + args[index]);
				} else if (args[index].length() > 0) {
					System.out.println("args [" + index + "] is String = " + args[index]);
				} else {
					System.out.println("args [" + index + "] is char = " + args[index]);

				}

			}


		}


	}


	static boolean isNumeric(String string) {
		for(int i = 0 ; i<string.length() ; i++){
			int asciivalue = string.charAt(i);
			if (asciivalue < 48 || asciivalue > 57 ){
				return false;
			}
		}
		return true;
	}

	static boolean isFloat(String string) {
		boolean checkDot=false;
		for(int i = 0 ; i<string.length() ; i++){
			int asciivalue = string.charAt(i);
			if (asciivalue < 46 || asciivalue > 57 || asciivalue == 47 ){
				return false;
			}
		}
		return true;
	}


	/*
	public static boolean isNumeric(String string) {
		int index = 0;
		boolean check = false;
		String regex = "\\d";
		for (; index < string.length(); index++) {
			if (string.substring(index, index + 1).matches(regex)) {
				check = true;
			}
			else {
				return false;
			}
		}
		return check;
	}
	*/

	/*
	public static boolean isFloat(String string) {
		int index = 0;
		boolean check = false;
		boolean checkDot = false;
		String regex = "\\d";
		String regexDot = "\\.";
		for (; index < string.length(); index++) {
			if (string.substring(index, index + 1).matches(regex)) {
				check = true;
			} else if (string.substring(index, index + 1).matches(regexDot)) {
				checkDot = true;
			}

		}
		if (check && checkDot) {
			return true;
		} else {
			return false;
		}
	}
	*/

}


	/*
	public static boolean isNumeric(String string) {
		 try {
			   Integer.parseInt(string);
				return true;
		 } catch (NumberFormatException e) {
				return false;
		  }

	}
	*/

	/*
	public static boolean isFloat(String string) {
  		  int intValue;
		
	 try{
		 Float.parseFloat(string);
				return true;
    	}catch(NumberFormatException e){
    		    return false;
    		}
  	
		}
 	}
 	*/
