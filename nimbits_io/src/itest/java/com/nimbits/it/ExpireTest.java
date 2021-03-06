package com.nimbits.it;

import com.nimbits.client.enums.FilterType;
import com.nimbits.client.model.point.Point;
import com.nimbits.client.model.point.PointModel;
import com.nimbits.client.model.value.Value;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ExpireTest extends NimbitsTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();


    }

    @Test
    public void executeIdleSetTest() throws InterruptedException {

        String pointName = UUID.randomUUID().toString();
        int c = 1000;
        int e = 9000;


        Point point = nimbits.addPoint(user, new PointModel.Builder()
                .name(pointName).expire(e).create());

        Random random = new Random();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, e * -1);
        for (int i = 0; i < c; i++) {


            nimbits.recordValueSync(pointName, new Value.Builder().timestamp(calendar.getTimeInMillis() - random.nextInt(10000000)).doubleValue(random.nextDouble() * 100).create());

        }

        List<Value> valueList = nimbits.getValues(point, c);
        for (Value vx : valueList) {
            System.out.println(vx.getDoubleValue() + vx.getTimestamp().toString());
        }
        assertEquals(0, valueList.size());



        for (int i = 0; i < c; i++) {


            nimbits.recordValueSync(pointName, new Value.Builder().timestamp(System.currentTimeMillis()-c).doubleValue(random.nextDouble() * 100).create());

        }

        List<Value> valueList1 = nimbits.getValues(point, c);
        for (Value vx : valueList1) {
            System.out.println(vx.getDoubleValue() + vx.getTimestamp().toString());
        }
        assertEquals(c, valueList1.size());


    }
}
