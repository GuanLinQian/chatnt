package club.chatnt.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 时间:10:13
 * 作者：Maibenben
 **/
@EnableTransactionManagement
@Configuration
@MapperScan("club.chatnt.mapper")
public class MybatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setDialectType("mysql");

        return paginationInterceptor;
    }
}
