import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Colors extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6602088768552478086L;
	private JPanel contentPane;
	private JTextField redField;
	private JTextField greenField;
	private JTextField blueField;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Colors frame = new Colors();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Colors() {
		setTitle("Colors");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);

		blueSlider = new JSlider();
		greenSlider = new JSlider();
		redSlider = new JSlider();
		redField = new JTextField();
		greenField = new JTextField();
		blueField = new JTextField();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colors = redField.getText() + "," + greenField.getText() + "," + blueField.getText();
				save(colors);
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		mnFile.add(mntmOpen);
		
		JMenu mnPresets = new JMenu("Presets");
		menuBar.add(mnPresets);
		
		JMenuItem mntmRed = new JMenuItem("Red");
		mntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(255);
				greenSlider.setValue(0);
				blueSlider.setValue(0);
			}
		});
		mnPresets.add(mntmRed);
		
		JMenuItem mntmOrange = new JMenuItem("Orange");
		mntmOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(0xFF);
				greenSlider.setValue(0xA0);
				blueSlider.setValue(0);
			}
		});
		mnPresets.add(mntmOrange);
		
		JMenuItem mntmYellow = new JMenuItem("Yellow");
		mntmYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(255);
				greenSlider.setValue(255);
				blueSlider.setValue(0);
			}
		});
		mnPresets.add(mntmYellow);
		
		JMenuItem mntmGreen = new JMenuItem("Green");
		mntmGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(0);
				greenSlider.setValue(255);
				blueSlider.setValue(0);
			}
		});
		mnPresets.add(mntmGreen);
		
		JMenuItem mntmBlue = new JMenuItem("Blue");
		mntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(0);
				greenSlider.setValue(0);
				blueSlider.setValue(255);
			}
		});
		mnPresets.add(mntmBlue);
		
		JMenuItem mntmCyan = new JMenuItem("Cyan");
		mntmCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(0);
				greenSlider.setValue(255);
				blueSlider.setValue(255);
			}
		});
		mnPresets.add(mntmCyan);
		
		JMenuItem mntmPurple = new JMenuItem("Purple");
		mntmPurple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(0xA0);
				greenSlider.setValue(0);
				blueSlider.setValue(0xA0);
			}
		});
		mnPresets.add(mntmPurple);
		
		JMenuItem mntmBlack = new JMenuItem("Black");
		mntmBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(0);
				greenSlider.setValue(0);
				blueSlider.setValue(0);
			}
		});
		mnPresets.add(mntmBlack);
		
		JMenuItem mntmWhite = new JMenuItem("White");
		mntmWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redSlider.setValue(255);
				greenSlider.setValue(255);
				blueSlider.setValue(255);
			}
		});
		mnPresets.add(mntmWhite);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(Color.WHITE);
		colorPanel.setBounds(52, 5, 290, 100);
		contentPane.add(colorPanel);

		
		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				redField.setText(Integer.toString(redSlider.getValue()));
				colorPanel
						.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
				colorPanel.repaint();
			}
		});
		
				redField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						redSlider.setValue(Integer.parseInt(redField.getText()));
						colorPanel
								.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
						colorPanel.repaint();
					}
				});
				redField.setHorizontalAlignment(SwingConstants.CENTER);
				redField.setText("255");
				redField.setBounds(317, 158, 40, 22);
				contentPane.add(redField);
				redField.setColumns(10);
		
				greenField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						greenSlider.setValue(Integer.parseInt(greenField.getText()));
						colorPanel
								.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
						colorPanel.repaint();
					}
				});
				greenField.setHorizontalAlignment(SwingConstants.CENTER);
				greenField.setText("255");
				greenField.setBounds(317, 214, 40, 22);
				contentPane.add(greenField);
				greenField.setColumns(10);
		
				blueField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						blueSlider.setValue(Integer.parseInt(blueField.getText()));
						colorPanel
								.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
						colorPanel.repaint();
					}
				});
				blueField.setHorizontalAlignment(SwingConstants.CENTER);
				blueField.setText("255");
				blueField.setBounds(317, 269, 40, 22);
				contentPane.add(blueField);
				blueField.setColumns(10);
		redSlider.setValue(255);
		redSlider.setMaximum(255);
		redSlider.setBounds(130, 158, 150, 25);
		contentPane.add(redSlider);

		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				greenField.setText(Integer.toString(greenSlider.getValue()));
				colorPanel
						.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
				colorPanel.repaint();
			}
		});
		greenSlider.setMaximum(255);
		greenSlider.setValue(255);
		greenSlider.setBounds(130, 214, 150, 25);
		contentPane.add(greenSlider);

		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				blueField.setText(Integer.toString(blueSlider.getValue()));
				colorPanel
						.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
				colorPanel.repaint();
			}
		});
		blueSlider.setMaximum(255);
		blueSlider.setValue(255);
		blueSlider.setBounds(130, 269, 150, 25);
		contentPane.add(blueSlider);

		JLabel lblRed = new JLabel("Red");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		lblRed.setBounds(37, 158, 56, 16);
		contentPane.add(lblRed);

		JLabel lblGreen = new JLabel("Green");
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreen.setBounds(37, 214, 56, 16);
		contentPane.add(lblGreen);

		JLabel lblBlue = new JLabel("Blue");
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlue.setBounds(37, 269, 56, 16);
		contentPane.add(lblBlue);
	}
	
	public void save(String c) {
		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(this);
		String path = new String(fc.getSelectedFile().getAbsolutePath()) + ".txt";
		FileIO.saveFile(c, path);
	}
	
	public void load() {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		String path = fc.getSelectedFile().getAbsolutePath();
		String[] s = FileIO.loadFile(path).split(",");
		redSlider.setValue(Integer.parseInt(s[0]));
		greenSlider.setValue(Integer.parseInt(s[1]));
		blueSlider.setValue(Integer.parseInt(s[2]));
	}
}
