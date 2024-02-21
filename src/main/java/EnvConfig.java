import org.apache.commons.lang3.RandomStringUtils;

public class EnvConfig {
        public static final int DEFAULT_TIMEOUT = 10;
        static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
        static final String REGISTER_URL ="https://stellarburgers.nomoreparties.site/register";
        static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
        public static final String PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";
        public static final String ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account";
        public static final String DEFAULT_NAME = "Иван";
        public static final String DEFAULT_EMAIL = RandomStringUtils.randomAlphanumeric(7)+"@yandex.ru";
        public static final String DEFAULT_PASSWORD = RandomStringUtils.randomAlphanumeric(7);
        public static final String INVALID_PASSWORD = RandomStringUtils.randomAlphanumeric(5);

}
