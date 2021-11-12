/*
1. Check that there are two command line arguments. Quit with a usage message to stderr if more than or less
than two strings are given on the command line.


2. Count the number of lines n in the file named by args[0]. Create a String array of length n and read in the
lines of the file as Strings, placing them into the array.


3. Create a List whose elements are the indices of the above String array. These indices should be arranged in
an order that effectively sorts the array. Using the above input file as an example we would have.


4. Use the List constructed in (3) to print the array in alphabetical order to the file named by args[1]. Note
that at no time is the array ever sorted. Instead you are indirectly sorting the array by building a List of indices
in a certain order.
*/

import java.io.*;
import java.util.Scanner;

public class Lex {
	
	 static void insertSort(List L, int[] array0, String[] word){
		 int k,l;
		 int n = array0.length;
		 
		 String[] help = word;
		 for(int i=1;i<array0.length;i++){
			 int j = i-1;
			 k = i;
			 while (j >= 0){
				if(help[k].compareTo(word[j]) > 0) break;
				
				array0[j+1] = array0[j];
				j--;
			 }
			 array0[j+1] = k;
		}
		 for(k=0;k<array0.length;k++) L.append(array0[k]);
		 
	 }
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = null;//in, line, token arrays used for file content.
		PrintWriter out1 = new PrintWriter(new File(args[1]+".txt"));
		String line = null;
		String[] conFile = new String[100]; //Content of file
		String[] token = null;
		int n, silk, lineNumber = 0, i = 0, z=0;
		
		if(args.length < 2){
			System.out.println("Usage: Search <input file> <target1>...<>");
			System.exit(1);
		}
		
		//An array used to store arg[i+1] arguments for later search.
		String[] track = new String[args.length - 1];

		in = new Scanner(new File(args[0]));
	
	

		for(z = 0; z<args.length-1; z++){
			track[z] = args[z+1];
		}

//Tokenizes content from file.
		while(in.hasNextLine() ){
			line = in.nextLine().trim() + " ";
			token = line.split("\\s");
			n = token.length;
			for(i = 0; i<n; i++) conFile[lineNumber++] = token[i];     
		}
	
		in.close();//Closes file.
	
	//Creates a number array that holds String original placement.
		int[] content = new int[lineNumber];
		z = 0;
		List L = new List();
		while(z<lineNumber){
			content[z] = z;
			++z;
			//L.append(0);
		}
	
		//for(n = 0; n < lineNumber; n++) System.out.println(content[n]);
		//System.out.println(L);
		
		insertSort(L, content, conFile);
		//System.out.println(L.length());
		System.out.print(L);
		L.moveFront();
		for(z=0; z < lineNumber; z++){
			System.out.println("The list unit at index: " + L.index() + " & it's data " + L.get());
			out1.println(conFile[L.get()]);
			L.moveNext();
		}
		
		in.close();
		out1.close();
		
	}

}