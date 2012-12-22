package com.naren.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		int ch=0;
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		BufferedReader br = null;
		BufferedWriter bw1 = null;
		BufferedWriter bw=null;
		String name, line, names1;
		Iterator<String> it;
		Collection<String> names = new ArrayList<String>();
		 
		while(ch!=5){
			
			System.out.println("Press 1 to add a friend");
			System.out.println("Press 2 to Delete a friend");
			System.out.println("Press 3 to list friends");
			System.out.println("Press 4 to search for friend");
			System.out.println("Press 5 to exit");
					
			while(!sc1.hasNextInt()){
				System.out.println("Please enter the correct input");
				sc1.next();
			}
			ch=sc1.nextInt();
			switch (ch) {
			case 1:
					System.out.println("Adding a friend");
					System.out.println("enter a name of a frind to add");
					name = sc2.next();
					names.add(name);
					try{
						bw= new BufferedWriter(new FileWriter("d:/names.txt",true));
						bw.write(name);
						bw.newLine();
					}catch(IOException e){
						e.printStackTrace();
					}finally{
							try {
								if(bw!=null){
									bw.close();
								}
						} catch (IOException e2) {
								e2.printStackTrace();
						}
			
					}
					break;
			case 2:
					System.out.println("Deleting a friend");
					System.out.println("Enter the name of the friend to delete");
					name = sc2.next();
					try{
						br=new BufferedReader(new FileReader("d:/names.txt"));
						bw1=new BufferedWriter(new FileWriter("d:/names.txt",true));
						while((line=br.readLine())!=null){
							if(!line.equals(name)){
								names.add(line);
								if(names.contains(line)){
									bw1.write(line);
									bw1.newLine();
								}
							}else{
								System.out.println("The name u entered successfully deleted"+" "+line);
								}
							}						
						}catch(IOException e){
						e.printStackTrace();
					}finally{
						try{
							if(br!=null)
								br.close();
							if(bw1!=null)
								bw1.close();
						}catch(IOException e2){
							e2.printStackTrace();
							}
						}
					break;
			case 3:
					System.out.println("Listing friends");
					try{
						br=new BufferedReader(new FileReader("d:/names.txt"));
						while((line=br.readLine())!= null){
							System.out.println(line);
						}
					}catch(IOException e){
						e.printStackTrace();
					}finally{
							try{
								if(br!=null){
									br.close();
								}
						}catch(IOException ex){
							ex.printStackTrace();
						}
					}
					break;
			case 4:
					System.out.println("Searching for friend");
					System.out.println("enter the name of a friend to search");
					name=sc2.next();
					try{
						br=new BufferedReader(new FileReader("d:/names.txt"));
						while((line=br.readLine())!=null){
							names.add(line);
						}
						if(names.contains(name)==true){
							System.out.println("Friend name was successfully searched");
						}
					}catch(IOException e){
						System.out.println("The friend name u entered is not there in file"+e.getMessage());
					}finally{
						try{
							if(br!=null)
								br.close();
						}catch(IOException ex){
							ex.printStackTrace();
						}
							
					}
					
					break;
			case 5:
					System.out.println("tata.. good bye! See you later");
					break;
			default:
					System.out.println("inputs only from 1-5");
					break;
			}
		}
		
		

	}

}
