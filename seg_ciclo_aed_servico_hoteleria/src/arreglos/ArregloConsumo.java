package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import clases.Consumo;

public class ArregloConsumo {

        // Declaracion de ArrayList
        ArrayList<Consumo> arListConsumo;

        public ArregloConsumo() {
                arListConsumo = new ArrayList<Consumo>();
        }

        // Metodos Administrativos
        public void addConsumo(Consumo con) {
                arListConsumo.add(con);
        }

        public void modifyConsumo(int indice, Consumo con) {
                arListConsumo.set(indice, con);
        }

        public void deleteConsumo(int indice) {
                arListConsumo.remove(indice);
        }

        public Consumo getConsumo(int indice) {
                return arListConsumo.get(indice);
        }

        public int getSize() {
                return arListConsumo.size();
        }

        public int getIndiceByCodigo(int codigo) {
                int indice = 0;

                for (int i = 0; i < getSize(); i++) {
                        if (codigo == arListConsumo.get(i).getCodigo()) {
                                indice = i;
                        }
                }
                return indice;
        }

        public void guardarData() {
                try {
                        PrintWriter pr = new PrintWriter(new File("Consumo.txt"));
                        for (int i = 0; i < getSize(); i++) {
                                Consumo con = arListConsumo.get(i);
                                pr.println(con.getCodigo() + "," + 
                                                   con.getCodigoCliente() + ","+
                                                   con.getFechaPedido() + "," + 
                                                   con.getServicio()+ "," + 
                                                   con.getTotalPagar() + ","+ 
                                                   con.getEstado());
                        }
                        pr.close();
                } catch (Exception e) {
                        System.out.println("ArregloConsumo.guardarData()" + e.getMessage());
                }
        }

        public void cargarData() {
                try {
                        BufferedReader br = new BufferedReader(
                                        new FileReader("Consumo.txt"));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                StringTokenizer st = new StringTokenizer(linea, ",");
                                Consumo con = new Consumo();
                                con.setCodigo(Integer.parseInt(st.nextToken()));
                                con.setCodigoCliente(Integer.parseInt(st.nextToken()));
                                con.setFechaPedido(st.nextToken());
                                con.setServicio(Integer.parseInt(st.nextToken()));
                                con.setTotalPagar(Double.parseDouble(st.nextToken()));
                                con.setEstado(Integer.parseInt(st.nextToken()));
                                arListConsumo.add(con);
                        }
                        br.close();
                } catch (Exception e) {
                        System.out.println("ArregloConsumo.cargarData()" + e.getMessage());
                }
        }

}