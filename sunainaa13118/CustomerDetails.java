package sunainaa13118;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.util.*;

public class CustomerDetails extends JDialog {
	private JLabel lblCustomer = new JLabel("Available Customers List");
	private JTextArea jcust = new JTextArea(20,50);
	private JScrollPane scrollPane = new JScrollPane(jcust);
	private JLabel jlblid=new JLabel("Customer id");
	private JComboBox<String> jtfCustomerID=new JComboBox<String>();
    private JLabel jlblIssued=new JLabel("Movie Issued");
    private JComboBox<String> jissue=new JComboBox<String>();
	public CustomerDetails() {
		String str="";
		int custid[]=new int[50];
		String issuemovie[]=new String[50];
		File f1=new File("Issue.dat");
		if(f1.exists()){
		try{ 
			
		
			DataInputStream out2= new DataInputStream(new FileInputStream(f1));
			int i=0;
			while(out2.available()!=0){
                custid[i]=out2.readInt();
				issuemovie[i]=out2.readUTF(); System.out.print(custid[i]);
				
		}
			out2.close();
			} 
		catch(Exception e){
			e.printStackTrace();
		}
		}
		try{
			File f=new File("Customer.dat");
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
			Customer m[]=new Customer[80];
			int i=0;int x;
			while((m[i]=(Customer)in.readObject())!=null){
				
	            
				str+=m[i].getCustID()+":FirstName="+m[i].getFirstName()+"  Lastname="+m[i].getLastName()+"  Phone="+m[i].getphoneNo();
				str+="\n";
				jtfCustomerID.addItem(m[i].getCustID()+"");
				if(m[i].getIssuedMovies()!=null){
				       for(int j=0;j<custid.length;j++){
				    	   if(custid[j]==0) break;
				    	   else
				    		  if(custid[j]==m[i].getCustID()) 
				    		        jissue.addItem(issuemovie[j]);
				       }
					
					
				}//end if
				else
					jissue.addItem("none");
				i++;	
			}// end while
			
			in.close();
		}
		catch(NullPointerException e){
			System.out.println("no movies");
		}
		catch (EOFException e){
			System.out.println("end of file reached");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		jcust.setText(str);
		JPanel jCustomer = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jCustomer.add(lblCustomer);
		jCustomer.add(scrollPane);
		jissue.setEnabled(false);
		jtfCustomerID.addItemListener(new ComboItemListener());
		this.add(jCustomer,BorderLayout.NORTH);
		JPanel jCustomer1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jCustomer1.add(jlblid);
		jCustomer1.add(jtfCustomerID);
		jCustomer1.add(jlblIssued);
		jCustomer1.add(jissue);
		this.add(jCustomer1,BorderLayout.SOUTH);
		this.setTitle("Customer Details");
		this.setSize(500, 400);
		this.pack();
		setLocationRelativeTo(new JFrame());
	}
	private class ComboItemListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent e){
			jissue.setSelectedIndex(jtfCustomerID.getSelectedIndex());
		}
	
		}

}
