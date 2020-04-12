package com.neusoft.oauth.endpoint;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>token销毁控制器</p>
 * <p>创建日期：2018-01-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
public class RevokeTokenEndpoint {

//    @Resource
//    private RedisTokenStore redisTokenStore;
//
//    @RequestMapping(method = RequestMethod.GET, value = "/oauth/revokeToken")
//    @ResponseBody
//    public AppResponse revokeToken(@Param("access_token") String accessToken) {
//        if (StringUtils.isNotBlank(accessToken)) {
//            redisTokenStore.removeAccessToken(accessToken);
//            return AppResponse.builder().code(AppResponseStatus.SUCCESS).msg("注销成功").build();
//        }
//        return AppResponse.builder().code(AppResponseStatus.ERROR).msg("access_token is not empty").build();
//    }
}
