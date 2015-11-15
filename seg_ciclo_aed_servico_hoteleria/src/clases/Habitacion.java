package clases;

public class Habitacion {

        // Declaracion de atributos
        private int numeroHabitacion;
        private int categoria;
        private int tipo;
        private double precioPorDia;
        private int estado;

        //Atributo statico para crear el codigo autogenrerado
        private static int aut_generado;

        // Metodo constructor (sobre carga)
        public Habitacion() {

        }

        public Habitacion(int categoria, int tipo, double precioPorDia, int estado) {
                aut_generado++;
                this.numeroHabitacion = aut_generado;
                this.categoria = categoria;
                this.tipo = tipo;
                this.precioPorDia = precioPorDia;
                this.estado = estado;
        }

        // Metodos getter and setter
        public int getNumeroHabitacion() {
                return numeroHabitacion;
        }

        public void setNumeroHabitacion(int numeroHabitacion) {
                this.numeroHabitacion = numeroHabitacion;
        }

        public int getCategoria() {
                return categoria;
        }

        public void setCategoria(int categoria) {
                this.categoria = categoria;
        }

        public int getTipo() {
                return tipo;
        }

        public void setTipo(int tipo) {
                this.tipo = tipo;
        }

        public double getPrecioPorDia() {
                return precioPorDia;
        }

        public void setPrecioPorDia(double precioPorDia) {
                this.precioPorDia = precioPorDia;
        }

        public int getEstado() {
                return estado;
        }

        public void setEstado(int estado) {
                this.estado = estado;
        }

        // Metodos descripcion
        public String getDesCategoria() {

                String des;
                switch (categoria) {
                case 0:
                        des = "A";
                        break;
                case 1:
                        des = "B";
                        break;
                case 2:
                        des = "C";
                        break;
                default:
                        des = "D";
                        break;
                }
                return des;

        }

        public String getDesTipo() {
                String des;
                switch (tipo) {
                case 0:
                        des = "Simple";
                        break;
                case 1:
                        des = "Doble";
                        break;
                case 2:
                        des = "Triple";
                        break;

                default:
                        des = "Matrimonial";
                        break;
                }
                return des;
        }

        public String getDesEstado() {
                String des;
                switch (estado) {
                case 0:
                        des = "Libre";
                        break;
                default:
                        des = "Ocupado";
                        break;
                }
                return des;
        }
}