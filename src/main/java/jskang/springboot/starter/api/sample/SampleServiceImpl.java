package jskang.springboot.starter.api.sample;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jskang.springboot.starter.common.code.formatter.CodeFormatter;
import jskang.springboot.starter.common.utils.ValidateUtil;
import jskang.springboot.starter.common.code.LogCode;
import jskang.springboot.starter.common.exceptions.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl {

    Logger log = LoggerFactory.getLogger(getClass());

    private static final List<Map<String, Object>> list = new LinkedList<>();

    public List<Map<String, Object>> createData(String name, String age, String company) {
        if (ValidateUtil.isBlank(name, age, company)) {
            throw new ValidationException(CodeFormatter.create(LogCode.L000008, name+ "," +age+ "," +company));
        }

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        map.put("company", company);
        log.debug(CodeFormatter.create(LogCode.L000000, map));

        list.add(map);
        return list;
    }

    public List<Map<String, Object>> readData() {
        return list;
    }

    public List<Map<String, Object>> updateData(String name, String age, String company) {
        if (ValidateUtil.isBlank(name, age, company)) {
            throw new ValidationException(CodeFormatter.create(LogCode.L000008, name+ "," +age+ "," +company));
        }

        int index = indexOf(name);
        if (index < 0) {
            throw new IndexOutOfBoundsException(CodeFormatter.create(LogCode.L000009));
        }

        Map<String, Object> map = list.get(index);
        map.put("age", age);
        map.put("company", company);
        log.debug(CodeFormatter.create(LogCode.L000000, map));

        list.set(index, map);
        return list;
    }

    public List<Map<String, Object>> deleteData(String name) {
        int index = indexOf(name);
        if (index < 0) {
            throw new IndexOutOfBoundsException(CodeFormatter.create(LogCode.L000009));
        }

        list.remove(index);
        return list;
    }

    private int indexOf(String name) {
        if (ValidateUtil.isBlank(name)) {
            throw new ValidationException(CodeFormatter.create(LogCode.L000008, name));
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("name").equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
