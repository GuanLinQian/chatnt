package club.chatnt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 时间:13:26
 * 作者：Maibenben
 **/
@Configuration
public class WebsocketConfig {

    @Bean
    ServerEndpointExporter serverEndpointExporter(){

        return  new ServerEndpointExporter();
    }
}
