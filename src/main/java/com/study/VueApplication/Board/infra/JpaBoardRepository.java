package com.study.VueApplication.Board.infra;

import com.study.VueApplication.Board.domain.Board;
import com.study.VueApplication.Board.domain.BoardSaveRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 4. Infrastructure Layer(인프라 계층) (Repository)
 *
 * 외부와의 통신(DB, 메시징 시스템 등)을 담당하는 계층이다.
 * 해당 계층에서 얻어온 정보를 응용 계층 또는 도메인 계층에 전달하는 것이 주 역할이다.
 */
@Repository
public interface JpaBoardRepository extends JpaRepository<Board, Long> {

    public List<Board> findAll();
    public Long save(BoardSaveRequestDto requestDto);

}
