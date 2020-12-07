package cryoshell;

import java.util.Random;

public class KeyBuilder {
		//Character Builder	
			KeyLibrary l = new KeyLibrary();
			private char[] charSeedKey = {'☺','☻','♥','♦','♣','♠','•','◘','○','◙','♂','♀','♪','♫','☼','►','◄','↕','‼','¶','§','▬','↨','↑','↓','→','←',
					'∟','↔','▲','▼',' ','!','#','$','%','&','(',')','*','+',',','-','.','/','0','1','2','3','4','5','6','7','8','9',':',';','<','=',
					'>','?','@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[',']','^',
					'_','`','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~',
					'⌂','Ç','ü','é','â','ä','à','å','ç','ê','ë','è','ï','î','ì','Â','Ã','Ä','Å','É','æ','Æ','ô','ö','ò','û','ù','ÿ','Ò','Ó','Ô','Õ',
					'Ö','Ü','¢','£','¥','₧','ƒ','á','í','ó','ú','ñ','Ñ','ª','º','¿','⌐','¬','½','¼','¾','¡','«','»','░','▒','▓','│','┤','╡','╢','╖',
					'╕','╣','║','╗','╝','╜','╛','┐','└','┴','┬','├','─','┼','╞','╟','╚','╔','╩','╦','╠','═','╬','╧','╨','╤','╥','╙','╘','╒','╓','╫',
					'╪','┘','┌','█','▄','▌','▐','▀','α','ß','Γ','π','Σ','σ','µ','τ','Φ','Θ','Ω','δ','∞','φ','ε','∩','≡','±','≥','≤','⌠','⌡','÷','≈',
					'°','∙','·','√','ⁿ','²','■'};
			private char[] switchSeedKey = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
					's','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M',
					'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7',
					'8','9',' ','.','&',',','!','?','\'','#','$','%','\"',':',';','+','-','=','/','*','_',
					'(',')','<','>','{','}','[',']','^','@','|','`'};
			private double[] multSeedKey = {1.0,1.2,1.25,1.3,1.35,1.4,1.45,1.5,1.55,1.6,1.65,1.7,1.75,1.8,2.0};
			private int[] shiftSeedKey = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,
					26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,
					56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73};
			private int[] initSeedKey = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
					27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,
					58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,
					89,90,91};
			private int[] positionSeedKey = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,
					26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,
					57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,
					88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,
					114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,
					137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,
					160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,
					183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,
					206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,
					229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,
					252,253,254,255,256,257};
			private int[] choiceSeedKey = {0,1,2};
			private int random;
			
			
			//Setters**********************************
			public void setRandom(int random){
				this.random = random;
			}
			//Getters**********************************
			public char[] getCharSeedKey() {
				return charSeedKey;
			}
			public double[] getMultSeedKey() {
				return multSeedKey;
			}
			public int[] getShiftSeedKey() {
				return shiftSeedKey;
			}
			public int getRandom() {
				return random;
			}
			public char[] getSwitchSeedKey() {
				return switchSeedKey;
			}
			public int[] getInitSeedKey() {
				return initSeedKey;
			}
			public int[] getPositionSeedKey() {
				return positionSeedKey;
			}
			public int[] getChoiceSeedKey() {
				return choiceSeedKey;
			}
			//Elite Functions
			public int randomizer(int range){
				Random rand = new Random();
				
				int temp = rand.nextInt(range);
				setRandom(temp);
				temp = getRandom();
				return temp;
			}
			//isNewChar() returns true if character is new to the array
			public boolean isNewChar(char x, char[] y){
				boolean check = false;
				for(int c = 0; c < y.length; c++) {
					if(x == y[c]){
						check = false;
							break;
						} else {
							check = true;
						}
					}
				return check;
			}
			//isNewNum() returns true if number is new to the array
			public boolean isNewNum(int x, int[] y) {
				boolean check = false;
				for(int c = 0; c < y.length; c++) {
					if(x == y[c]) {
						check = false;
						break;
						}
					check = true;
					}
				return check;
			}
			public boolean isNewDouble(double x, double[] y) {
				boolean check = false;
				for(int c = 0; c < y.length; c++) {
					if(x == y[c]) {
						check = false;
						break;
						}
					check = true;
					}
				return check;
			}
		public void InitKeyBuilderScript() {
			int rand = 0;
			int[] copyKey = getInitSeedKey();
			//Overriding inability to select 0, from default initialization of 0
			int z = l.getInitKeySize();
			int total = l.getInitTotalKeys();
			
			int selection = 0;
			for(int x = 0; x < total; x++) {
				System.out.print("private int[] I" + x + " = {");
				int[] newKey = new int[z];
			for(int c = 0; c < copyKey.length; c++) {
				rand = randomizer(z);
				selection = copyKey[rand];
				if(selection == 0)
					selection = z + 1;
				if(isNewNum(selection, newKey)) {
					newKey[c] = selection;
				} else {
					c--;
				}
			}
			for(int c = 0; c < newKey.length; c++) {
				if(newKey[c] == z + 1)
					newKey[c] = 0;
				System.out.print(newKey[c]);
				if(c < newKey.length - 1)
				System.out.print(",");
				}
			System.out.print("};\n");
			}
		} 
			//Switch Key builder Script
		public void SwitchKeyBuilderScript() {
			int size = l.getSwitchKeySize();
			//Set Range as size of the seed array
			char[] copyKey = getSwitchSeedKey();
			char[] newKey = new char[size];
			
			//Build randomized key
			for(int c = 0; c < size; c++) {
				//random number for selection
				int rand = randomizer(size);
					//selecting value
					char selection = copyKey[rand];
				//Checking is the selected value is new
					if(isNewChar(selection, newKey)) 
							newKey[c] = selection;
						 else 
							c--;
					}
				for(int c = 0; c < size; c++) {
					System.out.print("'");
						if(newKey[c] == '\'' || newKey[c] == '\"')
							System.out.print('\\');
					System.out.print(newKey[c]);
					System.out.print("'");
						if(c < size - 1) {
							System.out.print(",");
						}
					//Formats the output with indentations
					}
		}	
			
			//Character Key Builder Script
		public void CharKeyBuilderScript() {
			int size = l.getCharKeySize();
			//Set Range as size of the seed array
			char[] copyKey = getCharSeedKey();
			
			//Prints amount of Keys you want
			int z = l.getCharTotalKeys();
			for(int x = 0; x < z; x++) {
				System.out.print("private char[] C" + x + " = {");
				char[] newKey = new char[size];
			//Build randomized key
			for(int c = 0; c < size; c++) {
				//random number for selection
				int rand = randomizer(size);
					//selecting value
					char selection = copyKey[rand];
				//Checking is the selected value is new
					if(isNewChar(selection, newKey)) 
							newKey[c] = selection;
						 else 
							c--;
					}
				for(int c = 0; c < size; c++) {
					System.out.print("'");
					System.out.print(newKey[c]);
					System.out.print("'");
						if(c < size - 1) {
							System.out.print(",");
						}
					//Formats the output with indentations
					}
				System.out.print("};\n");
				}
			}
		
			//Shifter Key Builder Script
		public void ShiftKeyBuilderScript() {
				int rand = 0;
				int[] copyKey = getShiftSeedKey();
				//Overriding inability to select 0, from default initialization of 0
				int z = l.getShiftKeySize();
				int[] newKey = new int[z];
				
				int selection = 0;
				for(int c = 0; c < copyKey.length; c++) {
					rand = randomizer(copyKey.length);
					selection = copyKey[rand];
					if(isNewNum(selection, newKey)) {
						newKey[c] = selection;
					} else {
						c--;
					}
				}
				for(int c = 0; c < newKey.length; c++)
					if(newKey[c] == z) newKey[c] = 0;
				for(int c = 0; c < newKey.length; c++) {
					System.out.print(newKey[c]);
					if(c < newKey.length - 1)
					System.out.print(",");
					}
			} 
		public void MultKeyBuilderScript() {
			KeyLibrary l = new KeyLibrary();	
			int size = l.getMultKeySize();
				double[] copyKey = multSeedKey;
				int rand = 0;
				double s = 0.0;
				int reps = l.getMultReps();
				int total = l.getMultTotalKeys();
				
				for(int c = 0; c < total; c++) {
					System.out.print("private double[] M" + c + " = {");
				//Repeats newKey as many times as MultReps says
				for(int z = 0; z < reps; z++) {
					//Prepares new array
					double[] newKey = new double[size];
					//Creates new Key
					for(int y = 0; y < size; y++) {
						rand = randomizer(multSeedKey.length);
						s = copyKey[rand];
						if(isNewDouble(s, newKey)) {
							newKey[y] = s;
							} else {
								y--;
							}
					}
					//Prints new key
					for(int x = 0; x < newKey.length; x++) {
						System.out.print(newKey[x] + ",");
					}
				}
			System.out.print("};\n");
			}
		}
		public void PositionKeyBuilderScript() {
			int rand = 0;
			int[] copyKey = getPositionSeedKey();
			//Overriding inability to select 0, from default initialization of 0
			int z = l.getPositionKeySize();
			int[] newKey = new int[z];
			
			int y = l.getPositionTotalKeys();
			int selection = 0;
			for(int x = 0; x < y; x++) {
				System.out.print("private int[] P" + x + " = {");
				newKey = new int[z];
			for(int c = 0; c < copyKey.length; c++) {
				rand = randomizer(copyKey.length);
				selection = copyKey[rand];
				if(selection == 0) {
					selection = z;
				}
				if(isNewNum(selection, newKey)) {
					newKey[c] = selection;
				} else {
					c--;
				}
			}
			for(int c = 0; c < newKey.length; c++)
				if(newKey[c] == z) newKey[c] = 0;
			for(int c = 0; c < newKey.length; c++) {
				System.out.print(newKey[c]);
				if(c < newKey.length - 1)
				System.out.print(",");
				}
			System.out.print("};\n");
			}
		} 
		public void ChoiceKeyBuilderScript() {
			KeyLibrary l = new KeyLibrary();	
			int size = l.getChoiceKeySize();
				int[] copyKey = getChoiceSeedKey();
				int rand = 0;
				int s = 0;
				int reps = l.getChoiceReps();
				int total = l.getChoiceTotalKeys();
				
				for(int c = 0; c < total; c++) {
					System.out.print("private int[] CH" + c + " = {");
				//Repeats newKey as many times as MultReps says
				for(int z = 0; z < reps; z++) {
					//Prepares new array
					int[] newKey = new int[size];
					//Creates new Key
					for(int y = 0; y < size; y++) {
						rand = randomizer(copyKey.length);
						s = copyKey[rand];
						if(s == 0)
							s = size + 1;
						if(isNewNum(s, newKey)) {
							newKey[y] = s;
							} else {
								y--;
							}
					}
					//Prints new key
					for(int x = 0; x < newKey.length; x++) {
						if(newKey[x] == size + 1)
							newKey[x] = 0;
						System.out.print(newKey[x] + ",");
					}
				}
			System.out.print("};\n");
			}
		}
		//Array of Array Builder
		public void arrayOfArraysBuilderScript() {
				for(int c = 0; c < 258; c++) {
					System.out.print(c);
					if(c < 258)
						System.out.print(",");
				}
			}
		public void altCodeArrayScript() {
			String altCode = "☺☻♥♦♣♠•◘○◙♂♀♪♫☼►◄↕‼¶§▬↨↑↓→←∟↔▲▼ !#$%&''())*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~⌂ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜ¢£¥₧ƒáíóúñÑªº¿⌐¬½¼¾¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αßΓπΣσµτΦΘΩδ∞φε∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■";
			char[] array = altCode.toCharArray();
			for(int c = 0; c < array.length; c++) {
				System.out.print("'");
				System.out.print(array[c]);
				System.out.print("'");
				if(c < array.length - 1)
					System.out.print(",");
			}
			System.out.print(array.length);
			
		}
		
		public void translaterArrayScript() {
			String inputCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789`~!@#$%^&*()_-=+";
			char[] toCharArray = inputCharacters.toCharArray();
			for(int c = 0; c < toCharArray.length; c++) {
				System.out.print("'");
				System.out.print(toCharArray[c]);
				System.out.print("',");
			}
		}
		
	public static void main(String[] args) {
			KeyBuilder key = new KeyBuilder();
				
				
			key.ChoiceKeyBuilderScript();
	}
}
