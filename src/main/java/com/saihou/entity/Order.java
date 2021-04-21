package com.saihou.entity;

import com.saihou.service.OrderService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * オーダー
 *
 * @author saihou
 * @date 2021/04/20
 */
public class Order implements Serializable {

    private Integer id;

    private String orderCode;

    private String address;

    private String postCode;

    private String receiver;

    private String phoneNumber;

    private String remark;

    private Date createdDate;

    private Date paidDate;

    private Date deliveredDate;

    private Date confirmedDate;

    private Integer uid;

    private String status;

    private Float amount; // 金額

    private Integer number; // 数

    private List<OrderItem> orderItems;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatusDesc() {
        String desc;

        switch (status) {
            case OrderService.WAIT_PAY:
                desc = "待付款";
                break;
            case OrderService.WAIT_DELIVER:
                desc = "待发货";
                break;
            case OrderService.WAIT_CONFIRM:
                desc = "待收货";
                break;
            case OrderService.WAIT_REVIEW:
                desc = "等评价";
                break;
            case OrderService.FINISHED:
                desc = "完成";
                break;
            case OrderService.DELETED:
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }

        return desc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", receiver='" + receiver + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", createdDate=" + createdDate +
                ", paidDate=" + paidDate +
                ", deliveredDate=" + deliveredDate +
                ", confirmedDate=" + confirmedDate +
                ", uid=" + uid +
                ", status='" + status + '\'' +
                '}';
    }
}