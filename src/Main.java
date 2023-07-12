import domain.Vehicle;
import maps.*;

public class Main {
    //Criação dos mapas
    public static ListMap mapList = new ListMap();
    public static ArrayMap mapArray = new ArrayMap();
    public static TreeMap mapTree = new TreeMap();

    public static void main(String[] args) {
        //Uso de matriz para relacionar as funções e mapas com o tempo.
        long time[][] = new long[3][5];
        //Tempo do mapa de Vetor 
        time[0][0] = System.nanoTime();
        fillMapArray(100000);
        time[0][1] = System.nanoTime();
        mapArray.printSorted();
        time[0][2] = System.nanoTime();
        mapArray.removeChassisLessOrEqual(202050000);
        time[0][3] = System.nanoTime();
        System.out.println(mapArray.getNumberOfFordBrand());
        time[0][4] = System.nanoTime();
        //Tempo do mapa de Lista
        time[1][0] = System.nanoTime();
        fillMapList(100000);
        time[1][1] = System.nanoTime();
        mapList.printSorted();
        time[1][2] = System.nanoTime();
        mapList.removeChassisLessOrEqual(202050000);
        time[1][3] = System.nanoTime();
        System.out.println(mapList.getNumberOfFordBrand());
        time[1][4] = System.nanoTime();
        //Tempo do mapa de Arvore
        time[2][0] = System.nanoTime();
        fillMapTree(100000);
        time[2][1] = System.nanoTime();
        mapTree.printSorted();
        time[2][2] = System.nanoTime();
        mapTree.removeChassisLessOrEqual(202050000);
        time[2][3] = System.nanoTime();
        System.out.println(mapTree.getNumberOfFordBrand());
        time[2][4] = System.nanoTime();

        //Tabela com os tempos de cada função de cada mapa.
        System.out.println("\n\n");
        System.out.println("Mapa:            Vetor  ------------------  Lista  ------------------  Arvore");
        System.out.printf("Preencher:    %.3f segundos     |     %.3f segundos     |     %.3f segundos     |\n",(float) (time[0][1] - time[0][0])/1000000000,(float) (time[1][1] - time[1][0])/1000000000,(float) (time[2][1] - time[2][0])/1000000000);
        System.out.printf("Exibir:       %.3f segundos     |     %.3f segundos     |     %.3f segundos     |\n",(float) (time[0][2] - time[0][1])/1000000000,(float) (time[1][2] - time[1][1])/1000000000,(float) (time[2][2] - time[2][1])/1000000000);
        System.out.printf("Remover:      %.3f segundos     |     %.3f segundos     |     %.3f segundos     |\n",(float) (time[0][3] - time[0][2])/1000000000,(float) (time[1][3] - time[1][2])/1000000000,(float) (time[2][3] - time[2][2])/1000000000);
        System.out.printf("Contar:       %.3f segundos     |     %.3f segundos     |     %.3f segundos     |\n",(float) (time[0][4] - time[0][3])/1000000000,(float) (time[1][4] - time[1][3])/1000000000,(float) (time[2][4] - time[2][3])/1000000000);
        System.out.printf("Total:        %.3f segundos     |     %.3f segundos     |     %.3f segundos     |\n",(float) (time[0][4] - time[0][0])/1000000000,(float) (time[1][4] - time[1][0])/1000000000,(float) (time[2][4] - time[2][0])/1000000000);
		
    }

    //Funções de preenchimento dos mapas
    //Preenche o mapa de Vetor
    public static void fillMapArray(int number) {
        for (int i = 0; i < number; i++) {
            mapArray.put(new Vehicle());
        }
    }
    //preenche o mapa de Lista
    public static void fillMapList(int number) {
        for (int i = 0; i < number; i++) {
            mapList.put(new Vehicle());
        }
    }
    //preenche o mapa de Arvore
    public static void fillMapTree(int number) {
        for (int i = 0; i < number; i++) {
            mapTree.put(new Vehicle());
        }
    }
}
