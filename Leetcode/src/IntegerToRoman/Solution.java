package IntegerToRoman;

import java.util.LinkedHashMap;

public class Solution {
	// web
    private static LinkedHashMap<Integer, String> numToRoman = new LinkedHashMap<Integer, String>();
    static {
        numToRoman.put(1000, "M");
        numToRoman.put(900, "CM");
        numToRoman.put(500, "D");
        numToRoman.put(400, "CD");
        numToRoman.put(100, "C");
        numToRoman.put(90, "XC");
        numToRoman.put(50, "L");
        numToRoman.put(40, "XL");
        numToRoman.put(10, "X");
        numToRoman.put(9, "IX");
        numToRoman.put(5, "V");
        numToRoman.put(4, "IV");
        numToRoman.put(1, "I");
    }
    public String intToRoman(int num) {
        for (Integer i : numToRoman.keySet()) {
            if (num >= i) {
                return numToRoman.get(i) + intToRoman(num - i);
            }
        }
        return "";
    }
	// mine
    public String intToRomanM(int num) {
        String[][] map = {{"IX","IV","V","I"},
                          {"XC","XL","L","X"},
                          {"CM","CD","D","C"},
                          {"","","","M"}};
                          //9,4,5,1
        StringBuffer ans = new StringBuffer();
        int i = num;
        int count = 1;
        while(i > 0){
            int s = i % 10;
            if(s > 0){
                ans.insert( 0, single(s, count-1, map) );
            }
            i = i / 10;
            count++;
        }
        return ans.toString();
    }
    private StringBuffer single(int num, int i,String[][] map) {
        StringBuffer ans = new StringBuffer();
        if(num == 9){
            ans.append(map[i][0]);
            num -= 9;
        }      
        else if (num == 4) {
            ans.append(map[i][1]);
            num -= 4;
        }
        else if (num >= 5) {
            ans.append(map[i][2]);
            num -= 5;
        }
        while(num>0){
            ans.append(map[i][3]);
            num--;
        }
        return ans;
    }
}
