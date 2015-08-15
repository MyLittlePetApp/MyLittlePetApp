package br.com.mylittlepet.commons.utils;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CriptografiaUtils {

	private static SecretKey chave;
	private static KeySpec ks;
	private static PBEParameterSpec ps;
	private static final String algorithm = "PBEWithMD5AndDES";
	private static BASE64Encoder enc = new BASE64Encoder();
	private static BASE64Decoder dec = new BASE64Decoder();

	static {

		try {

			SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
			ps = new PBEParameterSpec(new byte[] { 3, 1, 4, 1, 5, 9, 2, 6 }, 20);

			ks = new PBEKeySpec("MYPETAPP".toCharArray());

			chave = skf.generateSecret(ks);
		} catch (java.security.NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		} catch (java.security.spec.InvalidKeySpecException ex) {
			ex.printStackTrace();
		}
	}
	
	public static String criptografarSenha(final String senha) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			sen = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
		}
		return sen;
	}
	
	public static final String criptografar(final String text)
			throws BadPaddingException, NoSuchPaddingException,
			IllegalBlockSizeException, InvalidKeyException,
			NoSuchAlgorithmException, InvalidAlgorithmParameterException {

		final Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, chave, ps);
		
		return enc.encode(cipher.doFinal(text.getBytes()));
	}
	
	public static final String descriptografar(final String text)
			throws BadPaddingException, NoSuchPaddingException,
			IllegalBlockSizeException, InvalidKeyException,
			NoSuchAlgorithmException, InvalidAlgorithmParameterException {

		final Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, chave, ps);
		String ret = null;
		try {
			ret = new String(cipher.doFinal(dec.decodeBuffer(text)));
		} catch (Exception ex) {
		}
		return ret;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(criptografar("14"));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}