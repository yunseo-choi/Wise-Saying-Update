package org.example.domain.wiseSaying.repository;

import org.example.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

//WiseSayingRepository를 상속받는 각각의 클래스들이 있음
// 지금은 Memory에 관련된 WiseSayingRepository가 있음
// 무기 안에 칼, 활, 창 등이 있는 것처럼 다중 상속됨.
public interface WiseSayingRepository {
    void add(WiseSaying wiseSaying);

    List<WiseSaying> findAll();

    boolean removeById(int id);

    Optional<WiseSaying> findById(int id);

    void modify(WiseSaying wiseSaying);
}
