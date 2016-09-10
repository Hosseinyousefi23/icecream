package oneWord;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class OneWord extends JFrame {

	int counter = 0;
	int width = 1200, height = 700;
	Color color = Color.BLACK;
	String[] fileName = { "test.txt" };
	int index = 0;
	int delay = 1000;
	ArrayList<String> words;

	DrawPanel drawPanel = new DrawPanel();

	public OneWord() {

		Random random = new Random();
		index = random.nextInt(fileName.length);
		words = splitText(fileName[index]);

		String input;
		input = JOptionPane.showInputDialog("Enter the delay (exm:1000ms):");
		// JOptionPane.showMessageDialog(null, input);
		delay = Integer.parseInt(input);

		ActionListener listener = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				if (counter < words.size()) {
					drawPanel.repaint();
					counter++;
				}

			}
		};
		final Timer timer = new Timer(delay, listener);

		drawPanel.setLayout(null);
		add(drawPanel);

		JButton start = new JButton("Start");
		start.setBounds(40, 100, 100, 60);
		drawPanel.add(start);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				counter = 0;
				timer.start();
			}
		});

		JButton end = new JButton("End");
		end.setBounds(40, 170, 100, 60);
		drawPanel.add(end);

		end.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				timer.stop();
			}
		});

		pack();
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		drawPanel.setBackground(Color.PINK);

	}

	private ArrayList<String> splitText(String textName) {

		ArrayList<String> words = new ArrayList<String>();
		File textsFolder = new File("files/matn_se_khati/texts/" + textName);
		String line;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(textsFolder), "UTF8"));
			while ((line = in.readLine()) != null) {
				String[] str = line.split(" ");

				for (int i = 0; i < str.length; i++) {
					words.add(str[i]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return words;

	}

	private class DrawPanel extends JPanel {

		JLabel jlabel;

		public DrawPanel() {

			jlabel = new JLabel("");
			// jlabel.setFont(new Font("Segoe Ui", 20, 20));
			this.setLayout(null);
			jlabel.setBounds(width / 2 - 50, height / 2 - 50, width, 50);
			this.add(jlabel);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.WHITE);
			g.fillRect(0, height / 2 - 50, width, 50);
			if (counter < words.size()) {
				jlabel.setText(words.get(counter));
			}
		}

	}

}
