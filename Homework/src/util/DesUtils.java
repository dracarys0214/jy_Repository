package util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DesUtils {
	public static void main(String[] args) {
		String key=encode("abcde", key_str);
		System.out.println(key);
	}

	// 密钥
	private static Key key;
	// KEY种子
	private static String key_str;
	// 常量
	public static final String UTF_8 = "UTF-8";
	public static final String DES = "DES";

	// 静态初始化
	static {

	}

	private static void setKey(String string) {
		try {
			key_str = string;
			// KEY 生成器
			KeyGenerator generator = KeyGenerator.getInstance(DES);
			// 初始化,安全随机算子
			generator.init(new SecureRandom(key_str.getBytes(UTF_8)));
			// 生成密钥
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对源字符串加密,返回 BASE64编码后的加密字符串
	 * 
	 * @param source
	 *            源字符串,明文
	 * @return 密文字符串
	 */
	public static String encode(String source, String key_str) {
		setKey(key_str);
		try {
			// 根据编码格式获取字节数组
			byte[] sourceBytes = source.getBytes(UTF_8);
			// DES 加密模式
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 加密后的字节数组
			byte[] encryptSourceBytes = cipher.doFinal(sourceBytes);
			// Base64编码器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			return base64Encoder.encode(encryptSourceBytes);
		} catch (Exception e) {
			// throw 也算是一种 return 路径
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对本工具类 encode() 方法加密后的字符串进行解码/解密
	 * 
	 * @param encrypted
	 *            被加密过的字符串,即密文
	 * @return 明文字符串
	 */
	public static String decode(String encrypted, String mykey) {
		if (!key_str.equals(mykey)) {
			System.err.println("秘钥不对");
			return null;
		}
		// Base64解码器
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			// 先进行base64解码
			byte[] cryptedBytes = base64Decoder.decodeBuffer(encrypted);
			// DES 解密模式
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, key);
			// 解码后的字节数组
			byte[] decryptStrBytes = cipher.doFinal(cryptedBytes);
			// 采用给定编码格式将字节数组变成字符串
			return new String(decryptStrBytes, UTF_8);
		} catch (Exception e) {
			// 这种形式确实适合处理工具类
			throw new RuntimeException(e);
		}
	}
}