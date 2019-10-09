package com.yuruicai.test.common;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//循环引用 测试
public class Circlbe {
    static int i;
    @Data
    class A{
        private int aa;
        public void a(){
            System.out.println("A..."+i );
            count();
            new B().B();
        }

        public int getAa() {
            return aa;
        }

        public void setAa(int aa) {
            this.aa = aa;
        }
    }
    class B{
        public void B(){
            System.out.println("B..."+i);
            count();
            new C().C();
        }
    }
    class C{
        public void C(){
            System.out.println("C..."+i);
            count();
            new A().a();
        }
    }

    synchronized static void count(){
        i++;
    }
    public static void main(String[] args) {
        /*new Circlbe().new A().a();
        new Circlbe().new B().B();
        new Circlbe().new C().C();*/
        A a1 = new Circlbe().new A();
        a1.setAa(1);
        A a2 = new Circlbe().new A();
        a2.setAa(6);
        A a3 = new Circlbe().new A();
        a3.setAa(6);

        List<A> as = Arrays.asList(a1, a2, a3);
        String s1 = as.stream().filter(x -> x.getAa() > 1).map(A::getAa).toString();
        System.out.println(s1);
        Stream<A> s = as.stream().filter(x -> x.getAa() > 1).distinct();
        System.out.println(s);

    }
}
