/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
 

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane; //

/**
 *
 * @author Jade
 */
public class ProductsFrm extends javax.swing.JFrame {
    private String op;//
    private double totalCompra = 0.0;
    private Object[][] carrito = new Object[5][3];
    String cajero;
    String numeroCaja;
    private double cantidad;
    private int cant;
    double costoTotal;//
    
    String option;

    //FROM SUPERMERCADO
    public boolean validateCashierName(String cashier) {
        boolean validCajero = false;
        while (!validCajero) {
            if (cashier != null && cashier.matches("^[a-zA-Z ]+$")) {
                validCajero = true;
            } else {
                JOptionPane.showMessageDialog(null, "Nombre completo no válido. Debe contener solo letras y espacios.");
                // You might want to prompt for the cashier name again or handle it according to your requirements
                cashier = JOptionPane.showInputDialog("Por favor, ingrese su nombre completo:");
            }
        }
        return validCajero;
    }

    public void menu(){
        do {
            //procesarOpcion(option);
        }while (!option.equals("6"));
        
        double impuesto = calcularImpuesto(totalCompra);
    }

    public void procesarOpcion(String option) {
        int eleccion;
        try {
            eleccion = Integer.parseInt(option);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opción no válida. Ingrese un número válido.");
            return;
        }

        switch (eleccion) {
           case 1:
                comprarArticulo(new Papa());
                break;
            case 2:
                comprarArticulo(new Arroz());
                break;
            case 3:
                comprarArticulo(new Jitomate());
                break;
            case 4:
                comprarArticulo(new Huevo());
                break;
            case 5:
                comprarArticulo(new Frijol());
                break;
            case 6:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
    }
    public void comprarArticulo(Articulo articulo) {
        //String cantidadStr = JOptionPane.showInputDialog("¿Cuánto deseas comprar de " + articulo + " (en kg)?");
        try {
            cantidad = cant;
            costoTotal = articulo.calcularCosto(cantidad);
            totalCompra += costoTotal;
            guardarEnCarrito(articulo, cantidad, costoTotal);
            JOptionPane.showMessageDialog(null, "Has seleccionado comprar " + cantidad + " kg de " + articulo.nombre + ". El costo total es $" + costoTotal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida. Ingrese un número válido.");
        }
    }
    
        public double calcularImpuesto(double totalCompra) {
        double impuesto = totalCompra * 0.10;
        return impuesto;
    }
    
        public void guardarEnCarrito(Articulo articulo, double cantidad, double costoTotal) {
        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i][0] == null) {
                carrito[i][0] = articulo;
                carrito[i][1] = cantidad;
                carrito[i][2] = costoTotal;
                
                break;
            }
        }
    }
    
        public void mostrarCarrito() {
        JOptionPane.showMessageDialog(null, "Artículos en el carrito:");
        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i][0] != null) {
                Articulo articulo = (Articulo) carrito[i][0];
                JOptionPane.showMessageDialog(null, articulo.nombre);
            }
        }
    }
    
    private void imprimirTicket() {
        StringBuilder ticketContent = new StringBuilder();

    // Nombre Supermercado
    ticketContent.append("Supermercado Tiendita de Mau, David y Nat\n\n");

    // Cajero
     String[] nameParts = cajero.split(" ");    
    if (nameParts.length >= 2) {
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            ticketContent.append("Cajero: ").append(lastName).append(", ").append(firstName.charAt(0)).append(".\n");
    // Caja
    ticketContent.append("Número de Caja: ").append(numeroCaja).append("\n");

    // RFC
    ticketContent.append("RFC: RFCXXXXX\n");
 
   // Dirección
   
    //ticketContent.append("Dirección: Calle 123, Colonia, Mex\n\n");
    String direccion = String.format("Dirección: %s, %s, %s%n%n", "Calle 123", "Colonia", "Mex");
    ticketContent.append(direccion);

    ticketContent.append("------------------------------------------------------------------------------------------------\n\n");


    // Articulos y costo
    ticketContent.append("Artículos en el carrito:\n");
        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i][0] != null) {
                Articulo articulo = (Articulo) carrito[i][0];
                double cantidad = (double) carrito[i][1];
                double costoTotal = (double) carrito[i][2];
                String nombreArticulo = articulo.nombre.toUpperCase(); // uppercase
            ticketContent.append(nombreArticulo).append(" ($").append(articulo.precioPorKg).append("/kg)\n");
            ticketContent.append("Cantidad: ").append(cantidad).append(  "--- Total: $ ").append(costoTotal).append("kg)\n");
            //CANTIDAD
            //TOTAL POR PRODUCTO
            
        }
    }
        
    ticketContent.append("------------------------------------------------------------------------------------------------\n\n");
    ticketContent.append("\nCosto total de la compra: $").append(totalCompra).append("\n");

    // Impuesto
    double impuesto = calcularImpuesto(totalCompra);
    ticketContent.append("Impuesto aplicado: $").append(impuesto).append("\n");
 
    String formattedReceipt = String.format(
        "================== Ticket de Compra ==================\n%s\n======================================================",
        ticketContent.toString()
    );

    JOptionPane.showMessageDialog(null, formattedReceipt, "Ticket de Compra", JOptionPane.PLAIN_MESSAGE);
        
    }
}


    ////////////////////////////////////////////////

    /**
     * Creates new form ProductsFrm
     */
    public ProductsFrm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelHOME = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelProd = new javax.swing.JPanel();
        lblArroz = new javax.swing.JLabel();
        lblHuevo = new javax.swing.JLabel();
        lblFrijol = new javax.swing.JLabel();
        lblJitomate = new javax.swing.JLabel();
        lblPapa = new javax.swing.JLabel();
        panelCarrito = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblAgregarAlCarrito = new javax.swing.JLabel();
        spinKG = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        bttAddProd = new javax.swing.JButton();
        bttMostrarArticulos = new javax.swing.JButton();
        bttPrintTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setName("HOME"); // NOI18N

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout panelHOMELayout = new javax.swing.GroupLayout(panelHOME);
        panelHOME.setLayout(panelHOMELayout);
        panelHOMELayout.setHorizontalGroup(
            panelHOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHOMELayout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(242, 242, 242))
        );
        panelHOMELayout.setVerticalGroup(
            panelHOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHOMELayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("HOME", panelHOME);

        lblArroz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArroz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arroz.png"))); // NOI18N
        lblArroz.setText("ARROZ");
        lblArroz.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblArroz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblArroz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblArroz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblArrozMouseClicked(evt);
            }
        });

        lblHuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/huevo.png"))); // NOI18N
        lblHuevo.setText("HUEVO");
        lblHuevo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblHuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblHuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHuevoMouseClicked(evt);
            }
        });

        lblFrijol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frijol.png"))); // NOI18N
        lblFrijol.setText("FRIJOL");
        lblFrijol.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblFrijol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFrijol.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblFrijol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFrijolMouseClicked(evt);
            }
        });

        lblJitomate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/jitomate.png"))); // NOI18N
        lblJitomate.setText("JITOMATE");
        lblJitomate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJitomate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblJitomate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJitomateMouseClicked(evt);
            }
        });

        lblPapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/papa.png"))); // NOI18N
        lblPapa.setText("PAPA");
        lblPapa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPapa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblPapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPapaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelProdLayout = new javax.swing.GroupLayout(panelProd);
        panelProd.setLayout(panelProdLayout);
        panelProdLayout.setHorizontalGroup(
            panelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdLayout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addComponent(lblPapa)
                .addGap(40, 40, 40)
                .addComponent(lblArroz)
                .addGap(51, 51, 51)
                .addComponent(lblJitomate)
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHuevo)
                .addGap(45, 45, 45)
                .addComponent(lblFrijol)
                .addGap(161, 161, 161))
        );
        panelProdLayout.setVerticalGroup(
            panelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPapa)
                    .addComponent(lblArroz)
                    .addComponent(lblJitomate))
                .addGap(18, 18, 18)
                .addGroup(panelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHuevo)
                    .addComponent(lblFrijol))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        lblHuevo.getAccessibleContext().setAccessibleName("lblEgg");
        lblFrijol.getAccessibleContext().setAccessibleName("lblBeans");
        lblJitomate.getAccessibleContext().setAccessibleName("lblTomato");
        lblPapa.getAccessibleContext().setAccessibleName("lblPotato");

        jTabbedPane2.addTab("PRODUCTOS", panelProd);

        panelCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCarritoMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        jLabel3.setText("Artículos en Carrito");
        
        bttAddProd.setText("Agregar");
                bttAddProd.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bttAddProdActionPerformed(evt);
            }
        });
        
        bttMostrarArticulos.setText("Mostrar Carrito");
            bttMostrarArticulos.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bttMostrarArticulosActionPerformed(evt);
            }
        });
        
        bttPrintTicket.setText("Imprimir Ticket");
                bttPrintTicket.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bttPrintTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(344, Short.MAX_VALUE))
                .addComponent(bttMostrarArticulos)//btt
                //////
                .addComponent(bttPrintTicket)//btt
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addComponent(bttMostrarArticulos)//btt
                .addContainerGap(129, Short.MAX_VALUE))
                .addComponent(bttPrintTicket)//btt
        );

        javax.swing.GroupLayout panelCarritoLayout = new javax.swing.GroupLayout(panelCarrito);
        panelCarrito.setLayout(panelCarritoLayout);
        panelCarritoLayout.setHorizontalGroup(
            panelCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarritoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCarritoLayout.setVerticalGroup(
            panelCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarritoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("CARRITO", panelCarrito);

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));

        lblAgregarAlCarrito.setText("Agregar al Carrito:");

        jLabel1.setText("KG:");

        bttAddProd.setText("Agregar");
        bttAddProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAddProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAgregarAlCarrito)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttAddProd)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblAgregarAlCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(bttAddProd)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("jpanAddProd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("tabHome");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void bttAddProdActionPerformed(java.awt.event.ActionEvent evt) { 
        cant = (int) spinKG.getValue();
        resetLabelBorders();
        procesarOpcion(option);
    }       
    
    private void bttMostrarArticulosActionPerformed(java.awt.event.ActionEvent evt) { 
        option = "6";
        resetLabelBorders();
        mostrarCarrito();
        imprimirTicket();
    }    
        private void bttPrintTicketActionPerformed(java.awt.event.ActionEvent evt) { 
        resetLabelBorders();
        imprimirTicket();
    } 

    private void lblPapaMouseClicked(java.awt.event.MouseEvent evt) {
        resetLabelBorders();
        lblPapa.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        option = "1";
    }                                    

    private void lblJitomateMouseClicked(java.awt.event.MouseEvent evt) {
        resetLabelBorders();
        lblJitomate.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        option = "3";
    }                                        

    private void lblFrijolMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
        resetLabelBorders();
        lblFrijol.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        option = "5";
    }                                      

    private void lblHuevoMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        resetLabelBorders();
        lblHuevo.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        option = "4";
    }                                     

    private void lblArrozMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        resetLabelBorders();
        option = "2";
        lblArroz.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }                                     

    private void panelCarritoMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        option = "6";
        //mostrarCarrito();
        //imprimirTicket();
    }                                         

    //TO REMOVE BORDERS
    private void resetLabelBorders() {
    lblArroz.setBorder(null);
    lblPapa.setBorder(null);
    lblJitomate.setBorder(null);
    lblHuevo.setBorder(null);
    lblFrijol.setBorder(null);
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
        ProductsFrm productsFrm = new ProductsFrm();
        productsFrm.menu();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                productsFrm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bttAddProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblAgregarAlCarrito;
    private javax.swing.JLabel lblArroz;
    private javax.swing.JLabel lblFrijol;
    private javax.swing.JLabel lblHuevo;
    private javax.swing.JLabel lblJitomate;
    private javax.swing.JLabel lblPapa;
    private javax.swing.JPanel panelCarrito;
    private javax.swing.JPanel panelHOME;
    private javax.swing.JPanel panelProd;
    private javax.swing.JSpinner spinKG;
    private javax.swing.JButton bttMostrarArticulos;
    private javax.swing.JButton bttPrintTicket;
    // End of variables declaration                   
}
