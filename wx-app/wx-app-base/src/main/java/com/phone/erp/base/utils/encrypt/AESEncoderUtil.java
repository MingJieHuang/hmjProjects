package com.phone.erp.base.utils.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [AES加密解密工具类]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class AESEncoderUtil {
	private static Logger logger = LoggerFactory.getLogger(AESEncoderUtil.class);

	/**
	 * [使用密钥{secretKey}对{content}字符串进行AES加密]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static String encode(String secretKey, String content) {
		try {
			SecretKeySpec skey = new SecretKeySpec(secretKey.getBytes(), "AES");
			// 创建密码器
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.toString().getBytes("utf-8");
			// 初始化密码器
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			byte[] resultByte = cipher.doFinal(byteContent);
			return parseByte2HexStr(resultByte);
		} catch (Exception e) {
			logger.error("使用密钥[" + secretKey + "]对[" + content + "]字符串进行AES加密失败,错误信息:" + e.getMessage());
		}
		return null;
	}

	/**
	 * [使用密钥{secretKey}对{content}字符串进行AES解密]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static String decode(String secretKey, String content) {
		byte[] contentByte = parseHexStr2Byte(content.toString());
		try {
			SecretKeySpec skey = new SecretKeySpec(secretKey.getBytes(), "AES");
			// 创建密码器
			Cipher cipher = Cipher.getInstance("AES");
			// 初始化密码器
			cipher.init(Cipher.DECRYPT_MODE, skey);
			byte[] resultByte = cipher.doFinal(contentByte);
			return new String(resultByte);
		} catch (Exception e) {
			logger.error("使用密钥[" + secretKey + "]对[" + content + "]字符串进行AES解密失败,错误信息:" + e.getMessage());
		}
		return null;
	}

	/**
	 * [将二进制转换成十六进制]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static String parseByte2HexStr(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			String hex = Integer.toHexString(array[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * [将十六进制转换成二进制]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		} else {
			byte[] result = new byte[hexStr.length() / 2];
			for (int i = 0; i < hexStr.length() / 2; i++) {
				int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
				int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
				result[i] = (byte) (high * 16 + low);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(AESEncoderUtil.encode("ERP-WS-SK-YSSOFT", "-9999"));
		System.out.println(AESEncoderUtil.decode("1234567812345687", "16CCEA80A5E729CD709983D425A20135"));
	}
}
