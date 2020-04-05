/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application.chat;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class chat_server extends javax.swing.JFrame {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream dis;
    static DataOutputStream dos;

    public chat_server() {
        initComponents();
    }
     public chat_server(int port) {
        try {
            String msg = "";
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            dis = new DataInputStream(socket.getInputStream());// takes input from the client socket
            dos = new DataOutputStream(socket.getOutputStream());//
            // reads message from client until "bye" is sent 
            while (!msg.equals("bye")) {
                try{
                msg = dis.readUTF();
                server_Area.setText(server_Area.getText() + "\n client : " + msg);
                }
                catch (Exception e) {
            System.out.println("there is error ");
        }
            }
            System.out.println("Closing connection"); 
  try
        { 
           // close connection
            server_Area.setText(server_Area.getText() +"\nclose The connection");
            server_send.setVisible(false);
            dis.close(); 
            dos.close(); 
            socket.close();
            serverSocket.close();
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        } 
           
        
      catch (IOException ex) {
            Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
      }     
        }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        server_send = new javax.swing.JButton();
        server_text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        server_Area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        server_send.setText("Send");
        server_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_sendActionPerformed(evt);
            }
        });

        server_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_textActionPerformed(evt);
            }
        });

        server_Area.setColumns(20);
        server_Area.setRows(5);
        jScrollPane1.setViewportView(server_Area);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel1.setText("Server");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(server_text, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(server_send, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(server_send)
                    .addComponent(server_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void server_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_server_textActionPerformed

    private void server_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_sendActionPerformed

        try {
            String msg1 = "";
            msg1 = server_text.getText();
            dos.writeUTF(msg1);
            server_text.setText("");
            if(msg1.equals("bye")){
                server_Area.setText(server_Area.getText() +"\nclose The connection");
                server_send.setVisible(false);
                
            }

        } catch (IOException ex) {
            Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_server_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_server().setVisible(true);

            }
        });
        chat_server server=new chat_server(6666);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea server_Area;
    private static javax.swing.JButton server_send;
    private static javax.swing.JTextField server_text;
    // End of variables declaration//GEN-END:variables
}
