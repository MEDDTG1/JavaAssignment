package passignment;

import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Locale;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

/**
 * The Cars GUI program implements an application that
 * adds data into a table aswell as creating a tab to look
 * at specific data and a graph tab that puts one of the data
 * fields into a pie chart.
 * 
 * @author Taylor
 *
 */
public class CarsGUI extends JFrame {
	
	private static ArrayList<Cars>cars;

	private JList type;
	private JPanel contentPane;
	private JTable table;
	private JFormattedTextField NameT;
	private JFormattedTextField OriginT;
	private JFormattedTextField PriceT;
	private JFormattedTextField TypeT;
	private JFormattedTextField DriveTrainT;
	private JFormattedTextField TransmissionT;
	private JFormattedTextField WeightT;
	private int listN = 0;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CarName", "Origin", "Price", "Type", "DriveTrain", "Transmission", "Weight-KG"
			}
		);
	
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarsGUI frame = new CarsGUI(cars);
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
	public CarsGUI(ArrayList<Cars>cars) {
		this.cars = cars;
		setTitle("AutoMobiles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBounds(20, 117, 838, 426);
		contentPane.add(tabbedPane);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("Subaru.png"));
		getContentPane().add(lblNewLabel);
		lblNewLabel.setBounds(522, 11, 316, 111);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Table", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cars", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Car Name");
		lblNewLabel_1.setBounds(22, 83, 56, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Origin");
		lblNewLabel_2.setBounds(22, 168, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(22, 256, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setBounds(287, 83, 83, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DriveTrain");
		lblNewLabel_5.setBounds(287, 168, 83, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Transmission");
		lblNewLabel_6.setBounds(287, 256, 83, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Weight-KG");
		lblNewLabel_7.setBounds(560, 83, 64, 14);
		panel_1.add(lblNewLabel_7);
		
		NameT = new JFormattedTextField();
		NameT.setEditable(false);
		NameT.setBounds(88, 64, 170, 52);
		panel_1.add(NameT);
		
		OriginT = new JFormattedTextField();
		OriginT.setEditable(false);
		OriginT.setBounds(88, 144, 170, 52);
		panel_1.add(OriginT);
		
		PriceT = new JFormattedTextField();
		PriceT.setEditable(false);
		PriceT.setBounds(88, 232, 170, 52);
		panel_1.add(PriceT);
		
		TypeT = new JFormattedTextField();
		TypeT.setEditable(false);
		TypeT.setBounds(380, 64, 170, 52);
		panel_1.add(TypeT);
		
		DriveTrainT = new JFormattedTextField();
		DriveTrainT.setEditable(false);
		DriveTrainT.setBounds(380, 144, 170, 52);
		panel_1.add(DriveTrainT);
		
		TransmissionT = new JFormattedTextField();
		TransmissionT.setEditable(false);
		TransmissionT.setBounds(380, 232, 170, 52);
		panel_1.add(TransmissionT);
		
		WeightT = new JFormattedTextField();
		WeightT.setEditable(false);
		WeightT.setBounds(634, 64, 178, 52);
		panel_1.add(WeightT);
		
		JButton backB = new JButton("Back");
		backB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listN--;
				fillFields(listN);
			}
		});
		backB.setBounds(305, 331, 89, 23);
		panel_1.add(backB);
		
		JButton nextB = new JButton("Next");
		nextB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listN++;
				fillFields(listN);
			}
		});
		nextB.setBounds(419, 331, 89, 23);
		panel_1.add(nextB);
		
		JButton btnNewButton_1 = new JButton("Last");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listN = 92;
				fillFields(listN);
			}
		});
		btnNewButton_1.setBounds(536, 331, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("First");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listN = 0;
				fillFields(listN);
			}
		});
		btnNewButton_2.setBounds(188, 331, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 127, 766, 260);
		scrollPane.setEnabled(false);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		type = new JList();
		type.setBounds(36, 11, 161, 108);
		panel.add(type);
		type.setModel(new AbstractListModel() {
			String[] values = new String[] {"Small", "Midsize", "Compact", "Large", "Van", "Sporty"};
			public int getSize() {
				return values.length;
		}
		public String getElementAt(int index) {
			return values[index];
		}
		});
		
		type.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					typeMouseClicked();
				}
			}
		});
		
		JButton btnNewButton = new JButton("Reset Table");
		btnNewButton.setBounds(665, 45, 137, 35);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				drawTable();
			}
		});
		
		drawTable();
		createCarsGraph();
		fillFields(listN);
	}
	
	/**
	 * This method draws the table with all data entered normally
	 */
	public void drawTable() {
		tm.setRowCount(0);
		for (int i = 0; i < 93; i++) {
			Object[] object = new Object[7];
			object[0]= cars.get(i).getcarName();
			object[1]= cars.get(i).getorigin();
			object[2]= cars.get(i).getprice();
			object[3]= cars.get(i).gettype();
			object[4]= cars.get(i).getdriveTrain();
			object[5]= cars.get(i).gettransmission();
			object[6]= cars.get(i).getweight();
			tm.addRow(object);
		}
		table.setAutoCreateRowSorter(true);
	}
	
	/**
	 * This method is used when filtering data for data contained in the car type field
	 */
	public void typeMouseClicked() {
		tm.setRowCount(0);
		
		for(int i = 0; i < 93; i++) {
			Object[] object2 = new Object[7];
			object2[0]= cars.get(i).getcarName();
			object2[1]= cars.get(i).getorigin();
			object2[2]= cars.get(i).getprice();
			object2[3]= cars.get(i).gettype();
			object2[4]= cars.get(i).getdriveTrain();
			object2[5]= cars.get(i).gettransmission();
			object2[6]= cars.get(i).getweight();
			
			if(object2[3].equals(type.getSelectedValue())) {
				tm.addRow(object2);
			}
			table.setAutoCreateRowSorter(true);
		}
	}
	
	/**
	 * This method is used for entering data in the cars tab textfields
	 * @param listN
	 */
	public void fillFields(int listN) {
		if(listN > (0-1) && listN < cars.size()) {
			NameT.setText(cars.get(listN).getcarName());
			OriginT.setText(cars.get(listN).getorigin());
			PriceT.setText(cars.get(listN).getprice());
			TypeT.setText(cars.get(listN).gettype());
			DriveTrainT.setText(cars.get(listN).getdriveTrain());
			TransmissionT.setText(cars.get(listN).gettransmission());
			WeightT.setText(cars.get(listN).getweight());
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Invalid", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * This method creates the graph in the graph tab
	 */
	public void createCarsGraph() {
		DefaultPieDataset data = new DefaultPieDataset();
		for(int i = 0; i < 93; i++) {
			data.setValue(cars.get(i).gettype(), i);
		}
		
		JFreeChart chart = ChartFactory.createPieChart("Car Type", data, true, true, Locale.ENGLISH);
		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);
		
		tabbedPane.add("Graph", mypanel);
		
	}
}
