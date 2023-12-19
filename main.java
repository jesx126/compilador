public class main {
    public static void main(String[] args) {
        interfaz miAplicacion= new interfaz();
        miAplicacion.pack();
        miAplicacion.setVisible(true);
        miAplicacion.setBounds(0, 0, 750, 700);
        miAplicacion.setLocationRelativeTo(null);
        miAplicacion.setDefaultCloseOperation(miAplicacion.EXIT_ON_CLOSE);
    }
}