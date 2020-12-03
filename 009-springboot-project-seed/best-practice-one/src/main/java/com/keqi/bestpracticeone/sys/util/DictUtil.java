package com.keqi.bestpracticeone.sys.util;

import com.keqi.bestpracticeone.sys.domain.vo.DictItemVO;
import com.keqi.bestpracticeone.sys.mapper.DictItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 程序启动后读取 sys_dict_item 表中的所数据，并存储在内存中
 *
 * @author keqi
 */
@Component
public class DictUtil implements CommandLineRunner {

    private static Map<String, List<DictItemVO>> dictMap;

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public void run(String... args) {
        dictMap = new HashMap<>();
        List<DictItemVO> dictItemVOS = this.dictItemMapper.listAll();
        dictMap = dictItemVOS.stream().collect(Collectors.groupingBy(DictItemVO::getTypeCode));
    }

    /**
     * 根据 typeCode 获取对应的 DictItemVO 列表
     *
     * @param typeCode typeCode
     * @return r
     */
    public static List<DictItemVO> listDictItem(String typeCode) {
        return dictMap.get(typeCode);
    }


    /**
     * 根据 typeCode 和 itemCode 获取对应的 DictItemVO
     *
     * @param typeCode typeCode
     * @param itemCode itemCode
     * @return r
     */
    public static DictItemVO getDictItem(String typeCode, String itemCode) {
        List<DictItemVO> dictItemVOS = dictMap.get(typeCode);
        for (DictItemVO t : dictItemVOS) {
            if (Objects.equals(itemCode, t.getItemCode())) {
                return t;
            }
        }
        return null;
    }

    /**
     * 根据 typeCode 和 itemCode 获取对应的 ItemName
     *
     * @param typeCode typeCode
     * @param itemCode itemCode
     * @return r
     */
    public static String getItemName(String typeCode, String itemCode) {
        DictItemVO dictItemVO = getDictItem(typeCode, itemCode);
        return dictItemVO == null ? null : dictItemVO.getItemName();
    }

    /**
     * 查询系统内所有字典数据
     *
     * @return r
     */
    public static Map<String, List<DictItemVO>> getDictMap() {
        return dictMap;
    }
}
