package leetcode_with_name;

public class Integer_to_Roman_12 {

    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"}; // 1000,2000,3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 100,200,300,400...900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 10,20,30,40...90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 1,2,3,4...9
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10]; // 千位数 + 百位数 + 十位数 + 个位数
    }
}
