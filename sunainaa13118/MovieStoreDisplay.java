package sunainaa13118;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.util.*;

public class MovieStoreDisplay extends JFrame {
	private JButton jbtAddMovie=new JButton("Add New Movie");
	private JButton jbtLibrary=new JButton("Movie Library");
	private JButton jbtAddUser=new JButton("Add New Customer");
	private JButton jbtIssueMovie=new JButton("Issue Movie");
	//private JButton jbtReturnMovie=new JButton("Return Movie");
	private JButton jbtCustomerDetails=new JButton(" Customer Details and Return Movies");
	private JLabel jlImage=new JLabel(new ImageIcon("movie library.jpeg"));
	 MovieStoreDisplay()
	 {   
		 
		
		 JPanel jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
		 jbtAddMovie.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 Movieinsert mi=new Movieinsert();
				 mi.setModal(true);
				 mi.setVisible(true);
			 }
		 });
		 jbtLibrary.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 MovieDisplay mi=new MovieDisplay();
				 mi.setModal(true);
				 mi.setVisible(true);
			 }
		 });
		 jbtAddUser.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 AddNewCustomer mi=new AddNewCustomer();
				 mi.setModal(true);
				 mi.setVisible(true);
			 }
		 });
		 jbtCustomerDetails.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 CustomerDetails mi=new CustomerDetails();
				 mi.setModal(true);
				 mi.setVisible(true);
			 }
		 });
		 jbtIssueMovie.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 IssueMovie mi=new IssueMovie();
				 mi.setModal(true);
				 mi.setVisible(true);
			 }
		 });
		 jp.add(jbtAddMovie);
		 jp.add(jbtLibrary);
		 jp.add(jbtAddUser);
		 jp.add(jbtCustomerDetails);
		 jp.add(jbtIssueMovie);
		// jp.add(jbtReturnMovie);
		 JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		 jp1.add(jlImage);
		
		
		 this.add(jp,BorderLayout.CENTER);
		 this.add(jp1,BorderLayout.SOUTH);
		
		 
	 }

	public static void main(String args[]) {
		MovieStoreDisplay mv = new MovieStoreDisplay();
		mv.setTitle("Movie Store");
		mv.setLocationRelativeTo(null);
		mv.setSize(400, 400);
		mv.setVisible(true);
        mv.pack();
		mv.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
   
   }

