package jskang.springboot.starter.common.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ConverterUtilTest {

    @Test
    void jsonStrToTypeRef() throws IOException {
        String testJsonMap = "{ \"company\": \"wisenut\", \"team\": \"research n develop\" }";

        Map<String, Object> map = ConverterUtil.jsonStrToTypeRef(testJsonMap, new TypeReference<LinkedHashMap<String, Object>>() {});
        Map<String, String> okMap = new LinkedHashMap<>();
        okMap.put("company", "wisenut");
        okMap.put("team", "research n develop");

        assertThat(map).isEqualTo(okMap);
    }

    @Test
    void jsonStrToMap() throws IOException {
        String testJsonMap = "{ \"company\": \"wisenut\", \"team\": \"research n develop\" }";

        Map<String, Object> map = ConverterUtil.jsonStrToMap(testJsonMap);
        Map<String, String> okMap = new LinkedHashMap<>();
        okMap.put("company", "wisenut");
        okMap.put("team", "research n develop");

        assertThat(map).isEqualTo(okMap);
    }

    @Test
    void mapToJsonStr() throws IOException {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("company", "wisenut");
        map.put("team", "research n develop");

        String jsonStr = ConverterUtil.mapToJsonStr(map);
        assertThat(jsonStr).isEqualTo("{\"company\":\"wisenut\",\"team\":\"research n develop\"}");
    }

    @Test
    void jsonStrToList() throws IOException {
        String testJsonList = "[ \"ElasticSearch\", \"SearchFormular-1\", \"Lucene\"]";

        List<Object> list = ConverterUtil.jsonStrToList(testJsonList);
        List<String> okList = new LinkedList<>();
        okList.add("ElasticSearch");
        okList.add("SearchFormular-1");
        okList.add("Lucene");

        assertThat(list).isEqualTo(okList);
    }

    @Test
    void listToJsonStr() throws JsonProcessingException {
        List<String> list = new LinkedList<>();
        list.add("ElasticSearch");
        list.add("SearchFormular-1");
        list.add("Lucene");

        String jsonStr = ConverterUtil.listToJsonStr(list);
        assertThat(jsonStr).isEqualTo("[\"ElasticSearch\",\"SearchFormular-1\",\"Lucene\"]");
    }

    @Test
    void stringArrToJsonStr() throws JsonProcessingException {
        String[] list = new String[]{"ElasticSearch", "SearchFormular-1", "Lucene"};

        String jsonStr = ConverterUtil.stringArrToJsonStr(list);
        assertThat(jsonStr).isEqualTo("[\"ElasticSearch\",\"SearchFormular-1\",\"Lucene\"]");
    }
}