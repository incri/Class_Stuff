package Base;

import FrontendLayer.WelcomePage;

public class Main {
	public static void main(String[] args) {
		try {
			WelcomePage welcomePage = new WelcomePage();
			welcomePage.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
