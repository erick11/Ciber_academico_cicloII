package clases;

public class Alojamiento {

        // Declaracion de atributos
        private int codigo;
        private int codigoCliente;
        private int codigoEmpleado;
        private int numeroHabitacion;
        private String fechaLlegada;
        private String horaLlegada;
        private String fechaSalida;
        private String horaSalida;
        private int estado;

        private static int aut_generado;

        // Metodo Constructor
        public Alojamiento() {
                aut_generado++;
                this.codigo = aut_generado;
        }

        public Alojamiento(int codigoCliente, int codigoEmpleado,
                        int numeroHabitacion, String fechaLlegada, String horaLlegada,
                        String fechaSalida, String horaSalida, int estado) {
                
                aut_generado++;
                this.codigo = aut_generado;
                this.codigoCliente = codigoCliente;
                this.codigoEmpleado = codigoEmpleado;
                this.numeroHabitacion = numeroHabitacion;
                this.fechaLlegada = fechaLlegada;
                this.horaLlegada = horaLlegada;
                this.fechaSalida = fechaSalida;
                this.horaSalida = horaSalida;
                this.estado = estado;
        }

        // Metodos getter and setter
        public int getCodigo() {
                return codigo;
        }

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }

        public int getCodigoCliente() {
                return codigoCliente;
        }

        public void setCodigoCliente(int codigoCliente) {
                this.codigoCliente = codigoCliente;
        }

        public int getCodigoEmpleado() {
                return codigoEmpleado;
        }

        public void setCodigoEmpleado(int codigoEmpleado) {
                this.codigoEmpleado = codigoEmpleado;
        }

        public int getNumeroHabitacion() {
                return numeroHabitacion;
        }

        public void setNumeroHabitacion(int numeroHabitacion) {
                this.numeroHabitacion = numeroHabitacion;
        }

        public String getFechaLlegada() {
                return fechaLlegada;
        }

        public void setFechaLlegada(String fechaLlegada) {
                this.fechaLlegada = fechaLlegada;
        }

        public String getHoraLlegada() {
                return horaLlegada;
        }

        public void setHoraLlegada(String horaLlegada) {
                this.horaLlegada = horaLlegada;
        }

        public String getFechaSalida() {
                return fechaSalida;
        }

        public void setFechaSalida(String fechaSalida) {
                this.fechaSalida = fechaSalida;
        }

        public String getHoraSalida() {
                return horaSalida;
        }

        public void setHoraSalida(String horaSalida) {
                this.horaSalida = horaSalida;
        }

        public int getEstado() {
                return estado;
        }

        public void setEstado(int estado) {
                this.estado = estado;
        }

        //Metodos de descripcion
        public String getDesEstado(){
                
                String des;
                switch (estado) {
                case 0:
                        des="libre";
                        break;

                default:
                        des= "Ocupado";
                        break;
                }
                
                return des;
        }
}