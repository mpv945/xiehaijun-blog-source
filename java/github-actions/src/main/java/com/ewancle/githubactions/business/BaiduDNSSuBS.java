package com.ewancle.githubactions.business;

import com.alibaba.fastjson.JSON;
import com.baidu.yunjiasu.openapi.client.Settings;
import com.baidu.yunjiasu.openapi.client.SuClientConfig;
import com.baidu.yunjiasu.openapi.exception.WebBackendException;

import java.util.HashMap;
import java.util.Map;

public class BaiduDNSSuBS {

    public static SuClientConfig SU_CLIENT_CONFIG = null;

    static {
        SU_CLIENT_CONFIG = new SuClientConfig();
        SU_CLIENT_CONFIG.setAccessKey(System.getenv("BAIDU_SU_ACCESS_KEY"));
        SU_CLIENT_CONFIG.setSecretKey(System.getenv("BAIDU_SU_SECRET_KEY"));
        SU_CLIENT_CONFIG.setEndpoint("api.su.baidu.com");
    }

    public void purgeCache(){
        System.out.println("准备开始进入清除阶段");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.name"));
        String value = System.getenv("HOME");
        System.out.println("HOME = "+value);
        
        // 读取操作系统环境变量
        // Map<String, String> osEnv = System.getenv();
        System.getProperties().entrySet().iterator();

        Map<String, Object> params = new HashMap<>();
        params.put("domain", System.getenv("BLOG_DOMAIN"));
        params.put("purge_everything", 1);

        Map<String, Object> result = null;
        try {
            result = new Settings(SU_CLIENT_CONFIG).purgeCache(params);
        } catch (WebBackendException e) {
            throw new RuntimeException(e);
        }
        System.out.println("清除缓存接口返回的信息 = "+ JSON.toJSONString(result));
    }
}
