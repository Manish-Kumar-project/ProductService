package com.ecommerce.ProductService.service.serviceimpl;

import com.ecommerce.ProductService.entities.ProductCatalog;
import com.ecommerce.ProductService.entities.ProductCategory;
import com.ecommerce.ProductService.entities.ProductOverview;
import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import com.ecommerce.ProductService.model.v1.ProductCategoryModel;
import com.ecommerce.ProductService.model.v1.ProductOverviewModel;
import com.ecommerce.ProductService.model.v1.SearchCriteriaBaseModel;
import com.ecommerce.ProductService.repository.ProductCatalogRepository;
import com.ecommerce.ProductService.repository.ProductCategoryRepository;
import com.ecommerce.ProductService.repository.impl.ProductCategoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryImplementation productCategoryImplementation;

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

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
    public void configureProductIndividual(List<ProductCatalog> productCatalogItems){
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

    public SearchCriteriaBaseModel<ProductCategoryModel> getProductCategoriesList() {
        SearchCriteriaBaseModel searchCriteriaBaseModel = new SearchCriteriaBaseModel();
        List<ProductCategoryModel> productCategoryModels = productCategoryImplementation.getProductCategoriesList();
        searchCriteriaBaseModel.setTotalCount((long)productCategoryModels.size());
        searchCriteriaBaseModel.setContent(productCategoryModels);
        return searchCriteriaBaseModel;
    }
    public SearchCriteriaBaseModel<ProductCatalogModel> getProductCatalogList() {
        SearchCriteriaBaseModel searchCriteriaBaseModel = new SearchCriteriaBaseModel();
        List<ProductCatalogModel> productCatalogModels = productCategoryImplementation.getProductCatalogList();
        searchCriteriaBaseModel.setTotalCount((long)productCatalogModels.size());
        searchCriteriaBaseModel.setContent(productCatalogModels);
        return searchCriteriaBaseModel;
    }
    public void updateProductsQuantity(ProductCatalogModel productCatalogModel) {
        ProductCatalog productCatalogModelFromDB = productCatalogRepository.findByProductCatalogUniqueId(productCatalogModel.getProductCatalogUniqueId());
        Integer productUpdateQuantity = productCatalogModelFromDB.getProductCatalogQuantity() - productCatalogModel.getProductCatalogQuantity();
        productCategoryImplementation.updateProductsQuantity(productUpdateQuantity,productCatalogModel.getProductCatalogUniqueId());
    }
    public ProductOverviewModel getProductOverview(Integer productDetailId) {
        return productCategoryImplementation.getProductOverview(productDetailId);
    }
    }