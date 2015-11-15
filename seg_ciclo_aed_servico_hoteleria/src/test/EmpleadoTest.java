package test;

import arreglos.ArregloEmpleado;
import clases.Empleado;

public class EmpleadoTest {

        private static void listar(ArregloEmpleado arEmp) {
                for (int i = 0; i < arEmp.getSize(); i++) {
                        System.out.println(arEmp.getEmpleado(i).getCodigo() + " | "
                                        + arEmp.getEmpleado(i).getNombres() + " | "
                                        + arEmp.getEmpleado(i).getApellidos() + " | "
                                        + arEmp.getEmpleado(i).getTipoDescripcion() + " | "
                                        + arEmp.getEmpleado(i).getClave());
                }
        }

        public static void main(String[] args) {
                        
                        //Declaracion de Objetos
                        ArregloEmpleado arEmp1 = new ArregloEmpleado();
                        ArregloEmpleado arEmp2 = new ArregloEmpleado();
                        Empleado emp1 = new Empleado("Erick Eduardo", "Navarrete Guerrero", 0, "123456");
                        Empleado emp2 = new Empleado("Oscar Germain", "Gutierrez Huiza", 0, "123456");
                        Empleado emp3 = new Empleado("Andrea Penelope", "Soto Rodriguez", 1, "123456");
                        
                        //Metodos Administrativos
                        System.out.println("Metodo Agregar");
                        arEmp1.addEmpleado(emp1);
                        arEmp1.addEmpleado(emp2);
                        arEmp1.addEmpleado(emp3);
                        listar(arEmp1);
                        
                        System.out.println("Metodo Modificar");
                        Empleado empMod = arEmp1.getEmpleado(0);
                        empMod.setNombres("Erick Modific");
                        arEmp1.modifyEmpleado(0, empMod);
                        listar(arEmp1);
                        
                        System.out.println("Metodo eliminar");
                        arEmp1.deleteEmpleado(0);
                        listar(arEmp1);
                        
                        System.out.println("Guardar Data");
                        arEmp1.guardarData();
                        
                        System.out.println("Cargando Data");
                        arEmp2.cargarData();
                        listar(arEmp2);
                // Empleado emp_tem01 = new Empleado();
                //
                // Empleado emp1 = new Empleado("Erick Eduardo", "Navarrete Guerrero",
                // 2,
                // "1");
                // Empleado emp2 = new Empleado("Carlos Alberto", "Palomino Guerrero",
                // 1,
                // "1");
                //
                // ArregloEmpledo arEmp = new ArregloEmpledo();
                //
                // // Agregart
                // arEmp.addEmpleado(emp1);
                // arEmp.addEmpleado(emp2);
                //
                // // Buscar
                // emp_tem01 = arEmp.getEmpleado(1);
                // System.out.println("codigo: " + emp_tem01.getCodigo());
                // System.out.println("Nombres: " + emp_tem01.getNombres());
                // System.out.println("Apellidos: " + emp_tem01.getApellidos());
                // System.out.println("Tipo: " + emp_tem01.getTipoDescripcion());
                // System.out.println("Clave: " + emp_tem01.getClave());
                // System.out.println("###############################################");
                //
                // System.out.println("|     Codigo      |" + "|       Nombres        |"
                // + "|     Apellidos     |"
                // + "|  tipo  |" + "|  clave  |");
                // for (int i = 0; i < arEmp.getSize(); i++) {
                // System.out.println(arEmp.getEmpleado(i).getCodigo() + " | "
                // + arEmp.getEmpleado(i).getNombres() + " | "
                // + arEmp.getEmpleado(i).getApellidos() + " | "
                // + arEmp.getEmpleado(i).getTipoDescripcion() + " | "
                // + arEmp.getEmpleado(i).getClave());
                // }
                //
                //
                // // Modificar
                // System.out.println("Modificar");
                // arEmp.modifyEmpleado(1, new Empleado("Lima Silva",
                // "Cristiano Ronaldo"));
                //
                // emp_tem01 = arEmp.getEmpleado(1);
                // System.out.println("codigo: " + emp_tem01.getCodigo());
                // System.out.println("Nombres: " + emp_tem01.getNombres());
                // System.out.println("Apellidos: " + emp_tem01.getApellidos());
                // System.out.println("Tipo: " + emp_tem01.getTipoDescripcion());
                // System.out.println("Clave: " + emp_tem01.getClave());
                //
                // System.out.println("|  Codigo  |" + "|  Nombres |" + "| Apellidos  |"
                // + "|  tipo  |" + "|  clave  |");
                // for (int i = 0; i < arEmp.getSize(); i++) {
                // System.out.println(arEmp.getEmpleado(i).getCodigo() + " | "
                // + arEmp.getEmpleado(i).getNombres() + " | "
                // + arEmp.getEmpleado(i).getApellidos() + " | "
                // + arEmp.getEmpleado(i).getTipoDescripcion() + " | "
                // + arEmp.getEmpleado(i).getClave());
                // }

        }
}