package ch11_ProxyPattern_VirtualProxy.Proxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {

	// The imageIcon is the REAL icon that we eventually want to display when it’s loaded
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;

	// pass the URL of the image into the constructor, This is the image we need to display once it’s loaded!
	public ImageProxy(URL imageURL) {
		this.imageURL = imageURL;
	}

	// we return a default width and height (800x600) until the imageIcon is loaded
	@Override
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 600;
		}
	}

	@Override
	public int getIconWidth() {
		if (imageIcon != null) {
			return imageIcon.getIconWidth();
		} else {
			return 800;
		}
	}

	// paint the icon on the screen by delegating to the imageIcon
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		if (imageIcon != null) {
			// if we’ve got an icon already, we go ahead and tell it to paint itself...
			imageIcon.paintIcon(c, g, x, y);
		} else {
			// ...otherwise we display the “loading” message
			g.drawString("Loading album cover, please wait...", x + 300, y + 200);
			if (!retrieving) {
				// if we aren’t already trying to retrieve the image, then start retrieving it
				retrieving = true;
				// We don’t want to hang up the entire user interface, so we’re going to use another thread
				// for retrieve the image (only one thread calls paint)
				// When you resize the window as the “loading” message is displayed,
				// notice that the proxy is handling the loading without hanging up the window
				retrievalThread = new Thread(new Runnable() {
					public void run() {
						try {
							// here’s where we load the REAL icon image
							imageIcon = new ImageIcon(imageURL, "Album Cover");
							c.repaint();
							// Now we’ve got an imageIcon already, so the next time the paintIcon method
							// will paint the image, not the loading message
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}

}
