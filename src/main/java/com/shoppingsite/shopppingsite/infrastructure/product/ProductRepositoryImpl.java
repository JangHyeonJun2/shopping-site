package com.shoppingsite.shopppingsite.infrastructure.product;

import com.shoppingsite.shopppingsite.domain.product.Product;
import com.shoppingsite.shopppingsite.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    @Override
    public void save(Product product) {
        ProductEntity productEntity = ProductEntity.of(
                product.getName(),
                product.getSize(),
                product.getColor(),
                product.getPrice(),
                product.getStock(),
                product.getImage(),
                product.getDescription()
        );
        productJpaRepository.save(productEntity);
    }

    @Override
    public void saveAll(List<Product> products) {
        List<ProductEntity> productEntities = products.stream()
                .map(product -> ProductEntity.of(
                        product.getName(),
                        product.getSize(),
                        product.getColor(),
                        product.getPrice(),
                        product.getStock(),
                        product.getImage(),
                        product.getDescription()
                ))
                .toList();
        productJpaRepository.saveAll(productEntities);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream()
                .map(ProductEntity::toProduct)
                .toList();
    }
}
