package com.agony.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ElasticSearch Transport client
 *
 * @author agony
 * @date 2020/4/19 22:10
 */
@Configuration
public class ESConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node1 = new InetSocketTransportAddress(
                InetAddress.getByName("hadoop01"), 9300
        );
        InetSocketTransportAddress node2 = new InetSocketTransportAddress(
                InetAddress.getByName("hadoop02"), 9300
        );
        InetSocketTransportAddress node3 = new InetSocketTransportAddress(
                InetAddress.getByName("hadoop03"), 9300
        );

        Settings settings = Settings.builder()
                .put("cluster.name", "escluster")
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddresses(node1, node2, node3);
        return client;
    }
}
