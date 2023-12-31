package com.liao.template.spring2.core.constant;

public interface BaseConstants {


    /**
     * 版本
     */
    String VERSION = "2.0.0.RELEASE";

    /**
     * 基础成功码
     */
    Integer BASIC_SUCCESS_CODE = 8000000;
    /**
     * 基础失败码
     */
    Integer BASIC_ERROR_CODE = -8000000;


    /**
     * localIp
     */
    String LOCAL_IP = "127.0.0.1";


    /**
     * 默认邮箱发送人
     */
    String DEFAULT_MAIL_FROM = "mailadmin@ecidi.com";


    /**
     * 测试用户名
     */
    String TEST = "test";

    /**
     * 测试用户姓名
     */
    String TEST_NAME = "测试用户";


    /**
     * 系统用户
     */
    String SYSTEM = "system";

    /**
     * 系统用户姓名
     */
    String SYSTEM_NAME = "系统用户";


    /**
     * 默认clientId
     */
    String DEFAULT_CLIENT_ID = "fawkes";

    /**
     * 默认clientName
     */
    String DEFAULT_CLIENT_NAME = "凤翎";

    /**
     * 默认租户
     */
    Integer DEFAULT_TENANT_ID = 100000;


    /**
     * 会话
     */
    String FAWKES_SESSION_NAME = "fawkes-session-n";


    /**
     * 开发环境
     */
    String DEV_CODE = "dev";
    /**
     * 生产环境
     */
    String PROD_CODE = "prod";
    /**
     * 测试环境
     */
    String TEST_CODE = "test";
    /**
     * 基础包路径
     */
    String BASE_PACKAGES = "com.fawkes";
    /**
     * 超级管理员
     */
    String SUPER_ADMIN = "fawkes";

}
