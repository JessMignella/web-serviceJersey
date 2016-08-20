package br.com.fiap.filter;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.StringTokenizer;

public class AuthenticationService {

	public boolean authenticate(String authCredentials){
		if(authCredentials == null){		
			return false;
		}
	 final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
	 String userNameAndPassword = null;
	 
	 byte[] decodeBytes = Base64.getDecoder().decode(encodedUserPassword);
	 try {
		userNameAndPassword = new String(decodeBytes,"UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 final StringTokenizer tokenizer = new StringTokenizer(userNameAndPassword,":");
	 if(tokenizer.countTokens() < 2){
		 return false;
	 }
	 final String username = tokenizer.nextToken();
	 final String password = tokenizer.nextToken();	 
	 boolean authStatus = "fiap".equals(username) && "1234".equals(password);
	 
	 return authStatus;
	}
}
