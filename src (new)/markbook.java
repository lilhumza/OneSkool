import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class markbook implements TableModelListener, ItemListener{

	private JFrame frame;
	JScrollPane SPMarkbook = new JScrollPane();
	JComboBox comboBox = new JComboBox();
	JLabel lblNewLabel_1 = new JLabel("Markbook");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					markbook markbookw = new markbook();
					markbookw.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public markbook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Tree.background"));
		frame.setBounds(100,100,1000,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel classXMarkbook = new JPanel();
		classXMarkbook.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(classXMarkbook, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 2148, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(classXMarkbook, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);

		GroupLayout gl_classXMarkbook = new GroupLayout(classXMarkbook);
		gl_classXMarkbook.setHorizontalGroup(
			gl_classXMarkbook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_classXMarkbook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_classXMarkbook.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
						.addComponent(SPMarkbook, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_classXMarkbook.setVerticalGroup(
			gl_classXMarkbook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_classXMarkbook.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(SPMarkbook, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		comboBox.setModel(new DefaultComboBoxModel(marksTable.calsses));
		SimpleTableDemo1(comboBox);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 791, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(37)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		marksTable.displayTable(SPMarkbook);
		classXMarkbook.setLayout(gl_classXMarkbook);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		marksTable.calculateMark(marksTable.marks);
		marksTable.createTable(marksTable.SPMarkbook, marksTable.marks, marksTable.assignments);
	    SimpleTableDemo(marksTable.table);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void SimpleTableDemo(JTable table) {
        table.getModel().addTableModelListener(this);
    }
	
	public void SimpleTableDemo1(JComboBox table) {
		comboBox.addItemListener(this);
    }

	public void tableChanged(TableModelEvent e) {
		 int row = e.getFirstRow();
	     int column = e.getColumn();
	     TableModel model = (TableModel)e.getSource();
	     String columnName = model.getColumnName(column);
	     Object data = model.getValueAt(row, column);

	     Arrays.deepToString(marksTable.marks);
	     marksTable.marks[row][column] = (String) data;
	     marksTable.calculateMark(marksTable.marks);
	     marksTable.createTable(marksTable.SPMarkbook, marksTable.marks, marksTable.assignments);
	     SimpleTableDemo(marksTable.table);
		
	}
	
	public void itemStateChanged(ItemEvent e) 
    { 
        if (e.getSource() == comboBox) { 
  
        	lblNewLabel_1.setText((String) comboBox.getSelectedItem()); 
        } 
    } 
}
