package adminswing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin {
	
	ArrayList<String> categories = new ArrayList<String>();
	
	
	private JFrame frame;
	private JButton btn_cat, btn_pic, btn_pic_add, btn_pic_back,
	btn_cat_add, btn_cat_back, admin_btn;
	private JTextField welcomeMsg, picMsg, picMsg1, picMsg2,
			picMsg3, catMsg, catMsg2, admin_title, admin_user_text, admin_pass_text;
	private JTextField pic_URL, pic_word, cat_word, admin_user, admin_pass;
	private JComboBox cat_list;
	
	public Admin() {
		categories.add("Tegneserier");
		categories.add("Film");
		categories.add("Landskaber");
		categories.add("Tr�er");
		
		frame = new JFrame("Admin Log in");
		frame.setResizable(false);
		frame.setSize(525, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel logIn_panel = new JPanel(null);
		final JPanel choose_panel = new JPanel(null);
		final JPanel pic_panel = new JPanel(null);
		final JPanel cat_panel = new JPanel(null);
		
		// Log in panel
		admin_title = new JTextField("Admin Log in");
		admin_title.setBounds(10, 10, 500, 35);
		admin_title.setFont(new Font("Serif", Font.BOLD, 20));
		admin_title.setEditable(false);
		logIn_panel.add(admin_title);
		
		admin_user_text = new JTextField("Username:");
		admin_user_text.setBounds(10, 50, 240, 35);
		admin_user_text.setFont(new Font("Serif", Font.BOLD, 20));
		admin_user_text.setEditable(false);
		logIn_panel.add(admin_user_text);
		
		admin_user = new JTextField();
		admin_user.setBounds(250, 50, 240, 35);
		admin_user.setFont(new Font("Serif", Font.BOLD, 20));
		admin_user.setEditable(true);
		logIn_panel.add(admin_user);
		
		admin_pass_text = new JTextField("Password:");
		admin_pass_text.setBounds(10, 90, 240, 35);
		admin_pass_text.setFont(new Font("Serif", Font.BOLD, 20));
		admin_pass_text.setEditable(false);
		logIn_panel.add(admin_pass_text);
		
		admin_pass = new JTextField();
		admin_pass.setBounds(250, 90, 240, 35);
		admin_pass.setFont(new Font("Serif", Font.BOLD, 20));
		admin_pass.setEditable(true);
		logIn_panel.add(admin_pass);
		
		admin_btn = new JButton("Log ind");
		admin_btn.setBounds(375, 130, 125, 45);
		admin_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				logIn_panel.setVisible(false);
				choose_panel.setVisible(true);
				pic_panel.setVisible(false);
				cat_panel.setVisible(false);
				frame.setContentPane(choose_panel);
			}
		});
		logIn_panel.add(admin_btn);
		logIn_panel.setVisible(true);
		
		// Choose panel
		welcomeMsg = new JTextField("Velkommen til admin siden, du har nu følgende valg:");
		welcomeMsg.setBounds(10, 10, 500, 35);
		welcomeMsg.setFont(new Font("Serif", Font.BOLD, 20));
		welcomeMsg.setEditable(false);
		choose_panel.add(welcomeMsg);
		
		//Knap til at tilf�je billeder
		btn_pic = new JButton("Tilføj Billede");
		btn_pic.setBounds(75, 125, 125, 45);
		btn_pic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Tilføj Billede");
				logIn_panel.setVisible(false);
				choose_panel.setVisible(false);
				pic_panel.setVisible(true);
				cat_panel.setVisible(false);
				frame.setContentPane(pic_panel);
			}
		});
		choose_panel.add(btn_pic);
		
		//Knap til at tilf�je kategorier
		btn_cat = new JButton("Tilføj Kategori");
		btn_cat.setBounds(300, 125, 125, 45);
		btn_cat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Tilføj Kategori");
				logIn_panel.setVisible(false);
				choose_panel.setVisible(false);
				pic_panel.setVisible(false);
				cat_panel.setVisible(true);
				frame.setContentPane(cat_panel);
			}
		});
		choose_panel.add(btn_cat);
		
		btn_cat = new JButton("Log ud");
		btn_cat.setBounds(10, 300, 125, 45);
		btn_cat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Tilføj Kategori");
				logIn_panel.setVisible(true);
				choose_panel.setVisible(false);
				pic_panel.setVisible(false);
				cat_panel.setVisible(false);
				frame.setContentPane(logIn_panel);
			}
		});
		choose_panel.add(btn_cat);
		choose_panel.setVisible(false);
		
		// Pic panel
		picMsg = new JTextField("Tilføj et billede og vælg kategori");
		picMsg.setBounds(10, 10, 500, 35);
		picMsg.setFont(new Font("Serif", Font.BOLD, 20));
		picMsg.setEditable(false);
		pic_panel.add(picMsg);
		
		picMsg1 = new JTextField("Indtast billede URL:");
		picMsg1.setBounds(10, 50, 500, 35);
		picMsg1.setFont(new Font("Serif", Font.BOLD, 16));
		picMsg1.setEditable(false);
		pic_panel.add(picMsg1);
		
		pic_URL = new JTextField();
		pic_URL.setBounds(10, 90, 500, 35);
		pic_URL.setFont(new Font("Serif", Font.BOLD, 16));
		pic_URL.setEditable(true);
		pic_panel.add(pic_URL);
				
		picMsg2 = new JTextField("Skriv ordet der skal skrives for at gætte motivet af billedet:");
		picMsg2.setBounds(10, 130, 500, 35);
		picMsg2.setFont(new Font("Serif", Font.BOLD, 16));
		picMsg2.setEditable(false);
		pic_panel.add(picMsg2);
		
		pic_word = new JTextField();
		pic_word.setBounds(10, 170, 500, 35);
		pic_word.setFont(new Font("Serif", Font.BOLD, 16));
		pic_word.setEditable(true);
		pic_panel.add(pic_word);
		
		picMsg3 = new JTextField("Vælg en kategori som billedet skal tilføjes til:");
		picMsg3.setBounds(10, 210, 500, 35);
		picMsg3.setFont(new Font("Serif", Font.BOLD, 16));
		picMsg3.setEditable(false);
		pic_panel.add(picMsg3);
		
		cat_list = new JComboBox();
		for(int i=0; i < categories.size(); i++) {
			cat_list.addItem(categories.get(i));
		}
		cat_list.setBounds(10, 250, 125, 35);
		cat_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println(cat_list.getSelectedItem());
			}
		});
		pic_panel.add(cat_list);
		
		btn_pic_back = new JButton("Tilbage");
		btn_pic_back.setBounds(10, 300, 125, 45);
		btn_pic_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				logIn_panel.setVisible(false);
				choose_panel.setVisible(true);
				pic_panel.setVisible(false);
				cat_panel.setVisible(false);
				frame.setContentPane(choose_panel);
			}
		});
		pic_panel.add(btn_pic_back);
		
		btn_pic_add = new JButton("Tilføj");
		btn_pic_add.setBounds(375, 300, 125, 45);
		btn_pic_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Tilføj");
			}
		});
		pic_panel.add(btn_pic_add);
		pic_panel.setVisible(false);
		
		// cat panel
		catMsg = new JTextField("Tilføj en kategori:");
		catMsg.setBounds(10, 10, 500, 35);
		catMsg.setFont(new Font("Serif", Font.BOLD, 20));
		catMsg.setEditable(false);
		cat_panel.add(catMsg);
		
		cat_word = new JTextField();
		cat_word.setBounds(10, 50, 500, 35);
		cat_word.setFont(new Font("Serif", Font.BOLD, 20));
		cat_word.setEditable(true);
		cat_panel.add(cat_word);
		
		btn_cat_back = new JButton("Tilbage");
		btn_cat_back.setBounds(10, 100, 125, 45);
		btn_cat_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				logIn_panel.setVisible(false);
				choose_panel.setVisible(true);
				pic_panel.setVisible(false);
				cat_panel.setVisible(false);
				frame.setContentPane(choose_panel);
			}
		});
		cat_panel.add(btn_cat_back);
		
		btn_cat_back = new JButton("Tilføj");
		btn_cat_back.setBounds(375, 100, 125, 45);
		btn_cat_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				String herro = cat_word.getText();
				categories.add(herro);
				cat_list.addItem(herro);
				logIn_panel.setVisible(false);
				choose_panel.setVisible(true);
				pic_panel.setVisible(false);
				cat_panel.setVisible(false);
				frame.setContentPane(choose_panel);
				cat_word.setText("");
			}
		});
		cat_panel.add(btn_cat_back);
		
		cat_panel.setVisible(false);
		
		
		
		frame.setContentPane(logIn_panel);
		frame.setVisible(true);
	}
	

}
