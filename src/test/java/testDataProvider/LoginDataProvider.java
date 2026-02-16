package testDataProvider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {

        return new Object[][] {
            { "ayush0202@mail.com", "Test@12345", "Ayush Yadav" },
            { "ayush0202@mail.com", "wrongPass", null },
            { "wrong@mail.com", "Test@12345", null }
        };
    }
}
