package test;

import arreglos.ArregloProducto;
import clases.Producto;

public class ProductoTest {

        static void listar (ArregloProducto arPro){
                for (int i = 0; i < arPro.getSize(); i++) {
                        Producto pro =  arPro.getProducto(i);
                        System.out.println(pro.getCodigo() + " | " +pro.getDescripcion() + " | "+ pro.getPrecio() +" | " + pro.getStock());
                }
        }
        
        public static void main(String[] args) {
                //Declaracion de variables
                ArregloProducto arPro1 = new ArregloProducto();
                ArregloProducto arPro2 = new ArregloProducto();
                
                Producto pro1 = new Producto();
                Producto pro2 = new Producto();
                Producto pro3 = new Producto();
                
                //lectura de Datos
                pro1.setDescripcion("Coca cola");
                pro1.setPrecio(2.00);
                pro1.setStock(10);
        
                pro2.setDescripcion("Inca Kola");
                pro2.setPrecio(2.00);
                pro2.setStock(10);
                
                pro3.setDescripcion("  Sprite ");
                pro3.setPrecio(2.00);
                pro3.setStock(10);
                //Proceso de calculo
                        //Metodos administrativos
                        
                        //Agregar
                        arPro1.addProducto(pro1);
                        arPro1.addProducto(pro2);
                        arPro1.addProducto(pro3);
                        System.out.println(" Metodo Agregar ");
                        listar(arPro1);
                        
                        //Modificar
                        Producto proMo = arPro1.getProducto(0);
                        proMo.setDescripcion("  fanta  ");
                        arPro1.modifyProducto(0, proMo);
                        System.out.println(" Metodo Modificar ");
                        listar(arPro1);
                        
                        //Eliminar
                        arPro1.deleteProducto(0);
                        System.out.println(" Metodo eliminar ");
                        listar(arPro1);
                        
                        //
                        System.out.println("Guardando en un txt");
                        arPro1.guardarData();
                
                        System.out.println("Cargando del txt");
                        arPro2.cargarData();
                        listar(arPro2);
                        
        }
        
}