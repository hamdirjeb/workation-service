import com.example.demo.dto.WorkationDto;
import com.example.demo.model.Workation;
import com.example.demo.repository.WorkationRepository;
import com.example.demo.service.WorkationMapper;
import com.example.demo.service.WorkationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WorkationServiceTest {

    private WorkationRepository repository;
    private WorkationMapper mapper;
    private WorkationService service;

    @BeforeEach
    void setUp() {
        repository = mock(WorkationRepository.class);
        mapper = mock(WorkationMapper.class);
        service = new WorkationService(repository, mapper);
    }

    @Test
    void save_ShouldReturnMappedDto() {
        WorkationDto dto = new WorkationDto("1", "Bali");
        Workation entity = new Workation("1", "Bali");

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.saveAndFlush(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(dto);

        WorkationDto result = service.save(dto);

        assertEquals(dto, result);
        verify(mapper).toEntity(dto);
        verify(repository).saveAndFlush(entity);
        verify(mapper).toDto(entity);
    }

    @Test
    void getAll_ShouldReturnListOfDtos() {
        Workation entity1 = new Workation("1", "Bali");
        Workation entity2 = new Workation("2", "Lisbon");

        WorkationDto dto1 = new WorkationDto("1", "Bali");
        WorkationDto dto2 = new WorkationDto("2", "Lisbon");

        when(repository.findAll()).thenReturn(Arrays.asList(entity1, entity2));
        when(mapper.toDto(entity1)).thenReturn(dto1);
        when(mapper.toDto(entity2)).thenReturn(dto2);

        List<WorkationDto> result = service.getAll();

        assertEquals(2, result.size());
        assertEquals(dto1, result.get(0));
        assertEquals(dto2, result.get(1));
    }

    @Test
    void getAll_ShouldReturnEmptyList_WhenNoEntitiesFound() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<WorkationDto> result = service.getAll();

        assertEquals(0, result.size());
        verify(mapper, never()).toDto(ArgumentMatchers.any());
    }
}