package club.chatnt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 时间:13:26
 * 作者：Maibenben
 **/
@Component
public class WebsocketConfig {

    @Bean
    ServerEndpointExporter serverEndpointExporter(){

        return  new ServerEndpointExporter();
    }
}
