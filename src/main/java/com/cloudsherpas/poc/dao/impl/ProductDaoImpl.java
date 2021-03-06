package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.ProductDao;
import com.cloudsherpas.poc.model.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public void increaseStock(final Long key, final int quantity) {
        final Product product = get(key);
        product.setStock(product.getStock() + quantity);
    }

    @Override
    public void decreaseStock(final Long key, final int quantity) {
        final Product product = get(key);
        product.setStock(product.getStock() - quantity);
    }
}
