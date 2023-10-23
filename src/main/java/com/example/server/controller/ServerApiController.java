package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

  // https://openapi.naver.com/v1/search/local.json
  // ?query=%EC%A3%BC%EC%8B%9D
  // &display=10
  // &start=1
  // &sort=random
  @GetMapping("/naver")
  public String naver() {
    URI uri = UriComponentsBuilder
      .fromUriString("https://openapi.naver.com")
      .path("/v1/search/local.json")
      .queryParam("query", "")
      .queryParam("display", 10)
      .queryParam("start",1)
      .queryParam("sort", "random")
      .encode()
      .build()
      .toUri();

    RestTemplate restTemplate = new RestTemplate();




  }



  @GetMapping("/hello")
  public User hello(@RequestParam String name, @RequestParam int age) {
    User user = new User();
    user.setName(name);
    user.setAge(age);
    return user;
  }

//  // @RequestBody User user인 version
//  @PostMapping("/user/{userId}/name/{userName}")
//  public User post(@RequestBody User user,
//                   @PathVariable int userId,
//                   @PathVariable String userName,
//                   @RequestHeader("x-authorization") String authorization,
//                   @RequestHeader("custom-header") String customHeader) {

//    log.info("userId : {}, userName: {}", userId, userName);
//    log.info("client req : {}", user);
//    log.info("authorization : {}, custom-header: {}", authorization, customHeader);
//
//    return user;
//  }

  // @RequestBody가 Req<User> 인 version
  @PostMapping("/user/{userId}/name/{userName}")
  public Req<User> post(
                        //HttpEntity<String> entity,
                        @RequestBody Req<User> user,
                        @PathVariable int userId,
                        @PathVariable String userName,
                        @RequestHeader("x-authorization") String authorization,
                        @RequestHeader("custom-header") String customHeader) {

    // log.info("req : {}", entity.getBody());
    log.info("userId : {}, userName: {}", userId, userName);
    log.info("client req : {}", user);
    log.info("authorization : {}, custom-header: {}", authorization, customHeader);

    Req<User> response = new Req<>();
    response.setHeader(
      new Req.Header()
    );

    response.setBody(
        user.getBody()
    );

    return response;
  }



}
