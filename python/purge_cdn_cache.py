#!/usr/bin/env python
# coding=utf-8

"""
Python Sdk 示例
"""
from baidusu.openapi3.client.settings import Settings
from baidusu.openapi3.client.su_client_config import SuClientConfig
import os

"""
# 1 系统环境变量参数方式 https://cloud.tencent.com/developer/article/1583622； 
# 2 执行时候传入参数：https://codeantenna.com/a/nlHcwpunGR
"""
env_dist = os.environ

config = SuClientConfig('api.su.baidu.com',
                        env_dist.get('BAIDU_SU_ACCESS_KEY'),
                        os.getenv('BAIDU_SU_SECRET_KEY'),
                        timeout=120)
def purge_cache():
    
    """
    print("BAIDU_SU_ACCESS_KEY :", env_dist.get('BAIDU_SU_ACCESS_KEY')) 
    print("BAIDU_SU_SECRET_KEY :", os.getenv('BAIDU_SU_SECRET_KEY'))
    print("BLOG_DOMAIN :", os.environ.get('BLOG_DOMAIN')) 
    """
    params = {}
    params["domain"] = os.environ.get('BLOG_DOMAIN')
    params["purge_everything"] = True

    result = Settings(config).purge_cache(params)

    print (result)

if __name__ == '__main__':
    purge_cache()