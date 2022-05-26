package com.ecommerce.ProductService.kafka.consumer;

import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiverEvent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductReceiverEvent.class);
    ProductCatalogModel productCatalogModel = null;
    @KafkaListener(groupId = "product-techie", topics = "producttechie11", containerFactory = "userKafkaListenerContainerFactory")
    public ProductCatalogModel getJsonMsgFromTopic(ProductCatalogModel productCatalogModel1) {
        productCatalogModel = productCatalogModel1;
        LOGGER.info("Event Receive-------------------------=================="+productCatalogModel1);
        System.out.println("Event Received ============================================"+productCatalogModel1);
        return productCatalogModel;
    }
}
