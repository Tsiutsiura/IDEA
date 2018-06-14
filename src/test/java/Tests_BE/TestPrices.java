package Tests_BE;

import Pages.HomePage;
import Pages.Prices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Yulia.Tsyutsyura on 19.03.2018.
 */
@RunWith(value = Parameterized.class)

public class TestPrices extends GeneralMethods {

    private String doctupe;
    private String subjectArea;
    private String numberOfPages;

    private static StringBuffer verificationErrors = new StringBuffer();

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        {"13", "16", "15" }  //Term Paper
                        //{"143", "18", "17" },    // Admission Services - Scholarship Essay
                        //{"125", "", "16" },    //Multiple Choice Questions (Non-time-framed)
                        //{"51", "112", "14" },    //PowerPoint Presentation
                        //{"82", " ", "5" }           //Programming
                }
        );
    }

    public TestPrices(String doctupe, String subjectArea, String numberOfPages) {
        this.doctupe = doctupe;
        this.subjectArea = subjectArea;
        this.numberOfPages = numberOfPages;
    }

    @Test
    public void testLogin() throws Exception {
        openSite("https://ca.bestessays.com/");
        sleep(2000);
        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getPricesButtonLocator()));
        Prices prices = homePage.goToPricesTable();

        wait.until(ExpectedConditions.visibilityOfElementLocated(prices.getFieldDoctypeLocator()));
        prices.selectDoctype(doctupe);
        if (doctupe != "125" && doctupe != "82"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(prices.getFieldSubjectLocator()));
            prices.selectSubject(subjectArea);
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(prices.getFieldNumberOfPagesLocator()));
        prices.typeNumberOfPages(numberOfPages);


        prices.cklickOnButtonCAD();
        assertEquals ("CAD", prices.findActiveCurrency());
        sleep(1000);
        prices.showPrices();

        prices.cklickOnButtonEUR();
        assertEquals ("EUR", prices.findActiveCurrency());
        wait.until(ExpectedConditions.visibilityOfElementLocated(prices.getPricesLocator()));
        prices.showPrices();

        prices.cklickOnButtonGBP();
        assertEquals ("GBP", prices.findActiveCurrency());
        wait.until(ExpectedConditions.visibilityOfElementLocated(prices.getPricesLocator()));
        prices.showPrices();

        prices.cklickOnButtonUSD();
        assertEquals ("USD", prices.findActiveCurrency());
        wait.until(ExpectedConditions.visibilityOfElementLocated(prices.getPricesLocator()));
        prices.showPrices();

    }
    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.close();
        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
