import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.print("Please enter your weight(kg) and height(cm): "); 
        String text = buf.readLine(); 
        String[] data = text.split(" ");
        
        double res = getBMI(data);
        String dia = getDiagnosis(res);
        
        System.out.println(dia + " BMI: " + res);               
    }
    
    public static double getBMI(String[] data) {
        double weight = Double.parseDouble(data[0]);
        double heightCm = Double.parseDouble(data[1]);
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }
    
    public static String getDiagnosis(double bmi) {
        if (bmi >= 30) {
            return "You are not in shape. Actually, you are not even close.";
        } else if (bmi >= 26) {
            return "To be honest, you are not in shape.";
        } else if (bmi >= 20) {
            return "You are in shape.";
        } else {
            return "You are under shape.";
        }
    }
}

