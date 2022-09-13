package com.simplilearn.firstProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AppSourceCode {
	
	public static void DirCreate() { 
		
		Directory = System.getProperty("User.dir");
		
		createFile = new File(Directory + "Files");
		
		if(!createFile.exists())
			createFile.mkdirs();
		
		System.out.println("File Path" + Directory);
	}

	private static Scanner input;
	private static Scanner readDbFile;
	private static UserDetails details;
	private static PrintWriter collect;
	private static File DBfile; 
	static String Directory;
	static File createFile;
	
	public static void main(String[] args) throws IOException {
		welcomeMessage();
		tools();
		mainMenu();
	    }
	// For printing welcome message for our user
	public static void welcomeMessage() {
		System.out.println("%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$");
		System.out.println("<<Welcome to LockedMe.com>>");
		System.out.println("%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$");
	    }
	// For creating new file and putting our values in it (Using like db to store data)
	public static void tools() throws IOException{
		DBfile = new File("UsersDB.txt");
		DBfile.createNewFile();
		
		try {	
			new Scanner(System.in);
			input = new Scanner(System.in);
			readDbFile = new Scanner(DBfile);
			DBfile.createNewFile();
			collect = new PrintWriter(new FileWriter(DBfile,true));
			details = new UserDetails();
		}catch(Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	    }
	
	// Here all the menu is defined where user can login , Signup and perform some operations live add,delete and find saved file  

	public static void mainMenu() throws IOException {
		
		System.out.println();
		
		System.out.println();
		
		System.out.println("*************** Main Menu ****************");
		
		System.out.println("\n Select an option mentioned below \n 1. Sign up \n 2. Sign in\n 3. Close the app\n");
	try {
		Scanner sc = new Scanner(System.in);
		int Option = sc.nextInt();
		
		switch(Option) {
		case 1: {signUp();}
		
		case 2: {signIn();}
		
		case 3:{System.exit(Option); break;}
		
		default:{ System.out.println("\n Invalid Input , Please Try Again With Above Mentioned Options \n"); mainMenu(); }
		
		}
		
		}catch(Exception e) {
		}
		System.out.println("\\n Invalid Input , Please Try Again With Above Mentioned Options \\n"); mainMenu(); 
	    }
	
	// Here we are Registering a new user
	public static void signUp() throws IOException {  
	  
	try {	
		System.out.println("\n Enter Username: \n");
		String username = input.next();
		while(readDbFile.hasNext()) {
			if(readDbFile.next().equals(username)) {
			System.out.println("\n Username Already Exists \n");
			signUp();
			}}
		details.setUserName(username);
		
		System.out.println("\n Enter Password: \n");
		String password = input.next();
		details.setPassword(password);
		
		System.out.println("\n User registered successfully \n");
		
		collect.println(details.getUserName());
		collect.println(details.getPassword());
		
		collect.close();
		
		System.out.println("\n1.Return to Main Menu\n2.Close the application\n");
		Scanner user = new Scanner(System.in);
		int mt15 = user.nextInt();
		switch(mt15) {
		case 1: main(null);
		case 2: break;
		default: System.out.println("\n Invalid Input , Please Try Again With Above Mentioned Options \n"); main(null);
		}
		}
	   catch(Exception e) {
		   signUp();
	   }
	   }
	
	// For Signup 
	public static void signIn() throws IOException {
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("******* Welcome to login page ********");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {	
			System.out.println("\nEnter Username : ");
			String inname = input.next();
			boolean found = false;
			while(readDbFile.hasNext() && !found) {
				if(readDbFile.next().equals(inname)) {
					System.out.println("\nEnter Pasword : ");
					String inpassword = input.next();
					if( readDbFile.next().equals(inpassword)) {
						System.out.println("\n You have Logged in Successfully! \n");
					found = true;
	                DirCreate();
	                showMenu();
	                break;
					}}
				}
			if(!found) {
					System.out.println("\n User not Found (or) Wrong Username or Password \n");
					System.out.println("\n1.Return Main Menu\n2.Close the application\n");
					Scanner sc = new Scanner(System.in);
					int chance = sc.nextInt();
					switch(chance) {
					case 1:{ main(null);}break;
					case 2:{break; }
					default:{ System.out.println("\n Invalid Input , Please Try Again With Above Mentioned Options ");  main(null); break;}
					}
				}
		}catch (Exception e) {
		}
	}
	
	// For doing CRUD like operations in MyLockers DB 
	public static void showMenu() throws IOException {
		System.out.println("\n%%%%%%%% MyLocker %%%%%%%%\n");
		System.out.println("\n1.List Files in Directory\n2.File operations(Add,Delete,Search File in Directory)\n3.Close the application\n");
		try {
		Scanner sc = new Scanner(System.in);
		int option1 = sc.nextInt();
		switch(option1) {
		case 1:{ listFiles(); }
		try {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("\n1.Return to Locker\n2.Close the application\n");
		int op = sc1.nextInt();
		switch(op) {
		case 1 :{ showMenu(); }
		case 2 :{ break; }
		default:{ System.out.println("\n Invalid Input , Please Try Again With Above Mentioned Options \n"); showMenu();}
		}
		}catch(Exception e) {
			System.out.println("\n Invalid Input , Please Try Again With Above Mentioned Options \n"); showMenu();
		}
		case 2:{ showOperations(); }
		
		case 3:{ System.exit(option1); }
		
		default:{ System.out.println("\n Invalid Input , Please Try Again With Above Mentioned Options \n"); showMenu();}
		}}catch(Exception e) {
		}
		
	}
	
	public static void listFiles() {
	try {
		if(createFile.list().length==0) {
			System.out.println("\nFolder is empty\n");
		}else {
		System.out.println("\n**The Files Available in " + Directory + " are : \n");
		String[] lists = createFile.list();
		Arrays.sort(lists);
		for(String view : lists) {
			System.out.println(view);
		}
		}
	}catch(Exception e) {
		e.getMessage();
	}
	}
	// 
	public static void showOperations() throws IOException {
		
		System.out.println("\n1.Add New File\n2.Delete Existing File\n3.Search File\n4.Return to Locker\n");
		try {	
		Scanner sc = new Scanner(System.in);
		int option3 = sc.nextInt();
		
		switch(option3) {
		
		case 1:{ System.out.println("\nEnter File Name to Add : \n");
		Scanner sc2 = new Scanner(System.in);
		String Name = sc2.next().trim().toLowerCase(); 
		addFile(Name);
		showMenu();
		break;
		}
			case 2:{ System.out.println("\nEnter File Name to Delete : \n");
			Scanner sc4 = new Scanner(System.in);
			String name2 = sc4.next().trim();
			deleteFile(name2);
			showMenu();
			break;
			}
			case 3:{System.out.println("\nEnter the File Name to Check Status : \n");
			Scanner sc5 = new Scanner(System.in);
			String sc7 = sc5.next().trim();
			searchFile(sc7);
			showMenu();
			break;
			}
			case 4:{ showMenu();}
			default:{ System.out.println("\n Invalid Input \n");	}
			showOperations();
			break;
		}
	}catch(Exception e) {
		System.out.println("\n Invalid Input \n");
		showOperations();
	}
	}
	// For adding file 
	public static void addFile(String name) throws IOException {
		
		File filec = new File(createFile+"/"+name);
		String list1[] = createFile.list();
		for(String namecheck : list1) {
			if(name.equalsIgnoreCase(namecheck)) {
				System.out.println(" File already exists in the folder ");
			return;
			}
		}
		filec.createNewFile();
		boolean res = filec.createNewFile();
		if(!res) System.out.println("\n File Created Successfully \n");
		
	}
	// For deleting file 
	public static void deleteFile(String name) {
		File file = new File(createFile+"/"+name);
		String[] list = createFile.list();
		for(String view1 : list) {
			if(name.equals(view1) && file.delete()) {
				System.out.println("\n File Deleted Successfully \n");
				return;
			}
		}
		System.out.println("\n File Not Found \n");
	}
	// For searching file 
	public static void searchFile(String Name) {
		new File(createFile+"/"+Name); 
		String[] list = createFile.list();
		for(String str : list) {
			if(Name.equals(str)) {
				System.out.println("\n File Found ");
				return;
			}
		}
		System.out.println("\n** File Not Found **\n");
	} 
	
	}


