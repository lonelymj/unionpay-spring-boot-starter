package com.lgmn.union.pay.starter.domain;

/**
 * 订单信息(全非必传属性)
 */
public class Goods {

    private Long discount;

    private String unit;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Long quantity;

    /**
     * 商品单价（分）
     */
    private Long price;

    /**
     * 商品分类
     */
    private String goodsCategory;

    /**
     * 商品说明
     */
    private String body;

    /**
     * 子商户号
     */
    private String subMerchantId;

    /**
     * 子商户商品总额
     */
    private Integer subOrderAmount;

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public Integer getSubOrderAmount() {
        return subOrderAmount;
    }

    public void setSubOrderAmount(Integer subOrderAmount) {
        this.subOrderAmount = subOrderAmount;
    }
}
