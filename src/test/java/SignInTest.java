import org.example.BaseTest;
import org.example.DatabaseConfig;
import org.example.LoginPage;
import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignInTest extends BaseTest {
    private MainPage mainPage;
    private DatabaseConfig databaseConfig;

    @Before
    public void setOption() {
        mainPage = new MainPage(driver);
        databaseConfig = new DatabaseConfig();
    }

    @Test
    public void testB() {
        LoginPage loginPage = mainPage.clickSignIn();
        String email = databaseConfig.getLastEmail();
        String password = databaseConfig.getLastPassword();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

    }

    @After
    public void afterTest() {

    }
}

