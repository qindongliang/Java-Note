package leetcode.medium.math;

import java.util.HashMap;
import java.util.Map;

/***
 *
 *https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * 设计一个算法对长url进行短url的转换
 *
 *
 */
public class TinyURL {


    static final Map<String, String> map = new HashMap<>();
    static final String BASE_HOST = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl=BASE_HOST+longUrl.hashCode();
        map.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
