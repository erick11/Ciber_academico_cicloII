package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import clases.Cliente;
import arreglos.ArregloCliente;

public class PanelCliente extends JPanel implements ActionListener, ItemListener {
        
        //Declaracion de Componentes
        private JLabel lblTitulo;
        private JPanel pnlDatos;
        private JTable tbCliente;
        private DefaultTableModel modelTbCliente;
        private JTextField txtCodigo;
        private JTextField txtNombres;
        private JTextField txtApellidos;
        private JTextField txtTelefono;
        private JLabel lblSeleccionar;
        private JComboBox cboSeleccionar;
        private JButton btnProcesar;
        private JLabel lblCodigo;
        private JLabel lblApellidos;
        private JLabel lblNombres;
        private JLabel lblTelefono;
        private JScrollPane scrollTbCliente;
        private JButton btnBuscar;
        
        ArregloCliente arCli = new ArregloCliente();

        //Constructor
        public PanelCliente() {
                arCli.cargarData();
                
                setLayout(null);
                
                lblTitulo = new JLabel("Matenimiento Cliente");
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
                lblTitulo.setBounds(216, 11, 175, 14);
                add(lblTitulo);

                pnlDatos = new JPanel();
                pnlDatos.setBorder(new TitledBorder(null, "Datos Generales",
                                TitledBorder.LEADING, TitledBorder.TOP, null, null));
                pnlDatos.setBounds(21, 79, 558, 105);
                add(pnlDatos);
                pnlDatos.setLayout(null);

                lblCodigo = new JLabel("C\u00F3digo");
                lblCodigo.setBounds(10, 26, 62, 14);
                pnlDatos.add(lblCodigo);

                txtCodigo = new JTextField();
                txtCodigo.setText(cod_auto());
                txtCodigo.setEnabled(false);
                txtCodigo.setBounds(90, 23, 122, 20);
                pnlDatos.add(txtCodigo);
                

                lblNombres = new JLabel("Nombres");
                lblNombres.setBounds(284, 26, 56, 14);
                pnlDatos.add(lblNombres);

                txtNombres = new JTextField();
                txtNombres.setEnabled(false);
                txtNombres.setBounds(396, 23, 112, 20);
                pnlDatos.add(txtNombres);
                

                lblApellidos = new JLabel("Apellidos");
                lblApellidos.setBounds(10, 66, 62, 14);
                pnlDatos.add(lblApellidos);

                txtApellidos = new JTextField();
                txtApellidos.setEnabled(false);
                txtApellidos.setBounds(88, 63, 124, 20);
                pnlDatos.add(txtApellidos);
                

                lblTelefono = new JLabel("Telefono");
                lblTelefono.setBounds(284, 66, 56, 14);
                pnlDatos.add(lblTelefono);

                txtTelefono = new JTextField();
                txtTelefono.setEnabled(false);
                txtTelefono.setBounds(396, 63, 112, 20);
                pnlDatos.add(txtTelefono);
                

                btnBuscar = new JButton("");
                btnBuscar.setEnabled(false);
                btnBuscar.setBounds(217, 22, 31, 23);
                pnlDatos.add(btnBuscar);

                scrollTbCliente = new JScrollPane();
                scrollTbCliente.setEnabled(false);
                scrollTbCliente.setBounds(21, 212, 558, 153);
                add(scrollTbCliente);

                modelTbCliente = new DefaultTableModel(new Object[][] {}, new String[] {
                                "C\u00F3digo", "Nombres", "Apellidos", "Telefono" });
                tbCliente = new JTable();
                tbCliente.setModel(modelTbCliente);
                scrollTbCliente.setViewportView(tbCliente);

                lblSeleccionar = new JLabel("Seleccionar");
                lblSeleccionar.setBounds(141, 54, 86, 14);
                add(lblSeleccionar);

                cboSeleccionar = new JComboBox();
                cboSeleccionar.addItemListener(this);
                cboSeleccionar.setModel(new DefaultComboBoxModel(new String[] {
                                "Elegir una opcion", "Ingresar", "Modificar", "Eliminar" }));
                cboSeleccionar.setBounds(228, 51, 115, 20);
                add(cboSeleccionar);

                btnProcesar = new JButton("Procesar");
                btnProcesar.setBounds(368, 50, 94, 23);
                btnProcesar.addActionListener(this);
                add(btnProcesar);
                
                listarTabla();
        }

        // Evento de botton y combo
        @Override
        public void itemStateChanged(ItemEvent e) {
                if (e.getSource().equals(cboSeleccionar)) {
                        seleccionar();
                }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                
                if (e.getSource().equals(btnProcesar)) {
                        procesar();
                }
        }

        // Eventos GUI
        private void seleccionar() {
                int opcion = cboSeleccionar.getSelectedIndex();

                if (opcion == 0) {
                        txtCodigo.setEnabled(false);
                        txtNombres.setEnabled(false);
                        txtApellidos.setEnabled(false);
                        txtTelefono.setEnabled(false);
                        btnBuscar.setEnabled(false);
                }
                if (opcion == 1) {

                        lblNombres.setEnabled(true);
                        txtNombres.setEnabled(true);
                        lblApellidos.setEnabled(true);
                        txtApellidos.setEnabled(true);
                        lblTelefono.setEnabled(true);
                        txtTelefono.setEnabled(true);
                        btnBuscar.setEnabled(false);
                }
                if (opcion == 2) {
                        txtCodigo.setEnabled(true);
                        txtNombres.setEnabled(true);
                        txtApellidos.setEnabled(true);
                        txtTelefono.setEnabled(true);
                        btnBuscar.setEnabled(true);

                }
                if (opcion == 3) {
                        txtCodigo.setEnabled(true);
                        txtNombres.setEnabled(false);
                        txtApellidos.setEnabled(false);
                        txtTelefono.setEnabled(false);
                        btnBuscar.setEnabled(false);
                }
        }
        
        private void procesar(){
                int opcion = cboSeleccionar.getSelectedIndex();
                if(opcion==0){
                        JOptionPane.showMessageDialog(pnlDatos, "Debes de eligir una opcion");
                }
                else if(opcion==1){
                        ingresar();
                }else if(opcion==2){
                        modificar();
                }else {
                        eliminar();
                }
        }
        
        //Metodos Administrativos
        private String cod_auto() {

                int cod;
                if (arCli.getSize() == 0) {
                        cod = arCli.getSize() + 1;
                } else {
                        cod = arCli.getCliente(arCli.getSize() - 1).getCodigo() + 1;
                }

                return "" + cod;
        }
        
        private void ingresar(){
                                
                Cliente cli = new Cliente(leerNombres(), leerApellidos(), leerTelefono());
                arCli.addCliente(cli);
                arCli.guardarData();
                listarTabla();
                limpiarCajasTexto();
                txtCodigo.setText(cod_auto());
                
        }
        
        private void modificar(){
                Cliente cli = new Cliente();
                cli.setCodigo(leerCodigo());
                cli.setNombres(leerNombres());
                cli.setApellidos(leerApellidos());
                cli.setTelefono(leerTelefono());
                int indice = arCli.getIndiceByCodigo(leerCodigo());
                arCli.modifyCliente(indice, cli);
                arCli.guardarData();
                listarTabla();
                limpiarCajasTexto();
                
        }
        
        private void eliminar(){
                int indice = arCli.getIndiceByCodigo(leerCodigo());;
                arCli.deleteCliente(indice);
                arCli.guardarData();
                listarTabla();
                limpiarCajasTexto();
                
        }
        
        //Metodos de lista
        private void listarTabla(){
                
                limpiarTabla();
                for (int i = 0; i < arCli.getSize(); i++) {
                        Object[] datos ={
                                                        arCli.getCliente(i).getCodigo(),
                                                        arCli.getCliente(i).getNombres(),
                                                        arCli.getCliente(i).getApellidos(),
                                                        arCli.getCliente(i).getTelefono()
                                                        };
                        modelTbCliente.addRow(datos);
                }
        }
        
        private void limpiarTabla(){
                int filas = tbCliente.getRowCount();
                
                for (int fila = 0; fila < filas; fila++) {
                        modelTbCliente.removeRow(0);
                }
        }
        
        private void limpiarCajasTexto(){
                txtNombres.setText("");
                txtApellidos.setText("");
                txtTelefono.setText("");
        }
        
        
        
        // Metodos de captura de datos GUI
        private int leerCodigo() {
                try {
                        int codigo = Integer.parseInt(txtCodigo.getText());
                        return codigo;
                } catch (Exception e) {
                        System.out.println("PanelCliente.leerCodigo(): " + e.getMessage());
                        return -666;
                }
        }
        
        private String leerNombres() {
                try {
                        String nombres = txtNombres.getText();
                        if (nombres.charAt(0) == ' ' || nombres.charAt(nombres.toCharArray().length - 1) == ' ') {
                                nombres.trim();
                        }
                        return nombres;
                } catch (Exception e) {
                        System.out.println("PanelCliente.leerNombres(): " + e.getMessage());
                        return null;
                }
        }

        private String leerApellidos() {
                try {
                        String apellidos = txtApellidos.getText();
                        if (apellidos.charAt(0) == ' ' || apellidos.charAt(apellidos.toCharArray().length - 1) == ' ') {
                                apellidos.trim();
                        }
                        return apellidos;
                } catch (Exception e) {
                        System.out.println("PanelCliente.leerApellidos(): "+ e.getMessage());
                        return null;
                }
        }

        private String leerTelefono() {
                try {
                        String tel = txtTelefono.getText();
                        if (tel.charAt(0) == ' ' || tel.charAt(tel.toCharArray().length - 1) == ' ') {
                                tel.trim();
                        }
                        return tel;
                } catch (Exception e) {
                        System.out.println("PanelCliente.leerTelefono(): " + e.getMessage());
                        return null;
                }
        }

        public static void main(String[] args) {
                
                JFrame fr = new JFrame();
                fr.setVisible(true);
                fr.setSize(610, 430);
                PanelCliente pnlCliente = new PanelCliente();
                fr.getContentPane().add(pnlCliente);

                
        }
}
