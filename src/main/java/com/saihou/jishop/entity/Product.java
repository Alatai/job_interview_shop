package com.saihou.jishop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品
 *
 * @author saihou
 * @date 2021/04/19
 */
public class Product implements Serializable {

    private Integer id;

    private String name;

    private String subtitle;

    private Float originalPrice;

    private Float promotePrice;

    private Integer stock;

    private Integer cid; // 分類id

    private Date createdDate;

    private Category category;

    private List<ProductImage> productImages;

    private List<ProductImage> singleImages;

    private List<ProductImage> detailImages;

    private Integer saleCount;

    private Integer reviewCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Float getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(Float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<ProductImage> getSingleImages() {
        return singleImages;
    }

    public void setSingleImages(List<ProductImage> singleImages) {
        this.singleImages = singleImages;
    }

    public List<ProductImage> getDetailImages() {
        return detailImages;
    }

    public void setDetailImages(List<ProductImage> detailImages) {
        this.detailImages = detailImages;
    }
}