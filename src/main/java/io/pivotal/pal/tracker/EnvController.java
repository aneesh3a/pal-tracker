package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    String cfInstancePort;
    String cfInstanceIndex;
    String cfInstanceMemoryLimit;
    String cfInstanceAddress;


    public EnvController(@Value("${cf.instance.port:NOT SET}") String cfInstancePort,
                         @Value("${cf.instance.memory.limit:NOT SET}") String cfInstanceMemoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddress

                         ) {
this.cfInstancePort=cfInstancePort;
        this.cfInstanceIndex=cfInstanceIndex;
        this.cfInstanceMemoryLimit=cfInstanceMemoryLimit;
        this.cfInstanceAddress=cfInstanceAddress;

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("PORT",cfInstancePort);
        stringMap.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        stringMap.put("MEMORY_LIMIT",cfInstanceMemoryLimit);
        stringMap.put("CF_INSTANCE_ADDR",cfInstanceAddress);
        return stringMap;
    }
}