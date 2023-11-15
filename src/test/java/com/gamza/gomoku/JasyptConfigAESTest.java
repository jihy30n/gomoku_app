package com.gamza.gomoku;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;

class JasyptConfigAESTest {

    @Test
    void stringEncryptor() {
        String tokenkey = "moullekeyincode256abcd1234efgh56ahdmffodkaghzhem";
        String username = "admin";
        String password = "jihyeon1234";
        System.out.println(jasyptEncoding(tokenkey));
        System.out.println(jasyptEncoding(username));
        System.out.println(jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {

        String key = "qlalfqjsgh";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        pbeEnc.setPassword(key);
        pbeEnc.setIvGenerator(new RandomIvGenerator());
        return pbeEnc.encrypt(value);
    }
}