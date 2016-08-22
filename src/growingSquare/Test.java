package growingSquare;

import java.awt.EventQueue;


public class Test {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	 new Myfram();
            }
        });
		
		
/*
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		 frame.add(panel);
		 panel.setBackground(Color.GRAY);
		
		 JButton start=new JButton("Start");
		 start.setBounds(40,100,100,60);
		 panel.add(start);
		 
		 start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.draw=true;
				frame.repaint();
			}
		});
		 
		 JButton end=new JButton("End");
		 end.setBounds(40,170,100,60);
		 panel.add(end);
		 
		 end.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.draw=false;
				frame.repaint();
			}
		});
		*/
	}
}
