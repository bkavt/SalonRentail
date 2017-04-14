package by.htp.salon.logics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import by.htp.salon.domain.Equipment;

public  class MyIO {
	private  RentUnit myRentList=new RentUnit();
	private  Date dateNow = new Date();
	private  SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy_MM_dd");
	private String nameFile;
	
	private String getDate(){
		
		nameFile="d://kurs//rent_unit_"+formatForDateNow.format(dateNow)+".txt";
		//System.out.println(nameFile);
		return formatForDateNow.format(dateNow)+".txt";
	}
	
	
	
	public  void WriteList(RentUnit list) {
		myRentList=list;
		int size=myRentList.getSizeList();
		
	    nameFile="d://Kurs//rent_unit_"+getDate();
	    File file=new File(nameFile);
		
		    try(FileWriter myFile=new FileWriter(file,false)){
				for (int i=0;i<size;i++){
					
					
					myFile.write(myRentList.getByIndex(i).toString()+"\r\n");
					
				}	
		    }
			catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        } 
	    
		
	}
}
