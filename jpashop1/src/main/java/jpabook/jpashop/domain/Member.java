package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 연관관계 거울, orders table의 member와 매핑됨
    @OneToMany(mappedBy = "member") // 하나의 회원이 여러개의 상품 주문 -> 1 : N 관계
    private List<Order> orders = new ArrayList<>();


}
