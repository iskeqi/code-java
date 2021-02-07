package com.keqi.springbootmybatisbase;

import com.keqi.springbootmybatisbase.sys.domain.db.MenuDO;
import com.keqi.springbootmybatisbase.sys.domain.param.MenuPageParam;
import com.keqi.springbootmybatisbase.sys.domain.vo.MenuVO;
import com.keqi.springbootmybatisbase.sys.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootMybatisBaseApplicationTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void insert() {
        MenuDO menuDO = new MenuDO();
        menuDO.setName("产品管理");
        System.out.println(this.menuMapper.insert(menuDO));
    }

    @Test
    void insertList() {
        MenuDO menuDO1 = new MenuDO();
        menuDO1.setName("产品管理");

        MenuDO menuDO2 = new MenuDO();
        menuDO2.setName("设备管理");

        List<MenuDO> list = new ArrayList<>();
        list.add(menuDO1);
        list.add(menuDO2);

        System.out.println(this.menuMapper.insertList(list));
    }

    @Test
    void updateById() {
        MenuDO menuDO1 = new MenuDO();
        menuDO1.setName("产品管理15");
        menuDO1.setId(15L);

        System.out.println(this.menuMapper.updateById(menuDO1));
    }

    @Test
    void update() {
        MenuDO menuDO1 = new MenuDO();
        menuDO1.setName("产品管理");

        MenuDO menuDO2 = new MenuDO();
        menuDO2.setName("产品管理15");

        System.out.println(this.menuMapper.update(menuDO1, menuDO2));
    }

    @Test
    void deleteById() {
        System.out.println(this.menuMapper.deleteById(15L));
    }

    @Test
    void delete() {
        MenuDO menuDO = new MenuDO();
        menuDO.setName("设备管理");
        System.out.println(this.menuMapper.delete(menuDO));
    }

    @Test
    void deleteByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(18L);
        ids.add(19L);
        System.out.println(this.menuMapper.deleteByIds(ids));
    }

    @Test
    void findById() {
        MenuDO byId = this.menuMapper.findById(16);
        System.out.println(byId);
    }

    @Test
    void find() {
        MenuDO menuDO = new MenuDO();
        menuDO.setName("设备管理1");
        MenuDO menuDO1 = this.menuMapper.find(menuDO);
        System.out.println(menuDO1);
    }

    @Test
    void findByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(21L);
        ids.add(22L);

        List<MenuDO> byIds = this.menuMapper.findByIds(ids);
        byIds.forEach(MenuDO::toString);
    }

    @Test
    void findList() {
        MenuDO menuDO = new MenuDO();
        menuDO.setName("产品管理");
        List<MenuDO> list = this.menuMapper.findList(menuDO);
        for (MenuDO menuDO1 : list) {
            System.out.println(menuDO1);
        }
    }

    @Test
    void page() {
        MenuPageParam param = new MenuPageParam();
        List<MenuVO> page = this.menuMapper.page(param);

        page.forEach(MenuVO::toString);
    }
}
