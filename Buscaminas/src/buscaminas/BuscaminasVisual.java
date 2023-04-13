package buscaminas;

import clases.Celda;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class BuscaminasVisual extends javax.swing.JFrame {

 
   

     public static Celda celda[][];
     public static int Filas;
     public static int Columnas ;
     public static int Minas;
     public static boolean gano;
     public boolean prendida;
     public static boolean perdio;

    public BuscaminasVisual() {
        initComponents();
        jugar.setIcon(new ImageIcon(getClass().getResource("/img/2.png")));
        prendido.setIcon(new ImageIcon(getClass().getResource("/img/off.png")));
        prendida=false;
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apagado.png")));
        jugar.setVisible(false);
        off();
        
    }

   public static void ganoOperdio(boolean gano,boolean perdio){
    // Crear un nuevo JFrame
    JFrame mensajeFrame = new JFrame("Mensaje");
 // Crea un objeto ImageIcon con la ruta de la imagen
        ImageIcon imagen = new ImageIcon("/img/marioc.png");

        // Crea un objeto JLabel y asigna la imagen al label
        JLabel labelImagen = new JLabel(imagen);

        // Ajusta el tamaño del label a la imagen
        labelImagen.setSize(imagen.getIconWidth(), imagen.getIconHeight());

        // Crea un objeto JFrame y añade el label al frame
        

    // Crear una etiqueta para mostrar el mensaje
    JLabel mensajeLabel = new JLabel();
    mensajeLabel.setHorizontalAlignment(JLabel.CENTER);

    // Configurar el texto de la etiqueta según si el usuario ganó o perdió
    if (gano && perdio==false) {
        mensajeLabel.setText("Ganaste");
        

    } else {
        mensajeLabel.setText("Perdiste");

    }

    // Establecer el color de fondo y el borde de la etiqueta
    mensajeLabel.setBackground(Color.WHITE);
    mensajeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    // Personalizar la fuente y el tamaño de la etiqueta
    mensajeLabel.setFont(new Font("Arial", Font.BOLD, 24));

    // Agregar la etiqueta al JFrame
    mensajeFrame.add(mensajeLabel);

    // Agregar un botón "Cerrar" para cerrar la ventana
    JButton cerrarButton = new JButton("Cerrar");
    cerrarButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    
            mensajeFrame.dispose();
            
        }
    });
    mensajeFrame.add(cerrarButton, BorderLayout.SOUTH);

    // Establecer el tamaño mínimo del JFrame
    mensajeFrame.setMinimumSize(new Dimension(200, 100));

    // Configurar el JFrame
    mensajeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    mensajeFrame.setLocationRelativeTo(null);
    mensajeFrame.pack();
    mensajeFrame.setVisible(true);
   
         
   } 
   

   
public void cargar() {
    gano=false;
    Filas = (int) spFilas.getValue();
    Columnas = (int) spColumnas.getValue();
    Minas = (int) spMinas.getValue();
    this.celda = new Celda[Filas][Columnas];
    int nMinas[][]=numerosSinRepeticiones(Minas+1);

    for(int i=0;i<Filas;i++){
        for(int j=0;j<Columnas;j++){
            this.celda[i][j]=new Celda(i,j);
            // Inicializar todas las celdas con valor 2
            this.celda[i][j].setTipoCelda(2);
            panelMinas.add(this.celda[i][j]);
        }
    }
//aqui estoy agregando mis minas a mi tablero
    for(int i=0;i<Minas;i++){
        this.celda[nMinas[0][i]][nMinas[1][i]].setTipoCelda(0);
    }

    // Asignar valores 1 o 2 a las celdas vecinas a las minas
    for(int i=0;i<Filas;i++){
        for(int j=0;j<Columnas;j++){
            if (this.celda[i][j].getTipoCelda() == 0) {
                // La celda actual tiene una mina y buscar las celdas vecinas
                for(int x=i-1; x<=i+1; x++) {
                    for(int y=j-1; y<=j+1; y++) {
                        if (x>=0 && x<Filas && y>=0 && y<Columnas) {
                            // La celda vecina esta dentro del tablero
                            if (this.celda[x][y].getTipoCelda() != 0) {
                                // La celda vecina no es una mina
                                this.celda[x][y].setTipoCelda(1);
                            }
                        }
                    }
                }
            }
        }
    }
}
    
    public int[][] numerosSinRepeticiones(int cantidad){
    Random rd= new Random();
    int b[][]=new int[2][cantidad];
    int cont=0;
    boolean v;
    while(cont<cantidad){
        int numero1=(int)(rd.nextDouble()*Filas);
        int numero2=(int)(rd.nextDouble()*Columnas);
        v=false;
        for (int i = 0; i < cont; i++) {
            if (numero1==b[0][i]&&numero2==b[1][i]) {
            v=true;
        }  
        }
        if(!v){
            b[0][cont]=numero1;
            b[1][cont]=numero2;
            cont++;
        }
      
        
    
    }
    return b;
    }
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spFilas = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        spColumnas = new javax.swing.JSpinner();
        jugar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spMinas = new javax.swing.JSpinner();
        prendido = new javax.swing.JButton();
        panelMinas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 204, 204), null, new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(255, 255, 255), null, null));
        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Filas   ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        spFilas.setModel(new javax.swing.SpinnerNumberModel(10, 10, 20, 1));
        jPanel1.add(spFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("     Columnas    ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 90, 30));

        spColumnas.setModel(new javax.swing.SpinnerNumberModel(10, 10, 20, 1));
        jPanel1.add(spColumnas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jugar.setBackground(new java.awt.Color(0, 0, 0));
        jugar.setForeground(new java.awt.Color(255, 255, 255));
        jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jugarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jugarMouseReleased(evt);
            }
        });
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        jPanel1.add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 60, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("      Minas  ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, 22));

        spMinas.setModel(new javax.swing.SpinnerNumberModel(10, 10, 60, 1));
        jPanel1.add(spMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        prendido.setBackground(new java.awt.Color(0, 0, 0));
        prendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prendidoActionPerformed(evt);
            }
        });
        jPanel1.add(prendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 30, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 24, 720, 111));

        panelMinas.setBackground(new java.awt.Color(204, 204, 204));
        panelMinas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelMinas.setOpaque(false);
        panelMinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMinasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMinasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMinasMouseReleased(evt);
            }
        });
        panelMinas.setLayout(new java.awt.GridLayout(10, 10));
        jPanel2.add(panelMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 147, 720, 450));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 150, 720, 450));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f2.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 770, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed

        panelMinas.setLayout(new java.awt.GridLayout((int) spFilas.getValue(),(int) spColumnas.getValue()));
          for(int i=0;i<Filas;i++){
                 for(int j=0;j<Columnas;j++){
                  panelMinas.remove(celda[i][j]);
            }
          }
          panelMinas.updateUI();
         String[] imagenes = {"f4.png", "f2.png", "f3.png"};
                          Random rand = new Random();
                          int random = rand.nextInt(imagenes.length);
                          
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/"+ imagenes[random])));
        cargar();
    }//GEN-LAST:event_jugarActionPerformed

    private void jugarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugarMousePressed
        // TODO add your handling code here:
        jugar.setIcon(new ImageIcon(getClass().getResource("/img/1.png")));
    }//GEN-LAST:event_jugarMousePressed

    private void jugarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugarMouseReleased
        // TODO add your handling code here:
        jugar.setIcon(new ImageIcon(getClass().getResource("/img/2.png")));
    }//GEN-LAST:event_jugarMouseReleased

    private void panelMinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinasMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_panelMinasMouseClicked

    private void panelMinasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinasMousePressed
        // TODO add your handling code here:
        jugar.setIcon(new ImageIcon(getClass().getResource("/img/1.png")));
    }//GEN-LAST:event_panelMinasMousePressed

    private void panelMinasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinasMouseReleased
        // TODO add your handling code here:
         jugar.setIcon(new ImageIcon(getClass().getResource("/img/2.png")));
    }//GEN-LAST:event_panelMinasMouseReleased

    private void prendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prendidoActionPerformed
        // TODO add your handling code here:
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inicio.png")));
        prendida=!prendida;



        System.out.println(prendida);
        if(prendida){
       on();
   
        }else{
       off();
        
        }

        

        
    }//GEN-LAST:event_prendidoActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
         jugar.setIcon(new ImageIcon(getClass().getResource("/img/1.png")));
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // TODO add your handling code here:
        jugar.setIcon(new ImageIcon(getClass().getResource("/img/2.png")));
    }//GEN-LAST:event_jPanel1MouseReleased
 public void off(){
         panelMinas.removeAll();
         panelMinas.repaint();
         panelMinas.updateUI();
         jLabel4.setIcon(null);
         jugar.setVisible(false);
         spFilas.setVisible(false);
         spColumnas.setVisible(false);
         spMinas.setVisible(false);
         jLabel1.setVisible(false);
         jLabel2.setVisible(false);
         jLabel3.setVisible(false);
         prendido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/off.png")));
         jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apagado.png")));
 }
public void on(){
         spMinas.setVisible(true);
         spFilas.setVisible(true);
         spColumnas.setVisible(true);
         jLabel1.setVisible(true);
         jLabel2.setVisible(true);
         jLabel3.setVisible(true);
         jugar.setVisible(true);
        prendido.setIcon(new ImageIcon(getClass().getResource("/img/onc.png")));
     try {
     
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/sonido/gameboy.wav"));
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.start();
     
ImageIcon iconoGIF = new ImageIcon(getClass().getResource("/img/intro1.gif"));
Image imagen = iconoGIF.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_DEFAULT);
ImageIcon iconoRedimensionado = new ImageIcon(imagen);
jLabel4.setIcon(iconoRedimensionado);

Timer timer = new Timer(4000, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        jLabel4.setIcon(null); // Detener la animacion
        ((Timer)evt.getSource()).stop(); // Detener el timer
    }
});

timer.setRepeats(false); // Establecer el Timer para que no se repita
timer.start(); // Iniciar el Timer


} catch(Exception ex) {
    System.out.println("Error al reproducir el sonido.");
    ex.printStackTrace();
}
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaminasVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaminasVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaminasVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaminasVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaminasVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jugar;
    private javax.swing.JPanel panelMinas;
    private javax.swing.JButton prendido;
    private javax.swing.JSpinner spColumnas;
    private javax.swing.JSpinner spFilas;
    private javax.swing.JSpinner spMinas;
    // End of variables declaration//GEN-END:variables
}
