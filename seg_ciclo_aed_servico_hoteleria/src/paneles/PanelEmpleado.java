package paneles;

//import ProyectoHotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import arreglos.ArregloEmpleado;

import clases.Empleado;
import java.awt.Font;

public class PanelEmpleado extends JPanel implements ActionListener,
                ItemListener {

        // Componentes de la GUI
        private JPanel pnlDatos;
        private JLabel lblCodigo;
        private JLabel lblApellidos;
        private JTextField txtCodigo;
        private JTextField txtNombres;
        private JTextField txtApellidos;
        private JLabel lblTipo;
        private JPasswordField txtClave;
        private JComboBox cboTipo;
        private JScrollPane scrollTbEmpleado;
        private DefaultTableModel modelTbEmpleado;
        private JTable tb_Empleados;
        private JComboBox cboSeleccionarOpcion;
        private JLabel lblSeleccionar;
        private JLabel lblNombres;
        private JLabel lblClave;
        private JLabel lblTitulo;
        private JButton btnBuscar;
        private JButton btnProcesar;

        // Clase que administra el arreglo
        ArregloEmpleado arEmp = new ArregloEmpleado();

        public PanelEmpleado() {
                arEmp.cargarData();

                this.setLayout(null);

                pnlDatos = new JPanel();
                pnlDatos.setBorder(new TitledBorder(null, "Datos Generales",
                                TitledBorder.LEADING, TitledBorder.TOP, null, null));
                pnlDatos.setBounds(23, 79, 558, 136);
                add(pnlDatos);
                pnlDatos.setLayout(null);

                lblCodigo = new JLabel("Codigo:");
                lblCodigo.setBounds(10, 22, 46, 20);
                pnlDatos.add(lblCodigo);

                lblApellidos = new JLabel("Apellidos: ");
                lblApellidos.setBounds(10, 61, 72, 20);
                pnlDatos.add(lblApellidos);

                txtCodigo = new JTextField();
                txtCodigo.setText(cod_auto());
                txtCodigo.setEnabled(false);
                txtCodigo.setBounds(92, 22, 146, 20);
                pnlDatos.add(txtCodigo);
                txtCodigo.setColumns(10);

                lblNombres = new JLabel("Nombres: ");
                lblNombres.setBounds(298, 22, 64, 20);
                pnlDatos.add(lblNombres);

                txtNombres = new JTextField();
                txtNombres.setEnabled(false);
                txtNombres.setBounds(384, 22, 164, 20);
                pnlDatos.add(txtNombres);

                txtApellidos = new JTextField();
                txtApellidos.setEnabled(false);
                txtApellidos.setBounds(92, 58, 146, 20);
                pnlDatos.add(txtApellidos);

                lblTipo = new JLabel("Tipo:  ");
                lblTipo.setBounds(299, 61, 46, 20);
                pnlDatos.add(lblTipo);

                cboTipo = new JComboBox();
                cboTipo.setEnabled(false);
                cboTipo.setModel(new DefaultComboBoxModel(new String[] {
                                "Administrador", "Empleado" }));
                cboTipo.setBounds(384, 61, 164, 20);
                pnlDatos.add(cboTipo);

                lblClave = new JLabel("Clave: ");
                lblClave.setBounds(10, 101, 57, 20);
                pnlDatos.add(lblClave);

                txtClave = new JPasswordField();
                txtClave.setEnabled(false);
                txtClave.setBounds(92, 98, 146, 20);
                pnlDatos.add(txtClave);

                btnBuscar = new JButton("");
                btnBuscar.setEnabled(false);
                btnBuscar.setBounds(248, 19, 26, 23);
                pnlDatos.add(btnBuscar);

                scrollTbEmpleado = new JScrollPane();
                scrollTbEmpleado.setBounds(23, 244, 558, 142);
                this.add(scrollTbEmpleado);

                modelTbEmpleado = new DefaultTableModel(new Object[][] {}, new String[] {
                                "Codigo", "Nombres", "Apellidos", "Tipo" });
                tb_Empleados = new JTable();
                tb_Empleados.setModel(modelTbEmpleado);
                scrollTbEmpleado.setViewportView(tb_Empleados);

                lblTitulo = new JLabel("Mantenimiento Empleado");
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
                lblTitulo.setBounds(207, 11, 196, 23);
                this.add(lblTitulo);

                lblSeleccionar = new JLabel("Seleccionar:");
                lblSeleccionar.setBounds(141, 54, 86, 14);
                this.add(lblSeleccionar);

                cboSeleccionarOpcion = new JComboBox();
                cboSeleccionarOpcion.addItemListener(this);
                cboSeleccionarOpcion.setModel(new DefaultComboBoxModel(new String[] {
                                "Eligir una Opcion", "Ingresar", "Modificar", "Eliminar" }));
                cboSeleccionarOpcion.setBounds(228, 51, 115, 20);
                this.add(cboSeleccionarOpcion);

                btnProcesar = new JButton("Procesar");
                btnProcesar.addActionListener(this);
                btnProcesar.setBounds(368, 50, 94, 23);
                this.add(btnProcesar);

                listarTabla();
        }

        // Eventos de Botones y Mouse
        @Override
        public void itemStateChanged(ItemEvent ie) {
                if (ie.getSource().equals(cboSeleccionarOpcion) )
                        seleccionar();
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
                if (ae.getSource().equals(btnProcesar)) {
                        procesar();
                }
        }



        // Eventos GUI
        void seleccionar() {
                int opcion = cboSeleccionarOpcion.getSelectedIndex();

                if (opcion == 0) {
                        lblCodigo.setEnabled(false);
                        txtCodigo.setEnabled(false);
                        lblNombres.setEnabled(false);
                        txtNombres.setEnabled(false);
                        lblApellidos.setEnabled(false);
                        txtApellidos.setEnabled(false);
                        lblTipo.setEnabled(false);
                        cboTipo.setEnabled(false);
                        lblClave.setEnabled(false);
                        txtClave.setEnabled(false);
                        btnBuscar.setEnabled(false);
                        // limpiar();
                        // btnBuscarEmp.setVisible(false);
                }
                else if (opcion == 1) {
                        lblCodigo.setEnabled(true);
                        txtCodigo.setEnabled(false);
                        lblNombres.setEnabled(true);
                        txtNombres.setEnabled(true);
                        lblApellidos.setEnabled(true);
                        txtApellidos.setEnabled(true);
                        lblTipo.setEnabled(true);
                        cboTipo.setEnabled(true);
                        lblClave.setEnabled(true);
                        txtClave.setEnabled(true);
                }
                else if (opcion == 2) {
                        // ocultarModificar();
                        lblCodigo.setEnabled(true);
                        txtCodigo.setEnabled(true);
                        lblNombres.setEnabled(true);
                        txtNombres.setEnabled(true);
                        lblApellidos.setEnabled(true);
                        txtApellidos.setEnabled(true);
                        lblTipo.setEnabled(true);
                        cboTipo.setEnabled(true);
                        lblClave.setEnabled(true);
                        txtClave.setEnabled(true);
                        btnBuscar.setEnabled(true);

                }
                else {
                        lblCodigo.setEnabled(true);
                        txtCodigo.setEnabled(true);
                        lblNombres.setEnabled(false);
                        txtNombres.setEnabled(false);
                        lblApellidos.setEnabled(false);
                        txtApellidos.setEnabled(false);
                        lblTipo.setEnabled(false);
                        cboTipo.setEnabled(false);
                        lblClave.setEnabled(false);
                        txtClave.setEnabled(false);
                }

        }

        void procesar() {
                int opcion = cboSeleccionarOpcion.getSelectedIndex();

                if (opcion == 1) {
                        ingresar();
                }else if (opcion == 2) {
                        modificar();
                }
                else{
                        eliminar();
                }
        }

        private String cod_auto() {

                int cod;
                if (arEmp.getSize() == 0) {
                        cod = arEmp.getSize() + 1;
                } else {
                        cod = arEmp.getEmpleado(arEmp.getSize() - 1).getCodigo() + 1;
                }

                return "" + cod;
        }

        // Metodos Logicos
        public void ingresar() {
                Empleado emp = new Empleado(leerNombres(), leerApellidos(), leerTipo(),leerClave());
                arEmp.addEmpleado(emp);
                arEmp.guardarData();
                listarTabla();
                limpiarCajasTexto();
                txtCodigo.setText(cod_auto());
        }

        public void modificar() {
                // Instancio el objeto Empleado
                Empleado emp = new Empleado();
                emp.setCodigo(leerCodigo());
                emp.setNombres(leerNombres());
                emp.setApellidos(leerApellidos());
                emp.setTipoEmpleado(leerTipo());
                emp.setClave(leerClave());
                int index = arEmp.getIndexByCodigo(leerCodigo());
                arEmp.modifyEmpleado(index, emp);
                arEmp.guardarData();
                listarTabla();
                limpiarCajasTexto();
        }

        public void eliminar() {
                int indice = 0;
                indice = arEmp.getIndexByCodigo(leerCodigo());
                arEmp.deleteEmpleado(indice);
                arEmp.guardarData();
                listarTabla();
                limpiarCajasTexto();
        }

        public void listarTabla() {

                limpiarTabla();
                for (int i = 0; i < arEmp.getSize(); i++) {
                        Object[] datos = { 
                                        arEmp.getEmpleado(i).getCodigo(),
                                        arEmp.getEmpleado(i).getNombres(),
                                        arEmp.getEmpleado(i).getApellidos(),
                                        arEmp.getEmpleado(i).getTipoDescripcion() 
                                        };
                        modelTbEmpleado.addRow(datos);
                }

        }

        public void limpiarTabla() {
                // Obtener el numero de filas
                int filas = tb_Empleados.getRowCount();

                // remueve todas las filas de la tabla
                for (int fila = 0; fila < filas; fila++) {
                        modelTbEmpleado.removeRow(0);
                }
        }
        
        public void limpiarCajasTexto() {
                txtCodigo.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                cboTipo.setSelectedIndex(0);
                txtClave.setText("");

        }
        
        // Metodos de Captura de Datos(GUI)
                public int leerCodigo() {
                        try {
                                int codigo = Integer.parseInt(txtCodigo.getText());
                                return codigo;
                        } catch (Exception e) {
                                return -666;
                        }
                }

                public String leerNombres() {
                        try {
                                String nombres = txtNombres.getText();
                                
                                if (nombres.charAt(0) == ' ' || nombres.charAt(nombres.toCharArray().length - 1)==' ') {
                                        return nombres.trim();
                                }
                                return nombres;
                        } catch (Exception e) {
                                System.out.println("PanelCliente.leerNombres(): " + e.getMessage());
                                return null;
                        }
                }

                public String leerApellidos() {

                        try {
                                String apellidos = txtApellidos.getText();
                                if (apellidos.charAt(0) == ' '|| apellidos.charAt(apellidos.toCharArray().length - 1)==' ') {
                                        return apellidos.trim();
                                }
                                return apellidos.trim();
                        } catch (Exception e) {
                                return null;
                        }

                }

                public int leerTipo() {
                        try {
                                int tipo = cboTipo.getSelectedIndex();
                                return tipo;

                        } catch (Exception e) {
                                return -666;
                        }

                }

                public String leerClave() {
                        try {

                                String pass = new String(txtClave.getPassword());
                                if (pass.charAt(0) == ' ') {
                                        return pass.trim();
                                }
                                return pass;
                        } catch (Exception e) {
                                return null;
                        }

                }


        public static void main(String[] args) {

                JFrame ventana = new JFrame();
                ventana.setVisible(true);
                ventana.setSize(610, 430);
                PanelEmpleado pnlEmpleado = new PanelEmpleado();
                ventana.getContentPane().add(pnlEmpleado);

        }
}