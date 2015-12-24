package sunainaa13118;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.util.*;

public class Movieinsert extends JDialog {
	private JLabel jlMovieName = new JLabel("Movie Name");
	private JTextField jtfMovieName = new JTextField(20);
	private JLabel jlYear = new JLabel("Year");
	private JTextField jtfYear = new JTextField(4);
	private JLabel jlGenere = new JLabel("Genere");

	private String movieGenere[] = { "Comedy", "Action", "Family", "Horror",
			"Documentary", "Adventure", "History", "War", "Fantasy",
			"Science Fiction", "Animation", "Musical", "Biography", "Romantic" };
	private JComboBox jcbGenere = new JComboBox(movieGenere);
	private JButton jbtADD = new JButton("ADD");
	private JLabel jlMovieInfo = new JLabel("Details");
	private JTextArea textarea = new JTextArea(8, 30);
	private JButton jbtAddtoFile = new JButton("Add to File");
	private JScrollPane scrollPane = new JScrollPane(textarea);

	Movieinsert() {
		JPanel jMovie = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jMovie.add(jlMovieName);
		jMovie.add(jtfMovieName);
		jMovie.add(jlGenere);
		jMovie.add(jcbGenere);
		jMovie.add(jlYear);
		jMovie.add(jtfYear);

		jbtADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append(jtfMovieName.getText().trim() + ","
						+ jtfYear.getText().trim() + ","
						+ jcbGenere.getSelectedItem() + "\n");
				if (textarea.getText() != "") {
					jbtAddtoFile.setEnabled(true);
				} else
					jbtAddtoFile.setEnabled(false);

			}
		});
		jMovie.add(jbtADD);
		this.add(jMovie, BorderLayout.NORTH);
		JPanel jMovieAdd = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jMovieAdd.add(jlMovieInfo);
		jMovieAdd.add(scrollPane);
		jbtAddtoFile.setEnabled(false);

		jbtAddtoFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("movie.dat");
				
					
					int startID = 1;
			        Movie[] m=new Movie[100]; int counter=0;
					if (f.exists()) {
						
						try{
							ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
						m= (Movie[]) in.readObject();	
						
	                    System.out.println(m.length);
						while(counter<m.length){
							System.out.println("counter:"+counter);
							if(m[counter]==null) break;
							else 
								counter++;
						}
						System.out.println("counter:"+counter);
						 
						
						startID = (m[counter-1].getMovieID()) + 1;
						
					
						in.close();
					}
					catch(ArrayIndexOutOfBoundsException e1){
						System.out.println("end of movie array reached");
					}
					catch(EOFException e1){
						System.out.println("end of file reached");
					}
			        catch(IOException e1){
			        	System.out.println("end of file reached");	
			        }
						catch(ClassNotFoundException e1){
							System.out.println("class not found");
						}
					}			
						
                  try{
					ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(f));

					String lines[] = textarea.getText().split("\n");
				
					String token[];
					for (int i = 0; i < lines.length; i++) {
						token = lines[i].split(",");

						m[i+counter] = new Movie();
						m[i+counter].setMovieName(token[0]);
						System.out.println(token[0]);
						m[i+counter].setYear(Integer.parseInt(token[1]));	
						System.out.println(token[1]);
						m[i+counter].setGenere(token[2]);
						System.out.println(token[2]);
						m[i+counter].setMovieID(startID);
						startID++;
					}
					out1.writeObject(m);
					out1.close();

					textarea.setText("");
					jbtAddtoFile.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Records added");

				} catch(ArrayIndexOutOfBoundsException e1){
					System.out.println(e1.getMessage());
				}
                  catch (Exception e1) {
					e1.printStackTrace();
				}

			}
			
		});
		jMovieAdd.add(jbtAddtoFile);
		this.add(jMovieAdd, BorderLayout.SOUTH);
		this.setTitle("Add a new Movie");
		this.setSize(700, 400);
		this.pack();
		setLocationRelativeTo(new JFrame());

	}

	

	
}
