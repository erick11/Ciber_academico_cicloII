package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelConsumo extends JPanel{
        private JLabel lblTitulo;
        private JTextField textField;
        private JTextField textField_1;
        private JTextField textField_2;
        private JTextField textField_3;
        private JTextField textField_4;
        private JLabel lblCdigo;
        private JPanel panel;
        private JLabel lblCdigo_1;
        private JLabel lblNombres;
        private JLabel lblApellidos;
        private JButton btnB;
        private JLabel lblFecha;
        public PanelConsumo() {
                setLayout(null);
                
                lblTitulo = new JLabel("Consumo");
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
                lblTitulo.setBounds(259, 23, 80, 14);
                add(lblTitulo);
                
                lblCdigo = new JLabel("C\u00F3digo: ");
                lblCdigo.setBounds(20, 58, 46, 14);
                add(lblCdigo);
                
                textField = new JTextField();
                textField.setEnabled(false);
                textField.setBounds(76, 55, 86, 20);
                add(textField);
                textField.setColumns(10);
                
                panel = new JPanel();
                panel.setBorder(new TitledBorder(null, "Datos Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                panel.setBounds(10, 121, 228, 140);
                add(panel);
                panel.setLayout(null);
                
                lblCdigo_1 = new JLabel("C\u00F3digo: ");
                lblCdigo_1.setBounds(10, 31, 46, 14);
                panel.add(lblCdigo_1);
                
                textField_1 = new JTextField();
                textField_1.setBounds(58, 28, 86, 20);
                panel.add(textField_1);
                textField_1.setColumns(10);
                
                btnB = new JButton("");
                btnB.setBounds(160, 27, 27, 23);
                panel.add(btnB);
                
                lblNombres = new JLabel("Nombres: ");
                lblNombres.setBounds(10, 72, 56, 14);
                panel.add(lblNombres);
                
                lblApellidos = new JLabel("Apellidos: ");
                lblApellidos.setBounds(10, 96, 56, 14);
                panel.add(lblApellidos);
                
                textField_2 = new JTextField();
                textField_2.setBounds(82, 66, 105, 20);
                panel.add(textField_2);
                textField_2.setColumns(10);
                
                textField_3 = new JTextField();
                textField_3.setBounds(76, 93, 111, 20);
                panel.add(textField_3);
                textField_3.setColumns(10);
                
                lblFecha = new JLabel("Fecha:  ");
                lblFecha.setBounds(376, 58, 46, 14);
                add(lblFecha);
                
                textField_4 = new JTextField();
                textField_4.setBounds(432, 55, 86, 20);
                add(textField_4);
                textField_4.setColumns(10);
                
                JLabel lblServicio = new JLabel("Servicio");
                lblServicio.setBounds(20, 83, 46, 14);
                add(lblServicio);
                
                JComboBox comboBox = new JComboBox();
                comboBox.setBounds(76, 86, 86, 20);
                add(comboBox);
        }
}