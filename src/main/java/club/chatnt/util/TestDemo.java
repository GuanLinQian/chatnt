package club.chatnt.util;

import org.springframework.util.DigestUtils;

/**
 * 时间:15:25
 * 作者：Maibenben
 **/
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("000000".getBytes()));
    }

}
