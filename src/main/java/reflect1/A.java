package reflect1;

public class A {
    public void f1(){
        System.out.println("A's f1()");
    }
    public String f2(){
        System.out.println("A's f2()");
        return "hello f2";
    }
    public String f3(String info,int number){
        System.out.println("A's f3()");
        return "info:"+info+"number:"+number;
    }
}
