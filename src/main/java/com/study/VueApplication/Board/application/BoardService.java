package com.study.VueApplication.Board.application;

import com.study.VueApplication.Board.domain.Board;
import com.study.VueApplication.Board.domain.BoardSaveRequestDto;
import com.study.VueApplication.Board.infra.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 2. Application Layer (응용 계층) (Service)
 *
 * 비즈니스 로직을 정의하고 정상적으로 수행될 수 있도록 도메인 계층과 인프라스트럭쳐 계층을 연결해주는 역할을 하는 계층이다.
 * 이 계층은 많은 정보를 가지고 있지 않게 유지하는 것이 중요하며,
 * 실질적인 데이터의 상태 변화 등의 처리는 도메인 계층에서 진행할 수 있도록 위임하는 것이 중요하다.
 *
 * Application Layer에 포함하는 기능들
 * 1. 트랜잭션의 단위
 * 2. DTO 변환
 * 3. 엔티티 조회/저장
 * 단순하게 말하면 Entity를 찾고(Repository), 변경 내용을 저장하는 기능(Persistence)을 호출한다.
 * (구현은 Infra layer)
 * 4. 사용자 인증/인가
 * 사용자가 특정 URL에 대해 권한이 있는지 정도의 인가는 presentation layer에서 하지만,
 *  URL만으로 판단이 어렵거나, DB내의 데이터와 대조해봐야 알 수 있는 경우(데이터 존재 여부, 중복 여부 등)
 * 5. 파라미터 검증
 * presentation layer에서도 수행할 수 있지만 주로 요청 방식에 따라 달라지는 '형식'에 대한 검증을 하고,
 * application layer에서는 '논리적'인 오류를 검증한다.
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final JpaBoardRepository boardRepository;
    
    /**
     * 게시글 전체 조회
     */
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    /**
     * 게시글 단건 조회
     */
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    /**
     * 게시글 저장 (트랜잭션 처리)
     */
    @Transactional
    public Long save(Board board){
        return boardRepository.save(board).getId();
    }

}
