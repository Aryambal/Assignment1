package testCases;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AmazonHomePage;
import pageObjects.TargetHomePage;
import testBase.BaseClass;

public class TC_PriceComparison extends BaseClass
{
	
	@Test
	public void priceComparisonTest()
	{

		try
		{
		
		logger.info("----Starting price comparison test-----");
		
		logger.info("Opening Amazon Website");
		driver.get(rb.getString("Amazonurl"));	
		
		AmazonHomePage AHP=new AmazonHomePage(driver);
	
		AHP.setSearch();
		AHP.clickSearch();
		String AmazonPrice=AHP.getPrice();
		System.out.println("Amazon Price in String Format: "+ AmazonPrice);
		
		int AP=Integer.parseInt(AmazonPrice);
		System.out.println("Price in Amazon: "+AP);
		
		driver.switchTo().newWindow(WindowType.TAB);
		logger.info("Opening Target Website");
		driver.get(rb.getString("Targeturl"));
		
		TargetHomePage THP=new TargetHomePage(driver);
		
		THP.setSearch();
		THP.clickSearch();
		String generatedprice=THP.getPrice();
		String TargetPrice=generatedprice.substring(1, 7);	
		System.out.println("Target Price in String Format: "+ TargetPrice);
		
		double TP=Double.parseDouble(TargetPrice);
		System.out.println("Price in Target: "+TP);
		
		if(AP<TP)
		{
			System.out.println("Price is less in Amazon WebSite");
		}
		else
		{
			System.out.println("Price is less in Target Website");
		}
		
		logger.info("test passed");
		
		Assert.assertTrue(true);
	
		}
		catch(Exception e)
		{
			logger.info("test failed");
			Assert.fail();
		}
		logger.info("----Finished price comparison test---");
	}
	
	
	
}
