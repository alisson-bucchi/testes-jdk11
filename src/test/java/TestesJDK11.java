import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesJDK11 {
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {

        System.setProperty("hudson.model.DirectoryBrowserSupport.CSP"," ")

        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        //WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.get("https://demo.cc360.dxnet.io/search360/search360");
        driver.manage().window().maximize();

        Thread.sleep(5000);
    }

    @Test
    public void Test1() throws InterruptedException {

        WebElement RefInterna = driver.findElement(By.cssSelector("#mat-input-0"));
        RefInterna.sendKeys("1254");

        WebElement agente = driver.findElement(By.cssSelector("#mat-input-1"));
        agente.sendKeys("Alisson Bucchi");

        WebElement emailCliente = driver.findElement(By.cssSelector("#mat-input-2"));
        emailCliente.sendKeys("alisson.t.buchi@gmail.com");

        WebElement telefone = driver.findElement(By.cssSelector("#mat-input-3"));
        telefone.sendKeys("913510050");

        Thread.sleep(3000);

        /**
        File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //Take the screenshot
        FileUtils.copyFile(screenshot2, new File("C:\\Screenshots\\search_images2.png"));
         **/

    }

    //--------------------Select and Choose an option from Linha de Atendimento-------------------

    @Test
    public void Test2() throws InterruptedException {

        driver.findElement(By.cssSelector("#mat-select-0 > .mat-select-trigger")).click();  //click Linha de Atendimento

        driver.findElement(By.cssSelector("#mat-option-6 > .mat-option-text")).click(); //select option into Linha de Atendimento box. Option: Whatsapp

        //mat-options: 0 - Tudo, 5 - Telegram, 6 - Whatsapp, 7 - Chat, 8 - Email_1, 9 - Voice.


        //--------------------Select and choose an option from Categoria--------------------

        driver.findElement(By.cssSelector("#mat-select-1 .mat-select-arrow-wrapper")).click();

        driver.findElement(By.cssSelector("#mat-option-34 > .mat-option-text")).click();

        //driver.findElement(By.xpath("//*[@id=\"mat-option-35\"]/span")).click();
        //mat-options: 1 - Tudo, 33 - Lead, 34 - Tema 1, 35 - Tema 1, 36 - Lead, 37 - Tema 2, 38 - New Type, 39 - Support, 40 - Telefone, 41 - Tecnicos.

        //Se selecionar Whatsapp na opção anterior há 2 opções: mat-option-1 - Tudo, mat-option-67 - Lead.


        //--------------------Select and choose an option from Sub-Categoria--------------------

        driver.findElement(By.cssSelector("#mat-select-2 .mat-select-arrow")).click();

        driver.findElement(By.cssSelector("#mat-option-36 > .mat-option-text")).click();

        //driver.findElement(By.xpath("//*[@id=\"mat-option-34\"]/span")).click();
        //mat-options: 2 - Tudo, 42 - informações, 43 - information, 44 - Sub Tema 1, 45 - Sub Tema 1, 46 - ascsfaw, 47 - Information, 48 - Sub Categorya, 49 - Collaboration, 50 - Networking, 51 - Demonstracao, 52 - Sistema de intrusao.

        //Se selecionar Lead na opção anterior há 3 opções: mat-option-1 - Tudo, mat-option-41 - informações, mat-option-42 - Information

        //--------------------Select and choose an option from Motivo--------------------

        driver.findElement(By.cssSelector(".ng-tns-c7-12 .mat-form-field-infix")).click();

        driver.findElement(By.cssSelector("#mat-option-37 > .mat-option-text")).click();

        //driver.findElement(By.xpath("//*[@id=\"mat-option-36\"]/span")).click(); //select Price

        // xpath para opção Lead no Firefox -> /html/body/div[3]/div[2]/div/div/div/mat-option[2]/span

        //--------------------Select and choose an option from Estado--------------------

        driver.findElement(By.cssSelector("#mat-select-4 .mat-select-arrow-wrapper")).click();

        driver.findElement(By.cssSelector("#mat-option-12 > .mat-option-text")).click();

        Thread.sleep(3000);

        //driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click(); //select Resolvido

    }

    //--------------------Selecting a date range--------------------
    @Test
    public void Test3() throws InterruptedException {

        driver.findElement(By.cssSelector("#academy-courses > div:nth-child(2) > div > div:nth-child(3) > mat-form-field.course-search.mat-form-field.ng-tns-c7-16.mat-primary.mat-form-field-type-mat-input.mat-form-field-appearance-outline.mat-form-field-can-float.mat-form-field-should-float.mat-form-field-has-label.ng-untouched.ng-pristine.ng-valid > div > div.mat-form-field-flex > div.mat-form-field-suffix.ng-tns-c7-16.ng-star-inserted > sat-datepicker-toggle > button")).click();  //open calendar

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"sat-datepicker-0\"]/div/sat-month-view/table/tbody/tr[3]/td[5]/div")).click(); //selecting 13th day

        driver.findElement(By.xpath("//*[@id=\"sat-datepicker-0\"]/div/sat-month-view/table/tbody/tr[4]/td[5]/div")).click(); //selecting 20th day

    }

    //-------------------- Selecting buttons: Limpar ou Procurar--------------------
    @After
    public void tearDown() throws InterruptedException {

        //driver.findElement(By.xpath("//*[@id=\"academy-courses\"]/div[2]/div/div[3]/div/button[1]/span")).click(); //Clean button

        driver.findElement(By.xpath("//*[@id=\"academy-courses\"]/div[2]/div/div[3]/div/button[2]/span")).click(); //Search button

        Thread.sleep(5000);

        driver.quit();

    }
}
