package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import clases.Empleado;
import clases.Habitacion;

public class ArregloHabitacion {

        private ArrayList<Habitacion> arListHabitacion;

        public ArregloHabitacion() {
                arListHabitacion = new ArrayList<Habitacion>();
        }

        // Metodos de mantenimiento para el arreglo
        public void addHabitacion(Habitacion hab) {
                arListHabitacion.add(hab);
        }

        public void modifyHabitacion(int indice, Habitacion hab) {
                arListHabitacion.set(indice, hab);
        }

        public void deleteHabitacion(int index) {
                arListHabitacion.remove(index);
        }

        public int getSize() {
                return arListHabitacion.size();
        }

        public Habitacion getHabitacion(int indice) {
                return arListHabitacion.get(indice);
        }

        public Habitacion getHabitacionByCodigo(int numHab){
                Habitacion hab = new Habitacion();
                for (int i = 0; i < getSize(); i++) {
                        if(numHab == getHabitacion(i).getNumeroHabitacion()){
                                hab = getHabitacion(i);
                        }
                }
                return hab;
        }
        
        public int getIndiceByNumeroHabitacion(int numHab){
                int indice= 0;
                for (int i = 0; i < getSize(); i++) {
                        if(numHab==arListHabitacion.get(i).getNumeroHabitacion()){
                                indice=i;
                        }
                }
                return indice;
        }
        
        //Metodos de Archivos
        public void guardarData() {

                try {
                        PrintWriter pw = new PrintWriter(new FileWriter("Habitacion.txt"));
                        for (int i = 0; i < getSize(); i++) {
                                Habitacion hab = arListHabitacion.get(i);
                                pw.println(hab.getNumeroHabitacion() + "," + 
                                                   hab.getCategoria()+ "," + 
                                                   hab.getTipo() + "," + 
                                                   hab.getPrecioPorDia() + ","+ 
                                                   hab.getEstado());
                        }
                        pw.close();
                } catch (Exception e) {
                        System.out.println("Error guardar(): " + e.getMessage());
                }

        }

        public void cargarData() {
                try {
                        FileReader fr = new FileReader("Habitacion.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                
                                StringTokenizer st = new StringTokenizer(linea, ",");
                                Habitacion hab = new Habitacion();
                                hab.setNumeroHabitacion(Integer.parseInt(st.nextToken()));
                                hab.setCategoria(Integer.parseInt(st.nextToken()));
                                hab.setTipo(Integer.parseInt(st.nextToken()));
                                hab.setPrecioPorDia(Double.parseDouble(st.nextToken()));
                                hab.setEstado(Integer.parseInt(st.nextToken()));
                                
                                arListHabitacion.add(hab);
                        }
                        br.close();
                } catch (Exception e) {
                        System.out.println("Error ArregloHabitacion.cargarData(): "+ e.getMessage().toString());
                }
        }

}