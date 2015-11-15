package paneles;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import clases.Habitacion;

import arreglos.ArregloHabitacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelHabitacion extends JPanel implements ActionListener, ItemListener{
        
        //Declaracion de Componentes
        private DefaultTableModel modelTbHabitacion;
        private JTable tbHabitacion;
        private JTextField txtNumeroHabitacion;
        private JTextField txtPrecioPorDia;
        private JLabel lblNumeroDeHabitacion;
        private JLabel lblCategoria;
        private JPanel pnlDatos;
        private JLabel lblTipo;
        private JComboBox cboTipo;
        private JLabel lblPrecioPorDia;
        private JLabel lblEstado;
        private JComboBox cboEstado;
        private JScrollPane scrollPane;
        private JLabel lblTitulo;
        private JComboBox cboCategoria;
        private JLabel lblSeleccionar;
        private JComboBox cboSeleccionarOpcion;
        private JButton btnProcesar;
        
        //Declaracion de Arreglo
        ArregloHabitacion arListHabitacion = new ArregloHabitacion();
        
        //Constructor
        public PanelHabitacion() {
                arListHabitacion.cargarData();
                
                setLayout(null);
                
                pnlDatos = new JPanel();
                pnlDatos.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                pnlDatos.setBounds(24, 79, 553, 116);
                add(pnlDatos);
                pnlDatos.setLayout(null);
                
                lblNumeroDeHabitacion = new JLabel("Numero de Habitaci\u00F3n");
                lblNumeroDeHabitacion.setBounds(10, 24, 118, 14);
                pnlDatos.add(lblNumeroDeHabitacion);
                
                txtNumeroHabitacion = new JTextField();
                txtNumeroHabitacion.setEnabled(false);
                txtNumeroHabitacion.setBounds(150, 21, 123, 20);
                pnlDatos.add(txtNumeroHabitacion);
                txtNumeroHabitacion.setColumns(10);
                
                lblCategoria = new JLabel("Categoria");
                lblCategoria.setBounds(293, 24, 68, 14);
                pnlDatos.add(lblCategoria);
                
                cboCategoria = new JComboBox();
                cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
                cboCategoria.setEnabled(false);
                cboCategoria.setBounds(389, 21, 123, 20);
                pnlDatos.add(cboCategoria);
                
                lblTipo = new JLabel("Tipo");
                lblTipo.setBounds(10, 55, 46, 14);
                pnlDatos.add(lblTipo);
                
                cboTipo = new JComboBox();
                cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Doble", "Triple", "Matrimonial"}));
                cboTipo.setEnabled(false);
                cboTipo.setBounds(150, 52, 123, 20);
                pnlDatos.add(cboTipo);
                
                lblPrecioPorDia = new JLabel("Precio por dia");
                lblPrecioPorDia.setBounds(292, 55, 87, 14);
                pnlDatos.add(lblPrecioPorDia);
                
                txtPrecioPorDia = new JTextField();
                txtPrecioPorDia.setEnabled(false);
                txtPrecioPorDia.setBounds(389, 52, 123, 20);
                pnlDatos.add(txtPrecioPorDia);
                txtPrecioPorDia.setColumns(10);
                
                lblEstado = new JLabel("Estado");
                lblEstado.setBounds(10, 91, 59, 14);
                pnlDatos.add(lblEstado);
                
                cboEstado = new JComboBox();
                cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupada"}));
                cboEstado.setEnabled(false);
                cboEstado.setBounds(150, 88, 123, 20);
                pnlDatos.add(cboEstado);
                
                scrollPane = new JScrollPane();
                scrollPane.setBounds(24, 206, 553, 152);
                add(scrollPane);
                
                
                modelTbHabitacion = new DefaultTableModel(new Object[][] {},new String[] {
                                        "N\u00FAmero de Habitaci\u00F3n ", "Categoria", "Tipo", "Precio por Dia", "Estado"}
                                        );
                tbHabitacion = new JTable();
                tbHabitacion.setModel(modelTbHabitacion);
                scrollPane.setViewportView(tbHabitacion);
                
                lblTitulo = new JLabel("Mantenimiento de Habitaci\u00F3n ");
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
                lblTitulo.setBounds(195, 21, 238, 14);
                add(lblTitulo);
                
                lblSeleccionar = new JLabel("Seleccionar");
                lblSeleccionar.setBounds(154, 46, 70, 14);
                add(lblSeleccionar);
                
                cboSeleccionarOpcion = new JComboBox();
                cboSeleccionarOpcion.addItemListener(this);
                cboSeleccionarOpcion.setModel(new DefaultComboBoxModel(new String[] {"Ellegir una Opci\u00F3n", "Agregar", "Modificar", "Eliminar"}));
                cboSeleccionarOpcion.setBounds(234, 46, 120, 20);
                add(cboSeleccionarOpcion);
                
                btnProcesar = new JButton("Procesar");
                btnProcesar.addActionListener(this);
                btnProcesar.setBounds(374, 46, 99, 23);
                add(btnProcesar);
                
                listarTabla();
        }
        
        //Eventos de GUI
        @Override
        public void itemStateChanged(ItemEvent e) {
                if(e.getSource().equals(cboSeleccionarOpcion)){
                        seleccionar();
                }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(btnProcesar)){
                        procesar();
                }
        }
        
        //Metodos de GUI
        private void seleccionar(){
                int opcion = cboSeleccionarOpcion.getSelectedIndex();

                if (opcion == 0) {
                        txtNumeroHabitacion.setEnabled(false);
                        cboCategoria.setEnabled(false);
                        cboTipo.setEnabled(false);
                        txtPrecioPorDia.setEnabled(false);
                        cboEstado.setEnabled(false);
                }
                if (opcion == 1) {

                        cboCategoria.setEnabled(true);
                        cboTipo.setEnabled(true);
                        txtPrecioPorDia.setEnabled(true);
                        cboEstado.setEnabled(true);
                }
                if (opcion == 2) {
                        cboCategoria.setEnabled(true);
                        cboTipo.setEnabled(true);
                        txtPrecioPorDia.setEnabled(true);
                        cboEstado.setEnabled(true);

                }
                if (opcion == 3) {
                        txtNumeroHabitacion.setEnabled(true);
                        cboCategoria.setEnabled(false);
                        cboTipo.setEnabled(false);
                        txtPrecioPorDia.setEnabled(false);
                        cboEstado.setEnabled(false);
                }
                
                
        }       
        
        private void procesar(){
                int opcion = cboSeleccionarOpcion.getSelectedIndex();
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
                if (arListHabitacion.getSize() == 0) {
                        cod = arListHabitacion.getSize() + 1;
                } else {
                        cod = arListHabitacion.getHabitacion(arListHabitacion.getSize() - 1).getNumeroHabitacion() + 1;
                }

                return "" + cod;
        }
        
        private void ingresar(){
                Habitacion hab = new Habitacion(leerCategoria(), leerTipo(), leerPrecioPorDia(), leerEstado());
                arListHabitacion.addHabitacion(hab);
                arListHabitacion.guardarData();
                listarTabla();
                limpiarCajasTexto();
        }
        
        private void modificar(){
                
                Habitacion hab = new Habitacion();
                hab.setNumeroHabitacion(leerNumeroHabitacion());
                hab.setCategoria(leerCategoria());
                hab.setTipo(leerTipo());
                hab.setPrecioPorDia(leerPrecioPorDia());
                hab.setEstado(leerEstado());
                int indice= arListHabitacion.getIndiceByNumeroHabitacion(leerNumeroHabitacion());
                arListHabitacion.modifyHabitacion(indice, hab);
                arListHabitacion.guardarData();
                listarTabla();
                limpiarCajasTexto();
        
        }
        
        private void eliminar(){
                
                int indice = arListHabitacion.getIndiceByNumeroHabitacion(leerNumeroHabitacion());
                arListHabitacion.deleteHabitacion(indice);
                arListHabitacion.guardarData();
                listarTabla();
                limpiarCajasTexto();
        }
        
        //Metodos de lista
        private void listarTabla(){
                limpiarTabla();
                for (int i = 0; i < arListHabitacion.getSize(); i++) {
                        Object[] datos = {
                                                        arListHabitacion.getHabitacion(i).getNumeroHabitacion(),
                                                        arListHabitacion.getHabitacion(i).getDesCategoria(),
                                                        arListHabitacion.getHabitacion(i).getDesTipo(),
                                                        arListHabitacion.getHabitacion(i).getPrecioPorDia(),
                                                        arListHabitacion.getHabitacion(i).getDesEstado()
                                                        };
                        modelTbHabitacion.addRow(datos);
                }
        }
        
        private void limpiarTabla(){
                int filas = tbHabitacion.getRowCount();
                for (int fila = 0; fila < filas; fila++) {
                        modelTbHabitacion.removeRow(0);
                }
        }
        
        private void limpiarCajasTexto(){
                cboCategoria.setSelectedIndex(0);
                cboTipo.setSelectedIndex(0);
                txtPrecioPorDia.setText(" ");
        }
        
        //Metodos de captura para la GUI
        public int leerNumeroHabitacion(){
                try {
                        int numHab= Integer.parseInt(txtNumeroHabitacion.getText());
                        return numHab;
                } catch (Exception e) {
                        System.out.println("PanelHabitacion.leerNumeroHabitacion()"+ e.getMessage());
                        return -666;
                }
        }
        
        public int leerCategoria(){
                
                try {
                        int cat = cboCategoria.getSelectedIndex();
                        return cat;
                } catch (Exception e) {
                        System.out.println(""+ e.getMessage());
                        return -666;
                }
                
        }
        
        public int leerTipo(){
                
                try {
                        int tipo = cboTipo.getSelectedIndex();
                        return tipo;
                } catch (Exception e) {
                        System.out.println("PanelHabitacion.leerPrecioPorDia"+ e.getMessage());
                        return -666;
                }
                
        }
        
        public double leerPrecioPorDia(){
                try {
                        double preDia = Double.parseDouble(txtPrecioPorDia.getText());
                        return preDia;
                } catch (Exception e) {
                        System.out.println("PanelHabitacion.leerPrecioPorDia"+ e.getMessage());
                        return -666;
                }
        }
        
        public int leerEstado(){
                try {
                        int estado = cboEstado.getSelectedIndex();
                        return estado;
                } catch (Exception e) {
                        System.out.println("PanelHabitacion.leerEstado()"+ e.getMessage());
                        return -666; 
                }
        }
        
        public static void main(String[] args) {
                
                JFrame fr = new JFrame();
                fr.setVisible(true);
                fr.setSize(610, 430);
                PanelHabitacion pnlHabitacion = new PanelHabitacion();
                fr.getContentPane().add(pnlHabitacion);
        
        }
}