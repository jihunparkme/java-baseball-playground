package test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class assertjTest {

    public class Dog {
        private String name;
        private Float weight;

        public Dog(String name, Float weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public Float getWeight() {
            return weight;
        }
    }

    @Test
    void test() {
        assertThat(true);
    }

    @Test
    void objectTest() {
        Dog fido = new Dog("Fido", 5.25F);
        Dog fidosClone = new Dog("Fido", 5.25F);

        assertThat(fido).isNotSameAs(fidosClone);
        assertThat(fido).usingRecursiveComparison().isEqualTo(fidosClone);
    }

    @Test
    void booleanTest() {
        assertTrue("".isEmpty());
    }

    @Test
    void arrayTest() {
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");
        assertThat(list).isNotEmpty();
        assertThat(list).startsWith("1");
    }

    @Test
    void arrayTest2() {
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3");
    }

    @Test
    void characterTest() {
        assertThat("s")
                .isNotEqualTo("b")
                .inUnicode()
                .isGreaterThanOrEqualTo("c")
                .isLowerCase();
    }

    @Test
    void classTest() {
        assertThat(Runnable.class).isInterface();
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }

    @Test
    void fileTest() {
        assertThat(new File("/Users/aaron/Desktop/capture/test.jpeg"))
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    @Test
    void doubleTest() {
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
    }

    @Test
    void mapTest() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        assertThat(map)
                .isNotEmpty()
                .containsKey(2)
                .doesNotContainKeys(10)
                .contains(entry(1, "a"));
    }

    @Test
    void throwableTest() {
        Exception ex = new NullPointerException("This is Null Point exception");
        assertThat(ex)
                .hasNoCause()
                .hasMessageEndingWith("n")
                .hasMessageContaining("exception");
    }

    @Test
    void describingTest() {
        Dog puppy = new Dog("Puppy", 5.25F);

        assertThat(puppy.getWeight())
                .as("%s's weight should be equal to 5.25", puppy.getName())
                .isEqualTo(5.25F);
    }

    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {"abc".charAt(3);})
                .withMessage("String index out of range: %s", "3")
                .withMessageContaining("index out of")
                .withNoCause();

        assertThatIOException().isThrownBy(() -> { throw new IOException("boom!"); })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();

        assertThatCode(() -> {
            "abc".charAt(2);
        }).doesNotThrowAnyException();
    }
}
