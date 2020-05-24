package services;

public class ContainerCreationService {

    public int[][] create(int length, int width) {
        int[][] array = new int[length + 2][width + 2];
        for (int i = 0; i < length + 1; i++){
            for (int j = 0; j <= width + 1; j++){
                array[length + 1][j] = 8;
                array[0][j] = 8;
            }
            array[i][width + 1] = 8;
            array[i + 1][0] = 8;
        }
        return array;
    }
}