public class main {
    public static void main(String[] args) {

        interfaz in = new interfaz();
        in.initcomp();

        // con el sig algoritmo puedes obtener info de la TS solo cambiando el número
        // de la matríz en el else con un rango de 0-2.
        // puedes copiarlo y pegarlo donde lo ocupes, lo dejé en el main para
        // demostración
        // Lexico.pros();
        for (int k = 0; k < Lexico.filas; k++) {
            if (Lexico.m[k][1] == null) {
                k = Lexico.filas - 1;
            } else {
                System.out.println(Lexico.m[k][2]);
            }
        }

    }
}