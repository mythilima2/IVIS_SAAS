package testfile;

import basefile.URL.launching.Dev1v2_URLlaunching_Using_SeleniumJava;
import CSVdatareader.Login_Credentials_CSV_Reader;
import pagefile.login.Login_UsingSeleniumJava;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BasicpomLogin_UsingSeleniumjava extends Dev1v2_URLlaunching_Using_SeleniumJava {
    Login_UsingSeleniumJava loginUsingSeleniumJava;

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() throws IOException {
        String filePath = "CSVdatareader/Credentials.csv"; // Replace with your CSV file path
        List<String[]> credentialsList = Login_Credentials_CSV_Reader.readCredentialsFromCSV(filePath);
        Object[][] credentials = new Object[credentialsList.size()][2];

        for (int i = 0; i < credentialsList.size(); i++) {
            credentials[i][0] = credentialsList.get(i)[0]; // username
            credentials[i][1] = credentialsList.get(i)[1]; // password
        }

        return credentials;
    }
    @Test(priority = 1, dataProvider = "loginCredentials")
    public void testCreateCustomer(String username, String password) {
        loginUsingSeleniumJava = new Login_UsingSeleniumJava(driver);
        loginUsingSeleniumJava.login(username, password);
    }
//    @Test
//    public void Login(){
//        loginUsingSeleniumJava=new Login_UsingSeleniumJava(driver);
//        loginUsingSeleniumJava.login("veera.rangina@motivitylabs.com", "Ivis@123");
//
//    }
}
