package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.ProductDTO;
import com.cloudsherpas.poc.dto.ProductListDTO;
import com.cloudsherpas.poc.service.ProductService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
public class ProductResource {

    @Autowired
    @Qualifier("productService")
    @Lazy
    private ProductService productService;

    @ApiMethod(
            name = "getProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public ProductDTO getProduct(@Named("productKey") final Long key) {
        return productService.getProduct(key);
    }

    @ApiMethod(
            name = "getAllProducts",
            path = "products/all",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @ApiMethod(
            name = "addProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addProduct(final ProductDTO productDTO) {
        productService.addProduct(productDTO);
    }

    @ApiMethod(
            name = "addProducts",
            path = "products",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addProducts(final ProductListDTO productList) {
        productService.addProducts(productList.getItems());
    }

    @ApiMethod(
            name = "updateProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateProduct(final ProductDTO productDTO) {
        productService.updateProduct(productDTO);
    }

    @ApiMethod(
            name = "updateAllProducts",
            path = "products/all",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateAllProducts(final ProductListDTO productList) {
        productService.updateAllProducts(productList.getItems());
    }

    @ApiMethod(
            name = "deleteProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteProduct(@Named("key") final Long key) {
        productService.deleteProduct(key);
    }
}
