package com.eatsure.pom;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PaymentsPage extends BasePage {

    public WebDriver driver;

    /***************Web Elements for payment page*************/

    @FindBy(xpath = "//div[@class='App']")
    private WebElement PAYMENTPAGE;
    @FindBy(xpath = "//div[@class='sc-hKwCoD ccfxGk']//p[contains(text(),'Choose Payments')]")
    private WebElement CHOOSEPAYMENTTXT;
    @FindBy(xpath = "//div[@class='sc-gyEloo hlxGDx']//button[contains(text(),'EDIT')]")
    private WebElement EDITLINK;
    @FindBy(xpath = "//div[text()='Pay on Delivery']")
    private WebElement BUTTONCOD;
    @FindBy(xpath = "(//div[starts-with(@class,'sc-iCfLBT cuIvbj')])[7]")
    private WebElement PRODBUTTONCOD;
    @FindBy(xpath = "(//div[starts-with(@class,'sc-iCfLBT cuIvbj')])[5]")
    private WebElement BUTTONCODFORBB;
    @FindBy(xpath = "(//div[starts-with(@class,'sc-iCfLBT kuaxzP')])[6]")
    private WebElement PRODBUTTONCODFORBB;
    @FindBy(xpath = "(//div[starts-with(@class,'sc-iCfLBT cuIvbj')])[1]")
    private WebElement BUTTONWALLET;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div[3]/div/div/div[1]/div[4]/div[2]/div/div/div[3]/div/div[1]/div[8]")
    private WebElement BUTTONNB;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div[3]/div/div/div[1]/div[4]/div[2]/div/div/div[3]/div/div[1]/div[3]")
    private WebElement BUTTONUPI;
    @FindBy(xpath = "//button[@class='sc-egiSv dlUuMp']")
    private WebElement ADDNEWUPIBTN;

    @FindBy(xpath = "//div[@class='sc-bilypg guQsGf']")
    private WebElement UPITEXT;

    @FindBy(xpath = "//input[@placeholder='Enter UPI ID']")
    private WebElement ENTERNEWUPI;
    @FindBy(xpath = "(//div[@class='sc-khQdMy cvNZHN ripple upiWrapper'])[1]")
    private WebElement SAVEDUPIRADIO;
    @FindBy(xpath = "//input[@placeholder='Enter UPI ID']")
    private WebElement ENTERUPI;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div[3]/div/div/div[1]/div[4]/div[2]/div/div/div[3]/div/div[1]/div[7]")
    private WebElement BUTTONCCDC;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div[3]/div/div/div[1]/div[4]/div[2]/div/div/div[3]/div/div[1]/div[4]")
    private WebElement BUTTONSODEXO;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div[3]/div/div/div[1]/div[4]/div[2]/div/div/div[3]/div/div[1]/div[5]")
    private WebElement BUTTONGC;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div[3]/div/div/div[1]/div[4]/div[2]/div/div/div[3]/div/div[1]/div[2]")
    private WebElement BUTTONSIMPL;
    @FindBy(xpath = "//div[@class='sc-khQdMy hkYCPy ripple padding-bottom-0']")
    private WebElement CARDSIMPL;
    @FindBy(xpath = "//div[starts-with(@class,'sc-caiKgP ipNIuR')]")
    private WebElement CARDTXT;
    @FindBy(xpath = "//div[@class='flex-x9ump0-0 byqvew']//button[@class='sc-kDThTU eDyLrU']")
    private WebElement SIMPLLINKPAY;
    @FindBy(xpath = "//input[@id='Cash']")
    private WebElement RADIOBUTTON;
//    @FindBy(xpath = "((//button[@class='sc-furvIG bvCfsX'])[1] | //button[@class='sc-iqsfdx flJKY']|(//button[@class='sc-iqsfdx dzxKMu'])[1])")
    @FindBy(xpath = "//label[@for='Cash']/div[2]/button")
    private WebElement PAYBUTTON;
    @FindBy(xpath = "//input[@id='Paytm']")
    private WebElement PAYTMRADIOBUTTON;
    @FindBy(xpath = "//div[@class='style__Price-kx4xgq-6 gmMvwS']")
    private WebElement CARTAMOUNT;
    @FindBy(xpath = "//*[@id='react-root']/div[3]/div/div/div[2]/div[3]/div[2]/div[3]/div[6]/div[2]/div")
    private WebElement GRANDTOTAL;
    @FindBy(xpath = "//div[@class='sc-hiCivh hVtwzt']")
    private WebElement INSUFFICIENTBALANCEWALLET;
    @FindBy(xpath = "//*[@class='flex-x9ump0-0 byqvew']//button[contains(text(),'LINK & PAY')]")
    private WebElement WALLETLINK;
    @FindBy(xpath = "//*[@class='flex-x9ump0-0 sc-hBURRC eziuzE bfcEnS']")
    private WebElement LINKPAYTMTEXT;
    @FindBy(xpath = "//*[@class='sc-iqsfdx gUvsur']")
    private WebElement CLICKSENDBTN;
    @FindBy(xpath = "//*[@class='sc-bkkfTU dwJSJU']")
    private WebElement WALLETOTPINPUT;
    @FindBy(xpath = "//*[@class='sc-iqsfdx flJKY']")
    private WebElement WALLETLINKSUBMIT;
    @FindBy(xpath = "//div[@class='sc-lbhJmS jwcsds nbTopImage']//img[@alt='AXIS']")
    private WebElement NB_AXISLINK;
    @FindBy(xpath = "//button[starts-with(@class,'sc-egiSv dlUuMp')]")
    private WebElement CCDC_BUTTON;
    @FindBy(xpath = "//div[starts-with(@class,'sc-jUotMc fookfc')]")
    private WebElement CCDCCARD;
    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement CARDNUMBER;
    @FindBy(xpath = "//input[@id='cardName']")
    private WebElement CARDNAME;
    @FindBy(xpath = "//input[@id='expiry_date']")
    private WebElement EXPIRYDATE;
    @FindBy(xpath = "//input[@id='cvv']")
    private WebElement CVV;
    @FindBy(xpath = "//div[@class='sc-khQdMy hkYCPy ripple']")
    private WebElement CARDSODEXO;

    @FindBy(xpath = "//button[@class='sc-egiSv dlUuMp']")
    private WebElement ADDNEWSODEXO;
    @FindBy(xpath = "//div[@class='sc-khQdMy hkYCPy ripple']")
    private WebElement SODEXORADIOBTN;

    @FindBy(xpath = "//input[@id='cardNumberProxy']")
    private WebElement SODEXOCARDENTER;

    @FindBy(xpath = "//input[@id='validity']")
    private WebElement SODEXOENTERVALIDITY;

    @FindBy(xpath = "//input[@id='cvv']")
    private WebElement SODEXOENTERCVV;

    @FindBy(xpath = "//input[@id='ownerName']")
    private WebElement SODEXOENTERNAME;

    @FindBy(xpath = "//button[@class='next active']")
    private WebElement SODEXONEXTBTN;
    @FindBy(xpath = "//input[@class='input-box input-box-sodexo']")
    private WebElement SODEXOPIN;
    @FindBy(xpath = "//div[@id='proceed-to-pay']")
    private WebElement SODEXOPAY;
    @FindBy(xpath = "//img[@class='logo-img sodexo']")
    private WebElement SODEXOLOGO;
    @FindBy(xpath = "//label[@for='Gift Card']")
    private WebElement LABELGC;
    @FindBy(xpath = "//div[@class='sc-jeqYYF roPDR']//input[@type='radio']")
    private WebElement GCRADIOBTN;
    @FindBy(xpath = "//div[@class='sc-bkkfTU bsUaOz']//input[@placeholder='Enter PIN']")
    private WebElement GCPIN;
    @FindBy(xpath = "//button[@class='btn btnd']")
    private WebElement CLICKSUCCESS;

    public PaymentsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    /************ Methods for payments *******************/

    /**
     * Description: Visibility of payment page
     *
     * @param driver
     * @author vivek varma
     */
    public void verifyPaymentPageIsDisplayed(WebDriver driver) throws Exception {

        BasePage.waitUntilPageLoad(driver);
        BasePage.waitForVisibility(driver, PAYMENTPAGE);
        if(PAYMENTPAGE.isDisplayed()) {
            log.info("Payment page is displayed");
        } else {
            log.info("Payment page is not displayed");
        }
    }

    /**
     * Description: verifying the text on payments page
     *
     * @param driver
     * @author vivek varma
     */
    public void verifyChoosePaymentText(WebDriver driver) {

        BasePage.waitForVisibility(driver, CHOOSEPAYMENTTXT);
        Assert.assertEquals("Choose Payments", CHOOSEPAYMENTTXT.getText());
    }

    /**
     * Description: Verifying the edit link on payment page
     *
     * @param driver
     * @author vivek varma
     */

    public void verifyEditLink(WebDriver driver) {

        BasePage.waitForVisibility(driver, EDITLINK);
        Assert.assertTrue(EDITLINK.isDisplayed());


    }

    /************ Cash on delivery *******************/

    /**
     * Description: Clicking on pay on delivery button
     *
     * @param driver
     * @author vivek varma
     */
    public void clickCODButton(WebDriver driver) {

        BasePage.scrollToElement(driver, BUTTONCOD);
        BasePage.isElementClickable(BUTTONCOD, driver);
        BasePage.clickJavaScript(BUTTONCOD, driver);
    }
    
    /**
     * Description: Clicking on pay on delivery button production
     *
     * @param driver
     * @author Vivek Ranjan
     */
    public void clickCODButtonPROD(WebDriver driver) {

        BasePage.scrollToElement(driver, PRODBUTTONCOD);
        BasePage.isElementClickable(PRODBUTTONCOD, driver);
        BasePage.clickJavaScript(PRODBUTTONCOD, driver);
    }
    /**
     * Description: Clicking on pay on delivery button for BB
     *
     * @param driver
     * @author Vivek Ranjan
     */
    public void clickCODButtonforBB(WebDriver driver) {

        BasePage.scrollToElement(driver, BUTTONCODFORBB);
        BasePage.isElementClickable(BUTTONCODFORBB, driver);
        BasePage.clickJavaScript(BUTTONCODFORBB, driver);
    }

    /**
     * Description: Clicking on pay on delivery button for BB PROD
     *
     * @param driver
     * @author Vivek Ranjan
     */
    public void clickCODButtonforBBPROD(WebDriver driver) {

        BasePage.scrollToElement(driver, PRODBUTTONCODFORBB);
        BasePage.isElementClickable(PRODBUTTONCODFORBB, driver);
        BasePage.clickJavaScript(PRODBUTTONCODFORBB, driver);
    }
    
    /**
     * Description: Verifying COD card after clicking on pay on delivery button
     *
     * @param
     * @author vivek varma
     */
    public void verifyCODCard() {

        Assert.assertEquals("Pay on Delivery", CARDTXT.getText());
        Assert.assertTrue(PAYBUTTON.isDisplayed());
    }

    /************ Paytm Wallet *******************/

    /**
     * Description: clicking on wallets button
     *
     * @param driver
     * @author vivek varma
     */
    public void clickWalletButton(WebDriver driver) {

        BasePage.scrollToElement(driver, BUTTONWALLET);
        BasePage.isElementClickable(BUTTONWALLET, driver);
        BasePage.clickJavaScript(BUTTONWALLET, driver);
    }

    /**
     * Description: Verifying wallet and link&pay link after clicking on wallets
     *
     * @param driver
     * @author vivek varma
     */
    public void verifyWalletCard(WebDriver driver) {

        Assert.assertEquals("Select Wallet to pay", CARDTXT.getText());
        BasePage.wait(10);
        if (PAYTMRADIOBUTTON.isDisplayed()) {
            System.out.println("Wallet is linked with sufficient balance");
            BasePage.clickElement(driver, PAYTMRADIOBUTTON);
        } else if (INSUFFICIENTBALANCEWALLET.isDisplayed()) {
            System.out.println("Insufficient Balance. Add money from Paytm App");
        } else if (WALLETLINK.isDisplayed()) {
            System.out.println("By linking your paytm wallet you can directly access your linked cards");
            BasePage.clickElement(driver, WALLETLINK);
            Assert.assertEquals("Link Paytm Account", LINKPAYTMTEXT.getText());
            BasePage.clickElement(driver, CLICKSENDBTN);
            BasePage.sendkeys(WALLETOTPINPUT, "888888", driver);
            BasePage.clickElement(driver, WALLETLINKSUBMIT);
            System.out.println("Wallet is linked with sufficient balance");
            BasePage.clickElement(driver, PAYTMRADIOBUTTON);
            BasePage.wait(10);
        } else {
            System.out.println("Paytm Wallet is not working");
        }
    }

    /************ Net banking *******************/

    /**
     * Description: clicking on Netbanking button
     *
     * @param driver
     * @author vivek varma
     */

    public void clickNetbankingButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.isElementClickable(BUTTONNB, driver);
        BasePage.clickJavaScript(BUTTONNB, driver);
    }

    /**
     * Description: verifyiing Netbanking card after clicking on Netbanking button
     *
     * @param driver
     * @author vivek varma
     */

    public void verifyNBCard(WebDriver driver) {

        Assert.assertEquals("Select Bank", CARDTXT.getText());
        BasePage.wait(10);
        BasePage.moveToElement(driver, NB_AXISLINK);
        BasePage.isElementClickable(NB_AXISLINK, driver);
        BasePage.clickJavaScript(NB_AXISLINK, driver);

    }

    /************ Pay Later - Simpl *******************/

    /**
     * Description: clicking on Paylater button
     *
     * @param driver
     * @author vivek varma
     */

    public void clickSimplButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.moveToElement(driver, BUTTONSIMPL);
        BasePage.isElementClickable(BUTTONSIMPL, driver);
        BasePage.clickJavaScript(BUTTONSIMPL, driver);
    }

    /**
     * Description: Verifyinig Simpl card and linking
     *
     * @param driver
     * @author vivek varma
     */

    public void verifySimplCard(WebDriver driver) {

        if(!SIMPLLINKPAY.isDisplayed()) {
            Assert.assertTrue(CARDSIMPL.isDisplayed());
            BasePage.wait(10);
            BasePage.clickElement(driver, CARDSIMPL);
        } else {
            BasePage.wait(5);
            BasePage.isElementClickable(SIMPLLINKPAY, driver);
            BasePage.clickJavaScript(SIMPLLINKPAY, driver);
        }

    }

    /************ UPI Collect *******************/

    /**
     * Description: clicking on UPI button
     *
     * @param driver
     * @author vivek varma
     */
    public void clickUpiCollectButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.moveToElement(driver, BUTTONUPI);
        BasePage.isElementClickable(BUTTONUPI, driver);
        BasePage.clickJavaScript(BUTTONUPI, driver);
    }

    /**
     * Description: verifying UPI collect card
     *
     * @param driver
     * @author vivek varma
     */

    public void verifyUpiCollectCard(WebDriver driver) throws Exception {

        Assert.assertEquals("Saved UPI", CARDTXT.getText());
        BasePage.wait(10);
        if (SAVEDUPIRADIO.isDisplayed()) {
            BasePage.clickElement(driver, SAVEDUPIRADIO);
        } else {
            BasePage.clickElement(driver, ADDNEWUPIBTN);
            Assert.assertTrue(UPITEXT.isDisplayed());
            ENTERNEWUPI.sendKeys("7220022001@paytm");
        }

    }


    /************ Sodexo *******************/

    /**
     * Description: clicking on sodexo button
     *
     * @param driver
     * @author vivek varma
     */

    public void clickSodexoButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.isElementClickable(BUTTONSODEXO, driver);
        BasePage.clickJavaScript(BUTTONSODEXO, driver);
    }

    /**
     * Description: verifying sodexo card and add new card
     *
     * @param driver
     * @author vivek varma
     */

    public void verifySodexoCard(WebDriver driver) throws InterruptedException {

        Assert.assertEquals("Pay Using Sodexo", CARDTXT.getText());
        BasePage.wait(10);
        BasePage.waitForVisibility(driver, CARDSODEXO, 10);
        Thread.sleep(5000);
        if (SODEXORADIOBTN.isDisplayed()) {
            BasePage.clickElement(driver, SODEXORADIOBTN);
        } else {
            BasePage.clickElement(driver, ADDNEWSODEXO);
            BasePage.waitUntilPageLoad(driver);
            BasePage.waitForVisibility(driver, SODEXOLOGO, 5);
            BasePage.waitForVisibility(driver, SODEXOCARDENTER, 5);
            SODEXOCARDENTER.sendKeys("6375130560343104");
            SODEXOCARDENTER.sendKeys(Keys.TAB);
            SODEXOENTERVALIDITY.sendKeys("0724");
            SODEXOENTERVALIDITY.sendKeys(Keys.TAB);
            SODEXOENTERCVV.sendKeys("729");
            SODEXOENTERCVV.sendKeys(Keys.TAB);
            SODEXOENTERNAME.sendKeys("Automation Test");
            SODEXOENTERNAME.sendKeys(Keys.TAB);
            BasePage.waitForVisibility(driver, SODEXONEXTBTN, 3);
            BasePage.clickElement(driver, SODEXONEXTBTN);
        }
    }

    /**
     * Description: Entering sodexo PIN
     *
     * @param driver
     * @author vivek varma
     */

    public void SodexoEnterPIN(WebDriver driver) {
        BasePage.waitUntilPageLoad(driver);
        BasePage.waitForVisibility(driver, SODEXOLOGO, 5);
        BasePage.waitForVisibility(driver, SODEXOPIN, 5);
        SODEXOPIN.sendKeys("1111");
        BasePage.isElementClickable(SODEXOPAY, driver);
        BasePage.clickJavaScript(SODEXOPAY, driver);
    }

    /************ Credit card *******************/

    /**
     * Description: clicking on cards button
     *
     * @param driver
     * @author vivek varma
     */

    public void clickCCButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.isElementClickable(BUTTONCCDC, driver);
        BasePage.clickJavaScript(BUTTONCCDC, driver);
    }

    /**
     * Description: Verifying credit card mode
     *
     * @param driver
     * @author vivek varma
     */

    public void verifyCCCard(WebDriver driver) {

        Assert.assertEquals("Pay Using Card", CARDTXT.getText());
        BasePage.wait(10);
        BasePage.moveToElement(driver, CCDC_BUTTON);
        BasePage.isElementClickable(CCDC_BUTTON, driver);
        BasePage.clickJavaScript(CCDC_BUTTON, driver);

    }

    /**
     * Description: Adding new credit card
     *
     * @param driver
     * @author vivek varma
     */

    public void AddNewCCCard(WebDriver driver) {

        Assert.assertEquals("Pay Using Card", CARDTXT.getText());
        BasePage.wait(10);
        driver.switchTo().frame("https://sandbox.juspay.in/iframe-element");
        BasePage.waitForVisibility(driver, CARDNUMBER);
        CARDNUMBER.sendKeys("4242424242424242");
        CARDNAME.sendKeys("Automation Test");
        EXPIRYDATE.sendKeys("1230");
        CVV.sendKeys("123");

    }

    /**
     * Description: clicking on success after making the payment with CC/DC/Netbanking
     *
     * @param driver
     * @author vivek varma
     */

    public void clickSuccess(WebDriver driver) {
        BasePage.waitUntilPageLoad(driver);
        BasePage.waitForVisibility(driver, CLICKSUCCESS, 5);
        BasePage.clickJavaScript(CLICKSUCCESS, driver);
    }

    /************ Debit card *******************/

    /**
     * Description: clicking on cards button
     *
     * @param driver
     * @author vivek varma
     */

    public void clickDCButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.isElementClickable(BUTTONCCDC, driver);
        BasePage.clickJavaScript(BUTTONCCDC, driver);
    }

    /**
     * Description: Verifying debit card mode
     *
     * @param driver
     * @author vivek varma
     */

    public void verifyDCCard(WebDriver driver) {

        Assert.assertEquals("Pay Using Card", CARDTXT.getText());
        BasePage.wait(10);
        BasePage.moveToElement(driver, CCDC_BUTTON);
        BasePage.isElementClickable(CCDC_BUTTON, driver);
        BasePage.clickJavaScript(CCDC_BUTTON, driver);

    }

    /**
     * Description: Adding new debit card
     *
     * @param driver
     * @author vivek varma
     */

    public void AddNewDCCard(WebDriver driver) {

        Assert.assertEquals("Pay Using Card", CARDTXT.getText());
        BasePage.wait(10);
        BasePage.waitForVisibility(driver, CCDCCARD);
        CARDNUMBER.sendKeys("4000056655665556");
        CARDNAME.sendKeys("Automation Test");
        EXPIRYDATE.sendKeys("1230");
        CVV.sendKeys("123");

    }

    /************ Gift card *******************/

    /**
     * Description: clicking on gift card button
     *
     * @param driver
     * @author vivek varma
     */

    public void clickGCButton(WebDriver driver) {

        BasePage.scrollbar_down(driver);
        BasePage.isElementClickable(BUTTONGC, driver);
        BasePage.clickJavaScript(BUTTONGC, driver);
    }

    /**
     * Description: Verifying Gift card mode
     *
     * @param driver
     * @author vivek varma
     */

    public void verifyGCCard(WebDriver driver) {

        Assert.assertEquals("Eatsure Gift Card", CARDTXT.getText());
        BasePage.wait(10);
        BasePage.waitForVisibility(driver, LABELGC, 5);
        BasePage.waitForVisibility(driver, GCRADIOBTN, 5);
        BasePage.moveToElement(driver, GCRADIOBTN);
        BasePage.clickJavaScript(GCRADIOBTN, driver);
        GCPIN.sendKeys(Keys.CONTROL + "a");
        GCPIN.sendKeys(Keys.DELETE);
        GCPIN.sendKeys("142326");

    }

    /**
     * Description: Below is the condition for verifying amount on the pay button, cart summary & grand total amount is same
     *
     * @param
     * @author vivek varma
     */
    public void verifyAmount() {

        String PAYBUTTONamt = extractNumeric(PAYBUTTON);
        System.out.println("PAYBUTTONamt" + PAYBUTTONamt);
        String cartamount = extractNumeric(CARTAMOUNT);
        System.out.println("cartamount" + cartamount);
        if (PAYBUTTONamt.equals(cartamount)) {
            System.out.println("Amount is verified");
        } else {
            System.out.println("Amount is not verified");
        }
    }

    /**
     * Description: clicking on pay button to place order
     *
     * @param driver
     * @author vivek varma
     */

    public void clickPayButton(WebDriver driver) {

        BasePage.wait(5);
        BasePage.isElementClickable(PAYBUTTON, driver);
        BasePage.clickJavaScript(PAYBUTTON, driver);

    }

}
