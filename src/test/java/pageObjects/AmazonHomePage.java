package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage
{

	public AmazonHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement txtSearch;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//span[@class='a-price-whole']")
	WebElement price;
	
	public void setSearch()
	{
		txtSearch.sendKeys("iPhone XR (64GB) - Yellow");
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
	
	public String getPrice()
	{
		try
		{
		return(price.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
