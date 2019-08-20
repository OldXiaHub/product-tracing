package org.taru.producttracing.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ���ܹ�����
 * @author 
 *
 */
public class SecurityUtl {
	private static String[] hexArray = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

	
	public static String  getMd5String(String  source){
		StringBuilder  sb =new StringBuilder("");
		try {
			MessageDigest   md=MessageDigest.getInstance("md5");
			md.update(source.getBytes());
			byte[] rawBit = md.digest();
			
			for(int i = 0; i<16; i++){
				sb.append(hexArray[rawBit[i]>>>4& 0x0f]);
				sb.append(hexArray[rawBit[i]& 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(SecurityUtl.getMd5String("zhangsan"));
	}
}
