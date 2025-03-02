package org.example.granjadao.CONTROLLER;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/granja")
@CacheConfig(cacheNames = "granja")
public class GranjaController {


}
