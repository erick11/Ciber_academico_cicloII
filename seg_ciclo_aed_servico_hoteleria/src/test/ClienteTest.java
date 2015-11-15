package test;

import arreglos.ArregloCliente;
import clases.Cliente;

public class ClienteTest {

        public static void listar(ArregloCliente arCli) {
                for (int i = 0; i < arCli.getSize(); i++) {
                        System.out.println(arCli.getCliente(i).getCodigo() + " | "
                                        + arCli.getCliente(i).getNombres() + " | "
                                        + arCli.getCliente(i).getApellidos() + " | "
                                        + arCli.getCliente(i).getTelefono());
                }
        }

        public static void main(String[] args) {
                
                //Declaracion de Objetos
                ArregloCliente arCli1 = new ArregloCliente();
                ArregloCliente arCli2 = new ArregloCliente();
                
                Cliente cli1 = new Cliente("Erick Eduardo","Navarrete Guerrero", "987654321");
                Cliente cli2 = new Cliente("Carlos Alberto","Palomino Guerrero","987654321");
                Cliente cli3 = new Cliente("Andrea Penelope","Soto Rodriguez","97612846");


                // Agregar
                System.out.println("########Agregando Clientes######");
                arCli1.addCliente(cli1);
                arCli1.addCliente(cli2);
                arCli1.addCliente(cli3);
                listar(arCli1);
                
                // modificar
                System.out.println("#############Modificando############");
                Cliente cliMo = arCli1.getCliente(0);
                cliMo.setNombres("Erick Modifi");
                arCli1.modifyCliente(0, cliMo);
                listar(arCli1);
                
                // delete
                System.out.println("########Eliminar######");
                arCli1.deleteCliente(0);
                listar(arCli1);

                System.out.println("Guardar Data");
                arCli1.guardarData();
                
                
                System.out.println("Carga Data");
                arCli2.cargarData();
                listar(arCli2);
        }
}