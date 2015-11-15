package clases;

public class Empleado {

        // Declaracion de Atributos
        private int codigo; // codigo autogenerado
        private String nombres;
        private String apellidos;
        private int tipoEmpleado;
        private String clave;

        // Atributos staticos
        private static int aut_generado;

        // Constructores(sobre carga de constructores)
        public Empleado() {
                aut_generado++;
                this.codigo= aut_generado;
        }

        public Empleado(String nombres, String apellidos, int tipoEmpleado, String clave) {
                aut_generado++;
                this.codigo = aut_generado;
                this.apellidos = apellidos;
                this.nombres = nombres;
                this.tipoEmpleado = tipoEmpleado;
                this.clave = clave;
        }

        // Metodos getter and setter
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

        public int getTipoEmpleado() {
                return tipoEmpleado;
        }

        public void setTipoEmpleado(int tipoEmpleado) {
                this.tipoEmpleado = tipoEmpleado;
        }

        public String getClave() {
                return clave;
        }

        public void setClave(String clave) {
                this.clave = clave;
        }



        // Metodos de descripcion
        public String getTipoDescripcion() {
                switch (tipoEmpleado) {
                case 0:
                        return "Administrador";
                default:
                        return "Empleado";
                }
        }
}