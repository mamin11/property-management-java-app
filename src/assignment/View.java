package assignment;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import classes.branch;
import classes.flat;
import classes.house;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;



public class View {


	private Model themodel;
	private Controller thecontroller;
	public JFrame frame;
	private JPanel panel;
	private Icon logo;
		
	//for branches
	public JButton[] buttons; //= new JButton[5];
	public JButton[] delButtons;
	//for houses
	public JButton[] hModbuttons;
	public JButton[] hDelButtons;
	public JButton[] hSellButtons;
	//for flats
	public JButton[] fModbuttons;
	public JButton[] fDelButtons;
	public JButton[] fSellButtons;
	
	public JLabel label;
	public JButton btnBack;
	public JButton btnBackFront;
	public JButton btnBackSecHome;
	public JButton btnAdmin;
	public JButton btnSecretary;
	public JButton btnLogin; 
	public JButton btnSecLogin;
	public JButton btnViewBranch;
	public JButton btnAddBranch;
	public JButton btnModifyBranch;
	public JButton btnViewProperty;
	public JButton btnAddProperty;
	public JButton btnModifyProperty;
	public JButton btnAddHouse;
	public JButton btnSaveHouse;
	public JButton btnModifyHouse;
	public JButton btnAddFlat;
	public JButton btnSaveFlat;
	public JButton btnModifyFlat;
	public JButton btnViewHouse;
	public JButton btnViewFlat;
	public JButton btnViewSold;
	public JButton btnSaveBranch;
	public JButton btnUpdateBranch;
	public JButton btnUpdateHouse;
	public JButton btnUpdateFlat;
	public JButton btnDeleteBranch;
	public JButton btnDeleteHouse;
	public JButton btnDeleteFlat;
	public JButton btnSellHouse;
	public JButton btnSellFlat;
	public JTextField username; 
	public JTextField password; 
	public JTextField textfield;
	
	public JTextField branchNameTF;
	public JTextField branchAddressTF;
	public JTextField branchTelNumTF;
	public JTextField branchEmailTF;
	public JTextField branchWebTF;
	public JTextField branchUnameTF;
	public JTextField branchPwordTF;
	
	public JTextField houseRoomsTF;
	public JTextField houseaddressTF;
	public JTextField houseSellingPriceTF;
	public JTextField houseSoldPriceTF;
	public JTextField houseNumFloorsTF;
	public JComboBox houseGardenCombo;
	public JComboBox houseGarageCombo;
	
	public JTextField flatRoomsTF;
	public JTextField flataddressTF;
	public JTextField flatSellingPriceTF;
	public JTextField flatSoldPriceTF;
	public JTextField flatFloorNumTF;
	public JTextField flatRentTF;
	
	public Vector<Boolean> comboBoxItems = new Vector<Boolean>();
	
    //MENU
    private JMenuBar MenuBar;
    JMenu scenarioMenu, editMenu, controlsMenu, helpMenu;
    JMenuItem option1,option2,option3, helpItem, aboutItem;

	int index;
	int size;
	int branchSize = 0;
	
	public String housePrice;
	public String flatPrice;
	
	View(Controller thecontroller, Model themodel) {
		
		//array for the delete and modify buttons depending on the size of the branch
		buttons = new JButton[thecontroller.branchSize];
		delButtons = new JButton[thecontroller.branchSize];
		
		//array for the delete and modify buttons depending on the size of the house
		hDelButtons = new JButton[thecontroller.houseSize];
		hModbuttons = new JButton[thecontroller.houseSize];
		hSellButtons = new JButton[thecontroller.houseSize];
		
		//array for the delete and modify buttons depending on the size of the flat
		fDelButtons = new JButton[thecontroller.flatSize];
		fModbuttons = new JButton[thecontroller.flatSize];
		fSellButtons = new JButton[thecontroller.flatSize];
		
			
		this.themodel = themodel;
		this.thecontroller = thecontroller;
		
		thecontroller.addView(this);
				
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		frame.setVisible(true);
		frame.setResizable(false);
		
		label = new JLabel("");
		frame.getContentPane().add(label);
		
		label = new JLabel("");
		frame.getContentPane().add(label);
		
		btnAdmin = new JButton("ADMIN");

		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnAdmin);
		btnAdmin.addActionListener(thecontroller);
		
		btnSecretary = new JButton("SECRETARY");

		btnSecretary.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnSecretary);
		btnSecretary.addActionListener(thecontroller);
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
					
		frame.repaint();
		this.centreWindow();
		this.menuSetup();
	}
	
    public void centreWindow()
    {    //Centre the window
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = frame.getSize();
      if (frameSize.height > screenSize.height)
      {
        frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width)
      {
        frameSize.width = screenSize.width;
      }
      frame.setLocation((screenSize.width - frameSize.width) / 2, 
                  (screenSize.height - frameSize.height) / 2);
     }
    
    private void menuSetup() 
    {
    	//create a menu bar
    	MenuBar = new JMenuBar();      
        frame.setJMenuBar(MenuBar);
		
        scenarioMenu = new JMenu("Scenario");    
        MenuBar.add(scenarioMenu);       
        
        option1 = new JMenuItem("Option 1"); 
//        option=1;
        scenarioMenu.add(option1);           
        //option1.addActionListener(this); 

        option2 = new JMenuItem("Option 2");
        //option=2;
        scenarioMenu.add(option2);           
       // option2.addActionListener(this);
        
        option3 = new JMenuItem("Option 3"); 
        //option=3;
        scenarioMenu.add(option3);           
       // option3.addActionListener(this);

        editMenu = new JMenu("Edit");     
        MenuBar.add(editMenu );

        controlsMenu = new JMenu("Controls");
        MenuBar.add(controlsMenu);

        helpMenu = new JMenu("Help");   // help menu, with  help topics and about application
        helpItem = new JMenuItem("Help Topics");
        helpMenu.add(helpItem);
       // helpItem.addActionListener(this);
        aboutItem = new JMenuItem("About...");
        helpMenu.add(aboutItem);
        aboutItem.addActionListener(thecontroller);
        MenuBar.add(helpMenu);
        
	}
    
    public void handleAboutItem ()
    {
 		String aboutBoxString = (" Application written by\n Amin \n"
 				+ " Student - Business Computing,\n"
 				+ " University of Northampton\n"
 				) ;
         JOptionPane.showMessageDialog(null, aboutBoxString, "About the author",
                                               JOptionPane.INFORMATION_MESSAGE);
         MenuBar.repaint();     //repaints menu after item is selected
    }
	
   //the view for the front page
	public void frontPage() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		frame.setVisible(true);
		frame.setResizable(false);
		
		label = new JLabel("");
		frame.getContentPane().add(label);
		
		label = new JLabel("");
		frame.getContentPane().add(label);
		
		btnAdmin = new JButton("ADMIN");

		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnAdmin);
		btnAdmin.addActionListener(thecontroller);
		
		btnSecretary = new JButton("SECRETARY");

		btnSecretary.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnSecretary);
		btnSecretary.addActionListener(thecontroller);
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label);
		frame.repaint();
		this.centreWindow();
	}


	//the view for the login page
	public void LoginPage() {		
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		label = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 3;
		frame.getContentPane().add(label, gbc_lblUsername);
		
		username = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(username, gbc_textField);
		username.setColumns(10);
		
		label = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 5;
		frame.getContentPane().add(label, gbc_lblPassword);
		
		password = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		frame.getContentPane().add(password, gbc_textField_1);
		password.setColumns(10);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(thecontroller);
		
		btnBackFront = new JButton("BACK");
		btnBackFront.setBounds(335, 11, 89, 23);
		btnBackFront.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackFront);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		frame.getContentPane().add(btnLogin, gbc_btnNewButton);
		frame.repaint();
		this.centreWindow();
		
	}
	
	//the view for the secretary login page
	public void SecLoginPage() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		label = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 3;
		frame.getContentPane().add(label, gbc_lblUsername);
		
		username = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(username, gbc_textField);
		username.setColumns(10);
		
		label = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 5;
		frame.getContentPane().add(label, gbc_lblPassword);
		
		password = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		frame.getContentPane().add(password, gbc_textField_1);
		password.setColumns(10);
		
		btnSecLogin = new JButton("LOGIN");
		btnSecLogin.addActionListener(thecontroller);
		
		btnBackFront = new JButton("BACK");
		btnBackFront.setBounds(335, 11, 89, 23);
		btnBackFront.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackFront);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		frame.getContentPane().add(btnSecLogin, gbc_btnNewButton);
		frame.repaint();
		
		this.centreWindow();
	}
	
	//the view for the admin home page
	public void adminHome() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);	
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("COMPANY-NAME PROPERTIES");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(200, 75, 189, 14);
		frame.getContentPane().add(label);
		
		btnViewBranch = new JButton("VIEW BRANCHES");
		btnViewBranch.setBounds(50, 200, 200, 100);
		btnViewBranch.addActionListener(thecontroller);
		frame.getContentPane().add(btnViewBranch);
		
		btnAddBranch = new JButton("ADD BRANCH");
		btnAddBranch.setBounds(325, 200, 200, 100);
		btnAddBranch.addActionListener(thecontroller);
		frame.getContentPane().add(btnAddBranch);
		
		btnBackFront = new JButton("BACK");
		btnBackFront.setBounds(540, 11, 89, 45);
		btnBackFront.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackFront);
		
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		btnImage.setIcon(logo);
		frame.getContentPane().add(btnImage);
		frame.repaint();
		
		this.centreWindow();
	}
	
	//the view for the add branch page
	public void addBranch() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(540, 11, 89, 45);
		btnBack.addActionListener(thecontroller);
		frame.getContentPane().add(btnBack);
		
		JLabel lblCompanynameProperties = new JLabel("ADD BRANCH");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(153, 16, 89, 23);
		frame.getContentPane().add(lblCompanynameProperties);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(30, 57, 46, 14);
		frame.getContentPane().add(lblName);
		
		branchNameTF = new JTextField();
		branchNameTF.setBounds(129, 54, 195, 20);
		frame.getContentPane().add(branchNameTF);
		branchNameTF.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(30, 82, 53, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER :");
		lblPhoneNumber.setBounds(30, 107, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("EMAIL :");
		lblEmail.setBounds(30, 132, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblWebsite = new JLabel("WEBSITE :");
		lblWebsite.setBounds(30, 157, 69, 14);
		frame.getContentPane().add(lblWebsite);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setBounds(30, 182, 69, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setBounds(30, 207, 69, 14);
		frame.getContentPane().add(lblPassword);
		
		branchAddressTF = new JTextField();
		branchAddressTF.setBounds(129, 79, 195, 20);
		frame.getContentPane().add(branchAddressTF);
		branchAddressTF.setColumns(10);
		
		branchTelNumTF = new JTextField();
		branchTelNumTF.setBounds(129, 104, 195, 20);
		frame.getContentPane().add(branchTelNumTF);
		branchTelNumTF.setColumns(10);
		
		branchEmailTF = new JTextField();
		branchEmailTF.setBounds(129, 129, 195, 20);
		frame.getContentPane().add(branchEmailTF);
		branchEmailTF.setColumns(10);
		
		branchWebTF = new JTextField();
		branchWebTF.setBounds(129, 154, 195, 20);
		frame.getContentPane().add(branchWebTF);
		branchWebTF.setColumns(10);
		
		branchUnameTF = new JTextField();
		branchUnameTF.setBounds(129, 179, 195, 20);
		frame.getContentPane().add(branchUnameTF);
		branchUnameTF.setColumns(10);
		
		branchPwordTF = new JTextField();
		branchPwordTF.setBounds(129, 204, 195, 20);
		frame.getContentPane().add(branchPwordTF);
		branchPwordTF.setColumns(10);
		
		btnSaveBranch = new JButton("ADD");
		btnSaveBranch.setBounds(176, 235, 89, 23);
		btnSaveBranch.addActionListener(thecontroller);
		frame.getContentPane().add(btnSaveBranch);
		
		frame.repaint();
		
		this.centreWindow();
	}
	
	//the view for view branch page
	public void viewBranch() { 
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		JLabel lblViewBranch = new JLabel("VIEW BRANCH");
		lblViewBranch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewBranch.setBounds(163, 21, 95, 14);
		frame.getContentPane().add(lblViewBranch);
		
		for(int c=40,i=0; i< thecontroller.branchSize; i++, c+=40) {
			index = i;
			JLabel lblBrnachName = new JLabel(i + ".");
			lblBrnachName.setText(i+1 + "." + thecontroller.branches.get(i).getName());
			lblBrnachName.setBounds(10, 75+c, 126, 14);
			frame.getContentPane().add(lblBrnachName);

			buttons[i] = new JButton("MODIFY");			
			buttons[i].setBounds(169, 71+c, 89, 23);
			buttons[i].addActionListener(thecontroller);
			frame.getContentPane().add(buttons[i]);
			
			delButtons[i] = new JButton("DELETE");
			delButtons[i] = new JButton("DELETE");
			delButtons[i].addActionListener(thecontroller);

			delButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,"SUCCESSFULLY DELETED");
					
				}
			});
			delButtons[i].setBounds(287, 71+c, 89, 23);
			frame.getContentPane().add(delButtons[i]);
		}
			
		btnBack = new JButton("BACK");
		btnBack.setBounds(540, 11, 89, 45);
		btnBack.addActionListener(thecontroller);
		frame.getContentPane().add(btnBack);
		
		frame.repaint();
		
		this.centreWindow();
	}

	//the view for modify branch page
	public void modifyBranch(String name, String address, String num, String email,String website,String username,String password) {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(540, 11, 89, 45);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"PLEASE CLICK SAVE TO GO BACK");
			}
		});
		frame.getContentPane().add(btnBack);
		
		JLabel lblCompanynameProperties = new JLabel("MODIFY BRANCH");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(153, 16, 123, 23);
		frame.getContentPane().add(lblCompanynameProperties);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(30, 57, 46, 14);
		frame.getContentPane().add(lblName);
		
		branchNameTF = new JTextField();
		branchNameTF.setText(name);
		branchNameTF.setBounds(129, 54, 195, 20);
		frame.getContentPane().add(branchNameTF);
		branchNameTF.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(30, 82, 53, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER :");
		lblPhoneNumber.setBounds(30, 107, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("EMAIL :");
		lblEmail.setBounds(30, 132, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblWebsite = new JLabel("WEBSITE :");
		lblWebsite.setBounds(30, 157, 89, 14);
		frame.getContentPane().add(lblWebsite);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setBounds(30, 182, 89, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setBounds(30, 207, 89, 14);
		frame.getContentPane().add(lblPassword);
		
		branchAddressTF = new JTextField();
		branchAddressTF.setText(address);
		branchAddressTF.setBounds(129, 79, 195, 20);
		frame.getContentPane().add(branchAddressTF);
		branchAddressTF.setColumns(10);
		
		branchTelNumTF = new JTextField();
		branchTelNumTF.setText(num);
		branchTelNumTF.setBounds(129, 104, 195, 20);
		frame.getContentPane().add(branchTelNumTF);
		branchTelNumTF.setColumns(10);
		
		branchEmailTF = new JTextField();
		branchEmailTF.setText(email);
		branchEmailTF.setBounds(129, 129, 195, 20);
		frame.getContentPane().add(branchEmailTF);
		branchEmailTF.setColumns(10);
		
		branchWebTF = new JTextField();
		branchWebTF.setText(website);
		branchWebTF.setBounds(129, 154, 195, 20);
		frame.getContentPane().add(branchWebTF);
		branchWebTF.setColumns(10);
		
		branchUnameTF = new JTextField();
		branchUnameTF.setText(username);
		branchUnameTF.setBounds(129, 179, 195, 20);
		frame.getContentPane().add(branchUnameTF);
		branchUnameTF.setColumns(10);
		
		branchPwordTF = new JTextField();
		branchPwordTF.setText(password);
		branchPwordTF.setBounds(129, 204, 195, 20);
		frame.getContentPane().add(branchPwordTF);
		branchPwordTF.setColumns(10);
		
		btnUpdateBranch = new JButton("SAVE");
		btnUpdateBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"SUCCESSFULLY UPDATED");
			}
		});
		btnUpdateBranch.setBounds(176, 235, 89, 23);
		btnUpdateBranch.addActionListener(thecontroller);
		frame.getContentPane().add(btnUpdateBranch);
		frame.repaint();
		
		this.centreWindow();
	}
	
	//the view for secretary home page
	public void secretaryHome(ArrayList<branch> branch) {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompanynameProperties = new JLabel(branch.get(0).getName().toUpperCase() + " Branch Properties");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(200, 75, 189, 14);
		frame.getContentPane().add(lblCompanynameProperties);
		
		btnViewProperty = new JButton("VIEW PROPERTY");
		btnViewProperty.setBounds(50, 200, 200, 100);
		btnViewProperty.addActionListener(thecontroller);
		frame.getContentPane().add(btnViewProperty);
		
		btnAddProperty = new JButton("ADD PROPERTY");
		btnAddProperty.setBounds(325, 200, 200, 100);
		btnAddProperty.addActionListener(thecontroller);
		frame.getContentPane().add(btnAddProperty);
		
		
		btnBackFront = new JButton("BACK");
		btnBackFront.setBounds(540, 11, 89, 45);
		btnBackFront.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackFront);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		this.centreWindow();
	}
	
	//the view for add property
	public void addProperty() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompanynameProperties = new JLabel("ADD PROPERTY");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(225, 74, 122, 14);
		frame.getContentPane().add(lblCompanynameProperties);
		
		btnAddHouse = new JButton("HOUSE");
		btnAddHouse.setBounds(50, 200, 200, 100);
		btnAddHouse.addActionListener(thecontroller);
		frame.getContentPane().add(btnAddHouse);
		
		btnAddFlat = new JButton("FLAT");
		btnAddFlat.setBounds(325, 200, 200, 100);
		btnAddFlat.addActionListener(thecontroller);
		frame.getContentPane().add(btnAddFlat);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);	
		
		this.centreWindow();
	}
	
	//the view for add house
	public void addHouse() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblCompanynameProperties = new JLabel("ADD HOUSE");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(153, 16, 89, 23);
		frame.getContentPane().add(lblCompanynameProperties);
		

		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(30, 82, 69, 14);
		frame.getContentPane().add(lblAddress);
		
		houseaddressTF = new JTextField();
		houseaddressTF.setBounds(129, 79, 195, 20);
		frame.getContentPane().add(houseaddressTF);
		houseaddressTF.setColumns(10);
		
		JLabel lblRooms = new JLabel("ROOMS :");
		lblRooms.setBounds(30, 107, 89, 14);
		frame.getContentPane().add(lblRooms);
		
		JLabel lblPhoneNumber = new JLabel("SELLING PRICE:");
		lblPhoneNumber.setBounds(30, 132, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblWebsite = new JLabel("NUM. FLOORS:");
		lblWebsite.setBounds(30, 157, 89, 14);
		frame.getContentPane().add(lblWebsite);
		
		JLabel lblUsername = new JLabel("GARDEN:");
		lblUsername.setBounds(30, 182, 89, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("GARAGE:");
		lblPassword.setBounds(30, 207, 89, 14);
		frame.getContentPane().add(lblPassword);
		
		houseRoomsTF = new JTextField();
		houseRoomsTF.setBounds(129, 104, 195, 20);
		frame.getContentPane().add(houseRoomsTF);
		houseRoomsTF.setColumns(10);
		
		houseSellingPriceTF = new JTextField();
		houseSellingPriceTF.setBounds(129, 129, 195, 20);
		frame.getContentPane().add(houseSellingPriceTF);
		houseSellingPriceTF.setColumns(10);
		
		houseNumFloorsTF = new JTextField();
		houseNumFloorsTF.setBounds(129, 154, 195, 20);
		frame.getContentPane().add(houseNumFloorsTF);
		houseNumFloorsTF.setColumns(10);
		
		btnSaveHouse = new JButton("ADD");
		btnSaveHouse.setBounds(176, 235, 89, 23);
		btnSaveHouse.addActionListener(thecontroller);
		btnSaveHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"SUCCESSFULLY ADDED");
			}
		});
		frame.getContentPane().add(btnSaveHouse);
		
		comboBoxItems.add(Boolean.TRUE);
		comboBoxItems.add(Boolean.FALSE);
		
		houseGardenCombo = new JComboBox(comboBoxItems);
		houseGardenCombo.setBounds(129, 179, 195, 20);
		frame.getContentPane().add(houseGardenCombo);
		
		houseGarageCombo = new JComboBox(comboBoxItems);
		houseGarageCombo.setBounds(129, 204, 195, 20);
		frame.getContentPane().add(houseGarageCombo);
		
		this.centreWindow();
	}
	
	//the view for add flat page
	public void addFlat() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblCompanynameProperties = new JLabel("ADD FLAT");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(153, 16, 89, 23);
		frame.getContentPane().add(lblCompanynameProperties);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(30, 82, 69, 14);
		frame.getContentPane().add(lblAddress);
		
		flataddressTF = new JTextField();
		flataddressTF.setBounds(129, 79, 195, 20);
		frame.getContentPane().add(flataddressTF);
		flataddressTF.setColumns(10);
		
		JLabel lblRooms = new JLabel("ROOMS :");
		lblRooms.setBounds(30, 107, 89, 14);
		frame.getContentPane().add(lblRooms);
		
		JLabel lblPhoneNumber = new JLabel("SELLING PRICE:");
		lblPhoneNumber.setBounds(30, 132, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblWebsite = new JLabel("FLOOR ITS ON:");
		lblWebsite.setBounds(30, 157, 89, 14);
		frame.getContentPane().add(lblWebsite);
		
		JLabel lblUsername = new JLabel("MONTHLY RENT");
		lblUsername.setBounds(30, 182, 89, 14);
		frame.getContentPane().add(lblUsername);
		
		flatRoomsTF = new JTextField();
		flatRoomsTF.setBounds(129, 104, 195, 20);
		frame.getContentPane().add(flatRoomsTF);
		flatRoomsTF.setColumns(10);
		
		flatSellingPriceTF = new JTextField();
		flatSellingPriceTF.setBounds(129, 129, 195, 20);
		frame.getContentPane().add(flatSellingPriceTF);
		flatSellingPriceTF.setColumns(10);
		
		flatFloorNumTF = new JTextField();
		flatFloorNumTF.setBounds(129, 154, 195, 20);
		frame.getContentPane().add(flatFloorNumTF);
		flatFloorNumTF.setColumns(10);
		
		flatRentTF = new JTextField();
		flatRentTF.setBounds(129, 179, 195, 20);
		frame.getContentPane().add(flatRentTF);
		flatRentTF.setColumns(10);
		
		btnSaveFlat = new JButton("ADD");
		btnSaveFlat.setBounds(173, 210, 89, 23);
		btnSaveFlat.addActionListener(thecontroller);
		btnSaveFlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"SUCCESSFULLY ADDED");
			}
		});
		frame.getContentPane().add(btnSaveFlat);
		
		this.centreWindow();
	}
	
	//the view for view property page
	public void viewProperty() {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblViewBranch = new JLabel("VIEW PROPERTY");
		lblViewBranch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewBranch.setBounds(250, 21, 112, 14);
		frame.getContentPane().add(lblViewBranch);
		
		btnViewHouse = new JButton("HOUSE");
		btnViewHouse.setBounds(50, 200, 150, 100);
		btnViewHouse.addActionListener(thecontroller);
		frame.getContentPane().add(btnViewHouse);
		
		btnViewFlat = new JButton("FLAT");
		btnViewFlat.setBounds(250, 200, 150, 100);
		btnViewFlat.addActionListener(thecontroller);
		frame.getContentPane().add(btnViewFlat);
		
		btnViewSold = new JButton("SOLD ");
		btnViewSold.setBounds(450, 200, 150, 100);
		btnViewSold.addActionListener(thecontroller);
		frame.getContentPane().add(btnViewSold);
		
		this.centreWindow();
	}
	
	//the view for view house page
	public void viewHouse(ArrayList<house> houses) {

		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblViewBranch = new JLabel("VIEW HOUSE");
		lblViewBranch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewBranch.setBounds(163, 21, 95, 14);
		frame.getContentPane().add(lblViewBranch);
		
		for(int c=40,i=0; i< houses.size(); i++, c+=40) {
			JLabel lblNorthampton = new JLabel(i + ".");
			lblNorthampton.setText(i+1 + ". " + houses.get(i).getAddress());
			lblNorthampton.setBounds(10, 75+c, 126, 14);
			frame.getContentPane().add(lblNorthampton);
			
			hSellButtons[i] =  new JButton("SELL");
			hSellButtons[i].addActionListener(thecontroller);
			hSellButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					housePrice = JOptionPane.showInputDialog("Enter Price");
				}
			});
			hSellButtons[i].setBounds(135, 71+c, 89, 23);
			frame.getContentPane().add(hSellButtons[i]);
			
			hModbuttons[i] = new JButton("MODIFY");
			hModbuttons[i].setBounds(236, 71+c, 89, 23);
			hModbuttons[i].addActionListener(thecontroller);
			frame.getContentPane().add(hModbuttons[i]);
			
			hDelButtons[i] = new JButton("DELETE");
			hDelButtons[i].addActionListener(thecontroller);
			hDelButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,"SUCCESSFULLY DELETED");
				}
			});
			hDelButtons[i].setBounds(335, 71+c, 89, 23);
			frame.getContentPane().add(hDelButtons[i]);
		}
		
		
		this.centreWindow();
	}
	
	//the view for modify house page
	public void modifyHouse(String address, int num_rooms, int selling_price, int sold_price, boolean isSold, int num_floors, boolean has_garage, boolean has_garden) {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"PLEASE CLICK SAVE TO GO BACK");
			}
		});
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblCompanynameProperties = new JLabel("MODIFY HOUSE");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(153, 16, 112, 23);
		frame.getContentPane().add(lblCompanynameProperties);
		
		JLabel lblName = new JLabel("ROOMS:");
		lblName.setBounds(30, 82, 69, 14);
		frame.getContentPane().add(lblName);
		
		houseRoomsTF = new JTextField();
		houseRoomsTF.setText(Integer.toString(num_rooms));
		houseRoomsTF.setBounds(129, 79, 195, 20);
		frame.getContentPane().add(houseRoomsTF);
		houseRoomsTF.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(30, 107, 89, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("SELLING PRICE:");
		lblPhoneNumber.setBounds(30, 132, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblWebsite = new JLabel("NUM. FLOORS:");
		lblWebsite.setBounds(30, 157, 89, 14);
		frame.getContentPane().add(lblWebsite);
		
		JLabel lblUsername = new JLabel("GARDEN:");
		lblUsername.setBounds(30, 182, 89, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("GARAGE:");
		lblPassword.setBounds(30, 207, 89, 14);
		frame.getContentPane().add(lblPassword);
		
		houseaddressTF = new JTextField();
		houseaddressTF.setText(address);
		houseaddressTF.setBounds(129, 104, 195, 20);
		frame.getContentPane().add(houseaddressTF);
		houseaddressTF.setColumns(10);
		
		houseSellingPriceTF = new JTextField();
		houseSellingPriceTF.setText(Integer.toString(selling_price));
		houseSellingPriceTF.setBounds(129, 129, 195, 20);
		frame.getContentPane().add(houseSellingPriceTF);
		houseSellingPriceTF.setColumns(10);
		
		houseNumFloorsTF = new JTextField();
		houseNumFloorsTF.setText(Integer.toString(num_floors));
		houseNumFloorsTF.setBounds(129, 154, 195, 20);
		frame.getContentPane().add(houseNumFloorsTF);
		houseNumFloorsTF.setColumns(10);
		
		btnUpdateHouse = new JButton("SAVE");
		btnUpdateHouse.setBounds(176, 235, 89, 23);
		btnUpdateHouse.addActionListener(thecontroller);
		frame.getContentPane().add(btnUpdateHouse);
		
		comboBoxItems.add(Boolean.TRUE);
		comboBoxItems.add(Boolean.FALSE);
		
		houseGardenCombo = new JComboBox(comboBoxItems);
		houseGardenCombo.setSelectedItem(has_garden);
		houseGardenCombo.setBounds(129, 179, 195, 20);
		frame.getContentPane().add(houseGardenCombo);
		
		houseGarageCombo = new JComboBox(comboBoxItems);
		houseGarageCombo.setSelectedItem(has_garage);
		houseGarageCombo.setBounds(129, 204, 195, 20);
		frame.getContentPane().add(houseGarageCombo);
		
		this.centreWindow();
	}
	
	//the view for view flat page
	public void viewFlat(ArrayList<flat> flats) {	
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblViewBranch = new JLabel("VIEW FLAT");
		lblViewBranch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewBranch.setBounds(174, 20, 95, 14);
		frame.getContentPane().add(lblViewBranch);
		
		for(int c=40,i=0; i< flats.size(); i++, c+=40) {
			//int count =1;
			JLabel lblNorthampton = new JLabel(i + ".");
			lblNorthampton.setText(i+1 + ". " + flats.get(i).getAddress());
			lblNorthampton.setBounds(10, 75+c, 126, 14);
			frame.getContentPane().add(lblNorthampton);
			
			fSellButtons[i] = new JButton("SELL");
			fSellButtons[i].setBounds(135, 71+c, 89, 23);
			fSellButtons[i].addActionListener(thecontroller);
			fSellButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flatPrice = JOptionPane.showInputDialog("Enter Price");
				}
			});
			frame.getContentPane().add(fSellButtons[i]);
			
			fModbuttons[i] = new JButton("MODIFY");
			fModbuttons[i].setBounds(236, 71+c, 89, 23);
			fModbuttons[i].addActionListener(thecontroller);
			frame.getContentPane().add(fModbuttons[i]);
			
			fDelButtons[i] = new JButton("DELETE");
			fDelButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,"SUCCESSFULLY DELETED");
				}
			});
			fDelButtons[i].setBounds(335, 71+c, 89, 23);
			fDelButtons[i].addActionListener(thecontroller);
			frame.getContentPane().add(fDelButtons[i]);
		}
		
	
		
		this.centreWindow();
	}
	
	//the view for modify flat page
	public void modifyFlat(String address, int num_rooms, int selling_price, int sold_price, boolean isSold, int floor_num, int monthly_charge) {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PLEASE CLICK SAVE TO GO BACK");
			}
		});
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblCompanynameProperties = new JLabel("MODIFY FLAT");
		lblCompanynameProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanynameProperties.setBounds(153, 16, 112, 23);
		frame.getContentPane().add(lblCompanynameProperties);
		
		JLabel lblName = new JLabel("ROOMS:");
		lblName.setBounds(30, 82, 69, 14);
		frame.getContentPane().add(lblName);
		
		flatRoomsTF = new JTextField();
		flatRoomsTF.setText(Integer.toString(num_rooms));
		flatRoomsTF.setBounds(129, 79, 195, 20);
		frame.getContentPane().add(flatRoomsTF);
		flatRoomsTF.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setBounds(30, 107, 89, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("SELLING PRICE:");
		lblPhoneNumber.setBounds(30, 132, 89, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblWebsite = new JLabel("FLOOR ITS ON:");
		lblWebsite.setBounds(30, 157, 89, 14);
		frame.getContentPane().add(lblWebsite);
		
		JLabel lblUsername = new JLabel("MONTHLY RENT:");
		lblUsername.setBounds(30, 182, 101, 14);
		frame.getContentPane().add(lblUsername);
		
		flataddressTF = new JTextField();
		flataddressTF.setText(address);
		flataddressTF.setBounds(129, 104, 195, 20);
		frame.getContentPane().add(flataddressTF);
		flataddressTF.setColumns(10);
		
		flatSellingPriceTF = new JTextField();
		flatSellingPriceTF.setText(Integer.toString(selling_price));
		flatSellingPriceTF.setBounds(129, 129, 195, 20);
		frame.getContentPane().add(flatSellingPriceTF);
		flatSellingPriceTF.setColumns(10);
		
		flatFloorNumTF = new JTextField();
		flatFloorNumTF.setText(Integer.toString(floor_num));
		flatFloorNumTF.setBounds(129, 154, 195, 20);
		frame.getContentPane().add(flatFloorNumTF);
		flatFloorNumTF.setColumns(10);
		
		btnUpdateFlat = new JButton("SAVE");
		btnUpdateFlat.addActionListener(thecontroller);
		btnUpdateFlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED");
			}
		});
		btnUpdateFlat.setBounds(176, 235, 89, 23);
		frame.getContentPane().add(btnUpdateFlat);
		
		flatRentTF = new JTextField();
		flatRentTF.setBounds(129, 179, 195, 20);
		frame.getContentPane().add(flatRentTF);
		flatRentTF.setColumns(10);
		
		this.centreWindow();
	}
	
	//the view for sold properties page
	public void soldProperties(ArrayList<house> soldHouses, ArrayList<flat> soldFlats) {
		frame.removeAll();
		frame.revalidate();	
		frame.setVisible(false);
		
		frame = new JFrame();
		frame.setTitle("Properties Company App");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("IMAGE");
		btnImage.setBounds(10, 11, 89, 45);
		frame.getContentPane().add(btnImage);
		
		btnBackSecHome = new JButton("BACK");
		btnBackSecHome.setBounds(540, 11, 89, 45);
		btnBackSecHome.addActionListener(thecontroller);
		frame.getContentPane().add(btnBackSecHome);
		
		JLabel lblViewBranch = new JLabel("VIEW SOLD PROPERTIES");
		lblViewBranch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewBranch.setBounds(180, 50, 200, 14);
		frame.getContentPane().add(lblViewBranch);
		
		for(int c=40,i=0; i< soldHouses.size(); i++, c+=40) {
			//int count =1;
			JLabel lblNorthampton = new JLabel(i+1+". "+soldHouses.get(i).getAddress());
			lblNorthampton.setBounds(10, 75+c, 126, 14);
			frame.getContentPane().add(lblNorthampton);
			
			JLabel price = new JLabel("PRICE: " + soldHouses.get(i).getSoldPrice());
			price.setBounds(200, 71+c, 89, 23);
			frame.getContentPane().add(price);
			
			JLabel type = new JLabel("HOUSE");
			type.setBounds(100, 71+c, 89, 23);
			frame.getContentPane().add(type);

		}
		for(int c=40,i=0; i< soldFlats.size(); i++, c+=40) {
			//int count =1;
			JLabel lblNorthampton = new JLabel(i+1+". "+soldFlats.get(i).getAddress());
			lblNorthampton.setBounds(350, 75+c, 126, 14);
			frame.getContentPane().add(lblNorthampton);
			
			JLabel price = new JLabel("PRICE: " + soldFlats.get(i).getSoldPrice());
			price.setBounds(500, 71+c, 89, 23);
			frame.getContentPane().add(price);
			
			JLabel type = new JLabel("FLAT");
			type.setBounds(430, 71+c, 89, 23);
			frame.getContentPane().add(type);

		}
		
		
		
		this.centreWindow();
	}
	


	//getter and setter

	public String getUsername() {
		 return username.getText();
		//return username;
	}



	public void setUsername(JTextField username) {
		this.username = username;
	}



	public String getPassword() {
		return password.getText();
	}



	public void setPassword(JTextField password) {
		this.password = password;
	}
	


	//branch getter and setters
	public String getBranchNameTF() {
		return branchNameTF.getText();
	}

	public void setBranchNameTF(String branchNameTF) {
		this.branchNameTF.setText(branchNameTF); 
		//= branchNameTF;
	}

	public String getBranchAddressTF() {
		return branchAddressTF.getText();
	}

	public void setBranchAddressTF(String branchAddressTF) {
		this.branchAddressTF.setText(branchAddressTF);
	}

	public String getBranchTelNumTF() {
		return branchTelNumTF.getText();
	}

	public void setBranchTelNumTF(String branchTelNumTF) {
		this.branchTelNumTF.setText(branchTelNumTF); 
	}

	public String getBranchEmailTF() {
		return branchEmailTF.getText();
	}

	public void setBranchEmailTF(String branchEmailTF) {
		this.branchEmailTF.setText(branchEmailTF);
	}

	public String getBranchWebTF() {
		return branchWebTF.getText();
	}

	public void setBranchWebTF(String branchWebTF) {
		this.branchWebTF.setText(branchWebTF);
	}

	public String getBranchUnameTF() {
		return branchUnameTF.getText();
	}

	public void setBranchUnameTF(String branchUnameTF) {
		this.branchUnameTF.setText(branchUnameTF);
	}

	public String getBranchPwordTF() {
		return branchPwordTF.getText();
	}

	public void setBranchPwordTF(String branchPwordTF) {
		this.branchPwordTF.setText(branchPwordTF);
	}

	public int getHouseRoomsTF() {
		return Integer.parseInt(houseRoomsTF.getText());
	}

	public void setHouseRoomsTF(int houseRoomsTF) {
		this.houseRoomsTF.toString();
	}

	public String getHouseaddressTF() {
		return houseaddressTF.getText();
	}

	public void setHouseaddressTF(String houseaddressTF) {
		this.houseaddressTF.setText(houseaddressTF);
	}

	public int getHouseSellingPriceTF() {
		//return houseSellingPriceTF;
		return Integer.parseInt(houseSellingPriceTF.getText());
	}

	public void setHouseSellingPriceTF(int houseSellingPriceTF) {
		this.houseSellingPriceTF.toString();
	}

	public int getHouseSoldPriceTF() {
		return Integer.parseInt(houseSoldPriceTF.getText());
	}

	public void setHouseSoldPriceTF(int houseSoldPriceTF) {
		this.houseSoldPriceTF.toString();
	}

	public int getHouseNumFloorsTF() {
		return Integer.parseInt(houseNumFloorsTF.getText());
	}

	public void setHouseNumFloorsTF(int houseNumFloorsTF) {
		this.houseNumFloorsTF.toString();
	}

	public Boolean getHouseGardenCombo() {
		return (Boolean) houseGardenCombo.getSelectedItem();
	}

	public void setHouseGardenCombo(Boolean houseGardenCombo) {
		this.houseGardenCombo.setSelectedItem(houseGardenCombo); 
	}

	public Boolean getHouseGarageCombo() {
		return (Boolean) houseGarageCombo.getSelectedItem();
	}

	public void setHouseGarageCombo(Boolean houseGarageCombo) {
		this.houseGarageCombo.setSelectedItem(houseGarageCombo); 
	}

	public String getFlatRoomsTF() {
		return flatRoomsTF.getText();
	}

	public void setFlatRoomsTF(String flatRoomsTF) {
		this.flatRoomsTF.setText(flatRoomsTF);
	}

	public String getFlataddressTF() {
		return flataddressTF.getText();
	}

	public void setFlataddressTF(String flataddressTF) {
		this.flataddressTF.setText(flataddressTF);
	}

	public int getFlatSellingPriceTF() {
		//return flatSellingPriceTF;
		return Integer.parseInt(flatSellingPriceTF.getText());
	}

	public void setFlatSellingPriceTF(int flatSellingPriceTF) {
		this.flatSellingPriceTF.toString();
	}

	public int getFlatSoldPriceTF() {
		return Integer.parseInt(flatSoldPriceTF.getText());
	}

	public void setFlatSoldPriceTF(int flatSoldPriceTF) {
		this.flatSoldPriceTF.toString();
	}

	public int getFlatFloorNumTF() {
		return Integer.parseInt(flatFloorNumTF.getText());
	}

	public void setFlatFloorNumTF(int flatFloorNumTF) {
		this.flatFloorNumTF.toString();
	}

	public int getFlatRentTF() {
		return Integer.parseInt(flatRentTF.getText());
	}

	public void setFlatRentTF(int flatRentTF) {
		this.flatRentTF.toString();
	}

	public JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


}
