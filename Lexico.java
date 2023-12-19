import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Lexico {
    public static String exp = " ";
    public static int i = 0;
    public static int filas = 100;
    public static String[][] m = new String[filas][3];
    public static Map<String, String> operadores = new HashMap<>();
    public static Pattern patron = Pattern.compile("[a-z]");
    public static Pattern patron2 = Pattern.compile("[0-9]+");
    public static Pattern patron3 = Pattern.compile("[0-9]+[.][0-9]+");
    public static Matcher mat;
    public static Matcher mat2;
    public static Matcher mat3;
    public static int parentesis = 0;

    public static void pros() {
        operadores.put("/", "División");
        operadores.put("-", "Resta");
        operadores.put("*", "Multiplicación");
        operadores.put("+", "Suma");
        operadores.put("(", "Parentesis de apertura");
        operadores.put(")", "Parentesis de cierre");
        operadores.put(";", "Fin");
        operadores.put("=", "Igual");
        StringTokenizer toknum = new StringTokenizer(exp,
                "/-*+()=;aAbBcCdDeEfFgGhHiIjJkKlLmMnNñÑoOpPqQrRsStTuUvVwWxXyYzZ", true);
        while (toknum.hasMoreElements()) {
            String str = toknum.nextToken();
            String stres = str.toLowerCase();
            m[i][2] = stres;
            mat = patron.matcher(stres);
            mat2 = patron2.matcher(stres);
            mat3 = patron3.matcher(stres);
            if (str.equals("+") || str.equals("/") || str.equals("-") || str.equals("*") || str.equals("(")
                    || str.equals(")") || str.equals("=")) {
                parentesis = metodos.parent(str);
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if (mat.matches()) {
                m[i][1] = "Var ";
                m[i][0] = ((Object) m[i][2]).getClass().getSimpleName() + " ";
            } else if (str.equals(";")) {
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if (mat2.matches()) {
                m[i][1] = "Num ";
                m[i][0] = "Integer ";
            } else if (mat3.matches()) {
                m[i][1] = "Num ";
                m[i][0] = "Decimal ";
            } else {
                m[i][1] = "Unknow ";
                m[i][0] = "Unknow ";
            }
            i++;
        }
        metodos.est_err(m);
    }

}

class metodos {
    // detección de paréntesis por conteo
    public static int parent(String str) {
        if (str.equals("(")) {
            Lexico.parentesis = Lexico.parentesis + 1;
        } else if (str.equals(")")) {
            Lexico.parentesis = Lexico.parentesis - 1;
        } else {
        }
        return Lexico.parentesis;
    }

    // detección de diviciónes por cero
    public static int div_0(String m[][]) {
        int flag = 0;
        for (int i = 0; i < m.length; i++) {
            if ("/".equals(m[i][2])) {
                if (i - 1 >= 0) {
                    if ("0".equals(m[i - 1][2]) || "0".equals(m[i + 1][2])) {
                        flag = 1;
                    }
                }
            } else {
            }
        }
        return flag;

    }

    // Detección de operadores consecutivos
    public static int op_c(String m[][]) {
        int flag = 0;
        for (int i = 0; i < m.length; i++) {
            if ("+".equals(m[i][2]) || "-".equals(m[i][2]) || "/".equals(m[i][2]) || "*".equals(m[i][2])) {
                if (i - 1 >= 0) {
                    if ("Num ".equals(m[i - 1][1]) && "Num ".equals(m[i + 1][1])
                            || ")".equals(m[i - 1][2]) && "(".equals(m[i + 1][2])
                            || ")".equals(m[i - 1][2]) && "Num ".equals(m[i + 1][1])
                            || "Num ".equals(m[i - 1][1]) && "(".equals(m[i + 1][2])) {
                    } else {
                        flag = 1;
                    }
                } else {
                    flag = 1;
                }
            }
        }
        return flag;
    }

    // mensajes de error
    public static void est_err(String m[][]) {
        int c_e=0;
        String texto="";
        if (Lexico.parentesis != 0) {
            if (Lexico.parentesis > 0) {
                JOptionPane.showMessageDialog(null, "Error: faltan paréntesis de cierre", "Error", 2);
                c_e++;
                texto=interfaz.t1.getText();
                interfaz.t1.setText(texto+"\n"+"Error: faltan paréntesis de cierre "+"E: "+c_e);
            } else if (Lexico.parentesis < 0) {
                JOptionPane.showMessageDialog(null, "Error: faltan paréntesis de apertura", "ERROR", 2);
                c_e++;
                texto=interfaz.t1.getText();
                interfaz.t1.setText(texto+"\n"+"Error: faltan paréntesis de apertura "+"E: "+c_e);
            }
        }
        Lexico.parentesis = 0;
        if ((div_0(m)) == 1) {
            JOptionPane.showMessageDialog(null, "Error: divición por cero", "Error", 2);
            c_e++;
            texto=interfaz.t1.getText();
            interfaz.t1.setText(texto+"\n"+"Error: Divición por cero "+"E: "+c_e);
        }
        if ((op_c(m)) == 1) {
            c_e++;
            JOptionPane.showMessageDialog(null, "Error: operadores sin operandos", "Error", 2);
            texto=interfaz.t1.getText();
            interfaz.t1.setText(texto+"\n"+"Error: operadores sin operandos "+"E: "+c_e);
        }
    }

}