package DealTests;

import org.junit.Before;
import org.junit.Test;
import parentTests.AbstractParentTests;

public class DealPageTest extends AbstractParentTests {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        Login();
    }

    @Test
    public void addNewDeal(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.selectDealType("Бонус");
        dealPage.selectDealCustomer("QATestLab");
        dealPage.selectDealProvider("ЧП \"Рога и Копыта\"");
        dealPage.selectDealDate(10, "мая", 2020, 14, 12);
        dealPage.clickSubmitButton();
        dealPage.checkDealPageOpen();
        boolean rowDisplayed = dealPage.getIsRowDisplayed(
                "10.05.2020 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        checkExpectedResult("New deal doesn't added", rowDisplayed);
    }

    @Test
    public void editDeal(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.selectDealType("Бонус");
        dealPage.selectDealCustomer("QATestLab");
        dealPage.selectDealProvider("ЧП \"Рога и Копыта\"");
        dealPage.selectDealDate(20, "мая", 2020, 14, 12);
        dealPage.clickSubmitButton();
        dealPage.checkDealPageOpen();
        boolean rowDisplayed = dealPage.getIsRowDisplayed(
                "20.05.2020 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        checkExpectedResult("New deal doesn't added", rowDisplayed);
        dealPage.clickOnDealRow(
                "20.05.2020 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        dealPage.checkDealEditForm();
        dealPage.selectDealDate(20, "авг.", 2018, 14, 12);
        dealPage.clickSaveButton();
        rowDisplayed = dealPage.getIsRowDisplayed(
                "20.08.2018 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        checkExpectedResult("Deal doesn't edit", rowDisplayed);
    }

    @Test
    public void deleteDeal(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.selectDealType("Бонус");
        dealPage.selectDealCustomer("QATestLab");
        dealPage.selectDealProvider("ЧП \"Рога и Копыта\"");
        dealPage.selectDealDate(23, "мая", 2020, 14, 12);
        dealPage.clickSubmitButton();
        dealPage.checkDealPageOpen();
        boolean rowDisplayed = dealPage.getIsRowDisplayed(
                "23.05.2020 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        checkExpectedResult("New deal doesn't added", rowDisplayed);
        dealPage.clickOnDealRow(
                "23.05.2020 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        dealPage.checkDealEditForm();
        dealPage.clickDeleteButton();
        rowDisplayed = dealPage.getIsRowDisplayed(
                "23.05.2020 14:12",
                "Бонус",
                "QATestLab",
                "ЧП \"Рога и Копыта\"");
        checkIsFalse("Deal doesn't deleated", rowDisplayed);
    }

    @Test
    public void addNotFilledDeal(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.clickSubmitButton();
        dealPage.checkPageNotFound();
    }

    @Test
    public void addDealWihtoutDealCustomer(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.selectDealType("Бонус");
        dealPage.selectDealProvider("ЧП \"Рога и Копыта\"");
        dealPage.selectDealDate(10, "мая", 2020, 14, 12);
        dealPage.clickSubmitButton();
        dealPage.checkPageNotFound();
    }

    @Test
    public void addDealWihtoutDealType(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.selectDealCustomer("QATestLab");
        dealPage.selectDealProvider("ЧП \"Рога и Копыта\"");
        dealPage.selectDealDate(10, "мая", 2020, 14, 12);
        dealPage.clickSubmitButton();
        dealPage.checkPageNotFound();
    }

    @Test
    public void addDealWihtoutDealProvider(){
        homePage.openDealPage();
        dealPage.checkDealPageOpen();
        dealPage.clickAddButton();
        dealPage.checkDealEditForm();
        dealPage.selectDealType("Бонус");
        dealPage.selectDealCustomer("QATestLab");
        dealPage.selectDealDate(10, "мая", 2020, 14, 12);
        dealPage.clickSubmitButton();
        dealPage.checkPageNotFound();
    }
}
