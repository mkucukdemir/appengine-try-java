/*
 * Copyright 2017 mkucukdemir.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smallfe.clerk.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Cryptographic functions are defined.
 * @author mkucukdemir
 */
public class CryptoUtils {
  
  public static final Map<String, String> ALPHABETS;
    static
    {
        ALPHABETS = new HashMap<String, String>();
        ALPHABETS.put("TR", "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ");
        ALPHABETS.put("EN", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
  
  /**
   * Decrypts certain encrypted text.
   * @param cipherText encrypted message.
   * @param magicNumber the number of places that the alphabet shifted down.
   * @param alphabet .
   * @return decrypted (plain) text.
   */
  public static String decrypt(String cipherText, int magicNumber, String alphabet){
    int charIndexInCipher,shift;
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < cipherText.length(); j++) {
      charIndexInCipher = ALPHABETS.get(alphabet).indexOf(cipherText.charAt(j));
      if(charIndexInCipher == -1){
        sb.append(cipherText.charAt(j));
      }
      else{
        shift = (charIndexInCipher+(29-(magicNumber%29)))%29;
        sb.append(ALPHABETS.get(alphabet).charAt(shift));
      }
    }
    try {
      return sb.toString();
    }catch (NullPointerException ex){
      return null;
    }
  }
  
  /**
   * Encrypts certain encrypted text.
   * @param plainText the message.
   * @param magicNumber the number of places that the alphabet shifted down.
   * * @param alphabet .
   * @return encrypted (cipher) text.
   */
  public static String encrypt(String plainText, int magicNumber, String alphabet){
    int charIndexInPlain,shift;
    StringBuilder sb=new StringBuilder();
    for (int j = 0; j < plainText.length(); j++) {
      charIndexInPlain = ALPHABETS.get(alphabet).indexOf(plainText.charAt(j));
      if(charIndexInPlain == -1){
        sb.append(plainText.charAt(j));
      }
      else{
        shift = (charIndexInPlain+magicNumber)%29;
        sb.append(ALPHABETS.get(alphabet).charAt(shift));
      }
    }
    try {
      return sb.toString();
    }catch (NullPointerException ex){
      return null;
    }
  }
  
}
