package algorithm.rate_limt;

import com.google.common.util.concurrent.RateLimiter;

/***
 *
 * 令牌桶算法示例
 *
 */
public class RateLimiterGuava {

    public static void main(String[] args) {

        //创建一个桶容量为5，并且每秒增加5个令牌，也就是每200ms放入一个令牌
        RateLimiter limiter=RateLimiter.create(5);

        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());


    }

}
