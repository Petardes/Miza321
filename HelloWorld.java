import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Main.java
 * 
 * Opis:
 * Program za testiranje delovanja razredov Stroj, Bager in VarilniStroj
 *
 * @version Vaja 35 (Gui Vmesnik)
 * @avtor Matej Germovnik
 */
 
/**
 * Javni razred za prikaz delovanja jave
 */  
 
public class HelloWorld {

    private static DefaultTableModel model;

    public static void main(String[] args) {
		
        // Ustvarimo novo okno
		
        JFrame frame = new JFrame("Testiranje Strojev");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Nastavimo glavni panel
		
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Ustvarimo tabelo in model
		
        model = new DefaultTableModel(new Object[]{"Tip Stroja", "Moč (kW)", "Posebnost"}, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Vnosni panel
		
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JTextField tipField = new JTextField();
        JTextField mocField = new JTextField();
        JTextField posebnostField = new JTextField();
        
        inputPanel.add(new JLabel("Tip Stroja:"));
        inputPanel.add(tipField);
        inputPanel.add(new JLabel("Moč (kW):"));
        inputPanel.add(mocField);
        inputPanel.add(new JLabel("Posebnost:"));
        inputPanel.add(posebnostField);
        
        JButton addButton = new JButton("Dodaj Stroj");
        inputPanel.add(addButton);
        
        panel.add(inputPanel, BorderLayout.NORTH);

        // Dodamo poslušalca za gumb
		
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tip = tipField.getText();
                String mocStr = mocField.getText();
                String posebnost = posebnostField.getText();

                try {
                    int moc = Integer.parseInt(mocStr);
                    
                    // Dodamo vrstico v tabelo
					
                    model.addRow(new Object[]{tip, moc, posebnost});
                    
                    // Po potrebi lahko tukaj ustvarimo konkretne objekte in jih shranimo
                    // Bager bager = new Bager(moc, Integer.parseInt(posebnost));
                    // VarilniStroj varilniStroj = new VarilniStroj(moc, Integer.parseInt(posebnost));
                    
                    // Očistimo vnosna polja
                    tipField.setText("");
                    mocField.setText("");
                    posebnostField.setText("");
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Vnesite veljavne številke za moč in posebnost.", "Napaka", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Dodamo panel na okno in prikažemo
        frame.add(panel);
        frame.setVisible(true);
    }
}