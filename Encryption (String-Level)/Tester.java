package cryoshell;

public class Tester {
	public int[] encryptPosition(int[] message, int stopHere, int[] randChoiceKey) {
		int[] m = new int[message.length];
		m = message.clone();
		//New Message to be returned
		int[] newM = new int[m.length];		
		
		int[] tempRK = randChoiceKey;
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
			int tempSize = 0;
			if(tempRK.length == 0)
				tempSize = 0;
			int[] tempC = new int[newM.length + tempSize];
			//Adding character to specific place!!
			//Switching numbers based on extra key (For now its set)
			//Adds a random number to the position selected
			boolean added = false;
			added = false;// Tells the aforementioned loop that the insertion has occurred
			//Inserting new number from randKey, based on choiceKey
			for(int c = 0; c < tempC.length; c++) {
				//Copies characters until stopHere happens
					if(c == stopHere) {
						added = true;
						//Loop inserting choice # of random
						if(tempRK.length == 0) {
							tempC[c] = newM[c];
						} else {
							for(int z = 0; z < tempRK.length; z++) {	
								tempC[c + z] = tempRK[z];
							}
						}
					} else {
						if(added == true) {
							tempC[c] = newM[c - tempRK.length];
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
		int[] ck = choiceKey;
		int[] rk = randKey;
		
		int countC = 0;
			int choice = 0;
		int countR = 0;
			int[] tempRK = new int[0];
		int stopHere = 0;//Tried something more complex, didn't work out, can try again using stopHere
			
			for(int x = 0; x < iterations; x++) {
			//Resets counters if necessary
					if(countC > ck.length - 1) {
						countC = 0;
					}
					if(countR > rk.length - 1) {
						countR = 0;
					}
				choice = ck[countC];//Giving encryptPosition number of random to be inserted
					countC++; //Increment choiceKey separately for bounds checking
					//Can be 0
				tempRK = new int[choice];
					for(int y = 0; y < choice; y++) {
						tempRK[y] = rk[countR];
					}
				for(int z = 0; z < tempRK.length; z++)
					System.out.println("tempRK[z] = " + tempRK[z]);
				countR = countR + choice; //Increment randKey counter by choice # grabbed
				newM = encryptPosition(newM, stopHere, tempRK);
			}
		return newM;
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
	
	public static void main(String[] args) {
		int[] m = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
				30,31,32,33,34,35,36,37,38,39,40};
		Tester t = new Tester();
	
		int[] choiceKey = {7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] randKey = {100,100,100,100};
		
		//int[] x = t.encryptPosition(mess, choiceKey, randKey);
		
		int[] x = t.loopEncryptPosition(m, 1, choiceKey, randKey);
		
		for(int c = 0; c < x.length; c++) {
			System.out.print(x[c] + ",");
		}

		/*System.out.println("\n");
		
		int[] y = t.loopDecryptPosition(x, 10, choiceKey, randKey);
		
		for(int c = 0; c < y.length; c++) {
			System.out.print(y[c] + ",");
		}*/
	}

}
