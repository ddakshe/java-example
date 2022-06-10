package com.kennen.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecommendId2Test {
    @Test
    void test() {
        String newId = "...!@BaT#*..y.abcdefghij k l m.";
//        String newId = "z-+.^.";

        String id = new NewId(newId)
                .step1()
                .step2()
                .step3()
                .step4()
                .step5()
                .step6()
                .step7()
                .step8()
                .getId();

        Assertions.assertEquals("bat.y.abcdefghi", id);


    }

    static class NewId{
        private String id;

        public String getId(){
            return id;
        }

        public NewId(String id){
            this.id = id;
        }

        public NewId step1(){
            id = id.toLowerCase();
            return this;
        }

        public NewId step2(){
            id = id.replaceAll("[^\\da-z-_.]", "");
            return this;
        }

        public NewId step3(){
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }

        public NewId step4(){
            id = id.replaceAll("^[.]+", "");
            return this;
        }

        public NewId step5(){
            if (id.isBlank()) {
                id = "a";
            }
            return this;
        }

        public NewId step6(){
            if (id.length() > 15) {
                id = id.substring(0,15);
            }
            return this;
        }

        public NewId step7(){
            id = id.replaceAll("[.]+$", "");
            return this;
        }

        public NewId step8(){
            StringBuilder builder = new StringBuilder(id);
            while(builder.length() < 3){
                builder.append(id.charAt(id.length() - 1));
            }
            id = builder.toString();
            return this;
        }
    }
}
