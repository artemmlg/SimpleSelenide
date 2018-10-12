import org.junit.BeforeClass;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public abstract class BaseTest {
    @BeforeClass
    public static void beforeClass() {
        baseUrl = "https://www.spotify.com";
        browser = "Chrome";
    }
}
