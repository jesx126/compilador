import java.awt.Color;

import javax.swing.*;
public class interfaz extends JFrame{
    JPanel p= new JPanel();
    
   public void initcomp(){
   interfaz miAplicacion = new interfaz();
       miAplicacion.pack();
       miAplicacion.setVisible(true);
       miAplicacion.setSize(500, 500);
       miAplicacion.setLocationRelativeTo(null);
       miAplicacion.setDefaultCloseOperation(miAplicacion.EXIT_ON_CLOSE);
        miAplicacion.getContentPane().add(p);
        comp();
        }
        public void comp(){
            p.setBackground(Color.BLACK);
            
        }
        
    


}
