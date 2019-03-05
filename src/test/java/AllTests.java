import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllTests {
        private WebDriver driver;
        private String baseURL;
        private String baseURL1;
        JavascriptExecutor jse;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "\\D:\\mystore\\ChromeWebD\\chromedriver.exe");
        driver = new ChromeDriver();
        baseURL1 = "https://learn.letskodeit.com/p/practice";
        baseURL = "http://automationpractice.com/index.php";
        jse = (JavascriptExecutor) driver;

        //maximize window
        driver.manage().window().maximize();
        //implicate wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() {
       driver.quit();
    }

    @Test
    public void testHoverAndClick() throws Exception {
        driver.get(baseURL1);
        jse.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000);
        WebElement hoverButton = driver.findElement(By.id("mousehover"));
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverButton).perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Top")).click();
    }
    @Test
    public void testPuttingTheProductInTheBagAndPurchasing()throws Exception {
        driver.get(baseURL);
        System.out.println("Site opened");
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contact us'])[1]/following::img[1]")).click();
        jse.executeScript("window.scrollBy(0,700)");
        System.out.println("Scroll down");

        WebElement hoverImg = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverImg).perform();
        System.out.println("Hover over element");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$16.51'])[2]/following::span[1]")).click();
        System.out.println("Clicked on the Add to card");

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$18.51'])" +
                "[2]/following::span[3]")).click();
        System.out.println("Clicked on the \'Proceed to check out 1\'");

        jse.executeScript("window.scrollBy(0,700)");
        System.out.println("Scroll down");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        System.out.println("Clicked on the \'Proceed to check out 2\'");

        driver.findElement(By.id("email")).sendKeys("nobafozey@1shivom.com");
        driver.findElement(By.id("passwd")).sendKeys("123123");
        Thread.sleep(2000);
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("Login successfully");

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='If you would like to add a comment about your order, please write it in the field below.'])[1]/following::span[1]")).click();
        System.out.println("Clicked on the \'Proceed to check out 3\'");
        Thread.sleep(2000);

        driver.findElement(By.id("cgv")).click();
        System.out.println("Clicked on the \'I agree checkbox\'");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(Read the Terms of Service)'])[1]/following::span[1]")).click();
        System.out.println("Clicked on the \'Proceed to check out 4\'");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Pay by check (order processing will be longer)")).click();
        System.out.println("Clicked on the \'Pay by check\'");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dollar'])[1]/following::span[1]")).click();
        System.out.println("Clicked on the \'I confirm my order\'");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Back to orders")).click();
        System.out.println("Clicked on the \'Back to orders\'");
    }
    @Test
    public void testRemovingProductFromTheBasketOnHoverCardButton() throws Exception {
        driver.get(baseURL);
        System.out.println("Site opened");
        jse.executeScript("window.scrollBy(0,700)");
        System.out.println("Scroll down");

        WebElement hoverImg = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverImg).perform();
        System.out.println("Hover over element");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$16.51'])[2]/following::span[1]")).click();
        System.out.println("Clicked on the Add to card");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@title='Continue shopping']//span")).click();
        System.out.println("Clicked on the \"Continue shopping\"");
        Assert.assertEquals("Title is not matching", "My Store".toLowerCase(), driver.getTitle().toLowerCase());
        Thread.sleep(2000);

        WebElement cardButton = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        Actions hoverCardButton = new Actions(driver);
        hoverCardButton.moveToElement(cardButton).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='remove_link']")).click();
        System.out.println("Clicked on the Remove element X button");
        Thread.sleep(2000);

        cardButton.click();
        Thread.sleep(2000);
        System.out.println("Clicked on the Card button");

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Your shopping cart is empty"));
        System.out.println("Shopping cart empty");
    }
    @Test
    public void testRemovingProductFromTheBasketOnOrderMyStore()throws Exception{
        driver.get(baseURL);
        System.out.println("Site opened");
        jse.executeScript("window.scrollBy(0,700)");
        System.out.println("Scroll down");

        WebElement hoverImg = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverImg).perform();
        System.out.println("Hover over element");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$16.51'])[2]/following::span[1]")).click();
        System.out.println("Clicked on the Add to card");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@title='Close window']")).click();
        System.out.println("Close popup");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
        System.out.println("Clicked on the Card button");
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,400)");
        System.out.println("Scroll down");

        driver.findElement(By.className("cart_quantity_delete")).click();
        System.out.println("Clicked on the delete product icon");
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Your shopping cart is empty"));
        System.out.println("Shopping cart empty");
    }
    @Test
    public void testAddingFourProductsToTheBasketAndCheckOut()throws Exception{
        driver.get(baseURL);
        System.out.println("Site opened");
        jse.executeScript("window.scrollBy(0,1200)");
        System.out.println("Scroll down");

        WebElement hoverImg = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line last-line first-item-of-mobile-line']//img[@title='Printed Summer Dress']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverImg).perform();
        System.out.println("Hover over element");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line last-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")).click();
        System.out.println("Clicked on the Add to card first img");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@title='Close window']")).click();
        System.out.println("Close popup");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@title='Women']")).click();
        System.out.println("Clicked on the Women tab");
        Thread.sleep(2000);

        WebElement imgSecond = driver.findElement(By.xpath("//img[@title='Blouse']"));
        Actions hoverImgSecond = new Actions(driver);
        hoverImgSecond.moveToElement(imgSecond).perform();
        System.out.println("Hover over second img");
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,300)");
        System.out.println("Scroll down");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$27.00'])[2]/following::span[1]")).click();
        System.out.println("Added second product");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@title='Close window']")).click();
        System.out.println("Close popup");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        System.out.println("Clicked on the Dresses");
        Thread.sleep(2000);

        WebElement imgThird = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']//div[@class='product-image-container']"));
        Actions hoverImgThird = new Actions(driver);
        hoverImgThird.moveToElement(imgThird).perform();
        System.out.println("Hover over Third img");
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,300)");
        System.out.println("Scroll down");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")).click();
        System.out.println("Added Third product");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@title='Close window']")).click();
        System.out.println("Close popup");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//body[@id='category']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]")).click();
        System.out.println("Clicked on the T-Shirts");
        Thread.sleep(2000);

        WebElement imgTShits = driver.findElement(By.xpath("//div[@class='product-image-container']//a[@title='Faded Short Sleeve T-shirts']"));
        Actions hoverImgTShirts = new Actions(driver);
        hoverImgTShirts.moveToElement(imgTShits).perform();
        System.out.println("Hover over Forth img");
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,300)");
        System.out.println("Scroll down");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        System.out.println("Added Forth product");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@title='Proceed to checkout']//span")).click();
        System.out.println("Proceed to checkout");
        Thread.sleep(2000);

        List <WebElement> prices = driver.findElements(By.xpath("//td[@class='cart_total']/span"));
        double priceSum = 0.0;
        for (WebElement price: prices){
            priceSum = Double.parseDouble(price.getText().substring(1)) + priceSum;
        }
        System.out.println("Price sum is "+priceSum);
        WebElement totalProducts = driver.findElement(By.xpath("//td[@id='total_product']"));
        double totalP = Double.parseDouble(totalProducts.getText().substring(1));
        System.out.println("Total price is "+totalP);
        Assert.assertEquals(totalP, priceSum, 0);
    }
}
