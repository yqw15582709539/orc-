package com.example.orc.Control;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.ExcelUtil;
import com.example.demo.HttpURLConnectionDemo;
import com.example.demo.Kd;
import com.example.orc.util.Animal;
import com.example.orc.util.HttpUtil;
import com.example.orc.util.Idcard;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrcControl {
    public static List<Map<String, String>> list = new ArrayList<>();

    static {
//        StringBuilder filePath = new StringBuilder();
//        filePath.append(System.getProperty("user.dir")).append("\\src\\main\\resources\\aaa.xlsx");
        String filePath ="D:\\aaa.xlsx";
        String columns[] = {"name", "adcode", "citycode"};
        try {
            list = new ExcelUtil().getExcelData(filePath, columns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "/yb")
    public String yb(@RequestBody Map<String, Object> map) {
        String url = "http://www.kuaidi100.com/query?type=" + map.get("type") + "&postid=" + map.get("number");
//        String url = "https://www.kuaidi100.com/chaxun?com="+map.get("type")+"&nu="+map.get("number")+"";
        String s = HttpURLConnectionDemo.doGet(url);

        return s;
    }

    @GetMapping(value = "/tq")
    public Map<Object, Object> tq(@RequestParam(value = "code") String code) throws IOException {
        if (code != null) {
            String s = new HttpURLConnectionDemo().doGet("https://restapi.amap.com/v3/weather/weatherInfo?city=" + code + "&key=4790b7c8b3290c65ad638f4b73a35a19");
            Gson gson = new Gson();
            Map<Object, Object> map = gson.fromJson(s, HashMap.class);
            return map;
        }
        return null;
    }

    @GetMapping(value = "/zg")
    public List<Map<String, String>> zg() throws IOException {
//        String filePat = "D:\\aaa.xlsx";
//        String columns[] = {"name", "adcode", "citycode"};
//        list = new ExcelUtil().getExcelData(filePat, columns);
        return list;
    }

    @PostMapping(value = "/imgUpload")
    public Map<Object, Object> imgUpload(@RequestParam("file") MultipartFile file) {
        try {
            //获取上传文件名
            String originalFilename = file.getOriginalFilename();
            File file1 = new File("C:\\image\\" + originalFilename);
            if (!file1.exists()) {
                file1.mkdirs();
                //保存文件
                file.transferTo(file1);
            }
            String idcard = Idcard.idcard(file1.toString());
            Gson gson = new Gson();
            Map<Object, Object> map = gson.fromJson(idcard, HashMap.class);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping(value = "/dw")
    public Map<Object, Object> dw(@RequestParam("file") MultipartFile file) {
        try {
            //获取上传文件名
            String originalFilename = file.getOriginalFilename();
            File file1 = new File("C:\\image\\" + originalFilename);
            if (!file1.exists()) {
                file1.mkdirs();
                //保存文件
                file.transferTo(file1);
            }
            String animal = Animal.animal(file1.toString());
            Gson gson = new Gson();
            Map<Object, Object> map = gson.fromJson(animal, HashMap.class);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
