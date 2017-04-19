package by.htp.salon.domain;

import by.htp.salon.logics.MyIO;
import by.htp.salon.logics.RentUnit;

public class Manager {
	private RentUnit freeEquip=new RentUnit();
	private OrderList order=new OrderList();
	private RentUnit rentEquip=new RentUnit();
	private MyIO myIO=new MyIO();
	
	public void setList(Equipment[] equip){
		freeEquip.setEquip(equip);
	}
	
	public void newOrder(Equipment equip,Client client){
		if (equip!=null){
			if (order.culcRentUnit(client)<3){
			order.newOrder(equip, client);
			rentEquip.add(equip);
			int i=freeEquip.find(equip);
			freeEquip.delByIndex(i);
			}
			else {System.out.println("You rent 3 units");
			}
		}
	}
	public void showList(Equipment[] list){
		int flag=0;
		for(int i=0; i<list.length-1;i++){
		 		if (list[i]!=null){
		 			System.out.println(list[i]);
		 		flag++;	
		 		}
		 	}
		if (flag==0){
			System.out.println("List empty");}
	}
	
	
	public void showFreeEquip(){
		 freeEquip.showAll();
	}
	
	public void showRentEquip(){
		 rentEquip.showAll();
	}
	
	public void showClientUnit(Client client){
		showList(order.findClienOrder(client));
	}
	
	
	public int findIndexByTitle(String title){
		int index=-1;
		for (int i=0; i<freeEquip.getSizeList();i++){
			if (freeEquip.getByIndex(i).getTitle()==title){
			index=i;	
			}
		}
		return index;
	}
	public Equipment findByTitle(String title){
		int i;
		i=findIndexByTitle(title);
		if (i>=0){
			return freeEquip.getByIndex(i);}
		else {
			System.out.println(title+" not found");	
			return null;	
		}
	}
	
	public void printReportByRent(){
		myIO.WriteList(freeEquip);
		myIO.ReadEquip();
	}
	
	
}
