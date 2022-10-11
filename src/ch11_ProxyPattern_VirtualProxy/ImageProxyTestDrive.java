package ch11_ProxyPattern_VirtualProxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ch11_ProxyPattern_VirtualProxy.Proxy.ImageProxy;
import ch11_ProxyPattern_VirtualProxy.RealSubject.ImageComponent;

public class ImageProxyTestDrive {

	ImageComponent imageComponent;
	JFrame frame = new JFrame("Album Cover Viewer");
	JMenuBar menuBar;
	JMenu menu;
	Hashtable<String, String> albums = new Hashtable<>();

	public ImageProxyTestDrive() throws MalformedURLException {
		albums.put("Buddha Bar", "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
		albums.put("Ima", "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
		albums.put("Karma", "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
		albums.put("MCMXC a.D.", "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
		albums.put("Northern Exposure", "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
		albums.put("Selected Ambient Works, Vol. 2",
								"http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");

		menuBar = new JMenuBar();
		menu = new JMenu("Favorite Albums");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		// add menu items and their listeners
		for (Enumeration<String> e = albums.keys(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			JMenuItem menuItem = new JMenuItem(name);
			menu.add(menuItem);
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					// if the user requests a new image, we’ll create a new proxy and start the process over
					imageComponent.setIcon(new ImageProxy(getAlbumUrl(event.getActionCommand())));
					frame.repaint();
				}
			});
		}

		// Here we create an image proxy and set it to an initial URL.
		// Whenever you choose a selection from the Album menu, you’ll get a new image proxy.
		URL initialURL = new URL((String) albums.get("Selected Ambient Works, Vol. 2"));
		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);

		frame.setSize(800, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	URL getAlbumUrl(String name) {
		try {
			return new URL((String) albums.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			new ImageProxyTestDrive();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
