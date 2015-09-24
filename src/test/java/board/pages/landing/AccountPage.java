package board.pages.landing;

import board.pages.PageManager;

public class AccountPage extends LandingTopPanelPages {

	public AccountPage(PageManager pages) {
		super(pages);
	}
	
	private String url = "account/";
	
	public String getPageUrl() {
		return url;
	}

}
