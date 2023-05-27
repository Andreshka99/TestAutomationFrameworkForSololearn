import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


public class SignInTest extends BaseTest {
    private MainPage mainPage;
    private AccountsRepository accountsRepository;
    private DatabaseConfig databaseConfig;

    @Before
    public void setOption() {
        mainPage = new MainPage(driver);
       // databaseConfig = new DatabaseConfig();
        accountsRepository = new AccountsRepository();
    }

    @Test
    public void testB() {
        LoginPage loginPage = mainPage.clickSignIn();
//        String email = databaseConfig.getLastEmail();
//        String password = databaseConfig.getLastPassword();
//        loginPage.enterEmail(email);
//        loginPage.enterPassword(password);
//        loginPage.clickLoginButton();
        int userId = 1054;

        HashMap<String, String> credentials = accountsRepository.getCredentialsById(userId);
        loginPage.enterEmail(credentials.get("login"));
        loginPage.enterPassword(credentials.get("password"));
        loginPage.clickLoginButton();



    }

    @After
    public void afterTest() {


    }
}

