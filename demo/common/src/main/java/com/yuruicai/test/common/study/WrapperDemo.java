package com.yuruicai.test.common.study;

public class WrapperDemo {
    public static void main(String[] args) {

    }
    class MemoryCell{
        public  Object read(){
            return storedValue;
        }
        public void write(Object x){
            this.storedValue = x;
        }
        private Object storedValue;
    }
}
