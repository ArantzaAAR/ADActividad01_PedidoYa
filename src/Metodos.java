import model.Clientes;
import model.Pedidos;

import java.io.*;
import java.util.ArrayList;

public class Metodos {
    private Object ois;

    public void escribirCsv(String path) {
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes(01, "Juan Morote", "juan@gmail.com"));
        listaClientes.add(new Clientes(02, "Margarita Romero", "marga@gmail.com"));
        listaClientes.add(new Clientes(03, "Lucía Adiario", "lucia@gmail.com"));
        listaClientes.add(new Clientes(04, "Lara Mirez", "lara@gmail.com"));

        ArrayList<Pedidos> listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedidos(243, 01, "Camiseta", 2));
        listaPedidos.add(new Pedidos(244, 03, "Pantalón", 1));
        listaPedidos.add(new Pedidos(245, 02, "Jersey", 3));
        listaPedidos.add(new Pedidos(246, 01, "Bermudas", 3));
        listaPedidos.add(new Pedidos(247, 04, "Camisa", 2));
        listaPedidos.add(new Pedidos(248, 02, "Falda", 1));
        listaPedidos.add(new Pedidos(249, 01, "Pantalón", 1));

        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file));
            printWriter.println("Id, Nombre, Email");
            for (Clientes clientes : listaClientes) {
                printWriter.println(clientes);
            }
            printWriter.println("Id, IdCliente, Producto, Cantidad");
            for (Pedidos pedidos : listaPedidos){
                printWriter.println((pedidos));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            printWriter.close();
        }
    }
    public void exportarObjetos (String path){
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes(01, "Juan Morote", "juan@gmail.com"));
        listaClientes.add(new Clientes(02, "Margarita Romero", "marga@gmail.com"));
        listaClientes.add(new Clientes(03, "Lucía Adiario", "lucia@gmail.com"));
        listaClientes.add(new Clientes(04, "Lara Mirez", "lara@gmail.com"));

        System.out.println("-----------------------------------");

        ArrayList<Pedidos> listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedidos(243, 01, "Camiseta", 2));
        listaPedidos.add(new Pedidos(244, 03, "Pantalón", 1));
        listaPedidos.add(new Pedidos(245, 02, "Jersey", 3));
        listaPedidos.add(new Pedidos(246, 01, "Bermudas", 3));
        listaPedidos.add(new Pedidos(247, 04, "Camisa", 2));
        listaPedidos.add(new Pedidos(248, 02, "Falda", 1));
        listaPedidos.add(new Pedidos(249, 01, "Pantalón", 1));

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            for (Clientes clientes : listaClientes){
                oos.writeObject(clientes);
            }

            for (Pedidos pedido : listaPedidos){
                oos.writeObject(pedido);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("No tienes permisos para escribir en el fichero");
        }finally{
            try {
                fos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }


    }


    //HE HECHO ESTE MÉTODO EXTRA
    public void exportarObjetosPedido(String path){
        File file = new File(path);
        if (!file.exists() || file.length() == 0) {
            System.out.println("El archivo no existe o está vacío");
            return;
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Pedidos pedido = null;

            while (true) {
                try {
                    pedido = (Pedidos) ois.readObject();
                    System.out.println(pedido.getId());
                    System.out.println(pedido.getClienteId());
                    System.out.println(pedido.getProducto());
                    System.out.println(pedido.getCantidad());
                    System.out.println("---");
                } catch (EOFException e) {
                    System.out.println("Fin del archivo");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no se encuentra");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally{
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }


    }



}
