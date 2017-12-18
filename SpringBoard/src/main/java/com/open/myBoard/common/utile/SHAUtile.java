package com.open.myBoard.common.utile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtile {

	public static String sha1(String data) {
		
		String retVal  = "";
		try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); // �� �κ��� SHA-256, MD5�θ� �ٲ��ָ� �ȴ�.
            md.update(data.getBytes()); // "������123"�� SHA-1���� ��ȯ�� ����!
 
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
