package com.ecommerce.ProductService.kafka.consumerconfig;

import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ReceiverConfig {



    @Bean
    public ConsumerFactory<String, ProductCatalogModel> userConsumerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configs.put(JsonDeserializer.TRUSTED_PACKAGES, "com.ecommerce.*");
        configs.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, "false");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "producttechie11");
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(ProductCatalogModel.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ProductCatalogModel> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ProductCatalogModel> factory = new ConcurrentKafkaListenerContainerFactory<String, ProductCatalogModel>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }

}
