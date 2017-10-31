/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author santo
 */
public class Display extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    static Cliente cliente;
    static JTextField txt;

    public static void main(String[] args) {
        
        

        JFrame ventanaM = new JFrame();

        ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
//        ventanaM.setSize(500, 600);//configurando tamaño de la ventana
//        ventanaM.setVisible(true);//configurando visualización de la ventana 

        JTextArea peMsg = new JTextArea();
        peMsg.setBounds(10, 30, 350, 300);
        ventanaM.add(peMsg);
        
        //Instanciamos la variable cliente pasandole el panel y activamos el hilo
        cliente= new Cliente(peMsg);
        Thread hilo = new Thread(cliente);
        hilo.start();
        

        ventanaM.setSize(500, 500);
        ventanaM.setLayout(null);
        ventanaM.setVisible(true);

        JLabel label1 = new JLabel("Mensaje");
        label1.setBounds(10, 350, 260, 20);
        ventanaM.add(label1);

        JLabel label2 = new JLabel("Tu nombre");
        label2.setBounds(10, 400,260, 20);
        ventanaM.add(label2);

        JTextArea txtmsn = new JTextArea();
        txtmsn.setBounds(100, 350, 260, 20);
        ventanaM.add(txtmsn);

        JTextArea txtnom = new JTextArea();
        txtnom.setBounds(100, 400, 260, 20);
        ventanaM.add(txtnom);

        JButton boton1 = new JButton("Enviar");
        boton1.setBounds(370, 350, 100, 20);
        ventanaM.add(boton1);
        boton1.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Sacamos el nombre y el mensaje de las cajas de texto
                String nombre = txtnom.getText();
                if (nombre.trim().length() == 0) {
                    nombre = "Sin nombre";
                }
                String msg = txtmsn.getText();
                if (nombre.trim().length() == 0) {
                    return;
                }
                //Limpiamos el cuadro de texto del mensaje
                txtmsn.setText("");
                //Utilizamos la funcion del cliente para enviar el mensaje
                cliente.enviarMsg(nombre + ": " + msg + "\n");
                // TODO add your handling code here:
            }

        });

    }

}
