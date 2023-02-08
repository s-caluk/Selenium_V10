
/*
kücük sayidan büyüge öncelik sirasi vardir: -2 -1 0 3 5...
öncelik sirasi ayni ise isim sirasi baz alinir.
hic bir sey yazilmamissa priority 0 dir.
 */
package video09_testNGFramework;

import org.testng.annotations.Test;

public class C02_Priority {


    @Test(priority = 3)
    public void test01(){
        System.out.println("Test 01");
    }

    @Test(priority = -3)
    public void test02(){
        System.out.println("Test 02");
    }
    @Test
    public void test03(){
        System.out.println("Test 03");
    }
}
