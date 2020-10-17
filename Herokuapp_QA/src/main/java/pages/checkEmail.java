package pages;

import java.util.regex.Pattern;

public class checkEmail {

	public static void main(String[] args) {
		String email = "@g.m";
		System.out.println(checkEmailFormat(email));
	}

	public static boolean checkEmailFormat(String email) {
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        }
		return true;
	}
}
