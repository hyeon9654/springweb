package example.day06;

public class ReplyEntity {
    
}


/*
    - 영속성이란? 자바는 영구저장이 불가능하므로(휘발성) DB 매핑/연결하여 영속성(영구저장) 표현
        Entity entity = new entoty();   // 객체
    @ManyToOne( cascade = 영속성제약조건, fetch = 불러오기시기 )
        CascadeType.REMOVE : 만일 부모 엔티티가 삭제되면 자식 엔티티같이 삭제된다.
        CascadeType.MERGE : 만일 부모 엔티티가 수정되면 자식 엔티티 수정 같이 반영된다.
        CascadeType.DETCH : 만일 부모 엔티티가 영속(연결)해제하면 자식 엔티티 같이 해제한다.
        CascadeType.REFESH : 만약 부모 엔티티가 재호출(생신)되면 자식 엔티티 같이 갱신한다.
        CascadeType.PERSIST : 만약 부모 엔티티가 저장하면 자식 엔티티 같이 저장된다.
        CascadeType.ALL 위 속성들을 모두 사용

*/