package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = mergeArrays(this.array, arrayToMerge);
        Integer max = 0;
        T mostCommon = null;
        for (T t: mergedArray) {
            if(Collections.frequency(Arrays.asList(mergedArray), t) > max){
                mostCommon = t;
                max = Collections.frequency(Arrays.asList(mergedArray), t);
            }
        }
        return mostCommon;
    }

    private T[] mergeArrays(T[] array1, T[] array2) {
        Integer newLength = array1.length + array2.length;
        T[] mergedArray = Arrays.copyOf(array1, newLength);
        for (int i = 0; i < array2.length; i++) {
            mergedArray[array1.length+i] = array2[i];
        }
        return mergedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(this.array, arrayToMerge);

        return Collections.frequency(Arrays.asList(mergedArray), valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        Integer index = 0;
        Integer count = Collections.frequency(Arrays.asList(this.array), valueToRemove);
        T[] t = Arrays.copyOf(this.array, this.array.length-count);
        for (int i = 0; i < array.length; i++) {
            if(this.array[i].equals(valueToRemove)){
                this.array[i] = null;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(this.array[i] != null){
                t[index] = this.array[i];
                index++;
            }
        }
        return t;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return Collections.frequency(Arrays.asList(this.array), valueToEvaluate);
    }
}
