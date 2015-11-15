package clases;

public class Consumo {

        // Declaracion de atributos
        private int codigo;
        private int codigoCliente;
        private String fechaPedido;
        private int servicio;
        private double totalPagar;
        private int estado;

        private static int aut_generado;

        // Metodo constructor
        public Consumo() {
                aut_generado++;
                this.codigo = aut_generado;
        }

        public Consumo(int codigoCliente, String fechaPedido, int servicio,
                        double totalPagar, int estado) {
                aut_generado++;
                this.codigo = aut_generado;
                this.codigoCliente = codigoCliente;
                this.fechaPedido = fechaPedido;
                this.servicio = servicio;
                this.totalPagar = totalPagar;
                this.estado = estado;
        }

        // Metodos getter ans setter
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

        public String getFechaPedido() {
                return fechaPedido;
        }

        public void setFechaPedido(String fechaPedido) {
                this.fechaPedido = fechaPedido;
        }

        public int getServicio() {
                return servicio;
        }

        public void setServicio(int servicio) {
                this.servicio = servicio;
        }

        public double getTotalPagar() {
                return totalPagar;
        }

        public void setTotalPagar(double totalPagar) {
                this.totalPagar = totalPagar;
        }

        public int getEstado() {
                return estado;
        }

        public void setEstado(int estado) {
                this.estado = estado;
        }
        
        //Metodos de descripcion
        public String getDesServicio(){
                String des = null;
                switch (servicio) {
                case 0:
                        des = "Comedor";
                        break;
                
                default:
                        des = "Habitacion";
                        break;
                }
                return des;
        }
        
        public String getDesEstado(){
                String des = null;
                switch (estado) {
                case 0:
                        des = "Pendiente";
                        break;
                
                default:
                        des = "Pagado";
                        break;
                }
                return des;
        }
}