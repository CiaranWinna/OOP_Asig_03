/*Name:Ciaran Winnan
 *Student ID: 2940836
*/

import java.util.*;
public class Assignment3_2017{
	public static void main(String args[]){
    IntManager in = new IntManager(100);
		System.out.println(in);
		for(int j = 0; j < 20; j++){
			int x = (int)(Math.random()*20);
			in.add(x);
		}
		System.out.println(in);
		
		//found function test
		boolean isFound = in.found(6);
		System.out.println("Found: " + isFound);
		
		//Max value function test
		Integer maxValue = in.max();
		System.out.println("Max Value: " + maxValue);
		
		//Sum of Odds function test
		Integer sumOfOdds = in.sumOdd();
		System.out.println("Sum of odds: " + sumOfOdds);
		
		//Frequency function test
		Integer frequency = in.freq(5);
		System.out.println("Frequency:" + frequency);
		
		//getOdd function test
		Integer [] getOddNumber = in.getOdd();
		for(int i = 0; i < getOddNumber.length; i++){
			System.out.print(getOddNumber[i] + " ");
		}
		
		//toString method test
		String myString = in.toString();
		System.out.println("\n" + myString);  
		
		
		
		/*Q2  ==============================================
		  This code is a sample test for Q2.*/
		TicketManager tm = new TicketManager();
     	System.out.println("\n" + tm);
     	
     	Ticket t1 = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	tm.buy(t1);
     	
     	System.out.println(tm);
     	
     	Ticket t2 = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	tm.buy(t2);
     	
     	System.out.println(tm);
     	
     	for(int j = 0; j < 200; j++)
     		tm.buy(new Ticket((int)(Math.random()*5),(int)(Math.random()*5)));
     	System.out.println(tm.sold());
     	Ticket draw = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	System.out.println(tm.freqWinner(draw));
     	Ticket search = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	System.out.println(tm.search(search));
     	System.out.println(tm.allSold());
     	String ticketString = tm.toString();
     	System.out.println(ticketString);
     	
	}
}
//Q1 class ===============================================
class IntManager{
	
	private Integer dt[];
	private int size;
	
	public IntManager(int k){
		dt = new Integer[k];
		size = 0;
	}
	
	public void add(Integer x){
		if(size < dt.length){
			dt[size] = x; 
			size++;
		}
	}
	
	public boolean found(Integer x){
		
		boolean found = false;
		int j = 0;
		
		while(j < size && !found){
			if(x.equals(dt[j])){
				found = true;
			}
			else{
				j++;
			}
		}
		
		if(found){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Integer max(){
		if(size == 0) return null;
		Integer maxInteger = dt[0];
		for(int i = 1; i < size; i++){
			if(dt[i] > maxInteger){
				maxInteger = dt[i]; 
			}
		}
		
		return new Integer(maxInteger);
	}
	
	public Integer sumOdd(){
		Integer sumOfOdds = 0;
		if(size == 0){
			return new Integer (null);
		}
		else{
			for(int i = 0; i < size; i++){
				if(dt[i] % 2 != 0){
					sumOfOdds = sumOfOdds + dt[i];
				}
			}
		}	
		return new Integer (sumOfOdds);
	}
	
	public Integer freq(Integer x){
		Integer count = 0;
		for(int i = 0; i < size; i++){
			if(dt[i] == x){
				count++;
			}
		}
		return new Integer (count);
	}
	
	public Integer[] getOdd(){
		
		int oddArrayLength = 0; 
			
		for(int i = 0; i < size; i++){
			if((dt[i] & 1) != 0){
				oddArrayLength++;
			}
		}
		
		Integer [] myOddArray = new Integer [oddArrayLength]; 
		
		int arrayCount = 0;
		
		for(int j = 0; j < size; j++){
			if((dt[j] & 1) != 0){
				myOddArray[arrayCount] = dt[j];
				arrayCount++;
			}
		}
			
			
		return myOddArray;
	}
		
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + dt[j] + ",";
		return s+dt[size-1]+"]";
	}
}


//Q2 classes ================================================
class Ticket{
	
	private final int a,b;
	
	Ticket(int a1, int b1){
		a = a1; 
		b = b1;
	}
	
	public int a(){
		return a;
	}
	
	public int b(){
		return b;
	}
	
	public String toString(){
		return "["+a+","+b+"]";
	}
}


class TicketManager{
	
	private Ticket[] tickets;
	private int sold = 0;
	private int maxTickets = 500;
	
	TicketManager(){
		tickets = new Ticket [maxTickets];
	}
	
	public boolean buy(Ticket t){
		if(sold >= maxTickets){
			return false;
		}
		else{
			for(int i = 0; i < maxTickets; i++){
				if(tickets[i] == (null)){
					tickets[i] = t;
					i = 500;
				}
			}
			sold++;
			return true;
		}
	}
	
	public int freqWinner(Ticket t){
		int freq = 0;
		for(int i = 0; i < sold; i++){
			if(tickets[i].equals(t)){
				freq++;
			}
		}
		return freq;
	}
	
	public boolean search(Ticket t){
		for(int i = 0; i < sold; i++){
			if(tickets[i].equals(t)){
				return true;
			}
		}
		return false;
	}
	
	public int sold(){
		return sold;
	}
	
	public boolean allSold(){
		if(sold == 500){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		if(sold == 0) return "[]";
		String s = "[";
		for(int j = 0; j < sold - 1; j++)
			s = s + tickets[j] + ",";
		return s+tickets[sold-1]+"]";
	}
}