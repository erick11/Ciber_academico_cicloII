package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import clases.Cliente;


public class ArregloCliente {

        private ArrayList<Cliente> arListCliente;

        public ArregloCliente() {
                arListCliente = new ArrayList<Cliente>();
        }

        // Metodos Administrativos
        // Agregar Cliente
        public void addCliente(Cliente cli) {
                arListCliente.add(cli);
        }

        // Modificar Cliente
        public void modifyCliente(int indice, Cliente cli) {
                arListCliente.set(indice, cli);
        }

        // Eliminar Cliente
        public void deleteCliente(int indice) {
                arListCliente.remove(indice);
        }

        // Obtener Cliente
        public Cliente getCliente(int indice) {
                return arListCliente.get(indice);
        }

        //
        public int getIndiceByCodigo(int cod){
                int indice = 0;
                for (int i = 0; i < getSize(); i++) {
                        if (cod == getCliente(i).getCodigo()) {
                                indice = i;
                        }

                }
                return indice;
        }
        
        public Cliente getClienteByCodigo(int cod){
                Cliente cli = new Cliente();
                for (int i = 0; i < getSize(); i++) {
                        if(cod==getCliente(i).getCodigo()){
                                cli= getCliente(i);
                        }
                }
                return cli;
        }
        
        // Tamaño del Arreglo
        public int getSize() {
                return arListCliente.size();
        }

        // Metodos Archivo
        public void guardarData() {

                try {
            PrintWriter pw = new PrintWriter(new FileWriter("Clientes.txt"));

            for(int i=0;i<getSize();i++) {
                Cliente cli = getCliente(i);
                pw.println(cli.getCodigo()+","+
                                   cli.getNombres()+","+
                                   cli.getApellidos()+","+
                                   cli.getTelefono()
                                   );
            }
            
            pw.close();

        } catch(Exception e) {
            System.out.println("Error en guardarData(): "+ e.toString()) ;
        }
        }

	public void cargarData() {

		try {

			File file = new File("Empleados.txt");

			if (file.exists()) {

				FileReader fr = new FileReader("Clientes.txt");
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(linea, ",");
					Cliente cli = new Cliente();
					cli.setCodigo(Integer.parseInt(st.nextToken()));
					cli.setNombres(st.nextToken());
					cli.setApellidos((st.nextToken()));
					cli.setTelefono(st.nextToken());
					arListCliente.add(cli);
				}
				br.close();

			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("ArregloCliente.cargarData(): " + e.getMessage());
		}
	}
}
