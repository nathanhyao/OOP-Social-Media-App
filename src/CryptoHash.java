
/***********************************************************************************************************************
 * CryptoHash.java: A little script to encrypt a string so we don't have raw passwords saved.
 *
 * @author Charles Graham
 * @version July 19, 2021
 **********************************************************************************************************************/

public class CryptoHash {
	public static String getHash(String password) {
        //encrypted password will always be 32 digits
	    if (password.length() > 32) { //pad or truncate password as needed
	        password = password.substring(0, 32);
	    } else {
	        for (int i = password.length(); i < 32; i++) {
	            password = "0" + password;
            }
	    }

	    int divisor =  0;
	    for (int i = 0; i < password.length(); i++) {
	        divisor += password.charAt(i);
	    }

	    StringBuilder output = new StringBuilder();
	    for (int i = 0; i < password.length(); i++) {
	        output.append((char) ((((int) password.charAt(i)) * 1000 * i / divisor) % 93 + 33));
	    }

	    return output.toString();
	}
}
