package com.giseggi.misc.util;

import com.giseggi.misc.entity.Entity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MiscUtilTest {

    @Autowired
    private MiscUtil miscUtil;

    @Test
    void dedupTest() {
        List<Entity> list = new ArrayList<>();
        Entity entity1 = Entity.builder().id1(111L).id2(1111L).build();
        Entity entity2 = Entity.builder().id1(222L).id2(2L).build();
        Entity entity3 = Entity.builder().id1(333L).id2(3333L).build();
        Entity entity4 = Entity.builder().id1(444L).id2(4444L).build();
        Entity entity5 = Entity.builder().id1(555L).id2(5555L).build();
        Entity entity6 = Entity.builder().id1(555L).id2(6666L).build();
        Entity entity7 = Entity.builder().id1(555L).id2(7777L).build();
        Entity entity8 = Entity.builder().id1(333L).id2(8888L).build();
        Entity entity9 = Entity.builder().id1(222L).id2(222L).build();

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);
        list.add(entity9);

        List<Entity> result = miscUtil.deduplication(list, Entity::getId1);

        assertEquals(result.get(0).getId1(), 111L);
        assertEquals(result.get(0).getId2(), 1111L);
        assertEquals(result.get(1).getId1(), 222L);
        assertEquals(result.get(1).getId2(), 2L);
        assertEquals(result.get(2).getId1(), 333L);
        assertEquals(result.get(2).getId2(), 3333L);
        assertEquals(result.get(3).getId1(), 444L);
        assertEquals(result.get(3).getId2(), 4444L);
        assertEquals(result.get(4).getId1(), 555L);
        assertEquals(result.get(4).getId2(), 5555L);
    }

}