import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PingCheckerWindow {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea txtrGiveThisAbout;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PingCheckerWindow window = new PingCheckerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PingCheckerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("OSRS Ping Checker");
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton pingCheckButton = new JButton("Check Ping");
		springLayout.putConstraint(SpringLayout.WEST, pingCheckButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pingCheckButton, -10, SpringLayout.SOUTH, frame.getContentPane());
		pingCheckButton.setToolTipText("Start Test");
		pingCheckButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 29));
		pingCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> worldz = new ArrayList();
				for(int i = 1; i<63 ; i++){
					worldz.add(i);
				}
				for(int i = 65; i<71 ; i++){
					worldz.add(i);
				}
				for(int i = 73; i<79 ; i++){
					worldz.add(i);
				}
				for(int i = 81; i<95 ; i++){
					worldz.add(i);
				}

				for(int i = 0; i<worldz.size(); i++){
					int world = worldz.get(i) + 300;
					txtrGiveThisAbout.append("World " + world);
					txtrGiveThisAbout.append("\n");
					String command = "ping oldschool" + worldz.get(i) + ".runescape.com";
					try {
						Process process  = Runtime.getRuntime().exec(command);
						Scanner out = new Scanner(process.getInputStream());
						System.out.println("==World " + world + "==");
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						out.next();
						String ping = (out.next());
						System.out.println(ping);
						txtrGiveThisAbout.append(ping);
						txtrGiveThisAbout.append("\n");
						txtrGiveThisAbout.append("\n");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		frame.getContentPane().add(pingCheckButton);
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 228, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pingCheckButton, -6, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, pingCheckButton, 0, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, frame.getContentPane());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		
		txtrGiveThisAbout = new JTextArea();
		txtrGiveThisAbout.setText("Click button\r\nthen wait a\r\ncouple seconds.\r\n(takes a bit)\r\n\r\n\r\n\r\n");
		scrollPane.setViewportView(txtrGiveThisAbout);
		
	}
}
