package com.saihou.service;

import com.saihou.entity.ProductImage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
public interface ProductImageService {

    String TYPE_SINGLE = "type_single"; // 商品写真タイプ
    String TYPE_DETAIL = "type_detail"; // 商品写真タイプ

    List<ProductImage> findAll();

    ProductImage findById(Integer id);

    List<ProductImage> findByPid(Integer pid);

    /**
     * 商品id、商品写真タイプを基に、商品写真を検索する
     *
     * @param pid  商品id
     * @param type 商品写真タイプ
     * @return 商品写真リスト
     */
    List<ProductImage> findByCondition(Integer pid, String type);

    int insert(ProductImage productImage);

    int update(ProductImage productImage);

    int delete(Integer id);

    void upload(HttpServletRequest request, MultipartFile image, ProductImage productImage);
}
