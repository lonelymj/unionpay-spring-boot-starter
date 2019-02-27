# unionpay-spring-boot-starter 银联商务支付 Starter
## 使用教程：下载编译 unionpay-spring-boot-starter
### 1）下载：unionpay-spring-boot-starter
### 2）编译打包：mvn clean install
## 引入项目如下：
    <dependency>
        <groupId>com.lgmn.starter</groupId>
        <artifactId>unionpay-spring-boot-starter</artifactId>
        <version>0.0.1</version>
    </dependency>
 ## 配置yml/properties
# yml 配置方式如下（请严格按照此方式配置）
##### 请注意，请填写真实有效的链接，银联在统一下单的接口收到此字段后，会测试链接是否有效，链接无效的情况会发生不可预估的错误
    unionpay:
      service:
        inst-mid: 机构商户号
        mid: 商户订单号
        tid: 终端号
        is-test: true
        msg-src: 消息来源
        msg-type: 消息类型
        order-no-prefix: 以银商分配的4位系统编号作为订单号的前4位
        notify-url: http://shandian.test.ngrok.pyis.top/choiceCar/api/callback
        key: 秘钥
            
        
## 使用方式
    // 注入 UnionPay_UnifiedOrder_SarterService
    @Autowired
    UnionPay_UnifiedOrder_SarterService unionPay_unifiedOrder_sarterService;
### 基本使用方法如下，仅仅需要传递生成的 32位订单号 与 分单位的金额 即可
    /**
     * 统一下单
     *
     * @param outtradeno  订单号
     * @param totalAmount 金额（分）
     * @return
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    private JSONObject postUnionPay_UnifiedOrde(String outtradeno, Integer totalAmount) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        UnifiedOrderEntity unifiedOrderEntity = new UnifiedOrderEntity();
        unifiedOrderEntity.setMerOrderId(outtradeno);
        unifiedOrderEntity.setTotalAmount(totalAmount);
        JSONObject jsonObject = unionPay_unifiedOrder_sarterService.postUnionPay_UnifiedOrde(unifiedOrderEntity);
        return jsonObject;
    }
    