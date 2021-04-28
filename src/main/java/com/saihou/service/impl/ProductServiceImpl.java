package com.saihou.service.impl;

import com.saihou.entity.Category;
import com.saihou.entity.Product;
import com.saihou.entity.ProductImage;
import com.saihou.mapper.ProductMapper;
import com.saihou.service.OrderItemService;
import com.saihou.service.ProductImageService;
import com.saihou.service.ProductService;
import com.saihou.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品
 *
 * @author saihou
 * @date 2021/04/19
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ReviewService reviewService;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findByCid(Integer id) {
        return productMapper.findByCid(id);
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        return productMapper.findByKeyword("%" + keyword + "%");
    }

    @Override
    public int insert(Product product) {
        product.setCreatedDate(new Date());

        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int delete(Integer id) {
        return productMapper.delete(id);
    }

    @Override
    public void fillRows(List<Category> categories) {
        int numberForRow = 4;

        for (Category category : categories) {
            List<Product> products = category.getProducts();
            List<List<Product>> productsByRow = new ArrayList<>();

            for (int i = 0; i < products.size(); i += numberForRow) {
                int size = i + numberForRow;
                size = Math.min(size, products.size());

                List<Product> productsForRow = products.subList(i, size);
                productsByRow.add(productsForRow);
            }

            category.setProductsByRow(productsByRow);
        }
    }

    @Override
    public Product productDetail(Integer id) {
        Product product = findById(id);

        List<ProductImage> singleImages = productImageService.findByCondition(id, ProductImageService.TYPE_SINGLE);
        List<ProductImage> detailImages = productImageService.findByCondition(id, ProductImageService.TYPE_DETAIL);

        product.setSingleImages(singleImages);
        product.setDetailImages(detailImages);

        return product;
    }

    @Override
    public List<Product> getSearchResult(String keyword) {
        List<Product> products = findByKeyword(keyword);

        for (Product product : products) {
            int saleCount = orderItemService.getSaleCount(product.getId());
            int reviewCount = reviewService.getReviewCount(product.getId());

            product.setSaleCount(saleCount);
            product.setReviewCount(reviewCount);
        }

        return products;
    }
}
