package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import clases.Alojamiento;

public class ArregloAlojamiento {

        private ArrayList<Alojamiento> arListAlojamiento;

        public ArregloAlojamiento() {
                arListAlojamiento = new ArrayList<Alojamiento>();
        }

        // Metodos administrativos
        public void addAlojamiento(Alojamiento alo) {
                arListAlojamiento.add(alo);
        }

        public void modifyAlojamiento(int indice, Alojamiento alo) {
                arListAlojamiento.set(indice, alo);
        }

        public void deleteAlojamiento(int indice) {
                arListAlojamiento.remove(indice);
        }

        public Alojamiento getAlojamiento(int indice) {
                return arListAlojamiento.get(indice);
        }

        public int getSize() {
                return arListAlojamiento.size();
        }

        // Metodos de Archivos

        public void guardarData() {

                try {
                        PrintWriter pw = new PrintWriter(new File("Alojamiento.txt"));
                        for (int i = 0; i < getSize(); i++) {
                                Alojamiento alo = getAlojamiento(i);
                                pw.println(alo.getCodigo() + "," +
                                                   alo.getCodigoCliente() + ","+ 
                                                   alo.getCodigoEmpleado() + ","+
                                                   alo.getNumeroHabitacion() + ","+  
                                                   alo.getFechaLlegada() + "," + 
                                                   alo.getHoraLlegada()+"," + 
                                                   alo.getFechaSalida() + ","+ 
                                                   alo.getHoraSalida() + "," + 
                                                   alo.getEstado()
                                                   );
                        }
                        pw.close();
                } catch (Exception e) {
                        System.out.println("ArregloAlojamiento.guardarData(): "
                                        + e.getMessage());
                }
        }

        public void cargarData() {
                try {
                        FileReader fr = new FileReader("Alojamiento.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea=br.readLine())!=null) {
                                StringTokenizer st = new StringTokenizer(linea, ",");
                                Alojamiento alo = new Alojamiento();
                                alo.setCodigo(Integer.parseInt(st.nextToken()));
                                alo.setCodigoCliente(Integer.parseInt(st.nextToken()));
                                alo.setCodigoEmpleado(Integer.parseInt(st.nextToken()));
                                alo.setNumeroHabitacion(Integer.parseInt(st.nextToken()));
                                alo.setFechaLlegada(st.nextToken());
                                alo.setHoraLlegada(st.nextToken());
                                alo.setFechaSalida(st.nextToken());
                                alo.setHoraSalida(st.nextToken());
                                alo.setEstado(Integer.parseInt(st.nextToken()));
                                
                                arListAlojamiento.add(alo);
                        }
                        fr.close();
                } catch (Exception e) {
                        System.out.println("ArregloAlojamiento.cargarData(): "
                                        + e.getMessage());
                }
        }
}