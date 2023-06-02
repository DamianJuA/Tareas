package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JButton btnagregar;
    private JButton btnCargar;
    private JButton btnBorrar;
    private JLabel lblid;
    private JLabel lblnombre;
    private JLabel lblmaterial;
    private JLabel lbltipo;
    private JLabel lblformadetocar;
    private JLabel lblURL;
    private JTextField txtid;
    private JTextField txtnombre;
    private JTextField txtmaterial;
    private JTextField txttipo;
    private JTextField txtformadetocar;
    private JTextField txtURL;
    private JTable tblinstrumentos;
    private JScrollPane scrol;
    private JLabel imagen;
    private GridLayout layout;
    private JPanel panel1; //Formulario de captura
    private JPanel panel2; // Tabla para mostrar datos
    private JPanel panel3;// imagen
    private JPanel panel4;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);
        //panel 1
        panel1= new JPanel(new FlowLayout());
        panel1.setBackground(new Color(173, 104, 104));
        lblid=new JLabel("Id: ");
        lblnombre=new JLabel("Nombre: ");
        lblmaterial=new JLabel("Material: ");
        lbltipo=new JLabel("Tipo: ");
        lblformadetocar=new JLabel("Forma de Tocar: ");
        lblURL=new JLabel("Imagen: ");
        txtid=new JTextField(3);
        txtnombre=new JTextField(15);
        txtmaterial=new JTextField(15);
        txttipo=new JTextField(10);
        txtformadetocar=new JTextField(10);
        txtURL=new JTextField(40);
        btnagregar=new JButton("Agregar");
        panel1.add(lblid);
        panel1.add(txtid);
        panel1.add(lblnombre);
        panel1.add(txtnombre);
        panel1.add(lblmaterial);
        panel1.add(txtmaterial);
        panel1.add(lbltipo);
        panel1.add(txttipo);
        panel1.add(lblformadetocar);
        panel1.add(txtformadetocar);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnagregar);


        //panel 2
        panel2= new JPanel(new FlowLayout());
        panel2.setBackground(new Color(87, 86, 86));
        btnCargar=new JButton("Cargar Informacion");
        panel2.add(btnCargar);
        tblinstrumentos = new JTable();
        scrol = new JScrollPane(tblinstrumentos);
        panel2.add(scrol);



        //panel 3
        panel3= new JPanel(new FlowLayout());
        panel3.setBackground(new Color(139, 125, 229));
        imagen= new JLabel("...");
        panel3.add(imagen);



        //panel 4
        panel4= new JPanel(new FlowLayout());
        panel4.setBackground(new Color(233, 159, 241));
        btnBorrar=new JButton("Borrar Columna");
        panel4.add(btnBorrar);




        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton getBtnagregar() {
        return btnagregar;
    }

    public void setBtnagregar(JButton btnagregar) {
        this.btnagregar = btnagregar;
    }

    public JLabel getLblid() {
        return lblid;
    }

    public void setLblid(JLabel lblid) {
        this.lblid = lblid;
    }

    public JLabel getLblnombre() {
        return lblnombre;
    }

    public void setLblnombre(JLabel lblnombre) {
        this.lblnombre = lblnombre;
    }

    public JLabel getLblmaterial() {
        return lblmaterial;
    }

    public void setLblmaterial(JLabel lblmaterial) {
        this.lblmaterial = lblmaterial;
    }

    public JLabel getLbltipo() {
        return lbltipo;
    }

    public void setLbltipo(JLabel lbltipo) {
        this.lbltipo = lbltipo;
    }

    public JLabel getLblformadetocar() {
        return lblformadetocar;
    }

    public void setLblformadetocar(JLabel lblformadetocar) {
        this.lblformadetocar = lblformadetocar;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtid() {
        return txtid;
    }

    public void setTxtid(JTextField txtid) {
        this.txtid = txtid;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxtmaterial() {
        return txtmaterial;
    }

    public void setTxtmaterial(JTextField txtmaterial) {
        this.txtmaterial = txtmaterial;
    }

    public JTextField getTxttipo() {
        return txttipo;
    }

    public void setTxttipo(JTextField txttipo) {
        this.txttipo = txttipo;
    }

    public JTextField getTxtformadetocar() {
        return txtformadetocar;
    }

    public void setTxtformadetocar(JTextField txtformadetocar) {
        this.txtformadetocar = txtformadetocar;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JTable getTblinstrumentos() {
        return tblinstrumentos;
    }

    public void setTblinstrumentos(JTable tblinstrumentos) {
        this.tblinstrumentos = tblinstrumentos;
    }

    public JScrollPane getScrol() {
        return scrol;
    }

    public void setScrol(JScrollPane scrol) {
        this.scrol = scrol;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public void limpiar(){
        txtid.setText("");
        txtnombre.setText("");
        txtmaterial.setText("");
        txttipo.setText("");
        txtformadetocar.setText("");
        txtURL.setText("");
    }
}
