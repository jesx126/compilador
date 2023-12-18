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
    public static int parentesis=0;
    public static void pros() {
        operadores.put("/", "División");
        operadores.put("-", "Resta");
        operadores.put("*", "Multiplicación");
        operadores.put("+", "Suma");
        operadores.put("(", "Parentesis de apertura");
        operadores.put(")", "Parentesis de cierre");
        operadores.put(";", "Fin");
        operadores.put("=", "Igual");
        StringTokenizer toknum = new StringTokenizer(exp, "/-*+()=;aAbBcCdDeEfFgGhHiIjJkKlLmMnNñÑoOpPqQrRsStTuUvVwWxXyYzZ", true);
        while (toknum.hasMoreElements()) {
            String str = toknum.nextToken();
            String stres = str.toLowerCase();
            m[i][2] = stres;
            mat = patron.matcher(stres);
            mat2 = patron2.matcher(stres);
            mat3 = patron3.matcher(stres);
            if (str.equals("+") || str.equals("/") || str.equals("-") || str.equals("*") || str.equals("(")
                    || str.equals(")") || str.equals("=")) {
                parentesis=metodos.parent(str);
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if (mat.matches()) {
                m[i][1] = "Var ";
                m[i][0] = ((Object) m[i][2]).getClass().getSimpleName() + " ";
            } else if (str.equals(";")) {
                m[i][1] = operadores.get(m[i][2]) + " ";
                m[i][0] = "Operador ";
            } else if(mat2.matches()){
                m[i][1] = "Num ";
                m[i][0] = "Integer ";
            }else if(mat3.matches()){
                m[i][1] = "Num ";
                m[i][0] = "Decimal ";
            }else{
                m[i][1] = "Unknow ";
                m[i][0] = "Unknow ";
            }
            i++;
        }
        metodos.est_err();
    }



}


class metodos{
    //detección de paréntesis por conteo
public static int parent(String str){
     if(str.equals("(")){Lexico.parentesis=Lexico.parentesis+1;}else if(str.equals(")")){Lexico.parentesis=Lexico.parentesis-1;}else{}
    return Lexico.parentesis;
}

//mensajes de error
public static void est_err(){
if(Lexico.parentesis!=0){   
        if(Lexico.parentesis>0){
            JOptionPane.showMessageDialog(null, "Error: faltan paréntesis de cierre", "Error",1);
        }else if(Lexico.parentesis<0){
            JOptionPane.showMessageDialog(null, "Error: faltan paréntesis de apertura", "ERROR", 1);
        }
    }
        Lexico.parentesis=0;
}

}