package org.example.domain.wiseSaying.repository;

import org.example.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//WiseSayingRepository를 상속하고, WiseSayingrepository에 대한 내부 로직 수행
public class WiseSayingMemoryRepository implements WiseSayingRepository {
    //WiseSaying엔티티를 List형태로 받는 wiseSayings
    private final List<WiseSaying> wiseSayings;
    //샘플데이터 추가에서 ID값을 관리하기 위한 lastId
    private int lastId;

    public WiseSayingMemoryRepository() {
        //각 객체의 생성자 호출
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public void add(WiseSaying wiseSaying) {
        //샘플데이터가 추가될 때마닫 ID값이 1증가
        wiseSaying.setId(++lastId);
        wiseSayings.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int id) {
        return wiseSayings.removeIf(e -> e.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void modify(WiseSaying wiseSaying) {
        // 현재는 메모리에 저장되기 때문에 여기서 딱히 할일이 없다.
    }
}
