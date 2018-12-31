package net.aionstudios.jdc.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * A class providing utilities for security.
 * 
 * @author Winter Roberts
 *
 */
public class SecurityUtils {
	
	private static final String tokenChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom rnd = new SecureRandom();

	/**
	 * Generates a token of the given length.
	 * 
	 * @param length The length of token to generate.
	 * @return A token.
	 */
	public static String genToken(int length){
	   StringBuilder sb = new StringBuilder(length);
	   for( int i = 0; i < length; i++ ) 
	      sb.append( tokenChars.charAt( rnd.nextInt(tokenChars.length()) ) );
	   return sb.toString();
	}
	
	public static String sha512PasswordHash(String passwordToHash, String salt){
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes(StandardCharsets.UTF_8));
			byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return generatedPassword;
	}

}
