package helper;

import java.sql.Time;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {

    static SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
    static NumberFormat nf = new DecimalFormat("R$ #,##0.00",
            new DecimalFormatSymbols(new Locale("pt-br")));

    public static String dateParaString(Date data){
        return Utils.sdf.format(data);
    }

    public static String dateParaString(Double valor){
        return Utils.nf.format(valor);
    }

    public static String doubleParaString(Double valor){
        return Utils.nf.format(valor);
    }

    public static Double stringParaDouble(String valor){
        try {
            return (Double)Utils.nf.parse(valor);
        }catch (ParseException e){
            return null;
        }
    }

    public static void pausar(int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        }catch (InterruptedException e){
        System.out.println("erro ao pausar por " + segundos + "segundos");
        }
    }




}
