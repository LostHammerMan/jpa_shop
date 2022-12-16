package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // EnumType : ORDINAL - enum 에 열거되어 있는 요소 숫자로(기본, 중간에 다른 요소가
    private DeliveryStatus status; // 삽입되는 경우 순서가 밀릴 수 있는 문제 존재, String - 문자
     // 배송상태 , READY, COMP
}
