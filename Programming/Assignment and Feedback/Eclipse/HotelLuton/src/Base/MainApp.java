package Base;

import FrontendLayer.WelcomePage;

public class MainApp {
	public static void main(String[] args) {
		try {
			WelcomePage window = new WelcomePage();
			window.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
