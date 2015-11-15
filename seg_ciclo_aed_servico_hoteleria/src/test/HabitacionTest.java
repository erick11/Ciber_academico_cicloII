package test;

import clases.Habitacion;
import arreglos.ArregloHabitacion;

public class HabitacionTest {

        private static void listar(ArregloHabitacion arHab) {
                for (int i = 0; i < arHab.getSize(); i++) {
                        System.out.println(arHab.getHabitacion(i).getNumeroHabitacion()
                                        + " | " + arHab.getHabitacion(i).getDesCategoria() + " | "
                                        + arHab.getHabitacion(i).getDesTipo() + "  |  "
                                        + arHab.getHabitacion(i).getPrecioPorDia() + " | "
                                        + arHab.getHabitacion(i).getDesEstado());
                }
        }

        public static void main(String[] args) {
                // Declaracion de Objetos
                ArregloHabitacion arhab1 = new ArregloHabitacion();
                ArregloHabitacion arhab2 = new ArregloHabitacion();

                Habitacion hab1 = new Habitacion(0, 0, 50.00, 0);
                Habitacion hab2 = new Habitacion(1, 1, 100.00, 0);
                Habitacion hab3 = new Habitacion(2, 2, 150.00, 0);
                Habitacion hab4 = new Habitacion(3, 3, 200.00, 0);

                // Metodos practicos
                // Agregar
                System.out.println("Metodo Agregar");
                arhab1.addHabitacion(hab1);
                arhab1.addHabitacion(hab2);
                arhab1.addHabitacion(hab3);
                arhab1.addHabitacion(hab4);
                listar(arhab1);

                // Modificar
                System.out.println("Metodo Modificar");
                Habitacion habMod = arhab1.getHabitacion(0);
                habMod.setPrecioPorDia(500);
                habMod.setEstado(1);
                arhab1.modifyHabitacion(0, habMod);
                listar(arhab1);
                
                // Eliminar
                System.out.println("Metodo Eliminar");
                arhab1.deleteHabitacion(0);
                listar(arhab1);
                
                //Grabar
                System.out.println("Metodo Guardar Data");
                arhab1.guardarData();
                
                //Cargar
                System.out.println("Metodo cargar Data");
                arhab2.cargarData();
                listar(arhab2);
        }
}
