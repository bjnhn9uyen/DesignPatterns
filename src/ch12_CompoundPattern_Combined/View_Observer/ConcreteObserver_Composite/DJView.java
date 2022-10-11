package ch12_CompoundPattern_Combined.View_Observer.ConcreteObserver_Composite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ch12_CompoundPattern_Combined.Controller_Strategy.ControllerInterface;
import ch12_CompoundPattern_Combined.Model_Subject.BeatModelInterface;
import ch12_CompoundPattern_Combined.View_Observer.BPMObserver;
import ch12_CompoundPattern_Combined.View_Observer.BeatObserver;

// DJView is an observer for both real-time beats and BPM changes
public class DJView implements ActionListener, BeatObserver, BPMObserver {

	// The view delegates behavior to the concrete controller that implements the controller interface.
	// We can plug in different controllers to provide different behaviors for the view
	BeatModelInterface model;
	ControllerInterface controller;

	BeatBar beatBar;
	JLabel bpmOutputLabel;

	JMenuItem startMenuItem;
	JMenuItem stopMenuItem;
	JTextField bpmTextField;
	JButton setBPMButton;
	JButton increaseBPMButton;
	JButton decreaseBPMButton;

	public DJView(BeatModelInterface model, ControllerInterface controller) {
		this.model = model;
		this.controller = controller;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
	}

	public void setupWindow() {
		JFrame frame = new JFrame();

		// the components for the user interface controls
		JPanel controlPanel = new JPanel(new GridLayout(1, 2));

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("DJ Control");
		startMenuItem = new JMenuItem("Start");
		menu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});
		stopMenuItem = new JMenuItem("Stop");
		menu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
			}
		});
		JMenuItem exit = new JMenuItem("Quit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(exit);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		JPanel enterPanel = new JPanel(new GridLayout(1, 2));
		bpmTextField = new JTextField(2);
		JLabel bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
		bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		enterPanel.add(bpmLabel);
		enterPanel.add(bpmTextField);

		setBPMButton = new JButton("Set");
		setBPMButton.setSize(new Dimension(10, 40));
		setBPMButton.addActionListener(this);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		increaseBPMButton = new JButton(">>");
		decreaseBPMButton = new JButton("<<");
		increaseBPMButton.addActionListener(this);
		decreaseBPMButton.addActionListener(this);
		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

		JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
		insideControlPanel.add(enterPanel);
		insideControlPanel.add(setBPMButton);
		insideControlPanel.add(buttonPanel);
		controlPanel.add(insideControlPanel);

		// create a few components for the current BPM and the pulse (the view of the model)
		JPanel viewPanel = new JPanel(new GridLayout(1, 2));

		JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		beatBar = new BeatBar();
		beatBar.getProgressBar().setValue(0);
		bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		bpmPanel.add(beatBar.getProgressBar());
		bpmPanel.add(bpmOutputLabel);

		viewPanel.add(bpmPanel);

		// setup and display the frame
		frame.getRootPane().setDefaultButton(setBPMButton);
		frame.getContentPane().add(controlPanel, BorderLayout.CENTER);
		frame.getContentPane().add(viewPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// the updateBPM() method is called when a state change occurs in the model
	@Override
	public void updateBPM() {
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
					bpmOutputLabel.setText("offline");
				}
			} else {
				if (bpmOutputLabel != null) {
					bpmOutputLabel.setText("Current BPM: " + model.getBPM());
				}
			}
		}
	}

	// the updateBeat() method is called when the model starts a new beat
	@Override
	public void updateBeat() {
		if (beatBar != null) {
			beatBar.getProgressBar().setValue(100);
		}
	}

	public void enableStopMenuItem() {
		stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
		startMenuItem.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBPM(bpm);
		} else if (e.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (e.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
	}

}

class BeatBar implements Runnable {

	private JProgressBar progressBar;
	private Thread thread;

	public BeatBar() {
		progressBar = new JProgressBar();
		progressBar.setMaximum(100);
		thread = new Thread(this);
		thread.start();
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	@Override
	public void run() {
		for (;;) {
			int value = progressBar.getValue();
			value = (int) (value * .75);
			progressBar.setValue(value);
			progressBar.repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
			}
		}
	}

}
