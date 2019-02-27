package com.lgmn.union.pay.starter.autoConfigure;

import com.lgmn.union.pay.starter.properties.UnionPaySarterServiceProperties;
import com.lgmn.union.pay.starter.service.UnionPay_UnifiedOrder_SarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UnionPaySarterServiceProperties.class)
@ConditionalOnClass(UnionPay_UnifiedOrder_SarterService.class)
@ConditionalOnProperty(prefix = "unionPay.service", value = "enabled", matchIfMissing = true)
public class UnionPayStarterAutoConfigure {

    @Autowired
    UnionPaySarterServiceProperties unionPaySarterServiceProperties;

    @Bean
    @ConditionalOnMissingBean(UnionPay_UnifiedOrder_SarterService.class)
    UnionPay_UnifiedOrder_SarterService unionPay_unifiedOrder_sarterService () {
        return new UnionPay_UnifiedOrder_SarterService(unionPaySarterServiceProperties.getMid(),
                                                       unionPaySarterServiceProperties.getTid(),
                                                       unionPaySarterServiceProperties.getInstMid(),
                                                       unionPaySarterServiceProperties.getIsTest(),
                                                       unionPaySarterServiceProperties.getOrderNoPrefix(),
                                                       unionPaySarterServiceProperties.getMsgSrc(),
                                                       unionPaySarterServiceProperties.getMsgType());
    }
}
