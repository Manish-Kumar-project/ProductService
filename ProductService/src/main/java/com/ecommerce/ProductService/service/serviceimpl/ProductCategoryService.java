package com.ecommerce.ProductService.service.serviceimpl;

import com.ecommerce.ProductService.entities.ProductCatalog;
import com.ecommerce.ProductService.entities.ProductCategory;
import com.ecommerce.ProductService.entities.ProductOverview;
import com.ecommerce.ProductService.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory saveMember(ProductCategory productCategory) {
        ProductCategory category = new ProductCategory();
        List<ProductCatalog> productCatalogs = new ArrayList<>();
        category.setCategoryUniqueId(productCategory.getCategoryUniqueId());
        category.setCategoryName(productCategory.getCategoryName());
        category.setCategoryQuantity(productCategory.getCategoryQuantity());
        List<ProductCatalog> productCatalogList = new ArrayList<ProductCatalog>();
        for (ProductCatalog productCatalog : productCategory.getProductCatalogs()) {
            ProductCatalog catalog = new ProductCatalog();
            catalog.setProductCatalogName(productCatalog.getProductCatalogName());
            catalog.setProductCatalogType(productCatalog.getProductCatalogType());
            catalog.setProductOverviewDescription(productCatalog.getProductOverviewDescription());
            catalog.setProductCatalogUniqueId(productCatalog.getProductCatalogUniqueId());
            catalog.setProductCatalogQuantity(productCatalog.getProductCatalogQuantity());
            catalog.setIsDiscountAvailableOnCatalog(productCatalog.getIsDiscountAvailableOnCatalog());
            catalog.setProductCategory(category);
            productCatalogs.add(catalog);
            ProductOverview productOverview = new ProductOverview();
            productOverview.setProductName(productCatalog.getProductOverview().getProductName());
            productOverview.setProductPrice(productCatalog.getProductOverview().getProductPrice());
            productOverview.setIsOfferAvailable(productCatalog.getProductOverview().getIsOfferAvailable());
            productOverview.setProductDescription(productCatalog.getProductOverview().getProductDescription());
            productOverview.setProductTax(productCatalog.getProductOverview().getProductTax());
            productOverview.setItemNumber(productCatalog.getProductOverview().getItemNumber());
            productOverview.setProductQuantityToBuy(productCatalog.getProductOverview().getProductQuantityToBuy());
            productOverview.setProductBrand(productCatalog.getProductOverview().getProductBrand());
            productOverview.setProductUniqueId(productCatalog.getProductOverview().getProductUniqueId());
            productOverview.setProductModelNumber(productCatalog.getProductOverview().getProductModelNumber());
            productOverview.setProductModelName(productCatalog.getProductOverview().getProductModelName());
            productOverview.setProductCatalog(catalog);
            catalog.setProductOverview(productOverview);

        }
        category.setProductCatalogs(productCatalogs);
        //    addressRepository.saveAll(addresses);
        productCategoryRepository.save(category);
        return null;
    }

    public void configureProductIndividual(List<ProductCatalog> productCatalogItems) {
        ProductCategory category = new ProductCategory();
        List<ProductCatalog> productCatalogs = new ArrayList<>();
        ProductCategory productCategory = productCategoryRepository.findByCategoryUniqueId(180280008L);

        category.setCategoryUniqueId(productCategory.getCategoryUniqueId());
        category.setCategoryName(productCategory.getCategoryName());
        category.setCategoryQuantity(productCategory.getCategoryQuantity());
        category.setCategoryId(productCategory.getCategoryId());

        for (ProductCatalog productCatalog : productCatalogItems) {
            ProductCatalog catalog = new ProductCatalog();
            catalog.setProductCatalogName(productCatalog.getProductCatalogName());
            catalog.setProductCatalogType(productCatalog.getProductCatalogType());
            catalog.setProductOverviewDescription(productCatalog.getProductOverviewDescription());
            catalog.setProductCatalogUniqueId(productCatalog.getProductCatalogUniqueId());
            catalog.setProductCatalogQuantity(productCatalog.getProductCatalogQuantity());
            catalog.setIsDiscountAvailableOnCatalog(productCatalog.getIsDiscountAvailableOnCatalog());
            catalog.setProductCategory(category);
            productCatalogs.add(catalog);
            ProductOverview productOverview = new ProductOverview();
            productOverview.setProductName(productCatalog.getProductOverview().getProductName());
            productOverview.setProductPrice(productCatalog.getProductOverview().getProductPrice());
            productOverview.setIsOfferAvailable(productCatalog.getProductOverview().getIsOfferAvailable());
            productOverview.setProductDescription(productCatalog.getProductOverview().getProductDescription());
            productOverview.setProductTax(productCatalog.getProductOverview().getProductTax());
            productOverview.setItemNumber(productCatalog.getProductOverview().getItemNumber());
            productOverview.setProductQuantityToBuy(productCatalog.getProductOverview().getProductQuantityToBuy());
            productOverview.setProductBrand(productCatalog.getProductOverview().getProductBrand());
            productOverview.setProductUniqueId(productCatalog.getProductOverview().getProductUniqueId());
            productOverview.setProductModelNumber(productCatalog.getProductOverview().getProductModelNumber());
            productOverview.setProductModelName(productCatalog.getProductOverview().getProductModelName());
            productOverview.setProductCatalog(catalog);
            catalog.setProductOverview(productOverview);

        }
        category.setProductCatalogs(productCatalogs);
        //    addressRepository.saveAll(addresses);
        productCategoryRepository.save(category);
    }

    public List<ProductCategory> getAllProductCategories() {

        List<ProductCategory> categories = productCategoryRepository.findAll();
        if (!categories.isEmpty()) {
            return categories;
        } else {
            return null;
        }
    }

}