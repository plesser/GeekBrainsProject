package homework_14;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkApp14Test {

    private HomeWorkApp14 hw;

    @BeforeEach
    void startUp(){
        System.out.println("Hello world!");
        hw = new HomeWorkApp14();
    }

    @AfterEach
    void finished(){
        System.out.println("Goodbye cruel world!");
    }


    @BeforeAll
    static void startFirst(){
        System.out.println("START TEST");
    }

    @AfterAll
    static void finishLast(){
        System.out.println("STOP TEST");
    }

    @DisplayName("Тест поиска в массиве сепаратора, что бы сумма была одинакова слева и справа")
    @Test
    void testCheckArray_1(){
        Assertions.assertEquals(true, hw.checkArray(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
    }

    @DisplayName("Тест поиска в массиве сепаратора, что бы сумма была одинакова слева и справа")
    @Test
    void testCheckArray_2(){
        Assertions.assertEquals(true, hw.checkArray(new int[]{1, 1, 1, 1, 4}));
    }

    @DisplayName("Тест поиска в массиве сепаратора, что бы сумма была одинакова слева и справа")
    @Test
    void testCheckArray_3(){
        HomeWorkApp14 hw = new HomeWorkApp14();
        Assertions.assertEquals(false, hw.checkArray(new int[]{2, 1, 1, 2, 5}));
    }

    @DisplayName("Тест сдвига массива влево")
    @Test
    void testShiftArray_1(){
        HomeWorkApp14 hw = new HomeWorkApp14();
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 1, 2} ,hw.shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -2));

    }

    @DisplayName("Тест сдвига массива вправо")
    @Test
    void testShiftArray_2(){
        HomeWorkApp14 hw = new HomeWorkApp14();
        Assertions.assertArrayEquals(new int[]{7, 8, 1, 2, 3, 4, 5, 6} ,hw.shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2));
    }
}