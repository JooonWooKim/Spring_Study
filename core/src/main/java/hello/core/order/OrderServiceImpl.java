package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy){
                            //@Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy)
                            //DiscountPolicy rateDiscountPolicy(필드명을 빈 이름으로 변경)
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
//        this.discountPolicy = rateDiscountPolicy;(필드명을 빈 이름으로 변경)
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //할인 정책에 회원을 넘긴다, grade를 넘길까 아이디를 통째로 넘길까 고민이 필요하다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
        
    }
    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
