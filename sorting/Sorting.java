public class Sorting {

    /**
     * Does Bubble sort on integer array
     * @param numbers An numbers to sort
     */
    public static void bubbleSort(int[] numbers) {
        int swapNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[i] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapNumber++;
                }
            }
        }

        System.out.println(swapNumber);
        System.out.println("First Element: " +  numbers[0]);
        System.out.println("Last Element: " + numbers[numbers.length - 1]);
    }
}
