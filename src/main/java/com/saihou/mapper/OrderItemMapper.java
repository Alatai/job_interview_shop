package com.saihou.mapper;

import com.saihou.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * オーダー詳細
 *
 * @author saihou
 * @date 2021/04/20
 */
@Repository("orderItemMapper")
public interface OrderItemMapper {

    List<OrderItem> findAll();

    OrderItem findById(Integer id);

    List<OrderItem> findByOid(Integer oid);

    List<OrderItem> findByUid(Integer uid);

    int insert(OrderItem orderItem);

    int update(OrderItem orderItem);

    int delete(Integer id);
}