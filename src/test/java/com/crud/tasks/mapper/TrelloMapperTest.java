package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards(){
        //Given
        List<TrelloListDto> testTrelloListDtos1 = new ArrayList<>();
        List<TrelloListDto> testTrelloListDtos2 = new ArrayList<>();
        TrelloListDto testTrelloListDto1 = new TrelloListDto("1", "testlist1", false);
        TrelloListDto testTrelloListDto2 = new TrelloListDto("2", "testlist2", true);
        TrelloListDto testTrelloListDto3 = new TrelloListDto("3", "testlist3", true);
        TrelloListDto testTrelloListDto4 = new TrelloListDto("4", "testlist4", false);
        testTrelloListDtos1.add(testTrelloListDto1);
        testTrelloListDtos1.add(testTrelloListDto2);
        testTrelloListDtos2.add(testTrelloListDto3);
        testTrelloListDtos2.add(testTrelloListDto4);

        List<TrelloBoardDto> testTrelloBoardDtoList = new ArrayList<>();
        TrelloBoardDto testTrelloBoardDto1 = new TrelloBoardDto("1", "test1", testTrelloListDtos1);
        TrelloBoardDto testTrelloBoardDto2 = new TrelloBoardDto("1", "test2", testTrelloListDtos2);
        testTrelloBoardDtoList.add(testTrelloBoardDto1);
        testTrelloBoardDtoList.add(testTrelloBoardDto2);

        List<TrelloList> testTrelloLists1 = new ArrayList<>();
        List<TrelloList> testTrelloLists2 = new ArrayList<>();
        TrelloList testTrelloList1 = new TrelloList("1", "testlist1", false);
        TrelloList testTrelloList2 = new TrelloList("2", "testlist2", true);
        TrelloList testTrelloList3 = new TrelloList("3", "testlist3", true);
        TrelloList testTrelloList4 = new TrelloList("4", "testlist4", false);
        testTrelloLists1.add(testTrelloList1);
        testTrelloLists1.add(testTrelloList2);
        testTrelloLists2.add(testTrelloList3);
        testTrelloLists2.add(testTrelloList4);

        List<TrelloBoard> expectedResult = new ArrayList<>();
        TrelloBoard testTrelloBoard1 = new TrelloBoard("1", "test1", testTrelloLists1);
        TrelloBoard testTrelloBoard2 = new TrelloBoard("1", "test2", testTrelloLists2);
        expectedResult.add(testTrelloBoard1);
        expectedResult.add(testTrelloBoard2);
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(testTrelloBoardDtoList);
        //Then
        for(int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i).getId(), result.get(i).getId());
            assertEquals(expectedResult.get(i).getName(), result.get(i).getName());
            for(int j = 0; j < expectedResult.get(i).getLists().size(); j++) {
                assertEquals(expectedResult.get(i).getLists().get(j).getId(), result.get(i).getLists().get(j).getId());
                assertEquals(expectedResult.get(i).getLists().get(j).getName(), result.get(i).getLists().get(j).getName());
                assertEquals(expectedResult.get(i).getLists().get(j).isClosed(), result.get(i).getLists().get(j).isClosed());
            }
        }
    }

    @Test
    void testMapToBoardsDto(){
        //Given
        List<TrelloList> testTrelloLists1 = new ArrayList<>();
        List<TrelloList> testTrelloLists2 = new ArrayList<>();
        TrelloList testTrelloList1 = new TrelloList("1", "testlist1", false);
        TrelloList testTrelloList2 = new TrelloList("2", "testlist2", true);
        TrelloList testTrelloList3 = new TrelloList("3", "testlist3", true);
        TrelloList testTrelloList4 = new TrelloList("4", "testlist4", false);
        testTrelloLists1.add(testTrelloList1);
        testTrelloLists1.add(testTrelloList2);
        testTrelloLists2.add(testTrelloList3);
        testTrelloLists2.add(testTrelloList4);

        List<TrelloBoard> testTrelloBoardList = new ArrayList<>();
        TrelloBoard testTrelloBoard1 = new TrelloBoard("1", "test1", testTrelloLists1);
        TrelloBoard testTrelloBoard2 = new TrelloBoard("1", "test2", testTrelloLists2);
        testTrelloBoardList.add(testTrelloBoard1);
        testTrelloBoardList.add(testTrelloBoard2);

        List<TrelloListDto> testTrelloListDtos1 = new ArrayList<>();
        List<TrelloListDto> testTrelloListDtos2 = new ArrayList<>();
        TrelloListDto testTrelloListDto1 = new TrelloListDto("1", "testlist1", false);
        TrelloListDto testTrelloListDto2 = new TrelloListDto("2", "testlist2", true);
        TrelloListDto testTrelloListDto3 = new TrelloListDto("3", "testlist3", true);
        TrelloListDto testTrelloListDto4 = new TrelloListDto("4", "testlist4", false);
        testTrelloListDtos1.add(testTrelloListDto1);
        testTrelloListDtos1.add(testTrelloListDto2);
        testTrelloListDtos2.add(testTrelloListDto3);
        testTrelloListDtos2.add(testTrelloListDto4);

        List<TrelloBoardDto> expectedResult = new ArrayList<>();
        TrelloBoardDto testTrelloBoardDto1 = new TrelloBoardDto("1", "test1", testTrelloListDtos1);
        TrelloBoardDto testTrelloBoardDto2 = new TrelloBoardDto("1", "test2", testTrelloListDtos2);
        expectedResult.add(testTrelloBoardDto1);
        expectedResult.add(testTrelloBoardDto2);
        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(testTrelloBoardList);
        //Then
        for(int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i).getId(), result.get(i).getId());
            assertEquals(expectedResult.get(i).getName(), result.get(i).getName());
            for(int j = 0; j < expectedResult.get(i).getLists().size(); j++) {
                assertEquals(expectedResult.get(i).getLists().get(j).getId(), result.get(i).getLists().get(j).getId());
                assertEquals(expectedResult.get(i).getLists().get(j).getName(), result.get(i).getLists().get(j).getName());
                assertEquals(expectedResult.get(i).getLists().get(j).isClosed(), result.get(i).getLists().get(j).isClosed());
            }
        }
    }
    @Test
    void testMapToList(){
        //Given
        List<TrelloListDto> testTrelloListDtos = new ArrayList<>();
        TrelloListDto testTrelloListDto1 = new TrelloListDto("1", "testlist1", false);
        TrelloListDto testTrelloListDto2 = new TrelloListDto("2", "testlist2", true);
        testTrelloListDtos.add(testTrelloListDto1);
        testTrelloListDtos.add(testTrelloListDto2);

        List<TrelloList> expectedResult = new ArrayList<>();
        TrelloList testTrelloList1 = new TrelloList("1", "testlist1", false);
        TrelloList testTrelloList2 = new TrelloList("2", "testlist2", true);
        expectedResult.add(testTrelloList1);
        expectedResult.add(testTrelloList2);
        //When
        List<TrelloList> result = trelloMapper.mapToList(testTrelloListDtos);
        //Then
        for(int i = 0; i < expectedResult.size(); i++){
            assertEquals(expectedResult.get(i).getId(), result.get(i).getId());
            assertEquals(expectedResult.get(i).getName(), result.get(i).getName());
            assertEquals(expectedResult.get(i).isClosed(), result.get(i).isClosed());
        }
    }
    @Test
    void testMapToListDto(){
        //Given
        List<TrelloList> testTrelloLists = new ArrayList<>();
        TrelloList testTrelloList1 = new TrelloList("1", "testlist1", false);
        TrelloList testTrelloList2 = new TrelloList("2", "testlist2", true);
        testTrelloLists.add(testTrelloList1);
        testTrelloLists.add(testTrelloList2);

        List<TrelloListDto> expectedResult = new ArrayList<>();
        TrelloListDto testTrelloListDto1 = new TrelloListDto("1", "testlist1", false);
        TrelloListDto testTrelloListDto2 = new TrelloListDto("2", "testlist2", true);
        expectedResult.add(testTrelloListDto1);
        expectedResult.add(testTrelloListDto2);
        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(testTrelloLists);
        //Then
        for(int i = 0; i < expectedResult.size(); i++){
            assertEquals(expectedResult.get(i).getId(), result.get(i).getId());
            assertEquals(expectedResult.get(i).getName(), result.get(i).getName());
            assertEquals(expectedResult.get(i).isClosed(), result.get(i).isClosed());
        }
    }
    @Test
    void testMapToCard(){
        //Given
        TrelloCardDto testTrelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        TrelloCard expectedResult = new TrelloCard("test", "test", "test", "test");
        //When
        TrelloCard result = trelloMapper.mapToCard(testTrelloCardDto);
        //Then
        assertEquals(expectedResult.getName(), result.getName());
        assertEquals(expectedResult.getDescription(), result.getDescription());
        assertEquals(expectedResult.getPos(), result.getPos());
        assertEquals(expectedResult.getListId(), result.getListId());
    }
    @Test
    void testMapToCardDto(){
        //Given
        TrelloCard testTrelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto expectedResult = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(testTrelloCard);
        //Then
        assertEquals(expectedResult.getName(), result.getName());
        assertEquals(expectedResult.getDescription(), result.getDescription());
        assertEquals(expectedResult.getPos(), result.getPos());
        assertEquals(expectedResult.getListId(), result.getListId());
    }
}
