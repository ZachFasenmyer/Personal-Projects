package cryoshell;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Master {
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static void main(String[] args) throws IOException {
		
		boolean repeat = true;
		int choice = 0;
		
		while(repeat == true) {
		
		if(JOptionPane.showConfirmDialog(null, "Shall we proceed?", "Welcome, I am Cryptonite",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			repeat = true;
				} else {
					repeat = false;
					System.exit(0);
				}
		
		Object[] obj = {"Encrypt", "Decrypt"};
			
			choice = JOptionPane.showOptionDialog(null, "<CRYPTONITE>\n\n",
	                "Choose an Action",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, obj, obj[1]);	
		
		if(choice == 0) {
			Encrypter.main(args);
		} 
		if(choice == 1) {
			DeCrypter.main(args);
		} else {
			
		}
			
		}
		System.exit(0);
	}
}
