package matn_se_khati;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

public class Panel extends JPanel {
	public static final int SPEED = 10;
	private static File textsFolder = new File("files/matn_se_khati/texts");
	private Random r;
	private Scanner scanner;
	private String text;

	public Panel() {
		r = new Random();
		try {
			create();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void create() throws FileNotFoundException {
		File[] files = textsFolder.listFiles();
		int a = r.nextInt(files.length);
		scanner = new Scanner(files[a]);
		text = scanner.useDelimiter("\\Z").next();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(text, 100, 100);
	}

}
