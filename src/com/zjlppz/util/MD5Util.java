package com.zjlppz.util;

/**
 * @创建作者：周健
 * @创建时间：2016-8-16
 * @创建版本：1.0
 * 
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
import java.security.MessageDigest;
//为保证用户信息安全，系统在保存用户信息的时候，务必要将其密码加密保存到数据库。
//需要使用密码的时候，取出数据，解密处理即可。
//避免保存明文密码。

/**
 * getMD5(String origin) 将信息转为md5码
 * 
 * convertMD5(String inStr) 1.将md5码传入可进行加密， 2.将加密后的信息传入可进行解密
 * 
 * 可将信息转译成MD5码，亦可对MD5码加密解密
 */
public class MD5Util {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;

		if (n < 0) {
			n = 256 + n;
		}

		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 生成MD5码
	 * 
	 * @return 返回md5
	 */
	public static String getMD5(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return resultString;
	}

	/**
	 * 1.将md5码传入可进行加密， 2.将加密后的信息传入可进行解密
	 * 
	 * 执行第一次是进行加密 执行第二次是对加密后的信息解密
	 * 
	 * @param inStr
	 * @return
	 */
	public static String convertMD5(String inStr) {
		char[] a = inStr.toCharArray();

		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}

		String s = new String(a);
		return s;
	}

	public static void main(String[] args) {
		String instr = "zj386018";
		System.out.println("生成MD5：" + getMD5(instr));
		System.out.println("加密MD5：" + convertMD5(getMD5(instr)));
		System.out.println("解密:" + convertMD5(convertMD5(getMD5(instr))));
	}

}
