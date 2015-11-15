package test;

import clases.Consumo;
import arreglos.ArregloConsumo;

public class ConsumoTest {

        public static void listar(ArregloConsumo arCon) {
                for (int i = 0; i < arCon.getSize(); i++) {
                        System.out.println(arCon.getConsumo(i).getCodigo() + " | "
                                        + arCon.getConsumo(i).getCodigoCliente() + " | "
                                        + arCon.getConsumo(i).getFechaPedido() + " | "
                                        + arCon.getConsumo(i).getServicio() + " | "
                                        + arCon.getConsumo(i).getTotalPagar() + " | "
                                        + arCon.getConsumo(i).getEstado());
                }
        }

        public static void main(String[] args) {

                ArregloConsumo arCon1 = new ArregloConsumo();
                ArregloConsumo arCon2 = new ArregloConsumo();
                
                Consumo con1 = new Consumo(1, "30/10/2014", 1, 50.00, 0);
                Consumo con2 = new Consumo(1, "30/10/2014", 1, 150.00, 0);
                Consumo con3 = new Consumo(2, "30/10/2014", 1, 250.00, 0);
                
                //Agregar
                System.out.println("Agregar");
                arCon1.addConsumo(con1);
                arCon1.addConsumo(con2);
                arCon1.addConsumo(con3);
                listar(arCon1);
                
                //Modificar
                System.out.println("Modificar");
                int indice = arCon1.getIndiceByCodigo(1);
                Consumo conModi = arCon1.getConsumo(indice);
                conModi.setEstado(1);
                arCon1.modifyConsumo(indice, conModi);
                listar(arCon1);
                
                //Eliminar
                System.out.println("Eliminar"); 
                arCon1.deleteConsumo(0);
                listar(arCon1);
                
                System.out.println("Guardar Data");
                arCon1.guardarData();
                
                System.out.println("Cargar Data");
                arCon2.cargarData();
                listar(arCon2);
        }
}