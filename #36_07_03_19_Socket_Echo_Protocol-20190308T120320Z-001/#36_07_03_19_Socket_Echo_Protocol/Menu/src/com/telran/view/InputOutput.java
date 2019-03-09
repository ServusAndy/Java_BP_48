package com.telran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public interface InputOutput {
    String readString(String prompt);
    void write(Object obj);

    default void writeln(Object obj){
        write(obj + "\n");
    }

    default <R> R readObject(String prompt, String error, Function<String, R> mapper){
        while(true){
            String line = readString(prompt);
            try {
                return mapper.apply(line);
            }catch (RuntimeException ex){
                writeln(error);
            }
        }
    }

    default int readInt(String prompt){
        return readObject(prompt,"It's not a number!",Integer::parseInt);
    }

    default int readInt(String prompt, int min, int max){
        return readObject(prompt, String.format("It's not int in range [%d,%d]",min,max), s -> {
            int val = Integer.parseInt(s);
            if(val < min && val > max){
                throw new NumberFormatException();
            }
            return val;
        });
    }

    default long readLong(String prompt){
        return readObject(prompt,"It's not a long number!",Long::parseLong);
    }

    default double readDouble(String prompt){
        return readObject(prompt,"It's not a number",Double::parseDouble);
    }

    default LocalDate readDate(String prompt, String format){
        return readObject(prompt +"[" + format +"]","Wrong date format!", s -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDate.parse(s,formatter);
        });
    }
}
