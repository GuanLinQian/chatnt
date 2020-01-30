package club.chatnt.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.DigestUtils;

/**
 * 时间:15:25
 * 作者：Maibenben
 **/
public class TestDemo {
    public static void main(String[] args) {


        System.out.println(DigestUtils.md5DigestAsHex("000000".getBytes()));
        System.out.println(RandomStringUtils.random(9,true,true));




    }

}
