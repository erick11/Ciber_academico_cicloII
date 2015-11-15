package clases;

public class DetalleConsumo {

        //Declaracion de atributos
        private int codigoConsumo;
        private int codigoProducto;
        private int cantidad;
        private double precioUnitario;
        private double subtotal;
        
        //Metodo construtor (sobre carga)
        public DetalleConsumo() {
                
        }

        public DetalleConsumo(int codigoConsumo, int codigoProducto, int cantidad,
                        double precioUnitario, double subtotal) {
                this.codigoConsumo = codigoConsumo;
                this.codigoProducto = codigoProducto;
                this.cantidad = cantidad;
                this.precioUnitario = precioUnitario;
                this.subtotal = subtotal;
        }

        //Metodos getter and Setter
        public int getCodigoConsumo() {
                return codigoConsumo;
        }

        public void setCodigoConsumo(int codigoConsumo) {
                this.codigoConsumo = codigoConsumo;
        }

        public int getCodigoProducto() {
                return codigoProducto;
        }

        public void setCodigoProducto(int codigoProducto) {
                this.codigoProducto = codigoProducto;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setCantidad(int cantidad) {
                this.cantidad = cantidad;
        }

        public double getPrecioUnitario() {
                return precioUnitario;
        }

        public void setPrecioUnitario(double precioUnitario) {
                this.precioUnitario = precioUnitario;
        }

        public double getSubtotal() {
                return subtotal;
        }

        public void setSubtotal(double subtotal) {
                this.subtotal = subtotal;
        }
        
        
        
}