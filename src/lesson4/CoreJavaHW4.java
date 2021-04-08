package lesson4;

import lesson4.model.Computer;
import lesson4.model.Cup;

public class CoreJavaHW4 {
    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.setBrand("Dell");
        comp.setModel("XPS-13");
        comp.setManufacturingYear(2020);
        comp.setOperatingSystem("Windows 10");
        comp.setLaptop(true);


        comp.printBrandModel();

        Cup c = new Cup();
        c.setItemWeight(100);
        c.setMaterial("Plastic");
        c.setColor("White");
        c.setBPAFree(false);

        System.out.println("Don't spill" + c.getMaterial() + c.getColor()
                + " cup filled with coffee on your "
                + comp.getBrand() + " " + comp.getModel() + "!");
    }
}
