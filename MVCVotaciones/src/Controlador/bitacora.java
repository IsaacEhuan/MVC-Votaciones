package Controlador;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class bitacora {

    public static void agregarInfo1(String metodo){
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("MVCVotaciones\\bit1.txt", true)));
            out.println(timeStamp +"\t"+metodo);
            out.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
    public static void agregarInfo2(){
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("MVCVotaciones\\bit2.txt", true)));
            out.println(timeStamp);
            out.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
    public static void agregarInfo3(){
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("MVCVotaciones\\bit3.txt", true)));
            out.println(timeStamp);
            out.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

}
