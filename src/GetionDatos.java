public class GetionDatos {

    public static void main(String[] args) {
        Metodos consultas = new Metodos();

        consultas.escribirCsv("src\\resources\\escribirDatos.csv");
        consultas.exportarObjetos("src\\resources\\exportarObjetos.obj");



    }
}
