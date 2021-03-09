package com.keqi.grid.sys.util;

import com.keqi.grid.sys.domain.db.DictItemDO;
import com.keqi.grid.sys.mapper.DictItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DictUtil implements CommandLineRunner {

    @Autowired
    private DictItemMapper dictItemMapper;

    private static Map<String, List<DictItemDO>> typeCodeMap;
    private static Map<String, DictItemDO> itemCodeMap;

    @Override
    public void run(String... args) throws Exception {
        List<DictItemDO> itemDOList = this.dictItemMapper.findAll();
        typeCodeMap = itemDOList.stream().collect(Collectors.groupingBy(DictItemDO::getTypeCode));
        itemDOList.forEach(x -> itemCodeMap.put(x.getItemCode(), x));
    }

    public static String findItemName(String itemCode) {
        DictItemDO t = itemCodeMap.get(itemCode);
        return t == null ? null : t.getItemName();
    }

    public List<DictItemDO> findByTypeCode(String typeCode) {
        List<DictItemDO> itemDOList = typeCodeMap.get(typeCode);
        return itemDOList == null ? Collections.emptyList() : itemDOList;
    }
}
