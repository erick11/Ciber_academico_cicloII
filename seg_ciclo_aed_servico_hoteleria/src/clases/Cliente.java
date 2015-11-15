package clases;

public class Cliente {

        //Declaracion de Atributos
        private int codigo;
        private String nombres;
        private String apellidos;
        private String telefono;
        
        private static int aut_generado;
        //Metodo constructor(sobre carga de constructores)
        public Cliente() {
                aut_generado++;
                this.codigo=aut_generado;
        }

        public Cliente(String nombres, String apellidos, String telefono) {
                aut_generado++;
                this.codigo = aut_generado;
                this.apellidos = apellidos;
                this.nombres = nombres;
                this.telefono = telefono;
        }

        //Metodos getter and setter
        public int getCodigo() {
                return codigo;
        }

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }

        public String getApellidos() {
                return apellidos;
        }

        public void setApellidos(String apellidos) {
                this.apellidos = apellidos;
        }

        public String getNombres() {
                return nombres;
        }

        public void setNombres(String nombres) {
                this.nombres = nombres;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }
        
        
}