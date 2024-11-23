package com.keystore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RetrievingFromKeyStore {

	private static final String FILE_PATH = "C:\\Pattabhi\\Learning\\workspace\\java-practice\\aes-tenantid.jck";
	private static final String KEY_STORE_ALIAS = "alpstest";
	private static final String KEY_STORE_PWD = "alpstest";
	private static final char[] KEY_STORE_PWD_CHAR_ARRAY = KEY_STORE_PWD.toCharArray();
	private static final String KEY_STORE_TYPE = "JCEKS";
	private static final String KEY_STORE_ALG = "AES";

	public static void main(String args[]) throws Exception {
		final String secretKeyStr = "ABCDEFGHIJKLMNOPQRSTUVWX";//this is the input from command line args
		storeSecretKey(secretKeyStr);
		retriveSecretKey();
	}

	public static void storeSecretKey(final String secretKeyStr) throws Exception {
		final File file = getFile();
		if (file != null && file.exists()) {
			final FileInputStream fis = new FileInputStream(file);
			// Creating the KeyStore object
			final KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
			// Loading the the KeyStore object
			keyStore.load(fis, KEY_STORE_PWD_CHAR_ARRAY);

			// Creating the KeyStore.ProtectionParameter object
			final ProtectionParameter protectionParam = new KeyStore.PasswordProtection(KEY_STORE_PWD_CHAR_ARRAY);

			// Creating SecretKey object
			final SecretKey mySecretKey = new SecretKeySpec(secretKeyStr.getBytes(), KEY_STORE_ALG);

			// Creating SecretKeyEntry object
			final SecretKeyEntry secretKeyEntry = new SecretKeyEntry(mySecretKey);
			keyStore.setEntry(KEY_STORE_ALIAS, secretKeyEntry, protectionParam);

			// Storing the KeyStore object
			final FileOutputStream fos = new FileOutputStream(file);
			keyStore.store(fos, KEY_STORE_PWD_CHAR_ARRAY);
		}
	}

	private static File getFile() throws FileNotFoundException {
		return new File(FILE_PATH);
	}

	public static void retriveSecretKey() throws Exception {
		final File file = getFile();
		if (file != null && file.exists()) {
			// Loading the the KeyStore object
			final FileInputStream fis = new FileInputStream(file);
			// Creating the KeyStore object
			final KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
			keyStore.load(fis, KEY_STORE_PWD_CHAR_ARRAY);

			// Creating the KeyStore.ProtectionParameter object
			final ProtectionParameter protectionParam = new KeyStore.PasswordProtection(KEY_STORE_PWD_CHAR_ARRAY);

			// Creating the KeyStore.SecretKeyEntry object
			final SecretKeyEntry secretKeyEnt = (SecretKeyEntry) keyStore.getEntry(KEY_STORE_ALIAS, protectionParam);
			// Creating SecretKey object
			final SecretKey mysecretKey = secretKeyEnt.getSecretKey();
			
			System.out.println("Decrypted secret key : " + decrypt(mysecretKey));
		}
	}

	private static String encrypt(final SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(KEY_STORE_ALG);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(key.getEncoded());
		// return new BASE64Encoder().encode(cipherText);
		return null;
	}

	private static String decrypt(final SecretKey key)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
		Cipher cipher = Cipher.getInstance(KEY_STORE_ALG);
		cipher.init(Cipher.DECRYPT_MODE, key);
		// byte[] plainText = cipher.doFinal(new
		// BASE64Decoder().decodeBuffer(encrypt(key)));
		return null;// new String(plainText);
	}

}