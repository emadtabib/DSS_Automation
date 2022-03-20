package com.generic.selector;

import com.generic.setup.cselector;

public class HomePageSelectors
{
	public static final String navMenu = ".mobile-menu>.js-toggle-sm-navigation";
	public static final String closeNavMenu = "div.btn-close-icon";
	public static final String search = "input#js-site-search-input";
	public static final String searchIcon = "icon-search";
	public static final String searchSuggestions = "css,.js-product-suggestions>div>a";
	public static final String closeSignUpModal = "css,.dy-modal-contents>.dy-lb-close";
	public static final String myAccountIcon = ".nav-icon.icon-account";
	public static final cselector signinLink = new cselector(".signin-link",".mobile-signin>a",".mobile-signin>a");
	public static final String userNameField = "#j_username";
	public static final String passwordField = "#j_password";
	public static final String singInButton = ".btn.btn-primary.btn-block.load_orders";
	public static final String closeSignUpModalee = ".dy-modal-contents>.dy-lb-close";
	public static final String signout = "signout-link";
	public static final String closeNotReadyToBuyModal = "css,.dy-modal-contents>.dy-lb-close";
	public static final String closeNotReadytoBuyModal = ".dy-modal-contents>.dy-lb-close";
	
	public static final String PLPProductsName = ".details-inner>a";
}
