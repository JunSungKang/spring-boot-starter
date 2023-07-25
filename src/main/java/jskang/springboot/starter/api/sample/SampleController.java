package jskang.springboot.starter.api.sample;

import java.util.List;
import java.util.Map;
import jskang.springboot.starter.common.api.Responser;
import jskang.springboot.starter.common.code.DescriptionCode;
import jskang.springboot.starter.common.code.ResponseCode;
import jskang.springboot.starter.common.code.formatter.CodeFormatter;
import jskang.springboot.starter.common.code.LogCode;
import jskang.springboot.starter.config.i18n.LocaleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v0.1/sample")
public class SampleController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    SampleServiceImpl sampleService;

    @GetMapping(value = "data")
    public ResponseEntity read(@RequestParam(required = false) String lang) {
        log.info(CodeFormatter.create(LogCode.L000001));
        List<Map<String, Object>> list = this.sampleService.readData();
        return Responser.SUCCESS_200(ResponseCode.R000012, list, LocaleType.getLocalType(lang));
    }

    @PostMapping(value = "data")
    public ResponseEntity create(@RequestBody Map<String, String> data, @RequestParam(required = false) String lang) {
        log.info(CodeFormatter.create(LogCode.L000001));

        List<Map<String, Object>> list = this.sampleService.createData(
            data.get("name"), data.get("age"), data.get("company")
        );
        return Responser.SUCCESS_200(ResponseCode.R000012, list, LocaleType.getLocalType(lang));
    }

    @PutMapping(value = "data")
    public ResponseEntity update(@RequestBody Map<String, String> data, @RequestParam(required = false) String lang) {
        log.info(CodeFormatter.create(LogCode.L000001));

        List<Map<String, Object>> list = this.sampleService.updateData(
            data.get("name"), data.get("age"), data.get("company")
        );
        return Responser.SUCCESS_200(ResponseCode.R000012, list, LocaleType.getLocalType(lang));
    }

    @DeleteMapping(value = "data")
    public ResponseEntity delete(@RequestBody Map<String, String> data, @PathVariable(required = false) String lang) {
        List<Map<String, Object>> list = this.sampleService.deleteData(data.get("name"));
        return Responser.SUCCESS_200(ResponseCode.R000012, list, DescriptionCode.D000003,
            LocaleType.getLocalType(lang));
    }
}
