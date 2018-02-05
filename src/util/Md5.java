package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5 {
	// mm1是没有加密的密码
	// newpas 是加密后的代码
	public static String jiami(String mm1) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 校验是否为空
		if (mm1 != null || !"".equals(mm1)) {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			String newpas = base64en.encode(md5.digest(mm1.getBytes("utf-8")));
			return newpas;
		}
		return mm1;
	}
}
