package com.example.jpaPractice003.domain.repository;

import com.example.jpaPractice003.domain.dto.BoardDTO;
import com.example.jpaPractice003.domain.dto.BoardSearchSort;
import com.example.jpaPractice003.domain.dto.PageRequestDTO;
import com.example.jpaPractice003.domain.dto.QBoardDTO;
import com.example.jpaPractice003.domain.entity.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.jpaPractice003.domain.entity.QBoard.board;

@RequiredArgsConstructor
@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<BoardDTO> findByPageRequest(PageRequestDTO pageRequestDTO) {

        PageRequest pageable = PageRequest.of(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        List<BoardDTO> fetch = jpaQueryFactory.select(new QBoardDTO(board.id, board.title, board.content, board.writer, board.regDate, board.modDate))
                                              .from(board)
                                              .where(createPageSearchOption(pageRequestDTO.getType(), pageRequestDTO.getKeyword()))
                                              .limit(pageable.getPageSize())
                                              .offset(pageable.getOffset())
                                              .orderBy(createPageSortOption(pageRequestDTO.getSort()))
                                              .fetch();

        JPAQuery<Long> countQuery = jpaQueryFactory.select(board.count())
                                              .from(board)
                                              .where(createPageSearchOption(pageRequestDTO.getType(), pageRequestDTO.getKeyword()));


        return PageableExecutionUtils.getPage(fetch,pageable,()->countQuery.fetchOne());
    }

    public BooleanBuilder createPageSearchOption(String type,String keyword){
        BooleanBuilder result = new BooleanBuilder();
        if(!StringUtils.isNullOrEmpty(type) && !StringUtils.isNullOrEmpty(keyword)){
            if(type.contains("t")){
               result.or(board.title.contains(keyword));
            }
            if(type.contains("w")){
                result.or(board.writer.contains(keyword));
            }
            if(type.contains("c")){
                result.or(board.content.contains(keyword));
            }
        }
            return result;
    }

    public OrderSpecifier[] createPageSortOption(BoardSearchSort sort){
        List<OrderSpecifier> result = new ArrayList<>();

        if(sort==BoardSearchSort.TITLE_ASC){
            result.add(new OrderSpecifier<>(Order.ASC, board.title));
        } else if (sort==BoardSearchSort.TITLE_DESC) {
            result.add(new OrderSpecifier<>(Order.DESC, board.title));
        } else if (sort==BoardSearchSort.CONTENT_ASC) {
            result.add(new OrderSpecifier<>(Order.ASC, board.content));
        } else if (sort==BoardSearchSort.CONTENT_DESC) {
            result.add(new OrderSpecifier<>(Order.DESC, board.content));
        } else if (sort==BoardSearchSort.WRITER_ASC) {
            result.add(new OrderSpecifier<>(Order.ASC, board.writer));
        } else if (sort==BoardSearchSort.WRITER_DESC) {
            result.add(new OrderSpecifier<>(Order.DESC, board.writer));
        }  else if (sort==BoardSearchSort.CREATE_DATE_ASC) {
            result.add(new OrderSpecifier<>(Order.ASC, board.regDate));
        } else if (sort==BoardSearchSort.CREATE_DATE_DESC) {
            result.add(new OrderSpecifier<>(Order.DESC, board.regDate));
        }
        return result.toArray(new OrderSpecifier[result.size()]);

    }
}
