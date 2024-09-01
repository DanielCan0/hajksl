/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecyo;
import java.io.Serializable;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

 

public class Proyecto extends javax.swing.JFrame {
   
    private static final String FILE_NAME = "Usuarios.dat"; 
    //el de arriba es donde se guardan los "usuarios" nuevos :3
    
    private static HashMap<String, User> users = new HashMap<>();
    private static String loggedInUser = null;

    
     
   public Proyecto() {
        initComponents();
        
        if (users.isEmpty()) {
            users.put("cano", new User("cano", "onac"));
           
        }
    }
        
   
      
    private void guardarUsuarios() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(users);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los usuarios: " + e.getMessage());
        }
    }
     private void cargarUsuarios() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (HashMap<String, User>) in.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Archivo de usuarios no encontrado. Creando uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los usuarios: " + e.getMessage());
        }
    }

     public static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        private String username;
        private String password;
        private int points;
        private Date registrationDate;
        private boolean isActive;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.points = 0;
            this.registrationDate = new Date();
            this.isActive = true;
    }
        
        
    public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean isActive) {
            this.isActive = isActive;
        }
    }
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("INICIO DE SESION");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 210, 50));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("REGISTRO");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 220, 60));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("SALIR");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 80, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecyo/imagenes/TWITTER.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleName("jLabel1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = JOptionPane.showInputDialog(this, "Ingrese su nombre de usuario:");
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre de usuario no puede estar vacío.");
            return;
        }

        String password = JOptionPane.showInputDialog(this, "Ingrese su contraseña:");
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contraseña no puede estar vacía.");
            return;
        }

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            loggedInUser = username;
            JOptionPane.showMessageDialog(this, "Bienvenido, " + username + "!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos.");
        }          
       }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String username = JOptionPane.showInputDialog(this, "Ingrese su nombre de usuario:");
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre de usuario no puede estar vacío.");
            return;
        }

        if (users.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe.");
            return;
        }

        String password = JOptionPane.showInputDialog(this, "Ingrese su contraseña");
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contraseña no puede estar vacía.");
            return;
        }

        User newUser = new User(username, password);
        users.put(username, newUser);
        guardarUsuarios(); 
        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
    public static void main(String args[]) {
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyecto().setVisible(true);
            }
        });
    }

    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
