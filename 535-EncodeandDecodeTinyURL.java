package LeetCode;

/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */

import java.util.HashMap;
import java.util.Random;

public class EncodeandDecodeTinyURL {
    HashMap<String, String> hashToUrl = new HashMap<>();
    HashMap<String, String> urlToHash = new HashMap<>();
    String tinyUrlBase = "http://tinyurl.com/";
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random rand = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToHash.containsKey(longUrl)) {
            return tinyUrlBase + urlToHash.get(longUrl);
        }
        StringBuilder s = new StringBuilder();
        do {

            for (int i = 0; i < 6; i++) {
                s.append(characters.charAt(rand.nextInt(characters.length())));
            }
        } while (hashToUrl.containsKey(s.toString()));
        hashToUrl.put(s.toString(), longUrl);
        urlToHash.put(longUrl, s.toString());
        return tinyUrlBase + s.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashToUrl.get(shortUrl.substring(tinyUrlBase.length()));
    }
}
