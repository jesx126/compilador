import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.applet.Applet;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz extends JFrame implements ActionListener, ChangeListener {
    public JPanel p = new JPanel();
    public JPanel p2 = new JPanel();
    public JButton boton;
    public JTable tabla;
    public DefaultTableModel model;
    public static JTextField campo1;
    public static TextArea t1;
    public JCheckBox check;
    Color modooscuro = new Color(44, 44, 44);
    int namas = 0;

    public void initcomp() {
        boton = new JButton("Analizar");
        campo1 = new JTextField();
        campo1.setSize(20, 20);
        model = new DefaultTableModel();
        tabla = new JTable(model);
        model.addColumn("Tipo");
        model.addColumn("Nombre");
        model.addColumn("Dato");
        t1 = new TextArea("", 5, 10);
        check = new JCheckBox("Modo Oscuro");
        check.addChangeListener(this);
    }

    public interfaz() {
        initcomp();
        this.setVisible(true);
        boton.addActionListener(this);
        p = (JPanel) this.getContentPane();
        p.add(campo1, BorderLayout.NORTH);

        p.add(boton, BorderLayout.EAST);

        p.add(new JScrollPane(tabla), BorderLayout.CENTER);

        p2 = (JPanel) this.getContentPane();
        p2.add(t1, BorderLayout.SOUTH);
        t1.setEditable(false);
        t1.setForeground(Color.RED);

        p2.add(check, BorderLayout.BEFORE_LINE_BEGINS);
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

    @Override
    public void stateChanged(ChangeEvent e) {

        if (check.isSelected() == true) {
            campo1.setBackground(modooscuro);
            campo1.setForeground(Color.white);
            boton.setBackground(modooscuro);
            boton.setForeground(Color.white);
            tabla.setBackground(modooscuro);
            tabla.setForeground(Color.white);
            t1.setBackground(modooscuro);
            check.setBackground(modooscuro);
            check.setForeground(Color.white);
        } else if (check.isSelected() == false) {
            campo1.setBackground(Color.white);
            campo1.setForeground(Color.black);
            boton.setBackground(Color.white);
            boton.setForeground(Color.black);
            tabla.setBackground(Color.white);
            tabla.setForeground(Color.black);
            t1.setBackground(Color.white);
            check.setBackground(Color.white);
            check.setForeground(Color.black);
        }
    }

}