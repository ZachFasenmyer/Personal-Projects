package cryoshell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Encrypter{
	//Settings values
	private int[] shiftKey;
	private char[] charKey;
	private String encryptedMessage;
	private int[] translatedMessage;
	private int[] shiftedMessage;
	//File I write and read to/from
	private String fileIRead = "EncryptMe";
	private String fileIWriteTo = "Encrypted Stuff";
	//Master key to decrypt message
	private int[] masterKey;
	private int masterKeySize = 10;
	private int positionKeySpecial = 13; //positionKeyChoice + choiceKeyChoice + this number = #ofiterations
	
	//Setters
	public void setShiftKey(int[] shiftKey) {
		this.shiftKey = shiftKey;
	}
	public void setCharKey(char[] charKey) {
		this.charKey = charKey;
	}
	public void setEncryptedMessage(String encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}
	public void setTranslatedMessage(int[] translatedMessage) {
		this.translatedMessage = translatedMessage;
	}
	public void setShiftedMessage(int[] shiftedMessage) {
		this.shiftedMessage = shiftedMessage;
	}
	public void setMasterKey(int[] masterKey) {
		this.masterKey = masterKey;
	}
	//Getters
	public int[] getShiftKey() {
		return shiftKey;
	}
	public char[] getCharKey() {
		return charKey;
	}
	public String getEncryptedMessage() {
		return encryptedMessage;
	}
	public int[] getTranslatedMessage() {
		return translatedMessage;
	} 
	public int[] getShiftedMessage() {
		return shiftedMessage;
	}
	public String getFileIRead() {
		return fileIRead;
	}
	public String getFileIWriteTo() {
		return fileIWriteTo;
	}
	public int[] getMasterKey() {
		return masterKey;
	}
	public int getMasterKeySize() {
		return masterKeySize;
	}
	public int getPositionKeySpecial() {
		return positionKeySpecial;
	}
	//Higher functions
	public int[] translateCharToInt(char[] input, int[] key) {//SUCCESS - Tested
		int[] output = new int[input.length];
		int[] k = key.clone();
		
			for(int c = 0; c < input.length; c++) {
		switch(input[c]) {
		case 'a' : output[c] = k[0]; break;
		case 'b' : output[c] = k[1]; break;
		case 'c' : output[c] = k[2]; break;
		case 'd' : output[c] = k[3]; break;
		case 'e' : output[c] = k[4]; break;
		case 'f' : output[c] = k[5]; break;
		case 'g' : output[c] = k[6]; break;
		case 'h' : output[c] = k[7]; break;
		case 'i' : output[c] = k[8]; break;
		case 'j' : output[c] = k[9]; break;
		case 'k' : output[c] = k[10]; break;
		case 'l' : output[c] = k[11]; break;
		case 'm' : output[c] = k[12]; break;
		case 'n' : output[c] = k[13]; break;
		case 'o' : output[c] = k[14]; break;
		case 'p' : output[c] = k[15]; break;
		case 'q' : output[c] = k[16]; break;
		case 'r' : output[c] = k[17]; break;
		case 's' : output[c] = k[18]; break;
		case 't' : output[c] = k[19]; break;
		case 'u' : output[c] = k[20]; break;
		case 'v' : output[c] = k[21]; break;
		case 'w' : output[c] = k[22]; break;
		case 'x' : output[c] = k[23]; break;
		case 'y' : output[c] = k[24]; break;
		case 'z' : output[c] = k[25]; break;
		case 'A' : output[c] = k[26]; break;
		case 'B' : output[c] = k[27]; break;
		case 'C' : output[c] = k[28]; break;
		case 'D' : output[c] = k[29]; break;
		case 'E' : output[c] = k[30]; break;
		case 'F' : output[c] = k[31]; break;
		case 'G' : output[c] = k[32]; break;
		case 'H' : output[c] = k[33]; break;
		case 'I' : output[c] = k[34]; break;
		case 'J' : output[c] = k[35]; break;
		case 'K' : output[c] = k[36]; break;
		case 'L' : output[c] = k[37]; break;
		case 'M' : output[c] = k[38]; break;
		case 'N' : output[c] = k[39]; break;
		case 'O' : output[c] = k[40]; break;
		case 'P' : output[c] = k[41]; break;
		case 'Q' : output[c] = k[42]; break;
		case 'R' : output[c] = k[43]; break;
		case 'S' : output[c] = k[44]; break;
		case 'T' : output[c] = k[45]; break;
		case 'U' : output[c] = k[46]; break;
		case 'V' : output[c] = k[47]; break;
		case 'W' : output[c] = k[48]; break;
		case 'X' : output[c] = k[49]; break;
		case 'Y' : output[c] = k[50]; break;
		case 'Z' : output[c] = k[51]; break;
		case '0' : output[c] = k[52]; break;
		case '1' : output[c] = k[53]; break;
		case '2' : output[c] = k[54]; break;
		case '3' : output[c] = k[55]; break;
		case '4' : output[c] = k[56]; break;
		case '5' : output[c] = k[57]; break;
		case '6' : output[c] = k[58]; break;
		case '7' : output[c] = k[59]; break;
		case '8' : output[c] = k[60]; break;
		case '9' : output[c] = k[61]; break;
		case ' ' : output[c] = k[62]; break;
		case '.' : output[c] = k[63]; break;
		case '&' : output[c] = k[64]; break;
		case ',' : output[c] = k[65]; break;
		case '!' : output[c] = k[66]; break;
		case '?' : output[c] = k[67]; break;
		case '\'' : output[c] = k[68]; break;
		case '#' : output[c] = k[69]; break;
		case '$' : output[c] = k[70]; break;
		case '%' : output[c] = k[71]; break;
		case '"' : output[c] = k[72]; break;
		case ':' : output[c] = k[73]; break;
		case ';' : output[c] = k[74]; break;
		case '+' : output[c] = k[75]; break;
		case '-' : output[c] = k[76]; break;
		case '=' : output[c] = k[77]; break;
		case '/' : output[c] = k[78]; break;
		case '*' : output[c] = k[79]; break;
		case '_' : output[c] = k[80]; break;
		case '(' : output[c] = k[81]; break;
		case ')' : output[c] = k[82]; break;
		case '<' : output[c] = k[83]; break;
		case '>' : output[c] = k[84]; break;
		case '{' : output[c] = k[85]; break;
		case '}' : output[c] = k[86]; break;
		case '[' : output[c] = k[87]; break;
		case ']' : output[c] = k[88]; break;
		case '^' : output[c] = k[89]; break;
		case '@' : output[c] = k[90]; break;
		case '`' : output[c] = k[91]; break;
		default: output[c] = '?';
		}
	}
		return output;
	}
	
	public int[] encryptShiftKey(int[] message, int[] key) {//SUCCESS - Tested
		int[] output = new int[message.length];
		int[] k = key.clone();
		//counters
		int x = 0; 
		int y = 0;
		
		while(x < message.length) {
			if(y < k.length) {
				output[x] = message[x] + k[y];
				y++; x++;
			}else {
				y = 0;
			}
		}
		return output;
	}
	
	public int[] multiplyInt(int[] message, double[] key) {
		int[] output = new int[message.length];
		//counters 
		int x = 0;
		int y = 0;
		//holds product till it's converted to int
		double temp = 0.0;
			
		double[] k = key.clone();
		while(x < message.length) {
			//If number breaks array bounds, reset to 0
			if(y < k.length) {
				temp = message[x] * k[y];
				output[x] = (int) Math.round(temp);
				y++; x++;
			}else {
				y = 0;
			}
		}
		return output;
	}
	
	public int[] encryptPosition(int[] message, int stopHere, int rand) {
		int[] m = new int[message.length];
		m = message.clone();
		//New Message to be returned
		int[] newM = new int[m.length];			
			//Sending odd numbers into new array first
				//Counter only ++ when newM position is filled
				int x = 0;
			for(int c = 0; c < m.length; c++) {
				if(c % 2 == 1) {
					newM[x] = m[c];
					x++;
				}	
			}
		//Sending even numbers into the new array second
			//Counter starts where first loop left off and only ++ when newM position is filled
			int y = x;
		for(int c = 0; c < m.length; c++) {
			if(c % 2 == 0) {
				newM[y] = m[c];
				y++;
			}
		}

		//****************************************
			//Declares tempArray to hold newM while it is* changed
			int[] tempC = new int[newM.length + 1];
			//Adding character to specific place!!
			//Switching numbers based on extra key (For now its set)
			//Adds a random number to the position selected
			boolean added = false;
			added = false;// Tells the aforementioned loop that the insertion has occurred
			//Inserting new number from randKey, based on choiceKey
			for(int c = 0; c < tempC.length; c++) {
				//Copies characters until stopHere happens
					if(c == stopHere) {
						tempC[c] = rand;
						added = true;
					} else {
						if(added == true) {
							tempC[c] = newM[c - 1];
							}
						else {
							tempC[c] = newM[c];
							}
					}
				}
		return tempC;
	}
	
	public int[] loopEncryptPosition(int[] message, int iterations, int[] choiceKey, int[] randKey) {
		int[] newM = new int[message.length];
		
		newM = message.clone();
		
		int countR = 0;
		int rand = 0;
		int stopHere = 0;//Tried something more complex, didn't work out, will try again
			
			for(int c = 0; c < iterations; c++) {
			//Resets counter if necessary
					if(countR > randKey.length - 1) {
						countR = 0;
					}
					rand = randKey[countR];
					countR++;
					
				newM = encryptPosition(newM, stopHere, rand);
			}
		return newM;
	}
	
	public char[] encryptCharKey(int[] message, char[] key) {//SUCCESS - Tested
		char[] output = new char[message.length];
		char[] k = key.clone();
		int x = 0;
		
		for(int c = 0; c < message.length; c++) {
			x = message[c];
			//If counter is out of bounds, it subtracts key length till its not
				for(int b = 0; b < k.length; b++) {
					if(x == b)
						output[c] = k[b];
				}
			}
		return output;
	}
	
	//Switches character encryption keys by char positions
		//outputs new positions of old characters
	public int[] charPositionSwitch(int[] charMessage, char[] keyWithNum, char[] keyWithChar) {
		int[] output = new int[charMessage.length];
		int[] m = charMessage.clone();
		char[] kN = keyWithNum.clone();
		char[] kC = keyWithChar.clone();
		
		int M = 0;
		char C = 'a';
		
		for(int x = 0; x < m.length; x++) {
			M = m[x];
			for(int y = 0; y < kN.length; y++) {
				if(y == M)
					C = kN[y];
				for(int z = 0; z < kC.length; z++) {
					if(kC[z] == C)
						output[x] = z;
				}
			}
		}
		
		return output;
	}
	
	public void fileWriter(char[] message, String filename) throws IOException {
			String writeToMe = getFileIWriteTo();
		   	OutputStreamWriter writer = new OutputStreamWriter(
		   			new FileOutputStream(writeToMe+"/"+filename), "UTF-8");
			   	for(int c = 0; c < message.length; c++) {				   			
			   		writer.write(message[c]);
			   	}
			   	writer.close();
	}

	public String fileReader(String filename) throws IOException {
			String readFromMe = getFileIRead();
			BufferedReader read = new BufferedReader(
					new InputStreamReader(new FileInputStream(readFromMe+"/"+filename), "UTF8"));
				StringBuilder output = new StringBuilder();
				String line;
			
			while((line = read.readLine()) != null) {
				output.append(line);
			}
		read.close();
		return output.toString();
	}
	
	public static void main(String[] args) throws IOException {
		Encrypter e = new Encrypter();
		KeyLibrary kl = new KeyLibrary();
		CharKeyLibrary ck = new CharKeyLibrary();
		
		//MASTER KEY
		int[] masterKey = new int[e.getMasterKeySize()];
		//Message initialization
		String message = null;
		File filename = null;
		//Enter the message
		Object[] obj = {"Encrypt File"};
		
		int choice = JOptionPane.showOptionDialog(null, "What can I do for you?",
                "<ENCRYPTER>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, obj, obj[0]);
		if(choice == 0) {
			//Gets the file names and loades them into a pre-allocated list
			JOptionPane.showMessageDialog(null,
				"1. I encrypt all Alphabetic, Numerical and Special Characters you see on your keyboard. Not custom symbols!"
						+ "\n2. First, place your file in the EncryptMe folder\n"
						+ "3. Click OK to choose file");
			
			final JFileChooser fc = new JFileChooser("EncryptMe");
			int returnVal = fc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			filename = fc.getSelectedFile();} else {
				System.out.println("File opener cancelled\n");
			}
			message = e.fileReader(filename.getName());
		}
		char[] messageToChar = message.toCharArray();
		
		//Initial Integer Encryption
		Object[] initKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int initKeyChoice = JOptionPane.showOptionDialog(null, "Choose 1st Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, initKeys, initKeys[9]);
		masterKey[0] = initKeyChoice;
		
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
		
		int[] translatedMessage = new int[messageToChar.length]; 
		translatedMessage = e.translateCharToInt(messageToChar, initSetting);
		//*************************************************************************************
		
		//Character Switch Encryption (2 choices)
		Object[] charSwitchKeys1 = {"0","1","2","3","4","5","6","7","8","9"};
		int charSwitchKeyChoice1 = JOptionPane.showOptionDialog(null, "Choose 2nd Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys1, charSwitchKeys1[9]);
		masterKey[1] = charSwitchKeyChoice1;
		
		char[] charSwitchSetting1 = new char[kl.getSwitchKeySize()];
		switch(charSwitchKeyChoice1) {
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
		
		Object[] charSwitchKeys2 = {"0","1","2","3","4","5","6","7","8","9"};
		int charSwitchKeyChoice2 = JOptionPane.showOptionDialog(null, "Choose 3rd Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys2, charSwitchKeys2[9]);
		masterKey[2] = charSwitchKeyChoice2;
		
		char[] charSwitchSetting2 = new char[kl.getSwitchKeySize()];
		switch(charSwitchKeyChoice2) {
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
		
		
		int[] switchedMessage1 = new int[translatedMessage.length];
		switchedMessage1 = e.charPositionSwitch(translatedMessage, charSwitchSetting1, charSwitchSetting2);
	
		//Multiplier Encryption
		Object[] multKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int multKeyChoice = JOptionPane.showOptionDialog(null, "Choose 4th Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, multKeys, multKeys[9]);
		masterKey[3] = multKeyChoice;
		
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
			
		int[] multipliedMessage = new int[switchedMessage1.length]; 
		multipliedMessage = e.multiplyInt(switchedMessage1, multSetting);
		
		//Shift Encryption***********************************************************
		Object[] shiftKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int shiftKeyChoice = JOptionPane.showOptionDialog(null, "Choose 5th Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shiftKeys, shiftKeys[9]);
		masterKey[4] = shiftKeyChoice;
		
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

		int[] shiftedMessage = new int[multipliedMessage.length]; 
		shiftedMessage = e.encryptShiftKey(multipliedMessage, shiftSetting);
		
		//Switch Encryption********************************************************
		Object[] charSwitchKeys3 = {"0","1","2","3","4","5","6","7","8","9"};
		int charSwitchKeyChoice3 = JOptionPane.showOptionDialog(null, "Choose 6th Setting",
				"<Encrypter>",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys3, charSwitchKeys3[9]);
		masterKey[5] = charSwitchKeyChoice3;
				
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
				"<Encrypter>",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charSwitchKeys4, charSwitchKeys4[9]);
		masterKey[6] = charSwitchKeyChoice4;
				
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
		
		int[] switchedMessage2 = new int[shiftedMessage.length];
		switchedMessage2 = e.charPositionSwitch(shiftedMessage, charSwitchSetting3, charSwitchSetting4);
		
		//Position Encryption (Random and Choice)
		Object[] positionKeys = {"0","1","2","3","4","5","6","7","8","9"};
		int positionKeyChoice = JOptionPane.showOptionDialog(null, "Choose 8th Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, positionKeys, positionKeys[9]);
		masterKey[7] = positionKeyChoice;
		
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
		masterKey[8] = choiceKeyChoice;
		
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
		int special = e.getPositionKeySpecial();
		int[] positionEMessage = e.loopEncryptPosition(switchedMessage2, positionKeyChoice + choiceKeyChoice + special, 
				choiceSetting, positionSetting);
		
		//Character Encryption********************************************************
		Object[] charKeys1 = {"0","1","2","3","4","5","6","7","8","9"};
		int charKeyChoice1 = JOptionPane.showOptionDialog(null, "Choose 10th Setting",
                "<Encrypter>",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, charKeys1, charKeys1[9]);
		masterKey[9] = charKeyChoice1;
		
		char[] charSetting = new char[kl.getCharKeySize()];
		switch(charKeyChoice1) {
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
		
		char[] encryptedMessage = new char[positionEMessage.length];
		encryptedMessage = e.encryptCharKey(positionEMessage, charSetting);
		//************************************************************************************
		//Prints out steps, to check Encryption strength
		for(int i = 0; i < messageToChar.length; i++) {
			System.out.print(messageToChar[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < translatedMessage.length; i++) {
			System.out.print(translatedMessage[i] + ",");
		}
		System.out.println();
		
		for(int i = 0; i < switchedMessage1.length; i++) {
			System.out.print(switchedMessage1[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < multipliedMessage.length; i++) {
			System.out.print(multipliedMessage[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < shiftedMessage.length; i++) {
			System.out.print(shiftedMessage[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < switchedMessage2.length; i++) {
			System.out.print(switchedMessage2[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < positionEMessage.length; i++) {
			System.out.print(positionEMessage[i] + ",");
		}
		System.out.println();
		for(int i = 0; i < encryptedMessage.length; i++) {
			System.out.print(encryptedMessage[i] + ",");
		}
		
		
		//************************************************************************************
		
		 
		 //Writing Message to file
		 e.fileWriter(encryptedMessage, filename.getName());
		 JOptionPane.showMessageDialog(null, filename.getName() + " has been saved to Encrypted Stuff (folder)");
		 
		 //Set Master key
		 e.setMasterKey(masterKey);
		 //Printing Message Key to remind user
		 StringBuffer sb2 = new StringBuffer();
		 int[] masterKeyTemp = e.getMasterKey();
		 int masterKeyLength = e.getMasterKeySize();
		 for (int c = 0; c < masterKeyLength; c++) {
		      sb2.append(masterKeyTemp[c]);
		 }
		 JOptionPane.showMessageDialog(null, "This is your...\n[---KEY: "+sb2.toString() +
				 " ---]" +
				 "\n!- Give this to my Decrypter, to decrypt your message -!");
	}
}