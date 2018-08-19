package pub.ustar.mybatisplugin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pub.ustar.mybatisplugin.dao.bean.Test;
import pub.ustar.mybatisplugin.dao.mapper.TestMapper;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("select")
    public Test select(@RequestParam int id){
        return testMapper.selectById(id);
    }

    @RequestMapping("insert")
    public int insert(@RequestParam int id, @RequestParam int version){
        return testMapper.insert(id, version);
    }
}
