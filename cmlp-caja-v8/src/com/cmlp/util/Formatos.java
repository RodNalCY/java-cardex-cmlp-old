/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmlp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author EDWARD
 */
public class Formatos {
    public static SimpleDateFormat sdtfecha=new SimpleDateFormat("dd/MM/yyyy");
    //public static DecimalFormat dfreales= new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));
    
    public static java.sql.Date Fechasql(String fecha) throws ParseException
    {
        Date f = Formatos.sdtfecha.parse(fecha);
        GregorianCalendar gc= new GregorianCalendar();
        gc.setTimeInMillis(f.getTime());
        java.sql.Date f2 = new java.sql.Date(gc.getTimeInMillis());
        return f2;
    }
}
