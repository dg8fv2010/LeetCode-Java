package LeetCode;

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String rst = "";
        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }
            String tmp = "";
            while (idx < s.length() && s.charAt(idx) != ' ') {
                tmp = s.charAt(idx) + tmp;
                idx++;
            }
            if (!tmp.equals("")) {
                if (rst.equals("")) {
                    rst = tmp;
                } else {
                    rst = rst + " " + tmp;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String a = "Let's take LeetCode contest";
        String b = "  hello world!  ";
        String c = "a good   example";
        String d = " ";
        ReverseWordsinaStringIII solu = new ReverseWordsinaStringIII();
        System.out.println("1:" + solu.reverseWords(" ") + ".");
    }
}
