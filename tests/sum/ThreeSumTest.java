package sum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by renguifu on 2017/1/23.
 */
public class ThreeSumTest {
    int[] sums = {-1, 0, 1, 2, -1, -4};
    private ThreeSum ts;
    @Before
    public void setUp() throws Exception {
        ts = new ThreeSum();
    }

    @Test
    public void threeSum() throws Exception {
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(-1,-1,2));
        result.add(Arrays.asList(-1,0,1));
        assertEquals(result,ts.threeSum(sums));
    }

}