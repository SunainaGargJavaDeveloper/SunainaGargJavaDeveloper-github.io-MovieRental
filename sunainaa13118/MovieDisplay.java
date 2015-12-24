package sunainaa13118;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.util.*;

public class MovieDisplay extends JDialog {
	private JLabel jlGenere = new JLabel("Genere");
	private String movieGenere[] = { "Comedy", "Action", "Family", "Horror",
			"Documentary", "Adventure", "History", "War", "Fantasy",
			"Science Fiction", "Animation", "Musical", "Biography", "Romantic" };
	private JComboBox jcbGenere = new JComboBox(movieGenere);
	private JTextArea textarea = new JTextArea(8, 30);
	private JScrollPane scrollPane = new JScrollPane(textarea);

	public MovieDisplay() {

		File f = new File("movie.dat");
		Movie[] a = new Movie[50];
		if (f.exists()) {
			try {

				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(f));
				    //in.reset();
					a = (Movie[]) in.readObject();
					
				
				// System.out.println(s.length); a=s;}
				in.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		System.out.println(a.length);
		final Movie[] a1 = a;
		JPanel jMovie = new JPanel(new FlowLayout(FlowLayout.CENTER));

		jMovie.add(jlGenere);
		jMovie.add(jcbGenere);
		jMovie.add(scrollPane);
		textarea.setText(settextdata(a1));
		jcbGenere.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				textarea.setText("");
				textarea.append(settextdata(a1));
			}

		});
      
		this.add(jMovie);
		this.setTitle("Movie Information");
		this.setSize(700, 400);
		this.pack();
		setLocationRelativeTo(new JFrame());

	}

	private String settextdata(Movie[] a1) {

		int i = 0;
		String str = new String();
		str = "";
		System.out.println(a1.length);
		while (i < a1.length) {
			if (a1[i] == null)
				break;
			if (a1[i].getGenere().equals(jcbGenere.getSelectedItem())) {
				str += a1[i].getMovieID() + "::" + a1[i].GetMovieName() + ","
						+ a1[i].getYear() + ":" + a1[i].getStatus() + "\n";
			}
			i++;
		}
		return str;

	}

	
}