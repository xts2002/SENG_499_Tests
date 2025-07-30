
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class UserFunctionTest {
    private WebDriver driver;

    @BeforeAll
    void setUpAll() {
        // No external driver binary needed for SafariDriver.
        // Just ensure Develop → Allow Remote Automation is on.
    }

    @BeforeEach
    void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String username = "tim";
        String user = "qwertmkjh@gmail.com";
        String password = "Soejhsd-2933i";

        //String adminname = "tim_222";
        String admin = "qwertyhfgadmin@gmail.com";
        String admin_password = "Swjdfjks-21343";
    }

    @Test
    @DisplayName("After User Logs in, page displays all user functionalities and is clickable, leads to correct destination")
    public void userFunctionTest() {

    }

    @Test
    @DisplayName("After opening the chatbot, all options are present and user can enter and send messages")
    public void userFunctionTest1() {

    }

    @Test
    @DisplayName("After Opening the Profile Menu, User can enter ONC API, view personal info")
    public void userFunctionTest2() {

    }

    @Test
    @DisplayName("After Opening the Profile Menu, User can change password using the menu given there")
    public void userFunctionTest3() {

    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
