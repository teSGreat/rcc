package blr.tg.rcc.r3.a;

import org.junit.Test;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Uleychik_SA on 06.05.2017.
 */
public class ExcelKillerTest {

    static ExcelKiller ek = new ExcelKiller();

    @Test
    public void getColNameByNumber_input_1() throws Exception {
        assertEquals("A", ek.getColNameByNumber(1));
    }

    @Test
    public void getColNameByNumber_input_26() throws Exception {
        assertEquals("Z", ek.getColNameByNumber(26));
    }

    @Test
    public void getColNameByNumber_input_27() throws Exception {
        assertEquals("AA", ek.getColNameByNumber(27));
    }

    @Test
    public void getColNameByNumber_input_26_plus_26() throws Exception {
        assertEquals("AZ", ek.getColNameByNumber(26 + 26));
    }

    @Test
    public void getColNameByNumber_input_26_plus_26x26() throws Exception {
        assertEquals("ZZ", ek.getColNameByNumber(26 + 26 * 26));
    }

    @Test
    public void getColNameByNumber_input_file() throws Exception {

        Scanner sc = new Scanner(ExcelKillerTest.class.getResourceAsStream("/02"));
        int[] nums = new int[sc.nextInt()];
        int i = 0;
        while (sc.hasNextInt()) {
            nums[i] = sc.nextInt();
            i++;
        }
        sc = null;

        String[] answers = new String[nums.length];
        for (int j = 0; j < nums.length; j++) {
            answers[j] = ek.getColNameByNumber(nums[j]);
        }
        // loading default answers
        String[] example = new String[nums.length];
        sc = new Scanner(ExcelKillerTest.class.getResourceAsStream("/02.a"));
        int j = 0;
        while (sc.hasNextLine()) {
            example[j] = sc.nextLine();
            j++;
        }

        assertArrayEquals(example, answers);
    }

}