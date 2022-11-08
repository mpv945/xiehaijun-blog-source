package com.ewancle.githubactions;

import com.ewancle.githubactions.business.BaiduDNSSuBS;

//@SpringBootApplication
public class GithubActionsApplication {

    public static void main(String[] args) {
        //SpringApplication.run(GithubActionsApplication.class, args);
        System.out.println("程序入口启动");
        BaiduDNSSuBS baiduDNSSuBS = new BaiduDNSSuBS();
        baiduDNSSuBS.purgeCache();
    }

}