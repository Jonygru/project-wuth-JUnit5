package ru.ibs.appline.data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataClass {
    public static Stream<Arguments> argForFirstParametrazedTests(){
        return Stream.of(
                Arguments.of("Vb[fqkj","764564643","qwertyqwerty","dfsdfgsdfgsdfg"),
                Arguments.of("Михайло","856675664","qwertyqwerty","dfsdfgsdfgsdfg"),
                Arguments.of("Иванов Иван Иванович","475445677","qwertyqwerty","dfsdfgsdfgsdfg")
        );
    }

}
