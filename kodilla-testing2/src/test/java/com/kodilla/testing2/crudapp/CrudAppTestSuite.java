package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://medestin.github.io/";
    private WebDriver webDriver;
    private Random generator;

    @Before
    public void initTest(){
        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest(){
        webDriver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudeAppTestCard();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }

    private String createCrudeAppTestCard() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"/v1/tasks/\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"/v1/tasks/\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"/v1/tasks/\")]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = webDriver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = webDriver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement button = webDriver.findElement(By.xpath(XPATH_ADD_BUTTON));
        button.click();

        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        webDriver.navigate().refresh();

        while(!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        String trelloUrl = "https://trello.com/login";
        boolean result = false;

        WebDriver trelloDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        trelloDriver.get(trelloUrl);

        trelloDriver.findElement(By.id("user")).sendKeys("marcinaskawski");
        trelloDriver.findElement(By.id("password")).sendKeys(System.getenv("KUDLATY_PASSWORD"));
        trelloDriver.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        trelloDriver.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[contains(@title,\"Kodilla Application\")]")).size()>0)
                .forEach(WebElement::click);

        Thread.sleep(2000);

        result = trelloDriver.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size()>0;

        trelloDriver.close();

        return result;
    }
}
