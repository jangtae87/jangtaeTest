package com.open.myBoard.common.utile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtile {

	public static String sha1(String data) {
		
		String retVal  = "";
		try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); // 이 부분을 SHA-256, MD5로만 바꿔주면 된다.
            md.update(data.getBytes()); // "세이프123"을 SHA-1으로 변환할 예정!
 
            byte byteData[] = md.digest();
 
            StringBuffer sb = new StringBuffer(); 
            for(int i=0; i<byteData.length; i++) {
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
 
            retVal = sb.toString();
            
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace(); 
        }
		
		return retVal;
	}
}
