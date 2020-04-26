package com.xzsd.app.customerme.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customerme.entity.CustomerMe;
import com.xzsd.app.customerme.service.CustomerMeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @author zsx
 * @date 2020/04/24
 */
@RestController
@RequestMapping("clientInformation")
public class CustomerMeController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerMeController.class);

    @Resource
    private CustomerMeService customerMeService;

    /**
     * 修改邀请码
     * @param customerMe
     * @return
     * @author zsx
     * @date 2020/04/24
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateInviteCode(CustomerMe customerMe){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            customerMe.setUserId(userId);
            return customerMeService.updateInviteCode(customerMe);
        }catch (Exception e){
            logger.error("修改邀请码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
