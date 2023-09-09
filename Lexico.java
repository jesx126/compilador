import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexico {
    public static String exp = "-12.2cgf-2+32/45-3*2+3(78*23/6)-32.123;";
    public static int i = 0;
    public static int filas = exp.length() - 2;
    public static String[][] m = new String[filas][3]; 
    public static Map<String, String> operadores = new HashMap<>();
    public static Pattern patron = Pattern.compile("[a-z]");
    public static Pattern patron2 = Pattern.compile("[0-9]+");
    public static Pattern patron3 = Pattern.compile("[0-9]+[.][0-9]+");
    public static Matcher mat;
    public static Matcher mat2;
    public static Matcher mat3;
    public static void pros() {
        operadores.put("/", "División");
        operadores.put("-", "Resta");
        operadores.put("*", "Multiplicación");
        operadores.put("+", "Suma");
        operadores.put("(", "Parentesis de apertura");
        operadores.put(")", "Parentesis de cierre");
        operadores.put(";", "Fin");
        StringTokenizer toknum = new StringTokenizer(exp, "/-*+();abcdefgijklmnñopqrstuvwxyz", true);
        while (toknum.hasMoreElements()) {
            String str = toknum.nextToken();
            String stres = str.toLowerCase();
            m[i][2] = stres;
            mat = patron.matcher(stres);
            mat2 = patron2.matcher(stres);
            mat3 = patron3.matcher(stres);
            if (str.equals("+") || str.equals("/") || str.equals("-") || str.equals("*") || str.equals("(")
                    || str.equals(")")) {
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if (mat.matches()) {
                m[i][1] = "Var ";
                m[i][0] = ((Object) m[i][2]).getClass().getSimpleName() + " ";
            } else if (str.equals(";")) {
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if(mat2.matches()){
                //int n = Integer.parseInt(m[i][2]);
                m[i][1] = "Num ";
                m[i][0] = "Integer ";
            }else if(mat3.matches()){
                m[i][1] = "Num ";
                m[i][0] = "Decimal ";
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
