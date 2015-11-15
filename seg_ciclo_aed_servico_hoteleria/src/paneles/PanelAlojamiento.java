package paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Alojamiento;
import clases.Cliente;
import clases.Habitacion;

import arreglos.ArregloAlojamiento;
import arreglos.ArregloCliente;
import arreglos.ArregloHabitacion;

public class PanelAlojamiento extends JPanel implements ActionListener, ItemListener{
        
        //Declaracion de Componentes
        private JTextField txtCodigo;
        private JTextField txtFechaLlegada;
        private JTextField txtHoraLlegada;
        private JTextField txtFechaSalida;
        private JTextField txtHoraSalida;
        private JTextField txtNombresCliente;
        private JTextField txtApellidosCliente;
        private JTextField txtCodigoCliente;
        private JPanel pnlHabitacion;
        private JLabel lblFechaDeLlegada;
        private JLabel lblHoraDeLlegada;
        private JLabel lblFechaSalida;
        private JLabel lblHoraDeSalida;
        private JPanel pnlDatosEmpleado;
        private JPanel pnlDatosCliente;
        private JButton btnBusCliente;
        private JLabel lblCodigo;
        private JLabel lblNombres;
        private JLabel lblApellidos;
        private JLabel lblAlojamiento;
        private JTextField txtCodEmpleado;
        private JTextField txtNomEmpleado;
        private JTextField txtApeEmpleado;
        private JLabel lblNumeroDeHabitacion;
        private JTextField txtNumHabitacion;
        private JLabel lblCategoria;
        private JTextField txtCategoria;
        private JTextField txtTipo;
        private DefaultTableModel modelTbHabitaciones;
        private JTable tbHabitaciones;
        private JButton btnBuscarHabitacion;
        private JButton btnCancelar;
        private JButton btnAceptar;
        
        //Declaracion de Arreglos
        ArregloAlojamiento arListAlojamiento = new ArregloAlojamiento();
        ArregloCliente arListCliente = new ArregloCliente();
        ArregloHabitacion arListHabitaccion = new ArregloHabitacion();
        
        
        //Constructor
        public PanelAlojamiento() {
                arListHabitaccion.cargarData();
                arListCliente.cargarData();
                arListAlojamiento.cargarData();
                
                setLayout(null);
                
                lblAlojamiento = new JLabel("Alojamiento");
                lblAlojamiento.setFont(new Font("Tahoma", Font.BOLD, 15));
                lblAlojamiento.setBounds(240, 11, 106, 36);
                add(lblAlojamiento);
                
                txtCodigo = new JTextField();
                txtCodigo.setEnabled(false);
                txtCodigo.setText(cod_auto());
                txtCodigo.setBounds(64, 36, 106, 20);
                add(txtCodigo);
                txtCodigo.setColumns(10);
                
                JLabel lblCdigo = new JLabel("C\u00F3digo: ");
                lblCdigo.setBounds(16, 39, 54, 14);
                add(lblCdigo);
                
                pnlDatosEmpleado = new JPanel();
                pnlDatosEmpleado.setBorder(new TitledBorder(null, "Datos Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                pnlDatosEmpleado.setBounds(16, 122, 287, 120);
                add(pnlDatosEmpleado);
                pnlDatosEmpleado.setLayout(null);
                
                JLabel lblCdigo_2 = new JLabel("C\u00F3digo: ");
                lblCdigo_2.setBounds(10, 25, 57, 14);
                pnlDatosEmpleado.add(lblCdigo_2);
                
                JLabel lblNombres_1 = new JLabel("Nombres: ");
                lblNombres_1.setBounds(10, 50, 57, 14);
                pnlDatosEmpleado.add(lblNombres_1);
                
                JLabel lblApellidos_1 = new JLabel("Apellidos: ");
                lblApellidos_1.setBounds(10, 83, 57, 14);
                pnlDatosEmpleado.add(lblApellidos_1);
                
                txtCodEmpleado = new JTextField();
                txtCodEmpleado.setBounds(77, 22, 144, 20);
                pnlDatosEmpleado.add(txtCodEmpleado);
                txtCodEmpleado.setColumns(10);
                
                txtNomEmpleado = new JTextField();
                txtNomEmpleado.setBounds(77, 47, 144, 20);
                pnlDatosEmpleado.add(txtNomEmpleado);
                txtNomEmpleado.setColumns(10);
                
                txtApeEmpleado = new JTextField();
                txtApeEmpleado.setBounds(77, 80, 144, 20);
                pnlDatosEmpleado.add(txtApeEmpleado);
                txtApeEmpleado.setColumns(10);
                
                pnlDatosCliente = new JPanel();
                pnlDatosCliente.setBorder(new TitledBorder(null, "Datos Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                pnlDatosCliente.setBounds(326, 122, 254, 120);
                add(pnlDatosCliente);
                pnlDatosCliente.setLayout(null);
                
                btnBusCliente = new JButton("");
                btnBusCliente.addActionListener(this);
                btnBusCliente.setBounds(198, 21, 31, 23);
                pnlDatosCliente.add(btnBusCliente);
                
                lblNombres = new JLabel("Nombres: ");
                lblNombres.setBounds(10, 59, 65, 14);
                pnlDatosCliente.add(lblNombres);
                
                txtNombresCliente = new JTextField();
                txtNombresCliente.setEnabled(false);
                txtNombresCliente.setBounds(70, 56, 117, 20);
                pnlDatosCliente.add(txtNombresCliente);
                txtNombresCliente.setColumns(10);
                
                lblApellidos = new JLabel("Apellidos: ");
                lblApellidos.setBounds(10, 84, 65, 14);
                pnlDatosCliente.add(lblApellidos);
                
                txtApellidosCliente = new JTextField();
                txtApellidosCliente.setEnabled(false);
                txtApellidosCliente.setBounds(68, 84, 119, 20);
                pnlDatosCliente.add(txtApellidosCliente);
                txtApellidosCliente.setColumns(10);
                
                lblCodigo = new JLabel("C\u00F3digo: ");
                lblCodigo.setBounds(10, 27, 46, 14);
                pnlDatosCliente.add(lblCodigo);
                
                txtCodigoCliente = new JTextField();
                txtCodigoCliente.setBounds(70, 24, 117, 20);
                pnlDatosCliente.add(txtCodigoCliente);
                txtCodigoCliente.setColumns(10);
                
                pnlHabitacion = new JPanel();
                pnlHabitacion.setBorder(new TitledBorder(null, "Habitaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                pnlHabitacion.setBounds(16, 253, 564, 161);
                add(pnlHabitacion);
                pnlHabitacion.setLayout(null);
                
                lblNumeroDeHabitacion = new JLabel("Numero de Habitacion: ");
                lblNumeroDeHabitacion.setBounds(276, 26, 139, 14);
                pnlHabitacion.add(lblNumeroDeHabitacion);
                
                txtNumHabitacion = new JTextField();
                txtNumHabitacion.setBounds(410, 23, 74, 20);
                pnlHabitacion.add(txtNumHabitacion);
                txtNumHabitacion.setColumns(10);
                
                lblCategoria = new JLabel("Categoria: ");
                lblCategoria.setBounds(276, 51, 74, 14);
                pnlHabitacion.add(lblCategoria);
                
                JLabel lblTipo = new JLabel("Tipo: ");
                lblTipo.setBounds(276, 76, 46, 14);
                pnlHabitacion.add(lblTipo);
                
                txtCategoria = new JTextField();
                txtCategoria.setEnabled(false);
                txtCategoria.setBounds(410, 51, 144, 20);
                pnlHabitacion.add(txtCategoria);
                txtCategoria.setColumns(10);
                
                txtTipo = new JTextField();
                txtTipo.setEnabled(false);
                txtTipo.setBounds(410, 82, 144, 20);
                pnlHabitacion.add(txtTipo);
                txtTipo.setColumns(10);
                
                JScrollPane scrollTbHabitaciones = new JScrollPane();
                scrollTbHabitaciones.setEnabled(false);
                scrollTbHabitaciones.setBounds(10, 26, 244, 124);
                pnlHabitacion.add(scrollTbHabitaciones);
                
                
                modelTbHabitaciones = new DefaultTableModel(new Object[][] {},new String[] {"#", "Categoria", "Tipo", "Precio Por Dia"});
                tbHabitaciones = new JTable();
                tbHabitaciones.setEnabled(false);
                tbHabitaciones.setModel(modelTbHabitaciones);
                scrollTbHabitaciones.setViewportView(tbHabitaciones);
                
                btnBuscarHabitacion = new JButton("");
                btnBuscarHabitacion.addActionListener(this);
                btnBuscarHabitacion.setBounds(492, 22, 29, 23);
                pnlHabitacion.add(btnBuscarHabitacion);
                
                lblFechaDeLlegada = new JLabel("Fecha de Llegada (dd/mm/yyyy): ");
                lblFechaDeLlegada.setBounds(16, 67, 162, 14);
                add(lblFechaDeLlegada);
                
                txtFechaLlegada = new JTextField();
                txtFechaLlegada.setBounds(188, 64, 116, 20);
                txtFechaLlegada.setText("08/11/2014");
                add(txtFechaLlegada);
                txtFechaLlegada.setColumns(10);
                
                lblHoraDeLlegada = new JLabel("Hora de Llegada (24:00): ");
                lblHoraDeLlegada.setBounds(326, 67, 125, 14);
                add(lblHoraDeLlegada);
                
                txtHoraLlegada = new JTextField();
                txtHoraLlegada.setBounds(461, 64, 119, 20);
                txtHoraLlegada.setText("09:00 a.m");
                add(txtHoraLlegada);
                txtHoraLlegada.setColumns(10);
                
                lblFechaSalida = new JLabel("Fecha Salida (dd/mm/yyyy):");
                lblFechaSalida.setBounds(16, 92, 168, 14);
                add(lblFechaSalida);
                
                txtFechaSalida = new JTextField();
                txtFechaSalida.setBounds(188, 95, 115, 20);
                txtFechaSalida.setText("08/12/2014");
                add(txtFechaSalida);
                
                
                lblHoraDeSalida = new JLabel("Hora de Salida (24:00):");
                lblHoraDeSalida.setBounds(326, 92, 125, 14);
                add(lblHoraDeSalida);
                
                txtHoraSalida = new JTextField();
                txtHoraSalida.setBounds(461, 89, 119, 20);
                txtHoraSalida.setText("09:00 a.m");
                add(txtHoraSalida);
                txtHoraSalida.setColumns(10);
                
                btnAceptar = new JButton("Aceptar");
                btnAceptar.addActionListener(this);
                btnAceptar.setBounds(347, 425, 89, 23);
                add(btnAceptar);
                
                btnCancelar = new JButton("Cancelar");
                btnCancelar.addActionListener(this);
                btnCancelar.setBounds(461, 425, 89, 23);
                add(btnCancelar);
                
                listarTabla();
        }
        
        
        //Eventos de GUI
        @Override
        public void itemStateChanged(ItemEvent e) {
                
                        
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(btnBusCliente)){
                        buscarCliente();
                }
                else if(e.getSource().equals(btnBuscarHabitacion)){
                        buscarHabitacion();
                }
                else{
                        aceptar();
                } 
        }
        
        //codigo Autogenerado
        private String cod_auto() {

                int cod;
                if (arListAlojamiento.getSize() == 0) {
                        cod = arListAlojamiento.getSize() + 1;
                } else {
                        cod = arListAlojamiento.getAlojamiento(arListAlojamiento.getSize() - 1).getCodigo() + 1;
                }

                return "" + cod;
        }
        
        //Metodos lógicos
        private void buscarCliente(){
                Cliente cli = arListCliente.getClienteByCodigo(leerCodCliente());
                txtNombresCliente.setText(cli.getNombres());
                txtApellidosCliente.setText(cli.getApellidos());
        }
        
        private void buscarHabitacion(){
                Habitacion hab = arListHabitaccion.getHabitacionByCodigo(leerNumeroHabitacion());
                txtCategoria.setText(hab.getDesCategoria());
                txtTipo.setText(hab.getDesTipo());
        } 
        
        private void aceptar() {
                Alojamiento alo = new Alojamiento(leerCodCliente(), leerCodEmpleado(), leerNumeroHabitacion(), leerFechaLlegada(), leerHoraLlegada(), leerFechaSalida(), leerHoraSalida(),0);
                int indice = arListHabitaccion.getIndiceByNumeroHabitacion(leerNumeroHabitacion());
                Habitacion hab = arListHabitaccion.getHabitacionByCodigo(leerNumeroHabitacion());
                hab.setEstado(1);
                
                arListHabitaccion.modifyHabitacion(indice, hab);
                arListAlojamiento.addAlojamiento(alo);
                
                arListHabitaccion.guardarData();
                arListAlojamiento.guardarData();
                
                txtCodigo.setText(cod_auto());          
                listarTabla();
                limpiarCajasTexto();
                
        }       
        
        private void listarTabla(){
                limpiarTabla();
                for (int i = 0; i < arListHabitaccion.getSize(); i++) {
                        if(arListHabitaccion.getHabitacion(i).getEstado() == 0){
                                Object datos[] = {
                                                arListHabitaccion.getHabitacion(i).getNumeroHabitacion(),
                                                arListHabitaccion.getHabitacion(i).getDesCategoria(),
                                                arListHabitaccion.getHabitacion(i).getDesTipo(),
                                                arListHabitaccion.getHabitacion(i).getPrecioPorDia()
                                                };
                                modelTbHabitaciones.addRow(datos);
                        }
                }
        }
        
        private void limpiarTabla(){
                int filas= tbHabitaciones.getRowCount();
                for (int fila = 0; fila < filas; fila++) {
                        modelTbHabitaciones.removeRow(0);
                }
                
                
        }
        
        private void limpiarCajasTexto(){
                txtFechaLlegada.setText(" ");
                txtHoraLlegada.setText(" ");
                txtFechaSalida.setText(" ");
                txtHoraSalida.setText(" ");
                txtCodigoCliente.setText(" ");
                txtNombresCliente.setText(" ");
                txtApellidosCliente.setText(" ");
                txtNumHabitacion.setText(" ");
                txtCategoria.setText(" ");
                txtTipo.setText(" ");
        }
        
        
        //Metodos de captura de datos de GUI
        public int leerCodCliente(){
                try {
                        int cod = Integer.parseInt(txtCodigoCliente.getText());
                        return cod;
                } catch (Exception e) {
                        System.out.println("PanelAlojamiento.leerCodCliente: "+ e.getMessage());
                        return -666;
                }
        }
        
        public int leerCodEmpleado(){
                try {
                        int cod = Integer.parseInt(txtCodEmpleado.getText());
                        return cod;
                } catch (Exception e) {
                        System.out.println("PanelAlojamiento.leerCodEmpleado(): "+ e.getMessage());
                        return -666;
                }
        }
        
        public int leerNumeroHabitacion(){
                try {
                        int cod = Integer.parseInt(txtNumHabitacion.getText());
                        return cod;
                } catch (Exception e) {
                        System.out.println("PanelAlojamiento.leerNumeroHabitacion(): "+ e.getMessage());
                        return -666;
                }
        }
        
        public String leerFechaLlegada(){
                
                try {
                        String fechaLlegada = txtFechaLlegada.getText();
                        int posUl = fechaLlegada.toCharArray().length - 1;
                        if (fechaLlegada.charAt(0) == ' '|| fechaLlegada.charAt(posUl) == ' ') {
                                fechaLlegada.trim();
                        }
                        return fechaLlegada;
                } catch (Exception e) {
                        System.out.println("PanelAlojamiento.leerFechaLlegada: "
                                        + e.getMessage());
                        return null;
                }
        }
        
        public String leerHoraLlegada(){
                try {
                        String horaLlegada = txtHoraLlegada.getText();
                        int posUl = horaLlegada.toCharArray().length - 1;
                        if(horaLlegada.charAt(0)==' ' || horaLlegada.charAt(posUl)==' '){
                                horaLlegada.trim();
                        }
                        return horaLlegada;
                } catch (Exception e) {
                        System.out.println("PanelAlojamiento.leerhoraSalida(): " + e.getMessage());
                        return null;
                }
        }
        
        public String leerFechaSalida(){
                try {
                        String fechaSalida = txtFechaSalida.getText();
                        int posUl = fechaSalida.toCharArray().length -1;
                        if(fechaSalida.charAt(0)==' ' || fechaSalida.charAt(posUl)==' '){
                                fechaSalida.trim();
                        }
                        return fechaSalida;
                } catch (Exception e) {
                        System.out.println(" "+ e.getMessage());
                        return null;
                }
        }
        
        public String leerHoraSalida(){
                try {
                        String horaSalida = txtHoraLlegada.getText();
                        int posUl = horaSalida.toCharArray().length - 1;
                        if(horaSalida.charAt(0)==' ' || horaSalida.charAt(posUl)==' '){
                                horaSalida.trim();
                        }
                        return horaSalida;
                } catch (Exception e) {
                        System.out.println("PanelAlojamiento.leerHoraSalida: " + e.getMessage());
                        return null;
                }
        }
        
        public static void main(String[] args) {
                
                JFrame jf = new JFrame();
                jf.setVisible(true);
                jf.setSize(604, 520);
                PanelAlojamiento pnlAlo = new PanelAlojamiento();
                jf.getContentPane().add(pnlAlo);
        }
}