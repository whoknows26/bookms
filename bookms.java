import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class bookms {
    public static void main(String[] args) {
        // Call method which helps to generate the table
        generateJTable();
    }

    /**
     * This method helps to generate Table with buttons like Add, Update, Delete
     */
    public static void generateJTable() {
        // create JFrame and JTable
        JFrame frame = new JFrame();
        final JTable table = new JTable();
        // create a table model and set a Column Identifiers to this model
        Object[] columns = { "ISBN", "Book Name", " Author Name", "Publisher", "Price" };
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        // set the model to the table
        table.setModel(model);
        // table.setBackground(Color.CYAN.brighter());
        table.setForeground(Color.black);
        Font font = new Font("", 0, 18);
        table.setFont(font);
        table.setRowHeight(30);
        JLabel lb1 = new JLabel("ISBN:");
        JLabel lb2 = new JLabel("Book Name: ");
        JLabel lb3 = new JLabel("Author: ");
        JLabel lb4 = new JLabel("Publisher: ");
        JLabel lb5 = new JLabel("Price: ");
        // create JTextFields to hold the value
        final JTextField textId = new JTextField();
        final JTextField textBname = new JTextField();
        final JTextField textAname = new JTextField();
        final JTextField textPub = new JTextField();
        final JTextField textPrice = new JTextField();
        // create JButtons to add the action
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton bg = new JButton("Change color");
        textId.setBounds(220, 320, 100, 25);
        textBname.setBounds(220, 350, 100, 25);
        textAname.setBounds(220, 380, 100, 25);
        textPub.setBounds(220, 410, 100, 25);
        textPrice.setBounds(220, 440, 100, 25);
        lb1.setBounds(140, 320, 100, 20);
        lb2.setBounds(140, 350, 100, 20);
        lb3.setBounds(140, 380, 100, 20);
        lb4.setBounds(140, 410, 100, 20);
        lb5.setBounds(140, 440, 100, 20);
        btnAdd.setBounds(350, 320, 100, 25);
        btnUpdate.setBounds(350, 365, 100, 25);
        btnDelete.setBounds(350, 410, 100, 25);
        bg.setBounds(260, 480, 150, 25);
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 15, 880, 300);
        frame.setLayout(null);
        frame.add(pane);
        // add JTextFields to the jframe
        frame.add(textId);
        frame.add(textBname);
        frame.add(textAname);
        frame.add(textPub);
        frame.add(textPrice);
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(bg);
        // adding button to jframe
        frame.add(lb1);
        frame.add(lb2);
        frame.add(lb3);
        frame.add(lb4);
        frame.add(lb5);
        // create an array of objects to set the row data
        final Object[] row = new Object[5];
        // button add row - Clicked on Add Button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0] = textId.getText();
                row[1] = textBname.getText();
                row[2] = textAname.getText();
                row[3] = textPub.getText();
                row[4] = textPrice.getText();
                textId.setText("");
                textPub.setText("");
                textBname.setText("");
                textAname.setText("");
                textPrice.setText("");
                model.addRow(row);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if (i >= 0) {
                    // remove a row from jtable
                    model.removeRow(i);
                } else {
                    System.out.println("There were issue while Deleting the Row(s).");
                }
            }
        });
        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                textId.setText(model.getValueAt(i, 0).toString());
                textBname.setText(model.getValueAt(i, 1).toString());
                textAname.setText(model.getValueAt(i, 2).toString());
                textPub.setText(model.getValueAt(i, 3).toString());
                textPrice.setText(model.getValueAt(1, 4).toString());
            }
        });
        // button update row - Clicked on Update Button
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if (i >= 0) {
                    model.setValueAt(textId.getText(), i, 0);
                    model.setValueAt(textBname.getText(), i, 1);
                    model.setValueAt(textAname.getText(), i, 2);
                    model.setValueAt(textPub.getText(), i, 3);
                    model.setValueAt(textPrice.getText(), i, 4);
                } else {
                    System.out.println("Update Error");
                }
            }
        });
        bg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(table, "Choose", Color.CYAN);
                table.setBackground(c);
            }
        });
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Book Details");
    }
}
