package main.api;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Locale;

public class UserGenerator {
    @Step("Creating User with random data")
    public User random() {return new User(RandomStringUtils.randomAlphanumeric(10).toLowerCase(Locale.ROOT)+"@sparrow.com", RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10));}
}
