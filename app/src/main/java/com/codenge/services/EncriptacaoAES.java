package com.codenge.services;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class EncriptacaoAES {

    private static final String ALGORITMO = "AES";
    private static final String CHAVE = "CDD8B293AC87380E20E1CF33B5239A67";

    public static String encriptar(String texto) throws Exception {
        SecretKeySpec chaveSpec = new SecretKeySpec(CHAVE.getBytes(), ALGORITMO);
        Cipher cifra = Cipher.getInstance(ALGORITMO);
        cifra.init(Cipher.ENCRYPT_MODE, chaveSpec);
        byte[] bytesEncriptados = cifra.doFinal(texto.getBytes());
        return Base64.encodeToString(bytesEncriptados, Base64.DEFAULT);
    }

    public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec chaveSpec = new SecretKeySpec(CHAVE.getBytes(), ALGORITMO);
        Cipher cifra = Cipher.getInstance(ALGORITMO);
        cifra.init(Cipher.DECRYPT_MODE, chaveSpec);
        byte[] bytesDecodificados = Base64.decode(textoEncriptado, Base64.DEFAULT);
        byte[] bytesDesencriptados = cifra.doFinal(bytesDecodificados);
        return new String(bytesDesencriptados);
    }

}
