package com.yuruicai.test.server.springcloud;

public class Test {
    public static void main(String [] args){
        Test test = new Test();
        //System.out.println(instance.isAbcbA("abcefg"));
        String str = "我abc汉def";
        System.out.println(str.substring(0,4));
        System.out.println(test.StringCutByByte(str, 2));
    }

    public boolean isAbcbA(String str){
        while(str.length() > 1){
            int length = str.length();
            char first = str.charAt(0);
            char last = str.charAt(length - 1);
            if(first == last){
                String strcpy = str.substring(1, length - 1);
                System.out.println(strcpy);
                isAbcbA(strcpy);
            }else{
                return false;
            }
            //不加break,就会进入死循环,因为退出循环也是一层一层的。做改错题肯定有意思。
            break;
        }
        return true;
    }
    public String StringCutByByte(String str, int index){
        String temp = null;
        byte [] bytes = str.getBytes();
        byte [] bytetemp = new byte[index];
        for(int i=0; i<index ; i++ ){
            bytetemp[i] = bytes[i];
            System.out.println(bytes[i]);
        }
        if(index>1){
            if(bytes[index-1]<0&&bytes[index-2]>0){
                //第三个参数表示要解码的字节数
                temp = new String(bytetemp,0,index-1);
            }else{
                temp = new String(bytetemp);
            }
        }else{
            if(bytes[index-1]<0){
                temp = null;
            }else
                temp = new String(bytetemp,0,1);
        }

        return temp;
    }

}
