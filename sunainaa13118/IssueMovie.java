package sunainaa13118;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;

public class IssueMovie extends JDialog{
//	super("Issue Movie");
	private JLabel jlMovieID=new JLabel("Movie ID");
	private JComboBox<String> jtfMovieID=new JComboBox<String>();
	private JLabel jlMovieInfo=new JLabel("Movie Information");
	private JComboBox<String> jtfMovieInfo=new JComboBox<String>();
	private JButton jbtAdd=new JButton("Add to Cart");
    private Movie a[]=new Movie[100];
    private Customer m[]=new Customer[50];
	private JTextArea textarea=new JTextArea(8,25);
	private JButton jbtIssue=new JButton("Issue Movies");
	private JLabel JlblCustomerID=new JLabel("Customer ID");
	private JComboBox<String> jtfCustomerID=new JComboBox<String>();
	private JComboBox<String>jtfFirstName=new JComboBox<String>();
	private JLabel jlblFirstName=new JLabel("First Name");
	private JLabel jlblLastName=new JLabel("Last Name");
	private JComboBox<String>jtfLastName=new JComboBox<String>();
	private int movielength;

	public IssueMovie()
	{   
		initialization();
		JPanel jp=new JPanel(new FlowLayout());
		jtfMovieID.addItemListener(new ComboItemListener());
		jtfMovieInfo.addItemListener(new ComboItemListener());
		jtfCustomerID.addItemListener(new ComboItemListener());
		jtfFirstName.addItemListener(new ComboItemListener());
		jtfLastName.addItemListener(new ComboItemListener());
		jbtAdd.addActionListener(new ButtonActionListener());
		textarea.setEditable(false);
		jbtIssue.setEnabled(false);
		jtfFirstName.setEnabled(false);
		jtfLastName.setEnabled(false);
		jbtIssue.addActionListener(new ButtonActionListener());
		jp.add(jlMovieID);
		jp.add(jtfMovieID);
		jp.add(jlMovieInfo);
		jp.add(jtfMovieInfo);
		jp.add(jbtAdd);
	    jp.add(textarea);
		jtfMovieInfo.setEnabled(false);
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp3.add(JlblCustomerID);
		jp3.add(jtfCustomerID);
		jp3.add(jlblFirstName);
		jp3.add(jtfFirstName);
		jp3.add(jlblLastName);
		jp3.add(jtfLastName);
		jp3.add(jbtIssue);
	
		this.add(jp,BorderLayout.NORTH);
		//this.add(jp1,BorderLayout.NORTH);
		this.add(jp3,BorderLayout.SOUTH);
        this.setTitle("IssueMovie");
		this.setSize(500, 400);
		this.pack();
		setLocationRelativeTo(new JFrame());
	}

	private  void initialization()
	{
		File f = new File("movie.dat");
		
		if (f.exists()) {
			try {
			//	Movie[] a = new Movie[50];
				String str1[]=new String[50];
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				a = (Movie[]) in.readObject();
				int i;
				for( i=0;a[i]!=null;i++){
				if(a[i].getStatus().equals("AVAILABLE")){
					str1[i]=""+(a[i].getMovieID());
					jtfMovieID.addItem(str1[i]);
					jtfMovieInfo.addItem(a[i].GetMovieName()+","+a[i].getYear()+","+a[i].getGenere());
				}//end if
					
				}//end for
				movielength=i;
				//jlist.add();
			    in.close();

			} 
			catch(ArrayIndexOutOfBoundsException e){
          	  System.out.println("end reached");
            }
			catch (Exception e) {
				e.printStackTrace();
				}
              
			} 
			f=new File("Customer.dat");
			try{
			//	Customer m[]=new Customer[50];
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				int i=0;
				try{
				while((m[i]=(Customer)in.readObject())!=null)
					i++;
				}
				catch (EOFException e1)
				{
					System.out.print("End of file reached");
				}
				in.close();
				for(i=0;m[i]!=null;i++){
					jtfCustomerID.addItem(m[i].getCustID()+"");
					jtfFirstName.addItem(m[i].getFirstName());
					jtfLastName.addItem(m[i].getLastName());
					
				}
			}
			catch(ArrayIndexOutOfBoundsException e){
	          	  System.out.println("end reached");
	            }
			catch (Exception e) {
				e.printStackTrace();

			}

	}
	private class ComboItemListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent e){
			/*	if(e.getSource()==jtfMovieInfo){
				jtfMovieID.setSelectedIndex(jtfMovieInfo.getSelectedIndex());
			}
			else*/ if (e.getSource()==jtfMovieID){
				jtfMovieInfo.setSelectedIndex(jtfMovieID.getSelectedIndex());
			}
			else if (e.getSource()==jtfCustomerID){
				jtfFirstName.setSelectedIndex(jtfCustomerID.getSelectedIndex());
				jtfLastName.setSelectedIndex(jtfCustomerID.getSelectedIndex());
			}
		/*	else if (e.getSource()==jtfFirstName){
				jtfCustomerID.setSelectedIndex(jtfFirstName.getSelectedIndex());
				jtfLastName.setSelectedIndex(jtfFirstName.getSelectedIndex());
				
			}*/
		/*	else if (e.getSource()==jtfLastName){
				jtfCustomerID.setSelectedIndex(jtfLastName.getSelectedIndex());
				jtfFirstName.setSelectedIndex(jtfLastName.getSelectedIndex());
			}*/
		}
	}
	private class ButtonActionListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==jbtAdd){
				String str= jtfMovieID.getSelectedItem()+":"+jtfMovieInfo.getSelectedItem();
				textarea.append(str+"\n");
				jbtIssue.setEnabled(true);
			}
			else if(e.getSource()==jbtIssue){
			    Movie[] issued=new Movie[10];
				String str[]=textarea.getText().split("\n");
				String str1[];
				int j=0,k=0;
				for(int i=0;i<str.length;i++)
				{   str1=str[i].split(":");
	                for(j=0;j<movielength;j++){
	                	if(Integer.parseInt(str1[0])==a[j].getMovieID()){
	                		a[j].setStatus(Movie.ISSUED); 
	                		issued[k]=a[j];k++;
	                	}//end if
	                }//end for
	                 	
				}//end for
				for(int i=0;m[i]!=null;i++){
					if(Integer.parseInt(jtfCustomerID.getItemAt(jtfCustomerID.getSelectedIndex()))==m[i].getCustID()){
						Movie temp[]=new Movie[k];
						m[i].setIssuedMovies(temp);
					}
				}
				try{
					ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("movie.dat"));
				/*	Movie temp[]=new Movie[movielength];
					for(j=0;a[j]!=null;j++){
					temp[j]=a[j];
					}  */
					out1.writeObject(a);
					out1.close();
				}
				catch (Exception e1) {
					e1.printStackTrace();

				}
				try{ 
					ObjectOutputStream out2= new ObjectOutputStream(new FileOutputStream("Customer.dat"));
					for(int i=0;i<m.length;i++){
						if(m[i]==null) break;
						out2.writeObject(m[i]);
					}
					out2.close();
					
					for(int i=0;i<str.length;i++)
					{   str1=str[i].split(":");
					    for(int l=0;l<jtfMovieID.getItemCount();l++){
					    	if(str1[0].trim().equals(jtfMovieID.getItemAt(l).trim())){
					    		jtfMovieID.removeItemAt(l);
					    		jtfMovieInfo.removeItemAt(l);
					    	}
					    }
					 }//end for
					
				}
				catch(Exception e1) {
					e1.printStackTrace();

				}
				try{
                        DataOutputStream out2= new DataOutputStream(new FileOutputStream("Issue.dat",true));
                        out2.writeInt(Integer.parseInt(jtfCustomerID.getItemAt(jtfCustomerID.getSelectedIndex())));
                        out2.writeUTF(textarea.getText());
                        out2.close();
                        textarea.setText("");
    					JOptionPane.showMessageDialog(new Frame(), "movie issued");
				}
				catch(Exception e1) {
					e1.printStackTrace();

				}
	
		}// end else if
	}
	}
}
