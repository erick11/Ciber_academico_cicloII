package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import clases.Empleado;

public class ArregloEmpleado {

        // Declaracion del objeto ArrayList
        private ArrayList<Empleado> arListEmpleado;

        // Metodo constructor
        public ArregloEmpleado() {
                arListEmpleado = new ArrayList<Empleado>();
        }

        // Metodos Administrativos

        // Tamaño del Arreglo
        public Empleado getEmpleado(int indice) {
                return arListEmpleado.get(indice);
        }

        public void addEmpleado(Empleado emp) {
                arListEmpleado.add(emp);
        }

        public void deleteEmpleado(int indice) {
                arListEmpleado.remove(indice);
        }

        public void modifyEmpleado(int index, Empleado emp) {
                arListEmpleado.set(index, emp);
        }

        public int getSize() {
                return arListEmpleado.size();
        }

        public void deleteAllEmpleado() {
                for (int i = 0; i < getSize(); i++) {
                        arListEmpleado.remove(0);
                }
        }

        public int getIndexByCodigo(int codigo) {
                int index = 0;
                for (int i = 0; i < arListEmpleado.size(); i++) {
                        if (codigo == arListEmpleado.get(i).getCodigo()) {
                                index = i;
                        }
                }
                return index;
        }

        // Metodos de Ancivos
        public void guardarData(){
                
                try {
            PrintWriter pw = new PrintWriter(new FileWriter("Empleados.txt"));

            for(int i=0;i<getSize();i++) {
                Empleado e = getEmpleado(i);
                pw.println(e.getCodigo()+","+e.getNombres()+","+
                e.getApellidos()+","+e.getTipoEmpleado()+","+e.getClave());

            }
            
            pw.close();

        } catch(Exception e) {
            System.out.println("Error en guardarData(): "+ e.toString()) ;
        }
        }

        public void cargarData() {
                try {
                        FileReader fr = new FileReader("Empleados.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                StringTokenizer st = new StringTokenizer(linea, ",");
                                Empleado emp = new Empleado();
                                
                                emp.setCodigo(Integer.parseInt(st.nextToken()));
                                emp.setNombres(st.nextToken());
                                emp.setApellidos((st.nextToken()));
                                emp.setTipoEmpleado(Integer.parseInt(st.nextToken()));
                                emp.setClave(st.nextToken());
                                
                                arListEmpleado.add(emp);
                        }
                        br.close();
                } catch (Exception e) {
                        System.out.println("Error ArregloEmpleado.cargarData(): "+ e.getMessage() + " | " + e.toString());
                }

        }
}
