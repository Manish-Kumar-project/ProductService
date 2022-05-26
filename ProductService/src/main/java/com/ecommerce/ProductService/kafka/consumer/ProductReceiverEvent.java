package com.ecommerce.ProductService.kafka.consumer;

import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import com.ecommerce.ProductService.service.serviceimpl.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiverEvent {


    @Autowired
    private ProductCategoryService productCategoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductReceiverEvent.class);
    ProductCatalogModel productCatalogModel = null;
    @KafkaListener(groupId = "product-techie", topics = "producttechie11", containerFactory = "userKafkaListenerContainerFactory")
    public ProductCatalogModel getProductEvent(ProductCatalogModel productCatalogModelQuantity) {
        productCatalogModel = productCatalogModelQuantity;
        LOGGER.info("Event Receive-------------------------=================="+productCatalogModel);
        System.out.println("Event Received ============================================"+productCatalogModel);
        receiveMessage(productCatalogModelQuantity);
        return productCatalogModel;
    }

    public void receiveMessage(ProductCatalogModel productCatalogModel){
      //  ProductCategoryService productCategoryImplementation = new ProductCategoryService();
        productCategoryService.updateProductsQuantity(productCatalogModel);
    }
}
