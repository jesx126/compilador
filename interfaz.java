import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz extends JFrame implements ActionListener{
    public JPanel p = new JPanel();
    public JButton boton;
    public JTable tabla;
    public DefaultTableModel model;
    public static JTextField campo1;
    int namas = 0;
    public void initcomp() {
        boton = new JButton("Analizar");
        campo1 = new JTextField();
        campo1.setSize(20,20);
        model = new DefaultTableModel();
        tabla = new JTable(model);
        model.addColumn("Tipo");
        model.addColumn("Nombre");
        model.addColumn("Dato");
    }
    public interfaz(){
        initcomp();
        this.setVisible(true);
        boton.addActionListener(this);
        p = (JPanel) this.getContentPane();
        p.add(campo1, BorderLayout.NORTH);
        p.add(boton, BorderLayout.EAST);
        p.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        namas++;
                // Aquí puedes realizar alguna acción con el texto del textField
                String texto = campo1.getText();
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

}