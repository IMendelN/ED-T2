import domain.Vehicle;
import maps.*;

public class Main {
    public static ListMap mapList = new ListMap();
    public static ArrayMap mapArray = new ArrayMap();
    public static TreeMap mapTree = new TreeMap();

    public static void main(String[] args) {
        long time[][] = new long[3][5];

        time[0][0] = System.nanoTime();
        fillMapArray(100000);
        time[0][1] = System.nanoTime();
        mapArray.printSorted();
        time[0][2] = System.nanoTime();
        mapArray.removeChassisLessOrEqual(202050000);
        time[0][3] = System.nanoTime();
        System.out.println(mapArray.getNumberOfFordBrand());
        time[0][4] = System.nanoTime();

        time[1][0] = System.nanoTime();
        fillMapList(100000);
        time[1][1] = System.nanoTime();
        mapList.printSorted();
        time[1][2] = System.nanoTime();
        mapList.removeChassisLessOrEqual(202050000);
        time[1][3] = System.nanoTime();
        System.out.println(mapList.getNumberOfFordBrand());
        time[1][4] = System.nanoTime();

        time[2][0] = System.nanoTime();
        fillMapTree(100000);
        time[2][1] = System.nanoTime();
        mapTree.printSorted();
        time[2][2] = System.nanoTime();
        mapTree.removeChassisLessOrEqual(202050000);
        time[2][3] = System.nanoTime();
        System.out.println(mapTree.getNumberOfFordBrand());
        time[2][4] = System.nanoTime();

        System.out.println("\n\n");
        System.out.println("Mapa: Vetor");

        System.out.printf("O tempo de preenchimento do vetor é de: %.3f segundos\n" , (float) (time[0][1] - time[0][0])/1000000000);
		System.out.printf("O tempo para printar o vetor de forma ordenada é de: %.3f segundos\n" , (float) (time[0][2] - time[0][1])/1000000000);
		System.out.printf("O tempo para remoção dos chassis do vetor é de: %.3f segundos\n" , (float) (time[0][3] - time[0][2])/1000000000);
		System.out.printf("O tempo para contar o numero de veiculos da marca Ford do vetor é de: %.3f segundos\n" , (float)(time[0][4] - time[0][3])/1000000000);
		System.out.printf("O tempo total de execução é de: %.3f segundos\n" , (float)(time[0][4] - time[0][0])/1000000000);

        System.out.println("\n\n");
        System.out.println("Mapa: Lista");

        System.out.printf("O tempo de preenchimento da lista é de: %.3f segundos\n" , (float) (time[1][1] - time[1][0])/1000000000);
		System.out.printf("O tempo para printar a lista de forma ordenada é de: %.3f segundos\n" , (float) (time[1][2] - time[1][1])/1000000000);
		System.out.printf("O tempo para remoção dos chassis da lista é de: %.3f segundos\n" , (float) (time[1][3] - time[1][2])/1000000000);
		System.out.printf("O tempo para contar o numero de veiculos da marca Ford da lista é de: %.3f segundos\n" , (float) (time[1][4] - time[1][3])/1000000000);
		System.out.printf("O tempo total de execução é de: %.3f segundos\n" , (float)(time[1][4] - time[1][0])/1000000000);
		
        System.out.println("\n\n");
        System.out.println("Mapa: Arvore");

        System.out.printf("O tempo de preenchimento da arvore é de: %.3f segundos\n" , (float) (time[2][1] - time[2][0])/1000000000);
		System.out.printf("O tempo para printar a arvore de forma ordenada é de: %.3f segundos\n" , (float) (time[2][2] - time[2][1])/1000000000);
		System.out.printf("O tempo para remoção dos chassis da arvore é de: %.3f segundos\n" , (float) (time[2][3] - time[2][2])/1000000000);
		System.out.printf("O tempo para contar o numero de veiculos da marca Ford da arvore é de: %.3f segundos\n" ,(float) (time[2][4] - time[2][3])/1000000000);
		System.out.printf("O tempo total de execução é de: %.3f segundos\n" , (float)(time[2][4] - time[2][0])/1000000000);
		
    }

    public static void fillMapArray(int number) {
        for (int i = 0; i < number; i++) {
            mapArray.put(new Vehicle());
        }
    }

    public static void fillMapList(int number) {
        for (int i = 0; i < number; i++) {
            mapList.put(new Vehicle());
        }
    }

    public static void fillMapTree(int number) {
        for (int i = 0; i < number; i++) {
            mapTree.put(new Vehicle());
        }
    }
}
