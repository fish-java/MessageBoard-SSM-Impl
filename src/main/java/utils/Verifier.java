package utils;

import java.util.regex.Pattern;

public class Verifier {
    public static boolean isValidName(String s){
        // 用户名应该是英文字母+数字，且开头第一个字母必须是英文字母
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]*",s);
    }
}
