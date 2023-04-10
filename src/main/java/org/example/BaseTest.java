package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public  class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp()  {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sololearn.com");
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
           driver.quit();
        }
    }

}
