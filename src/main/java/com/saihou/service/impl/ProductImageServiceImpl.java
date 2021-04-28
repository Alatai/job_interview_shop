package com.saihou.service.impl;

import com.saihou.entity.ProductImage;
import com.saihou.mapper.ProductImageMapper;
import com.saihou.query.ProductImageQuery;
import com.saihou.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service("productImageService")
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    @Qualifier("productImageMapper")
    private ProductImageMapper productImageMapper;

    @Override
    public List<ProductImage> findAll() {
        return productImageMapper.findAll();
    }

    @Override
    public ProductImage findById(Integer id) {
        return productImageMapper.findById(id);
    }

    @Override
    public List<ProductImage> findByPid(Integer id) {
        return productImageMapper.findByPid(id);
    }

    @Override
    public List<ProductImage> findByCondition(Integer pid, String type) {
        ProductImageQuery query = new ProductImageQuery();
        query.setPid(pid);
        query.setType(type);

        return productImageMapper.findByCondition(query);
    }

    @Override
    public int insert(ProductImage productImage) {
        return productImageMapper.insert(productImage);
    }

    @Override
    public int update(ProductImage productImage) {
        return productImageMapper.update(productImage);
    }

    @Override
    public int delete(Integer id) {
        return productImageMapper.delete(id);
    }

    @Override
    public void upload(HttpServletRequest request, MultipartFile image, ProductImage productImage) {
        // アップロードパス
        String path;

        // 二つのファイルを用意している
        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType())) {
            path = request.getSession().getServletContext().getRealPath("/image/single");
        } else {
            path = request.getSession().getServletContext().getRealPath("/image/detail");
        }

        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

        // ファイル名を設置する
        String filename = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        try {
            image.transferTo(new File(path, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        productImage.setName(filename);
    }

}
