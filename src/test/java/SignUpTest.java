import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignUpTest extends BaseTest {
    private MainPage mainPage;
    private  String email;
    private  String password;

    @Before
    public void setOption() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void testA()   {
        SignUpPage signUpPage = mainPage.clickRegister();
        email = RandomCredentialsGenerator.generateRandomEmail();
        password = RandomCredentialsGenerator.generateRandomPassword();
        signUpPage.enterEmail(email);
        signUpPage.enterName("Tester123");
        signUpPage.enterPassword(password);
        signUpPage.clickSignUpButton();
    }

    @After
    public void afterTest() {
        if (email != null && password != null) {
            DatabaseConfig databaseConfig = new DatabaseConfig();
            databaseConfig.setEmailAndPassword(email, password);
        }

    }

}
