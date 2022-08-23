package FrontendLayer;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class WelcomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		setBackground(Color.WHITE);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    JLabel lblWelcomeToHotel = new JLabel("WELCOME TO HOTEL LUTON");
		lblWelcomeToHotel.setForeground(Color.WHITE);
		lblWelcomeToHotel.setFont(new Font("Dialog", Font.BOLD, 32));
		lblWelcomeToHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToHotel.setBackground(UIManager.getColor("Button.select"));
		lblWelcomeToHotel.setBounds(313, 12, 570, 69);
		contentPane.add(lblWelcomeToHotel);

		JDesktopPane externalDesktopPane = new JDesktopPane();
		externalDesktopPane.setBorder(null);
		externalDesktopPane.setBackground(Color.LIGHT_GRAY);
		externalDesktopPane.setBounds(688, 64, 560, 571);
		contentPane.add(externalDesktopPane);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(482, 178, 194, 69);
		contentPane.add(btnNewButton);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUpBox signUp = new SignUpBox();
				signUp.setVisible(true);
				externalDesktopPane.add(signUp);
			}
		});
		
		btnSignup.setFont(new Font("Dialog", Font.BOLD, 22));
		btnSignup.setBounds(482, 291, 194, 69);
		contentPane.add(btnSignup);
		
		JButton btnGallery = new JButton("GALLERY");
		btnGallery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGallery.setFont(new Font("Dialog", Font.BOLD, 22));
		btnGallery.setBounds(482, 405, 194, 69);
		contentPane.add(btnGallery);
		
		JLabel logoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		logoLabel.setIcon(new ImageIcon(logo));
		logoLabel.setBounds(52, 12, 135, 115);
		contentPane.add(logoLabel);
		
		JLabel WallpapperLabel = new JLabel("");
		Image wallpaper = new ImageIcon(this.getClass().getResource("/HotelWallpapper.jpg")).getImage();
		WallpapperLabel.setIcon(new ImageIcon(wallpaper));
		WallpapperLabel.setBackground(Color.WHITE);
		WallpapperLabel.setBounds(12, 12, 1256, 623);
		contentPane.add(WallpapperLabel);
		
	}
}
