package test;

import clases.Alojamiento;
import arreglos.ArregloAlojamiento;

public class AlojamientoTest {

        private static void listar(ArregloAlojamiento arAlo) {
                for (int i = 0; i < arAlo.getSize(); i++) {
                        System.out.println(arAlo.getAlojamiento(i).getCodigo()
                                        +" | "+arAlo.getAlojamiento(i).getCodigoCliente()
                                        +" | "+ arAlo.getAlojamiento(i).getCodigoEmpleado()
                                        +" | "+ arAlo.getAlojamiento(i).getFechaLlegada()
                                        +" | "+ arAlo.getAlojamiento(i).getHoraLlegada()
                                        +" | "+ arAlo.getAlojamiento(i).getFechaSalida()
                                        +" | "+ arAlo.getAlojamiento(i).getHoraSalida()
                                        +" | "+ arAlo.getAlojamiento(i).getDesEstado());
                }
        }

        public static void main(String[] args) {
                ArregloAlojamiento arLisAlo1 = new ArregloAlojamiento();
                ArregloAlojamiento arLisAlo2 = new ArregloAlojamiento();
                
                Alojamiento alo1 = new Alojamiento(1, 1, 1, "28/10/2014", "09:00", "30/10/2014", "08:00", 1);
                Alojamiento alo2 = new Alojamiento(1, 2, 1, "28/10/2014", "10:00", "30/10/2014", "12:00", 1);
                Alojamiento alo3 = new Alojamiento(1, 3, 1, "28/10/2014", "11:00", "30/10/2014", "13:00", 1);
                
                System.out.println("Metodo Agregar");
                arLisAlo1.addAlojamiento(alo1);
                arLisAlo1.addAlojamiento(alo2);
                arLisAlo1.addAlojamiento(alo3);
                listar(arLisAlo1);
                
                System.out.println("Metodo Modificar");
                Alojamiento almod = arLisAlo1.getAlojamiento(0);
                almod.setEstado(0);
                arLisAlo1.modifyAlojamiento(0, almod);
                listar(arLisAlo1);
                
                System.out.println("Metodo Eliminar");
                arLisAlo1.deleteAlojamiento(0);
                listar(arLisAlo1);
                
                System.out.println("Guardar Data");
                arLisAlo1.guardarData();
                
                System.out.println("Cargar Data");
                arLisAlo2.cargarData();
                listar(arLisAlo2);
                
        }
}