package sef.module2.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class caesars {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				List<String> inputtxt = new ArrayList<String>(); 
				
				try {
					FileReader reader = new FileReader("Data.txt");
					BufferedReader bufferedReader = new BufferedReader(reader);					 
		            String line;
		            while ((line = bufferedReader.readLine()) != null) {		            	
		            	inputtxt.add(line);
		            }
		            reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//String[] inputtxt = {"Java","Gunars","Viens"};
				Random rand = new Random();
				int offset = rand.nextInt(9)+1;
				
				//System.out.println("Ievadi tekstu: ");
				Scanner input = new Scanner(System.in);
				
				int index = rand.nextInt(inputtxt.size());				
				String inputtext = inputtxt.get(index);//input.nextLine();		
				System.out.println("Teksts: "+inputtext);
				String encodedTxt = encode(inputtext, offset);

				System.out.println(encodedTxt);		
				
				Boolean guessed = false;
				int guess = 1;
				do
				{
					//System.out.println("Mini ciparu(1-9): ");
					//input.nextInt();	
					//int guess = rand.nextInt(9)+1
					guess++;	
				
					String decodedTxt = decode(encodedTxt, guess);
				
					System.out.println(decodedTxt);
				
					if(decodedTxt.equals(inputtext))
					{
						guessed = true;
						System.out.println("Pareizi, cipars:" + guess);
					}
					else
					{
						guessed = false;
						System.out.println("Nepareizi, cipars: " + guess);
					}
					//System.out.println("Vai teksts apmierina(Y/y-jaa, N/n - nee)?: ");
					//char apm = input.next().charAt(0);
					
					//if(apm == 'Y' || apm == 'y'){
					//	guessed = true;
					//}
					//else
					//{
					//	guessed = false;
					//}		
				}
				while(guessed != true);
				
				input.close();
	}
	
	public static String encode(String txt, int offset)
	{
		char arr[] = txt.toCharArray();
		
		for(int i = 0; i<arr.length; i++){
			arr[i] = (char)(arr[i] + offset);
		}
		return  String.valueOf(arr);
	}
	
	public static String decode(String txt, int offset){
		
		char arr[] = txt.toCharArray();
		
		for(int i = 0; i<arr.length; i++){
			arr[i] = (char)(arr[i] - offset);
		}
		return String.valueOf(arr);
	}
}
