package main.java;

import org.apache.commons.lang3.RandomStringUtils;

public class EnvConfig {
        public static final int DEFAULT_TIMEOUT = 10;
        static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
        static final String REGISTER_URL ="https://stellarburgers.nomoreparties.site/register";
        static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
        public static final String PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";
        public static final String ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account";
        public static final String DEFAULT_NAME = "Иван";
        public static final String DEFAULT_EMAIL = "ivanov@yandex.ru";
        public static final String DEFAULT_PASSWORD = RandomStringUtils.randomAlphanumeric(7);
        public static final String INVALID_PASSWORD = RandomStringUtils.randomAlphanumeric(5);
        public static final String PHONE_NUMBER_WITHOUT_PLUS = "1234567890000";
        public static final String EXP_DATE = "01.01.2023";
        public static final String WEB_DRIVER_CHROME = "/Users/v.kalishevskaya/Downloads/chromedriver-mac-x64/chromedriver";
        public static final String WEB_DRIVER_FIREFOX = "/Users/v.kalishevskaya/Downloads/geckodriver";

}
