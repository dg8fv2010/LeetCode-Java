package LeetCode;

/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:

vector<string> decode(string s) {
  //... your code
  return strs;
}


So Machine 1 does:

string encoded_string = encode(strs);


and Machine 2 does:

vector<string> strs2 = decode(encoded_string);


strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */

import java.util.LinkedList;
import java.util.List;

public class EncodeandDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder rst = new StringBuilder();
        for (String s : strs) {
            rst.append(s.length()).append('/').append(s);
        }
        return rst.toString();
    }

    public List<String> decode(String s) {
        List<String> rst = new LinkedList<>();
        int idx = 0;
        while (idx < s.length()) {
            int pos = s.indexOf('/', idx);
            int len = Integer.parseInt(s.substring(idx, pos));
            String tmp = s.substring(pos + 1, pos + 1 + len);
            rst.add(tmp);
            idx = pos + 1 + len;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        EncodeandDecodeStrings solu = new EncodeandDecodeStrings();
        List<String> s = new LinkedList<>();
        s.add("aaa");
        s.add("bbb");
        solu.decode(solu.encode(s));
    }
}
