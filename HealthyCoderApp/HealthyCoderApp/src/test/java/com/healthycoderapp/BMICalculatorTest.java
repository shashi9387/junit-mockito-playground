package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {
    @Test
    void should_ReturnTrue_When_DietRecommended(){
//        assertTrue(BMICalculator.isDietRecommended(100,1.72));
        // given
        double weight = 80;
        double height = 1.73;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        //then
        assertTrue(recommended);
    }
    @Test
    void should_ReturnFalse_When_DietNotRecommended(){
//        assertFalse(BMICalculator.isDietRecommended(50,1.72));
        // given
        double weight = 50;
        double height = 1.73;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        //then
        assertFalse(recommended);
    }
    @Test
    void should_Through_Arithmetic_Exception_When_Height_Zero(){
        //given
        double weight= 50;
        double height = 0;
        //when
        Executable execute = () -> BMICalculator.isDietRecommended(weight,height);
        //then
        assertThrows(ArithmeticException.class,execute);
    }
    @Test
    void should_return_CoderWithWorshBMI_When_CoderListisNotEmpty(){
        List<Coder> coder = new ArrayList<>();
        coder.add(new Coder(1.85,60));
        coder.add(new Coder(1.88,65));
        coder.add(new Coder(1.9,70));

        Coder worstBMI = BMICalculator.findCoderWithWorstBMI(coder);
        assertAll(
                () -> assertEquals(1.9,worstBMI.getHeight()),
                () -> assertEquals(70,worstBMI.getWeight())
                );
    }
    @Test
    void should_return_Null_When_BMICoderListisEmpty(){
        List<Coder> coder = new ArrayList<>();

        Coder worstBMI = BMICalculator.findCoderWithWorstBMI(coder);
        assertNull(worstBMI);
    }
    @Test
    void should_return_BMIScore_When_CoderListIsNotEmpty(){
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.85,60));
        coders.add(new Coder(1.88,65));
        coders.add(new Coder(1.9,70));
        double[] expected = {17.53,18.39,19.39};

        double[] bmiScore = BMICalculator.getBMIScores(coders);

        assertArrayEquals(expected,bmiScore);
    }

}