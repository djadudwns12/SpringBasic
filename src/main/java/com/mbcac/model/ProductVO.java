package com.mbcac.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor (access = AccessLevel.PROTECTED) // 기본생성자를 protected 하도록 생성(프로그래머가 임의로 기본생성자를 호출하지 못하도록)
// 리플렉션 우리는 호출 x / 스프링은 호출 가능 (-> 메모리 누수가능성을 줄이기 위하여사용)
@AllArgsConstructor
@Builder
@ToString
public class ProductVO 
{
	private String productNo; 
	private String productName; 
	private int qty; 
	private int price;
	private String productNickName;
}
