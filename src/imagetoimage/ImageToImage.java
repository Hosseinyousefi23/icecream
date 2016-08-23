package imagetoimage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ImageToImage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	// all images in given directory
	private ArrayList<Image> images;
	// Directory
	private static final File dir = new File("files/blinking_images/images");
	// all pasvands :D
	private static final String[] EXTENSIONS = new String[] { "gif", "png", "bmp" };
	// screen size for dynamic show :D
	private int SCREEN_WIDTH, SCREEN_HEIGHT;
	// Timer for sleeping and blinking
	private Timer timer;
	// timer time to sleep in miliseconds
	private int blinkingTime = 400;

	// pass screen size from frame class
	public ImageToImage(int screenWidth, int screenHeight) {
		images = new ArrayList<>();
		this.SCREEN_WIDTH = screenWidth;
		this.SCREEN_HEIGHT = screenHeight;
		timer = new Timer(blinkingTime, this);
		timer.start();
	}

	// searching for all images throught the give directory
	private static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};

	public void invokeAllImages() {
		if (dir.isDirectory()) {
			for (File f : dir.listFiles(IMAGE_FILTER)) {

				BufferedImage img = null;

				try {
					img = ImageIO.read(f);
					// add to images array
					ImageIcon imgIcon = new ImageIcon(img);
					images.add(imgIcon.getImage());

				} catch (final IOException e) {
					// in ja error ro neshon midim cherto perte ......
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		int x, y;

		ArrayList<Point> positions = getPositions();
		for (int i = 0; i < positions.size(); i++) {
			gg.drawImage(images.get(i), positions.get(i).x, positions.get(i).y, this);
		}
	}

	// make random positions and return array of points respectively
	public ArrayList<Point> getPositions() {
		ArrayList<Point> positions = new ArrayList<>();
		Random rnd = new Random();
		int rightBoundary = SCREEN_WIDTH - 100;
		int leftBoundary = SCREEN_HEIGHT - 100;
		int x, y;
		for (int i = 0; i < images.size(); i++) {

			x = rnd.nextInt(rightBoundary);
			y = rnd.nextInt(leftBoundary);
			positions.add(new Point(x, y));
		}
		return positions;
	}

	// repeat repainting for blinking purposes
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
