package com.tejovat.tims.util;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordUtils
{

  private static final Random RANDOM = new SecureRandom();
  /** Length of password. @see #generateRandomPassword() */
  public static final int PASSWORD_LENGTH = 8;

  public static String generateRandomPassword()
  {
      // Pick from some letters that won't be easily mistaken for each
      // other. So, for example, omit o O and 0, 1 l and L.
      String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

      String pw = "";
      for (int i=0; i<PASSWORD_LENGTH; i++)
      {
          int index = (int)(RANDOM.nextDouble()*letters.length());
          pw += letters.substring(index, index+1);
      }
      return pw;
  }
  
  public static char[] geek_Password(int len)
  {
      System.out.println("Generating password using random() : ");
      System.out.print("Your new password is : ");

      // A strong password has Cap_chars, Lower_chars,
      // numeric value and symbols. So we are using all of
      // them to generate our password
      String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String Small_chars = "abcdefghijklmnopqrstuvwxyz";
      String numbers = "0123456789";
              String symbols = "!@#$%^&*_=+-/.?<>)";


      String values = Capital_chars + Small_chars +
                      numbers + symbols;

      // Using random method
      Random rndm_method = new Random();

      char[] password = new char[len];

      for (int i = 0; i < len; i++)
      {
          // Use of charAt() method : to get character value
          // Use of nextInt() as it is scanning the value as int
          password[i] =
            values.charAt(rndm_method.nextInt(values.length()));

      }
      return password;
  }
}
