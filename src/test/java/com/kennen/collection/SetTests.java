package com.kennen.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTests {
    @Test
    void testInteger() {

        Set<Integer> setOfInteger = new HashSet<>();
        setOfInteger.add(1);
        setOfInteger.add(1);
        setOfInteger.add(1);
        setOfInteger.add(1);
        Assertions.assertEquals(setOfInteger.size(), 1);
    }

    @Test
    void testUser() {
        Set<User> users = new HashSet<>();
        users.add(new User("Kennen", 37));
        users.add(new User("Kennen", 37));
        users.add(new User("Kennen", 37));
        users.add(new User("Kennen", 37));
        Assertions.assertEquals(users.size(), 1);
    }

    @AllArgsConstructor
    @Getter @Setter
    static class User{
        private String name;
        private Integer age;

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            User user = (User) o;
//            return Objects.equals(name, user.name) && Objects.equals(age, user.age);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(name, age);
//        }
    }
}
