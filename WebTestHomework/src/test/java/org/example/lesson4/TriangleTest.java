package org.example.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @Disabled("Тест не входит в итоговый проект")
    @Tag("positiveTest")
    void test1() throws MyNotTriangleException{
        logger.info("Тест1 запущен");
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6, triangle.getTriangleArea(3,4,5));
        logger.info("Тест1 завершен успешно");
    }

    @Test
    @Disabled("Тест не входит в итоговый проект")
    @Tag("negativeTest")
    @DisplayName("Значение стороны треугольника меньше 0")
    void test2() throws MyNotTriangleException{
        logger.info("Тест2 запущен");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyNotTriangleException.class,() -> triangle.getTriangleArea(-1,4,5));
        logger.info("Тест2 завершен успешно");
    }

    @Test
    @Disabled("Тест не входит в итоговый проект")
    @Tag("negativeTest")
    @DisplayName("Значение стороны треугольника равно 0")
    void test3() throws MyNotTriangleException{
        logger.info("Тест3 запущен");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyNotTriangleException.class,() -> triangle.getTriangleArea(0,4,5));
        logger.info("Тест3 завершен успешно");
    }

    @Test
    @Disabled("Тест не входит в итоговый проект")
    @Tag("negativeTest")
    @DisplayName("Недопустимость существования треугольника с текущими сторонами")
    void test4() throws MyNotTriangleException{
        logger.info("Тест4 запущен");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyNotTriangleException.class,() -> triangle.getTriangleArea(10,4,5));
        logger.info("Тест4 завершен успешно");
    }

    @ParameterizedTest
    @Disabled("Тест не входит в итоговый проект")
    @Tag("positiveTest")
    @CsvSource({"4,5,3,6","5,3,4,6"})
    void test5 (int a, int b, int c, int s) throws MyNotTriangleException{
        Triangle triangle = new Triangle();
        Assertions.assertEquals(s, triangle.getTriangleArea(a,b,c));
    }

}