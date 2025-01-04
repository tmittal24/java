package com.regexp.ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Regex2 {
  public static void main(String [] arg) {
    Pattern p = Pattern.compile(arg[0]);
    Matcher m = p.matcher(arg[1]);
    boolean b = false;
    while(b = m.find()) {
      System.out.print(m.start() + m.group());
    }
  }
}
