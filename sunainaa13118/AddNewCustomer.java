package sunainaa13118;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.util.*;

public class AddNewCustomer extends JDialog {
private JLabel lblFirstName=new JLabel("First Name");
private JTextField jtfFirstName=new JTextField(30);
private JLabel lblLastName=new JLabel("Last Name");
private JTextField jtfLastName=new JTextField(30);
private JLabel lblPhoneNo=new JLabel("Telephone No");
private JTextField jtfPhoneNo=new JTextField(10);
private JButton jbtAdd=new JButton("Add");
public AddNewCustomer()
{
	JPanel jCustomer = new JPanel(new GridLayout(3,2));
	jtfFirstName.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e){
			jbtAdd.setEnabled(true);
		}
		public void keyReleased(KeyEvent e){
			
		}
		public void keyTyped(KeyEvent e){
			jbtAdd.setEnabled(true);
		}
	});
	jCustomer.add(lblFirstName);
	jCustomer.add(jtfFirstName); 
	jCustomer.add(lblLastName);
	jCustomer.add(jtfLastName);
	jCustomer.add(lblPhoneNo);
	jCustomer.add(jtfPhoneNo);
	this.add(jCustomer,BorderLayout.NORTH);
	JPanel jCustomer1=new JPanel(new FlowLayout(FlowLayout.CENTER));
	jbtAdd.setEnabled(false);
	add(jbtAdd);
	jbtAdd.addActionListener(new CustListener());
	this.add(jCustomer1,BorderLayout.SOUTH);
	this.setTitle("Add New Customer");
	this.setSize(500, 400);
	this.pack();
	setLocationRelativeTo(new JFrame());

}
private class CustListener implements ActionListener
{
	public void actionPerformed(ActionEvent e){
		Customer c=new Customer();
		c.setFirstName(jtfFirstName.getText());
		c.setLastName(jtfLastName.getText());
		c.setPhoneNo(jtfPhoneNo.getText());
		File f=new File("Customer.dat");
		int Startid=1;
		try{ 
			Customer m[]=new Customer[50];
			if(f.exists()){
				ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
				
				int i=0;
				try{
				while((m[i]=(Customer)in.readObject())!=null)
					i++;
				}
				catch (EOFException e1)
				{
					System.out.print("End of file reached");
				}
				
				Startid=m[i-1].getCustID()+1;
				in.close();
				
			}
	    c.setCustID(Startid);		
		ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(f));
		if(Startid!=1){
			for(int j=0;m[j]!=null;j++){
				out1.writeObject(m[j]);
			}
		}
			out1.writeObject(c);
		
		out1.close();
		jtfFirstName.setText("");
		jtfLastName.setText("");
		jtfPhoneNo.setText("");
		jbtAdd.setEnabled(false);
		JOptionPane.showMessageDialog(new JFrame(), "Customer Added with CustomerID"+Startid);
		}
		catch(Exception e1){
			e1.printStackTrace();
			
		}
		
	}
}

}
