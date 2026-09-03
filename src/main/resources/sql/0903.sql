# day05 / TestEntity sample , SQL 카멜 표기법 대신에 _(언더바)

INSERT INTO test( name, descri, price, create_date, update_date )
    VALUE( '코카콜카' , '맛있는 탄산음료1' , 1000, now(), now() ),
    ( '사이다' , '맛있는 탄산음료2' , 1500, now(), now() ),
    ( '환타' , '맛있는 탄산음료3' , 700, now(), now() )