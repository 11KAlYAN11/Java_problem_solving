package Arrays;
class Data {
    int value;
}

public class CallByReference { 
    public static void main(String[] args) {
        Data obj = new Data();
        obj.value = 10;
        System.out.println("Before the mtd call: "+obj.value);
        modifyObject(obj);
        System.out.println("After mtd call: "+obj.value);
    }

    public static void modifyObject(Data d) {
        d.value += 5;
    }

    // So when we pass the ref of that value it effect the org data
}
