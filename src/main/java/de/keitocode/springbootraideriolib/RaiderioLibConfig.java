package de.keitocode.springbootraideriolib;

import de.keitocode.springbootraideriolib.service.RaiderioService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan("de.keitocode.springbootraideriolib")
public class RaiderioLibConfig {

    private static final String BASE_URL = "https://raider.io/api/v1";

    @Bean
    public RaiderioLib raiderioLib() {
        return new RaiderioService();
    }

    @Bean 
    public WebClient raiderioClient() {
        var tcpClient = TcpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2_000)
        .doOnConnected(connection ->
            connection.addHandlerLast(new ReadTimeoutHandler(2))
                .addHandlerLast(new WriteTimeoutHandler(2))); 

        return WebClient.builder()
        .baseUrl(BASE_URL)
        .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
        .build();
    }
}