package com.cmlp.util;

import com.cmlp.vistas.PrincipalCMLPJF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

public class Horas implements ActionListener {

    public void tiempo() {

        //FECHA DEL SISTEMA
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        PrincipalCMLPJF.labelFecha.setText(formato.format(fecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Horas());
        tiempo.start();
        tiempo.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date sistHora = new Date();
        String pmAm = "hh:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pmAm);
        Calendar hoy = Calendar.getInstance();
        PrincipalCMLPJF.labelHora.setText(String.format(format.format(sistHora), hoy));

    }

}
