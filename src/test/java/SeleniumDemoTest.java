import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;


public class SeleniumDemoTest {

    @Test
    public void testGoogle() {
        WebDriver fireFoxDriver = new FirefoxDriver();
        fireFoxDriver.get("https://www.google.com.ua/");

        WebElement field = fireFoxDriver.findElement(By.id("lst-ib"));
        field.sendKeys("test");
        field.sendKeys(Keys.ENTER);

         try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(fireFoxDriver.getCurrentUrl());
        fireFoxDriver.quit();
    }

    @Test
    public void testPrestashop3() {

        WebDriver fireFoxDriver = new FirefoxDriver();
        fireFoxDriver.get ("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=3fcdd4f834562da140ce96fa15d50d31&logout");

        //открытие окна во весь экран
        fireFoxDriver.manage().window().maximize();
        //установка таймаута
        fireFoxDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //как достучатся к элементу
        //WebElement targetElement = driver.findElement (By.cssSelector("#_desktop_user_info"));
        fireFoxDriver.findElement(By.cssSelector("#email")).sendKeys("webinar.test@gmail.com");
        fireFoxDriver.findElement(By.cssSelector("#passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        fireFoxDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block ladda-button']")).click();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       //driver.findElement(By.xpath("//li[@id='subtab-AdminCatalog']")).click;

       /*//Добавляем ожидания для конкретного события, после наведения курсора

        FluentWait wait = new WebDriverWait(driver, 70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#subtab-AdminCategories")));*/

        // Переход по выпадающему списку

        Actions  actions = new Actions(fireFoxDriver);

        /*actions.moveToElement(driver.findElement(By.cssSelector("#subtab-AdminCatalog")))
        .moveToElement(driver.findElement(By.cssSelector("#subtab-AdminCategories")))
        .click().build().perform();*/

        WebElement category = fireFoxDriver.findElement(By.xpath("//li[@id='subtab-AdminCatalog']"));

        //actions.moveToElement(category).perform();
        actions.moveToElement(category).moveToElement(fireFoxDriver.findElement(By.xpath("//li[@id='subtab-AdminCategories']"))).click().perform();

    }

    @Test
    public void testGoogleChrome() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com.ua/");

        WebElement field = chromeDriver.findElement(By.id("lst-ib"));
        field.sendKeys("test");
        field.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(chromeDriver.getTitle());
        chromeDriver.quit();
    }
}
