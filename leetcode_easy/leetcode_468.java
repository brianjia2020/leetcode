package leetcode_easy;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_468 {


    @Test
    public void test(){
        System.out.println(validIPAddress("172.16.254.1"));
    }

    public String validIPAddress(String IP) {
        if (IP.endsWith(".") || IP.endsWith(":")) return "Neither";

        if (validIP4(IP)){
            return "IPv4";
        } else if (validIP6(IP)){
            return "IPv6";
        } else{
            return "Neither";
        }

    }

    public boolean validIP4(String IP){

        String[] strings = IP.split("\\.");

        if (strings.length != 4){
            return false;
        } else {
            for (String string: strings){
                if ( string.length() != 1 && string.startsWith("0")) return false;
                try {
                    if (Integer.parseInt(string) > 255 || Integer.parseInt(string) < 0) return false;
                } catch (Exception e){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validIP6(String IP){
        String[] strings = IP.split(":");
        if(strings.length != 8){
            return false;
        } else {
            for (String string: strings){
                if (string.length() > 4 || string.length() == 0) return false;
                if (!string.matches("[abcdefABCEDF0123456789]*")) return false;
            }
        }
        return true;
    }

}
