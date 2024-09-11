package org.example.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.entity.gateway.SprintGateway;
import org.example.entity.model.Sprint;
import org.example.infrastructure.dto.SprintRegistrationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class CreateSprintUseCaseTest {
    @Mock
    private SprintGateway sprintGateway;

    @InjectMocks
    private CreateSprintUseCase createSprintUseCase;

    @Test
     void testExecute() throws JsonProcessingException {

        String payload = """
                {
                    "title": "sprint 1",
                    "beginDate": "2024-08-28",
                    "endDate": "2024-09-05"
                }
                """ ;
       ObjectMapper mapper = new ObjectMapper();
       mapper.registerModule(new JavaTimeModule());
       mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
       SprintRegistrationDto sprintRegistrationDto = mapper.readValue(payload, SprintRegistrationDto.class);

        when(sprintGateway.create(any())).thenReturn(new Sprint(1L, "sprint 1",  LocalDate.of(2024, 9, 5), LocalDate.of(2024, 8, 28), null));

        // Call the execute method
        Sprint result = createSprintUseCase.execute(sprintRegistrationDto);

        // Add assertions here based on the expected behavior of the execute method
        assertEquals("sprint 1", result.getTitle());
        assertEquals(LocalDate.of(2024, 8, 28), result.getBeginDate());
        assertEquals(LocalDate.of(2024, 9, 5), result.getEndDate());
    }


}