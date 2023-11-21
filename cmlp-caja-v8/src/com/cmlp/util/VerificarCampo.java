package com.cmlp.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class VerificarCampo {
    
    public void validarSoloLetras(JTextField campo) {
        
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int arroba = (int)e.getKeyChar();
                if (Character.isDigit(c) || arroba==64) {
                    e.consume();
                    System.out.println("Campo Letra: "+c);
                }
            }
        });
        
    }
    
    public void validarSoloNumeros(JTextField campo) {
        
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    System.out.println("Campo numero: "+c);
                }
            }
        });
        
    }
    public void limitarCaracteres(JTextField campo, int cantidad) {
        
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam>=cantidad) {
                    e.consume();
                    System.out.println("Limitar Campo: "+c);
                }
            }
        });
        
    }
    
}
