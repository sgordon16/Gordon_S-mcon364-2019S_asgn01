
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		String name = null;
		String bday;
		String email;
		String url;
		ArrayList<String> urls = new ArrayList<String>();
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter Your name");
		name = kb.nextLine(); 
		/*
		 * name matches a first name that starts with a capital letter followed by a period or any number of lower case letters
		 * the same is for the last name. It can include any number of middle initials capitalized followed by a period
		 * The first name, middle initial(s) and last name are in separate groups
		 */
		System.out.println(name.matches("^([A-Z]([a-z]+|.)) (([A-Z]. )*)([A-Z][a-z]+)$") ? "Valid" : "Invalid");
		
		System.out.println("Enter Your birthday");
		bday = kb.nextLine();
		/*
		 * bday matches a month spelled out or its abbreviation followed by a period 
		 * followed by the day which is within that month's range 
		 * (1-30, or 1-31, or 1-29 for February (it does not check for leap years))
		 * followed by a comma, space and 4 digit year. Or mm/dd/yyyy format also checking for valid months and days.
		 */
		System.out.println(bday.matches("^((((Jan(uary|.)|Mar(ch|.)|May|Jul(y|.)|Aug(ust|.)|Oct(ober|.)|Dec(ember|.)) "
				+ "([1-9]|(([1-2][0-9])|(3[0-1]))))|(Apr(il|.)|Jun(e|.)|Sep(tember|.)|Nov(ember|.) "
				+ "([1-9]|(([1-2][0-9])|30)))|(Feb(ruary|.) ([1-9]|([1-2][0-9]))), )|"
				+ "(((0(1|3|5|7|8)|1(0|2))\\/([0-2][1-9]|3[0-1]))|((0(4|6|9)|11)\\/([0-2][1-9]|30))|"
				+ "(2|\\/[0-2][1-9]))\\/)\\d{4}$") ? "Valid" : "Invalid");
		
		System.out.println("Enter Your email");
		email = kb.nextLine();
		/*
		 * email matches one or more word characters before the @ (covers most cases) 
		 * followed by an @, followed by one or more groups 
		 * of one or more word characters followed by a period, followed by a TLD restricted to the main ones 
		 * or any country code (either one or two codes for example .co or .co.il)
		 * then it can have optionally sub directories  
		 */
		System.out.println(email.matches("^\\w+@(\\w+\\.)+(com|gov|net|org|edu|([a-z]{2}(\\.[a-z]{2})?))$") ? "Valid" : "Invalid");
		
		System.out.println("Enter your 10 top favorite web pages");
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + ": ");
			url = kb.nextLine();
			/*
			 * url matches http with an optional s followed by ://www. 
			 * followed by one or more word characters followed by a TLD restricted to the main ones 
		     * or any country code (either one or two codes for example .co or .co.il)
		     * followed by an optional / followed by optional sub-directories 
		     * that can include any characters
			 */
			if(url.matches("^https?://w{3}\\.\\w+\\.(com|gov|net|org|edu|([a-z]{2}(\\.[a-z]{2})?))\\/?(.+)*$")) {
				urls.add(url);
			}
			else {
				System.out.println("Invalid url");
				i--;
			}
			
		}
		//matches any url that contains com, edu or co.il
		urls.stream().filter(s -> s.matches(".*(com|edu|co\\.il).*")).forEach(System.out::println);
	}
}

