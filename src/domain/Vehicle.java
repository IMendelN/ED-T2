package domain;

import java.util.Random;

public class Vehicle implements Comparable<Vehicle> {
    private int chassis;
    private String brand;

    private static int numVehicles = 0;
    private static Random chassisGenerator = new Random();
    private static Random brandGenerator = new Random();

    /**
     * Construtor da classe Vehicle.
     * Gera o número do chassis e a marca do veículo.
     */
    public Vehicle() {
        generateChassis();
        generateBrand();
    }

    /**
     * Gera o número do chassis do veículo.
     * O chassis é gerado aleatoriamente, dentro de uma faixa específica, com base
     * no número de veículos já criados.
     */
    private void generateChassis() {
        if (Vehicle.numVehicles % 2 == 0)
            this.chassis = 202050000 - chassisGenerator.nextInt(50000);
        else
            this.chassis = 202050000 + chassisGenerator.nextInt(50000);
        Vehicle.numVehicles++;
    }

    /**
     * Gera a marca do veículo.
     * A marca é escolhida aleatoriamente entre algumas opções pré-definidas.
     */
    private void generateBrand() {
        int c = brandGenerator.nextInt(7);
        switch (c) {
            case 0:
                this.brand = "Ford";
                break;
            case 1:
                this.brand = "Toyota";
                break;
            case 2:
                this.brand = "Chevrolet";
                break;
            case 3:
                this.brand = "Peugeot";
                break;
            case 4:
                this.brand = "Renault";
                break;
            case 5:
                this.brand = "Mazda";
                break;
            case 6:
                this.brand = "Lexus";
                break;
            default:
                new Exception("ERRO NA GERAÇÃO DA MARCA");
        }
    }

    /**
     * Retorna a marca do veículo.
     * 
     * @return a marca do veículo
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Retorna o número do chassis do veículo.
     * 
     * @return o número do chassis do veículo
     */
    public int getChassis() {
        return this.chassis;
    }

    /**
     * Verifica se o veículo pertence à marca Ford.
     * 
     * @return true se o veículo é da marca Ford, false caso contrário
     */
    public boolean isFordBrand() {
        return this.brand.equalsIgnoreCase("Ford");
    }

    /**
     * Implementação do método compareTo da interface Comparable.
     * Compara o número de chassis do veículo com outro veículo.
     * 
     * @param v o veículo a ser comparado
     * @return 0 se os chassis são iguais, 1 se o chassis deste veículo é maior, -1
     *         caso contrário
     */
    @Override
    public int compareTo(Vehicle v) {
        if (this.chassis > v.getChassis())
            return 1;
        else if (this.chassis < v.getChassis())
            return -1;
        else
            return 0;
    }

    /**
     * Retorna uma representação em string do veículo.
     * 
     * @return uma string com o número do chassis e a marca do veículo
     */
    @Override
    public String toString() {
        return "Veículo Chassi: " + this.chassis + " Marca: " + this.brand;
    }
}
