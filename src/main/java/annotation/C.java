package annotation;

public class C {
    public void f1(){
        System.out.println("C's f1()");
    }
    @Test(value = "haha")
    public void f2(){
        System.out.println("C's f2()");
    }

    public void hello(){
        System.out.println("C's hello()");
    }
}
