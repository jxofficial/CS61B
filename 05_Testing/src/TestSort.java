

public class TestSort {

    @org.junit.jupiter.api.Test
    /** Tests the Sort.sort method */
    public void testSort() {
        String[] input = {"7", "3", "5", "1"};
        String[] expected = {"1", "3", "5", "7"};

        Sort.sort(input);

        org.junit.jupiter.api.Assertions.assertArrayEquals(expected, input);
    }


    @org.junit.jupiter.api.Test
    public void testFindSmallestIndex() {
        String[] input = {"i", "have", "a", "pig"};
        int expectedIndex = 2;

        int actualIndex = Sort.findSmallestIndex(input, 0);

        org.junit.jupiter.api.Assertions.assertEquals(expectedIndex, actualIndex);
    }
    @org.junit.jupiter.api.Test
    public void testSwap() {
        int a = 0;
        int b = 2;

        String[] input = {"i", "have", "a", "pig"};
        String[] expected = {"a", "have", "i", "pig"};

        Sort.swap(input, a, b);

        org.junit.jupiter.api.Assertions.assertArrayEquals(expected, input);
    }


}
