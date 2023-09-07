import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Lexico {
    public static String exp = "z-12-2*-x+32/45-3*2+3(78*23/6);";
    public static int i = 0;
    public static int filas = exp.length() - 2;
    public static String[][] m = new String[filas][3]; 
    public static Map<String, String> operadores = new HashMap<>();
    public static void pros() {
        operadores.put("/", "División");
        operadores.put("-", "Resta");
        operadores.put("*", "Multiplicación");
        operadores.put("+", "Suma");
        operadores.put("(", "Parentesis de apertura");
        operadores.put(")", "Parentesis de cierre");
        operadores.put(";", "Fin");
        StringTokenizer toknum = new StringTokenizer(exp, "/-*+()", true);
        while (toknum.hasMoreElements()) {
            String str = toknum.nextToken();
            m[i][2] = str;
            if (str.equals("+") || str.equals("/") || str.equals("-") || str.equals("*") || str.equals("(")
                    || str.equals(")")) {
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if (str.equals("x") || str.equals("y") || str.equals("z")) {
                m[i][1] = "Var ";
                m[i][0] = ((Object) m[i][2]).getClass().getSimpleName() + " ";
            } else if (str.equals(";")) {
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else {
                int n = Integer.parseInt(m[i][2]);
                m[i][1] = "Num ";
                m[i][0] = ((Object) n).getClass().getSimpleName() + " ";
            }
            i++;
        }
        System.out.println("\nExpresión: " + exp + "\n");
        for (int j = 0; j < filas; j++) {

            for (int k = 0; k < 3; k++) {
                if (m[j][k] == null) {
                    j = filas - 1;
                } else {
                    System.out.print(m[j][k]);
                }
            }
            System.out.print(" \n");
        }
        
    }
}
