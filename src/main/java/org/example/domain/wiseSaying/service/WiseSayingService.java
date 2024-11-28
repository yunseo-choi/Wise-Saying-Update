package org.example.domain.wiseSaying.service;

import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.domain.wiseSaying.repository.WiseSayingMemoryRepository;
import org.example.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingMemoryRepository();
    }

    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);

        wiseSayingRepository.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public boolean removeById(int id) {
        return wiseSayingRepository.removeById(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.modify(wiseSaying);
    }
}
