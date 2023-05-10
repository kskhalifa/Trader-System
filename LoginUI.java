import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.io.*;
import java.util.*;

public class LoginUI extends JFrame implements ActionListener {
	
	private static LoginUI frame;
	private JPanel logP;
	private JLabel userL, passL;
	private JTextField userF, passF;
	private JButton logBtn;
	
	public LoginUI() {
		// Creating the Login form
		userL = new JLabel("Username: ");
		userF = new JTextField(10);
		passL = new JLabel("Password: ");
		passF = new JPasswordField(10);
		logBtn = new JButton("Submit!");
		
		logP = new JPanel(new GridLayout(3,2));
		logP.add(userL);
		logP.add(userF);
		logP.add(passL);
		logP.add(passF);
		logP.add(logBtn);
		
		add(logP);
		logBtn.addActionListener(this);
		setTitle("Login");
	}
	public static void main(String[] args) {
		
		frame = new LoginUI();
		frame.setSize(300,200);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// checks the credential of the user
		String usrName = userF.getText();
		String usrPass = passF.getText();
		
		String[][] credential = getUsers();
		
		if (checkCred(usrName,usrPass,credential)) {
			// go to the main ui
			Login User = new Login(usrName);
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			MainUI.main(null);
		} else {
			JOptionPane.showMessageDialog(null,  "Wrong username or password!");
			System.exit(0);
		}
	}

	private String[][] getUsers() {
		String[][] cred = new String[3][3];
		int i = 0, j = 0;
		try {
			File myFile = new File("Credential.txt");
			Scanner read = new Scanner(myFile);
			while (read.hasNextLine()) {
				cred[i][j] = read.nextLine();
				j++;
				if (j == 2) {
					i++;
					j = 0;
				}
			}
			read.close();
			return cred;
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist!");
			return null;
		}
	}
	
	private boolean checkCred(String name, String pass, String[][] cred) {
		boolean passed = false;
		for (int i = 0; i < 3; i++) {
			if (cred[i][0].equals(name)) {
				if (cred[i][1].equals(pass)) {
					passed = true;
				}
			}
		}
		return passed;
	}
}
