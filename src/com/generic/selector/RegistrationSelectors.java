package com.generic.selector;

import com.generic.setup.cselector;

public class RegistrationSelectors {
	//Done CBI Smoke
	//Navigation
	public static final cselector closeOfferButtonGH = new cselector("css,#Close1-Item4 .offer-control");
	public static final cselector registrationButton = new cselector("css, .yCmsComponent>div>a.btn.btn-secondary.btn-block");
	public static final cselector MyAccount = new cselector("css, div.spot:nth-child(3) > button:nth-child(1)");

	public static final cselector registerBtn = new cselector("css,div.form-actions.clearfix.col-sm-6 > button");
																   
	public static final cselector saveButton = new cselector("css,#gwt_billshipaddr_btn > button","css, #userRegAddressForm2 > div.t-registration__continue-button > button");
	
	//Fields of 1st step
	public static final cselector emailAddress = new cselector("css,input[name='email']","css, input[name=\"email\"]");	
	public static final cselector password =  new cselector("css,input[name='pwd']","css, input[name=\"pwd\"]");	
	//Fields of 2nd step
	public static final cselector firstName =new cselector ("css,input[name='firstName']","css, input[name=\"firstName\"]");	
	public static final cselector lastName =new cselector ("css,input[name='lastName']","css, input[name=\"lastName\"]");	
	//public static final cselector lastNameBD = new cselector("css,#bill_lnbox","css,#field-12");
	public static final cselector companyName=new cselector ("css,#bill_cnbox","css,input[label=\"Company Name\"]");
	public static final cselector companyNameGH=new cselector ("css,#bill_cnbox","css, input[id=\"bill_addrCompany\"]");
	//public static final cselector companyNameBD=new cselector ("css,#bill_cnbox","css,#field-13");
	public static final cselector AddressLine1 = new cselector ("css,#bill_sa1box", "css,input[label=\"Street Address 1\"]");
	public static final cselector mobileCity = new cselector ("css, input[id=\"bill_city\"]");
	public static final cselector mobilezipcode = new cselector ("css, #bill_zipbox","css,input[type=\"postalCode\"]");

	public static final cselector AddressLine1GH = new cselector ("css,#bill_sa1box", "css, input[id=\"bill_strAdd1\"]");
	public static final cselector AddressLine1BD = new cselector ("css,#bill_sa1box", "css,input[id=\"bill_strAdd1\"]");
	public static final cselector city = new cselector ("css,#bill_citybox","css,#bill_city");
	public static final cselector cityGH = new cselector ("css,#bill_citybox","css, #bill_city");
	//public static final cselector cityBD = new cselector ("css,#bill_citybox","css,#field-13");
	public static final cselector state = new cselector("css,#bill_region","css,#bill_region");
	public static final cselector FGstateMobile = new cselector("css,#bill_region");
	public static final cselector stateGH = new cselector("css,#bill_region","css, select[id=\"bill_region\"]");
	//public static final cselector stateBD = new cselector("css,#bill_region","css,#field-14");
	public static final cselector Zipcode = new cselector("css,#bill_zipbox","css,input[type=\"postalCode\"]");
	public static final cselector ZipcodeGH = new cselector("css,#bill_zipbox","css, #bill_postalCode");
	public static final cselector FGzipcodeMobile = new cselector("css,#bill_zipbox","css, #bill_postalCode");
	public static final cselector zipcodeMobileGR = new cselector("css,input[label=\"Zip/Postal Code\"]","css, input[id=\"bill_postalCode\"]");
	//public static final cselector ZipcodeBD = new cselector("css,#bill_zipbox","css,#field-15");
	public static final cselector phone = new cselector("css,#bill_phone1box", "css,input[label=\"Daytime Phone\"]");
	public static final cselector phoneGR = new cselector("css, #bill_phone1box", "css, input[id=\"bill_phone1\"]");
	public static final cselector phoneBD = new cselector("css,#bill_phone1box", "css,input[id=\"bill_phone1\"]");

	//Registration success verification
	public static final cselector welcomeMessage = new cselector("css,.alert-info ");
	public static final cselector welcomeMessageGR = new cselector("css,.data.overviewWrapper","css,#app-main > div.t-my-account > div.t-my-account__content > div.c-dangerous-html");
	public static final cselector welcomeMessageGH = new cselector("css,.data.overviewWrapper","css,.t-my-account__signout");
	public static final cselector welcomeMessageRY = new cselector("css,.data.overviewWrapper","css,.t-my-account-accordion__header");

	//Error messages  
	
	//Mobile
	public static final cselector emailAddressErrorMobile =new cselector("css,.c-custom-input-error");
	public static final cselector confEmailAddressErrorMobile = new cselector("css,.c-custom-input-error");
	public static final cselector passwordRulesErrorMobile = new cselector("css,.c-custom-input-error");
	public static final cselector confirmPasswordErrorMobile = new cselector("css,.c-custom-input-error"); 
	
	public static final cselector firstNameErrorMobile =new cselector("css,.c-custom-input-error");
	public static final cselector lastNameErrorMobile =new cselector("css,.c-custom-input-error");
	public static final cselector streetAddreesErrorMobile =new cselector("css,.c-custom-input-error");
	public static final cselector cityErrorMobile =new cselector("css,.c-custom-input-error");
	public static final cselector stateErrorMobile =new cselector("css,#register-form > div:nth-child(1) > div:nth-child(2) > div > div > div > div.c-address-form__city-state-container > div.u-flexbox.u-padding-bottom-md.c-address-city-state-field > div:nth-child(2) > div > div.pw-field__error");
	public static final cselector ZIPCodeErrorMobile =new cselector("css,.c-custom-input-error");
	public static final cselector phoneErrorMobile =new cselector("css,.c-custom-input-error");
	
	//Desktop
	public static final cselector emailAddressError = new cselector( "email.errors");	
	public static final cselector passwordRulesError = new cselector("css,#password_minchar");
	
	public static final cselector firstNameError = new cselector("firstName.errors");
	public static final cselector lastNameError = new cselector("lastName.errors");

	

	
}
