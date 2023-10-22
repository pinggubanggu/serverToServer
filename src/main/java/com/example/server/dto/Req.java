package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req<T> {

//  아래와 같은 JSON 구조를 주고 받고 싶어서 만든 Req 클래스이다.
//  {
//    "header" : {
//      "response_code" : ""
//    },
//
//    "body" : {
//        "name" : "spring boot",
//        "age" : 1024
//    }
//  }
  private Header header;
  private T body;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Header {
    private String responseCode;
  }

}
