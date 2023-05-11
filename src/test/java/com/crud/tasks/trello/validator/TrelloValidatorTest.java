package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    void shouldReturnEmptyList(){
        //Given
        List<TrelloBoard> trelloBoardList = List.of(new TrelloBoard("1", "test", new ArrayList<TrelloList>()));
        //When
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoardList);
        //Then
        assertEquals(1, trelloBoardList.size());
        assertEquals(0, result.size());
    }

}