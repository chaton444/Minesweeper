
package clases;

import buscaminas.BuscaminasVisual;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class Celda extends JButton {
    private int x;
    private int y;
    private Color color[];
    private int tipoCelda;
    private boolean Visible;
    private boolean bandera=false;

    public boolean getVisible() {
        return Visible;
    }

    public void setVisible(boolean Visible) {
        this.Visible = Visible;
    }
    
  
    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
        this.Visible=false;
        this.bandera=false;
        this.tipoCelda = tipoCelda;
        this.color=new Color[]{Color.MAGENTA,Color.BLUE,new Color(0, 89, 19),Color.RED,new Color(0, 9, 135),Color.PINK,Color.YELLOW,Color.GRAY};
        this.setBackground(new java.awt.Color(0, 0, 0));
        this.setMinimumSize(new Dimension(30,9));
        this.setFont(new java.awt.Font("sans-serif ",Font.BOLD,14));
        this.setPreferredSize(new Dimension(100, 50));
        this. setMargin(new Insets(0, 0, 0, 0)); // Establecer el margen del botón
        this.setBorder(new LineBorder(new Color(163, 163, 163), 1)); 
 
        this.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent ev) {
        celdaMouseClicked(ev);
 
    }
        });
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              celdaActionPerformed(evt); 
        }
        });
       
}
    
    
    
    public void cambiarTipoCelda(int tipoCelda) {
    this.tipoCelda = tipoCelda;
}
     public void setTipoCelda(int tipoCelda) {
        this.tipoCelda = tipoCelda;
    }
         public int getTipoCelda() {
        return tipoCelda;
    }
         
         
         private void celdaMouseClicked(java.awt.event.MouseEvent ev){
             
         if (ev.getButton() == MouseEvent.BUTTON3) {

       System.out.println("bandera posición (" + x + ", " + y + ")");
       // toggle bandera
        this.bandera = !this.bandera; 
             System.out.println(this.bandera);
       if(BuscaminasVisual.gano==false){
                 if (this.bandera && this.Visible!=true) {
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banderam.png")));
        } else {
            this.setIcon(null);
        }
       }
     
    
}
         }
         
         
         
         
    private void celdaActionPerformed(java.awt.event.ActionEvent evt){
     maquinaDeEstados();
      
    if (todasLasCeldasNoMinaEstanVisibles()) {
      
        BuscaminasVisual.ganoOperdio(true,false);
        BuscaminasVisual.gano=true;
    }

    }
    
    
    
    public boolean todasLasCeldasNoMinaEstanVisibles() {
    for (int i = 0; i < BuscaminasVisual.Filas; i++) {
        for (int j = 0; j < BuscaminasVisual.Columnas; j++) {
            if (BuscaminasVisual.celda[i][j].getTipoCelda() != 0 && !BuscaminasVisual.celda[i][j].getVisible()) {
                return false;
            }
        }
    }
    return true;
}

    
    
public void maquinaDeEstados(){
    while(!Visible && BuscaminasVisual.gano==false && bandera==false){
        this.Visible=true;
            this.setOpaque(false);
             this.setContentAreaFilled(false);
        switch(tipoCelda){
            case 0:
                System.out.println("es de tipo  mina");
                for(int i=0;i<BuscaminasVisual.Filas;i++){
                  for(int j=0; j<BuscaminasVisual.Columnas;j++){
                      if(BuscaminasVisual.celda[i][j].tipoCelda==0){
                          String[] imagenes = {"buu.png", "kirbyc.png", "linkc.png", "luigic.png", "linkc.png", "marioc.png", "pikachuc.png", "y.png"};
                          Random rand = new Random();
                          int random = rand.nextInt(imagenes.length);
                          
            BuscaminasVisual.celda[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/"+ imagenes[random])));
            BuscaminasVisual.celda[i][j].setOpaque(false);
            BuscaminasVisual.celda[i][j].setContentAreaFilled(false);
           
                      
                      
                      }
                        

                  }
                
                }
                BuscaminasVisual.gano=true;
                 BuscaminasVisual.ganoOperdio(false,true);
                break;
            case 1:
                   System.out.println("es de tipo1");
    int cont = 0;
    this.setBackground(new java.awt.Color(240, 240, 240));
    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            int fila = x + i;
            int columna = y + j;
            if (fila >= 0 && fila < BuscaminasVisual.Filas && columna >= 0 && columna < BuscaminasVisual.Columnas 
                    && !(i == 0 && j == 0) && BuscaminasVisual.celda[fila][columna].getTipoCelda() == 0) {
                cont++;
            }
        }
    }
    this.setText(" " + cont);
    this.setForeground(this.color[cont]);
    this.setOpaque(false);
    this.setContentAreaFilled(false);
   

                break;
            case 2:
           for(int i=-2;i<=1;i++){
                    if(x+i>0 && x+i<BuscaminasVisual.Filas){
                        for(int j=-2;j<=1;j++){
                            System.out.println("");
                            if(y+j>=0 && y+j<BuscaminasVisual.Columnas && BuscaminasVisual.celda[x+i][y+j].getTipoCelda()!=0){
                                if(!BuscaminasVisual.celda[x+i][y+j].getVisible()){
                                }
                                     BuscaminasVisual.celda[x+i][y+j].maquinaDeEstados();
                            }
                      
                        }
                    }
                }
                break;
            case 3:
                System.out.println("es bandera");
                

                break;                
      
        }
    }
}




}