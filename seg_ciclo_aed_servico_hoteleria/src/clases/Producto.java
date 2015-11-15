package clases;

public class Producto {

        //Declaracion de  atributos 
        private int codigo;
        private String descripcion;
        private double precio;
        private int stock;
        
        private static int aut_generado;
        //Metodo constructor (sobre carga)
        public Producto() {
                aut_generado++;
                this.codigo= aut_generado;
        }

        public Producto(int codigo, String descripcion, double precio, int stock) {
                this.codigo = codigo;
                this.descripcion = descripcion;
                this.precio = precio;
                this.stock = stock;
        }

        //Metodos getter ans setter
        public int getCodigo() {
                return codigo;
        }

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public double getPrecio() {
                return precio;
        }

        public void setPrecio(double precio) {
                this.precio = precio;
        }

        public int getStock() {
                return stock;
        }

        public void setStock(int stock) {
                this.stock = stock;
        }
        
        

}