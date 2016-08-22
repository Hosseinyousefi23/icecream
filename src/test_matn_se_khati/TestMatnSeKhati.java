package test_matn_se_khati;

import javax.swing.JFrame;

import matn_se_khati.Panel;

public class TestMatnSeKhati {
	public static void main(String[] args) {
		JFrame application = new JFrame();
		application.setSize(600, 600);
		application.setVisible(true);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		application.add(p);
	}
}
