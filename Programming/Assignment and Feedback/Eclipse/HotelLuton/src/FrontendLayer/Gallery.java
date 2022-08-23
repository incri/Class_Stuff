package FrontendLayer;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Gallery extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the Gallery frame.
	 */
	public Gallery() {
		setBackground(Color.WHITE);
		setTitle("Gallery");
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
