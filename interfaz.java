import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz extends JFrame {
    
    public JPanel p = new JPanel();
    // public JTextField textField;
    public JButton boton;
    public JTable tabla;
    public DefaultTableModel model;
    public static JTextField textField = new JTextField();
    int namas = 0;

    public void initcomp() {
        interfaz miAplicacion = new interfaz();
        miAplicacion.pack();
        miAplicacion.setVisible(true);
        miAplicacion.setBounds(0, 0, 500, 550);
        miAplicacion.setLocationRelativeTo(null);
        miAplicacion.setDefaultCloseOperation(miAplicacion.EXIT_ON_CLOSE);
        miAplicacion.getContentPane().add(p);
        textField.setPreferredSize(new Dimension(200, 20));
        boton = new JButton("Analizar");
        // Agrega los componentes al JPanel

        model = new DefaultTableModel();
        tabla = new JTable(model);
        model.addColumn("Tipo");
        model.addColumn("Nombre");
        model.addColumn("Dato");
        textField.setVisible(rootPaneCheckingEnabled);
        p.add(textField, BorderLayout.NORTH);
        p.add(boton, BorderLayout.EAST);
        p.add(new JScrollPane(tabla), BorderLayout.CENTER);
        p.setBackground(Color.black);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                namas++;
                // Aquí puedes realizar alguna acción con el texto del textField
                String texto = textField.getText();
                // Por ejemplo, puedes agregar el texto a la tabla
                // model.addRow(new Object[] { texto });
                Lexico.exp = texto;
                Lexico.filas = Lexico.exp.length() - 2;
                for (int i = 0; i < Lexico.m.length; i++) {
                    for (int j = 0; j < Lexico.m[i].length; j++) {
                        Lexico.m[i][j] = null;
                    }
                }
                if (namas > 1) {
                    model.setRowCount(0);
                }
                Lexico.pros();
                Lexico.i = 0;
                for (String[] row : Lexico.m) {
                    model.addRow(row);
                }
            }
        });
    }

}