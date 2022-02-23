package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP extends SelTestCase {


	
	/////////////////DSS//////////////////
	
	public static void clickAddToCartButton() throws Exception {
		try {
			logs.debug("Click Add To Cart Button ");
			getDriver().findElement(By.cssSelector(PDPSelectors.addToCartButton)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Add To Cart Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void verifyAddToCartLayerIsDisplayed() throws Exception {
		try {
			logs.debug("Verify Add To Cart Layer Is Displayed");
			getDriver().findElement(By.cssSelector(PDPSelectors.addToCartLayer)).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Add To Cart Layer selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void clickProceedToCheckout() throws Exception {
		try {
			logs.debug("Click Proceed To Checkout");
			getDriver().findElement(By.cssSelector(PDPSelectors.proceedToCheckout)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Proceed To Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void clickMiniCartContinueCheckout() throws Exception {
		try {
			logs.debug("Click mini Cart Continue Checkout");
			getDriver().findElement(By.cssSelector(PDPSelectors.miniCartContinueCheckout)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Mini Cart Continue Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void navigteToBundleLandingPage() throws Exception {
		try {
			logs.debug("Navigte To Bundle Landing Page");
			getDriver().findElement(By.partialLinkText(PDPSelectors.budgetBundles)).click();
			getDriver().findElement(By.partialLinkText(PDPSelectors.budgetBundles)).click();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Budget Bundles link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void navigteToRandomBundlePage() throws Exception {
		try {
			logs.debug("Navigte To Bundle Page");
			List<WebElement> items = new ArrayList<WebElement>();
			items = SelectorUtil.getAllElements(PDPSelectors.BundlesLinks);
			items.remove(items.size() - 1);
			logs.debug("WebElement List Size = " + items.size());
			Random random = new Random();
			int index = random.nextInt(items.size() - 1);
			items.get(index).click();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Shop now links for bundle items selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	
	public static String getBundleHeadline() throws Exception {
		try {
			getCurrentFunctionName(true);
			String bundleHeadline = "";
			logs.debug("Get Bundle Headline: ");
			bundleHeadline = getDriver().findElement(By.cssSelector(PDPSelectors.BundleHeadline)).getText().replaceAll(" ", "").trim();
			logs.debug("Bundle Headline: " + bundleHeadline);
			getCurrentFunctionName(false);
			return bundleHeadline;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Headline selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static Double getBundlePrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlePrice = "";
			logs.debug("Get Bundle Price: ");

			BundlePrice = getDriver().findElement(By.cssSelector(PDPSelectors.BundlesPrice)).getText();
			logs.debug("Bundle Price: " + BundlePrice);
			Double BundlePrice2 = Double.parseDouble(BundlePrice.replace('$', ' ').trim());
			logs.debug("Bundle Price: " + BundlePrice);
			getCurrentFunctionName(false);
			return BundlePrice2;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static void clickBundlesAddToCart() throws Exception {
		try {
			logs.debug("Click on bundle Add To Cart");
			getDriver().findElement(By.cssSelector(PDPSelectors.BundlesAddToCart)).click();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button for Bundle selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getQtysInAddToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String QtysInAddToCartButton = "";
			logs.debug("Get Qty In Add To Cart Button: ");
			QtysInAddToCartButton = getDriver().findElement(By.cssSelector(PDPSelectors.QtysInAddToCartButton)).getText();
			logs.debug("Qty In Add To Cart Button: " + QtysInAddToCartButton);
			int QtyInAddToCartButton = Integer.parseInt(QtysInAddToCartButton);
			logs.debug("Qty In Add To Cart Button: " + QtyInAddToCartButton);
			getCurrentFunctionName(false);
			return QtyInAddToCartButton;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleSKUimg() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundleSKUimg = "";
			logs.debug("Get Qty In Add To Cart Button: ");
			BundleSKUimg = getDriver().findElement(By.cssSelector(PDPSelectors.BundleSKUimg)).getAttribute("src");
			logs.debug("Bundle SKU img: " + BundleSKUimg);
			getCurrentFunctionName(false);
			return BundleSKUimg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleDescription() throws Exception {
		try {
			getCurrentFunctionName(true);
			String bundleDescription = "";
			logs.debug("Get Bundle Description: ");
			bundleDescription = getDriver().findElement(By.cssSelector(PDPSelectors.bundleDescription)).getText();
			logs.debug("Bundle Description: " + bundleDescription);
			getCurrentFunctionName(false);
			return bundleDescription;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Description selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleDescriptionData() throws Exception {
		try {
			getCurrentFunctionName(true);
			String bundleDescription = "";
			logs.debug("Get Bundle Description Data: ");
			bundleDescription = getDriver().findElement(By.cssSelector(PDPSelectors.bundleDescriptionData)).getText();
			logs.debug("Bundle Description Data: " + bundleDescription);
			getCurrentFunctionName(false);
			return bundleDescription;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Description Data selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSideBarNavImg() throws Exception {
		try {
			getCurrentFunctionName(true);
			String sideBarNavImg = "";
			logs.debug("Get Side Bar Nav img: ");
			sideBarNavImg = getDriver().findElement(By.cssSelector(PDPSelectors.sideBarNavImg)).getAttribute("src");
			logs.debug("Side Bar Nav img: " + sideBarNavImg);
			getCurrentFunctionName(false);
			return sideBarNavImg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Nav Img selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSideBarNavTitle() throws Exception {
		try {
			getCurrentFunctionName(true);
			String sideBarNavTitle = "";
			logs.debug("Get Side Bar Nav Title: ");
			sideBarNavTitle = getDriver().findElement(By.cssSelector(PDPSelectors.sideBarNavTitle)).getText().replaceAll(" ", "").trim();
			logs.debug("Side Bar Nav Title: " + sideBarNavTitle);
			getCurrentFunctionName(false);
			return sideBarNavTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Nav Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getsideBarResetTitle() throws Exception {
		try {
			getCurrentFunctionName(true);
			String sideBarResetTitle = "";
			logs.debug("Get Side Bar Reset Title: ");
			sideBarResetTitle = getDriver().findElement(By.cssSelector(PDPSelectors.sideBarResetTitle)).getText();
			logs.debug("Side Bar Reset Title: " + sideBarResetTitle);
			getCurrentFunctionName(false);
			return sideBarResetTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Reset Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static int getNumOfBundleTabs() throws Exception {
		try {
			getCurrentFunctionName(true);
			int BundleTabs = 0;
			logs.debug("Get Bundle Tabs Number: ");
			BundleTabs = getDriver().findElements(By.cssSelector(PDPSelectors.BundleTabs)).size();
			logs.debug("Bundle Tabs Number: " + BundleTabs);
			getCurrentFunctionName(false);
			return BundleTabs;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Tabs selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundlesImgs(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlesImgs = "";
			logs.debug("Get Bundle Img index: " + index );
			BundlesImgs = getDriver().findElements(By.cssSelector(PDPSelectors.BundlesImgs)).get(index).getAttribute("src");
			logs.debug("Bundle Img index: " + index + " : " + BundlesImgs);
			getCurrentFunctionName(false);
			return BundlesImgs;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundles Imgs selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundlesTitle(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlesTitle = "";
			logs.debug("Get Bundle Title index: " + index );
			BundlesTitle = getDriver().findElements(By.cssSelector(PDPSelectors.BundlesTitle)).get(index).getText();
			logs.debug("Bundle Title index: " + index + " : " + BundlesTitle);
			getCurrentFunctionName(false);
			return BundlesTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundles Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleItemsCode(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundleItemsCode = "";
			logs.debug("Get Bundle Items Code index: " + index );
			BundleItemsCode = getDriver().findElements(By.cssSelector(PDPSelectors.BundleItemsCode)).get(index).getText();
			logs.debug("Bundle Items Code index: " + index + " : " + BundleItemsCode);
			getCurrentFunctionName(false);
			return BundleItemsCode;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Items Code selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	
	public static Double getBundleItemsPrice(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundleItemsPrice = "";
			logs.debug("Get Bundle Items Price index: " + index);
			BundleItemsPrice = getDriver().findElements(By.cssSelector(PDPSelectors.BundleItemsPrice)).get(index)
					.getText().replace('$', ' ').trim().replace("/ea", " ").trim();
			logs.debug("Bundle Items Price index: " + index + " : " + BundleItemsPrice);

			Double BundleItemsPrices = Double.parseDouble(BundleItemsPrice);
			logs.debug("Bundle Items Price index: " + index + " : " + BundleItemsPrices);
			getCurrentFunctionName(false);
			return BundleItemsPrices;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Items Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static int BundlesQty() throws Exception {
		try {
			logs.debug("Bundles Qtys are: ");
			int bundlesQty = 0;
			bundlesQty = getDriver().findElements(By.id(PDPSelectors.BundlesQtys)).size();
			logs.debug("Bundles Qtys are: "+ bundlesQty);
			return bundlesQty;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Qtys selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static int outOFStuckQty() throws Exception {
		try {
			logs.debug("Out of Stuck Qtys are:  ");
			int outOfStuckQtys = 0;
			if (!SelectorUtil.isNotDisplayed(PDPSelectors.outOfStuckQtys))
				outOfStuckQtys = getDriver().findElements(By.cssSelector(PDPSelectors.outOfStuckQtys)).size();

			logs.debug("Out of Stuck Qtys are:  " + outOfStuckQtys);
			return outOfStuckQtys;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Out Of Stuck selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getminiCartItemsNumbers() throws Exception {
		try {
			getCurrentFunctionName(true);
			int miniCartItems = 0;
			logs.debug("Get Mini Cart Items Numbers: ");
			miniCartItems = Integer.parseInt(getDriver().findElement(By.cssSelector(PDPSelectors.miniCartItems)).getText().replaceAll(" ", "").trim());
			logs.debug("Mini Cart Items Numbers: " + miniCartItems);
			getCurrentFunctionName(false);
			return miniCartItems;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Nav Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static void NavigteToColorationsSRP() {
		getCurrentFunctionName(true);
		getDriver().get(getURL() + getCONFIG().getProperty("colorationsSRP"));
		getCurrentFunctionName(false);
	}

	public static String navigteToRandomSingleColorationsPage() throws Exception {
		try {
			logs.debug("Navigte To Single Colorations PDP Page");
			List<WebElement> items = new ArrayList<WebElement>();
			items = getDriver().findElements(By.cssSelector(PDPSelectors.ColorationsPDPLinks));
			items.remove(items.size() - 1);
			logs.debug("WebElement List Size = " + items.size());
			Random random = new Random();
			int index = random.nextInt(items.size() - 1);
			String itemTitle = items.get(index).getAttribute("title");
			logs.debug("<font color=#f442cb>Selected PDP Title from the SRP: </font><font color=#b86d29>" + itemTitle + "</font>");
			items.get(index).click();
			return itemTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Selectors of PDPs links on the SRP were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getSinglePDPHeadline() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SingleHeadline = "";
			logs.debug("Get Single Headline: ");
			SingleHeadline = getDriver().findElement(By.cssSelector(PDPSelectors.SingleHeadline)).getText();
			logs.debug("<font color=#f442cb>Single PDP Headline: </font><font color=#b86d29>" + SingleHeadline + "</font>");
			getCurrentFunctionName(false);
			return SingleHeadline;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single Headline selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static String getSinglePDPRangePrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlePrice = "";
			logs.debug("Get Single Price: ");

			BundlePrice = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPPrice)).getText();
			logs.debug("<font color=#f442cb>Single PDP Price: </font><font color=#b86d29>" + BundlePrice + "</font>");
			getCurrentFunctionName(false);
			return BundlePrice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Price selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static Double getSinglePDPPrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlePrice = "";
			logs.debug("Get Single Price: ");

			BundlePrice = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPPrice)).getText();
			logs.debug("Single Price: " + BundlePrice);
			Double BundlePrice2 = Double.parseDouble(BundlePrice.replace('$', ' ').trim());
			logs.debug("<font color=#f442cb>Single PDP Price: </font><font color=#b86d29>" + BundlePrice + "</font>");
			getCurrentFunctionName(false);
			return BundlePrice2;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Price selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSinglePDPCode() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPCode = "";
			logs.debug("Get SinglePDP Code: " );
			SinglePDPCode = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPSKU)).getText();
			logs.debug("<font color=#f442cb>Single PDP Code: </font><font color=#b86d29>" + SinglePDPCode + "</font>");
			getCurrentFunctionName(false);
			return SinglePDPCode;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Code selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSinglePDPSKUimgSrc() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPSKUimg = "";
			logs.debug("Get Single PDP SKU img src: ");
			SinglePDPSKUimg = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPSKUimg)).getAttribute("src");
			logs.debug("<font color=#f442cb>Single PDP SKU img src: </font><font color=#b86d29>" + SinglePDPSKUimg + "</font>");
			getCurrentFunctionName(false);
			return SinglePDPSKUimg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSinglePDPSKUAltimg() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPSKUimg = "";
			logs.debug("Get Single PDP SKU img alt: ");
			SinglePDPSKUimg = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPSKUimg)).getAttribute("alt");
			logs.debug("<font color=#f442cb>Single PDP SKU img alt: </font><font color=#b86d29>" + SinglePDPSKUimg + "</font>");
			getCurrentFunctionName(false);
			return SinglePDPSKUimg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSinglePDPProductOverviewHeader() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPDescription = "";
			logs.debug("Get Single PDP Product Overview Header: ");
			SinglePDPDescription = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPProductOverviewHeader)).getText();
			logs.debug("Single PDP Product Overview Header: " + SinglePDPDescription);
			getCurrentFunctionName(false);
			return SinglePDPDescription;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Product Overview Header: selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static String getSinglePDPProductOverview() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPDescription = "";
			logs.debug("Get Single PDP Product Overview description: ");
			SinglePDPDescription = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPProductOverview)).getText();
			logs.debug("<font color=#FF0000>Single PDP Product Overview description: </font><font color=#b86d29> " + SinglePDPDescription + "</font>");
			getCurrentFunctionName(false);
			return SinglePDPDescription;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Product Overview description: selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSinglePDPShareLinksDiv() throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPShareLinksDiv = "";
			logs.debug("Get Single PDP Share Links Div: ");
			SinglePDPShareLinksDiv = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPShareLinksDiv)).getText();
			logs.debug("Single PDP Share Links Div " + SinglePDPShareLinksDiv);
			getCurrentFunctionName(false);
			return SinglePDPShareLinksDiv;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Share Links Div selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static String getSinglePDPShareLinks(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String SinglePDPShareLinks = "";
			logs.debug("Get Single PDP Share Links index: " + index );
			SinglePDPShareLinks = getDriver().findElements(By.cssSelector(PDPSelectors.SinglePDPShareLinks)).get(index).getAttribute("href");
			logs.debug("<font color=#f442cb>Single PDP Share Link index:("+ index + ") is: </font><font color=#b86d29>"+ SinglePDPShareLinks + "</font>");
			getCurrentFunctionName(false);
			return SinglePDPShareLinks;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Single PDP Share Links selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static boolean validateRecommendedForYouHeaderIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false;
			logs.debug("Validate Recommended For You Product Title is displayed or not" );
			isDisplayed = getDriver().findElement(By.cssSelector(PDPSelectors.recommendedForYouTitle)).isDisplayed();
			logs.debug("Recommended For You Product Title is displayed? : " +  isDisplayed);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Recommended For You Product Tiles selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static boolean validateRecommendedForYouCarouselIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false;
			logs.debug("Validate Recommended For You Products Carousel is displayed or not" );
			isDisplayed = getDriver().findElement(By.cssSelector(PDPSelectors.recommendedForYouTitle)).isDisplayed();
			logs.debug("Recommended For You Products Carousel is displayed? : " +  isDisplayed);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Recommended For You Products Carousel selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getRecommendedForYouProductTiles(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String RecommendedForYouProductTiles = "";
			logs.debug("Get Recommended For You Product Tile index: " + index );
			RecommendedForYouProductTiles = getDriver().findElements(By.cssSelector(PDPSelectors.recommendedForYouProductTiles)).get(index).getText();
			logs.debug("Recommended For You Product Tile index: "+ index + " is: "+ RecommendedForYouProductTiles);
			getCurrentFunctionName(false);
			return RecommendedForYouProductTiles;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Recommended For You Product Tiles selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static boolean validateWriteTheFirstReview() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false;
			logs.debug("Validate write The First Review is displayed or not" );
			isDisplayed = getDriver().findElement(By.cssSelector(PDPSelectors.writeTheFirstReview)).isDisplayed();
			logs.debug("Validate write The First Review is displayed? : " +  isDisplayed);
			String WriteReviewDiv = getDriver().findElement(By.cssSelector(PDPSelectors.writeTheFirstReview)).getText();
			logs.debug("<font color=#f442cb>Write Review Div contains: </font><font color=#b86d29>" +  WriteReviewDiv + "</font>");
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Write The First Review selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBrandImg() throws Exception {
		try {
			getCurrentFunctionName(true);
			String brandImg = "";
			logs.debug("Get Brand img src" );
			brandImg = getDriver().findElement(By.cssSelector(PDPSelectors.recommendedForYouProductTiles)).getText();
			logs.debug("<font color=#f442cb>Brand img src is: </font><font color=#b86d29>"+ brandImg + "</font>");
			getCurrentFunctionName(false);
			return brandImg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Brand img selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String slectPDPOptionsifAnyAndValidate() throws Exception {
		try {
			logs.debug("Select PDP options is any");
			String optionName = "";
			if (!SelectorUtil.isNotDisplayed(PDPSelectors.selectOptionsButton)) {
			String SinglePDPSKUimg = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPSKUimg)).getAttribute("src");
			List<WebElement> options = new ArrayList<WebElement>();
			options = getDriver().findElements(By.cssSelector(PDPSelectors.optionListLinks));
			options.remove(options.size() - 1);
			logs.debug("<font color=#f442cb>Number of available color options are: </font><font color=#b86d29>"+ options.size() + "</font>");
			Random random = new Random();
			int index = random.nextInt(options.size() - 1);
			optionName = options.get(index).getText();
			logs.debug("<font color=#f442cb>Selected PDP option is: </font><font color=#b86d29>" + optionName + "</font>");
			options.get(index).click();
			Thread.sleep(7000);
			String NewSingleSKUimgSrc = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPSKUimg)).getAttribute("src");
			sassert().assertNotEquals(NewSingleSKUimgSrc, SinglePDPSKUimg,
					"<font color=#f442cb>PDP image src is not updated after selecting an options. The old image src: </font><font color=#b86d29>" + SinglePDPSKUimg
							+ "</font><font color=#FF0000>The new image src: </font><font color=#b86d29>"
							+ NewSingleSKUimgSrc + "</font>");
			SinglePDPSKUimg = getDriver().findElement(By.cssSelector(PDPSelectors.SinglePDPSKUimg)).getAttribute("alt");
			sassert().assertTrue(SinglePDPSKUimg.contains(optionName),
					"<font color=#f442cb>PDP image src is not updated to reflect the selected color,  The selected color is: </font><font color=#b86d29>" + optionName
							+ "</font><font color=#FF0000>The new image name: </font><font color=#b86d29>"
							+ SinglePDPSKUimg + "</font>");
			}else {
				logs.debug("<font color=#f442cb>No options to select: </font>");	
			}
			
			return optionName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Out Of Stuck selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getQtyValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			int qtyValue;
			logs.debug("Get Qty Value" );
			qtyValue = Integer.parseInt(getDriver().findElement(By.cssSelector(PDPSelectors.qtyValue)).getAttribute("value"));
			logs.debug("<font color=#f442cb>Qty Value is: </font><font color=#b86d29>"+ qtyValue + "</font>");
			getCurrentFunctionName(false);
			return qtyValue;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Qty Value selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBrandImgss() throws Exception {
		try {
			getCurrentFunctionName(true);
			String brandImg = "";
			logs.debug("Get Brand img src" );
			brandImg = getDriver().findElement(By.cssSelector(PDPSelectors.addToCartButton)).getText();
			logs.debug("<font color=#f442cb>Brand img src is: </font><font color=#b86d29>"+ brandImg + "</font>");
			getCurrentFunctionName(false);
			return brandImg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Brand img selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static Double getPriceInaddToCartModal() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlePrice = "";
			logs.debug("Get Price In add To Cart Modal: ");

			BundlePrice = getDriver().findElement(By.cssSelector(PDPSelectors.priceInaddToCartModal)).getText();
			logs.debug("Price In add To Cart Modal:  " + BundlePrice);
			Double BundlePrice2 = Double.parseDouble(BundlePrice.replace('$', ' ').trim());
			logs.debug("<font color=#f442cb>Price In add To Cart Modal: </font><font color=#b86d29>" + BundlePrice + "</font>");
			getCurrentFunctionName(false);
			return BundlePrice2;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Price In add To Cart Modal:  selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
}
