package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import clases.Producto;

public class ArregloProducto {

        private ArrayList<Producto> arListProducto; 
        
        
        //Constructor
        public ArregloProducto() {
                
                arListProducto = new ArrayList<Producto>();
        
        }
        
        //Metodos Administrativos
        public void addProducto(Producto pro){
                arListProducto.add(pro);
        }
        
        public void modifyProducto(int indice, Producto pro){
                arListProducto.set(indice, pro);
        }

        public void deleteProducto(int indice){
                arListProducto.remove(indice);
        }

        public int getSize(){
                return arListProducto.size();
        }
        
        public Producto getProducto(int indice){
                return arListProducto.get(indice);
        }
        
        public Producto getByCodigo(int cod){
                for (int i = 0; i < getSize(); i++) {
                        if (cod==getProducto(i).getCodigo()) {
                                return getProducto(i);
                        }
                }
                return null;
        }
        
        //Metodos de Archivo
        
        public void guardarData(){
                
                try {
                        PrintWriter pw = new PrintWriter(new File("Productos.txt"));
                        for (int i = 0; i < getSize(); i++) {
                                Producto pro = getProducto(i);
                                pw.println(pro.getCodigo()+","+pro.getDescripcion()+","+pro.getPrecio()+","+pro.getStock());
                        }
                        
                        pw.close();
                        
                } catch (Exception e) {
                        System.out.println("Error guardarData(): "+e.getMessage());
                }
        }

        public void cargarData(){
                
                try {
                        FileReader fr = new FileReader("Productos.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        
                        while ((linea = br.readLine()) != null) {
                                StringTokenizer st = new StringTokenizer(linea, ",");
                                Producto pro = new Producto();
                                
                                pro.setCodigo( Integer.parseInt(st.nextToken()));
                                pro.setDescripcion(st.nextToken());
                                pro.setPrecio(Double.parseDouble(st.nextToken()));
                                pro.setStock(Integer.parseInt(st.nextToken()));
                                
                                
                                arListProducto.add(pro);
                        }
                        
                        fr.close();
                } catch (Exception e) {
                        System.out.println("Error ArregloProducto.cargarData(): "+ e.getMessage() + " | " + e.toString());
                }
        }
}