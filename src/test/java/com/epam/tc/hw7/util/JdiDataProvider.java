package com.epam.tc.hw7.util;

import com.epam.tc.hw7.entities.MetalAndColorEntity;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class JdiDataProvider {
    public static final String EXPECTED_USERNAME = "ROMAN IOVLEV";
    public static final String PATH = "src/test/resources/testdata/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "testDataSet")
    public static Object[][] metalsAndColorsDataSet() throws IOException {
        return parse(PATH);
    }

    public static Object[][] parse(String path) throws IOException {
        Gson gson = new Gson();
        Object[][] dataArray;
        Type type = new TypeToken<Map<String, MetalAndColorEntity>>() {}.getType();
        Map<String, MetalAndColorEntity> map = gson.fromJson(new JsonReader(new FileReader(path)), type);
        int i = 0;
        dataArray = new Object[map.size()][1];
        for (Map.Entry<String, MetalAndColorEntity> entry : map.entrySet()) {
            dataArray[i][0] = entry.getValue();
            i++;
        }
        return dataArray;
    }
}
