package cryoshell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DeCrypter {
	
	private int shiftSetting;
	private int charSetting;
	
	private int[] shiftKey;
	private int[] charKey;
	//File I read/write to/from
	private String fileIRead = "Encrypted Stuff";
	private String fileIWriteTo = "Decrypted Stuff";
	
	private int positionKeySpecial = 13; //Reference the same variable in Encrypter

	public int getShiftSetting() {
		return shiftSetting;
	}
	public void setShiftSetting(int shiftSetting) {
		this.shiftSetting = shiftSetting;
	}
	public int getCharSetting() {
		return charSetting;
	}
	public void setCharSetting(int charSetting) {
		this.charSetting = charSetting;
	}
	public int[] getShiftKey() {
		return shiftKey;
	}
	public void setShiftKey(int[] shiftKey) {
		this.shiftKey = shiftKey;
	}
	public int[] getCharKey() {
		return charKey;
	}
	public void setCharKey(int[] charKey) {
		this.charKey = charKey;
	}
	public String getFileIRead() {
		return fileIRead;
	}
	public String getFileIWriteTo() {
		return fileIWriteTo;
	}
	public int getPositionKeySpecial() {
		return positionKeySpecial;
	}
	
	//Higher functions
	public int[] decryptCharKey(String message, char[] key) {
		char[] messageToCharArray = message.toCharArray();
		int[] output = new int[messageToCharArray.length];
		char[] k = key.clone();
		
		for(int c = 0; c < messageToCharArray.length; c++) {
			char pos = messageToCharArray[c];
			
				for (int b = 0; b < k.length; b++) {
					if(pos == k[b]) {
						output[c] = b;
					}	
			}
		}
		return output;
	}
	
public int[] decryptPosition(int[] message, int stopHere) {
		
		//****************************************
		//Declares tempArray to hold newM while it is* changed
		int[] tempC = new int[message.length - 1];
		//Adding character to specific place!!
		//Switching numbers based on extra key (For now its set)
		//Adds a random number to the position selected
		boolean minused = false;
		minused = false;// Tells the aforementioned loop that the insertion has occurred
		//Inserting new number from randKey, based on choiceKey
		for(int c = 0; c < tempC.length; c++) {
			//Copies characters until stopHere happens
				if(c == stopHere) {//Note: stopHere - 1 because it must be half of what will be
					tempC[c] = message[c + 1];
					minused = true;
				} else {
					if(minused == true) {
						tempC[c] = message[c + 1];
						}
					else {
						tempC[c] = message[c];
						}
				}
			}
				//****************************************
		//New Message to be returned
		int[] newM = new int[tempC.length];
			//Rearranging odd numbers
				//Start with position 1, Counter moves normally through m
				int x = 1;
				//Starts with 0 to get odds
				int y = 0;
				//c rearranges newM to original order
			while(x < tempC.length) {
				newM[x] = tempC[y];
				x = x + 2;
				y++;
				
			}
			//Rearranging even numbers
				//Counter starts where first loop left off
				//Uses y
				//Starts with even 0
				int w = 0;
			while(w < tempC.length) {
				newM[w] = tempC[y];
				y++;
				w = w + 2;	
				}
		return newM;
	}
	
	public int[] loopDecryptPosition(int[] message, int iterations, int[] choiceKey, int[] randKey) {
		int[] newM = new int[message.length];
		
		newM = message.clone();
		
		int stopHere = 0;//Tried more complex, didn't work, will rework
			
			for(int c = 0; c < iterations; c++)	
				newM = decryptPosition(newM, stopHere);
		return newM;
	}
	
	public int[] decryptMultKey(int[] message, double[] key) {
		int[] output = new int[message.length];
		//counters	
			int x = 0;
			int y = 0;
			//holds product till its converted to int
			double temp = 0.0;
			
		double[] k = key.clone();
		while(x < message.length) {
			//If number breaks array bounds, reset to 0
			if(y < k.length) {
				temp = message[x] / k[y];
				output[x] = (int) Math.round(temp);
				x++; y++;
			} else {
				y = 0;
			}
		}
		return output;
	}
	
	public int[] decryptShiftKey(int[] message, int[] key) {
		int[] output = new int[message.length];
		int[] k = key.clone();
		//counters
			int x = 0;
			int y = 0;
		
		while(x < message.length) {
			if(y < k.length) {
				output[x] = message[x] - k[y];
				x++; y++;
			}else {
				y = 0;
			}
		}
		return output;
	}
	
	public char[] translateIntToChar(int[] message, int[] key) {
		char[] output = new char[message.length];
		int[] k = key.clone();
		int x = 0;
		char[] translater = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
				's','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7',
				'8','9',' ','.','&',',','!','?','\'','#','$','%','\"',':',';','+','-','=','/','*','_',
				'(',')','<','>','{','}','[',']','^','@','`'};
		
		for(int c = 0; c < message.length; c++) {
			x = message[c];
			for(int b = 0; b < translater.length; b++) {
				if(x == k[b]) {
					output[c] = translater[b];
				}
			}
		}
		return output;
	}
	
	//Takes integer-form message and char key it was switched with
		//outputs char equivalents of positions in said key
	public int[] decryptCharPositionSwitch(int[] intMessage, char[] keyWithNum, char[] keyWithChar) {
		int[] output = new int[intMessage.length];
		int[] m = intMessage.clone();
		char[] kN = keyWithNum.clone();
		char[] kC = keyWithChar.clone();
		//Holder for current position in message
		int M = 0;
		char C = 'a';
		//1st loop selects current position of message
		for(int x = 0; x < m.length; x++) {
			M = m[x];
			//2nd loop gets character in X's position
			for(int y = 0; y < kC.length; y++) {
				if(y == M)
					C = kC[y];
				for(int z = 0; z < kN.length; z++) {
					if(kN[z] == C)
						output[x] = z;
				}
			}
		}	
		return output;
	}
	
	public String fileReader(String filename) throws IOException {
		String readFromMe = getFileIRead();
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(readFromMe+"/"+filename), "UTF8"));
			StringBuilder output = new StringBuilder();
			String line;
		
		while((line = read.readLine()) != null) {
			output.append(line);
			System.out.print(line + ",");
		}
	read.close();
	return output.toString();
}
	
	public void fileWriter(char[] message, String filename) throws IOException {
		String writeToMe = getFileIWriteTo();
	   	OutputStreamWriter writer = new OutputStreamWriter(
	   			new FileOutputStream(writeToMe+"/"+filename), "UTF-8");
		   	for(int c = 0; c < message.length; c++)	{			   			
		   		writer.write(message[c]);
		   		System.out.print(message[c] + ",");
		   	}
		   	writer.close();
}
	
	public static void main(String[] args) throws IOException {
		DeCrypter d = new DeCrypter();
		KeyLibrary kl = new KeyLibrary();
		CharKeyLibrary ck = new CharKeyLibrary();
		String message = "";
		
		JOptionPane.showMessageDialog(null,
				"1. I decrypt all Alphabetic, Numerical and Special Characters you see on your keyboard. Not custom symbols!"
						+ "\n2. First, place your file in the Encrypted Stuff folder\n"
						+ "3. Click OK to choose file");
			
			final JFileChooser fc = new JFileChooser("Encrypted Stuff");
			File filename = null;
			int returnVal = fc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			filename = fc.getSelectedFile();} else {
				System.out.println("File opener cancelled\n");
			}
			message = d.fileReader(filename.getName());
		//Initial integer encryption
		Object[] initKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int initKeyChoice = JOptionPane.showOptionDialog(null, "Choose 1st Setting",
                "<Decrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, initKeys, initKeys[9]);
		
		int[] initSetting = new int[kl.getInitKeySize()];
		switch(initKeyChoice) {
		case 0: initSetting = kl.getI0(); break;
		case 1: initSetting = kl.getI1(); break;
		case 2: initSetting = kl.getI2(); break;
		case 3: initSetting = kl.getI3(); break;
		case 4: initSetting = kl.getI4(); break;
		case 5: initSetting = kl.getI5(); break;
		case 6: initSetting = kl.getI6(); break;
		case 7: initSetting = kl.getI7(); break;
		case 8: initSetting = kl.getI8(); break;
		case 9: initSetting = kl.getI9(); break;
		default: initSetting = kl.getI0();
		}
		
		Object[] charKeys1 = {"0","1","2","3","4","5","6","7","8","9"};
		int charKeyChoice1 = JOptionPane.showOptionDialog(null, "Choose 2nd Setting",
                "<Decrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charKeys1, charKeys1[9]);
		
		char[] charSwitchSetting1 = new char[kl.getSwitchKeySize()];
		switch(charKeyChoice1) {
		case 0: charSwitchSetting1 = kl.getW0(); break;
		case 1: charSwitchSetting1 = kl.getW1(); break;
		case 2: charSwitchSetting1 = kl.getW2(); break;
		case 3: charSwitchSetting1 = kl.getW3(); break;
		case 4: charSwitchSetting1 = kl.getW4(); break;
		case 5: charSwitchSetting1 = kl.getW5(); break;
		case 6: charSwitchSetting1 = kl.getW6(); break;
		case 7: charSwitchSetting1 = kl.getW7(); break;
		case 8: charSwitchSetting1 = kl.getW8(); break;
		case 9: charSwitchSetting1 = kl.getW9(); break;
		default: charSwitchSetting1 = kl.getW0();
		}
		
		Object[] charSwitchKeys1 = {"0","1","2","3","4","5","6","7","8","9"};
		int charSwitchKeyChoice1 = JOptionPane.showOptionDialog(null, "Choose 3rd Setting",
                "<Decrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys1, charSwitchKeys1[9]);
		
		char[] charSwitchSetting2 = new char[kl.getSwitchKeySize()];
		switch(charSwitchKeyChoice1) {
		case 0: charSwitchSetting2 = kl.getW10(); break;
		case 1: charSwitchSetting2 = kl.getW11(); break;
		case 2: charSwitchSetting2 = kl.getW12(); break;
		case 3: charSwitchSetting2 = kl.getW13(); break;
		case 4: charSwitchSetting2 = kl.getW14(); break;
		case 5: charSwitchSetting2 = kl.getW15(); break;
		case 6: charSwitchSetting2 = kl.getW16(); break;
		case 7: charSwitchSetting2 = kl.getW17(); break;
		case 8: charSwitchSetting2 = kl.getW18(); break;
		case 9: charSwitchSetting2 = kl.getW19(); break;
		default: charSwitchSetting2 = kl.getW10();
		}
		
		Object[] multKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int multKeyChoice = JOptionPane.showOptionDialog(null, "Choose 4th Setting\n",
                "<Decrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, multKeys, multKeys[9]);
		
		double[] multSetting = new double[kl.getMultKeySize()];
		switch(multKeyChoice) {
		case 0: multSetting = kl.getM0(); break;
		case 1: multSetting = kl.getM1(); break;
		case 2: multSetting = kl.getM2(); break;
		case 3: multSetting = kl.getM3(); break;
		case 4: multSetting = kl.getM4(); break;
		case 5: multSetting = kl.getM5(); break;
		case 6: multSetting = kl.getM6(); break;
		case 7: multSetting = kl.getM7(); break;
		case 8: multSetting = kl.getM8(); break;
		case 9: multSetting = kl.getM9(); break;
		default: multSetting = kl.getM0(); 
		}
		
		Object[] shiftKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int shiftKeyChoice = JOptionPane.showOptionDialog(null, "Choose 5th Setting",
                "<Decrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shiftKeys, shiftKeys[9]);
		
		int[] shiftSetting = new int[kl.getShiftKeySize()];
		switch(shiftKeyChoice) {
		case 0: shiftSetting = kl.getS0(); break;
		case 1: shiftSetting = kl.getS1(); break;
		case 2: shiftSetting = kl.getS2(); break;
		case 3: shiftSetting = kl.getS3(); break;
		case 4: shiftSetting = kl.getS4(); break;
		case 5: shiftSetting = kl.getS5(); break;
		case 6: shiftSetting = kl.getS6(); break;
		case 7: shiftSetting = kl.getS7(); break;
		case 8: shiftSetting = kl.getS8(); break;
		case 9: shiftSetting = kl.getS9(); break;
		default: shiftSetting = kl.getS0();
		}
		//Switch Encryption 2
		Object[] charSwitchKeys3 = {"0","1","2","3","4","5","6","7","8","9"};
		int charSwitchKeyChoice3 = JOptionPane.showOptionDialog(null, "Choose 6th Setting",
				"<Decrypter>",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys3, charSwitchKeys3[9]);
				
		char[] charSwitchSetting3 = new char[kl.getCharKeySize()];
		switch(charSwitchKeyChoice3) {
		case 0: charSwitchSetting3 = ck.getC0(); break;
		case 1: charSwitchSetting3 = ck.getC1(); break;
		case 2: charSwitchSetting3 = ck.getC2(); break;
		case 3: charSwitchSetting3 = ck.getC3(); break;
		case 4: charSwitchSetting3 = ck.getC4(); break;
		case 5: charSwitchSetting3 = ck.getC5(); break;
		case 6: charSwitchSetting3 = ck.getC6(); break;
		case 7: charSwitchSetting3 = ck.getC7(); break;
		case 8: charSwitchSetting3 = ck.getC8(); break;
		case 9: charSwitchSetting3 = ck.getC9(); break;
		default: charSwitchSetting3 = ck.getC0();
		}
		
		Object[] charSwitchKeys4 = {"0","1","2","3","4","5","6","7","8","9"};
		int charSwitchKeyChoice4 = JOptionPane.showOptionDialog(null, "Choose 7th Setting",
				"<Decrypter>",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys4, charSwitchKeys4[9]);
				
		char[] charSwitchSetting4 = new char[kl.getCharKeySize()];
		switch(charSwitchKeyChoice4) {
		case 0: charSwitchSetting4 = ck.getC10(); break;
		case 1: charSwitchSetting4 = ck.getC11(); break;
		case 2: charSwitchSetting4 = ck.getC12(); break;
		case 3: charSwitchSetting4 = ck.getC13(); break;
		case 4: charSwitchSetting4 = ck.getC14(); break;
		case 5: charSwitchSetting4 = ck.getC15(); break;
		case 6: charSwitchSetting4 = ck.getC16(); break;
		case 7: charSwitchSetting4 = ck.getC17(); break;
		case 8: charSwitchSetting4 = ck.getC18(); break;
		case 9: charSwitchSetting4 = ck.getC19(); break;
		default: charSwitchSetting4 = ck.getC10();
		}
		
		//Position Encryption (Random and Choice)
		Object[] positionKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int positionKeyChoice = JOptionPane.showOptionDialog(null, "Choose 8th Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, positionKeys, positionKeys[9]);
		
		int[] positionSetting = new int[kl.getPositionKeySize()];
		switch(positionKeyChoice) {
		case 0: positionSetting = kl.getP0(); break;
		case 1: positionSetting = kl.getP1(); break;
		case 2: positionSetting = kl.getP2(); break;
		case 3: positionSetting = kl.getP3(); break;
		case 4: positionSetting = kl.getP4(); break;
		case 5: positionSetting = kl.getP5(); break;
		case 6: positionSetting = kl.getP6(); break;
		case 7: positionSetting = kl.getP7(); break;
		case 8: positionSetting = kl.getP8(); break;
		case 9: positionSetting = kl.getP9(); break;
		default: positionSetting = kl.getP0();
		}
		
		
		
		Object[] choiceKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int choiceKeyChoice = JOptionPane.showOptionDialog(null, "Choose 9th Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choiceKeys, choiceKeys[9]);
		
		int[] choiceSetting = new int[kl.getChoiceKeySize()];
		switch(choiceKeyChoice) {
		case 0: choiceSetting = kl.getCH0(); break;
		case 1: choiceSetting = kl.getCH1(); break;
		case 2: choiceSetting = kl.getCH2(); break;
		case 3: choiceSetting = kl.getCH3(); break;
		case 4: choiceSetting = kl.getCH4(); break;
		case 5: choiceSetting = kl.getCH5(); break;
		case 6: choiceSetting = kl.getCH6(); break;
		case 7: choiceSetting = kl.getCH7(); break;
		case 8: choiceSetting = kl.getCH8(); break;
		case 9: choiceSetting = kl.getCH9(); break;
		default: choiceSetting = kl.getCH0();
		}
		
		//Character Encryption
		Object[] charKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int charKeyChoice = JOptionPane.showOptionDialog(null, "Choose 10th Setting",
                "<Decrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charKeys, charKeys[9]);
		
		char[] charSetting = new char[258];
		switch(charKeyChoice) {
		case 0: charSetting = ck.getC20(); break;
		case 1: charSetting = ck.getC21(); break;
		case 2: charSetting = ck.getC22(); break;
		case 3: charSetting = ck.getC23(); break;
		case 4: charSetting = ck.getC24(); break;
		case 5: charSetting = ck.getC25(); break;
		case 6: charSetting = ck.getC26(); break;
		case 7: charSetting = ck.getC27(); break;
		case 8: charSetting = ck.getC28(); break;
		case 9: charSetting = ck.getC29(); break;
		default: charSetting = ck.getC20();
		}
		
			//Reverse Character Encryption
		int[] charToInt = new int[message.length()]; 
		charToInt = d.decryptCharKey(message, charSetting);
			//Reverse Position Encryption
		int special = d.getPositionKeySpecial();
		int[] dePosition = d.loopDecryptPosition(charToInt, positionKeyChoice + choiceKeyChoice + special,
		choiceSetting, positionSetting);
			//Reverse Switch 2
		int[] deSwitch2 = new int[dePosition.length];
		deSwitch2 = d.decryptCharPositionSwitch(dePosition, charSwitchSetting3, charSwitchSetting4);
			//Reverse Shift Encryption
		int[] deShifted = new int[dePosition.length]; 
		deShifted = d.decryptShiftKey(deSwitch2, shiftSetting);
			//Reverse Multiple Encryption
		int[] deMulted = new int[dePosition.length]; 
		deMulted = d.decryptMultKey(deShifted, multSetting);
			//Reverse Switch1
		int[] deSwitch1 = new int[dePosition.length]; 
		deSwitch1 = d.decryptCharPositionSwitch(deMulted, charSwitchSetting1, charSwitchSetting2); 
			//Translate machine values to human form
		char[] finalDecrypt = new char[dePosition.length]; 
		finalDecrypt = d.translateIntToChar(deSwitch1, initSetting);

		 d.fileWriter(finalDecrypt, filename.getName());
		 JOptionPane.showMessageDialog(null,filename.getName() + " has been saved to Decrypted Stuff (folder)");
		 
		 //show me
		System.out.println();
		for(int i = 0; i < charToInt.length; i++) {
			System.out.print(charToInt[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < dePosition.length; i++) {
			System.out.print(dePosition[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < deSwitch2.length; i++) {
			System.out.print(deSwitch2[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < deShifted.length; i++) {
			System.out.print(deShifted[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < deMulted.length; i++) {
			System.out.print(deMulted[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < deSwitch1.length; i++) {
			System.out.print(deSwitch1[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < finalDecrypt.length; i++) {
			System.out.print(finalDecrypt[i] + ",");
		}
	}
}