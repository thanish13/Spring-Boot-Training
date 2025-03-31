package org.example.api;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/example")
public interface Example{

    @GetMapping("/{name}")
    String getExample(@PathVariable("name") String name);



}
